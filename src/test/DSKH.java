
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

public class DSKH implements Serializable{
     int n;
    ArrayList<KHACHHANG> kh;
    public void NhapDSKH(){
        Scanner sc = new Scanner(System.in);
        do{
            System.out.print("Nhap so luong khach hang can lap ds: ");
            n = sc.nextInt();
        }while(n<=0);
        kh = new ArrayList<>(n);
        for(int i = 0;i<n;i++){
            KHACHHANG x = new KHACHHANG();
            System.out.println("\nNhap thong tin khach hang thu "+(i+1));
            x.Nhap();
            kh.add(x);
        }
    }
    public void XuatDSKH(){
        int i = 1;
        System.out.print("\nDanh sach khach hang: ");
        System.out.printf("\n%10s%20s%20s%20s%20s","stt","Ma","ten KH","sdt","dia chi");
        
         for(KHACHHANG x : kh){
             System.out.printf("\n%10d",(i++));
             x.Xuat();
             System.out.print("\n");
         }
    }
    
    public void TimKiemtheoMKH(){
        String MKH;
        int i=1;
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap vao ma khach hang can tim: ");
        MKH = sc.nextLine();
        System.out.print("\nKhach hang co SDT ban vua nhap la: ");
        System.out.printf("\n%10s%20s%20s%20s%20s","stt","Ma KH","ten KH","dia chi","std");
        for(KHACHHANG x : kh){
            if(x.getMa().equalsIgnoreCase(MKH) ){
               System.out.printf("\n%10d",(i++));
               x.Xuat();
            }
        }
    }
    public int timKiemKH(int a){
        Scanner sc=new Scanner(System.in);
        int b=0;
        for(int i=0;i<kh.size();i++){
            if(kh.get(i).getSDTKH()==a){
                b=1;
                System.out.print("Ten khach hang:"+kh.get(i).getTenKH());
            }
        }
        return b;
    }
    
    public void XoaKHtheoMKH(){
        String MKH;
        int i = 1;
          Scanner sc = new Scanner(System.in);
        System.out.print("nhap vao ma khach hang ban muon xoa: ");
        MKH = sc.nextLine();
        for(int j=0;j<kh.size();j++){
            if(kh.get(j).getMa().equalsIgnoreCase(MKH)){
               kh.remove(j);
        }
        }
            System.out.print("\nDanh sach khach hang sau khi xoa la: ");
        System.out.printf("\n%10s%20s%20s%20s%20s","stt","ma KH","ten KH","dia chi","std");
        
        for(KHACHHANG x : kh){
        System.out.printf("\n%10d",(i++));
        x.Xuat();
        }
    }
    public void ThemKH(){
        KHACHHANG x = new KHACHHANG();
        x.Nhap();
        kh.add(x);
    }
    
    public void ghifileKH(){
        File f= new File("khachhang.dat");
        try {
            FileOutputStream fout = new FileOutputStream(f);
            ObjectOutputStream out= new ObjectOutputStream(fout);
            out.writeObject(kh);
            out.close();
            fout.close();
        } catch (IOException  e) {
            System.out.println("Loi ghi file: "+e);
        }
    }
    public ArrayList<KHACHHANG> docfileKH(){
        File f= new File("khachhang.dat");
        try {
            FileInputStream fi = new FileInputStream(f);       
            ObjectInputStream in= new ObjectInputStream(fi);
            kh= new ArrayList<KHACHHANG>();
            kh= (ArrayList)in.readObject();
//            for(Object s:kh){
//                System.out.println(s.toString());
//            }
            
            in.close();
            fi.close();} catch (Exception e) {System.out.println("Loi doc file: "+e);
            }
        return kh;
    }
    public void empty(){
        File f= new File("khachhang.dat");
        try {
            FileOutputStream fout = new FileOutputStream(f);
            fout.close();
        } catch (IOException  e) {
        }
    }
}

