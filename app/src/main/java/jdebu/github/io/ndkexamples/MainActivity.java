package jdebu.github.io.ndkexamples;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener{
	private TextView title,result;
	private EditText op1,op2;
	private Button suma,resta;
	private int operador1,operador2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initUI();
	}

	private void initUI() {
		title = (TextView) findViewById(R.id.textview);
		result = (TextView) findViewById(R.id.resultado);
		op1 = (EditText) findViewById(R.id.op1);
		op2 = (EditText) findViewById(R.id.op2);
		suma = (Button) findViewById(R.id.sumar);
		resta = (Button) findViewById(R.id.restar);
		suma.setOnClickListener(this);
		resta.setOnClickListener(this);
		title.setText(HelloJNI());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	static {
		System.loadLibrary("HelloJNI");
	}
	public native String HelloJNI();
	public native int suma(int numero1, int numero2);
	public native int resta(int numero1, int numero2);

	@Override
	public void onClick(View v) {
		switch (v.getId()){
			case R.id.sumar:
				Log.e(null,"click sumar");
					result.setText(suma(Integer.parseInt(op1.getText().toString()),Integer.parseInt(op2.getText().toString()))+"");
				break;
			case R.id.restar:
				Log.e(null,"clic restar");
				result.setText(resta(Integer.parseInt(op1.getText().toString()), Integer.parseInt(op2.getText().toString()))+"");
				break;
		}
	}
}
