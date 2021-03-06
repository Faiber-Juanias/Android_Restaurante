package com.example.multimedia.android_restaurante.fragments;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.multimedia.android_restaurante.AdapterListPlato;
import com.example.multimedia.android_restaurante.DatosPlato;
import com.example.multimedia.android_restaurante.DialogFullScreen;
import com.example.multimedia.android_restaurante.R;
import com.example.multimedia.android_restaurante.db.Constantes;
import com.example.multimedia.android_restaurante.db.OpenHelper;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentCarta.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentCarta#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentCarta extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public FragmentCarta() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentCarta.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentCarta newInstance(String param1, String param2) {
        FragmentCarta fragment = new FragmentCarta();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_fragment_carta, container, false);

        //Creamos las referencias
        final RecyclerView objRecycler = (RecyclerView) view.findViewById(R.id.recycler_platos);
        Button objSync = (Button) view.findViewById(R.id.btn_sync);

        //Instanciamos el ArrayList
        final ArrayList<DatosPlato> arrayDatosPlato = new ArrayList<>();
        //Mostramos el recycler como una lista vertical
        objRecycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        //Llamamos al metodo para que llene el ArrayList
        llenaRecycler(arrayDatosPlato);

        //Creamos una instancia del adaptador
        AdapterListPlato objAdapter = new AdapterListPlato(arrayDatosPlato, getContext());

        //Asignamos el evento OnClickListener que creamos
        objAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager objManager = getFragmentManager();
                DialogFullScreen objDialog = new DialogFullScreen();

                //Creo un Bundle para enviar los datos a DialogFullScreen
                Bundle objBundle = new Bundle();
                objBundle.putInt("imagen", arrayDatosPlato.get(objRecycler.getChildAdapterPosition(view)).getImagen());
                objDialog.setArguments(objBundle);

                FragmentTransaction objTransaction = objManager.beginTransaction();
                objTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                objTransaction.add(android.R.id.content, objDialog).addToBackStack(null).commit();
            }
        });
        //Asignamos el adaptador al recycler
        objRecycler.setAdapter(objAdapter);

        //Asignamos el evento al boton Sycn
        objSync.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Sincronizando...", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    /**
     * Metodo que devuelve la conexion
     */
    public SQLiteDatabase conecta(){
        //Creamos la conexion con la base de datos
        OpenHelper objHelper = new OpenHelper(getContext(), "restaurante", null, 1);
        SQLiteDatabase objDb = objHelper.getWritableDatabase();
        return objDb;
    }

    public void llenaRecycler(ArrayList<DatosPlato> arrayDatosPlato){
        SQLiteDatabase objDb = conecta();

        //Consulto todos los registros de la tabla Platos
        String[] campos = new String[]{Constantes.IMAGEN_TBL_PLATOS, Constantes.NOMBRE_TBL_PLATOS, Constantes.PRECIO_TBL_PLATOS};
        Cursor objCursor = objDb.query(Constantes.TBL_PLATOS, campos, null, null, null, null, null);

        //Verifico si hay registros
        if (objCursor.moveToFirst()){
            do {
                //Almaceno el numero de imagen que trae la base de datos
                //arrayDatosPlato.add(new DatosPlato(objCursor.getInt(0), objCursor.getString(1), objCursor.getInt(2)));
                arrayDatosPlato.add(new DatosPlato(objCursor.getInt(0), objCursor.getString(1), objCursor.getInt(2)));
            }while (objCursor.moveToNext());
        }else {
            Toast.makeText(getContext(), "No hay registros para llenar arrayDatosPlato.", Toast.LENGTH_SHORT).show();
        }
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
