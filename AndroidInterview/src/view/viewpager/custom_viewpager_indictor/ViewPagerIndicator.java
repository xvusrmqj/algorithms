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
 * http://www.imooc.com/learn/615
 * @author lv
 *
 */
public class ViewPagerIndicator extends LinearLayout {
	private Paint paint;
	private Path path;
	private int triangleW;
	private int triangleH;
	private int initTranslationX;
	private int translationX;
	private static final float RADIO_TRIANGLE_WIDTH = 1 / 6F;

	private int tabVisibleCount;

	public void setVisibleTabCount(int count) {
		this.tabVisibleCount = count;
	}

	public void setTabItemTitles(List<String> list) {
		if (list != null && list.size() > 0) {
			this.removeAllViews();
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
			layoutParams.width = getScreenWidth() / tabVisibleCount;
			view.setLayoutParams(layoutParams);
		}
	}

	private int getScreenWidth() {
		WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
		DisplayMetrics m = new DisplayMetrics();
		wm.getDefaultDisplay().getMetrics(m);
		return m.widthPixels;
	}

	@Override
	protected void dispatchDraw(Canvas canvas) {
		canvas.save();
		canvas.translate(initTranslationX + translationX, getHeight());
		canvas.drawPath(path, paint);
		canvas.restore();
		super.dispatchDraw(canvas);
	}

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

	public void scroll(int position, float positionOffset) {
		int tabWidth = getWidth() / tabVisibleCount;
		translationX = (int) (tabWidth * (positionOffset + position));
		if (position >= tabVisibleCount - 2 && positionOffset > 0 && getChildCount() > tabVisibleCount) {
			this.scrollTo((position - (tabVisibleCount - 2)) * tabWidth + (int) (tabWidth * positionOffset), 0);
		}
		invalidate();
	}
}
