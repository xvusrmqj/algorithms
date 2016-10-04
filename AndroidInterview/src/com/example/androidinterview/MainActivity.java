package com.example.androidinterview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import components.activity.FinishAppActivity;
import components.activity.dispatchevent.EventActivity;
import components.activity.task.SingleTaskActivity1;
import view.three_scroll_ways.ScrollActivity;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void FragmentTestActivity(View view) {
		startActivity(new Intent(this, components.activity.fragment.FragmentTestActivity.class));
	}

	public void SingleTaskActivity1(View view) {
		startActivity(new Intent(this, SingleTaskActivity1.class));
	}

	public void EventActivity(View view) {
		startActivity(new Intent(this, EventActivity.class));
	}
	public void LifeTimeActivity(View view) {
		startActivity(new Intent(this, components.activity.LifeTimeActivity.class));
	}

	public void FinishAppActivity(View view) {
		startActivity(new Intent(this, FinishAppActivity.class));
	}

	public void WindowActivity(View view) {
		startActivity(new Intent(this, components.activity.WindowActivity.class));
	}

	public void BroadcastClientActivity(View view) {
		startActivity(new Intent(this, components.broadcastreciver.BroadcastClientActivity.class));
	}

	public void MessengerClient(View view) {
		startActivity(new Intent(this, ipc.messager_test.MessengerClient.class));
	}

	public void ProviderActivity(View view) {
		startActivity(new Intent(this, ipc.contentprovider.client.ProviderActivity.class));
	}

	public void ViewPost(View view) {
		startActivity(new Intent(this, multi_thread.ViewPost.class));
	}

	public void RunOnUiThread(View view) {
		startActivity(new Intent(this, multi_thread.RunOnUiThread.class));
	}

	public void HandlerSendMsg(View view) {
		startActivity(new Intent(this, multi_thread.HandlerSendMsg.class));
	}

	public void HandlerPostRunnable(View view) {
		startActivity(new Intent(this, multi_thread.HandlerPostRunnable.class));
	}

	public void AsyncTaskTest(View view) {
		startActivity(new Intent(this, multi_thread.AsyncTaskTest.class));
	}

	public void ServiceTestActivity(View view) {
		startActivity(new Intent(this, components.service.ServiceTestActivity.class));
	}

	public void ScrollActivity(View view) {
		startActivity(new Intent(this, ScrollActivity.class));
	}

	public void AnimationActivity(View view) {
		startActivity(new Intent(this, view.three_scroll_ways.AnimationActivity.class));
	}

	public void LayoutActivity(View view) {
		startActivity(new Intent(this, view.three_scroll_ways.LayoutActivity.class));
	}

	public void CustomViewActivity(View view) {
		startActivity(new Intent(this, view.customview.CustomViewActivity.class));
	}

	public void ViewPagerActivity(View view) {
		startActivity(new Intent(this, view.viewpager.ViewPagerActivity.class));
	}
	public void ViewPagerIndicatorActivity(View view) {
		startActivity(new Intent(this, view.viewpager.custom_viewpager_indictor.ViewPagerIndicatorActivity.class));
	}

	public void GetInfoActivity(View view) {
		startActivity(new Intent(this, optimize.GetInfoActivity.class));
	}

	public void MediaplayerActivity(View view) {
		startActivity(new Intent(this, projects.mediaplayer.MediaplayerActivity.class));
	}

	public void ValueAnimatorTest(View view) {
		startActivity(new Intent(this, animation.ValueAnimatorTest.class));
	}

	public void ObjectAnimatorTest(View view) {
		startActivity(new Intent(this, animation.ObjectAnimatorTest.class));
	}

	public void BitmapActivity(View view) {
		startActivity(new Intent(this, optimize.bitmap.BitmapActivity.class));
	}
}
