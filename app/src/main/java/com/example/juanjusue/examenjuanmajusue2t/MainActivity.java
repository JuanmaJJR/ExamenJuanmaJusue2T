package com.example.juanjusue.examenjuanmajusue2t;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.juanjusue.examenjuanmajusue2t.DataHolder.DataHolder;
import com.example.juanjusue.examenjuanmajusue2t.FireBase.FireBaseAdmin;
import com.example.juanjusue.examenjuanmajusue2t.FireBase.FireBaseAdminListener;
import com.example.juanjusue.examenjuanmajusue2t.asynctasks.HttpJsonAsyncTask;
import com.example.juanjusue.examenjuanmajusue2t.asynctasks.HttpJsonAsyncTaskListener;
import com.example.juanjusue.examenjuanmajusue2t.sqllite.Contact;
import com.example.juanjusue.examenjuanmajusue2t.sqllite.DataBaseHandler;
import com.google.firebase.crash.FirebaseCrash;
import com.google.firebase.database.DataSnapshot;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    public DataBaseHandler databaseHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DataHolder.instance.fireBaseAdmin= new FireBaseAdmin();
        MainActivityEvents events = new MainActivityEvents(this);
        DataHolder.instance.fireBaseAdmin.setListener(events);

        ////_________DESCARGAR JSON DESDE PHP-MYSQL___________\\\\\\\\\\\
        HttpJsonAsyncTask httpJsonAsyncTask1=new HttpJsonAsyncTask(this);
        httpJsonAsyncTask1.setListener(events);
        String url1 = String.format("http://10.0.2.2/pruebasJSON/leeJugadores.php");
        httpJsonAsyncTask1.execute(url1);
        ////____________________________________________________\\\\\\\\\\
    }
}
class MainActivityEvents implements HttpJsonAsyncTaskListener, FireBaseAdminListener {
    MainActivity mainActivity;

    public MainActivityEvents(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public void firebaseAdmin_registerOk(Boolean blOk) {

    }

    @Override
    public void firebaseAdmin_loginOk(Boolean blOk) {

    }

    @Override
    public void firebaseAdmin_ramaDescargada(String rama, DataSnapshot dataSnapshot) {

    }

    @Override
    public void JsonOk(String x) {
        Log.v("PRUEBA2",""+x);
        try {

            JSONObject object = new JSONObject(x); //Creamos un objeto JSON a partir de la cadena

            JSONArray json_array = object.optJSONArray("Contactos");
            for (int i = 0; i < json_array.length(); i++) {
                this.mainActivity.databaseHandler.addContact(new Contact(Integer.parseInt(json_array.getJSONObject(i).getString("id")),json_array.getJSONObject(i).getString("nombre"),Double.parseDouble(json_array.getJSONObject(i).getString("lat")),Double.parseDouble(json_array.getJSONObject(i).getString("lon"))));
                Log.v("PRUEBA1","ENTRA EN EL FOR"+json_array.getJSONObject(i).getString("nombre"));

            }

        } catch (JSONException e) {
            e.printStackTrace();
            FirebaseCrash.report(new Exception("Error JSON"));
        }

    }
}