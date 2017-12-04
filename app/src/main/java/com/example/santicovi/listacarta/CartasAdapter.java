package com.example.santicovi.listacarta;

import android.content.Context;
import android.graphics.Movie;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import java.util.List;


/**
 * Created by SantiCovi on 04/12/2017.
 */

public class CartasAdapter extends ArrayAdapter<Carta> {
    public CartasAdapter(Context context, int resource, List<Carta> objects) {
        super(context, resource, objects);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Obtenim l'objecte en la possició corresponent
        Carta carta = getItem(position);
        Log.w("XXXX", carta.toString());

        // Mirem a veure si la View s'està reusant, si no es així "inflem" la View
        // https://github.com/codepath/android_guides/wiki/Using-an-ArrayAdapter-with-ListView#row-view-recycling
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.lv_cartas_row, parent, false);
        }

        // Unim el codi en les Views del Layout
        TextView tvTitle = convertView.findViewById(R.id.textoCarta);
        ImageView ivPosterImage = convertView.findViewById(R.id.fotoCarta);

        // Fiquem les dades dels objectes (provinents del JSON) en el layout
        tvTitle.setText(carta.getName());
        Glide.with(getContext()).load(carta.getImagen()).into(ivPosterImage);
        // Retornem la View replena per a mostrarla
        return convertView;
    }

}
