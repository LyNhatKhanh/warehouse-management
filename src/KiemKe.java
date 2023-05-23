public abstract class KiemKe {
	protected String maPhieu;
	protected String maSanPham;
	protected String status;
	protected int soLuong;
	protected NgayThang time;
	public KiemKe() {
		// TODO Auto-generated constructor stub
	}
	public KiemKe(String maPhieu, String maSanPham, String status, int soLuong, NgayThang time) {
		// TODO Auto-generated constructor stub
		this.maPhieu = maPhieu;
		this.maSanPham = maSanPham;
		this.status = status;
		this.soLuong = soLuong;
		this.time = time;
	}
	//setter and getter
	public String getMaSanPham() {
		return maSanPham;
	}
	public void setMaSanPham(String maSanPham) {
		this.maSanPham = maSanPham;
	}      
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public String getMaPhieu() {
		return maPhieu;
	}
	public void setMaPhieu(String maPhieu) {
		this.maPhieu = maPhieu;
	}
	public NgayThang getTime() {
		return time;
	}
	public void setTime(NgayThang time) {
		this.time = time;
	}
	//method
	public abstract void InputP_Key();
	public abstract void Input();
	public abstract void Output();
}
