package com.kamopos.hairdressingbeauty.ui.cashier;

import com.kamopos.hairdressingbeauty.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class CashierInfoFragment extends Fragment implements
		View.OnClickListener {
	private Button mFindMemberBtn, mClearBtn, mTakeSingleBnt;
	//private ListView mCashierList;
	private OnCashierUpChanger mOnCashierUpChanger;

	public void setOnCashierUpChanger(OnCashierUpChanger mOnCashierUpChanger) {
		this.mOnCashierUpChanger = mOnCashierUpChanger;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_cashier_info_layout,
				null);
		initView(rootView);
		initAction();
		return rootView;
	}

	private void initView(View rootView) {
		mFindMemberBtn = (Button) rootView.findViewById(R.id.find_member);
		mClearBtn = (Button) rootView.findViewById(R.id.clear);
		mTakeSingleBnt = (Button) rootView.findViewById(R.id.take_single);
		
	}

	private void initAction() {
		mFindMemberBtn.setOnClickListener(this);
		mClearBtn.setOnClickListener(this);
		mTakeSingleBnt.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		switch (arg0.getId()) {
		case R.id.find_member://查找会员
			if(mOnCashierUpChanger!=null){
				mOnCashierUpChanger.findMember();
			}
			break;
		case R.id.clear://清除
			if(mOnCashierUpChanger!=null){
				mOnCashierUpChanger.clearCashier();
			}
			break;
		case R.id.take_single://取单
			if(mOnCashierUpChanger!=null){
				mOnCashierUpChanger.takeSingle();
			}
			break;

		default:
			break;
		}
	}
	public interface OnCashierUpChanger{
		public void clearCashier();
		public void takeSingle();
		public void findMember();
		public void updataCashier();//服务或者商品
	}
}
