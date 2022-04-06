/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.Serializable;
import java.util.Scanner;


public class NGUOI implements Serializable{
    private String ten;
    private String Ma;
    private int SDT;
    public NGUOI(){
        ten = "";
        Ma = "";
        SDT = 0;
        
    }
    public NGUOI(String ten,String Ma,int SDT){
        this.ten  = ten;
        this.Ma = Ma;
        this.SDT = SDT;
    }
    public String getMa(){
        return this.Ma;
    }
    public void Nhap(){
    Scanner sc = new Scanner (System.in);
    System.out.print("\nNhap ten: ");
    ten = sc.nextLine();
    System.out.print("Nhap ma: ");
    Ma = sc.nextLine();
    System.out.print("Nhap SDT: ");
    SDT = sc.nextInt();
    sc.nextLine();
    }
    public void Xuat(){
     System.out.printf("%20s%20s%20d",Ma,ten,SDT);   
    }
    public String getTen(){
        return ten;
    }
    public int getSDT(){
        return SDT;
    }
    @Override
    public String toString(){
        return "Ten:"+ten+",Ma:"+Ma+",SDT:"+SDT;
    }
}
