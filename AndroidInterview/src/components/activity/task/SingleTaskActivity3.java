package components.activity.task;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SingleTaskActivity3 extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		TextView textView = new TextView(this);
		textView.setText("SingleTaskActivity3");
		setContentView(textView);
		Log.e("singleTask", "----Activity3-onCreate-");
	}
	@Override
	protected void onResume() {
		super.onResume();
		startActivity(new Intent(this, SingleTaskActivity1.class));
	}
	@Override
	protected void onStop() {
		Log.e("singleTask", "----Activity3-onStop-");
		super.onStop();
	}
	@Override
	protected void onDestroy() {
		Log.e("singleTask", "----Activity3-onDestroy-");
		super.onDestroy();
	}
}
