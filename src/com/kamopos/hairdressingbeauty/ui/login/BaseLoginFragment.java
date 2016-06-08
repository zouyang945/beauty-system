package com.kamopos.hairdressingbeauty.ui.login;

import com.kamopos.hairdressingbeauty.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BaseLoginFragment extends Fragment{
	/**管理员登录**/
	public static final int ROOT_LOGIN=0;
	/**收银员登录**/
	public static final int CASHIER_LOGIN=1;
	public static final String LOGIN_TYPE="login_type";
	private int mCurrentType=0;
	
	public void setCurrentType(int mCurrentType) {
		this.mCurrentType = mCurrentType;
	}
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		if(getArguments()!=null){
			mCurrentType=getArguments().getInt(LOGIN_TYPE, 0);
		}
		
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView=inflater.inflate(R.layout.fragment_login_layout, null);
		rootView.findViewById(R.id.other_info).setVisibility(mCurrentType==0?View.VISIBLE:View.INVISIBLE);
		return rootView;
	}

}
