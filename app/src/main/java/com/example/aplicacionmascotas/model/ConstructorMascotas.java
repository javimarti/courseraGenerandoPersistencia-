package com.example.aplicacionmascotas.model;

import android.content.ContentValues;
import android.content.Context;

import com.example.aplicacionmascotas.db.BaseDatos;
import com.example.aplicacionmascotas.db.ConstantesBaseDatos;
import com.example.myapplication.MascotasDto;
import com.example.myapplication.*;

import java.util.ArrayList;

public class ConstructorMascotas {


        private static final int LIKE = 1;
        private Context context;
        public ConstructorMascotas(Context context) {
            this.context = context;
        }

        public ArrayList<MascotasDto> obtenerDatos() {
            BaseDatos db = new BaseDatos(context);
            insertarTresMascotas(db);
            return  db.obtenerTodosLosMascotas();
        }



        public void insertarTresMascotas(BaseDatos db){
            ContentValues contentValues = new ContentValues();
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Ulises");
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.pet48);

            db.insertarMascota(contentValues);

            contentValues = new ContentValues();
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Malena");
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.pet48);

            db.insertarMascota(contentValues);

            contentValues = new ContentValues();
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Lola");
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.pet48);

            db.insertarMascota(contentValues);
        }

        public void darLikeMascota(MascotasDto contacto){
            BaseDatos db = new BaseDatos(context);
            ContentValues contentValues = new ContentValues();
            contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_NUMERO_LIKES, contacto.getId());
            contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_NUMERO_LIKES, LIKE);
            db.insertarLikeMascota(contentValues);
        }

        public int obtenerLikesMascota(MascotasDto mascota){
            BaseDatos db = new BaseDatos(context);
            return db.obtenerLikesMascota(mascota);
        }

}
