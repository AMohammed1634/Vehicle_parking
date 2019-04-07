
package pproject;

import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;


public class Pproject {

    
   static ArrayList<vehicle> arr=new ArrayList<>();
   static int [] free=new int [100];
   static int [] used=new int [100];
   static int size_free=1,size_used=1;
   static int  chec_value=0;
   //static ArrayList<Integer> free=new ArrayList<>();
   //static ArrayList<Integer> used=new ArrayList<>();
   static Scanner input=new Scanner (System.in);
    public static void main(String[] args) {
       
       free[0]=100;
       Date d=new Date();
       System.out.println("\t\t\tDATE  :  "+d.toString()+"\n");
       System.out.println("===================================================================================");
       System.out.println("===================================================================================");
       char a='0';
       int s=a-'0';
       System.out.println(s);
       /////////////////////////////////////////////
       for (int i=0;true;)
       {
           System.out.println("-----------------------------------------------------------------------------------");
           System.out.println("TO ADD VEHICLE YOU SHOULD ENTER    --> \" ADD \" <--");
           System.out.println("TO DELLET VEHICLE YOU SHOULD ENTER --> \" DEL \" <--");
           System.out.println("TO SHOW STATUS YOU SHOULD ENTER    --> \" SHO \" <--");
            System.out.print( "TO EXITE YOU SHOULD ENTER          --> \" EXI \" <--------------------->>   ");
           String p=input.next();
           System.out.println("----------------------------------------------------------------------------------------\n");
           if(p.equalsIgnoreCase("add"))
           {
               add();
               i++;
           }
           else if(p.equalsIgnoreCase("del")&&i==0)
           {
               System.out.println("----------------------> No VEHICLE in parcing to livie \n");
               
           }
           else if(p.equalsIgnoreCase("del"))
           {
               dell();
           }
           else if(p.equalsIgnoreCase("sho"))
           {
               int sum=0;
               for(int j=0;j<size_free;j++)
               {
                   sum+=free[j];
               }
               if(sum==100)
               {
                   free[0]=100;
                   size_free=1;
                   
               }
               show();
           }
           else if(p.equalsIgnoreCase("exi"))
               return;
           else 
           {
               System.out.println("--------------------------->  WRONG  TRY AGAIN  <--- ");
           }
       }
    }
    ////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    public static void add()
    {
        String t;
        while(true)
        {
            System.out.print("-----------Enter the type of VEHICLE \" Truck , Car , Bus , Motocycle  \" --->  ");
            t=input.next();
            if(t.equalsIgnoreCase("truck")||t.equalsIgnoreCase("car")||t.equalsIgnoreCase("bus")||t.equalsIgnoreCase("motocycle"))
                break;
            else 
            {
                System.out.println("\n--->  You Must Choise correct anser    <---");
                System.out.println("--->  try again please \"croect anser\"<---\n");
            }
        }
        
        String pid;
       ///
        for(;;chec_value++)
        {
            boolean u=true;
             System.out.print("-------------------------------------------------Enter The ID of VEHICLE -->  ");
             pid=input.next();
             
             for(int j=0;j<arr.size();j++)
             {
                 if(pid.equalsIgnoreCase(arr.get(j).id))
                 {
                     System.out.println("\n===>>This ID is used <<=== ");
                     System.out.println("===>>try again please<<=== \n");
                     u=false;
                     break;
                 }
                 
             }
             if(u)
                 break;
             
        }
        ///
        
        
        Truck tr=new Truck();
        Bus bu=new Bus ();
        Car ca=new Car();
        Motocycle mo=new Motocycle();
        if(t.equalsIgnoreCase("truck"))
        {
            tr.id=pid;
            tr.type="Truck";
            arr.add(tr);
        
        }
        if(t.equalsIgnoreCase("Car"))
        {
            ca.id=pid;
            ca.type="Car";
            arr.add(ca);
        }
        if(t.equalsIgnoreCase("Bus"))
        {
            bu.id=pid;
            bu.type="Bus";
            arr.add(bu);
        }
        if(t.equalsIgnoreCase("motocycle"))
        {
            mo.id=pid;
            mo.type="Motocycle";
            arr.add(mo);
        }
        
        
        boolean test=true;
        //we well back to this block;   
        for(int i=1;i<size_free&&size_free>=2;i++)
        {
            if (arr.get(arr.size()-1).length<=free[i])
            {
                free[i]-=arr.get(arr.size()-1).length;
                if(free[i]==0)
                {
                    for(int j=i;j<size_free-1;j++)//to here
                    {
                        free[j]=free[j+1];
                    }
                    size_free--;
                }
                
                test=false;
                break;
            }
            
        }
        //////
        if(test)
        {
            free[0]=free[0]-arr.get(arr.size()-1).length;
            //free[1]=0;
        }
        ///////////
        
        
    }
    
      ////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////
    public static void dell()
    {
        int index = 0;
        String pid;boolean r=false; double p_hour;
        for(int i=0;;i++)
        {
            System.out.print("--------------------------Enter The ID of VEHICLE to get it  -->  ");
            pid=input.next();
            for(int j=0;j<arr.size();j++)
            {
                if(pid.equalsIgnoreCase(arr.get(j).id))
                {
                    index=j;
                    r=true;
                    break;
                }
            }
            if(r)
                break;
            else 
            {
                System.out.println("\n==>>%%%  ERROR THIS ID NOT COME TO MY PARCKING    %%%<<==");
                   
                System.out.println("==>>%%%             TRY AGAIN                     %%%<<==\n"); 
            }
        }
        for(;;)
        {
            try{
                System.out.print("-------------------------> Enter The HOURES of VEHICLE -->  ");
                p_hour=input.nextDouble();
                if(p_hour<=0)
                {
                    System.out.println("\n==>>%%%  ERROR YOU MUST INPUT POSITIVE INTEGER    %%%<<==");
                   
                    System.out.println("==>>%%%             TRY AGAIN                     %%%<<==\n"); 
                    continue;
                }
                break;
            }
            catch(InputMismatchException e)
            {
                System.out.println("\n==>>%%%  ERROR YOU MUST INPUT OF INTEGER    %%%<<==");
                System.out.println("==>>%%%  THE ERROR TYPE IS \" " + e+" \"   %%%<<==");
                System.out.println("==>>%%%  TRY AGAIN   %%%<<==\n");
                input=new Scanner(System.in);
            }
        }
        if(index<arr.size()-1)
        {
            size_free++;
            free[size_free-1]=arr.get(index).length;
        }
        else 
        {
            free[0]+=arr.get(index).length;
        }
        System.out.println("\nThe Amount Of Money is  ==>>  "+arr.get(index).calcMoney(p_hour)+" $$ <<==\n");
        
        ////////////       
        //error{
       if(index==used[size_used-1]&&size_free>2)
       {
           free[size_free-2]+=free[size_free-1];
           size_free--;
        }
        if(index==used[size_used-1]-1&&size_free>2)
        {
            free[size_free-2]+=free[size_free-1];
            size_free--; 
        }
        ////////////   
        //          }
        used[size_used-1]=index;
        arr.remove(index);
        
        
        
    
    }
    //////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////
    public static void show()
    {
        for(int i=0;i<size_free;i++)
        {
            System.out.println(".........I have a unused space  "+(i+1)+" his space is  :  "+free[i]+" meters............");
        }
    }
}
