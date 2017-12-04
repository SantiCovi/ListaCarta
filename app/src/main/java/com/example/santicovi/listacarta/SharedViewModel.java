package com.example.santicovi.listacarta;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

/**
 * Created by SantiCovi on 04/12/2017.
 */

public class SharedViewModel extends ViewModel {
    private final MutableLiveData<Carta> selected = new MutableLiveData<>();

    public void select(Carta carta){
        selected.setValue(carta);
    }

    public LiveData<Carta> getSelected(){
        return selected;
    }
}
