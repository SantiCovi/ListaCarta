package com.example.santicovi.listacarta;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.LifecycleRegistryOwner;
import android.support.v7.app.AppCompatActivity;


/**
 * Created by SantiCovi on 04/12/2017.
 */

public class AppCompatLifecycleActivity extends AppCompatActivity {
    private final LifecycleRegistry mRegistry = new LifecycleRegistry(this);

    @Override
    public LifecycleRegistry getLifecycle() {
        return mRegistry;
    }

}

