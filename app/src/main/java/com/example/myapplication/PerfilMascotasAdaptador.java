package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static com.example.myapplication.R.layout.cardviewperfil;
import static com.example.myapplication.R.layout.cardviewpetlayout;

public class PerfilMascotasAdaptador extends RecyclerView.Adapter<PerfilMascotasAdaptador.MascotasViewHolder> {



    private ArrayList<PerfilMascotasDto> pefilMascotas;

    public PerfilMascotasAdaptador(ArrayList<PerfilMascotasDto> mascotas) {
        this.pefilMascotas=mascotas;

    }

    @NonNull
    @Override
    public MascotasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(cardviewperfil,parent,false);

        return new MascotasViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotasViewHolder mascotasViewHolder, int position) {
     PerfilMascotasDto perfil = pefilMascotas.get(position);
       // mascotasViewHolder.boneImg.setImageResource(perfil.getBoneImg());

        mascotasViewHolder.petImgPerfil.setImageResource(perfil.getPetImgPerfil());

        mascotasViewHolder.petName.setText(perfil.getPetName());
    //    mascotasViewHolder.mCardView.setTag(position);

    }

    @Override
    public int getItemCount() {
        return pefilMascotas.size();
    }

    public static class MascotasViewHolder extends RecyclerView.ViewHolder{
     //private final ImageView boneImg;
       private final ImageView petImgPerfil;
        private final TextView  petName;
       // private final CardView  mCardView;


        public MascotasViewHolder(@NonNull View itemView) {
            super(itemView);
          //  mCardView =(CardView)itemView.findViewById(R.id.cvPerfilMascotas);
           // boneImg=(ImageView)itemView.findViewById(R.id.boneImg);
            petName=(TextView)itemView.findViewById(R.id.petName);
            petImgPerfil= (ImageView)itemView.findViewById(R.id.petImgPerfil);

        }
    }

    public ArrayList<PerfilMascotasDto> getMascotas() {
        return pefilMascotas;
    }

    public void setMascotas(ArrayList<PerfilMascotasDto> mascotas) {
        this.pefilMascotas = mascotas;
    }
}
