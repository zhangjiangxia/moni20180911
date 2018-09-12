package bwie.com.moni20180911.data.utils;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class OkhttpUtils {


   public static OkhttpUtils okhttpUtils;
    public  OkHttpClient okHttpClient;

    private OkhttpUtils(){
      if (null==okHttpClient){
          synchronized (OkHttpClient.class){
              if (null==okHttpClient){
                  okHttpClient = new OkHttpClient.Builder().build();
              }
          }
      }
    }

    public static OkhttpUtils getInstance(){
   if (null==okhttpUtils){
   synchronized (OkhttpUtils.class){
       if (null==okhttpUtils){
           okhttpUtils = new OkhttpUtils();
       }
   }
}
    return okhttpUtils;
    }

    public void get(String stringurl, Callback callback){
        Request request = new Request.Builder().url(stringurl).build();
        okHttpClient.newCall(request).enqueue(callback);
    }

}
