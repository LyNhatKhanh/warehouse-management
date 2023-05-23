import java.util.Scanner;

public class NhanVien implements CheckingFormat{
	protected String maNhanVien;
	protected String hoVaTen;
	private String gioiTinh;
	private NgayThang ngaySinh;
	private String soDienThoai;
	private DiaChi diaChi;
	private String canCuoc;
	private String email;
	private NgayThang ngayVaoLam;
    private long luongCoBan;
    private long luongThuong;
	Scanner sc = new Scanner(System.in);
	
	public NhanVien() {
		
	}
	
	public NhanVien(String maNhanVien, String hoVaTen, String gioiTinh, NgayThang ngaySinh, String soDienThoai,
			DiaChi diaChi, String canCuoc, String email, NgayThang ngayVaoLam, long luongCoBan, long luongThuong) {
		this.maNhanVien = maNhanVien;
		this.hoVaTen = hoVaTen;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
		this.canCuoc = canCuoc;
		this.email = email;
		this.ngayVaoLam = ngayVaoLam;
		this.luongCoBan = luongCoBan;
		this.luongThuong = luongThuong;
	}

	public NgayThang getNgayVaoLam() {
		return ngayVaoLam;
	}

	public void setNgayVaoLam(NgayThang ngayVaoLam) {
		this.ngayVaoLam = ngayVaoLam;
	}

	public double getLuongCoBan() {
		return luongCoBan;
	}

	public void setLuongCoBan(long luongCoBan) {
		this.luongCoBan = luongCoBan;
	}

	public double getLuongThuong() {
		return luongThuong;
	}

	public void setLuongThuong(long luongThuong) {
		this.luongThuong = luongThuong;
	}

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public String getHoVaTen() {
		return hoVaTen;
	}

	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public NgayThang getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(NgayThang ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public DiaChi getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(DiaChi diaChi) {
		this.diaChi = diaChi;
	}

	public String getCanCuoc() {
		return canCuoc;
	}

	public void setCanCuoc(String canCuoc) {
		this.canCuoc = canCuoc;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	//Hàm kiểm tra mã nhân viên
	
	
	public void input_MaNhanVien() {	
		System.out.print("Nhập mã nhân viên (VD:NV_số):");
		maNhanVien = IDNVchecking();
	}

	//Hàm nhập thông tin của Nhân Viên
	public void input_NhanVien() {
		System.out.print("Nhập họ và tên:");
		this.hoVaTen = chuanhoa().trim();

		System.out.print("Nhập giới tính:");
		this.gioiTinh = chuanhoa().trim();
		
		System.out.println("----Nhập ngày sinh----");
		ngaySinh = new NgayThang();
		ngaySinh.input_NgayThang();
		
		System.out.print("Nhập số điện thoại(10 số):");
		this.soDienThoai = check_sdt();

		System.out.println("----Nhập địa chỉ----");
		diaChi = new DiaChi();
		diaChi.nhap();

		System.out.print("Nhập số CCCD(12 số):");
		canCuoc = sc.nextLine();
		if(canCuoc.length() != 12) {
			System.out.println("Vui lòng nhập lại !!");
			canCuoc = sc.nextLine();
		}
		System.out.print("Nhập địa chỉ email (VD:tên@gmail.com):");
		email = check_email();

		System.out.print("Nhập ngày vào làm: ");
		NgayThang nvl = new NgayThang();
		nvl.setNgay(sc.nextInt());
		nvl.setThang(sc.nextInt());
		nvl.setNam(sc.nextInt());
		this.ngayVaoLam = nvl;

		System.out.print("Lương cơ bản: ");
		this.luongCoBan = giaChecking();
		
		System.out.print("Lương thưởng: ");
		this.luongThuong = giaChecking();
	}
	
	
	//Hàm xuất thông tin của Nhân Viên
	public void output_NhanVien() {
		
		System.out.format("%10s" , "╔======================================================================╗\n");
		System.out.format("%10s" , "                           Thông tin Nhân Viên                          \n");
		System.out.format("%10s" , "  Mã nhân viên:" + maNhanVien +  "\n");
		System.out.format("%10s" , "  Họ và Tên: " + hoVaTen + "\n");
		System.out.format("%10s" , "  Giới tính: " + gioiTinh + "\n");
		System.out.format("%10s" , "  Ngày sinh: " + ngaySinh + "\n");
		System.out.format("%10s" , "  Số điện thoại: " + soDienThoai + "\n");
		System.out.format("%10s" , "  Địa chỉ: " + diaChi + "\n");
		System.out.format("%10s" , "  Căn cước: " + canCuoc + "\n");
		System.out.format("%10s" , "  Email: " + email + "\n");		
		System.out.format("%10s" , "  Ngày vào làm: " + ngayVaoLam + "\n");		
		System.out.format("%10s" , "  Lương cơ bản: " + luongCoBan + "\n");		
		System.out.format("%10s" , "  Lương thưởng: " + luongThuong + "\n");		
		System.out.format("%10s" , "╚======================================================================╝\n");	
	}

	public static int  count = 1;

	public void xuat() {
		System.out.printf("%-3s %-10s %-18s %-5s %-13s %-12s %-15s %-15s %-22s %-15s %-15s %-15s\n", count, this.maNhanVien, this.hoVaTen, this.gioiTinh, this.ngaySinh.toString(), this.soDienThoai, this.diaChi.getTinhtp(), this.canCuoc, this.email, this.ngayVaoLam.toString(), String.valueOf(this.luongCoBan), String.valueOf(this.luongThuong));
		count++;
	}

	public String toString() {
		return this.maNhanVien + ";" + this.hoVaTen + ";" + this.gioiTinh + ";" + this.ngaySinh.toString() + ";" + this.soDienThoai + ";" + this.diaChi.getTinhtp() + ";" + this.canCuoc + ";" + this.email+ ";" + this.ngayVaoLam.toString() + ";" + this.luongCoBan + ";" + this.luongThuong;
	}

	public static void main(String[] args) {
		NhanVien nv = new NhanVien();
		nv.input_NhanVien();
		nv.output_NhanVien();
		nv.xuat();
		nv.toString();
	}

}

