package components.broadcastreciver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class OrderedBroadcastReciver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent arg1) {
		Toast.makeText(context, "OrderedBroadcastReciver先收到", 1).show();
//		abortBroadcast();//可以终止广播给下一个.
	}

}
