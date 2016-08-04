package components.activity.task;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SingleTaskActivity1 extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		TextView textView = new TextView(this);
		textView.setText("SingleTaskActivity1");
		setContentView(textView);
		Log.e("singleTask", "----Activity1-onCreate-");
	}
	@Override
	protected void onResume() {
		super.onResume();
		startActivity(new Intent(this, SingleTaskActivity2.class));
	}
	@Override
	protected void onStop() {
		Log.e("singleTask", "----Activity1-onStop-");
		super.onStop();
	}
	@Override
	protected void onDestroy() {
		Log.e("singleTask", "----Activity1-onDestroy-");
		super.onDestroy();
	}
}
