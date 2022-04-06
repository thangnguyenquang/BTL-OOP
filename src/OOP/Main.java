package OOP;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DSNhanVien nv = new DSNhanVien();
        DSKhachHang kh = new DSKhachHang();
        DSMatHangDoChoi mh = new DSMatHangDoChoi();
        DSHoaDon hd = new DSHoaDon();

        do {
            System.out.println();
            System.out.println("   Chuong Trinh Quan Ly Kinh Doanh Do Choi Tre Em   ");
            System.out.println("1. Nhan vien ");
            System.out.println("2. Khach hang ");
            System.out.println("3. Mat hang do choi ");
            System.out.println("4. Hoa don ");
            System.out.println("0. Thoat khoi chuong trinh ! ");
            System.out.println();
            System.out.println("Hay nhap lua chon cua ban ! ");

            Scanner sc = new Scanner(System.in);
            int chon = sc.nextInt();

            switch (chon) {

                case 1 :
                    do {
                        System.out.println();
                        System.out.println("             Quan Ly Nhan Vien            ");
                        System.out.println("1. Nhap va xuat danh sach nhan vien ");
                        System.out.println("2. Them danh sach nhan vien vua nhap vao file ");
                        System.out.println("3. Doc va xuat danh sach nhan vien tu file ");
                        System.out.println("4. Tim kiem mot nhan vien trong danh sach ");
                        System.out.println("5. Sap xep danh sach nhan vien (A-Z) ");
                        System.out.println("6. Xoa mot nhan vien trong danh sach ");
                        System.out.println("7. Sua thong tin cua mot nhan vien ");
                        System.out.println("8. Tro ve menu chinh ");
                        System.out.println("0. Thoat khoi chuong trinh ");
                        System.out.println();
                        System.out.println("Hay nhap lua chon cua ban ! ");

                        int chonnv = sc.nextInt();
                        switch (chonnv){
                            case 1 :
                                System.out.println("Nhap va xuat danh sach nhan vien");
                                nv.nhapDS();
                                nv.xuatDS();
                                break;
                            case 2 :
                                System.out.println("Them danh sach nhan vien vua nhap vao file ");
                                nv.GhiDSNVFile();
                                break;
                            case 3 :
                                System.out.println("Doc va xuat danh sach nhan vien tu file");
                                nv.DocDSNVFile();
                                nv.xuatDS();
                                break;
                            case 4 :
                                System.out.println("Tim kiem mot nhan vien trong danh sach");
                                nv.TimKiemNVBangMa();
                                break;
                            case 5 :
                                System.out.println("Sap xep danh sach nhan vien (A-Z)");
                                nv.sapXepTen();
                                break;
                            case 6 :
                                System.out.println("Xoa mot nhan vien trong danh sach ");
                                nv.xoaNhanVien();
                                nv.GhiDSNVFile();
                                break;
                            case 7 :
                                System.out.println("Sua thong tin cua mot nhan vien");
                                nv.suaNhanVien();
                                break;
                            case 8 :
                                chon = 00;
                                break;
                            case 0 :
                                System.exit(0);
                                break;
                        }
                    } while (chon != 00);
                    break;

                case 2 :
                    do {
                        System.out.println();
                        System.out.println("             Quan Ly Khach Hang            ");
                        System.out.println("1. Nhap va xuat danh sach khach hang ");
                        System.out.println("2. Them danh sach khach hang vua nhap vao file ");
                        System.out.println("3. Doc va xuat danh sach khach hang tu file ");
                        System.out.println("4. Tim kiem mot khach hang trong danh sach ");
                        System.out.println("5. Sap xep danh sach khach hang (A-Z) ");
                        System.out.println("6. Xoa mot khach hang trong danh sach ");
                        System.out.println("7. Sua thong tin cua mot khach hang ");
                        System.out.println("8. Tro ve menu chinh ");
                        System.out.println("0. Thoat khoi chuong trinh ");
                        System.out.println();
                        System.out.println("Hay nhap lua chon cua ban ! ");

                        int chonkh = sc.nextInt();
                        switch (chonkh){
                            case 1 :
                                System.out.println("Nhap va xuat danh sach khach hang");
                                kh.nhapDS();
                                kh.xuatDS();
                                break;
                            case 2 :
                                System.out.println("Them danh sach khach hang vua nhap vao file ");
                                kh.GhiDSKHFile();
                                break;
                            case 3 :
                                System.out.println(" Doc va xuat danh sach khach hang tu file");
                                kh.DocDSKHFile();
                                kh.xuatDS();
                                break;
                            case 4 :
                                System.out.println("Tim kiem mot khach hang trong danh sach");
                                kh.TimKiemKHBangMa();
                                break;
                            case 5 :
                                System.out.println("Sap xep danh sach khach hang (A-Z)");
                                kh.sapXepTen();
                                break;
                            case 6 :
                                System.out.println("Xoa mot khach hang trong danh sach ");
                                kh.xoaKhachHang();
                                kh.GhiDSKHFile();
                                break;
                            case 7 :
                                System.out.println("Sua thong tin cua mot khach hang");
                                kh.suaKhachHang();
                                kh.GhiDSKHFile();
                                break;
                            case 8 :
                                chon = 00;
                                break;
                            case 0 :
                                System.exit(0);
                                break;
                        }
                    } while (chon != 00);
                    break;

                case 3 :
                    do {
                        System.out.println();
                        System.out.println("          Quan Ly mat hang do choi        ");
                        System.out.println("1. Nhap va xuat danh sach do choi ");
                        System.out.println("2. Them danh sach do choi vua nhap vao file ");
                        System.out.println("3. Doc va xuat danh sach do choi tu file ");
                        System.out.println("4. Tim kiem do choi bang hang san xuat ");
                        System.out.println("5. Sap xep danh sach do choi theo gia tien ");
                        System.out.println("6. Xoa mot mat hang trong danh sach ");
                        System.out.println("7. Tim kiem do choi bang ten ");
                        System.out.println("8. Tim kiem do choi bang ma do choi ");
                        System.out.println("9. Tro ve menu chinh ");
                        System.out.println("0. Thoat khoi chuong trinh ");
                        System.out.println();
                        System.out.println("Hay nhap lua chon cua ban ! ");

                        int chonmh = sc.nextInt();
                        switch (chonmh){
                            case 1 :
                                System.out.println("Nhap va xuat danh sach do choi");
                                mh.nhapDS();
                                mh.xuatDS();
                                break;
                            case 2 :
                                System.out.println("Them danh sach do choi vua nhap vao file");
                                mh.GhiDSMHFile();
                                break;
                            case 3 :
                                System.out.println("Doc va xuat danh sach do choi tu file");
                                mh.DocDSMHFile();
                                mh.xuatDS();
                                break;
                            case 4 :
                                System.out.println(" Tim kiem do choi bang hang san xuat");
                                mh.TimKiemMHBangHangSX();
                                break;
                            case 5 :
                                System.out.println("Sap xep danh sach do choi theo gia tien");
                                mh.sapXepTheoGiaTien();
                                break;
                            case 6 :
                                System.out.println(" Xoa mot mat hang trong danh sach ");
                                mh.xoaMatHang();
                                mh.GhiDSMHFile();
                                break;
                            case 7 :
                                System.out.println("Tim kiem do choi bang ten do choi ");
                                mh.TimKiemMHBangTen();
                                break;
                            case 8 :
                                System.out.println("Tim kiem do choi bang ma do choi ");
                                mh.TimKiemMHBangMa();
                                break;
                            case 9 :
                                chon = 00;
                                break;
                            case 0 :
                                System.exit(0);
                                break;
                        }
                    } while (chon != 00);
                    break;

                case 4 :
                    do {
                        System.out.println();
                        System.out.println("             Quan Ly Hoa Don            ");
                        System.out.println("1. Nhap va xuat danh sach hoa don ");
                        System.out.println("2. Them danh sach hoa don vua nhap vao file ");
                        System.out.println("3. Doc va xuat danh sach hoa don tu file ");
                        System.out.println("4. Tim kiem mot hoa don trong danh sach ");
                        System.out.println("5. Sap xep danh sach hoa don theo tong thanh tien ");
                        System.out.println("6. Xoa mot hoa don trong danh sach ");
                        System.out.println("7. Tro ve menu chinh ");
                        System.out.println("8. Tinh tong tien cac hoa don theo ngay, thang hoac nam ");
                        System.out.println("0. Thoat khoi chuong trinh ");
                        System.out.println();
                        System.out.println("Hay nhap lua chon cua ban ! ");

                        int chonhd = sc.nextInt();
                        switch (chonhd){
                            case 1 :
                                System.out.println("Nhap va xuat danh sach hoa don");
                                hd.nhapDS();
                                hd.xuatDS();
                                break;
                            case 2 :
                                System.out.println("Them danh sach hoa don vao file");
                                hd.GhiDSHDFile();
                                break;
                            case 3 :
                                System.out.println("Doc va xuat danh sach hoa don tu file");
                                hd.DocDSHDFile();
                                hd.xuatDS();
                                break;
                            case 4 :
                                System.out.println("Tim kiem mot hoa don trong danh sach");
                                hd.TimKiemHDBangMa();
                                break;
                            case 5 :
                                System.out.println("Sap xep danh sach hoa don theo tong thanh tien ");
                                hd.sapXep();
                                break;
                            case 6 :
                                System.out.println("Xoa mot hoa don trong danh sach");
                                hd.xoaHoaDon();
                                hd.GhiDSHDFile();
                                break;
                            case 7 :
                                chon = 00;
                                break;
                            case 8 :
                                System.out.println("Tinh tong tien cac hoa don theo \n1. Theo ngay \n2. Theo thang \n3. Theo nam ");
                                System.out.println("Nhap lua chon cua ban : ");
                                int chondate = new Scanner(System.in).nextInt();
                                switch(chondate){
                                    case 1: hd.tongTienHoaDonTheoNgay();
                                    break;
                                    case 2: hd.tongTienHoaDonTheoThang();
                                    break;
                                    case 3: hd.tongTienHoaDonTheoNam();
                                    break;
                                    default:
                                        break;
                                }
                            case 0 :
                                System.exit(0);
                                break;
                        }
                    } while (chon != 00);
                    break;
            }
        } while (true);
    }
}