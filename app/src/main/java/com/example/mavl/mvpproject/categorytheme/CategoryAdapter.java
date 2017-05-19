package com.example.mavl.mvpproject.categorytheme;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.mavl.mvpproject.ListViewBaseAdapter;
import com.example.mavl.mvpproject.R;
import com.example.mavl.mvpproject.Utils.ImageLoaderUtil;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

import java.util.List;


public class CategoryAdapter extends ListViewBaseAdapter<Category> {

    public static final int PREVIEW_DISPLAY_WIDTH = 200;
    public static final int PREVIEW_DISPLAY_HEIGHT = 144;

    public CategoryAdapter(Context context, List<Category> list) {
        super(context, list);
    }

    @Override
    public View createView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder ;
        if(convertView == null){
            convertView = mInflater.inflate(R.layout.category_item,parent,false);
            holder = new ViewHolder();
            holder.des = (TextView) convertView.findViewById(R.id.category_des);
            holder.image = (ImageView) convertView.findViewById(R.id.category_image);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.des.setText(list.get(position).getDes());
        ImageSize size = new ImageSize(PREVIEW_DISPLAY_WIDTH,
                PREVIEW_DISPLAY_HEIGHT);
        holder.image.setTag(list.get(position).getIcon());
        ImageLoaderUtil.loadImage(list.get(position).getIcon(), size, new SimpleImageLoadingListener() {
            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                super.onLoadingComplete(imageUri, view, loadedImage);
                if (imageUri.equals(holder.image.getTag())) {
                    holder.image.setImageBitmap(loadedImage);
                }
            }

            @Override
            public void onLoadingStarted(String imageUri, View view) {
                super.onLoadingStarted(imageUri, view);
                holder.image.setImageResource(R.drawable.image_loaded_by_default);
            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                super.onLoadingFailed(imageUri, view, failReason);
                holder.image.setImageResource(R.drawable.image_loaded_by_default);
            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {
                super.onLoadingCancelled(imageUri, view);
                holder.image.setImageResource(R.drawable.image_loaded_by_default);
            }
        });
        return convertView;
    }
    static class ViewHolder{
        TextView des;
        ImageView image;
    }
}
