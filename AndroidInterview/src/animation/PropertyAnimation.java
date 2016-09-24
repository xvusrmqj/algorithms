package animation;

import com.example.androidinterview.R;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class PropertyAnimation extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ImageView iv = new ImageView(this);
		iv.setImageResource(R.drawable.girl);
		iv.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				rotateyAnimRun2(v);
			}
		});
		setContentView(iv);
	}

	public void rotateyAnimRun(View view) {
		ObjectAnimator//  
				.ofFloat(view, "rotationX", 0.0F, 360.0F)//  
				.setDuration(500)//  
				.start();
	}
	public void rotateyAnimRun2(final View view)  
	{  
	    ObjectAnimator anim = ObjectAnimator//  
	            .ofFloat(view, "zhy", 1.0F,  0.0F)//  
	            .setDuration(500);//  
	    anim.start();  
	    anim.addUpdateListener(new AnimatorUpdateListener()  
	    {  
	        @Override  
	        public void onAnimationUpdate(ValueAnimator animation)  
	        {  
	            float cVal = (Float) animation.getAnimatedValue();  
	            view.setAlpha(cVal);  
	            view.setScaleX(cVal);  
	            view.setScaleY(cVal);  
	        }  
	    });  
	}
//    public void verticalRun( View view)  
//    {  
//        ValueAnimator animator = ValueAnimator.ofFloat(0, mScreenHeight  
//                - mBlueBall.getHeight());  
//        animator.setTarget(mBlueBall);  
//        animator.setDuration(1000).start();  
////      animator.setInterpolator(value)  
//        animator.addUpdateListener(new AnimatorUpdateListener()  
//        {  
//            @Override  
//            public void onAnimationUpdate(ValueAnimator animation)  
//            {  
//                mBlueBall.setTranslationY((Float) animation.getAnimatedValue());  
//            }  
//        });  
//    }
}
