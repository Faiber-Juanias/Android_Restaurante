package com.example.multimedia.android_restaurante;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.multimedia.android_restaurante.fragments.FragmentCarta;
import com.example.multimedia.android_restaurante.fragments.FragmentPedido;

public class Principal extends AppCompatActivity implements FragmentCarta.OnFragmentInteractionListener, FragmentPedido.OnFragmentInteractionListener{

    //Almacenamos en un array los id de cada boton
    private int[] idBotones = new int[]{R.id.btn_carta, R.id.btn_pedido};
    private ImageButton[] objBotones = new ImageButton[2];
    private ImageButton btnSalida;

    //Almaceno la instancia de todos los fragmentos
    Fragment[] objFragment = new Fragment[2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        //Creo la referencia con el boton salida
        btnSalida = (ImageButton) findViewById(R.id.btn_salida);
        btnSalida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Salgo de la ejecucion
                finish();
            }
        });

        //Lleno el array con cada una de las instancias de cada fragmento
        objFragment[0] = new FragmentCarta();
        objFragment[1] = new FragmentPedido();

        for (int i=0; i<idBotones.length; i++){
            //Creamos la referencia a los botones
            objBotones[i] = (ImageButton) findViewById(idBotones[i]);

            final int n = i;

            objBotones[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    /**
                     * Valido el id del boton presionado para asi cambiar el color del boton seleccionado
                     */
                    switch (objBotones[n].getId()){
                        case R.id.btn_carta:
                            objBotones[n].setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                            objBotones[1].setBackgroundColor(0);
                            break;
                        case R.id.btn_pedido:
                            objBotones[n].setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                            objBotones[0].setBackgroundColor(0);
                            break;
                    }
                    FragmentManager objManager = getSupportFragmentManager();
                    FragmentTransaction objTransaction = objManager.beginTransaction();
                    objTransaction.replace(R.id.content_fragment, objFragment[n]);
                    objTransaction.commit();
                }
            });
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
