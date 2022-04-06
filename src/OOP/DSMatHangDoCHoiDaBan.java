package OOP;

import java.util.ArrayList;
import java.util.Scanner;

public class DSMatHangDoCHoiDaBan {
    private int soLuongMua;

    ArrayList<MatHangDoChoi> lstMHDB ;

    public void nhapDS()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so luong cac loai do choi da mua : ");
        soLuongMua = sc.nextInt();
        lstMHDB = new ArrayList<>();
        for ( int i=0; i<soLuongMua; i++)
        {
            MatHangDoChoi mh =new MatHangDoChoi();
            System.out.println("Nhap thong tin san pham thu " + (i+1));
            mh.nhap();
            lstMHDB.add(mh);
        }
    }

    public void xuatDS()
    {
        System.out.printf("%-13s|" , "Ma Do Choi" );
        System.out.printf("%-20s|" , "Ten Do Choi" );
        System.out.printf("%-15s|" , "Hang San Xuat" );
        System.out.printf("%-10s|" , "So Luong" );
        System.out.printf("%-10s|" , "Gia Tien" );
        System.out.printf("%-13s|" , "Thanh Tien" );
        System.out.println();
        for ( MatHangDoChoi mh: lstMHDB )
        {
            mh.xuat();
            System.out.println();
        }
    }

    public double tongTien()
    {
        float s=0;
        for ( MatHangDoChoi mh: lstMHDB )
        {
            s = s + mh.thanhTien();
        }
        return s;
    }

}
