package com.kamopos.hairdressingbeauty.ui;

import com.kamopos.hairdressingbeauty.R;
import com.kamopos.hairdressingbeauty.widget.TopView;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
public class BaseActionbarActivity extends FragmentActivity{
	private View rootView;
	private TopView mTopView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

    @Override
    public void setContentView(int layoutResID) {
        initBaseView(View.inflate(this, layoutResID, null), null);
    }
    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void setContentView(View view) {
        initBaseView(view, null);
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        initBaseView(view, params);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
	/**
     * rootview
     */
    private void initBaseView(View view, ViewGroup.LayoutParams params) {
        rootView = View.inflate(this, R.layout.base_actionbar_activity_layout, null);
        rootView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        if (params == null)
            params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        ((ViewGroup) rootView.findViewById(R.id.content)).addView(view, params);
        mTopView = (TopView) rootView.findViewById(R.id.materinal_design_top);
        super.setContentView(rootView);
    }
    /**
     * 获取头部视图
     * @return
     */
    public TopView getTopView(){
    	return mTopView;
    }
    public View getRootView(){
    	return rootView;
    }
}
