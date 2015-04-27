package com.alejandrocelaya.fragmentos;

import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;


public class Main extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment f1 = getSupportFragmentManager().findFragmentById(R.id.fragment);
        Fragment f2 = getSupportFragmentManager().findFragmentById(R.id.fragment2);
    }

}
