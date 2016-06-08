package com.kamopos.hairdressingbeauty.ui.storemanagement;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.kamopos.hairdressingbeauty.R;
import com.kamopos.hairdressingbeauty.ui.BaseActionbarActivity;

public class StoreManagementActivity extends BaseActionbarActivity{
	private TicketSettingFragment mTicketSettingFragment;
	private CashierManagementFragment mCashierManagementFragment;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_store_management_layout);
		initActionbar();
		//testTicketSettingFragment();
		testCashierManagementFragment();
	}
	private void initActionbar(){
		getTopView().setTitle(R.string.store_management);
	}
	/**
	 * ����СƱ���ý���
	 */
	private void testTicketSettingFragment(){
		getTopView().setTitle(R.string.ticket_set);
		mTicketSettingFragment=new TicketSettingFragment();
		replaceFragment(mTicketSettingFragment);
		getTopView().setFuncationBtnVisable(View.VISIBLE);
		getTopView().setFunctionBtn("Ԥ��", new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				preview();
			}
		});
	}
	/**
	 * ��������Ա����
	 */
	private void testCashierManagementFragment(){
		getTopView().setTitle(R.string.cashier_management);
		mCashierManagementFragment=new CashierManagementFragment();
		replaceFragment(mCashierManagementFragment);
	}
	/**
	 * �滻�ŵ������������
	 * @param ft  Ҫ�滻������
	 */
	private void replaceFragment(Fragment ft) {
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.add_content, ft).commit();

	}
	/**
	 * Ԥ��
	 */
	private void preview(){
		if(mTicketSettingFragment!=null){
			mTicketSettingFragment.preview();
		}
	}
	
}
