package view.customview.canvastest;

import com.example.androidinterview.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.View;
/**
 * 用于图片浏览的自定义组件.
 * PictureView
 * @author lv
 *
 */
public class PictureView extends View {

	private Bitmap dog;
	private Bitmap girl;
	private Paint paint;
	int j;
	int i = 0;
	int girlWidth, girlHeight;
	RectF rect;

	public PictureView(Context context, AttributeSet attrs) {
		super(context, attrs);
		dog = BitmapFactory.decodeResource(context.getResources(), R.drawable.dog);
		girl = BitmapFactory.decodeResource(context.getResources(), R.drawable.girl);
		paint = new Paint();
		j = girl.getWidth();
		girlWidth = girl.getWidth();
		girlHeight = girl.getHeight();
		rect = new RectF(0, 0, girlWidth,girlHeight);
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		clock(canvas);
	}

	/**
	 * 时钟，不完美。
	 * @param canvas
	 */

	private void clock(Canvas canvas) {
		canvas.drawBitmap(dog, 0, 0, paint); // 
		Path path = new Path();
		if (i <= 360){
			path.moveTo(girlWidth/2, girlHeight/2);
			path.arcTo(rect, 0, i++);
			path.close();
			canvas.clipPath(path);
			invalidate();
		}
		canvas.drawBitmap(girl, 0, 0, paint);
	}

	/**
	 * 从四周到中间
	 * @param canvas
	 */

	private void edgeToMedium(Canvas canvas) {
		canvas.drawBitmap(dog, 0, 0, paint); // 
		if (i < j) {
			i++;
			j--;
			canvas.clipRect(0, 0, i, i);
			canvas.clipRect(0, j, i, girlHeight, Region.Op.UNION);
			canvas.clipRect(j, 0, girlHeight, i, Region.Op.UNION);
			canvas.clipRect(j, j, girlHeight, girlHeight, Region.Op.UNION);
			invalidate();
		}
		canvas.drawBitmap(girl, 0, 0, paint);
	}

	/**
	 * 从两边到中间
	 * @param canvas
	 */

	private void leftRightToMedium(Canvas canvas) {
		canvas.drawBitmap(dog, 0, 0, paint); // 
		if (i < j) {
			i++;
			j--;
			canvas.clipRect(0, 0, i, girlHeight);
			canvas.clipRect(j, 0, girlWidth, girlHeight, Region.Op.UNION);
			invalidate();
		}
		canvas.drawBitmap(girl, 0, 0, paint);
	}

	/**
	 * 从左上到右下
	 * @param canvas
	 */

	private void leftTopToRightBottom(Canvas canvas) {
		canvas.drawBitmap(dog, 0, 0, paint); // 
		if (i <= girl.getWidth()) {
			i++;
			canvas.clipRect(0, 0, i, i);
			invalidate();
		}
		canvas.drawBitmap(girl, 0, 0, paint);
	}
}
