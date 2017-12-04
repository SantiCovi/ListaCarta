package com.example.santicovi.listacarta;

import android.arch.lifecycle.LifecycleFragment;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;


/**
 * Created by SantiCovi on 04/12/2017.
 */

public class DetailActivityFragment extends LifecycleFragment {
    private TextView tvName;
    private TextView tvType;
    private ImageView tvImage;
    private View view;

    public DetailActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_detail, container, false);
        Intent intent = getActivity().getIntent();
        if (intent!=null){
            Carta carta = (Carta) intent.getSerializableExtra("carta");
            if (carta!=null){
                show(carta);
            }
        }
        SharedViewModel sharedModel = ViewModelProviders.of(
                getActivity()
        ).get(SharedViewModel.class);
        sharedModel.getSelected().observe(this, new Observer<Carta>() {
            @Override
            public void onChanged(@Nullable Carta carta) {
                show(carta);
            }
        });

        return view;
    }

    private void show(Carta carta) {
        Log.d("Carta", carta.toString());
        tvImage = view.findViewById(R.id.fotoCartaDetail);
        tvName = view.findViewById(R.id.nombreCartaDetail);
        tvType = view.findViewById(R.id.tipoCartaDetail);
        tvName.setText(carta.getName());
        tvType.setText(carta.getType());
        Glide.with(getContext()).load(carta.getImagen()).into(tvImage);

    }
}
