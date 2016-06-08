package com.kamopos.hairdressingbeauty.ui.promotion;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.kamopos.hairdressingbeauty.R;
import com.kamopos.hairdressingbeauty.ui.BaseActionbarActivity;
/**
 * �ƹ����
 * @author Administrator
 *
 */
public class PromotionActivity extends BaseActionbarActivity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_promotion_layout);
		initActionbar();
		testSpecialPromotion();
	}
	private void initActionbar(){
		getTopView().setTitle("�ƹ����");
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
	 * �����ؼ۴�������
	 */
	private void testSpecialPromotion(){
		SpecialPromotionFragment mSpecialPromotionFragment=new SpecialPromotionFragment();
		replaceFragment(mSpecialPromotionFragment);
		getTopView().setTitle("�ؼ۴���");
	}
}
