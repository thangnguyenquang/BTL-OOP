
package test;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.*;

public class DSMH implements Serializable{
    int i=0, n=0;
    ArrayList <MATHANG> mh=new ArrayList<>();
    public void nhapDS() {
        Scanner input = new Scanner(System.in);        
        do {
            System.out.print("\nNhap vao so mat hang: ");
            n = input.nextInt();
            input.nextLine();
        } while (n <= 0 || n > 20);
        for (i = 0; i < n; i++) {
            MATHANG x = new MATHANG();
            System.out.printf("\nNhap mat hang thu %d\n", i + 1);
            x.nhap();
            mh.add(x);
        }
    }
    
     public void xuatDS() {
        System.out.println("Danh sach mat hang vua nhap: \n");
        System.out.printf("%15s%15s%15s%15s\n","Ma Hang","Ten hang", "Loai hang", "Gia ban le");
        mh.forEach(x -> {
            x.xuat();
            });
    }
     public void lietke(){
        String hangcantim;
        Scanner sc = new Scanner(System.in);
        System.out.print("\nNhap vao ma hang can tim: ");
        hangcantim = sc.nextLine();
        
        System.out.printf("%20s%30s%20s%30s\n","Ma Hang","Ten hang", "Loai hang", "Gia ban le");

        for(i=0;i<n;i++){
            if(hangcantim.equals(mh.get(i).getMaMH())){
                mh.get(i).xuat();                
            }
        }
    }
    public void themDSMH(){
        System.out.print("\nThem mat hang:\n");
        MATHANG x=new MATHANG();
            x.nhap();
            mh.add(x);
    }
    public void xoaDSMH(){
        System.out.print("\nNhap ma mat hang can xoa:");
        String xoa;
        Scanner sc=new Scanner(System.in);
        xoa=sc.nextLine();
        for(int i=0;i<mh.size();i++){
            if(xoa.equals(mh.get(i).getMaMH())==true){
                mh.remove(i);
            }
        }
        System.out.print("\nDanh Sach Mat Hang Moi:\n");
        for (MATHANG x:mh){
            x.xuat();
        }
    }
    
    //Phu tro cho hoa don    
    public int timKiemMH(String a){
        Scanner sc=new Scanner(System.in);
        int b=0;
        for(int i=0;i<mh.size();i++){
            if(mh.get(i).getMaMH().equals(a)==true){
                b=1;
//                System.out.print("Ten mat hang:"+mh.get(i).getTen());
            }
        }
        return b;
    }
    
    public int getgiaSP(String a){
        Scanner sc=new Scanner(System.in);
        int x=0;
        for(int i=0;i<mh.size();i++){
            if(mh.get(i).getMaMH().equals(a)==true){
                x=mh.get(i).getGia();
            }
            }
        return x;
    }
    public String getLoaiSP(String a){
        Scanner sc=new Scanner(System.in);
        String b="";
        for(int i=0;i<mh.size();i++){
            if(mh.get(i).getMaMH().equals(a)==true){
                b=mh.get(i).getLoaiMH();
            }
            }
        return b;
    }
    public String gettenSP(String a){
        Scanner sc=new Scanner(System.in);
        String b="";
        for(int i=0;i<mh.size();i++){
            if(mh.get(i).getMaMH().equals(a)==true){
                b=mh.get(i).getTen();
            }
            }
        return b;
    }   
    
    //thao tac voi file
    public void ghifileMH(){
        File f= new File("mathang.dat");
        try {
            FileOutputStream fout = new FileOutputStream(f);
            ObjectOutputStream out= new ObjectOutputStream(fout);
            out.writeObject(mh);
            out.close();
            fout.close();
        } catch (IOException  e) {
            System.out.println("Loi ghi file: "+e);
        }
    }
    public ArrayList<MATHANG> docfileMH(){
        File f= new File("mathang.dat");

        try {
            FileInputStream fi = new FileInputStream(f);       
            ObjectInputStream in= new ObjectInputStream(fi);
            mh= new ArrayList<MATHANG>();
            mh= (ArrayList)in.readObject();
//            for(Object s:mh){
//                System.out.println(s.toString());
//            }
            
            in.close();
            fi.close();} catch (Exception e) {System.out.println("Loi doc file: "+e);
            }
        return mh;
    }
    public void empty(){
        File f= new File("mathang.dat");
        try {
            FileOutputStream fout = new FileOutputStream(f);
            fout.close();
        } catch (IOException  e) {
        }
    }
}
