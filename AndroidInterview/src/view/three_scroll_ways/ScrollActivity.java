package view.three_scroll_ways;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * 使用Scrollto和Scrollby进行滑动
 * @author lv
 *
 */
public class ScrollActivity extends Activity implements OnClickListener {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Button btn = new Button(this);
		btn.setText("ScrollActivity");
		btn.setOnClickListener(this);
		setContentView(btn);
	}
	/**
	 * scrollTo和scrollBy是对View内容的移动,而不是View本身
	 */
	@Override
	public void onClick(View v) {
		v.scrollBy(-10, -10);
	}

}
