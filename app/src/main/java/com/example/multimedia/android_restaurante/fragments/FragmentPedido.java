package com.example.multimedia.android_restaurante.fragments;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.multimedia.android_restaurante.Datos;
import com.example.multimedia.android_restaurante.R;
import com.example.multimedia.android_restaurante.db.Constantes;
import com.example.multimedia.android_restaurante.db.OpenHelper;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentPedido.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentPedido#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentPedido extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public FragmentPedido() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentPedido.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentPedido newInstance(String param1, String param2) {
        FragmentPedido fragment = new FragmentPedido();
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
        View vista = inflater.inflate(R.layout.fragment_fragment_pedido, container, false);

        //Creo la referencia con el recycler
        RecyclerView objRecycler = (RecyclerView) vista.findViewById(R.id.recycler_pedidos);
        objRecycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        //Creamos el array de tipo Datos
        ArrayList<Datos> arrayDatos = new ArrayList<>();

        //Conectamos con la base de datos
        SQLiteDatabase objDb = conecta();
        //Hacemos una consulta para traer el id de la tabla Platos
        String[] campos = new String[]{Constantes.ID_TBL_PLATOS_TBL_PEDIDO};
        Cursor objCursor = objDb.query(Constantes.TBL_PEDIDO, campos, null, null, null, null, null);
        //validamos si hay registros
        if (objCursor.moveToFirst()){
            do {
                //Rescato el id de platos que se encuentra en la tabla pedidos
                int idPlatos = objCursor.getInt(0);
                //Hacemos una consulta para traer la imagen de acuerdo a ese id
                String[] camposDos =  new String[]{Constantes.IMAGEN_TBL_PLATOS};
                String[] args = new String[]{String.valueOf(idPlatos)};
                Cursor objCursorDos = objDb.query(Constantes.TBL_PLATOS, camposDos, "" + camposDos[0] + " = ?", args, null, null, null);
                //Valido si hay registros
                if (objCursorDos.moveToFirst()){
                    do {

                    }while (objCursor.moveToNext());
                }
            }while (objCursor.moveToNext());
        }

        return vista;
    }

    //Metodo que conecta con la base de datos
    public SQLiteDatabase conecta(){
        OpenHelper objConecta = new OpenHelper(getContext(), "restaurante", null, 1);
        SQLiteDatabase objDb = objConecta.getWritableDatabase();
        return objDb;
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
