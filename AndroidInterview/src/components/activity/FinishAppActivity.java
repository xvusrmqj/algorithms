package components.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FinishAppActivity extends Activity {
	public static int layers = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		System.out.println("------onCreate------");
		super.onCreate(savedInstanceState);
		Button btn = new Button(this);
		btn.setText("finish");
		btn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				android.os.Process.killProcess(android.os.Process.myPid());
			}
		});
		setContentView(btn);
	}

	@Override
	protected void onStart() {

		System.out.println("------onStart-------");
		super.onStart();
	}

	@Override
	protected void onRestart() {
		System.out.println("-------onRestart------");

		super.onRestart();
	}

	@Override
	protected void onResume() {
		System.out.println("-------onResume------");
		super.onResume();
		if (layers++ < 2)
			startActivity(new Intent(this, FinishAppActivity.class));
	}

	@Override
	protected void onPause() {

		System.out.println("-------onPause------");
		super.onPause();
	}

	@Override
	protected void onStop() {
		System.out.println("-------onStop------");
		super.onStop();
	}

	@Override
	protected void onDestroy() {
		System.out.println("--------onDestroy-----");

		super.onDestroy();
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		System.out.println("-------onSaveInstanceState------");
		super.onSaveInstanceState(outState);
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		System.out.println("------onRestoreInstanceState-------");
		super.onRestoreInstanceState(savedInstanceState);
	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		System.out.println("------onWindowFocusChanged-------");
		super.onWindowFocusChanged(hasFocus);
	}

}
