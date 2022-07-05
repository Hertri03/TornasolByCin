
package com.mycompany.singleton;

import java.util.Date;

public class Reloj extends Thread
{
    private static Reloj reloj;

    private Reloj() {}
  
    private synchronized static void createInstance() 
    {
        if (reloj == null) 
        {
            reloj = new Reloj();
            reloj.start();
         }
    }


    public static Reloj getInstancia() 
    {
        createInstance();

        return reloj;
    }

 

    @Override
    public void run() {
        while (true) 
        {

            Date hora = new Date(System.currentTimeMillis());
            System.out.println(hora);

            try {
                sleep(1000);
                } 
            catch (Exception e) 
            {
                System.out.println(e.getMessage());
                }

        }

    }
    
}
