package components.activity.fragment;

import com.example.androidinterview.R;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentTestActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		final ViewGroup root = (ViewGroup) getLayoutInflater().inflate(R.layout.activity_fragmenttest, null);
		Button btn = new Button(this);
		btn.setText("start a fragment");
		btn.setId(1000);
		btn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// add a fragment in an activity
				FragmentManager manager = getFragmentManager();
				manager.beginTransaction()//
						.addToBackStack(null).add(root.getId(), new MyFragment1())//
						.commit();
			}
		});

		root.addView(btn);
		setContentView(root);
	}
}
