package com.example.juanjusue.examenjuanmajusue2t.FireBase;

/**
 * Created by juan.jusue on 19/02/2018.
 */

import android.app.Activity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by JuanmaJR on 19/02/2018.
 */

public class FireBaseAdmin {

    public FirebaseAuth mAuth;
    FirebaseDatabase database;
    DatabaseReference myRefRaiz;

    public FireBaseAdminListener listener;
    public FirebaseUser user;

    public FireBaseAdmin(){
        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        myRefRaiz=database.getReference();
    }

    public void LogOut(){
        FirebaseAuth.getInstance().signOut();
    }


    public void setListener(FireBaseAdminListener listener){

        this.listener=listener;
    }

    public void registerEmailPass(String email, String password, Activity activity){



    }
    public void loginEmailPass(String email, String password, Activity activity) {


    }
    public void descargarYObservarRama(final String rama){

        DatabaseReference refBranch = myRefRaiz.child(rama);
        refBranch.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                listener.firebaseAdmin_ramaDescargada(rama,dataSnapshot);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                listener.firebaseAdmin_ramaDescargada(rama,null);
            }
        });
    }
    public void insertarenrama (String rutaRama, Map<String, Object> valores){
        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put(rutaRama ,valores);
        myRefRaiz.updateChildren(childUpdates);
    }
}
