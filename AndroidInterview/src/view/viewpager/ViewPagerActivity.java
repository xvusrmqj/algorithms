package view.viewpager;

import java.util.ArrayList;
import java.util.List;

import com.example.androidinterview.R;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ViewPagerActivity extends Activity implements View.OnClickListener {
	private TextView tv1;
	private TextView tv2;
	private TextView tv3;

	private ViewPager pager;
	private List<View> list = new ArrayList<View>();

	private LinearLayout layout1;
	private LinearLayout layout2;
	private LinearLayout layout3;
	private LinearLayout layoutBottom1;
	private LinearLayout layoutBottom2;
	private LinearLayout layoutBottom3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏标题栏
		setContentView(R.layout.activity_viewpager);
		initView();
		initEvent();
		setAdapter();
	}

	private void initEvent() {
		layoutBottom1.setOnClickListener(this);
		layoutBottom2.setOnClickListener(this);
		layoutBottom3.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		resetViewColor();
		if (v == layoutBottom1) {
			pager.setCurrentItem(0);
			tv1.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
		} else if (v == layoutBottom2) {
			pager.setCurrentItem(1);
			tv2.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
		} else if (v == layoutBottom3) {
			pager.setCurrentItem(2);
			tv3.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
		}
	}

	private void setAdapter() {
		PagerAdapter pagerAdapter = new PagerAdapter() {

			@Override
			public void destroyItem(ViewGroup container, int position, Object object) {
				container.removeView(list.get(position));
			}

			@Override
			public Object instantiateItem(ViewGroup container, int position) {
				View view = list.get(position);
				container.addView(view);
				return view;
			}

			@Override
			public boolean isViewFromObject(View arg0, Object arg1) {
				return arg0 == arg1;
			}

			@Override
			public int getCount() {
				return list.size();
			}
		};
		pager.setAdapter(pagerAdapter);
		pager.addOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				resetViewColor();
				switch (arg0) {
				case 0:
					tv1.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
					break;
				case 1:
					tv2.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
					break;
				case 2:
					tv3.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
					break;

				default:
					break;
				}
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {

			}
		});
	}

	private void initView() {
		tv1 = (TextView) findViewById(R.id.viewpager_tv1);
		tv2 = (TextView) findViewById(R.id.viewpager_tv2);
		tv3 = (TextView) findViewById(R.id.viewpager_tv3);
		layoutBottom1 = (LinearLayout) findViewById(R.id.viewpager_bottom_item1);
		layoutBottom2 = (LinearLayout) findViewById(R.id.viewpager_bottom_item2);
		layoutBottom3 = (LinearLayout) findViewById(R.id.viewpager_bottom_item3);
		pager = (ViewPager) findViewById(R.id.viewpager);
		layout1 = (LinearLayout) getLayoutInflater().inflate(R.layout.viewpager1, null);
		layout2 = (LinearLayout) getLayoutInflater().inflate(R.layout.viewpager2, null);
		layout3 = (LinearLayout) getLayoutInflater().inflate(R.layout.viewpager3, null);
		list.add(layout1);
		list.add(layout2);
		list.add(layout3);
	}

	private void resetViewColor() {
		tv1.setTextColor(getResources().getColor(android.R.color.black));
		tv2.setTextColor(getResources().getColor(android.R.color.black));
		tv3.setTextColor(getResources().getColor(android.R.color.black));

	}
}
