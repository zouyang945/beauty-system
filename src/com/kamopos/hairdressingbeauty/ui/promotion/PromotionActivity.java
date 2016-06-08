package com.kamopos.hairdressingbeauty.ui.promotion;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.kamopos.hairdressingbeauty.R;
import com.kamopos.hairdressingbeauty.ui.BaseActionbarActivity;
/**
 * 推广促销
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
		getTopView().setTitle("推广促销");
	}
	/**
	 * 替换门店管理下面区域
	 * @param ft  要替换的内容
	 */
	private void replaceFragment(Fragment ft) {
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.add_content, ft).commit();

	}
	/**
	 * 测试特价促销界面
	 */
	private void testSpecialPromotion(){
		SpecialPromotionFragment mSpecialPromotionFragment=new SpecialPromotionFragment();
		replaceFragment(mSpecialPromotionFragment);
		getTopView().setTitle("特价促销");
	}
}
