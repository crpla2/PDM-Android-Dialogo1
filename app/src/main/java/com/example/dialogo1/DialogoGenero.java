package com.example.dialogo1;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public class DialogoGenero extends DialogFragment {
    RespuestaDialogoGenero respuesta;

    /*contructor, esta clase se llamará cuando hacemos show()
    de la clase DialogFragment
     */

    @Override
    public Dialog onCreateDialog(Bundle savedinstanceState){
        //1. Usamos la clase Builder para construir el dialogo
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        //2. Seteamos las carácteristicas(titulo, mensaje)
        builder.setTitle(("Una pregunta"));
        builder.setMessage("¿Eres chica?");
        //3.Añadimos los botones (positivo,negativo,neutro)
        builder.setPositiveButton("SI!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                respuesta.onRespuesta("Eres chica!");
            }
        });
        builder.setNegativeButton("No!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                respuesta.onRespuesta("Eres chico!");
            }
        });
        builder.setNeutralButton("Neutro!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                respuesta.onRespuesta("Eres neutro!");
            }
        });
        //4.Devolvemos el Dialog
        return builder.create();
    }

    //Interfaz para la comunicación entre la actividad y el fragmento doialogo
    public interface RespuestaDialogoGenero{
        public void onRespuesta(String s);
    }
    //se invoca cuando el fragmento se añade a la actividad
    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        respuesta=(RespuestaDialogoGenero) activity;
    }
}
