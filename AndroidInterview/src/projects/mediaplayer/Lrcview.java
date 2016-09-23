package projects.mediaplayer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * 歌词
 * Created by wcy on 2015/11/9.
 */
public class Lrcview extends View {

	public Lrcview(Context context) {
		this(context, null);
	}

	public Lrcview(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public Lrcview(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	String s1 = "11111111";
	String s2 = "22222222";
	String s3 = "3333333";
	String s4 = "444444444";
	String s5 = "55555555";
	String s6 = "66666666666";
	Paint p = new Paint();
	float x = 0;
	float y = 0;
	int step = 12;

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		canvas.drawText(s1, x, y += step, p);
		canvas.drawText(s2, x, y += step, p);
		canvas.drawText(s3, x, y += step, p);
		canvas.drawText(s4, x, y += step, p);
		canvas.drawText(s5, x, y += step, p);
		canvas.drawText(s6, x, y += step, p);
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		postInvalidate();
	}

}