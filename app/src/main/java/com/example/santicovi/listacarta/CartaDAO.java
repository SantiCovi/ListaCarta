package com.example.santicovi.listacarta;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import java.util.List;



/**
 * Created by SantiCovi on 04/12/2017.
 */

@DAO
public interface CartaDAO {
    @Query("select * from carta")
    LiveData<List<Carta>> getCartas();

    @Insert
    void addCarta(Carta carta);

    @Delete
    void deleteCarta(Carta carta);

    @Insert
    void addCartas(List<Carta> cartas);

    @Query("delete from carta")
    void deleteCartas();
}

