package com.empresa.listas;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

/**
 * Created by cta on 20/04/2015.
 */
public class ImageActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        ImageView imageView = (ImageView) findViewById(R.id.bigImage);
        imageView.setImageResource(getIntent().getExtras().getInt("imageResource"));
    }
}
