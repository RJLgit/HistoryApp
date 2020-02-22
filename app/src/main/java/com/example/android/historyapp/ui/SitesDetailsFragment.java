package com.example.android.historyapp.ui;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.TextView;

import com.example.android.historyapp.R;
import com.example.android.historyapp.data.MyMediaController;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.ui.PlayerControlView;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ScheduledExecutorService;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;

public class SitesDetailsFragment extends Fragment implements MediaController.MediaPlayerControl, MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener {
    //PlayerControlView mPlayerView;
    MediaPlayer mediaPlayer;
    MyMediaController mediaController;
    private static final String TAG = "SitesDetailsFragment";

    private Handler handler = new Handler();

    @Override
    public void onPrepared(MediaPlayer mediaPlayer) {
        mediaController.setMediaPlayer(this);
        mediaController.setAnchorView(getActivity().findViewById(R.id.my_media_controller));

        handler.post(new Runnable() {
            public void run() {
                mediaController.setEnabled(true);
                mediaController.show(0);

            }
        });
    }



    @Override
    public boolean onError(MediaPlayer mediaPlayer, int i, int i1) {
        return false;
    }

    public SitesDetailsFragment() {

    }

    @Override
    public void start() {
        mediaPlayer.start();
    }

    @Override
    public void pause() {
        mediaPlayer.pause();
    }

    @Override
    public int getDuration() {
        return mediaPlayer.getDuration();
    }

    @Override
    public int getCurrentPosition() {
        return mediaPlayer.getCurrentPosition();
    }

    @Override
    public void seekTo(int i) {
        mediaPlayer.seekTo(i);
    }

    @Override
    public boolean isPlaying() {
        return mediaPlayer.isPlaying();
    }

    @Override
    public int getBufferPercentage() {
        return 0;
    }

    @Override
    public boolean canPause() {
        return true;
    }

    @Override
    public boolean canSeekBackward() {
        return true;
    }

    @Override
    public boolean canSeekForward() {
        return true;
    }

    @Override
    public int getAudioSessionId() {
        return 0;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_sites_details, container, false);
        //mediaController = rootView.findViewById(R.id.my_media_controller);
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setOnPreparedListener(this);
        AssetFileDescriptor afd = getContext().getResources().openRawResourceFd(R.raw.canon_in_d);
        if (afd != null) {

            try {
                mediaPlayer.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
                afd.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        mediaController = new MyMediaController(getActivity());
        Log.d(TAG, "onCreateView: " + mediaPlayer);
        //mediaPlayer = MediaPlayer.create(getActivity(), R.raw.canon_in_d);
        if (mediaPlayer != null) {
            mediaPlayer.prepareAsync();
            mediaPlayer.start();

        }

      /*  mPlayerView = rootView.findViewById(R.id.my_exoplayer);

        SimpleExoPlayer player = new SimpleExoPlayer.Builder(getActivity()).build();
        mPlayerView.setPlayer(player);
        //C:\Users\rICHAR\Ucfa\HistoryApp\app\src\main\res\raw\canon_in_d.mp3
        Uri uri = Uri.parse("android.resource://" + getActivity().getPackageName() + R.raw.canon_in_d);
        player.prepare(createMediaSource(uri));*/

        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();
        mediaPlayer.release();
        mediaPlayer = null;
    }



    /*  private MediaSource createMediaSource(Uri uri) {
        String userAgent = Util.getUserAgent(getActivity(), "HistoryApp");
        MediaSource mediaSource = new ExtractorMediaSource(uri, new DefaultDataSourceFactory(getActivity(), userAgent), new DefaultExtractorsFactory(), null, null);
        return mediaSource;
    }*/
}
