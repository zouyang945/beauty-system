package com.kamopos.hairdressingbeauty.ui.serviceproductmanagement;

import com.kamopos.hairdressingbeauty.R;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ServiceListFragment extends BaseServiceProductListFragment {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view=inflater.inflate(R.layout.fragment_service_list_layout,null);
		initView(view);
		return view;
	}
	private void initView(View v){
		mUpDataBnt = (ImageView) v.findViewById(R.id.up_data);
		mDataTypeBtn = (ImageView) v.findViewById(R.id.data_type);
		mAddDataBtn = (ImageView) v.findViewById(R.id.add_data);
		mUpDataBnt.setOnClickListener(this);
		mDataTypeBtn.setOnClickListener(this);
		mAddDataBtn.setOnClickListener(this);
	}
	@Override
	public void onClick(View arg0) {
		switch (arg0.getId()) {
		case R.id.up_data:
			if(mOnDataChange!=null){
				mOnDataChange.upData(BaseServiceProductListFragment.SERVICE_LIST);
			}
			break;
		case R.id.data_type:
			if(mOnDataChange!=null){
				mOnDataChange.dataType(BaseServiceProductListFragment.SERVICE_LIST);
			}
			break;
		case R.id.add_data:
			if(mOnDataChange!=null){
				mOnDataChange.addData(BaseServiceProductListFragment.SERVICE_LIST);
			}
			break;

		default:
			break;
		}
	}
	
}
