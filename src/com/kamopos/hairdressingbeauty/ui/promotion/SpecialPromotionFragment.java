package com.kamopos.hairdressingbeauty.ui.promotion;

import com.kamopos.hairdressingbeauty.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/**
 * ÌØ¼Û´ÙÏú
 * @author 
 *
 */
public class SpecialPromotionFragment extends Fragment{
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v=inflater.inflate(R.layout.fragment_special_promotion_layout, null);
		initView(v);
		return v;
	}
	private void initView(View v){
		
	}
}
