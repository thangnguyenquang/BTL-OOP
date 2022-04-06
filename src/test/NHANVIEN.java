/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.Serializable;
import java.util.Scanner;

public class NHANVIEN extends NGUOI implements Serializable{
    private String ngaySinh;
    private String congViec;
    private float hsl;
    private float luongNV;
    
    public NHANVIEN(){
        this.congViec = "";
        this.hsl = 0.2f;
        this.luongNV = 0.2f;
        this.ngaySinh = "";   
    }
    public NHANVIEN(String maNV,String ten,String ngaySinh, String congViec,int SDT, float hsl,float luongNV){
        super();
        this.congViec = congViec;
        this.hsl = hsl;
        this.luongNV = luongNV;
        this.ngaySinh = ngaySinh;
    }
    public String getMaNV(){
        return super.getMa();
    }
    public String getTenNV(){
        return super.getTen();
    }
    public float Luong(){
        return hsl*1500;
    }
    
    @Override
    public void Nhap(){
        super.Nhap();
        Scanner sc = new Scanner (System.in);
        System.out.print("Nhập ngày sinh nhân viên:  ");
        ngaySinh = sc.nextLine();
        System.out.print("Nhập công việc của nhân viên: ");
        congViec = sc.nextLine();
        System.out.print("Nhập hệ số lương: ");
        hsl = sc.nextFloat();
    }
    @Override
    public void Xuat(){
        super.Xuat();
        System.out.printf("%25s",ngaySinh);
        System.out.printf("%20s",congViec);
        System.out.printf("%20s",hsl);
        System.out.printf("%20s",Luong());
        
    }
    
    @Override
    public String toString(){
        return "(NV)"+super.toString() +",NS:"+ngaySinh+",CV:"+congViec+",HSL:"+hsl;
    }
}