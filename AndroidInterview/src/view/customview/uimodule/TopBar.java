package view.customview.uimodule;

import com.example.androidinterview.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class TopBar extends RelativeLayout {
	private TextView tv;
	private Button btn;

	private String btnText;
	private int btncolor;
	private Drawable btnBackground;

	private String text;
	private float textSize;
	private int textColor;

	private LayoutParams btnLayoutParams;
	private LayoutParams tvLayoutParams;

	private BtnClickListener listener;

	public interface BtnClickListener {
		public void onClick();
	}

	public void setOnBtnClickListener(BtnClickListener listener) {
		this.listener = listener;
	}

	public TopBar(Context context, AttributeSet attrs) {
		super(context, attrs);
		TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.topbar);
		btnText = typedArray.getString(R.styleable.topbar_leftText);
		btncolor = typedArray.getColor(R.styleable.topbar_leftTextColor, 0);
		btnBackground = typedArray.getDrawable(R.styleable.topbar_leftBackground);
		text = typedArray.getString(R.styleable.topbar_tittle);
		textSize = typedArray.getDimension(R.styleable.topbar_textSize, 0);
		textColor = typedArray.getColor(R.styleable.topbar_textColor, 0);
		typedArray.recycle();

		btn = new Button(context);
		tv = new TextView(context);

		btn.setTextColor(btncolor);
		btn.setText(btnText);
		btn.setBackgroundDrawable(btnBackground);

		tv.setText(text);
		tv.setTextSize(textSize);
		tv.setTextColor(textColor);
		tv.setGravity(Gravity.CENTER);

		btnLayoutParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
		btnLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
		tvLayoutParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
		tvLayoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);

		setBackgroundColor(getResources().getColor(android.R.color.holo_blue_bright));
		addView(btn, btnLayoutParams);
		addView(tv, tvLayoutParams);

		btn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				listener.onClick();
			}
		});
	}

}
