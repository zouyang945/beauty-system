package com.kamopos.hairdressingbeauty.util;

import java.util.HashMap;
import java.util.Map;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;

/**
 * The class <code>OutOfUiThread</code>
 * <p>
 * ������UI�̵߳�LoopThread
 * 
 */
public class OutOfUiThreadUtil {
	private static Map<String, OutOfUiLooperThread> mOutOfUiLooperThreadMap = new HashMap<String, OutOfUiLooperThread>();
	private final static int MAX_SIZE = 20;

	public static synchronized OutOfUiLooperThread getOrCreateThread(String key) {
		OutOfUiLooperThread thread = mOutOfUiLooperThreadMap.get(key);
		if (thread == null) {
			thread = new OutOfUiLooperThread(key);
			thread.start();
			mOutOfUiLooperThreadMap.put(key, thread);
			if (mOutOfUiLooperThreadMap.size() >= MAX_SIZE) {
				// ��������̳߳�
				throw new RuntimeException(
						"Don't to create too much OutOfUiLooperThread!");
			}
		}
		return thread;
	}

	public static synchronized boolean destoryThread(String key) {
		OutOfUiLooperThread thread = mOutOfUiLooperThreadMap.get(key);
		if (thread != null) {
			thread.quit();
			mOutOfUiLooperThreadMap.remove(key);
			return true;
		}
		return false;
	}

	/**
	 * 
	 * The class <code>LooperThread</code> <br>
	 * ���ɹ�����ڣ��������A/Looper(4946): Could not create epoll instance. errno=24 �쳣
	 * 
	 */
	public static class OutOfUiLooperThread extends HandlerThread implements
			Callback {

		/**
		 * Constructor
		 * 
		 * @param pos
		 */
		public OutOfUiLooperThread(String name) {
			super(name);
		}

		private Handler mOutuiHandler;
		private Callback mCallback;

		public Handler getAndWaitForHandler() {
			// getLooper�ڲ������жϵȺ�
			if (mOutuiHandler == null) {
				mOutuiHandler = new Handler(this.getLooper(), this);
			}
			return mOutuiHandler;
		}

		/**
		 * (non-Javadoc)
		 * 
		 * @see Callback#handleMessage(Message)
		 */
		@Override
		public boolean handleMessage(Message msg) {
			if (mCallback != null)
				return mCallback.handleMessage(msg);
			return false;
		}

		public Callback getCallback() {
			return mCallback;
		}

		public void setCallback(Callback mCallback) {
			this.mCallback = mCallback;
		}

	}

}
