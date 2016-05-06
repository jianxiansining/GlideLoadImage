package com.djn.picloading.otherpicloading;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.io.File;
import java.util.List;

/**
 * Created by Administrator on 2016/5/3.
 */
public class GridAdapter extends BaseAdapter {

    private List<PicBean> picList;
    private Context context;
    public GridAdapter( Context context,List<PicBean> picList) {
        this.picList=picList;
        this.context=context;
    }

    @Override
    public int getCount() {
        return picList.size()==0?0:picList.size();
    }

    @Override
    public Object getItem(int position) {
        return picList.size()==0?null:picList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return picList.size()==0?0:position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            convertView= View.inflate(context,R.layout.view_image,null);
            holder=new ViewHolder();
            holder.iv= (ImageView) convertView.findViewById(R.id.iv);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        //TODO 设置图片显示
        PicBean picBean = picList.get(position);
        Log.d("GridAdapter", picBean.path);
        Glide.with(context)
                .load(new File(picBean.path)).into(holder.iv);
        return convertView;
    }
    private static class ViewHolder{
        public ImageView iv;
    }
}
