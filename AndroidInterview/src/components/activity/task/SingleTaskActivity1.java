package components.activity.task;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class SingleTaskActivity1 extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		TextView textView = new TextView(this);
		textView.setText("SingleTaskActivity1");
		textView.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(SingleTaskActivity1.this, SingleTaskActivity2.class));
			}
		});
		setContentView(textView);
		Log.e("singleTask", "----Activity1-onCreate-");
	}
	@Override
	protected void onNewIntent(Intent intent) {
		super.onNewIntent(intent);
		Log.e("singleTask", "----Activity1-onNewIntent=");
	}
	@Override
	protected void onResume() {
		super.onResume();
		Log.e("singleTask", "----Activity1-onResume-");
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
