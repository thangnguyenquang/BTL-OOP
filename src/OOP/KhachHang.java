package OOP;

import java.io.Serializable;
import java.util.Scanner;

public class KhachHang extends Nguoi implements Serializable {
    private String maKH;

    public KhachHang(){

    }

    public String getMaKH() { return maKH;}
    public void setMaKH ( String maKH ) { this.maKH=maKH; }

    public void nhap()
    {
        super.nhap();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma khach hang : ");
        maKH = sc.nextLine();
    }

    public void xuat()
    {
        System.out.printf("%-15s|" , maKH );
        super.xuat();
    }

}
