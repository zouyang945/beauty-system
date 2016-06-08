package com.kamopos.hairdressingbeauty.ui.cashier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kamopos.hairdressingbeauty.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.SimpleAdapter;

/**
 * 单个消费项（服务种类/商品种类）
 * @author Administrator
 *
 */
public class BaseConsumeritemsFragment extends Fragment{
	private GridView mConsumerItems;
	public static final String DATA_SOURCE="data_source";
	private int mCurrentDataSource=0;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if(getArguments()!=null){
			mCurrentDataSource=getArguments().getInt(DATA_SOURCE, 0);
		}
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView=inflater.inflate(R.layout.fragment_base_service_layout, null);
		initView(rootView);
		return rootView;
	}
	private void initView(View rootView){
		mConsumerItems=(GridView) rootView.findViewById(R.id.base_item);
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> item = new HashMap<String, Object>();
		item.put("title", mCurrentDataSource==0?"洗剪吹":"发胶");
		list.add(item);
		item.put("title", mCurrentDataSource==0?"洗吹":"护发素");
		list.add(item);
		item.put("title", mCurrentDataSource==0?"单剪":"染发剂");
		list.add(item);
		SimpleAdapter ss=new SimpleAdapter(getActivity(), list, android.R.layout.simple_list_item_2, new String[]{"title"}, 
				new int[]{android.R.id.text1});
		mConsumerItems.setAdapter(ss);
	}
}
