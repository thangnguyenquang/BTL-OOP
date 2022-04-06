package OOP;

import java.io.Serializable;
import java.util.Scanner;

public class MatHangDoChoi implements Serializable {
    private String maMH;
    private String tenMH;
    private String hangSX;
    private float giaTien;
    private int soLuong;

    public MatHangDoChoi(){

    }

    public void nhap()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma do choi : ");
        maMH = sc.nextLine();
        System.out.println("Nhap ten do choi : ");
        tenMH = sc.nextLine();
        System.out.println("Nhap hang san xuat : ");
        hangSX = sc.nextLine();
        System.out.println("Nhap gia tien cua do choi : ");
        giaTien = sc.nextFloat();
        System.out.println("Nhap so luong do choi : ");
        soLuong = sc.nextInt();
    }

    public float thanhTien() { return soLuong*giaTien; }

    public String getMaMH() { return maMH; }
    public void setMaMH( String maMH ) { this.maMH=maMH ;}

    public String getTenMH() { return tenMH; }
    public void setTenMH( String tenMH ) { this.tenMH=tenMH; }

    public String getHangSX() { return hangSX; }
    public void setHangSX( String hangSX ) { this.hangSX=hangSX; }

    public int getSoLuong() { return soLuong; }
    public void setSoLuong( int soLuong ) { this.soLuong=soLuong; }

    public float getGiaTien() { return giaTien; }
    public void setGiaTien( float giaTien ) { this.giaTien=giaTien; }



    public void xuat()
    {
        System.out.printf("%-13s|" , maMH);
        System.out.printf("%-20s|" , tenMH);
        System.out.printf("%-15s|" , hangSX);
        System.out.printf("%-10d|" , soLuong);
        System.out.printf("%-10.2f|" , giaTien);
        System.out.printf("%-13.2f|" , thanhTien());
        System.out.println();
    }

}
