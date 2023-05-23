import java.util.Scanner;

public class chiTietPhieuNhap extends HangHoa implements CheckingFormat{
    private String maPhieuNhap;
    Scanner inp = new Scanner(System.in);
    public chiTietPhieuNhap(){
        super();
    }
    
    public chiTietPhieuNhap(String maSanPham,String tenSanPham,long donGia, int soLuong,String donVi,NgayThang ngaySanXuat,NgayThang hanSuDung , String maPhieuNhap) 
    {
        super(maSanPham, tenSanPham, donGia, soLuong, donVi, ngaySanXuat, hanSuDung);
        this.maPhieuNhap = maPhieuNhap;
   
    }
    public chiTietPhieuNhap(String maSanPham,String tenSanPham,long donGia, int soLuong,String donVi,NgayThang ngaySanXuat,NgayThang hanSuDung) 
    {
        super(maSanPham, tenSanPham, donGia, soLuong, donVi, ngaySanXuat, hanSuDung);
    }
    public String getMaPhieuNhap() {
        return maPhieuNhap;
    }
   
    public void setMaPhieuNhap(String maPhieuNhap) {
        this.maPhieuNhap = maPhieuNhap;
    }
       
    public long giaChecking() 
    {
        long dauVao;
        dauVao = inp.nextLong();
        while(dauVao<0)
        {
            System.out.print("Vui long nhap lai: ");
            dauVao = inp.nextLong();
        }
        return dauVao;
    }  
    public void nhapMaSP() {
    	System.out.print("Nhập mã hàng hóa: ");
        super.maSanPham=maHangHoaChecking().trim();
    }
    public void nhapMaPN() {
    	System.out.print("Nhập mã phiếu nhập: ");
    	maPhieuNhap = IDPNchecking().trim();
    }
    public void nhap()
    {
        System.out.print("Nhập tên hàng hóa: ");
        super.tenSanPham = kiemTraBlank().trim();
        System.out.print("Nhập số lượng: ");
        super.soluong = soLuongChecking();
        System.out.print("Nhập đơn giá hàng hóa: ");
        super.dongia = giaChecking();
        System.out.print("Nhập đơn vị tính: ");
        super.donvitinh = kiemTraBlank().trim();
        System.out.print("Nhập ngày sản xuất: ");
        nsx=new NgayThang();
        nsx.input_NgayThang();
        System.out.print("Nhập ngày hạn sử dụng: ");
        hsd=new NgayThang();
        hsd.input_NgayThang();
    }
    public static int count = 1;
    public void xuat()
    {
        System.out.printf("%-4d %-15s %-15s %-25s %-10d %-15s %-15s %-15s %-15s\n", count, this.maPhieuNhap, super.maSanPham, super.tenSanPham, super.soluong , super.dongia, super.donvitinh, nsx, hsd);
        count ++;
    }

	@Override
	public String toString() {
		return maPhieuNhap + ";" + maSanPham+";"+ tenSanPham + ";" + dongia + ";" + soluong + ";" + donvitinh + ";"+ nsx + ";" + hsd;
	}
	public String toString1() {
		return maSanPham+";"+ tenSanPham + ";" + dongia + ";" + soluong + ";" + donvitinh + ";"+ nsx + ";" + hsd;
	}

   
}
