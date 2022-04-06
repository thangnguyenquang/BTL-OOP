package OOP;

import java.io.Serializable;
import java.util.Scanner;

public class NhanVien extends Nguoi implements Serializable {
    private String maNV;
    private float hsl;
    private float ngayCong;
    private static float lcb=240000;

    public NhanVien(){

    }

    public String getMaNV() { return maNV; }
    public void setMaNV( String maNV ) { this.maNV=maNV; }

    public float getHsl() { return hsl; }
    public void setHsl( float hsl ) { this.hsl=hsl; }

    public float getNgaycong() { return ngayCong; }
    public void setNgayCong( float ngayCong ) { this.ngayCong=ngayCong; }


    public void nhap()
    {
        super.nhap();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma nhan vien : ");
        maNV = sc.nextLine();
        System.out.println("Nhap he so luong : ");
        hsl = sc.nextFloat();
        System.out.println("Nhap ngay cong : ");
        ngayCong = sc.nextFloat();
    }

    public void xuat()
    {
        System.out.printf("%-15s|" , maNV);
        super.xuat();
        System.out.printf("%-15.1f|" , hsl);
        System.out.printf("%-13.1f|" , ngayCong);
        System.out.printf("%-10.2f|" , tinhluong());
    }

    public float tinhluong() { return ngayCong*hsl*lcb;}

}
