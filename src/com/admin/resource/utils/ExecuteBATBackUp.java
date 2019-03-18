package com.admin.resource.utils;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecuteBATBackUp {
    Tarea1 t1 = new Tarea1(); // Tarea1 usa Timer
    //t1.programar();
    Tarea2 t2 = new Tarea2(); // Tarea2 usa Executor Framework
    //t2.programar();
        // System.out.printf("Esperando a iniciar ejecución @ t=%d\n", System.currentTimeMillis() / 1000 );

}

class Tarea1 extends TimerTask {
    Timer timer;
    int counter;
    
    public void programar() {
        timer = new Timer();
        // Ejecutar dentro de 2 milisegundos, repetir cada 3 segundos
        timer.schedule(this, 2 * 1000, 3 * 1000);
    }
    
    @Override
    public void run() {
        counter++;
        System.out.printf("Ejecución T1 %d @ t=%d\n", counter, System.currentTimeMillis() / 1000);
        if (counter == 3) {
            this.detener();
        }
    }
    
    void detener() {
        timer.cancel();
    }
}
class Tarea2 implements Runnable {
    ScheduledExecutorService ses;
    int counter;
    
    void programar() {
        ses = Executors.newScheduledThreadPool(1);
        // Ejecutar dentro de 13 milisegundos, repetir cada 3 segundos
        ses.scheduleAtFixedRate(this, 13 * 1000, 3 * 1000, TimeUnit.MILLISECONDS);
    }
    
    @Override
    public void run() {
        counter++;
        System.out.printf("Ejecución T2 %d @ t=%d\n", counter, System.currentTimeMillis() / 1000);
        if (counter == 3) {
            this.detener();
        }
    }
    
    void detener() {
        ses.shutdown();
    }
}