package com.kamopos.hairdressingbeauty.ui.storemanagement;

import java.util.ArrayList;
import java.util.List;

import com.kamopos.hairdressingbeauty.R;
import com.kamopos.hairdressingbeauty.vo.Cashier;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class CashierManagementFragment extends Fragment {
	private ListView mCashierListView;
	private List<Cashier> mCashierList;
	private CashierListAdapter mCashierListAdapter;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initData();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view=inflater.inflate(R.layout.fragment_cashier_management_layout, null);
		initView(view);
		return view;
	}
	private void initData(){
		mCashierList=new ArrayList<Cashier>();
		Cashier cashier;
		for (int i = 0; i < 3; i++) {
			cashier=new Cashier();
			cashier.setAccount("15161654651");
			cashier.setUserName("张三");
			cashier.setStaffWork("收营员");
			cashier.setEmployeeRow("男");
			mCashierList.add(cashier);
		}
	}
	private void initView(View v){
		mCashierListView=(ListView) v.findViewById(R.id.cashier_list);
		mCashierListAdapter=new CashierListAdapter(mCashierList);
		mCashierListView.setAdapter(mCashierListAdapter);
	}
	private class CashierListAdapter extends BaseAdapter{
		List<Cashier> mCashierList;
		public CashierListAdapter(List<Cashier> list){
			this.mCashierList=list;
		}
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return mCashierList.size();
		}

		@Override
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return mCashierList.get(arg0);
		}

		@Override
		public long getItemId(int arg0) {
			// TODO Auto-generated method stub
			return arg0;
		}

		@Override
		public View getView(int arg0, View arg1, ViewGroup arg2) {
			View view=View.inflate(getActivity(), R.layout.item_cashier_management_layout, null);
			TextView cashier_account=(TextView) view.findViewById(R.id.cashier_account);
			TextView cashier_name=(TextView) view.findViewById(R.id.cashier_name);
			TextView cashier_type=(TextView) view.findViewById(R.id.cashier_type);
			TextView cashier_sex=(TextView) view.findViewById(R.id.cashier_sex);
			Cashier cashier=mCashierList.get(arg0);
			if(cashier!=null){
				cashier_account.setText(cashier.getAccount());
				cashier_name.setText(cashier.getUserName());
				cashier_type.setText(cashier.getStaffWork());
				cashier_sex.setText(cashier.getEmployeeRow());
			}
			return view;
		}
		
	}
}
