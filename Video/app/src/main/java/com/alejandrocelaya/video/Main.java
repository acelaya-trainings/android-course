package com.alejandrocelaya.video;

import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.MediaController;
import android.widget.VideoView;


public class Main extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VideoView v = (VideoView) findViewById(R.id.videoView);
//        v.setVideoPath("/sdcard/video.mp4");
        v.setVideoURI(Uri.parse(String.format(
                "android.resource://%s/%s",
                getPackageName(),
                R.raw.video
        )));
        v.setMediaController(new MediaController(this));
        v.requestFocus();
        v.start();
    }

}
