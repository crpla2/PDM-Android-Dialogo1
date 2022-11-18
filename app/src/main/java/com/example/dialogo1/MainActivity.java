package com.example.dialogo1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements DialogoGenero.RespuestaDialogoGenero{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onRespuesta(String s) {
        Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT).show();
    }
    public void clic(View view){
        DialogFragment dialogFragment= new DialogoGenero();
        dialogFragment.show(getSupportFragmentManager(),"Mi dialogo");
    }
}