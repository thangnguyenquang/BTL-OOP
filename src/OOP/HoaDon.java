package OOP;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class HoaDon implements Serializable {
    private String maHD;
    private String maNVBan;
    private String maKHMua;
    private String maMHMua;
    private int soLuongBan;

    ArrayList<MatHangDoChoi> lstHB;

    DSNhanVien dsnv = new DSNhanVien();
    DSKhachHang dskh = new DSKhachHang();
    DSMatHangDoChoi dsmh = new DSMatHangDoChoi();

    ArrayList<NhanVien> listNV = dsnv.DocDSNVFile();
    ArrayList<KhachHang> listKH = dskh.DocDSKHFile();

    SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
    SimpleDateFormat dfday = new SimpleDateFormat("dd");
    SimpleDateFormat dfmonth = new SimpleDateFormat("MM");
    SimpleDateFormat dfyear = new SimpleDateFormat("yyyy");

    Date date = null;

    public String getNgay() {
        return dfday.format(date);
    }

    public String getThang() {
        return dfmonth.format(date);
    }

    public String getNam() {
        return dfyear.format(date);
    }


    public HoaDon() throws IOException, ClassNotFoundException {
    }

    public int getSoLuongBan() {
        return soLuongBan;
    }

    public void setSoLuongBan(int soLuongBan) {
        this.soLuongBan = soLuongBan;
    }

    public String getMaKHMua() {
        return maKHMua;
    }

    public void setMaKHMua( String maKHMua) {
        this.maMHMua=maKHMua; }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public void nhapHD() throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma hoa don : ");
        maHD = sc.nextLine();
        System.out.println("Nhap ngay lap hoa don ( dd-MM-yyyy ) : ");
        try {
            date = df.parse(sc.nextLine());
        } catch (ParseException e) {
        }

        for (int i = 0; i < 1; i++) {
            System.out.println("Nhap ma nhan vien lap hoa don : ");
            maNVBan = sc.nextLine();
            if (dsnv.timKiemNV(maNVBan) == 0) {
                System.out.println("Ma nhan vien ban nhap khong ton tai ! Vui long nhap lai");
                i--;
            }
        }

        for (int i = 0; i < 1; i++) {
            System.out.println("Nhap ma khach hang mua :");
            maKHMua = sc.nextLine();
            if (dskh.timKiemKH(maKHMua) == 0) {
                System.out.println("Ma khach hang ban nhap khong hoac chưa ton tai ! " +
                        "Ban muon nhap lai hay nhap khach hang mơi .");
                System.out.println("1. Nhap lai              2. Nhap khach hang moi ");

                int chon = sc.nextInt();
                switch (chon) {
                    case 1:
                        i--;
                        maKHMua = sc.nextLine();
                        break;
                    case 2:
                        dskh.nhap();
                        setMaKHMua(dskh.getMaKH());
                        dskh.timKiemThongTinKH(maKHMua);
                        break;
                }
            }
        }

        System.out.println();
        System.out.println("Nhap danh sach mat hang ban : ");
        System.out.println("Nhap so san phan khach hang da mua : ");
        int n = sc.nextInt();
        lstHB = new ArrayList<>();
        for ( int i=0; i<n; i++ ) {
            System.out.println("Nhap thong tin san pham thư " + (i+1));
                for ( int j=0; j<1; j++ ) {
                    System.out.println("Nhap ma mat hang : ");
                    String maHang = new Scanner(System.in).nextLine();
                    MatHangDoChoi mh = new DSMatHangDoChoi().timHangHoa(maHang);
                    if (mh != null) {
                        System.out.println("Nhap so luong da mua : ");
                        soLuongBan = new Scanner(System.in).nextInt();
                        if (soLuongBan > mh.getSoLuong())
                            System.out.println("Hang hoa khong du so luong trong kho");
                        else {
                            new DSMatHangDoChoi().capNhapHangHoa((mh.getSoLuong() - soLuongBan), mh.getMaMH());
                            mh.setSoLuong(soLuongBan);
                            lstHB.add(mh);
                        }
                    } else {
                        System.out.println("Mat hang khong co ! Chon lai");
                        j--;
                    }
                }
            }
        }

    public double tongTien()
    {
        double tongTien=0;
        for ( MatHangDoChoi mh: lstHB )
        {
            tongTien+=mh.getGiaTien()*mh.getSoLuong();
        }
        return tongTien;
    }

    public void xuatHD() throws IOException, ClassNotFoundException {
        System.out.println("Ma hoa don: " + maHD);
        System.out.println("Nhan vien lap hoa don : " + dsnv.getTenNV(maNVBan));
        System.out.println("Ngay lap: " +  df.format(date));
        System.out.println("Thong tin khach hang mua : ");
        dskh.timKiemThongTinKH(maKHMua);
        System.out.println();
        System.out.println("Danh sach mat hang da ban: ");
        System.out.printf("%-13s|" , "Ma Do Choi" );
        System.out.printf("%-20s|" , "Ten Do Choi" );
        System.out.printf("%-15s|" , "Hang San Xuat" );
        System.out.printf("%-10s|" , "So Luong" );
        System.out.printf("%-10s|" , "Gia Tien" );
        System.out.printf("%-13s|" , "Thanh Tien" );
        System.out.println();
        double tongtien=0;
        for( MatHangDoChoi mh: lstHB){
            mh.xuat();
            tongtien+=mh.getGiaTien()*mh.getSoLuong();
        }
        System.out.println();
        System.out.println("Tong thanh tien: "+tongtien);
    }


}
