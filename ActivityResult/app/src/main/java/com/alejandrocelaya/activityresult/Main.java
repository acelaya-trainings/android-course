package com.alejandrocelaya.activityresult;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Main extends ActionBarActivity implements View.OnClickListener {

    public static final String EXTRA = "numbers";

    private TextView texto;
    private Button altura;
    private Button anchura;
    private Button area;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        texto = (TextView) findViewById(R.id.texto);
        altura = (Button) findViewById(R.id.altura);
        anchura = (Button) findViewById(R.id.anchura);
        area = (Button) findViewById(R.id.area);

        altura.setOnClickListener(this);
        anchura.setOnClickListener(this);
        area.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(this, Numbers.class);

        switch (v.getId()) {
            case R.id.altura:
                i.putExtra(EXTRA, "Altura");
                startActivityForResult(i, 1);
                break;
            case R.id.anchura:
                i.putExtra(EXTRA, "Anchura");
                startActivityForResult(i, 1);
                break;
            case R.id.area:
                i.putExtra(EXTRA, "Area");
                int a = Integer.valueOf(altura.getText().toString()),
                    b = Integer.valueOf(anchura.getText().toString());
                texto.setText(String.format("%s area calculada", a * b));
                break;
            default:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (data.hasExtra("anchuraInfo")) {
            anchura.setText(data.getStringExtra("anchuraInfo"));
        } else if (data.hasExtra("alturaInfo")) {
            altura.setText(data.getStringExtra("alturaInfo"));
        }
    }
}
