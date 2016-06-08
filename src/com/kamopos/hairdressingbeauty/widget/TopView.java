package com.kamopos.hairdressingbeauty.widget;

import com.kamopos.hairdressingbeauty.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * 自定义头部状态栏
 * 
 * @author
 * 
 */
public class TopView extends RelativeLayout {
	private Context mContext;
	private View mRootView;
	private ImageView mIconBack;
	private TextView mTitle;
	private View.OnClickListener mBackListener;
	private Button mFunctionBtn;
	private LinearLayout mCustomRightLayout;

	public TopView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(context);
	}

	public TopView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	public TopView(Context context) {
		super(context);
		init(context);
	}

	private void init(Context context) {
		this.mContext = context;
		mRootView = View.inflate(context, R.layout.desgin_top_layout, this);
		mIconBack = (ImageView) mRootView.findViewById(R.id.up_icon);
		mTitle = (TextView) mRootView.findViewById(R.id.commect_title);
		mFunctionBtn=(Button) mRootView.findViewById(R.id.function_btn);
		mCustomRightLayout=(LinearLayout) mRootView.findViewById(R.id.custom_right_layout);
		setupAction();
	}

	private void setupAction() {

	}
	/**
	 * 设置顶部状态栏右边按钮文字，点击事件
	 * @param title
	 * @param listener
	 */
	public void setFunctionBtn(String title,View.OnClickListener listener){
		mFunctionBtn.setText(title);
		mFunctionBtn.setOnClickListener(listener);
	}
	/**
	 * 设置顶部右边按钮是否可见
	 * @param visibility
	 */
	public void setFuncationBtnVisable(int visibility){
		mFunctionBtn.setVisibility(visibility);
	}
	/**
	 * 设置顶部状态栏右边按钮文字，点击事件
	 * @param resId
	 * @param listener
	 */
	public void setFunctionBtn(int resId,View.OnClickListener listener){
		mFunctionBtn.setText(resId);
		mFunctionBtn.setOnClickListener(listener);
	}
	/**
	 * 头部返回键监听
	 * 
	 * @param backListener
	 */
	public void setBackListener(View.OnClickListener backListener) {
		this.mBackListener = backListener;
		if (mBackListener != null) {
			mRootView.findViewById(R.id.up_icon).setOnClickListener(
					mBackListener);
		}
	}

	/**
	 * 设置头部文字
	 * 
	 * @param resId
	 */
	public void setTitle(int resId) {
		if (resId == -1) {
			return;
		}
		mTitle.setText(resId);
	}

	/**
	 * 设置头部文字
	 * 
	 * @param resId
	 */
	public void setTitle(CharSequence ses) {
		if (ses == null) {
			return;
		}
		mTitle.setText(ses);
	}

	/**
	 * 设置头部返回键是否显示
	 * 
	 * @param visiable
	 */
	public void setBackIconView(boolean visiable) {
		mIconBack.setVisibility(visiable ? View.VISIBLE : View.GONE);
	}

	/**
	 * 设置头部文字是否显示
	 * 
	 * @param visiable
	 */
	public void setTitleVisibility(boolean visiable) {
		mTitle.setVisibility(visiable ? View.VISIBLE : View.GONE);
	}
	/**
	 * 设置右边区域自定义视图
	 * @param v
	 */
	public void setCustomRightView(View v){
		mCustomRightLayout.addView(v);
		mCustomRightLayout.setVisibility(View.VISIBLE);
	}
	/**
	 * 设置右边区域自定义视图显示或者隐藏
	 * @param visibility
	 */
	public void setCustomRightViewVisable(int visibility){
		mCustomRightLayout.setVisibility(visibility);
	}
}
