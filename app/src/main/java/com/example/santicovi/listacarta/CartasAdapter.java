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


        Carta carta = getItem(position);
        Log.w("XXXX", carta.toString());

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.lv_cartas_row, parent, false);
        }


        TextView tvTitle = convertView.findViewById(R.id.textoCarta);
        ImageView ivPosterImage = convertView.findViewById(R.id.fotoCarta);


        tvTitle.setText(carta.getName());
        Glide.with(getContext()).load(carta.getImagen()).into(ivPosterImage);

        return convertView;
    }

}
