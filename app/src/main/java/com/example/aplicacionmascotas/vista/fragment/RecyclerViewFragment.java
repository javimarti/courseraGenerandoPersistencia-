package com.example.aplicacionmascotas.vista.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplicacionmascotas.presentador.IRecylerViewFragmentPresenter;
import com.example.aplicacionmascotas.presentador.RecyclerViewFragmentPresenter;
import com.example.myapplication.MascotasAdaptador;
import com.example.myapplication.MascotasDto;
import com.example.myapplication.R;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragmentView{
    ArrayList <MascotasDto> mascotas;
    MascotasAdaptador adaptador;
    RecyclerView listmascotas;

    private RecyclerView rvMascotas;
    private IRecylerViewFragmentPresenter presenter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // return super.onCreateView(inflater, container, savedInstanceState);



      //  CardView mCardView;
        View v = inflater.inflate(R.layout.fragment_recycler, container, false);


        rvMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        presenter = new RecyclerViewFragmentPresenter(this, getContext());
          //mascotas= new ArrayList<MascotasDto>();

       // inicializarListMascotas();
       // inicializarAdaptador();

        return v;
    }


    /*
    public void inicializarAdaptador(){
                adaptador = new MascotasAdaptador(mascotas);
        listmascotas.setAdapter(adaptador);

    }

    public void inicializarListMascotas(){
        mascotas= new ArrayList<MascotasDto>();
        // mascotas.add(new MascotasDto(R.id.petImg,"Ulises",R.id.boneImg,1,R.id.boneLikeImg));
        // mascotas.add(new MascotasDto(R.id.petImg,"Malena",R.id.boneImg,1,R.id.boneLikeImg));
        // mascotas.add(new MascotasDto(R.id.petImg,"Lola",R.id.boneImg,1,R.id.boneLikeImg));
        // mascotas.add(new MascotasDto(R.id.petImg,"Morita",R.id.boneImg,1,R.id.boneLikeImg));

        mascotas.add(new MascotasDto(R.drawable.pet48,"Ulises",R.drawable.bonesvg,"0",R.mipmap.bonelike48));
        mascotas.add(new MascotasDto(R.drawable.pet48,"Malena",R.drawable.bonesvg,"0",R.mipmap.bonelike48));
        mascotas.add(new MascotasDto(R.drawable.pet48,"Lola",R.drawable.bonesvg,"0",R.mipmap.bonelike48));
        mascotas.add(new MascotasDto(R.drawable.pet48,"Morita",R.drawable.bonesvg,"0",R.mipmap.bonelike48));

    }*/

    @Override
    public void generarLinearLayoutVertical() {

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listmascotas.setLayoutManager(llm);
    }

    @Override
    public MascotasAdaptador crearAdaptador(ArrayList<MascotasDto> mascotas) {

        adaptador = new MascotasAdaptador(mascotas);
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotasAdaptador adaptador) {
        listmascotas.setAdapter(adaptador);
    }
}
