
import java.util.Scanner;

public class NgayThang implements CheckingFormat{
	private int ngay;
	private int thang;
	private int nam;
	Scanner inp = new Scanner(System.in);
	public NgayThang() {
		
	}
	public NgayThang(int ngay, int thang, int nam) {
		this.ngay = ngay;
		this.thang = thang;
		this.nam = nam;
	}

	public int getNgay() {
		return ngay;
	}

	public void setNgay(int ngay) {
		if(ngay >= 1 && ngay <= 31) {
			this.ngay = ngay;
		}	
		else if(ngay < 1) {
			this.ngay = 1;
		}
		else if(ngay > 31) {
			this.ngay = 31;
		}
	}
	
	public int getThang() {
		return thang;
	}

	public void setThang(int thang) {
		if(thang >= 1 && thang <= 12) {
			this.thang = thang;
		}
		else if(thang < 1) {
			this.thang = 1;
		}
		else if(thang > 12) {
			this.thang = 12;
		}
	}

	public int getNam() {
		return nam;
	}

	public void setNam(int nam) {
		if(nam >= 1) {
			this.nam = nam;
		}
		else {
			this.nam = 2022;
		}
	}
	
	//Hàm kiểm tra năm nhuận
	public boolean check_namnhuan(int nam) {
		if ((this.nam % 4 == 0 && this.nam % 100 != 0) || this.nam % 400 == 0) {
			return true;
		}
		return false;
	}
	//Hàm nhập ngày tháng năm
	public void input_NgayThang() {
		boolean off = true;
		while (off == true) {
			System.out.println("Vui lòng nhập ngày tháng năm !!");
			ngay = this.ngayThangChecking();
			thang = this.ngayThangChecking();
			nam = this.ngayThangChecking();
			int nNumOfDays = 0;
			switch (thang) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				nNumOfDays = 31;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				nNumOfDays = 30;
				break;
			case 2:
				if (check_namnhuan(nam)) {
					nNumOfDays = 29;
				} else {
					nNumOfDays = 28;
				}
				break;
			}
			if(nam > 0 && (thang > 0 && thang <= 12) && (ngay > 0 && ngay <= nNumOfDays)) {
				off = false;
			}else {
				System.out.println("Nhập sai, xin vui lòng nhập lại !!");
			}
		}
	}
	
	//Hàm xuất ngày tháng năm
	@Override
	public String toString() {
		return ngay + "/" + thang + "/" + nam;
	}
}
