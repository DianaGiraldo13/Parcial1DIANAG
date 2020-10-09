package co.diana.parcial1dianag;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Button;

import com.google.gson.Gson;

public class Actividad2 extends AppCompatActivity implements Observer{

    private Button buttonArriba;
    private Button buttonAbajo;
    private Button buttonIzquierda;
    private Button buttonDerecha;
    private Button buttonRojo;
    private boolean buttonPressed=false;
    private TCP tcp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad2);

        buttonArriba = findViewById(R.id.buttonArriba);
        buttonAbajo = findViewById(R.id.buttonAbajo);
        buttonIzquierda = findViewById(R.id.buttonIzquierda);
        buttonDerecha = findViewById(R.id.buttonDerecha);
        buttonRojo = findViewById(R.id.buttonRojo);
        tcp= TCP.instance();
        tcp.setObservador(this);

       buttonArriba.setOnClickListener(
               (v)->{
                   Gson gson = new Gson();
                   Movimiento movimiento = new Movimiento("arriba");
                   String mensaje= gson.toJson(movimiento);
                   tcp.sendMessage(mensaje);
               }
       );

        buttonAbajo.setOnClickListener(
                (v)->{
                    Gson gson = new Gson();
                    Movimiento movimiento = new Movimiento("abajo");
                    String mensaje= gson.toJson(movimiento);
                    tcp.sendMessage(mensaje);
                }
        );

        buttonIzquierda.setOnClickListener(
                (v)->{
                    Gson gson = new Gson();
                    Movimiento movimiento = new Movimiento("izquierda");
                    String mensaje= gson.toJson(movimiento);
                    tcp.sendMessage(mensaje);
                }
        );

        buttonDerecha.setOnClickListener(
                (v)->{
                    Gson gson = new Gson();
                    Movimiento movimiento = new Movimiento("derecha");
                    String mensaje= gson.toJson(movimiento);
                    tcp.sendMessage(mensaje);
                }
        );

        buttonRojo.setOnClickListener(
                (v)->{
                    Gson gson = new Gson();
                    Color color = new Color(87,35,100);
                    String mensaje= gson.toJson(color);
                    tcp.sendMessage(mensaje);
                }
        );



    }

}