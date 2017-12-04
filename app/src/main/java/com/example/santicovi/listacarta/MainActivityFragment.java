package com.example.santicovi.listacarta;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends LifecycleFragment {
    private ArrayList<Carta> items;
    private CartasAdapter adapter;
    private SharedPreferences preferences;
    private CartasViewModel model;
    private SharedViewModel sharedViewModel;

    public MainActivityFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_cartas_fragment, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_refresh) {
            refresh();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ListView lvCartas = view.findViewById(R.id.lvCartas);
        items = new ArrayList<>();
        adapter = new CartasAdapter(
                getContext(), R.layout.lv_cartas_row, items
        );
        sharedViewModel = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);
        lvCartas.setAdapter(adapter);

        lvCartas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Carta carta = (Carta) parent.getItemAtPosition(position);
                if (!esTablet()){
                    Intent intent = new Intent(getContext(), DetailActivity.class);
                    intent.putExtra("carta", carta);
                    startActivity(intent);
                } else {
                    sharedViewModel.select(carta);
                }
            }
        });

        model = ViewModelProviders.of(this).get(CartasViewModel.class);
        model.getCartas().observe(this, new Observer<List<Carta>>() {
            @Override
            public void onChanged(@Nullable List<Carta> cartas) {
                adapter.clear();
                adapter.addAll(cartas);
            }
        });

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        refresh();
    }

    boolean esTablet(){
        return getResources().getBoolean(R.bool.tablet);
    }

    private void refresh() {

    }

}
