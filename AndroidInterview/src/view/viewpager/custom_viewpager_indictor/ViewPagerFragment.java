package view.viewpager.custom_viewpager_indictor;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ViewPagerFragment extends Fragment {
	private String mTittle;
	private static final String BUNDLE_TITLE = "title";

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		Bundle arguments = getArguments();
		if (arguments != null) {
			mTittle = arguments.getString(BUNDLE_TITLE);
		}
		TextView tv = new TextView(getActivity());
		tv.setText(mTittle);
		tv.setGravity(Gravity.CENTER);
		return tv;
	}

	public static ViewPagerFragment newInstance(String tittle) {
		Bundle b = new Bundle();
		b.putString(BUNDLE_TITLE, tittle);
		ViewPagerFragment vf = new ViewPagerFragment();
		vf.setArguments(b);
		return vf;

	}
}
