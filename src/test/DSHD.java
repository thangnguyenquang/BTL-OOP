package test;

import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;

public class DSHD{
    ArrayList <HOADON> hd;
    public void nhapDSHD(){
        Scanner sc=new Scanner(System.in);
        int nHD;        
        hd=new ArrayList();
        System.out.print("Nhap so hoa don:");
        nHD = sc.nextInt();
        for(int i=0;i<nHD;i++){
            System.out.printf("\nNhap hoa don thu %d:\n",i+1);
            HOADON x=new HOADON();
            x.nhapHD();
            hd.add(x);
        }
    }
    public void xuatDSHD(){
        System.out.print("\nDanh Sach Hoa Don:\n");
        for (HOADON x:hd){
            x.xuatHD();
        }
    }
    
    public void ghifile(){
        File f= new File("hoadon.dat");
        try {
            FileOutputStream fout = new FileOutputStream(f);
            ObjectOutputStream out= new ObjectOutputStream(fout);
            out.writeObject(hd);
            out.close();
            fout.close();
        } catch (IOException  e) {
            System.out.println("Loi ghi file: "+e);
        }
    }
    public void docfile(){
        File f= new File("hoadon.dat");
        try {
            FileInputStream fi = new FileInputStream(f);       
            ObjectInputStream in= new ObjectInputStream(fi);
            hd= new ArrayList<HOADON>();
            hd= (ArrayList)in.readObject();
            for(Object s:hd){
                System.out.println(s.toString());
            }            
            in.close();
            fi.close();
        } catch (Exception e) {
                System.out.println("Loi doc file: "+e);
            }
    }
    
    public void themDSHD(){
        HOADON x=new HOADON();
            x.nhapHD();
            hd.add(x);
    }
    public void xoaDSHD(){
        System.out.print("\nNhap ma hoa don can xoa:");
        String xoaHD;
        Scanner sc=new Scanner(System.in);
        xoaHD=sc.nextLine();
//        System.out.print(hd.size());
        for(int i=0;i<hd.size();i++){
            if(xoaHD.equals(hd.get(i).getMaDonHang())==true){
                hd.remove(i);
            }
        }
        System.out.print("\nDanh Sach Hoa Don Moi:\n");
        for (HOADON x:hd){
            x.xuatHD();
        }
    }
    
    public void tongTienTatCaHoaDon(){
        int tongTienAll=0;
        for (HOADON x:hd){
            tongTienAll+=x.getTongTien();        
        }
        System.out.printf("\nTong tien tat ca cac hoa don: %d",tongTienAll);
        System.out.print("\nThue 10%:"+tongTienAll*0.1);
    }
}
/*
public void sapxepDSHD(){
        Collections.sort(hd, new Comparator<HOADON>() {
            @Override
            public int compare(HOADON o1, HOADON o2) {
                if(o1.getMaDonHang().compareTo(o2.getMaDonHang())>0) {
                        return 1;
                    }
                    else if (o1.getMaDonHang().compareTo(o2.getMaDonHang())==0){
                        return 0;
                    }
                    else return -1;
            }
            });
            for (HOADON x:hd){
            x.xuatHD();
        }
    }
public void timHD(){
    System.out.print("\nNhap ma hoa don can tim:");
    String timHD;
    Scanner sc=new Scanner(System.in);
    timHD=sc.nextLine();
    for(int i=0;i<hd.size();i++){
        if(timHD.equals(hd.get(i).getMaDonHang())==true){
            hd.get(i).xuatHD();
        }
    }
}
*/