package fragmentos.cta.com.ejercicio4;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class DetalleActivity extends FragmentActivity {

	public static final String EXTRA_TEXTO =
			"Hola caracola";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detalle);
		
		FragmentDetalle detalle = 
				(FragmentDetalle)getSupportFragmentManager()
					.findFragmentById(R.id.FrgDetalle);
		
		detalle.mostrarDetalle(getIntent().getStringExtra(EXTRA_TEXTO));
	}
}
