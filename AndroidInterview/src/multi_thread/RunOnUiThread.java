package multi_thread;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RunOnUiThread extends Activity implements View.OnClickListener {
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
		final Button btn = (Button) view;
		new Thread() {
			public void run() {
				//内部类被当作外部类成员,可以调用外部类方法(私有的也行).
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						btn.setText("hello333");
					}
				});
			};
		}.start();
	}
}

class A {
	private int a;
	public void test() {
		System.out.println("a");
	}

	class B{
		
		
		void testBBB(){
			a = 10;
			test();
		}
	}
}
