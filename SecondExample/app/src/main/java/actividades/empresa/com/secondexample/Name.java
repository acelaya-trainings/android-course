package actividades.empresa.com.secondexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by cta on 15/04/2015.
 */
public class Name extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.name);

        TextView lblName = (TextView) findViewById(R.id.lblName);
        lblName.setText(getIntent().getExtras().getString("name", "No name provided"));

        Button btnFinal = (Button) findViewById(R.id.btnNameFinal);
        btnFinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Name.this, FinalActivity.class));
            }
        });
    }

}
