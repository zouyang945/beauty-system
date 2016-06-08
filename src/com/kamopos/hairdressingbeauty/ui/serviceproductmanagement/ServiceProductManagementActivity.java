package com.kamopos.hairdressingbeauty.ui.serviceproductmanagement;

import com.kamopos.hairdressingbeauty.R;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ServiceProductManagementActivity extends FragmentActivity
		implements ServiceProductListFragment.Callbacks,
		BaseServiceProductListFragment.OnDataChange,BaseClassifyFragment.OnClassifyChange {
	private ServiceListFragment mServiceListFragment;
	private ProductListFragment mProductListFragment;
	private AlertDialog mUpDataDialog;
	private BaseClassifyFragment mBaseClassifyFragment;
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.activity_service_product_management_layout);
		if (findViewById(R.id.add_content) != null) {
			mServiceListFragment = new ServiceListFragment();
			mServiceListFragment.setOnDataChange(this);
			replaceFragment(mServiceListFragment);
		}
	}

	/**
	 * 替换收银界面右边区域
	 * 
	 * @param ft
	 *            要替换的内容
	 */
	private void replaceFragment(Fragment ft) {
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.add_content, ft).commit();

	}

	@Override
	public void onItemSelected(int position) {
		switch (position) {
		case 0:
			mServiceListFragment = new ServiceListFragment();
			mServiceListFragment.setOnDataChange(this);
			replaceFragment(mServiceListFragment);
			break;
		case 1:
			mProductListFragment = new ProductListFragment();
			mProductListFragment.setOnDataChange(this);
			replaceFragment(mProductListFragment);
			break;

		default:
			break;
		}
	}

	@Override
	public void upData(int type) {
		if(mUpDataDialog!=null&&mUpDataDialog.isShowing()){
			mUpDataDialog.dismiss();
			mUpDataDialog=null;
		}
		AlertDialog.Builder ab=new AlertDialog.Builder(this);
		View view=View.inflate(this, R.layout.preview_updata_dialog_layout, null);
		TextView title=(TextView) view.findViewById(R.id.title);
		title.setText(type==0?"导入服务":"导入商品");
		ab.setView(view);
		ab.create();
		ab.show();
		//Toast.makeText(this, "updata:" + type, Toast.LENGTH_SHORT).show();
	}
	
	@Override
	public void dataType(int type) {
		mBaseClassifyFragment=new BaseClassifyFragment();
		Bundle bundle=new Bundle();
		bundle.putInt(BaseClassifyFragment.CLASSIFY_TYPE, type);
		mBaseClassifyFragment.setArguments(bundle);
		mBaseClassifyFragment.setOnClassifyChange(this);
		replaceFragment(mBaseClassifyFragment);
	}

	@Override
	public void addData(int type) {
		Toast.makeText(this, "addData:" + type, Toast.LENGTH_SHORT).show();
	}

	@Override
	public void close(int type) {
		onItemSelected(type);
	}

	@Override
	public void done(int type) {
		onItemSelected(type);
	}
}
