package com.slidingmenu.example;

import android.annotation.TargetApi;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.ActionBar.TabListener;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.slidingmenu.lib.SlidingMenu;
import com.slidingmenu.lib.app.SlidingFragmentActivity;

@TargetApi(11)
public class ExampleActivity extends SlidingFragmentActivity implements TabListener {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		setBehindContentView(R.layout.frame);

		FragmentTransaction t = this.getFragmentManager().beginTransaction();
		t.add(R.id.frame, new SampleListFragment());
		t.commit();

		getSlidingMenu().setBehindOffsetRes(R.dimen.actionbar_home_width);
		getSlidingMenu().setBehindScrollScale(0.5f);
		getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		ActionBar actionBar = getSupportActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		actionBar.setDisplayHomeAsUpEnabled(true);
		for (int i = 0; i < 3; i++) {
			Tab tab = actionBar.newTab();
			tab.setText("Tab " + i);
			tab.setTabListener(this);
			actionBar.addTab(tab);
		}
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			toggle();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		this.getSupportMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		switch (tab.getPosition()) {
		case 0:
			findViewById(R.id.main).setBackgroundResource(android.R.color.white);
			break;
		case 1:
			findViewById(R.id.main).setBackgroundResource(android.R.color.black);
			break;
		case 2:
			findViewById(R.id.main).setBackgroundResource(android.R.color.darker_gray);
			break;
		}
	}

	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub

	}

	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTabSelected(Tab tab,
			android.support.v4.app.FragmentTransaction ft) {
		switch (tab.getPosition()) {
		case 0:
			findViewById(R.id.main).setBackgroundResource(android.R.color.white);
			break;
		case 1:
			findViewById(R.id.main).setBackgroundResource(android.R.color.black);
			break;
		case 2:
			findViewById(R.id.main).setBackgroundResource(android.R.color.darker_gray);
			break;
		}
	}

	@Override
	public void onTabUnselected(Tab tab,
			android.support.v4.app.FragmentTransaction ft) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTabReselected(Tab tab,
			android.support.v4.app.FragmentTransaction ft) {
		// TODO Auto-generated method stub

	}



}
