
package com.mycompany.singleton;


public class Singleton extends Thread
{
    private static Singleton instanciaUnica;
 
    private Singleton() {}
  
    private synchronized static void createInstance() 
    {
          if (instanciaUnica == null) 
        { 
            instanciaUnica = new Singleton();
            instanciaUnica.start();
        }
      
    }
 
    public static Singleton getInstance() {
        createInstance();

        return instanciaUnica;
    }
    
   @Override
    public void run() 
    {
         
        while(true)
        {
                                            
                        Singleton obj = Singleton.getInstance();
                        System.out.println(obj.hashCode());
          try {
                       sleep(1000);              
                } 
            
            catch (Exception e) 
            {
                System.out.print(e.getMessage());
            }
        }
        
    }
 }

