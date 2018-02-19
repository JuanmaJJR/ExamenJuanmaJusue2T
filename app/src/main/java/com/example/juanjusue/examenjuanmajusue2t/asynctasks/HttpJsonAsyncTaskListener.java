package com.example.juanjusue.examenjuanmajusue2t.asynctasks;

/**
 * Created by juan.jusue on 19/02/2018.
 */

//USAMOS ESTE LISTENER, PARA TRATAR CON EL JSON QUE NOS DEVUELVE EL PHP, A SER DE FORMA ASINCRONA, NECESITAMOS USAR UN LISTENER O RECOGEREMOS UN NULL EN EL ACTIVITY
//DEBIDO A QUE NO HA TERMINADO DE EJECUTARSE.

public interface HttpJsonAsyncTaskListener {
    public void JsonOk(String s);
}
