package components.activity.task;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class SingleTaskActivity3 extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		TextView textView = new TextView(this);
		textView.setText("SingleTaskActivity3");
		textView.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				startActivity(new Intent(SingleTaskActivity3.this, SingleTaskActivity1.class));
			}
		});
		setContentView(textView);
		Log.e("singleTask", "----Activity3-onCreate-");
	}

	@Override
	protected void onNewIntent(Intent intent) {
		super.onNewIntent(intent);
		Log.e("singleTask", "----Activity3-onNewIntent=");
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.e("singleTask", "----Activity3-onResume-");
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
