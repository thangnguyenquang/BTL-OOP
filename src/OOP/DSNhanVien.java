package OOP;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class DSNhanVien implements Serializable {
    ArrayList<NhanVien> lstNV ;

    public DSNhanVien(){
        lstNV = new ArrayList<>();
    }

    public void nhap()
    {
        NhanVien nv = new NhanVien();
        nv.nhap();
        lstNV.add(nv);
    }

    public void nhapDS()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so luong Nhan Vien : ");
        int n = sc.nextInt();
        lstNV = new ArrayList<>();
        for ( int i=0; i<n; i++ )
        {
            NhanVien nv = new NhanVien();
            System.out.println("Nhap thong tin Nhan vien thu " + (i+1));
            nv.nhap();
            lstNV.add(nv);
        }
    }

    public void GhiDSNVFile() throws  IOException
    {
            FileOutputStream fout = new FileOutputStream("nhanvien.dat");
            ObjectOutputStream out = new ObjectOutputStream(fout);
            out.flush();
            out.writeObject(lstNV);
            out.close();
            fout.close();
        System.out.println("Ghi File thanh cong ");
    }

    public ArrayList<NhanVien> DocDSNVFile()
            throws FileNotFoundException, IOException, ClassNotFoundException
    {
        FileInputStream fin = new FileInputStream("nhanvien.dat");
        ObjectInputStream in = new ObjectInputStream(fin);
        lstNV = new ArrayList<>();
        lstNV = (ArrayList)in.readObject();
        in.close();
        fin.close();

        return lstNV;
    }

    public void xuatDS()
    {
        System.out.printf("%-15s|%-20s|%-10s|%-10s|%-30s|%-14s|%-15s|%-13s|%-10s|" , "Ma Nhan Vien" , "Ho Ten" , "Nam Sinh" , "Gioi Tinh" ,
                          "Dia Chi " , "So Dien Thoai" , "He So Luong" , "Ngay Cong" , "Luong");
        System.out.println();
        for ( NhanVien nv: lstNV)
        {
            nv.xuat();
            System.out.println();
        }
    }

    public int timKiemNV( String ma )
    {
        Scanner sc =new Scanner(System.in);
        int a=0;
        for ( NhanVien nv: lstNV )
        {
            if ( nv.getMaNV().equals(ma) )
            {
                a=1;
                System.out.println("Nhan vien lap hoa don : " + nv.getHoten());
            }
        } return a;
    }

    public String getTenNV( String maNV ) throws IOException, ClassNotFoundException {
        String ten = "";
        ArrayList<NhanVien> kq = DocDSNVFile();
        for ( NhanVien nv: lstNV )
        {
            if (nv.getMaNV().equals(maNV) )
                ten = nv.getHoten();
        }
        return ten;
    }

    public void suaNhanVien()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma nhan vien muon sua : ");
        String ma = sc.nextLine();
        boolean timThay = false;
        for ( NhanVien nv : lstNV )
        {
            if ( nv.getMaNV().equals(ma))
            {
                System.out.println("Nhan vien truoc khi sua : ");
                nv.xuat();
                System.out.println();
                System.out.println("Nhap ten moi muon sua : ");
                String ten = sc.nextLine();
                System.out.println("Nhap gioi tinh moi muon sua : ");
                String gt = sc.nextLine();
                System.out.println("Nhap dia chi moi muon sua  : ");
                String dc = sc.nextLine();
                System.out.println("Nhap so dien thoai moi muon sua : ");
                String sdt=sc.nextLine();
                System.out.println("Nhap nam sinh moi muon sua : ");
                int ns = sc.nextInt();
                System.out.println("Nhap he so luong moi muon sua : ");
                float hsl = sc.nextFloat();
                System.out.println("Nhap ngay cong moi muon sua : ");
                float ngayCong = sc.nextFloat();

                nv.setHoten(ten);
                nv.setGioiTinh(gt);
                nv.setDiaChi(dc);
                nv.setNamSinh(ns);
                nv.setSdt(sdt);
                nv.setHsl(hsl);
                nv.setNgayCong(ngayCong);
                timThay = true;
                System.out.println("Sua nhan vien thanh cong !");
                break;
            }
        } if ( timThay == false ) System.out.println("Khong tim thay nhan vien can sua !");
        System.out.println("Danh sach nhan vien sau khi sua : ");
        xuatDS();
    }
    
    public void TimKiemNVBangHoTen()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ten Nhan Vien can tim kiem : ");
        String tenNV = sc.nextLine();
        boolean timThay = false;
        for (NhanVien nv : lstNV) {
            if (nv.getHoten().equals(tenNV)) {
                System.out.printf("%15s%25s%10s%10s%45s%15s%15s%10s%20s\n", "Ma Nhan Vien", "Ho Ten", "Nam Sinh", "Gioi Tinh",
                        "Dia Chi ", "So Dien Thoai", "He So Luong", "Ngay Cong", "Luong");
                nv.xuat();
                timThay = true;
            }
        } if (timThay == false) System.out.println("Khong tim thay nhan vien nao !");
    }

    public void TimKiemNVBangMa()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma nhan vien can tim kiem : ");
        String ma = sc.nextLine();
        boolean timThay = false;
        for (NhanVien nv : lstNV) {
            if (nv.getMaNV().equals(ma)) {
                System.out.printf("%-15s|%-20s|%-10s|%-10s|%-30s|%-14s|%-10s|%-10s|%-10s|" , "Ma Nhan Vien" , "Ho Ten" , "Nam Sinh" , "Gioi Tinh" ,
                        "Dia Chi " , "So Dien Thoai" , "He So Luong" , "Ngay Cong" , "Luong");
                System.out.println();
                nv.xuat();
                timThay = true;
                break;
            }
        }if (timThay == false) System.out.println("Khong tim thay nhan vien nao !");
        System.out.println();
    }

    public void xoaNhanVien()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma nhan vien muon xoa : ");
        String ma = sc.nextLine();
        boolean timThay = false;
        for (NhanVien nv : lstNV)
        {
            if ( nv.getMaNV().equals(ma))
            {
                lstNV.remove(nv);
                System.out.println("Xoa nhan vien thanh cong !");
                timThay = true;
                break;
            }
        } if (timThay == false) System.out.println("Khong tim thay nhan vien can xoa !");
    }

    /*public void sapXepTen()
    {
        Collections.sort(lstNV, new Comparator<NhanVien>() {
            @Override
            public int compare(NhanVien nv1, NhanVien nv2) {
                return ( nv1.getHoten().compareTo(nv2.getHoten()));
            }
        });
        xuatDS();
    }*/

    public void sapXepTen() {
        lstNV.sort(Comparator.comparing(NhanVien::getTen).thenComparing(NhanVien::getHoten));
        System.out.println("Danh sach khach hang sau khi sap xep:");
        xuatDS();
    }
    
}
