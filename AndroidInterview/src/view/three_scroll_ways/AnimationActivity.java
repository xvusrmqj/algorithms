package view.three_scroll_ways;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
/**
 * 使用Animation进行滑动
 * @author lv
 *
 */
public class AnimationActivity extends Activity implements OnClickListener{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		LinearLayout ll = new LinearLayout(this);
		Button btn1 = new Button(this);
		btn1.setText("AnimationActivity");
		ll.addView(btn1);
		btn1.setOnClickListener(this);
		setContentView(ll);
	}

	@Override
	public void onClick(View v) {
		Animation translateAnimation = new TranslateAnimation(100.0f, 250.0f,100.0f,100.0f);    
		translateAnimation.setDuration(1000);    
		translateAnimation.setFillAfter(true);
		v.startAnimation(translateAnimation); 
	}
}
