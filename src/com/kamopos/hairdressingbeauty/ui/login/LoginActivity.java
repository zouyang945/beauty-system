package com.kamopos.hairdressingbeauty.ui.login;

import com.kamopos.hairdressingbeauty.R;
import com.kamopos.hairdressingbeauty.ui.BaseActionbarActivity;

import android.os.Bundle;

public class LoginActivity extends BaseActionbarActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login_layout);
		setupActionBar();
	}

	private void setupActionBar() {
		getTopView().setBackIconView(false);
		getTopView().setTitle(R.string.login_title);
	}
}
