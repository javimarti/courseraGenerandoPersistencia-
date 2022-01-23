package com.example.myapplication;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.

 * create an instance of this fragment.
 */
public class PerfilFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    ArrayList <PerfilMascotasDto> arrayPerfilMascota;
    PerfilMascotasAdaptador adaptador;
    RecyclerView perfilmascotas;

    // TODO: Rename and change types of parameters
    //private String mParam1;
   // private String mParam2;

    public PerfilFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    /*
    public static PerfilFragment newInstance(String param1, String param2) {
        PerfilFragment fragment = new PerfilFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
*/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        CardView mPerfilCardView;
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        arrayPerfilMascota= new ArrayList<PerfilMascotasDto>();
        perfilmascotas = (RecyclerView) v.findViewById(R.id.rvMascotasPerfil);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        perfilmascotas.setLayoutManager(llm);
        inicializarPerfil();
        inicializarAdaptador();

        return v;
    }

    public void inicializarAdaptador(){
        adaptador = new PerfilMascotasAdaptador(arrayPerfilMascota);
        perfilmascotas.setAdapter(adaptador);

    }

    public void inicializarPerfil(){
        arrayPerfilMascota= new ArrayList<PerfilMascotasDto>();
        // mascotas.add(new MascotasDto(R.id.petImg,"Ulises",R.id.boneImg,1,R.id.boneLikeImg));
        // mascotas.add(new MascotasDto(R.id.petImg,"Malena",R.id.boneImg,1,R.id.boneLikeImg));
        // mascotas.add(new MascotasDto(R.id.petImg,"Lola",R.id.boneImg,1,R.id.boneLikeImg));
        // mascotas.add(new MascotasDto(R.id.petImg,"Morita",R.id.boneImg,1,R.id.boneLikeImg));

        arrayPerfilMascota.add(new PerfilMascotasDto(R.drawable.pet48,"Ulises"));
        arrayPerfilMascota.add(new PerfilMascotasDto(R.drawable.pet48,"Malena"));
        arrayPerfilMascota.add(new PerfilMascotasDto(R.drawable.pet48,"Lola"));
        arrayPerfilMascota.add(new PerfilMascotasDto(R.drawable.pet48,"Morita"));

    }
}