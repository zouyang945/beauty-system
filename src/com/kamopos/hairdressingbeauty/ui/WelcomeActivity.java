package com.kamopos.hairdressingbeauty.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kamopos.hairdressingbeauty.R;
import com.kamopos.hairdressingbeauty.ui.login.BaseLoginFragment;
import com.kamopos.hairdressingbeauty.widget.PagerSlidingTabStrip;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class WelcomeActivity extends FragmentActivity {
	PagerSlidingTabStrip tabs;
	ViewPager pager;
	DisplayMetrics dm;
	BaseLoginFragment afrag,bfrag;
	String[] titles=new String[2] ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome_layout);
		initView();
		//≤‚ ‘¥˙¬Î
//		ListView testListView = (ListView) findViewById(R.id.stripe_listview);
//		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
//		Map<String, Object> item = new HashMap<String, Object>();
//		item.put("title", "Item-1");
//		list.add(item);
//		item.put("title", "Item-2");
//		list.add(item);
//		item.put("title", "Item-3");
//		list.add(item);
//		SimpleAdapter ss=new SimpleAdapter(this, list, android.R.layout.simple_list_item_2, new String[]{"title"}, 
//				new int[]{android.R.id.text1});
//		testListView.setAdapter(ss);
	}
	private void initView(){
		dm = getResources().getDisplayMetrics();
		pager = (ViewPager) findViewById(R.id.pager);
		tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
		titles[0]=getString(R.string.root_login);
		titles[1]=getString(R.string.cashier_login);
		pager.setAdapter(new MyAdapter(getSupportFragmentManager(),titles));
		tabs.setViewPager(pager);
	}
	public class MyAdapter extends FragmentPagerAdapter{
		String[] _titles;
		public MyAdapter(FragmentManager fm,String[] titles) {
			super(fm);
			_titles=titles;
		}
		
		@Override
		public CharSequence getPageTitle(int position) {
			return _titles[position];
		}
		
		@Override
		public int getCount() {
			return _titles.length;
		}

		@Override
		public Fragment getItem(int position) {
			Bundle bundle;
			switch (position) {
			case 0:
				if (afrag == null) {
					afrag = new BaseLoginFragment();
					bundle=new Bundle();
					bundle.putInt(BaseLoginFragment.LOGIN_TYPE, BaseLoginFragment.ROOT_LOGIN);
					afrag.setArguments(bundle);
				}
				return afrag;
			case 1:
				if (bfrag == null) {
					bfrag = new BaseLoginFragment();
					bundle=new Bundle();
					bundle.putInt(BaseLoginFragment.LOGIN_TYPE, BaseLoginFragment.CASHIER_LOGIN);
					bfrag.setArguments(bundle);
				}
				return bfrag;
			
			default:
				return null;
			}
		}
	}
}
