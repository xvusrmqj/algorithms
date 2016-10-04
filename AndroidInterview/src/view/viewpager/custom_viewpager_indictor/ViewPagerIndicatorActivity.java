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

public class ViewPagerIndicatorActivity extends FragmentActivity implements View.OnClickListener {

	private ViewPager pager;
	private ViewPagerIndicator indicator;
	private List<String> listContent = Arrays.asList("111", "222", "333","4", "5", "6","7", "8", "9");
	private List<ViewPagerFragment> listFragment = new ArrayList<ViewPagerFragment>();
	private FragmentPagerAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏标题栏
		setContentView(R.layout.activity_viewpager_custom_indicator);
		initView();
		
		indicator.setVisibleTabCount(3);
		indicator.setTabItemTitles(Arrays.asList("a","b","c","d","e","f","g","h","i"));
		
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

	@Override
	public void onClick(View v) {
		resetViewColor();

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

	private void resetViewColor() {

	}
}
