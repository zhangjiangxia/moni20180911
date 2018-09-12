package bwie.com.moni20180911.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import bwie.com.moni20180911.R;
import bwie.com.moni20180911.data.adapter.SbBaseAdapet;
import bwie.com.moni20180911.data.bean.Infobean;
import bwie.com.moni20180911.di.IContract;
import bwie.com.moni20180911.di.persente.IPresenterimpl;

public class MainActivity extends AppCompatActivity implements IContract.IView {

    @BindView(R.id.recyclrer_view)
    RecyclerView recyclrerView;
    private IContract.IPresenter iPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        iPresenter = new IPresenterimpl();
        iPresenter.relevanceData(this);
        iPresenter.infoData();
    }


    @Override
    public void showData(final String msg) {
runOnUiThread(new Runnable() {

    private List<Infobean.DataBean> data;
    private SbBaseAdapet adapet;

    @Override
    public void run() {

        Gson gson=new Gson();
        Infobean infobean = gson.fromJson(msg, Infobean.class);
        data = infobean.getData();
       //设置布局
        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclrerView.setLayoutManager(layoutManager);
        //列表展示
        adapet = new SbBaseAdapet(data, MainActivity.this);
        recyclrerView.setAdapter(adapet);
        adapet.setOnitmeonClickLinsenter(new SbBaseAdapet.onitmeonClickLinsenter() {
            @Override
            public void onitmeclick(int layoutPosition) {
                data.remove(layoutPosition);
                adapet.notifyDataSetChanged();
            }
        });
    }
});
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        iPresenter.deleteData(this);
    }
}
