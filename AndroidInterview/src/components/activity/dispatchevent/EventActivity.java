package components.activity.dispatchevent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class EventActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		System.out.println("------onCreate------");
		super.onCreate(savedInstanceState);
		EventView ev = new EventView(this);
		setContentView(ev);
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		System.out.println("---EventActivity----dispatchTouchEvent-------");
		return super.dispatchTouchEvent(ev);
	}
}

