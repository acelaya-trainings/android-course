package actividades.empresa.com.actividades;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

/**
 * Created by cta on 15/04/2015.
 */
public class Segunda extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.segunda);

        TextView textoSegunda = (TextView) findViewById(R.id.textoSegunda);
        textoSegunda.setText(this.getIntent().getExtras().getString("textoEnviado"));
    }
}
