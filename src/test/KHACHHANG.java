package test;

import java.io.Serializable;
import java.util.Scanner;

public class KHACHHANG extends NGUOI implements Serializable{
    private String diaChi;
      
    public KHACHHANG (){
        diaChi = "";
    }
    public KHACHHANG(String MaKH,String ten, String diaChi,String Ma, int SDT){
        super(ten,Ma,SDT);
        this.diaChi = diaChi;
    }
    public int getSDTKH(){
        return super.getSDT();
    }
    public String getTenKH(){
        return super.getTen();
    }
    public String getMaKH(){
        return super.getMa();
    }
    @Override
    public void Nhap(){
        Scanner sc = new Scanner (System.in);    
        super.Nhap();
        System.out.print("Nhap dia chi khach hang: ");
        diaChi = sc.nextLine();
    }
    @Override
    public void Xuat(){
        super.Xuat();
        System.out.printf("%20s",diaChi);
    }
    @Override
    public String toString(){
        return "(KH)"+super.toString()+",Dia chi:"+diaChi;
    }
}
