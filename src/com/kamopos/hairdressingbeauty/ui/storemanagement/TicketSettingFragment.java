package com.kamopos.hairdressingbeauty.ui.storemanagement;

import com.kamopos.hairdressingbeauty.R;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

public class TicketSettingFragment extends Fragment{
	private AlertDialog mPreviewDailog;
	private DisplayMetrics dm;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		dm = getResources().getDisplayMetrics();
		initData();
	}
	/**
	 * 从数据库中去除门店信息数据
	 */
	private void initData(){
		
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v=inflater.inflate(R.layout.fragment_ticket_set_layout, null);
		initView(v);
		return v;
	}
	private void initView(View v){
		updataView();
	}
	/**
	 * 通过数据更新视图
	 */
	private void updataView(){
		
	}
	/**
	 * 预览小票
	 */
	public void preview(){
		if(mPreviewDailog!=null&&mPreviewDailog.isShowing()){
			mPreviewDailog.dismiss();
			mPreviewDailog=null;
		}
		AlertDialog.Builder ab=new AlertDialog.Builder(getActivity());
		View dialogView=LayoutInflater.from(getActivity()).inflate(R.layout.preview_ticket_set_dialog_layout, null);
		ab.setView(dialogView);
		mPreviewDailog=ab.create();
		mPreviewDailog.show();
		WindowManager.LayoutParams lp=mPreviewDailog.getWindow().getAttributes();
		lp.width=dm.widthPixels/4;
		mPreviewDailog.getWindow().setAttributes(lp);
	}
}
