
package test;

import java.io.Serializable;
import java.util.*;

public class MATHANG  implements Serializable{
    //int maHang;
    private String maHang;    
    private String tenHang;
    private String loaiHang;
    private int soLuong;
    private int donGia;
    
    public MATHANG(){
        maHang="";
        donGia=0;
        tenHang="";
        loaiHang="";
        soLuong=0;
    }
    public MATHANG(String maHang,String tenHang,String loaiHang,int donGia,int soLuong ){
        this.maHang=maHang;
        this.tenHang=tenHang;        
        this.loaiHang=loaiHang;
        this.donGia=donGia;
        this.soLuong=soLuong;
    }
            
    public void nhap() {
           Scanner sc = new Scanner(System.in);
    System.out.print("Nhap ma hang: ");
    maHang = sc.nextLine();
    System.out.print("Nhap ten hang: ");
    tenHang = sc.nextLine();
    System.out.print("Nhap vao loai hang: ");
    loaiHang = sc.nextLine(); 
    System.out.print("Nhap don gia: ");
    donGia = sc.nextInt();
    }

    public void xuat() {
//        System.out.printf("%20s%10s%10d%10d%10d\n", maHang, tenHang, donGia,soLuong,donGia*soLuong);
    System.out.printf("\n%15s%15s%15s%15d%15d", maHang, tenHang, loaiHang, donGia,soLuong);
    }

    public int thanhTien(){
        return donGia*soLuong;
    }
    public String getMaMH(){
        return maHang;
    }
    public String getLoaiMH(){
        return loaiHang;
    }
    public int getGia(){
        return donGia;
    }
    public String getTen(){
        return tenHang;
    }
    public void setSL(int SL){
        soLuong=SL;
    }
    @Override
    public String toString(){
        return "Ma hang:"+maHang+",Don gia:"+donGia+",Loai hang:"+loaiHang+",Ten hang:"+tenHang+",SL:"+soLuong+";";
    }
}
