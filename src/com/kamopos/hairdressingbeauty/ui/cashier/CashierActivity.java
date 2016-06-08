package com.kamopos.hairdressingbeauty.ui.cashier;

import com.kamopos.hairdressingbeauty.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

public class CashierActivity extends FragmentActivity {
	private CashierInfoFragment mCashierInfoFragment;
	private ServiceCommodityFragment mServiceCommodityFragment;
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.activity_cashier_layout);
		initView();
		initFragment();
	}

	private void initView() {
		mCashierInfoFragment = ((CashierInfoFragment) getSupportFragmentManager()
				.findFragmentById(R.id.menu_fragment));
	}
	/**
	 * ��ʼ����Ʒ/�����б�
	 */
	private void initFragment(){
		mServiceCommodityFragment=new ServiceCommodityFragment();
		replaceFragment(mServiceCommodityFragment);
	}
	/**
	 * �滻���������ұ�����
	 * @param ft  Ҫ�滻������
	 */
	private void replaceFragment(Fragment ft) {
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.add_cashier_content, ft).commit();

	}
}
