package bd.aula.sqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class Main extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteDatabase db = openOrCreateDatabase("miDB", MODE_PRIVATE, null);
//        db.execSQL("CREATE TABLE IF NOT EXISTS MiTabla(Nombre VARCHAR, Apellido VARCHAR, Edad INT(3));");
//        db.execSQL("INSERT INTO MiTabla VALUES('Alejandro', 'Celaya', 26);");

        Cursor c = db.rawQuery("SELECT * FROM MiTabla", null);
        c.moveToFirst();
//        Log.d("Resultado", c.getString(c.getColumnIndex("Nombre")));
//        Log.d("Resultado", c.getString(c.getColumnIndex("Apellido")));
//        Log.d("Resultado", String.valueOf(c.getInt(c.getColumnIndex("Edad"))));

        TextView t = (TextView) findViewById(R.id.texto);
        t.setText(
                String.format(
                        "%s %s %s",
                        c.getString(c.getColumnIndex("Nombre")),
                        c.getString(c.getColumnIndex("Apellido")),
                        String.valueOf(c.getInt(c.getColumnIndex("Edad")))
                )
        );

        c.close();
        db.close();
    }

}
