package bwie.com.moni20180911.di.persente;

import java.lang.ref.WeakReference;

import bwie.com.moni20180911.di.IContract;
import bwie.com.moni20180911.di.model.IModeimpl;

public class IPresenterimpl implements IContract.IPresenter<IContract.IView> {
   IContract.IView iView;
    private IContract.IModel iModel;
    private WeakReference<IContract.IView> iViewWeakReference;
    private WeakReference<IContract.IModel> iModelWeakReference;

    @Override
    public void relevanceData(IContract.IView iView) {
        this.iView=iView;
        iModel = new IModeimpl();
        iViewWeakReference = new WeakReference<>(iView);
        iModelWeakReference = new WeakReference<>(iModel);
    }

    @Override
    public void deleteData(IContract.IView iView) {
        iViewWeakReference.clear();
        iModelWeakReference.clear();
    }

    @Override
    public void infoData() {
 iModel.requestData(new IContract.IModel.onCallBackLisenter() {
     @Override
     public void oncallBack(String msg) {
         iView.showData(msg);
     }
 });
    }
}
