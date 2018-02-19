package com.example.juanjusue.examenjuanmajusue2t.FireBase;


import com.google.firebase.database.DataSnapshot;

/**
 * Created by JuanmaJR on 19/02/2018.
 */

public interface FireBaseAdminListener {
    public  void firebaseAdmin_registerOk(Boolean blOk);
    public void firebaseAdmin_loginOk(Boolean blOk);
    public void firebaseAdmin_ramaDescargada(String rama, DataSnapshot dataSnapshot);
}
