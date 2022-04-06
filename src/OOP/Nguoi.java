package OOP;

import java.io.Serializable;
import java.util.Scanner;

public class Nguoi implements Serializable {
    private String hoTen;
    private String gioiTinh;
    private String diaChi;
    private String sdt;
    private int namSinh;

    public void nhap()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ho va ten : ");
        hoTen = sc.nextLine();
        System.out.println("Nhap gioi tinh : ");
        gioiTinh = sc.nextLine();
        System.out.println("Nhap dia chi  : ");
        diaChi = sc.nextLine();
        System.out.println("Nhap so dien thoai : ");
        sdt = sc.nextLine();
        System.out.println("Nhap nam sinh : ");
        namSinh = sc.nextInt();
        System.out.println();
    }

    public void xuat()
    {
        System.out.printf("%-20s|" , hoTen);
        System.out.printf("%-10d|" , namSinh);
        System.out.printf("%-10s|" , gioiTinh);
        System.out.printf("%-30s|" , diaChi);
        System.out.printf("%-14s|" , sdt);
    }

    public String getHoten() { return hoTen;}
    public void setHoten(String hoTen) { this.hoTen=hoTen;}

    public String getDiaChi() { return diaChi;}
    public void setDiaChi(String diaChi) { this.diaChi=diaChi;}

    public int getNamSinh() { return namSinh;}
    public void setNamSinh(int namSinh) { this.namSinh=namSinh;}

    public String getGioiTinh() { return gioiTinh;}
    public void setGioiTinh(String gioiTinh) { this.gioiTinh=gioiTinh;}

    public String  getSdt() { return sdt;}
    public void setSdt( String sdt) { this.sdt=sdt;}

    public String getTen() {
        try {
            return hoTen.substring(hoTen.lastIndexOf(hoTen)).toLowerCase();
        } catch ( Exception e ){
            return hoTen;
        }
    }
}
