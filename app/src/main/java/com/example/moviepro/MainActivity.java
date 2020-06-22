package com.example.moviepro;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.TableLayout;

import tv.danmaku.ijk.media.example.application.Settings;
import tv.danmaku.ijk.media.example.widget.media.AndroidMediaController;
import tv.danmaku.ijk.media.example.widget.media.IjkVideoView;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IjkMediaPlayer.loadLibrariesOnce(null);
        IjkMediaPlayer.native_profileBegin("libijkplayer.so");

        Settings mSettings = new Settings(this);
        String mVideoPath = "http://ivi.bupt.edu.cn/hls/cctv1hd.m3u8";

        AndroidMediaController mMediaController = new AndroidMediaController(this, false);

        IjkVideoView mVideoView = (IjkVideoView) findViewById(R.id.videoView);
        TableLayout mHudView = (TableLayout) findViewById(R.id.hud_view);
        mVideoView.setMediaController(mMediaController);
        mVideoView.setHudView(mHudView);

        mVideoView.setVideoURI(Uri.parse(mVideoPath));
        mVideoView.start();
    }
}
