package test;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args){
        DSNV nv = new DSNV();
        DSKH kh=new DSKH();
        DSMH mh=new DSMH();
        DSHD hd= new DSHD();

        Scanner sc=new Scanner(System.in);
        int chon=0,chonMuc=0;
        do{
            System.out.print("\n 1.Quan li nhan vien");
            System.out.print("\n 2.Quan li khach hang");
            System.out.print("\n 3.Quan li mat hang");
            System.out.print("\n 4.Quan li hoa don");
            System.out.print("\n 0.thoat");
            System.out.print("\n Moi ban chon:");
            chon=sc.nextInt();
            if(chon==0)
                System.exit(0);
            else if(chon==1){
                do{
                    System.out.print("\n 1.Nhap danh sach nhan vien");
                    System.out.print("\n 2.Hien thi danh sach nhan vien");
                    System.out.print("\n 3.Luu file");
                    System.out.print("\n 4.Lay du lieu tu file");
                    System.out.print("\n 5.Tim kiem nhan vien");
                    System.out.print("\n 6.Them nhan vien");
                    System.out.print("\n 7.Xoa nhan vien");                    
                    System.out.print("\n 0.Tro ve");
                    System.out.print("\n Moi ban chon:");
                    chonMuc = sc.nextInt();
                    switch(chonMuc){
                        case 1: nv.nhapDSNV();break;
                        case 2: nv.xuatDSNV();break;
                        case 3: nv.ghifileNV();break;
                        case 4: nv.docfileNV();break;
                        case 5: nv.timkiem();break;
                        case 6: nv.themNhanVien();break;
                        case 7: nv.xoaNhanVien();break;
                    }
                }while(chonMuc != 0);
            }
            else if(chon==2){
                do{
                    System.out.print("\n 1.Nhap danh sach khach hang");
                    System.out.print("\n 2.In danh sach khach hang moi");
                    System.out.print("\n 3.Luu file danh sach");
                    System.out.print("\n 4.Lay du lieu tu file");
                    System.out.print("\n 5.Them khach hang");
                    System.out.print("\n 6.Xoa khach hang");
                    System.out.print("\n 7.Tim kiem khach hang");
                    System.out.print("\n 8.Xoa file danh sach");
                    System.out.print("\n 0.Tro ve");
                    System.out.print("\n Moi ban chon:");
                    chonMuc = sc.nextInt();
                    switch(chonMuc){
                        case 1: kh.NhapDSKH();break;
                        case 2: kh.XuatDSKH();break;
                        case 3: kh.ghifileKH();break;
                        case 4: kh.docfileKH();break;
                        case 5: kh.ThemKH();break;
                        case 6: kh.XoaKHtheoMKH();break;
                        case 7: kh.TimKiemtheoMKH();break;
                        case 8: kh.empty();break;
                    }
                }while(chonMuc!=0);
            }
            else if(chon==3){
                do{
                    System.out.print("\n 1.Nhap danh sach mat hang");
                    System.out.print("\n 2.Hien thi danh sach mat hang");
                    System.out.print("\n 3.Luu file");
                    System.out.print("\n 4.Lay du lieu tu file");
                    System.out.print("\n 5.Them 1 mat hang");
                    System.out.print("\n 6.Xoa 1 mat hang");
                    System.out.print("\n 7.Tim mat hang");
                    System.out.print("\n 0.Tro ve");
                    System.out.print("\n Moi ban chon:");
                    chonMuc = sc.nextInt();
                    switch(chonMuc){
                        case 1: mh.nhapDS();break;
                        case 2: mh.xuatDS();break;
                        case 3: mh.ghifileMH();break;
                        case 4: mh.docfileMH();break;
                        case 5: mh.themDSMH();break;
                        case 6: mh.xoaDSMH();break;
                        case 7: mh.lietke();break;
                 }}while(chonMuc != 0);
            }
            else if(chon==4){
                do{
                    System.out.print("\n 1.Tao moi danh sach");
                    System.out.print("\n 2.In danh sach hoa don");
                    System.out.print("\n 3.Luu DSHD vao file");
                    System.out.print("\n 4.Lay DSHD tu file");
                    System.out.print("\n 5.Them hoa don");
                    System.out.print("\n 6.Xoa hoa don");
                    System.out.print("\n 7.Tong tien (thue) hoa don");
                    System.out.print("\n 0.Tro ve");
                    System.out.print("\n Moi ban chon:");
                    chonMuc=sc.nextInt();
                    switch(chonMuc){
                        case 1:hd.nhapDSHD();break;
                        case 2:hd.xuatDSHD();break;                        
                        case 3:hd.ghifile();break;
                        case 4:hd.docfile();break;
                        case 5:hd.themDSHD();break;
                        case 6:hd.xoaDSHD();break;
                        case 7:hd.tongTienTatCaHoaDon();break;
                    }
                }while(chonMuc!=0);
            }
        }while(chon!=0);         
    }    
}
