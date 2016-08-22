package multi_thread;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

public class HandlerSendMsg extends Activity implements View.OnClickListener{
	private Button btn;
	private Handler handler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			btn.setText("hello444");
		};
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		btn = new Button(this);
		btn.setText("hello111");
		btn.setOnClickListener(this);
		setContentView(btn);
	}
	@Override
	public void onClick(View view) {
		new Thread(){
			public void run() {//这个Run方法是线程里的
				handler.sendEmptyMessage(0);
			};
		}.start();
	}
}
