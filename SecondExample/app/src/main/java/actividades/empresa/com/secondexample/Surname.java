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
public class Surname extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.surname);

        TextView lblName = (TextView) findViewById(R.id.lblSurname);
        lblName.setText(getIntent().getExtras().getString("surname", "No surname provided"));

        Button btnFinal = (Button) findViewById(R.id.btnSurnameFinal);
        btnFinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Surname.this, FinalActivity.class));
            }
        });
    }

}
