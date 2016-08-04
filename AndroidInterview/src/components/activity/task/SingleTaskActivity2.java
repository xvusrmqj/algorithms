package components.activity.task;

import com.example.androidinterview.MainActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SingleTaskActivity2 extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		TextView textView = new TextView(this);
		textView.setText("SingleTaskActivity2");
		setContentView(textView);
		Log.e("singleTask", "----Activity2-onCreate-");
	}
	@Override
	protected void onResume() {
		super.onResume();
		startActivity(new Intent(this, MainActivity.class));
	}
	@Override
	protected void onStop() {
		Log.e("singleTask", "----Activity2-onStop-");
		super.onStop();
	}
	@Override
	protected void onDestroy() {
		Log.e("singleTask", "----Activity2-onDestroy-");
		super.onDestroy();
	}
}
