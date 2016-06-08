package com.kamopos.hairdressingbeauty.ui.cashier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kamopos.hairdressingbeauty.R;
import com.kamopos.hairdressingbeauty.ui.WelcomeActivity.MyAdapter;
import com.kamopos.hairdressingbeauty.ui.login.BaseLoginFragment;
import com.kamopos.hairdressingbeauty.widget.PagerSlidingTabStrip;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.SimpleAdapter;

/**
 * 服务商品
 * 
 * @author Administrator
 * 
 */
public class ServiceCommodityFragment extends Fragment implements
		View.OnClickListener {
	PagerSlidingTabStrip tabs;
	ViewPager pager;
	DisplayMetrics dm;
	String[] titles = new String[2];
	BaseConsumeritemsFragment mServiceFragment, mProductFragment;
	private Button mReceivablesBtn, mRecharge, mExchangeBtn, mReturn_cards;
	private ImageView mPopupData;
	private OnConsumptionChange mOnConsumptionChange;

	public void setOnConsumptionChange(OnConsumptionChange mOnConsumptionChange) {
		this.mOnConsumptionChange = mOnConsumptionChange;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		dm = getResources().getDisplayMetrics();
		titles[0] = getString(R.string.service);
		titles[1] = getString(R.string.product);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater
				.inflate(R.layout.fragment_service_layout, null);
		initView(rootView);
		return rootView;
	}

	private void initView(View rootView) {
		pager = (ViewPager) rootView.findViewById(R.id.pager);
		tabs = (PagerSlidingTabStrip) rootView.findViewById(R.id.tabs);
		mReceivablesBtn = (Button) rootView.findViewById(R.id.receivables);
		mRecharge = (Button) rootView.findViewById(R.id.recharge);
		mExchangeBtn = (Button) rootView.findViewById(R.id.exchange);
		mReturn_cards = (Button) rootView.findViewById(R.id.return_cards);
		mPopupData = (ImageView) rootView.findViewById(R.id.popup_data);
		pager.setAdapter(new MyAdapter(getActivity()
				.getSupportFragmentManager(), titles));
		tabs.setViewPager(pager);
		initAction();
	}

	private void initAction() {
		mReceivablesBtn.setOnClickListener(this);
		mRecharge.setOnClickListener(this);
		mExchangeBtn.setOnClickListener(this);
		mReturn_cards.setOnClickListener(this);
		mPopupData.setOnClickListener(this);
	}

	public class MyAdapter extends FragmentPagerAdapter {
		String[] _titles;

		public MyAdapter(FragmentManager fm, String[] titles) {
			super(fm);
			_titles = titles;
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
				if (mServiceFragment == null) {
					mServiceFragment = new BaseConsumeritemsFragment();
					bundle = new Bundle();
					bundle.putInt(BaseConsumeritemsFragment.DATA_SOURCE, 0);
					mServiceFragment.setArguments(bundle);
				}
				return mServiceFragment;
			case 1:
				if (mProductFragment == null) {
					mProductFragment = new BaseConsumeritemsFragment();
					bundle = new Bundle();
					bundle.putInt(BaseConsumeritemsFragment.DATA_SOURCE, 1);
					mProductFragment.setArguments(bundle);
				}
				return mProductFragment;

			default:
				return null;
			}
		}
	}

	@Override
	public void onClick(View arg0) {
		switch (arg0.getId()) {
		case R.id.receivables:// 收款
			if(mOnConsumptionChange!=null){
				mOnConsumptionChange.receivables();
			}
			break;
		case R.id.recharge:// 充值
			if(mOnConsumptionChange!=null){
				mOnConsumptionChange.recharge();
			}
			break;
		case R.id.exchange:// 积分兑换
			if(mOnConsumptionChange!=null){
				mOnConsumptionChange.exchange();
			}
			break;
		case R.id.return_cards:// 退卡
			if(mOnConsumptionChange!=null){
				mOnConsumptionChange.return_cards();
			}
			break;
		case R.id.popup_data:// 多个菜单
			showPopupData();
			break;
		default:
			break;
		}
	}
	private PopupWindow	popupWindow ;
	private void showPopupData(){
		View popupWindow_view = getActivity().getLayoutInflater().inflate(R.layout.popup_consumer_layout, null, 
				false);
		ListView mPopupData=(ListView) popupWindow_view.findViewById(R.id.popup_data);
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> item = new HashMap<String, Object>();
		item.put("title", "洗剪吹");
		list.add(item);
		item.put("title", "染发");
		list.add(item);
		item.put("title", "单剪");
		list.add(item);
		SimpleAdapter ss=new SimpleAdapter(getActivity(), list, android.R.layout.simple_list_item_2, new String[]{"title"}, 
				new int[]{android.R.id.text1});
		mPopupData.setAdapter(ss);
				// 创建PopupWindow实例
		popupWindow = new PopupWindow(popupWindow_view,  150,  LayoutParams.MATCH_PARENT, true);
		//popupWindow.setAnimationStyle(R.style.AnimationFade); 
		popupWindow.showAsDropDown(popupWindow_view);
		//popup_data
	}
	public interface OnConsumptionChange {
		public void receivables();

		public void recharge();

		public void exchange();

		public void return_cards();
	}
}
