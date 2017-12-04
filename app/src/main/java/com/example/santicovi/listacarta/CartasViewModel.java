package com.example.santicovi.listacarta;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by SantiCovi on 04/12/2017.
 */

public class CartasViewModel extends AndroidViewModel {
    private final Application app;
    private final AppDatabase appDatabase;
    private final CartaDAO cartaDAO;
    private LiveData<List<Carta>> cartas;

    public CartasViewModel(Application application) {
        super(application);
        this.app = application;
        this.appDatabase = AppDatabase.getDatabase(this.getApplication());
        this.cartaDAO = appDatabase.getCartaDAO();
    }

    public LiveData<List<Carta>> getCartas(){
        if (cartas == null){
            reload();
        }
        return cartaDAO.getCartas();
    }

    public void reload() {
        RefreshDataTask task = new RefreshDataTask();
        task.execute();
    }

    private class RefreshDataTask extends AsyncTask<Void, Void, ArrayList<Carta>> {
        @Override
        protected ArrayList<Carta> doInBackground(Void... voids) {
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(
                    app.getApplicationContext()
            );

            CartasMagicAPI api = new CartasMagicAPI();
            ArrayList<Carta> result = api.getLast100Cartas();

            Log.d("DEBUG", result.toString());

            cartaDAO.deleteCartas();
            cartaDAO.addCartas(result);
            return result;
        }
    }
}
