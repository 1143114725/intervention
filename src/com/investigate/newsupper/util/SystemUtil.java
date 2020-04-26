package com.investigate.newsupper.util;

import java.util.Locale;

import android.app.Activity;
import android.content.Context;
import android.telephony.TelephonyManager;

/**
 * 系统工具类
 */
public class SystemUtil {
	/**
	 * 获取当前手机系统语言。
	 * 
	 * @return 返回当前系统语言。例如：当前设置的是“中文-中国”，则返回“zh-CN”
	 */
	public static String getSystemLanguage() {
		return Locale.getDefault().getLanguage();
	}

	/**
	 * 获取当前系统上的语言列表(Locale列表)
	 * 
	 * @return 语言列表
	 */
	public static Locale[] getSystemLanguageList() {
		return Locale.getAvailableLocales();
	}

	/**
	 * 获取当前手机系统版本号
	 * 
	 * @return 系统版本号
	 */
	public static String getSystemVersion() {
		System.out.println("系统版本号 = " + android.os.Build.VERSION.RELEASE);
		return android.os.Build.VERSION.RELEASE;
	}

	/**
	 * 获取手机型号
	 * 
	 * @return 手机型号
	 */
	public static String getSystemModel() {
		System.out.println("手机型号 = " + android.os.Build.MODEL);
		return android.os.Build.MODEL;
	}

	/**
	 * 获取手机厂商
	 * 
	 * @return 手机厂商
	 */
	public static String getDeviceBrand() {
		System.out.println("手机厂商 = " + android.os.Build.BRAND);
		return android.os.Build.BRAND;
	}

	/**
	 * 获取手机IMEI(需要“android.permission.READ_PHONE_STATE”权限)
	 * 
	 * @return 手机IMEI
	 */
	public static String getIMEI(Context ctx) {
		TelephonyManager tm = (TelephonyManager) ctx.getSystemService(Activity.TELEPHONY_SERVICE);
		if (tm != null) {
			return tm.getDeviceId();
		}
		return null;
	}
}
