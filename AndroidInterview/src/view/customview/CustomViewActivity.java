package view.customview;

import com.example.androidinterview.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import view.customview.uimodule.TopBar;
import view.customview.uimodule.TopBar.BtnClickListener;
import view.customview.view.ToggleButton;

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
		ToggleButton tbn = (ToggleButton) findViewById(R.id.toggle_btn);
		tbn.setOnBtnClickListener(new ToggleButton.BtnClickListener() {
			
			@Override
			public void onClick() {
				Toast.makeText(CustomViewActivity.this, "ToggleButton", Toast.LENGTH_LONG).show();
			}
		});
		
	}
}
