package components.contentprovider;

import android.app.Activity;
import android.widget.TextView;

public class ContentProviderActivity extends Activity {
	private TextView tv;
	String note = "请看下包中的类:\n ipc.contentprovider.client.ProviderActivity";
	protected void onCreate(android.os.Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		tv = new TextView(this);
		tv.setText(note);
		setContentView(tv);
	}
	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		System.out.println("未设置宽高的情况下貌似是match_parent");
		System.out.println(tv.getWidth() + ":" + tv.getHeight());
	}
}
