package com.kamopos.hairdressingbeauty.app;

import android.app.Application;
import android.os.Handler;

public abstract class BaseApplication extends Application {
	/**
	 * applicaton instrance
	 */
	private static BaseApplication mInstrance;
	/**
	 * the main ui thread
	 */
	private Thread mUiThread;
	/**
	 * the main ui handler
	 */
	private Handler mHandler;

	/**
	 * Gettor of app instarance
	 * 
	 * @return BaseApplication
	 */
	public static BaseApplication getInstrance() {
		return mInstrance;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		mUiThread = Thread.currentThread();
		mHandler = new Handler();
		mInstrance = this;
		setup();
	}

	/**
	 * 程序运行初始化
	 */
	protected abstract void setup();

	/**
	 * (non-Javadoc)
	 * 
	 * @see android.app.Application#onTerminate()
	 */
	@Override
	public void onTerminate() {
		super.onTerminate();
	}

	/**
	 * Runs the specified action on the UI thread. If the current thread is the
	 * UI thread, then the action is executed immediately. If the current thread
	 * is not the UI thread, the action is posted to the event queue of the UI
	 * thread.
	 * 
	 * @param runnable
	 *            the action to run on the UI thread
	 */
	public void runOnUiThread(Runnable runnable) {
		if (mUiThread == Thread.currentThread()) {
			runnable.run();
		} else {
			mHandler.post(runnable);
		}
	}

}
