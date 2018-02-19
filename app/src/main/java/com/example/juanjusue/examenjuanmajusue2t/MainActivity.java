package com.example.juanjusue.examenjuanmajusue2t;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.juanjusue.examenjuanmajusue2t.FireBase.FireBaseAdminListener;
import com.example.juanjusue.examenjuanmajusue2t.asynctasks.HttpJsonAsyncTaskListener;
import com.example.juanjusue.examenjuanmajusue2t.sqllite.DataBaseHandler;
import com.google.firebase.database.DataSnapshot;

public class MainActivity extends AppCompatActivity {
    public DataBaseHandler databaseHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
class MainActivityEvents implements HttpJsonAsyncTaskListener, FireBaseAdminListener {

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