import java.util.Scanner;

public abstract class ChuThe{
	protected String tenChuThe;
	protected String soDienThoai;
	protected DiaChi diaChi;
	protected String email;
	Scanner inp = new Scanner(System.in);
	
	public ChuThe() {
		
	}
	public ChuThe(String tenChuThe, String soDienThoai, DiaChi diaChi, String email) {
		this.tenChuThe = tenChuThe;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
		this.email = email;
	}
	
	public String getTenChuThe() {
		return tenChuThe;
	}
	
	public void setTenChuThe(String tenChuThe) {
		this.tenChuThe = tenChuThe;
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
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
		
	public abstract void input_tct();
	public abstract void input_sdt();
	public abstract void input_email();
	public abstract void input_diachi();
	public abstract void output();
}
