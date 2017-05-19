/*
 * Copyright (C) 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.mavl.mvpproject;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.example.mavl.mvpproject.Utils.ImageLoaderUtil;

public class AppApplication extends MultiDexApplication {

    private static Context mContext;

    public AppApplication() {
        super();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        AppApplication.mContext = getApplicationContext();

        ImageLoaderUtil.init(this);
    }

    public static Context getAppContext() {
        return AppApplication.mContext;
    }

    @Override
    public void onTerminate() {
        synchronized (this) {
        }
        super.onTerminate();
    }
}