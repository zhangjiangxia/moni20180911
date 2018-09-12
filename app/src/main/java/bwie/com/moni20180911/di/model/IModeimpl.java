package bwie.com.moni20180911.di.model;

import java.io.IOException;

import bwie.com.moni20180911.data.utils.OkhttpUtils;
import bwie.com.moni20180911.di.IContract;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Response;

public class IModeimpl implements IContract.IModel {
    public static final String URLSTRING = "http://www.zhaoapi.cn/product/searchProducts?keywords=%E6%89%8B%E6%9C%BA&page=1&sort=0";


    @Override
    public void requestData(final onCallBackLisenter onClickListener) {
        OkhttpUtils.getInstance().get(URLSTRING, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                String estring = e.getMessage().toString();
                onClickListener.oncallBack(estring);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String responsestring = response.body().string().toString();
                onClickListener.oncallBack(responsestring);
            }
        });
    }
}