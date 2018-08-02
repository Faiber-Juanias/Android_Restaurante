package com.example.multimedia.android_restaurante;

import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.multimedia.android_restaurante.db.OpenHelper;
import com.example.multimedia.android_restaurante.fragments.FragmentCarta;
import com.example.multimedia.android_restaurante.fragments.FragmentDetalleCarta;
import com.example.multimedia.android_restaurante.fragments.FragmentPedido;

public class Principal extends AppCompatActivity implements FragmentCarta.OnFragmentInteractionListener, FragmentDetalleCarta.OnFragmentInteractionListener, FragmentPedido.OnFragmentInteractionListener{

    //Almacenamos en un array los id de cada boton
    private int[] idBotones = new int[]{R.id.btn_carta, R.id.btn_pedido, R.id.btn_informe, R.id.btn_salida};
    private ImageButton objBotones;

    //Almaceno la instancia de todos los fragmentos
    Fragment[] objFragment = new Fragment[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        objFragment[0] = new FragmentCarta();
        objFragment[1] = new FragmentDetalleCarta();
        objFragment[2] = new FragmentPedido();

        for (int i=0; i<idBotones.length; i++){
            //Creamos la referencia a los botones
            objBotones = (ImageButton) findViewById(idBotones[i]);

            final int n = i;

            objBotones.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
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
