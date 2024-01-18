import java.util.Scanner;
import java.util.*;
import static java.lang.Math.*;

public class Shopping_cart{

  
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
        int total;
        double sub_total=0;
        double grand_total=0;
        double discount=0;
        double final_discount=0;
        int package_charge=0;
        String new_Str= null;
        System.out.println("Enter the name of the product=");
        String name= sc.next();
        System.out.println("Enter the total no. of product=");
        int n= sc.nextInt();
        int []arr= new int [n];
        
        System.out.println("Enter the quantity of product A=");
        int prodA=sc.nextInt();
        System.out.println("Enter the quantity of product B=");
        int prodB=sc.nextInt();
        System.out.println("Enter the quantity of product C=");
        int prodC=sc.nextInt();
        total= (prodA *20)+(prodB* 40) +(prodC* 50);
        
        for(int i=1;i<=n;i++)
        {
            System.out.println("Enter the price of the "+ i+" product=");
             arr[i]=sc.nextInt();
              }
        
              System.out.println("Enter the discount coupon=");
               String str= sc.next();
               double dis=Discount_price(str,total, prodA , prodB, prodC, discount,n);
                
               System.out.println("Wheter you want to apply another coupon=");
               boolean more_vouchers= sc.nextBoolean();
               while(more_vouchers==true){
                System.out.println("Enter the new discount coupon=");
                 new_Str=sc.next();
                final_discount=Math.max(dis, Discount_price(new_Str, total, prodA , prodB, prodC, discount,n));
               }
        sub_total= total-final_discount;
        package_charge=shipping_charge(n);

        grand_total=sub_total+n +package_charge;
        System.out.println("Product name="+name + " Quantity of the product="+ n+ "Total amount of the product="+total);
        System.out.println(" Sub_total after the final discount="+ sub_total);
        System.out.println(" Discount voucer applied="+str +" "+ new_Str+ " the discount amount is="+final_discount);
        System.out.println("Shipping charge="+package_charge+ "Gift wrap fee="+n );
        System.out.println("The Final price="+ grand_total);
        
    }

    public static double Discount_price(String str,int total, int prodA ,int prodB, int prodC, double discount, int n){
     
        switch(str){
            case "flat_10_discount" :
            if (total>200){
                discount=10;
                break;
            }

            case "bulk_5_discount":
            if(prodA>10 || prodB>10 ||prodC>10){
            if(prodA>=10)
            discount=0.5*prodA;

            if(prodB>10)
            discount=discount+0.5*prodB;

            if(prodC>10)
            discount=discount*0.5*prodC;
             break;
            }

            case "bulk_10_discount":
            {
                if(n>20){
                    discount=0.10*total;
                }
                break;

            }
            case "tiered_50_discount":
            {
                if(n>30){
                    if(prodA>15 || prodB>15 ||prodC>15){
                        if(prodA>15)
                        discount= (prodA-15)*0.50;

                        if(prodB>15)
                        discount= (prodB-15)*0.50;

                        if(prodC>15)
                        discount= (prodC-15)*0.50;
                    }
                }
                break;
            }
            default:
            System.out.println("Invalid discount coupon");
        }
        
     return discount;
    }
    public static int shipping_charge(int n){
        int m= n/10;
         return 5*m + 5;
	}
}
