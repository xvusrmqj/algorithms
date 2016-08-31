package components.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;

/**
 * 设置Activity为窗口形式,只需在AndroidManifest.xml里设置
 * @author lv
 *
 */
public class WindowActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		LinearLayout layout = new LinearLayout(this);
		//XXX 不知道为什么这里怎么设置都不行???
		layout.setLayoutParams(new LayoutParams(500, 500));
		//		layout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT));
		setContentView(layout);
	}
}
