package bwie.com.moni20180911.di;



public interface IContract {
    interface IView{
     void showData(String msg);
    }
    interface IModel{
        interface onCallBackLisenter{
          void oncallBack(String msg);
        }
      void requestData(onCallBackLisenter onClickListener);
    }
    interface IPresenter<IView>{
      void relevanceData(IView iView);
      void deleteData(IView iView);
      void infoData();
    }
}
