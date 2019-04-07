
package pproject;


public class Motocycle extends vehicle{
   
     Motocycle()
     {
         this.length=2;
     }
    
     
     @Override
      public double calcMoney(double hour)
    {
        return 5*hour;
    }
}
