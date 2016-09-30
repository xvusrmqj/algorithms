package animation;

import com.example.androidinterview.R;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ValueAnimatorTest extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Button iv = new Button(this);
		iv.setText("hello");
		iv.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				click(v);
			}
		});
		setContentView(iv);
	}

	// 使用ValueAnimator动画做一个计时器的效果.
	public void click(final View view) {
		ValueAnimator animator = ValueAnimator.ofInt(0, 100).setDuration(5000);
		animator.addUpdateListener(new AnimatorUpdateListener() {
			@Override
			public void onAnimationUpdate(ValueAnimator animation) {
				Integer value = (Integer) animation.getAnimatedValue();
				((Button) view).setText(value + "");
			}
		});
		animator.start();
	}
}
