package OOP;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class DSHoaDon {
    ArrayList<HoaDon> lstHD;

    public DSHoaDon(){
        lstHD = new ArrayList<>();
    }
    public void nhap() throws IOException, ClassNotFoundException
    {
        HoaDon hd = new HoaDon();
        hd.nhapHD();
        lstHD.add(hd);
    }

    public void nhapDS() throws IOException, ClassNotFoundException
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so luong hoa don : ");
        int n = sc.nextInt();
        lstHD = new ArrayList<>();
        for ( int i=0; i<n; i++ )
        {
            HoaDon hd = new HoaDon();
            System.out.println("Nhap hoa don thu " + (i+1));
            hd.nhapHD();
            lstHD.add(hd);
        }
    }

    public void xuatDS() throws IOException, ClassNotFoundException {
        int i = 0;
        for ( HoaDon hd:lstHD )
        {
            System.out.println("-------------------------------------------------HOA DON THU " + (i+1) + "------------------------------------------------");
            System.out.println();
            hd.xuatHD();
            ++i;
        }
    }

    public void tongTienHoaDonTheoNgay()
    {
        double s = 0;
        System.out.println("Nhap ngay muon tinh tong tien cac hoa don : ");
        String ngay = new Scanner(System.in).nextLine();
        for ( HoaDon hd: lstHD )
        {
            if( hd.getNgay().equals(ngay) )
            {
                s = s + hd.tongTien();
            }
        }
        System.out.println(" Tong so tien hoa don trong ngay do la : " + s );
    }

    public void tongTienHoaDonTheoThang()
    {
        double s = 0;
        System.out.println("Nhap thang muon tinh tong tien cac hoa don : ");
        String thang = new Scanner(System.in).nextLine();
        for ( HoaDon hd: lstHD )
        {
            if( hd.getThang().equals(thang) )
            {
                s = s + hd.tongTien();
            }
        }
        System.out.println(" Tong so tien hoa don trong thang do la : " + s );
    }

    public void tongTienHoaDonTheoNam()
    {
        double s = 0;
        System.out.println("Nhap nam muon tinh tong tien cac hoa don : ");
        String nam = new Scanner(System.in).nextLine();
        for ( HoaDon hd: lstHD )
        {
            if( hd.getNam().equals(nam) )
            {
                s = s + hd.tongTien();
            }
        }
        System.out.println(" Tong so tien hoa don trong nam do la : " + s );
    }
    public void TimKiemHDBangMa() throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma hoa don can tim kiem : ");
        String ma = sc.nextLine();
        boolean timThay = false;
        for ( HoaDon hd: lstHD ) {
            if ( hd.getMaHD().equals(ma) ) {
                hd.xuatHD();
                timThay = true;
                break;
            }
        }if (timThay == false) System.out.println("Khong tim thay hoa don nao !");
        System.out.println();
    }

    public void xoaHoaDon()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma hoa don muon xoa : ");
        String ma = sc.nextLine();
        boolean timThay = false;
        for ( HoaDon hd:lstHD )
        {
            if ( hd.getMaHD().equals(ma))
            {
                lstHD.remove(hd);
                System.out.println("Xoa hoa don thanh cong !");
                timThay = true;
                break;
            }
        } if (timThay == false) System.out.println("Khong tim thay hoa don can xoa !");
    }


    public void sapXep() throws IOException, ClassNotFoundException {
        Collections.sort(lstHD, new Comparator<HoaDon>() {
            @Override
            public int compare(HoaDon hd1, HoaDon hd2) {
                if ( hd1.tongTien() < hd2.tongTien()){
                    return 1;
                } else {
                    if ( hd1.tongTien() == hd2.tongTien()){
                        return 0;
                    } else {
                        return -1;
                    }
                }
            }
        });
        xuatDS();
    }

    public void GhiDSHDFile()
    {
        try {
            FileOutputStream fout = new FileOutputStream("hoadon.dat");
            ObjectOutputStream out = new ObjectOutputStream(fout);
            out.flush();
            out.writeObject(lstHD);
            out.close();
            fout.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Ghi File thanh cong ");
    }

    public void DocDSHDFile() throws IOException, ClassNotFoundException
    {
            FileInputStream fin = new FileInputStream("hoadon.dat");
            ObjectInputStream in = new ObjectInputStream(fin);
            lstHD = new ArrayList<>();
            lstHD = (ArrayList)in.readObject();
            in.close();
            fin.close();

    }

}
