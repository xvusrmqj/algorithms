package components.broadcastreciver;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import components.activity.task.SingleTaskActivity1;

public class ClientActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Button btn = new Button(this);
		btn.setText("发送广播的Activity");
		setContentView(btn);
	}

	@Override
	protected void onStart() {
		CommonReceiver receiver = new CommonReceiver();
		registerReceiver(receiver, new IntentFilter("hello.client"));
		unregisterReceiver(receiver);
	}

	@Override
	protected void onResume() {
		super.onResume();
		sendOrderedBroadcast(new Intent("android.intent.action.LVTESTRECEIVER"), null);//有序广播
	}
}
