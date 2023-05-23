import java.util.Scanner;

public class DiaChi implements CheckingFormat{
	private String xaphuong;
	private String quanhuyen;
	private String tinhtp;
	private String diachicuthe;
	Scanner inp = new Scanner(System.in);
	
	// Constructor
	public DiaChi() {
		xaphuong = "";
		quanhuyen = "";
		tinhtp = "";
		diachicuthe = "";
	}
	public DiaChi(String xaphuong, String quanhuyen, String tinhtp, String diachicuthe) {
		this.xaphuong = xaphuong;
		this.quanhuyen = quanhuyen;
		this.tinhtp = tinhtp;
		this.diachicuthe = diachicuthe;
	}
	
	//Encapsulation
	public String getXaphuong() {
		return xaphuong;
	}
	public void setXaphuong(String xaphuong) {
		this.xaphuong = xaphuong;
	}
	
	public String getQuanhuyen() {
		return quanhuyen;
	}
	public void setQuanhuyen(String quanhuyen) {
		this.quanhuyen = quanhuyen;
	}

	public String getTinhtp() {
		return tinhtp;
	}
	public void setTinhtp(String tinhtp) {
		this.tinhtp = tinhtp;
	}
	
	public String getDiachicuthe() {
		return diachicuthe;
	}
	public void setDiachicuthe(String diachicuthe) {
		this.diachicuthe = diachicuthe;
	}
	//Import
	public void nhap() {
		System.out.print("Xã/Phường: ");
		this.xaphuong = kiemTraBlank().trim();
		System.out.print("Quận/Huyện: ");
		this.quanhuyen = kiemTraBlank().trim();
		System.out.print("Tỉnh/Thành Phố: ");
		this.tinhtp = kiemTraBlank().trim();
		System.out.print("Địa chỉ cụ thể: ");
		this.diachicuthe = kiemTraBlank().trim();
	}
	
	@Override
	public String toString() {
		return diachicuthe + ", " + xaphuong + ", " + quanhuyen + ", " + tinhtp;
	}
}
