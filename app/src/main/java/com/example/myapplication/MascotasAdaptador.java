package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplicacionmascotas.model.ConstructorMascotas;

import java.util.ArrayList;

import static com.example.myapplication.R.layout.cardviewpetlayout;

public class MascotasAdaptador extends RecyclerView.Adapter<MascotasAdaptador.MascotasViewHolder> {


    private final Activity activity;
    private ArrayList<MascotasDto> mascotas;
    private int likeArray[]=new int[50];

    public MascotasAdaptador(ArrayList<MascotasDto> mascotas, Activity activity) {
        this.mascotas=mascotas;
        this.activity=activity;
    }

    @NonNull
    @Override
    public MascotasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(cardviewpetlayout,parent,false);

        return new MascotasViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotasViewHolder mascotasViewHolder, int position) {
     MascotasDto mascota = mascotas.get(position);
        mascotasViewHolder.boneImg.setImageResource(mascota.getBoneImg());
        mascotasViewHolder.boneLikeImg.setImageResource(mascota.getBoneLikeImg());
        mascotasViewHolder.petImg.setImageResource(mascota.getPetImg());
        mascotasViewHolder.petName.setText(mascota.getPetName());
        mascotasViewHolder.votes.setText(mascota.getVotes());
        mascotasViewHolder.mCardView.setTag(position);
        likeArray=mascotasViewHolder.likeArray;

        mascotasViewHolder.boneLikeImg.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  int position = (int) mCardView.getTag();
               // likeArray[position]+=1;

                ConstructorMascotas constructorContactos = new ConstructorMascotas(activity);
                constructorContactos.darLikeMascota(mascota);
                mascotasViewHolder.votes.setText(Integer.toString(constructorContactos.obtenerLikesMascota(mascota)) );
               Toast.makeText(view.getContext(),Integer.toString(position),Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotasViewHolder extends RecyclerView.ViewHolder{

      private final ImageView boneLikeImg;
       private final ImageView boneImg;
       private final ImageView petImg;
        private final TextView  petName;
        private final TextView  votes;
        private final CardView  mCardView;
        private final int likeArray[];

        public MascotasViewHolder(@NonNull View itemView) {
            super(itemView);

            mCardView =(CardView)itemView.findViewById(R.id.cvMascotas);
            boneLikeImg= (ImageView)itemView.findViewById(R.id.boneLikeImg);
            petName=(TextView)itemView.findViewById(R.id.petName);
            boneImg=(ImageView)itemView.findViewById(R.id.boneImg);
            votes=(TextView)itemView.findViewById(R.id.votes);
            petImg= (ImageView)itemView.findViewById(R.id.petImg);




            likeArray = new int[50];
        }
    }
    public int[] getLikeArray() {
        return likeArray;
    }

    public void setLikeArray(int[] likeArray) {
        this.likeArray = likeArray;
    }
    public ArrayList<MascotasDto> getMascotas() {
        return mascotas;
    }

    public void setMascotas(ArrayList<MascotasDto> mascotas) {
        this.mascotas = mascotas;
    }
}
