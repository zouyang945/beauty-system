package com.kamopos.hairdressingbeauty.ui.serviceproductmanagement;

import android.support.v4.app.Fragment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class BaseServiceProductListFragment extends Fragment implements
		OnClickListener {
	public static final int SERVICE_LIST = 0;
	public static final int PRODUCT_LIST = 1;
	protected OnDataChange mOnDataChange;
	protected ImageView mUpDataBnt, mDataTypeBtn, mAddDataBtn;

	public void setOnDataChange(OnDataChange l) {
		this.mOnDataChange = l;
	}

	public interface OnDataChange {
		/**
		 * 上传
		 * @param type
		 */
		public void upData(int type);
		/**
		 * 分类
		 * @param type
		 */

		public void dataType(int type);
		/**
		 * 添加
		 * @param type
		 */
		public void addData(int type);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub

	}

}
