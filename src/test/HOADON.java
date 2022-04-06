package test;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class HOADON implements Serializable{
    private String maDonHang;
    private int sdtKH;
    private String maNhanVienBanHang;
    private String ngayLap;
    private String maSP;
    private int SL;
    
    ArrayList<MATHANG> mhhd =new ArrayList();
    
    DSNV nv=new DSNV();
    DSKH kh=new DSKH();
    DSMH mh=new DSMH();
    ArrayList<MATHANG> listMH=mh.docfileMH();
    ArrayList<NHANVIEN> listNV=nv.docfileNV();
    ArrayList<KHACHHANG> listKH=kh.docfileKH();
    
    public HOADON(){
        maDonHang="";
        sdtKH=0;
        maNhanVienBanHang="";  
        ngayLap="";
    }
    public HOADON(String maDonHang,int sdtKH,String maNhanVienBanHang,String ngayLap,ArrayList<MATHANG> mh){
        this.maDonHang=maDonHang;
        this.sdtKH=sdtKH;
        this.maNhanVienBanHang=maNhanVienBanHang;
        this.ngayLap=ngayLap;
        this.mhhd=mhhd;        
    }
    
    public String getMaDonHang(){
        return maDonHang;
    }
    public int getTongTien(){
        int tongTien=0;
        for(MATHANG x:mhhd)
            tongTien+=x.thanhTien();
        return tongTien;  
    }
    
    public void nhapHD(){
        Scanner sc= new Scanner(System.in);
        System.out.print("Nhap ma hoa don:");
        maDonHang=sc.nextLine();
        System.out.print("Nhap ngay lap:");
        ngayLap=sc.nextLine();
        for(int i=0; i<1;i++){
            System.out.print("Nhap ma nhan vien:");
            maNhanVienBanHang=sc.nextLine();
            if(nv.timKiemNV(maNhanVienBanHang)==0){
                System.out.print("\nMa nhan vien khong ton tai.Vui long nhap lai!\n");
                i--;
            }
        }
        for(int i=0;i<1;i++){
            System.out.print("\nNhap so dien thoai khach hang: ");
            sdtKH = sc.nextInt();
            if(kh.timKiemKH(sdtKH)==0){
                System.out.print("\nKhach hang moi! ");
                System.out.print("\nGhi danh sach ? ");
                System.out.print("\n1.Co     2.Khong ");
                System.out.print("\nMoi ban chon: ");
                int chon;
                chon=sc.nextInt();
                switch(chon){
                    case 1:kh.ThemKH();kh.ghifileKH();kh.docfileKH();break;
                    case 2:System.out.print("\nTiep tuc");break;
                }
            }
        }
        System.out.print("\nNhap vao so san pham can mua: ");
        int n = sc.nextInt();
        for (int i=0;i<n;++i) {
            System.out.printf("\nNhap mat hang thu %d\n", i + 1);         
            sc.nextLine();
            for(int j=0; j<1;j++){
                System.out.print("Nhap ma sp: ");
                maSP=sc.nextLine();
                if(mh.timKiemMH(maSP)==0){
                    System.out.print("\nMa mat hang khong ton tai.Vui long nhap lai!\n");
                    j--;
                }
            }
            System.out.print("Nhap so luong: ");SL=sc.nextInt();
            MATHANG x= new MATHANG(maSP,mh.gettenSP(maSP),mh.getLoaiSP(maSP),mh.getgiaSP(maSP),SL);
            x.setSL(SL);
            mhhd.add(x);
        }
    }
    public void xuatHD(){
        System.out.printf("\n%20s %s","Ma don hang:",maDonHang);
        System.out.printf("\n%20s %s","Nguoi lap:",nv.tenNVLap(maNhanVienBanHang));
        System.out.printf("%20s %s","Ngay lap:",ngayLap);
        System.out.printf("\n%15s%15s%15s%15s%15s%15s\n", "maHang", "tenHang","loaiHang","donGia","soLuong","thanhTien");
        for(MATHANG x:mhhd){
            x.xuat();
            System.out.printf("%15d",x.thanhTien());
        }
        System.out.printf("\n%75s%15d\n","Tong tien:",getTongTien());
    }

    @Override
    public String toString(){        
        return "Ma don hang:"+maDonHang+",SDT khach hang:"+sdtKH+",Ma nhan vien ban hang:"+maNhanVienBanHang
                +",Ngay lap:"+ngayLap+",Mat hang:"+mhhd;        
    }
}