package view.customview.view;

import com.example.androidinterview.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * 参考:http://blog.csdn.net/cyp331203/article/details/40736027
 * @author lv
 */
public class ToggleButton extends RelativeLayout {
	/** 
	 * 开关按钮的背景 
	 */
	private Bitmap backgroundBitmap;
	/** 
	 * 开关按钮的滑动部分 
	 */
	private Bitmap slideButtonBitmap;
	/** 
	 * 滑动按钮的左边界 
	 */
	private float slideBtn_left;
	/** 
	 * 当前开关的状态 
	 */
	private boolean currentState = false;

	private BtnClickListener listener;

	public interface BtnClickListener {
		public void onClick();
	}

	public void setOnBtnClickListener(BtnClickListener listener) {
		this.listener = listener;
	}

	/** 
	 * 在代码里面创建对象的时候，使用此构造方法 
	 *  
	 * @param context 
	 */
	public ToggleButton(Context context) {
		super(context);
	}

	/** 
	 * 在布局文件中声明的view，创建时由系统自动调用 
	 *  
	 * @param context 
	 * @param attrs 
	 */
	public ToggleButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		backgroundBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.switch_background);
		slideButtonBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.slide_button);

		/* 
		 * 点击事件 
		 */
		setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				currentState = !currentState;
				// 刷新当前view会导致ondraw方法的执行  
				invalidate();
				// 刷新当前的状态 
				if (currentState) {
					slideBtn_left = backgroundBitmap.getWidth() - slideButtonBitmap.getWidth();
				} else {
					slideBtn_left = 0;
				}
				if (listener != null)
					listener.onClick();
			}
		});
	}

	/** 
	 * 测量尺寸时的回调方法 
	 */
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// super.onMeasure(widthMeasureSpec, heightMeasureSpec);  
		// 设置当前view的大小 width:view的宽，单位都是像素值 heigth:view的高，单位都是像素值  
		setMeasuredDimension(backgroundBitmap.getWidth(), backgroundBitmap.getHeight());
	}

	Paint paint = new Paint();

	/** 
	 * 画view的方法,绘制当前view的内容 
	 */
	@Override
	protected void onDraw(Canvas canvas) {

		// 画背景  
		canvas.drawBitmap(backgroundBitmap, 0, 0, paint);
		// 画滑块  
		canvas.drawBitmap(slideButtonBitmap, slideBtn_left, 0, paint);
	}
}
