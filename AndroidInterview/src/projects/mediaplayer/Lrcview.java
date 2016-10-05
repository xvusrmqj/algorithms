package projects.mediaplayer;

import java.util.List;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

/**
 * 歌词
 */
public class Lrcview extends View {

	List<LrcContent> list;
	int currentIndex;

	Paint currentPaint = new Paint();
	Paint noCurrentPaint = new Paint();

	float centerDisplayHeight;
	float centerDisplayWidth;
	float step;

	public Lrcview(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public void setList(List<LrcContent> list) {
		this.list = list;
	}

	public void setCurrentIndex(int duration) {
		System.out.println("duration=" + duration);
		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i).getStartTime() < duration && list.get(i + 1).getStartTime() > duration) {
				this.currentIndex = i;
				postInvalidate();
				break;
			}
		}
	}

	//这里最适合最初化一些参数
	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		currentPaint.setColor(Color.RED);
		currentPaint.setTextAlign(Align.CENTER);
		float currentSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 16,
				getResources().getDisplayMetrics());
		currentPaint.setTextSize(currentSize);
		noCurrentPaint.setColor(Color.BLUE);
		noCurrentPaint.setTextAlign(Align.CENTER);
		float noCurrentSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 13,
				getResources().getDisplayMetrics());
		noCurrentPaint.setTextSize(noCurrentSize);

		Rect bounds = new Rect();
		currentPaint.getTextBounds("hello", 0, 1, bounds);
		step = bounds.height();
		centerDisplayHeight = (getHeight() - step) / 2;
		centerDisplayWidth = getWidth() / 2;
		System.out.println("centerDisplayHeight=" + centerDisplayHeight + ",step=" + step);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		float preY = centerDisplayHeight;
		float postY = centerDisplayHeight;
		super.onDraw(canvas);
		if (list == null || list.size() == 0)
			return;
		canvas.drawText(list.get(currentIndex).getLrcString(), centerDisplayWidth, centerDisplayHeight, currentPaint);
		// 画之前
		for (int i = currentIndex - 1; i >= 0; i--) {
			preY -= (step + 5);//这里与下面加5是为了行与行之间隔开一点，而不是紧挨着
			canvas.drawText(list.get(i).getLrcString(), centerDisplayWidth, preY, noCurrentPaint);
		}
		// 画之后
		for (int i = currentIndex + 1; i < list.size(); i++) {
			postY += (step + 5);
			canvas.drawText(list.get(i).getLrcString(), centerDisplayWidth, postY, noCurrentPaint);
		}
	}

}