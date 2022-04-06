package OOP;

import java.io.*;
import java.util.*;

public class DSKhachHang extends KhachHang implements Serializable {
    ArrayList<KhachHang> lstKH ;

    public DSKhachHang(){
        lstKH = new ArrayList<>();
    }

    public void nhap()
    {
        KhachHang kh = new KhachHang();
        kh.nhap();
        lstKH.add(kh);
    }

    public void nhapDS()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so luong khach hang : ");
        int n = sc.nextInt();
        lstKH = new ArrayList<>();
        for ( int i=0; i<n; i++ )
        {
            KhachHang kh = new KhachHang();
            System.out.println("Nhap thong tin khach hang thu " + (i+1));
            kh.nhap();
            lstKH.add(kh);
        }
    }

    public void GhiDSKHFile()
    {
        try {
            FileOutputStream fout = new FileOutputStream("khachhang.dat");
            ObjectOutputStream out = new ObjectOutputStream(fout);
            out.flush();
            out.writeObject(lstKH);
            out.close();
            fout.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Ghi File thanh cong ");
    }

    public ArrayList<KhachHang> DocDSKHFile() throws FileNotFoundException, IOException, ClassNotFoundException
    {
        FileInputStream fin = new FileInputStream("khachhang.dat");
        ObjectInputStream in = new ObjectInputStream(fin);
        lstKH = new ArrayList<>();
        lstKH = (ArrayList)in.readObject();
        in.close();
        fin.close();

        return lstKH;
    }


    public void xuatDS()
    {
        System.out.printf("%-15s|%-20s|%-10s|%-10s|%-30s|%-14s|" , "Ma Khach Hang" , "Ho Ten" ,
                "Nam Sinh" , "Gioi Tinh" , "Dia Chi " , "So Dien Thoai" );
        System.out.println();
        for ( KhachHang kh: lstKH)
        {
            kh.xuat();
            System.out.println();
        }
    }

    public void suaKhachHang()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma khach hang muon sua : ");
        String ma = sc.nextLine();
        boolean timThay = false;
        for ( KhachHang kh: lstKH )
        {
            if ( kh.getMaKH().equals(ma))
            {
                System.out.println("Khach hang truoc khi sua : ");
                kh.xuat();
                System.out.println("Nhap ten moi muon sua : ");
                String ten = sc.nextLine();
                System.out.println("Nhap gioi tinh moi muon sua : ");
                String gt = sc.nextLine();
                System.out.println("Nhap dia chi moi muon sua  : ");
                String dc = sc.nextLine();
                System.out.println("Nhap so dien thoai moi muon sua : ");
                String sdt = sc.nextLine();
                System.out.println("Nhap nam sinh moi muon sua : ");
                int ns = sc.nextInt();

                kh.setHoten(ten);
                kh.setGioiTinh(gt);
                kh.setDiaChi(dc);
                kh.setNamSinh(ns);
                kh.setSdt(sdt);
                timThay = true;
                System.out.println("Sua khach hang thanh cong ! ");
                break;
            }
        } if ( timThay == false ) System.out.println("Khong tim thay khach hang !");
        System.out.println("Danh sach khach hang sau khi sua : ");
        xuatDS();
    }

    public int timKiemKH( String ma )
    {
        Scanner sc =new Scanner(System.in);
        int a=0;
        for ( KhachHang kh: lstKH )
        {
            if ( kh.getMaKH().equals(ma) )
            {
                a=1;
                System.out.printf("%-15s|%-20s|%-10s|%-10s|%-30s|%-14s|" , "Ma Khach Hang" , "Ho Ten" ,
                        "Nam Sinh" , "Gioi Tinh" , "Dia Chi " , "So Dien Thoai" );
                System.out.println();
                kh.xuat();
            }
        } return a;
    }

    public void timKiemThongTinKH( String ma ) {
        for (KhachHang kh : lstKH) {
            if (kh.getMaKH().equals(ma)) {
                System.out.printf("%-15s|%-20s|%-10s|%-10s|%-30s|%-14s|", "Ma Khach Hang", "Ho Ten",
                        "Nam Sinh", "Gioi Tinh", "Dia Chi ", "So Dien Thoai");
                System.out.println();
                kh.xuat();
            }
        }
    }

        public void TimKiemKHBangHoTen ()
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("Nhap ten khach hang can tim kiem : ");
            String tenkh = sc.nextLine();
            boolean timThay = false;
            for (KhachHang kh : lstKH) {
                if (kh.getHoten().equals(tenkh)) {
                    System.out.printf("%15s%25s%10s%10s%45s%15s\n", "Ma Khach Hang", "Ho Ten",
                            "Nam Sinh", "Gioi Tinh", "Dia Chi ", "So Dien Thoai");
                    kh.xuat();
                    timThay = true;
                }
            }
            if (timThay == false) System.out.println("Khong tim thay khach hang nao !");
        }

        public void TimKiemKHBangMa ()
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("Nhap ma khach hang can tim kiem : ");
            String ma = sc.nextLine();
            boolean timThay = false;
            for (KhachHang kh : lstKH) {
                if (kh.getMaKH().equals(ma)) {
                    System.out.printf("%15s%20s%10s%10s%35s%15s\n", "Ma Khach Hang", "Ho Ten",
                            "Nam Sinh", "Gioi Tinh", "Dia Chi ", "So Dien Thoai");
                    kh.xuat();
                    timThay = true;
                    break;
                }
            }
            if (timThay == false) System.out.println("Khong tim thay khach hang nao !");
            System.out.println();
        }

        public void xoaKhachHang ()
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("Nhap ma khach hang muon xoa : ");
            String ma = sc.nextLine();
            boolean timThay = false;
            for (KhachHang kh : lstKH) {
                if (kh.getMaKH().equals(ma)) {
                    lstKH.remove(kh);
                    System.out.println("Xoa khach hang thanh cong !");
                    timThay = true;
                    break;
                }
            }
            if (timThay == false) System.out.println("Khong tim thay khach hang can xoa !");
        }

    /*public void sapXepTen()
    {
        Collections.sort(lstKH, new Comparator<KhachHang>() {
            @Override
            public int compare(KhachHang kh1, KhachHang kh2) {
                return ( kh1.getHoten().compareTo(kh2.getHoten()));
            }
        });
        xuatDS();
    }*/

        public void sapXepTen () {
            lstKH.sort(Comparator.comparing(KhachHang::getTen).thenComparing(KhachHang::getHoten));
            System.out.println("Danh sach khach hang sau khi sap xep:");
            xuatDS();
        }

    }

