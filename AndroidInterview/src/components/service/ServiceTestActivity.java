package components.service;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;

public class ServiceTestActivity extends Activity implements View.OnClickListener {
	private Button btn1;
	private Button btn2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//初始化一个线性布局
		LinearLayout ll = new LinearLayout(this);
		btn1 = new Button(this);
		btn1.setText("startService");
		btn2 = new Button(this);
		btn2.setText("startIntentService");
		//加到布局里
		ll.addView(btn1);
		ll.addView(btn2);
		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);

		setContentView(ll);
	}

	@Override
	public void onClick(final View view) {
		if(view==btn1){
			Intent intent = new Intent(ServiceTestActivity.this, ServiceTest.class);
			startService(intent);
		}else if(view==btn2){
			Intent intent = new Intent(ServiceTestActivity.this, IntentServiceTest.class);
			startService(intent);
		}
	}
}
