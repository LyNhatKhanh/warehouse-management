import java.util.Scanner;

public abstract class Phieu {
	protected String maPhieu;
	protected String maNhanVien;
	protected NgayThang ngayTaoPhieu;
	protected String PartnerID;
	Scanner inp = new Scanner(System.in);
	// Constructor
	public Phieu() {
		maPhieu = "";
		maNhanVien = "";
		ngayTaoPhieu = null;
	}
	public Phieu(String maPhieu, String maNhanVien, String PartnerID, NgayThang ngayTaoPhieu) {
		this.maPhieu = maPhieu;
		this.maNhanVien = maNhanVien;
		this.PartnerID = PartnerID;
		this.ngayTaoPhieu = ngayTaoPhieu;
	}
	
	// Encapsulation
	public String getMaPhieu() {
		return maPhieu;
	}
	public void setMaPhieu(String maPhieu) {
		this.maPhieu = maPhieu;
	}
	public String getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	public NgayThang getNgayTaoPhieu() {
		return ngayTaoPhieu;
	}
	public void setNgayTaoPhieu(NgayThang ngayTaoPhieu) {
		this.ngayTaoPhieu = ngayTaoPhieu;
	}
	public String getPartnerID() {
		return PartnerID;
	}
	public void setPartnerID(String partnerID) {
		PartnerID = partnerID;
	}
	// Import
	public abstract void nhapMaPhieu(); //Kiem tra khoa chinh
	public abstract void nhap();
	// Total price
	//public abstract double totalPrice();
	// Export
	public abstract void xuat();
	
	
}
