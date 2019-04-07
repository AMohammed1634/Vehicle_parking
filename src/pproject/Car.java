
package pproject;


public class Car extends vehicle{
    
     Car()
     {
         this.length=5;
     }
    
     
     @Override
      public double calcMoney(double hour)
    {
        return 10*hour;
    }
}
