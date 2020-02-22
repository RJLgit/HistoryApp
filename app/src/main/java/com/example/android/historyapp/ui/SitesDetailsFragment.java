package com.example.android.historyapp.ui;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import com.example.android.historyapp.R;
import com.example.android.historyapp.data.MyMediaController;
import java.io.IOException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SitesDetailsFragment extends Fragment implements MediaController.MediaPlayerControl, MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener {
    //PlayerControlView mPlayerView;
    MediaPlayer mediaPlayer;
    MyMediaController mediaController;
    private static final String TAG = "SitesDetailsFragment";

    private Handler handler = new Handler();


    //Empty constructor
    public SitesDetailsFragment() {

    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_sites_details, container, false);
        //Create Media player
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setOnPreparedListener(this);
        //Create file from resources - will change to get this from storage in the end
        AssetFileDescriptor afd = getContext().getResources().openRawResourceFd(R.raw.canon_in_d);
        if (afd != null) {
            try {
                mediaPlayer.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
                afd.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        //Create Media controller
        mediaController = new MyMediaController(getActivity());
       //Off the main thread prepare the media player
        if (mediaPlayer != null) {
            mediaPlayer.prepareAsync();
            mediaPlayer.start();

        }
        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();
        mediaPlayer.release();
        mediaPlayer = null;
    }

   /* Media Player Controller methods for the interface*/
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

    //Called by prepare()
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


    //Error listener method
    @Override
    public boolean onError(MediaPlayer mediaPlayer, int i, int i1) {
        return false;
    }

}
