package OOP;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class DSMatHangDoChoi extends MatHangDoChoi implements Serializable{
    ArrayList<MatHangDoChoi> lstMH ;

    public DSMatHangDoChoi(){
        lstMH = new ArrayList<>();
    }

    public void nhap()
    {
        MatHangDoChoi mh = new MatHangDoChoi();
        mh.nhap();
        lstMH.add(mh);
    }

    public void nhapDS()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so luong cac loai do choi : ");
        int n = sc.nextInt();
        lstMH = new ArrayList<>();
        for ( int i=0; i<n; i++)
        {
            MatHangDoChoi mh =new MatHangDoChoi();
            System.out.println("Nhap thong tin san pham thu " + (i+1));
            mh.nhap();
            lstMH.add(mh);
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
        for ( MatHangDoChoi mh: lstMH )
        {
            mh.xuat();
            System.out.println();
        }
    }


    public double tongTien()
    {
        float s=0;
        for ( MatHangDoChoi mh: lstMH )
        {
             s = s + mh.thanhTien();
        }
        return s;
    }

    public void GhiDSMHFile()
    {
        try {
            FileOutputStream fout = new FileOutputStream("mathang.dat");
            ObjectOutputStream out = new ObjectOutputStream(fout);
            out.flush();
            out.writeObject(lstMH);
            out.close();
            fout.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Ghi File thanh cong ");
    }

    public void GhiDSHHFile( ArrayList<MatHangDoChoi> lstHang)
    {
        try {
            FileOutputStream fout = new FileOutputStream("mathang.dat");
            ObjectOutputStream out = new ObjectOutputStream(fout);
            out.flush();
            out.writeObject(lstHang);
            out.close();
            fout.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Ghi File thanh cong ");
    }

    public ArrayList<MatHangDoChoi> DocDSMHFile() throws IOException, ClassNotFoundException
    {
        FileInputStream fin = new FileInputStream("mathang.dat");
        ObjectInputStream in = new ObjectInputStream(fin);
        lstMH = new ArrayList<>();
        lstMH = (ArrayList)in.readObject();
        in.close();
        fin.close();

        return lstMH;
    }


    public void TimKiemMHBangTen()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ten mat hang can tim kiem : ");
        String tenMH = sc.nextLine();
        boolean timThay = false;
        for ( MatHangDoChoi mh: lstMH ) {
            if (mh.getTenMH().equals(tenMH)) {
                System.out.printf("%-13s|" , "Ma Do Choi" );
                System.out.printf("%-20s|" , "Ten Do Choi" );
                System.out.printf("%-15s|" , "Hang San Xuat" );
                System.out.printf("%-10s|" , "So Luong" );
                System.out.printf("%-10s|" , "Gia Tien" );
                System.out.printf("%-13s|" , "Thanh Tien" );
                System.out.println();
                mh.xuat();
                timThay = true;
            }
        } if (timThay == false) System.out.println("Khong tim thay mat hang nao !");
    }

    public MatHangDoChoi timHangHoa ( String maHang ) throws IOException, ClassNotFoundException {
        ArrayList<MatHangDoChoi> kq = DocDSMHFile();
        for ( MatHangDoChoi mh: kq )
        {
            if(mh.getMaMH().equals(maHang))
                return mh;
        }return null;
    }

    public void capNhapHangHoa( int soLuong, String maHang ) throws IOException, ClassNotFoundException {
        ArrayList<MatHangDoChoi> kq = DocDSMHFile();

        for (MatHangDoChoi mh : kq) {
            if ( mh.getMaMH().equals(maHang))
                mh.setSoLuong(soLuong);
        }
        GhiDSHHFile(kq);
    }

    public void xoaMatHang()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma mat hang muon xoa : ");
        String ma = sc.nextLine();
        boolean timThay = false;
        for ( MatHangDoChoi mh: lstMH )
        {
            if ( mh.getMaMH().equals(ma))
            {
                lstMH.remove(mh);
                System.out.println("Xoa mat hang thanh cong !");
                timThay = true;
                break;
            }
        } if (timThay == false) System.out.println("Khong tim thay mat hang can xoa !");
    }

    public void sapXepTheoGiaTien()
    {
        Collections.sort(lstMH, new Comparator<MatHangDoChoi>() {
            @Override
            public int compare(MatHangDoChoi mh1, MatHangDoChoi mh2) {
                if ( mh1.getGiaTien() < mh2.getGiaTien()){
                    return 1;
                } else {
                    if ( mh1.getGiaTien() == mh2.getGiaTien() ){
                        return 0;
                    } else {
                        return -1;
                    }
                }
            }
        });
        xuatDS();
    }

    public void TimKiemMHBangHangSX()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap hang san xuat cua do choi can tim kiem : ");
        String tenHSX = sc.nextLine();
        boolean timThay = false;
        for ( MatHangDoChoi mh: lstMH ) {
            if (mh.getHangSX().equals(tenHSX)) {
                System.out.printf("%-13s|" , "Ma Do Choi" );
                System.out.printf("%-20s|" , "Ten Do Choi" );
                System.out.printf("%-15s|" , "Hang San Xuat" );
                System.out.printf("%-10s|" , "So Luong" );
                System.out.printf("%-10s|" , "Gia Tien" );
                System.out.printf("%-13s|" , "Thanh Tien" );
                System.out.println();
                mh.xuat();
                timThay = true;
            }
        } if (timThay == false) System.out.println("Khong tim thay mat hang nao !");
    }

    public void TimKiemMHBangMa()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma mat hang can tim kiem : ");
        String ma = sc.nextLine();
        boolean timThay = false;
        for ( MatHangDoChoi mh: lstMH ) {
            if (mh.getMaMH().equals(ma)) {
                System.out.printf("%-15s|%-20s|%-15s|%-10s|%-10s|%-15s|\n", "Ma Do Choi" , "Ten Do Choi" ,
                        "Hang San Xuat" , "Gia Tien", "So Luong" , "Thanh Tien");
                mh.xuat();
                timThay = true;
                break;
            }
        }if (timThay == false) System.out.println("Khong tim thay mat hang nao !");
        System.out.println();
    }
}
