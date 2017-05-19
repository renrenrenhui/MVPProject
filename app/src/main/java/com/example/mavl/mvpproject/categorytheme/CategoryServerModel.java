package com.example.mavl.mvpproject.categorytheme;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import org.apache.http.Header;

import java.util.List;

/**
 * model层最大的特点是被赋予了数据获取的职责，与我们平常model层只定义实体对象截然不同，
 * 数据的获取、存储、数据状态变化都是model层的任务，presenter会根据需要调用该层的数据处理逻辑并在需要时将回调传入。
 */
public class CategoryServerModel {

    private DataLoadListener listener;
    private AsyncHttpClient mAsyncHttpClient;

    public void getCategoryList(){
        String url = "http://45.79.180.31:7080/kk_online_category/category.php";
        if (mAsyncHttpClient == null) {
            mAsyncHttpClient = new AsyncHttpClient();
        }
        mAsyncHttpClient.setTimeout(7000);
        mAsyncHttpClient.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                CategoryList category = new Gson().fromJson(new String(responseBody), new TypeToken<CategoryList>() {
                }.getType());
                listener.success(category.category);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable throwable) {
                listener.failure();
            }
        });
    }

    public interface DataLoadListener{
        void failure();
        void success(List<Category> list);
    }

    public void setListener(DataLoadListener listener) {
        this.listener = listener;
    }
}
