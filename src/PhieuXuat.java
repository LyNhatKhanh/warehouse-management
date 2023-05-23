import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class PhieuXuat extends Phieu implements CheckingFormat{
	Scanner inp = new Scanner(System.in);
	private List<PhieuXuat> list_PX = new ArrayList<>();
	private List<chiTietPhieuXuat> list = new ArrayList<>(); 
	//Constructor
	public PhieuXuat() {
		super();
	}
	public PhieuXuat(String maPhieu, String maNhanVien, String PartnerID, NgayThang ngayTaoPhieu) {
		super(maPhieu, maNhanVien, PartnerID, ngayTaoPhieu);
	}

		
	// Method
	@Override
	public void nhapMaPhieu() {
		System.out.print("Nhập mã phiếu xuất: ");
		super.maPhieu = IDPXchecking();
	}
	@Override
	public void nhap() {
		System.out.print("Nhập mã nhân viên tạo phiếu: ");
		super.maNhanVien = IDNVchecking();
		System.out.print("Nhập mã cửa hàng cần cung cấp: ");
		super.PartnerID = IDCHchecking();
		System.out.print("Nhập ngày tạo phiếu: ");
		super.ngayTaoPhieu = new NgayThang();
		ngayTaoPhieu.input_NgayThang();
	}
	//đọc file chi tiết phiếu xuất
	public void readFromFile() throws IOException {
		try {
			FileReader fr = new FileReader("ChiTietPhieuXuat.txt");
			try {
				BufferedReader br = new BufferedReader(fr);
				String line = "";
				while(true) {
					line = br.readLine();
					if(line == null) {
						break;
					}
					
					String txt[] = line.split("[;/]");
					String q = txt[0];
					String a = txt[1];
					String b = txt[2];
					double c = Double.parseDouble(txt[3]);
					int d = Integer.parseInt(txt[4]);
					String e = txt[5];
					NgayThang date1 = new NgayThang();
					date1.setNgay(Integer.parseInt(txt[6]));
					date1.setThang(Integer.parseInt(txt[7]));
					date1.setNam(Integer.parseInt(txt[8]));
					NgayThang date2 = new NgayThang();
					date2.setNgay(Integer.parseInt(txt[9]));
					date2.setThang(Integer.parseInt(txt[10]));
					date2.setNam(Integer.parseInt(txt[11]));
					chiTietPhieuXuat create = new chiTietPhieuXuat(a, b, (long) c, d, e, date1, date2, q);
					list.add(create);					
				}
				br.close();
			} catch (FileNotFoundException e) {
				throw e;
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			fr.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//đọc file từ phiếu xuất
	public void readFromFile_PX() throws IOException {
		try {
			FileReader fr = new FileReader("Phieu.txt");
			try {
				BufferedReader br = new BufferedReader(fr);
				String line = "";
				while(true) {
					line = br.readLine();
					if(line == null) {
						break;
					}
					String txt[] = line.split("[;/]");
					String fileIDpx = txt[0];
					String fileIDnv = txt[1];
					String fileIDch = txt[2];
					NgayThang fileDate = new NgayThang();
					fileDate.setNgay(Integer.parseInt(txt[3]));
					fileDate.setThang(Integer.parseInt(txt[4]));
					fileDate.setNam(Integer.parseInt(txt[5]));
					PhieuXuat create = new PhieuXuat(fileIDpx, fileIDnv, fileIDch, fileDate);
					list_PX.add(create);
				}
				br.close();
			} catch (FileNotFoundException e) {
				throw e;
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//tính tổng giá
	public static HashMap<String, Long> total_Price = new HashMap<String, Long>(); 
	public void totalPrice() {
		for(PhieuXuat i: list_PX) {
			long total = 0;
			for(chiTietPhieuXuat j : list) {
				if(i.getMaPhieu().equalsIgnoreCase(j.getMaPhieuXuat())) {
					total += j.getDongia()*j.soluong;
				}
			}
			total_Price.put(i.getMaPhieu(), total);
		}
	}
	public static int  count = 1;
	@Override
	public void xuat() {
		System.out.printf("%-4d %-15s %-15s %-20s %-25s %-10d\n", count, super.maPhieu, super.maNhanVien, super.PartnerID, super.ngayTaoPhieu.toString(), total_Price.get(maPhieu));
		count++;
	}
	public String toString() {
		return super.maPhieu + ";" + super.maNhanVien + ";" + super.PartnerID + ";" + super.ngayTaoPhieu.toString();
	}
	
	

}
