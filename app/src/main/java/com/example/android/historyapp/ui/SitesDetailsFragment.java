package com.example.android.historyapp.ui;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.historyapp.R;
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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;

public class SitesDetailsFragment extends Fragment {
    //PlayerControlView mPlayerView;

    public SitesDetailsFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_sites_details, container, false);
      /*  mPlayerView = rootView.findViewById(R.id.my_exoplayer);

        SimpleExoPlayer player = new SimpleExoPlayer.Builder(getActivity()).build();
        mPlayerView.setPlayer(player);
        //C:\Users\rICHAR\Ucfa\HistoryApp\app\src\main\res\raw\canon_in_d.mp3
        Uri uri = Uri.parse("android.resource://" + getActivity().getPackageName() + R.raw.canon_in_d);
        player.prepare(createMediaSource(uri));*/

        return rootView;
    }



  /*  private MediaSource createMediaSource(Uri uri) {
        String userAgent = Util.getUserAgent(getActivity(), "HistoryApp");
        MediaSource mediaSource = new ExtractorMediaSource(uri, new DefaultDataSourceFactory(getActivity(), userAgent), new DefaultExtractorsFactory(), null, null);
        return mediaSource;
    }*/
}
