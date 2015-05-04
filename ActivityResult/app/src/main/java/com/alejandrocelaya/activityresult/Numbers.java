package com.alejandrocelaya.activityresult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by cta on 04/05/2015.
 */
public class Numbers extends Activity implements View.OnClickListener {

    protected EditText numero;
    protected Button ir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.numbers);

        numero = (EditText) findViewById(R.id.numero);
        ir = (Button) findViewById(R.id.ir);
        ir.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i = getIntent();
        String s = numero.getText().toString(),
               msg = i.getStringExtra(Main.EXTRA);

        i.putExtra("Anchura".contentEquals(msg) ? "anchuraInfo" : "alturaInfo", s);
        setResult(RESULT_OK, i);
        finish();
    }
}
