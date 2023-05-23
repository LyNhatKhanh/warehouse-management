import java.util.Scanner;

public class HangHoa implements CheckingFormat{
	
	protected String maSanPham;
	protected String tenSanPham;
	protected long dongia;
	protected int soluong;
	protected String donvitinh;
	protected NgayThang nsx;
	protected NgayThang hsd;
	Scanner inp = new Scanner(System.in);
	public HangHoa() {
		
	}
	public HangHoa(String maSanPham, String tenSanPham, long dongia, int soluong, String donvitinh, NgayThang nsx,
			NgayThang hsd) {
		this.maSanPham = maSanPham;
		this.tenSanPham = tenSanPham;
		this.dongia = dongia;
		this.soluong = soluong;
		this.donvitinh = donvitinh;
		this.nsx = nsx;
		this.hsd = hsd;
	}
	
	public String getMaSanPham() {
		return maSanPham;
	}
	public void setMaSanPham(String maSanPham) {
		this.maSanPham = maSanPham;
	}
	public String getTenSanPham() {
		return tenSanPham;
	}
	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}
	public long getDongia() {
		return dongia;
	}
	public void setDongia(long dongia) {
		this.dongia = dongia;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public String getDonvitinh() {
		return donvitinh;
	}
	public void setDonvitinh(String donvitinh) {
		this.donvitinh = donvitinh;
	}
	public NgayThang getNsx() {
		return nsx;
	}
	public void setNsx(NgayThang nsx) {
		this.nsx = nsx;
	}
	public NgayThang getHsd() {
		return hsd;
	}
	public void setHsd(NgayThang hsd) {
		this.hsd = hsd;
	}
	public Scanner getInp() {
		return inp;
	}
	public void setInp(Scanner inp) {
		this.inp = inp;
	}
	//nhập
	public void nhapMHH() {
		System.out.print("Nhập mã hàng hóa: ");
		this.maSanPham = this.maHangHoaChecking().trim();
	}
	public void nhap() {
		System.out.print("Nhập tên hàng hóa: ");
		this.tenSanPham = this.kiemTraBlank().trim();
		System.out.print("Nhập số lượng: ");
        soluong = soLuongChecking();
        System.out.print("Nhập đơn giá hàng hóa: ");
        dongia = (long) giaChecking();
        System.out.print("Nhập đơn vị tính: ");
        donvitinh = kiemTraBlank().trim();
        System.out.print("Nhập ngày sản xuất: ");
        nsx=new NgayThang();
        nsx.input_NgayThang();
        System.out.print("Nhập ngày hạn sử dụng: ");
        hsd=new NgayThang();
        hsd.input_NgayThang();
	}
	//xuất 1 sản phẩm
	public static int count = 1;
    public void xuat()
    {
        System.out.printf("|%-4d|%-15s|%-25s|%-10d|%-15s|%-15s|%-15s|%-15s|\n", count, this.maSanPham, this.tenSanPham, this.soluong , this.dongia, this.donvitinh, this.nsx, this.hsd);
        count ++;
    }
	@Override
	public String toString() {
		return maSanPham + ";" + tenSanPham + ";" + dongia + ";"
				+ soluong + ";" + donvitinh + ";" + nsx + ";" + hsd;
	}
}
