package components.activity.fragment;

import com.example.androidinterview.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class MyFragment2 extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_my1, container, false);
		TextView findViewById = (TextView) view.findViewById(R.id.textView);
		findViewById.setText("MyFragment2");
		Button btn = (Button) view.findViewById(R.id.btn);
		btn.setText("this is a new button");
		return view;
	}
}
