package animation;

import com.example.androidinterview.R;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.BounceInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

public class ObjectAnimatorTest extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ImageView iv = new ImageView(this);
		iv.setImageResource(R.drawable.girl);
		iv.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				scale(v);
			}
		});
		setContentView(iv);
	}
	//平移动画
	public void translate(View view) {
		//		TranslateAnimation animation = new TranslateAnimation(0, 200, 0, 0);
		//		animation.setDuration(1000);
		//		animation.setFillAfter(true);
		//		view.startAnimation(animation);

		ObjectAnimator//  
				.ofFloat(view, "translationX", 0.0F, 200.0F)//  
				.setDuration(1000)//  
				.start();
	}
	// alpha动画
	public void alpha(View view) {
		//		AlphaAnimation animation = new AlphaAnimation(0, 1);
		//		animation.setDuration(1000);
		//		animation.setFillAfter(true);
		//		view.startAnimation(animation);

		ObjectAnimator//  
				.ofFloat(view, "alpha", 0.0F, 1.0F)//  
				.setDuration(1000)//  
				.start();
	}
	// 旋转动画
	public void rotate(View view) {
		//		RotateAnimation animation = new RotateAnimation(0, 180, view.getWidth() / 2, view.getHeight() / 2);
		//		animation.setDuration(1000);
		//		animation.setFillAfter(true);
		//		view.startAnimation(animation);

		ObjectAnimator//  
				.ofFloat(view, "rotation", 0.0F, 180.0F)//  
				.setDuration(1000)//  
				.start();
	}
	// 缩放动画
	public void scale(View view) {
		//		ScaleAnimation animation = new ScaleAnimation(0f,1f,0f,1f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f); ;
		//		animation.setDuration(1000);
		//		animation.setFillAfter(true);
		//		view.startAnimation(animation);

		ObjectAnimator//  
				.ofFloat(view, "scaleX", 0.0F, 1.0F)//  
				.setDuration(1000)//  
				.start();
		ObjectAnimator//  
				.ofFloat(view, "scaleY", 0.0F, 1.0F)//  
				.setDuration(1000)//  
				.start();
	}
	// 几种动画组合
	public void composite(View view) {
		// method 1 最简单的组合
		//		ObjectAnimator.ofFloat(view, "translationX", 0F, 200.0F).setDuration(1000).start();
		//		ObjectAnimator.ofFloat(view, "translationY", 0F, 200.0F).setDuration(1000).start();
		//		ObjectAnimator.ofFloat(view, "rotation", 0.0F, 360.0F).setDuration(1000).start();
		// method 2 可以重用PropertyValuesHolder
		//		PropertyValuesHolder p1 = PropertyValuesHolder.ofFloat("translationX", 0F, 200.0F);
		//		PropertyValuesHolder p2 = PropertyValuesHolder.ofFloat("translationY", 0F, 200.0F);
		//		PropertyValuesHolder p3 = PropertyValuesHolder.ofFloat("rotation", 0F, 360.0F);
		//		ObjectAnimator.ofPropertyValuesHolder(view, p1, p2, p3).setDuration(1000).start();
		// method 3 更丰富的组合, 顺序播放,一起播放,设置先后顺序
		ObjectAnimator animator1 = ObjectAnimator.ofFloat(view, "translationX", 0F, 200.0F);
		ObjectAnimator animator2 = ObjectAnimator.ofFloat(view, "translationY", 0F, 200.0F);
		ObjectAnimator animator3 = ObjectAnimator.ofFloat(view, "rotation", 0.0F, 360.0F);
		AnimatorSet set = new AnimatorSet();
		//		set.playSequentially(animator1,animator2,animator3);
		//		set.playTogether(animator1,animator2,animator3);
		set.play(animator1).with(animator2);
		set.play(animator3).after(animator1);
		set.setDuration(1000).start();

	}
	// 动画的监听
	public void animationListener(View view) {
		ObjectAnimator animator = ObjectAnimator//  
				.ofFloat(view, "rotation", 0.0F, 180.0F)// 
				.setDuration(1000);
		animator.addListener(new AnimatorListenerAdapter() {
			@Override
			public void onAnimationEnd(Animator animation) {
				Toast.makeText(ObjectAnimatorTest.this, "animator_end", 1).show();
			}
		});
		animator.start();
	}
	// 给动画添加差值器(动画变化的加速度)
	public void addInterpolation(View view) {
		ObjectAnimator animator = ObjectAnimator//  
				.ofFloat(view, "translationY", 0.0F, 400.0F)// 
				.setDuration(1000);
		animator.setInterpolator(new BounceInterpolator());
		animator.start();
	}

}
