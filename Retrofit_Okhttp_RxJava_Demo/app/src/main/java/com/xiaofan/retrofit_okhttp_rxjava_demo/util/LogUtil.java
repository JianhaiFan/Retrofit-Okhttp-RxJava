package com.xiaofan.retrofit_okhttp_rxjava_demo.util;

import android.util.Log;

import java.util.Map;

/**
 * @author: 范建海
 * @createTime: 2016/12/6 15:54
 * @className:  LogUtil
 * @description: 日志输入文件
 * @changed by:
 */
public class LogUtil {
	// 其他日志TAG
	public static final String TAG = "yxck";
	// 请求服务器日志TAG
	public static final String NET_TAG = "OkHttpUtil";
	
	public static final boolean bOpenLog = true;


	public static int d(String msg) {
		if (bOpenLog) {
			return Log.d(TAG, msg);
		} else {
			return 0;
		}
	}

	public static int d(String tag, String msg) {
		if (bOpenLog) {
			return Log.d(TAG, tag + ":" +msg);
		} else {
			return 0;
		}
	}
	
	public static int d(String tag, String msg, boolean mark) {
		if (bOpenLog) {
			if(mark){
			  return Log.d(tag,msg);
			}else{
			  return Log.d(TAG, tag + ":" +msg);
			}
		} else {
			return 0;
		}
	}

	public static int i(String tag, String msg) {
		if (bOpenLog) {
			return Log.i(TAG, tag + " ===== " +msg);
		} else {
			return 0;
		}
	}
	
	public static int i(String msg) {
		if (bOpenLog) {
			return Log.i(TAG, msg);
		} else {
			return 0;
		}
	}

	public static int w(String msg) {
		if (bOpenLog) {
			return Log.w(TAG, msg);
		} else {
			return 0;
		}
	}

	public static int e(String msg) {
		if (bOpenLog) {
		    int ret = Log.e(TAG, msg);
			return ret;
		} else {
			return 0;
		}
	}

	public static int e(Throwable e) {
		if (bOpenLog) {
		    int ret = Log.e(TAG, "", e);
			return ret;
		} else {
			return 0;
		}
	}

	public static int e(String tag, String msg) {
		if (bOpenLog) {
            int ret = Log.e(TAG, tag + ":" + msg);
			return ret;
		} else {
			return 0;
		}
	}

	public static int e(String msg, Throwable e) {
		if (bOpenLog) {
            int ret = Log.e(TAG, msg, e);
			return ret;
		} else {
			return 0;
		}
	}

	/**
	 * 输出日志信息
	 */
	public static void printParams(String url, Map<String,String> params, String accessToken) {
		if (bOpenLog) {
			LogUtil.e(NET_TAG,"======================start================================");
			LogUtil.i(NET_TAG,"(header) accessToken --> "+ accessToken);
			LogUtil.i(NET_TAG,"url --> " + url);
			LogUtil.i(NET_TAG,"json --> "+"Y");
			if (params != null) {
				for (Map.Entry<String,String> param : params.entrySet()) {
					LogUtil.i(NET_TAG,param.getKey() +" --> "+param.getValue());
				}
			}
			LogUtil.e(NET_TAG,"======================end==================================");
		}
	}
}
