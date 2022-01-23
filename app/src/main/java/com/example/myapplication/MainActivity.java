package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.example.aplicacionmascotas.vista.fragment.RecyclerViewFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<MascotasDto> mascotas;
    RecyclerView listmascotas;
    MascotasAdaptador adaptador;
    private Toolbar actionBar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    public CardView mCardView;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         actionBar =(Toolbar) findViewById(R.layout.actionbar);
        tabLayout =(TabLayout) findViewById(R.id.tabLayout);
        viewPager =(ViewPager) findViewById(R.id.viewpager);

       setSupportActionBar((Toolbar) actionBar);
       setUpViewPager();
        /*
        ArrayList <MascotasDto> mascotas= new ArrayList<MascotasDto>();
         listmascotas = (RecyclerView) findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listmascotas.setLayoutManager(llm);
        inicializarListMascotas();
        inicializarAdaptador();

         */

        /*
        ImageView star = (ImageView) findViewById(R.id.star);
        star.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                adaptador.getLikeArray();
                adaptador.getMascotas();
                        Intent intent = new Intent(MainActivity.this,FavoritiesActivity.class );
                        intent.putExtra("mascotaArray",adaptador.getMascotas());
                        intent.putExtra("mascotaLikeCounter",adaptador.getLikeArray());
                      startActivity(intent);
            }
        });
        ImageView dots = (ImageView) findViewById(R.id.dots);
        dots.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openOptionsMenu();
            }
        });
        */


    }
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

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch (item.getItemId()){
            case R.id.contacto:
                 intent = new Intent(MainActivity.this,FavoritiesActivity.class );
                        startActivity(intent);
                break;
            case R.id.acercade:
                 intent = new Intent(MainActivity.this,BioActivity.class );
                startActivity(intent);
                break;

        }
        return super.onOptionsItemSelected(item);
    }
    ArrayList<Fragment> agregarFragment(){

        ArrayList<Fragment> fragments= new ArrayList<>();
        fragments.add( new RecyclerViewFragment());
        fragments.add(new PerfilFragment());
        return fragments;

    }

    private void setUpViewPager(){
    viewPager.setAdapter(new PagerAdapter(getSupportFragmentManager(),agregarFragment()));
    tabLayout.setupWithViewPager(viewPager);
    }
}