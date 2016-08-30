package view.three_scroll_ways;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.FrameLayout.LayoutParams;

/**
 * 使用改变布局参数来实现滑动
 * @author lv
 *
 */
public class LayoutActivity extends Activity implements OnClickListener {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		LinearLayout layout = new LinearLayout(this);
		Button btn1 = new Button(this);
		btn1.setLayoutParams(new LinearLayout.LayoutParams(80, 100));
		btn1.setText("Hello");
		layout.addView(btn1);
		btn1.setOnClickListener(this);
		setContentView(layout);
	}

	@Override
	public void onClick(View v) {
		MarginLayoutParams params = (MarginLayoutParams) v.getLayoutParams();
		params.width += 100;
		params.leftMargin += 100;
		//		v.requestLayout();
		v.setLayoutParams(params);//这两个方法都行.
	}

}
