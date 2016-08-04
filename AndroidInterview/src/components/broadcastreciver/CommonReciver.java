package components.broadcastreciver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class CommonReciver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent arg1) {
		Toast.makeText(context, "CommonReciver", 1).show();
	}

}
