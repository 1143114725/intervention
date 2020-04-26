package com.investigate.newsupper.util;

import java.util.ArrayList;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.Context;

	/** 服务工具类  
	*   
	* @author Administrator  
	*   
	*/  
public class ServiceUtils {  
 
   /** 
    * 判断服务是否开启 
    *  
    * @return 
    */  
   public static boolean isServiceRunning(Context context, String ServiceName) {  
       if (("").equals(ServiceName) || ServiceName == null)  
           return false;  
       ActivityManager myManager = (ActivityManager) context  
               .getSystemService(Context.ACTIVITY_SERVICE);  
       ArrayList<RunningServiceInfo> runningService = (ArrayList<RunningServiceInfo>) myManager  
               .getRunningServices(30);  
       for (int i = 0; i < runningService.size(); i++) {  
           if (runningService.get(i).service.getClassName().toString()  
                   .equals(ServiceName)) {  
               return true;  
           }  
       }  
       return false;  
   }  
}