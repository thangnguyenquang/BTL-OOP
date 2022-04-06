/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class DSNV implements Serializable{
     int n;

    ArrayList<NHANVIEN> nv;
    private String maNv;
    private boolean flag;

static Scanner sc=new Scanner(System.in);

    public void nhapDSNV() {
//        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số nhân viên: ");
        n = sc.nextInt();
        nv = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {

            flag = true;
            NHANVIEN input = new NHANVIEN();

            // bắt trường hợp mã nhân viên trùng nhau
            do {
                if (flag) {
                    System.out.println("Nhập thông tin nhân viên thứ " + (i + 1));
                } else {
                    System.out.println("Mã Nhân Viên Trùng nhau làm ơn nhập lại " + (i + 1));
                }
                input.Nhap();
                System.out.println("\n");
                flag = false;

                // kiem tra xem nhan vien co bi trung ko,
                // neu bi trung thi chay lai do lan nua
                // luc nay flag = false nen se chay vao else
                // neu ko bi trung thi  nhanVienList.add(input); chay tiep for
                // s la tung phan tu trong nhanVienList
            } while (nv.stream().anyMatch((s) -> s.getMaNV().equals(input.getMaNV())));
            nv.add(input);

//            nhanVienList.forEach(s -> s.getMaNV().equals(input.getMaNV()));
        }
    }

    public void xuatDSNV() {
        int a = 0;
        System.out.print("\nDanh sách nhân viên bạn vừa nhập là: ");
        System.out.printf("\n%10s%20s%20s%25s%20s%20s%20s%20s",
                "STT", "MaNV","TenNV", "Ngày Sinh", "Công việc", "SĐT", "Hệ số lương", "Lương");
        for (NHANVIEN x : nv) {
            System.out.printf("\n%10d", ++a);
            x.Xuat();
            System.out.println("\n");
        }
    }

    public void timkiem() {
        flag = false;
//        Scanner sc = new Scanner(System.in);
        do {
            if (flag)
                System.out.print("\n Không tìm thấy mã nhập lại ");
            else
                System.out.print("\nNhập mã để tìm kiếm nhân viên - Nhập mã nhân viên: ");
            int a = 0;
            maNv = sc.nextLine();

            for (NHANVIEN nhanVien : nv) {
                if (nhanVien.getMaNV().equals(maNv)) {
                    System.out.printf("\n%10d", ++a);
                    nhanVien.Xuat();
                    System.out.println("\n");
                }
            }
            flag = true;
            // kiem tra khong trung , thay vi kiem tra trung nhu nhap nhan vien
        } while (!nv.stream().anyMatch((s) -> s.getMaNV().equals(maNv)));
    }

    public void xoaNhanVien() {
//            Scanner sc = new Scanner(System.in);
        flag = false;
        do {
            if (flag)
                System.out.print("\n Không tìm thấy mã nhập lại : ");
            else
                System.out.print("\n Nhập mã để Xóa nhân viên - Nhập mã nhân viên:");
            maNv = sc.nextLine();

            // java 8 mới có
            nv.removeIf(nhanVien -> nhanVien.getMaNV().equals(maNv));
            flag = true;

            // kiem tra khong trung , thay vi kiem tra trung nhu nhap nhan vien
        } while (!nv.stream().anyMatch((s) -> s.getMaNV().equals(maNv)));

//        nhanVienList.removeIf(nhanVien -> nhanVien.getMaNV().equals(maNV));
//        for (NhanVien nhanVien : nhanVienList) {
//            if (nhanVien.getMaNV().equals(maNV)) {
//                nhanVienList.remove(nhanVien);
//            }
//        }

        //netbean
        /*
        for(int i=0;i<nv.size();i++){
            if(maNv.equals(nv.get(i).getMaNV())==true){
                nv.remove(i);
            }
        }
        System.out.print("\nDanh Sach Hoa Don Moi:\n");
        for (NHANVIEN x:nv){
            x.Xuat();
        }
        */
    }

    public void themNhanVien() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số nhân viên: ");
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            NHANVIEN x = new NHANVIEN();
            System.out.println("Thêm thông tin nhân viên thứ " + (i + 1));
            x.Nhap();
            nv.add(x);
        }
    }
    
    
    
    
    //phu tro cho hoa don
    public String tenNVLap(String a){
        String b="";
        for(int i=0;i<nv.size();i++){
                if(nv.get(i).getMaNV().equals(a)==true)
                    b=a.replace(a, nv.get(i).getTenNV()) ;
            }
        return b;
    }
    
    public int timKiemNV(String a){
        Scanner sc=new Scanner(System.in);
        int b=0;
        for(int i=0;i<nv.size();i++){
            if(nv.get(i).getMaNV().equals(a)==true){
                b=1;
                System.out.print("Ten nhan vien:"+nv.get(i).getTenNV());
            }
            }
        return b;
    }
    public void ghifileNV(){
        File f= new File("nhanvien.dat");
        try {
            FileOutputStream fout = new FileOutputStream(f);
            ObjectOutputStream out= new ObjectOutputStream(fout);
            out.writeObject(nv);
            out.close();
            fout.close();
        } catch (IOException  e) {
            System.out.println("Loi ghi file: "+e);
        }
    }
    public ArrayList<NHANVIEN> docfileNV(){
        File f= new File("nhanvien.dat");

        try {
            FileInputStream fi = new FileInputStream(f);       
            ObjectInputStream in= new ObjectInputStream(fi);
            nv= new ArrayList<NHANVIEN>();
            nv= (ArrayList)in.readObject();
//            for(Object s:nv){
//                System.out.println(s.toString());
//            }
            
            in.close();
            fi.close();} catch (Exception e) {System.out.println("Loi doc file: "+e);
            }
        return nv;
    }
    
}