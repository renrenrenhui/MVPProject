package com.example.mavl.mvpproject.categorytheme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mavl.mvpproject.ActivityUtils;
import com.example.mavl.mvpproject.R;

/**
 * activity在项目中是一个全局的控制者，
 * 负责创建view以及presenter实例，并将二者联系起来
 * 创建后的fragment实例作为presenter的构造函数参数被传入，
 * 这样就可以在presenter中调用view中的方法了
 * 将fragment作为view层的实现类，为什么是fragment呢？有两个原因，
 * 第一个原因是我们把activity作为一个全局控制类来创建对象，把fragment作为view，这样两者就能各司其职。
 * 第二个原因是因为fragment比较灵活，能够方便的处理界面适配的问题。
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CategoryFragment fragment  = CategoryFragment.newInstance();

        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),fragment,R.id.container);

        //设置presenter
        new CategoryPresenter(fragment);
    }
}
