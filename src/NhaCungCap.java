
public class NhaCungCap extends ChuThe implements CheckingFormat{
	private String maNhaCungCap;

	public NhaCungCap() {
		super();
	}

	public NhaCungCap(String maNhaCungCap, String tenChuThe, String soDienThoai, String email, DiaChi diaChi) {
		super(tenChuThe, soDienThoai, diaChi, email);
		this.maNhaCungCap = maNhaCungCap;
	}

	public String getMaNhaCungCap() {
		return maNhaCungCap;
	}

	public void setMaNhaCungCap(String maNhaCungCap) {
		this.maNhaCungCap = maNhaCungCap;
	}
	
	
	public String input_mncc() {
		System.out.print("Nhập mã nhà cung cấp (VD:SUP___):");
		maNhaCungCap = IDNCCchecking();
		return maNhaCungCap;
	}
	public boolean check_tct(boolean kt_ten) {
		//Nếu tên rỗng sẽ xuất ra thông báo
		if(this.getTenChuThe() == "" || this.tenChuThe.isEmpty()) {
			System.out.println("Thông tin không được để trống !!");
		}else {
			kt_ten = false;
		}
		return kt_ten;
	}
	@Override
	public void input_tct() {
		boolean kt = true;
		do {
			System.out.print("Nhập tên nhà cung cấp:");
			super.tenChuThe = chuanhoa().trim();
		}while(check_tct(kt));
	}
	@Override
	public void input_sdt() {
		System.out.print("Nhập số điện thoại (VD:0...):");
		super.soDienThoai = check_sdt();
	}
	@Override
	public void input_email() {
		System.out.print("Nhập email (VD:ten@gmail.com):");
		super.email = check_email();
	}
	@Override
	public void input_diachi() {
		System.out.println("Nhập địa chỉ:");
		diaChi = new DiaChi();
		diaChi.nhap();
	}

	public static int  count = 1;
	@Override
	public void output() {
		System.out.printf("%-4s %-15s %-25s %-20s %-25s %-30s\n", count, maNhaCungCap, super.tenChuThe, super.soDienThoai, super.email , super.diaChi);
		count++;
	}
	@Override
	public String toString() {
		return maNhaCungCap + "," + tenChuThe + "," + soDienThoai + "," + email + "," + diaChi ;
	}
	
}
