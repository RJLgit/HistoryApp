package com.example.android.historyapp.ui;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
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
import java.io.IOException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SitesDetailsFragment extends Fragment implements MediaController.MediaPlayerControl, MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener {
    //PlayerControlView mPlayerView;
    MediaPlayer mediaPlayer;
    MyMediaController mediaController;
    private static final String TAG = "SitesDetailsFragment";
    public static final String ARG_ITEM_ID = "Key for args";
    TextView textView;

    private Handler handler = new Handler();


    //Empty constructor
    public SitesDetailsFragment() {

    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_sites_details, container, false);
        textView = rootView.findViewById(R.id.site_name_text_view);
        Bundle bundle = getArguments();
        if (bundle != null && bundle.containsKey(ARG_ITEM_ID)) {
            String title = bundle.getString(ARG_ITEM_ID);
            textView.setText("");
            textView.setText(title);
        }

        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
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
            Log.d(TAG, "onCreateView: preparing");
            mediaPlayer.prepareAsync();
            mediaPlayer.start();

        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView: destorying");
        if (mediaPlayer != null) {
            mediaPlayer.pause();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
        if (mediaPlayer != null) {
            mediaPlayer.pause();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: stopping");
        if (mediaPlayer != null) {
            mediaPlayer.pause();
            mediaPlayer.release();
            mediaPlayer = null;
        }
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
        if (mediaPlayer != null ) {
            return mediaPlayer.getDuration();
        } else {
            return 0;
        }
    }

    @Override
    public int getCurrentPosition() {
        if (mediaPlayer != null) {
            return mediaPlayer.getCurrentPosition();
        } else {
            return 0;
        }
    }

    @Override
    public void seekTo(int i) {
        mediaPlayer.seekTo(i);
    }

    @Override
    public boolean isPlaying() {
        if (mediaPlayer != null) {
            return mediaPlayer.isPlaying();
        } else {
            return false;
        }

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
