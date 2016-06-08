package com.kamopos.hairdressingbeauty.ui.serviceproductmanagement;

import com.kamopos.hairdressingbeauty.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
/**
 * 分类(服务/商品)
 * @author 
 *
 */
public class BaseClassifyFragment extends Fragment implements OnClickListener {
	public static final int SERVICE_TYPE = 0;
	public static final int PRODUCT_TYPE = 1;
	public static final String CLASSIFY_TYPE = "classify_type";
	private int mCurrentType;
	private ImageView mClose;
	private TextView mTitle;
	private Button mDoneBtn;
	private OnClassifyChange mOnClassifyChange;

	public void setOnClassifyChange(OnClassifyChange mOnClassifyChange) {
		this.mOnClassifyChange = mOnClassifyChange;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (getArguments() != null) {
			mCurrentType = getArguments().getInt(CLASSIFY_TYPE, 0);
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_base_classify_layout, null);
		initView(v);
		return v;
	}

	private void initView(View v) {
		mClose = (ImageView) v.findViewById(R.id.close);
		mTitle = (TextView) v.findViewById(R.id.title);
		mDoneBtn = (Button) v.findViewById(R.id.done);
		initAction();
	}

	private void initAction() {
		mTitle.setText(mCurrentType == 0 ? "服务分类" : "商品分类");
		mClose.setOnClickListener(this);
		mDoneBtn.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		switch (arg0.getId()) {
		case R.id.close:
			if (mOnClassifyChange != null) {
				mOnClassifyChange.close(mCurrentType);
			}
			break;
		case R.id.done:
			if (mOnClassifyChange != null) {
				mOnClassifyChange.done(mCurrentType);
			}
			break;

		}
	}

	public interface OnClassifyChange {
		public void close(int type);

		public void done(int type);
	}
}
