package view.viewpager.custom_viewpager_indictor;

import java.util.List;

import com.example.androidinterview.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 自定义的ViewGroup, 主要和LinearLayout的区别就是
 * 1. 有一个指示的小三角形
 * 2. 这个三角形随着ViewPager能滑动.
 * http://www.imooc.com/learn/615
 * @author lv
 *
 */
public class ViewPagerIndicator extends LinearLayout {
	//下面是画三角形所需要的一些参数
	private Paint paint;
	private Path path;
	private int triangleW;
	private int triangleH;
	private int initTranslationX;
	private int translationX;
	private static final float RADIO_TRIANGLE_WIDTH = 1 / 6F;

	private int tabVisibleCount;

	/**
	 * 需要先调用setVisibleTabCount, 后调用setTabItemTitles
	 * @param count
	 */
	public void setVisibleTabCount(int count) {
		this.tabVisibleCount = count;
	}

	/**
	 * 动态设置Indicator的项
	 * @param list
	 */
	public void setTabItemTitles(List<String> list) {
		if (list != null && list.size() > 0) {
			this.removeAllViews();//先把XML里设的全移除
			for (String string : list) {
				TextView tv = new TextView(getContext());
				LinearLayout.LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
				lp.width = getScreenWidth() / tabVisibleCount;
				tv.setLayoutParams(lp);
				tv.setText(string);
				tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
				tv.setGravity(Gravity.CENTER);
				tv.setTextColor(Color.parseColor("#77000000"));
				addView(tv);
			}
		}
	}

	public ViewPagerIndicator(Context context) {
		this(context, null);
	}

	public ViewPagerIndicator(Context context, AttributeSet attrs) {
		super(context, attrs);
		TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.ViewPagerIndicator);
		tabVisibleCount = array.getInt(R.styleable.ViewPagerIndicator_visible_tab_count, 4);
		array.recycle();
		paint = new Paint();
		paint.setAntiAlias(true);
		paint.setColor(Color.parseColor("#ffffffff"));
		paint.setStyle(Style.FILL);
		paint.setPathEffect(new CornerPathEffect(3));

	}

	/**
	 * 设置XML里的那些Indicator项
	 */
	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		int childCount = getChildCount();
		if (childCount == 0)
			return;
		for (int i = 0; i < childCount; i++) {
			View view = getChildAt(i);
			LinearLayout.LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
			layoutParams.weight = 0;
			layoutParams.width = getScreenWidth() / tabVisibleCount; //就是取了一下屏幕宽度,再根据屏幕宽度改了一个宽度,至于这样吗?
			view.setLayoutParams(layoutParams);
		}
	}

	/**
	 * 取得屏幕宽度
	 * @return
	 */
	private int getScreenWidth() {
		WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
		DisplayMetrics m = new DisplayMetrics();
		wm.getDefaultDisplay().getMetrics(m);
		return m.widthPixels;
	}

	/**
	 * ViewGroup一般覆盖这个方法,而不是onDraw, 它们的区别在哪?
	 */
	@Override
	protected void dispatchDraw(Canvas canvas) {
		canvas.save();
		canvas.translate(initTranslationX + translationX, getHeight());
		canvas.drawPath(path, paint);
		canvas.restore();
		super.dispatchDraw(canvas);
	}

	/**
	 * onSizeChanged() is called when your view is first assigned a size, and again if the size of your view changes for any reason.
	 * 这个方法的好处就是能得到控件的宽度,高度(以参数的形式给出)
	 */
	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
		triangleW = (int) (w / tabVisibleCount * RADIO_TRIANGLE_WIDTH);
		triangleH = triangleW / 3;
		initTranslationX = w / tabVisibleCount / 2 - triangleW / 2;
		initTriangle();
	}

	private void initTriangle() {
		path = new Path();
		path.moveTo(0, 0);
		path.lineTo(triangleW, 0);
		path.lineTo(triangleW / 2, -triangleH);
		path.close();
	}

	/**
	 * 这个就是三角形滑动的方法了.
	 * @param position
	 * @param positionOffset
	 */
	public void scroll(int position, float positionOffset) {
		int tabWidth = getWidth() / tabVisibleCount;
		translationX = (int) (tabWidth * (positionOffset + position));
		if (position >= tabVisibleCount - 2 && positionOffset > 0 && getChildCount() > tabVisibleCount) {
			this.scrollTo((position - (tabVisibleCount - 2)) * tabWidth + (int) (tabWidth * positionOffset), 0);
		}
		invalidate();
	}
}
