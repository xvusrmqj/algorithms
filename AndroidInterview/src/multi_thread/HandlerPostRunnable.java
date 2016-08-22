package multi_thread;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

public class HandlerPostRunnable extends Activity implements View.OnClickListener{
	private Button btn;
	private Handler handler = new Handler();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		btn = new Button(this);
		btn.setText("hello111");
		btn.setOnClickListener(this);
		setContentView(btn);
	}
	@Override
	public void onClick(final View view) {
		new Thread(){
			public void run() {
				handler.post(new Runnable() {
					@Override
					public void run() {
						((Button)view).setText("hello555");
					}
				});
			};
		}.start();
	}
}
