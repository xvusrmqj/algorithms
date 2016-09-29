package components.activity.fragment;

import com.example.androidinterview.R;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MyFragment1 extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_my1, container, false);
		View btn = view.findViewById(R.id.btn);
		btn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// replace to another fragment 
				FragmentManager fm = getFragmentManager();
				fm.beginTransaction()//
						.addToBackStack(null)//
						.replace(getActivity().findViewById(R.id.root).getId(), new MyFragment2())//
						.commit();
			}
		});
		return view;
	}
}
