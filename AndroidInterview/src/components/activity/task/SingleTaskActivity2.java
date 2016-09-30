package components.activity.task;

import com.example.androidinterview.MainActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class SingleTaskActivity2 extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		TextView textView = new TextView(this);
		textView.setText("SingleTaskActivity2");
		textView.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(SingleTaskActivity2.this, SingleTaskActivity3.class));
			}
		});
		setContentView(textView);
		Log.e("singleTask", "----Activity2-onCreate-");
	}
	@Override
	protected void onNewIntent(Intent intent) {
		super.onNewIntent(intent);
		Log.e("singleTask", "----Activity2-onNewIntent=");
	}
	@Override
	protected void onResume() {
		super.onResume();
		Log.e("singleTask", "----Activity2-onResume-");
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
