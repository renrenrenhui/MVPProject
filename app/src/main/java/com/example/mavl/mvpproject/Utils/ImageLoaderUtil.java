package com.example.mavl.mvpproject.Utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import com.example.mavl.mvpproject.R;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;


public class ImageLoaderUtil {
    private static BitmapFactory.Options options = new BitmapFactory.Options();
    static {
        options.inPreferredConfig = Bitmap.Config.RGB_565;
    }
    public static DisplayImageOptions DISPLAY_IMAGE_OPTIONS = new DisplayImageOptions.Builder()
            .showImageOnLoading(R.drawable.image_loaded_by_default) // resource or drawable
            .showImageForEmptyUri(R.drawable.image_loaded_by_default) // resource or drawable
            .showImageOnFail(R.drawable.image_loaded_by_default) // resource or drawable
            .cacheInMemory(true)
            .cacheOnDisk(true)
            .imageScaleType(ImageScaleType.IN_SAMPLE_INT)
            .decodingOptions(options)
            .build();

    public static void init(Context context) {
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
                .threadPoolSize(3) // default
                .threadPriority(Thread.NORM_PRIORITY - 1) // default
                .tasksProcessingOrder(QueueProcessingType.FIFO) // default
                .denyCacheImageMultipleSizesInMemory()
                .memoryCache(new LruMemoryCache(2*1024*1024))
                .memoryCacheSize(2*1024*1024)
                .memoryCacheSizePercentage(13)
                .diskCacheSize(50 * 1024 * 1024)
                .diskCacheFileCount(100)
                .build();

        ImageLoader.getInstance().init(config);
    }

    public static void displayImage(String url, ImageView imageView) {
        ImageLoader.getInstance().displayImage(url, imageView, DISPLAY_IMAGE_OPTIONS);
    }

    public static void displayImage(String url, ImageView imageView, ImageLoadingListener listener) {
        ImageLoader.getInstance().displayImage(url, imageView, DISPLAY_IMAGE_OPTIONS, listener);
    }

    public static void loadImage(String url, ImageSize size, SimpleImageLoadingListener listener) {
        ImageLoader.getInstance().loadImage(url, size, DISPLAY_IMAGE_OPTIONS, listener);
    }

    public static Bitmap loadImageSync(String url, ImageSize size){
        return ImageLoader.getInstance().loadImageSync(url, size, DISPLAY_IMAGE_OPTIONS);
    }
}
