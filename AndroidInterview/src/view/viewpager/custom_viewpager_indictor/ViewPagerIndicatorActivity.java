package view.viewpager.custom_viewpager_indictor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.androidinterview.R;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 用于显示自定义ViewPager
 * 如果想让上边的项可以点击的话,可以继承onclickListener
 * @author lv
 *
 */
public class ViewPagerIndicatorActivity extends FragmentActivity {
	//需要ViewPager , ViewPagerIndicator, PagerAdaptor
	private ViewPager pager;
	private ViewPagerIndicator indicator;
	private FragmentPagerAdapter adapter;
	//listContent用于放ViewPagerIndicator里的项
	private List<String> listContent = Arrays.asList("111", "222", "333", "4", "5", "6", "7", "8", "9");
	//listFragment用于放ViewPager里的项
	private List<ViewPagerFragment> listFragment = new ArrayList<ViewPagerFragment>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏标题栏
		setContentView(R.layout.activity_viewpager_custom_indicator);
		initView();

		indicator.setVisibleTabCount(3);//设置一屏上显示的项数量
		indicator.setTabItemTitles(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i"));//这是所有的项

		pager.setAdapter(adapter);
		pager.addOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {

			}

			@Override
			public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
				indicator.scroll(position, positionOffset);
			}

			@Override
			public void onPageScrollStateChanged(int arg0) {

			}
		});
	}

	private void initView() {

		pager = (ViewPager) findViewById(R.id.viewpager);
		indicator = (ViewPagerIndicator) findViewById(R.id.id_indicator);
		for (String item : listContent) {
			ViewPagerFragment fragment = ViewPagerFragment.newInstance(item);
			listFragment.add(fragment);
		}
		adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {

			@Override
			public int getCount() {
				return listFragment.size();
			}

			@Override
			public Fragment getItem(int position) {
				return listFragment.get(position);
			}
		};
	}

}
