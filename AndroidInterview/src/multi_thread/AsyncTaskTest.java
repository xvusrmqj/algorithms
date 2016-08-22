package multi_thread;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AsyncTaskTest extends Activity implements View.OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Button btn = new Button(this);
		btn.setText("hello111");
		btn.setOnClickListener(this);
		setContentView(btn);
	}

	@Override
	public void onClick(final View view) {
		new AsyncTask<Integer, Void, String>() {
			@Override
			protected String doInBackground(Integer... params) {
				return "hello"+params[0];
			}

			@Override
			protected void onPostExecute(String result) {
				((Button) view).setText(result);
			}
		}.execute(666);
	}
}
