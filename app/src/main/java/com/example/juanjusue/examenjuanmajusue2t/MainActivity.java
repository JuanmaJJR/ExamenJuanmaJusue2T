package com.example.juanjusue.examenjuanmajusue2t;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.juanjusue.examenjuanmajusue2t.DataHolder.DataHolder;
import com.example.juanjusue.examenjuanmajusue2t.FireBase.FireBaseAdmin;
import com.example.juanjusue.examenjuanmajusue2t.FireBase.FireBaseAdminListener;
import com.example.juanjusue.examenjuanmajusue2t.asynctasks.HttpJsonAsyncTask;
import com.example.juanjusue.examenjuanmajusue2t.asynctasks.HttpJsonAsyncTaskListener;
import com.example.juanjusue.examenjuanmajusue2t.sqllite.DataBaseHandler;
import com.google.firebase.database.DataSnapshot;

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

    public MainActivityEvents(MainActivity mainActivity) {
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
    public void JsonOk(String s) {

    }
}