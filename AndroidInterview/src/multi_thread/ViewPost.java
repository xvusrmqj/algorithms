package multi_thread;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ViewPost extends Activity implements View.OnClickListener{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Button btn = new Button(this);
		btn.setText("hello111");
		btn.setOnClickListener(this);
		setContentView(btn);
	}
	@Override
	public void onClick(View view) {
		final Button btn = (Button)view;
		new Thread(){
			public void run() {//这个Run方法是线程里的
				btn.post(new Runnable() {
					@Override
					public void run() {//这个是View的Runnable里的。
						btn.setText("hello222");
					}
				});
			};
		}.start();
	}
}
