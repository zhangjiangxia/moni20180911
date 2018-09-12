package bwie.com.moni20180911.data.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import bwie.com.moni20180911.R;
import bwie.com.moni20180911.data.bean.Infobean;
import bwie.com.moni20180911.ui.MainActivity;

public class SbBaseAdapet extends RecyclerView.Adapter<SbBaseAdapet.Subhodel> {
    onitmeonClickLinsenter onitmeonClickLinsenter;

    public interface onitmeonClickLinsenter{
     void onitmeclick(int layoutPosition);
 }

    public void setOnitmeonClickLinsenter(SbBaseAdapet.onitmeonClickLinsenter onitmeonClickLinsenter) {
        this.onitmeonClickLinsenter = onitmeonClickLinsenter;
    }


  public List<Infobean.DataBean> data;
  public Context context;

    public SbBaseAdapet(List<Infobean.DataBean> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public Subhodel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.recycler_itme, parent, false);
        Subhodel subhodel = new Subhodel(inflate);
        return subhodel;
    }

    @Override
    public void onBindViewHolder(@NonNull Subhodel holder, int position) {
        String[] split = data.get(position).getImages().split("\\|");
        Picasso.with(context).load(split[0]).into(holder.rimg);
        holder.rtext.setText(data.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class Subhodel extends RecyclerView.ViewHolder implements View.OnClickListener {

        private  ImageView rimg;
        private  TextView rtext;

        public Subhodel(View itemView) {
            super(itemView);
            rimg = itemView.findViewById(R.id.r_img);
            rtext = itemView.findViewById(R.id.r_text);
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
//            onitmeonClickLinsenter.onitmeclick(getLayoutPosition()-1);
            //获取当前条目位置
            int layoutPosition = getLayoutPosition();
            //Toast.makeText(context, "layoutPosition:" + layoutPosition, Toast.LENGTH_SHORT).show();
            //接口中的方法进行了执行
            onitmeonClickLinsenter.onitmeclick(getLayoutPosition()-1);
        }
    }

}
