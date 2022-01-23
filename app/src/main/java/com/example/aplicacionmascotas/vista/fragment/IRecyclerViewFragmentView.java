
package  com.example.aplicacionmascotas.vista.fragment;



import com.example.myapplication.MascotasAdaptador;
import com.example.myapplication.MascotasDto;

import java.util.ArrayList;

public  interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertical();

    public MascotasAdaptador crearAdaptador(ArrayList<MascotasDto> mascotas);

    public void inicializarAdaptadorRV(MascotasAdaptador adaptador);
}