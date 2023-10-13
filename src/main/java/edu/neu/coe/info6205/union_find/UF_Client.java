/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package edu.neu.coe.info6205.union_find;

import java.util.*;

/**
 *
 * @author anirudh
 */
public class UF_Client {
    
    public static int count(int n){
        int count =0;
        UF_HWQUPC u = new UF_HWQUPC(n);
        Random r = new Random();
        
        while(u.components()>1){
            int a =r.nextInt(n);
            int b =r.nextInt(n);
            
            u.connect(a,b);
            count++;
            
        }
        return count;
    }
    
    
    
    public static void main(String[] args) {
        System.out.println("Please Enter a number : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Number of objects : "+n+" and total Connections are : "+count(n));
        
        System.out.println("Relationship between m and n");
        for(int i=1000;i<1000000;i*=2){
            int total=0;
            for(int j=0;j<100;j++){
                total+=count(i);
            }
            int avg= total/100;
            System.out.println("Number of objects is : "+i+" Number of Connections is "+avg);
        }
    }
    
    
    
    
    
    
}
