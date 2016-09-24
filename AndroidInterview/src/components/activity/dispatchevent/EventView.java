package components.activity.dispatchevent;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;

public class EventView extends View {


	public EventView(Context context) {
		super(context);
	}
	@Override
	public boolean performClick() {
		System.out.println("performClick------------");
		return super.performClick();
	}
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		performClick();
		System.out.println("onTouchEvent------------");
		return true;
	}
}
