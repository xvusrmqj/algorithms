package components.service.intentService;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Client extends Activity implements View.OnClickListener {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Button btn = new Button(this);
		btn.setText("Client_intent_service");
		btn.setOnClickListener(this);
		setContentView(btn);
	}

	@Override
	public void onClick(final View view) {
		Intent intent = new Intent(Client.this, Server.class);
		startService(intent);
	}
}
