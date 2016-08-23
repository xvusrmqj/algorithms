package ipc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class BundleTest extends Activity{
@Override
protected void onCreate(Bundle savedInstanceState) {
	
	super.onCreate(savedInstanceState);
	Intent intent = new Intent();
	Bundle bundle = new Bundle();
	bundle.putString("key", "value");
	intent.putExtras(bundle);
}
}
