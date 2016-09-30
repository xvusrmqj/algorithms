package view.customview.uimodule;

import com.example.androidinterview.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;
import view.customview.uimodule.TopBar.BtnClickListener;

public class CustomViewActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_customview);
		TopBar topBar = (TopBar) findViewById(R.id.topbar);
		topBar.setOnBtnClickListener(new BtnClickListener() {
			@Override
			public void onClick() {
				Toast.makeText(CustomViewActivity.this, "hello i can be click", Toast.LENGTH_LONG).show();
			}
		});
	}
}
