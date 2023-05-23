
import java.util.Scanner;

public class KiemKeXuat extends KiemKe implements CheckingFormat{
	Scanner inp = new Scanner(System.in);
	//Constructor
	public KiemKeXuat() {
		super();
	}
	public KiemKeXuat(String maPhieu, String maSanPham, String status, int soLuong, NgayThang time) {
		super(maPhieu, maSanPham, status, soLuong, time);
	}
	//method	
	@Override
	public void InputP_Key() {
		System.out.print("Nhập mã phiếu xuất: ");
		maPhieu = IDPXchecking().trim();
		System.out.print("Nhập mã hàng hóa: ");
		super.maSanPham = maHangHoaChecking().trim();
	}
	@Override
	public void Input() {
		System.out.print("Nhập tình trạng hàng hóa [chưa xuất: x][đã xuất: v]: ");
		super.status = this.checkStatus().trim();
		System.out.println("Số lượng hàng hóa bị loại: ");
		super.soLuong = this.soLuongChecking();
		System.out.println("Nhập ngày kiểm kê");
		super.time = new NgayThang();
		time.input_NgayThang();
	}
	
	//xuat
	public static int  count = 1;
	@Override
	public void Output() {
		System.out.printf("%-4d %-15s %-15s %-10s %-15d %-25s", count, super.maPhieu, super.maSanPham, super.status, super.soLuong, super.time.toString());
		count++;
	}
	@Override
	public String toString() {
		return maPhieu + ";" + maSanPham + ";"+ status + ";"+ soLuong + ";" + time.toString();
	}
	
	
	

}

