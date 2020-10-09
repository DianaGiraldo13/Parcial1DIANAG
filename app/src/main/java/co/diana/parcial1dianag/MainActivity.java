package co.diana.parcial1dianag;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class MainActivity extends AppCompatActivity implements Observer {

    private EditText editTextNombre;
    private Button buttonOk;
    private Socket socket;
    private BufferedReader reader;
    private BufferedWriter writer;
    private TCP tcp;

    public void pass(){
        Intent i = new Intent(this,Actividad2.class);
        startActivity(i);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNombre = findViewById(R.id.editTextNombre);
        buttonOk = findViewById(R.id.buttonOk);
        tcp=TCP.instance();
        tcp.setObservador(this);



        buttonOk.setOnClickListener(
                (v)->{
                    Intent intent = new Intent(this,Actividad2.class);
                    Gson gson=new Gson();
                    Usuario usuario= new Usuario(editTextNombre.getText().toString());
                    String mensaje= gson.toJson(usuario);
                    tcp.sendMessage(mensaje);
                    startActivity(intent);
                }
        );

    }


}