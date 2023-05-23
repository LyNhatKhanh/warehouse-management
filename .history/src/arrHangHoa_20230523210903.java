import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class arrHangHoa implements CheckingFormat{
	private List<HangHoa> list = new ArrayList<>();
	private List<HangHoa> DS_Loai = new ArrayList<>();
	private List<HangHoa> DS_tra = new ArrayList<>();
	
	Scanner inp = new Scanner(System.in);
	
	// đọc file hàng hóa tồn kho
	public void readFromFile() throws IOException {
		File temp = new File("../HangHoa.txt");
		BufferedReader br_temp = new BufferedReader(new FileReader(temp));
		String line1 = "";
		line1 = br_temp.readLine();
		if(line1 == null){
			System.out.println("Hiện không có dữ liệu, dữ liệu mặc định sẽ được tải xuống..........");
			try {
				File phieunhap = new File("HangHoa_Default.txt");
				BufferedReader brn = new BufferedReader(new FileReader(phieunhap));
				String line = "";
				while(true) {
					line = brn.readLine();
					if(line == null) {
						break;
					}
					BufferedWriter bwn = new BufferedWriter(new FileWriter(temp, true));
					bwn.write(line);
					bwn.newLine();
					bwn.close();
				}
				brn.close();
			} catch(FileNotFoundException e) {
				throw e;
			}catch(NumberFormatException e) {
				throw e;
			}finally {
				br_temp.close();
			}
			
		}
		
		try {
			FileReader fr = new FileReader("../HangHoa.txt");
			try {
				BufferedReader br = new BufferedReader(fr);
				String line = "";
				while(true) {
					line = br.readLine();
					if(line == null) {
						break;
					}
					
					String txt[] = line.split("[;/]");
					String a = txt[0];
					String b = txt[1];
					double c = Double.parseDouble(txt[2]);
					int d = Integer.parseInt(txt[3]);
					String e = txt[4];
					NgayThang date1 = new NgayThang();
					date1.setNgay(Integer.parseInt(txt[5]));
					date1.setThang(Integer.parseInt(txt[6]));
					date1.setNam(Integer.parseInt(txt[7]));
					NgayThang date2 = new NgayThang();
					date2.setNgay(Integer.parseInt(txt[8]));
					date2.setThang(Integer.parseInt(txt[9]));
					date2.setNam(Integer.parseInt(txt[10]));
					
					HangHoa create = new HangHoa(a, b, (long) c, d, e, date1, date2);
					boolean flag = true;
					int local = 0;
					for(HangHoa i : list) {
						if(i.getMaSanPham().equalsIgnoreCase(create.getMaSanPham())) {
							flag = false;
							local = list.indexOf(i);
							break;
						}
					}
					if(flag == true) {
						list.add(create);
					}	
					else {
						list.set(local, create);
					}					
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
	// đọc file hàng hóa bị trả
	public void readFromFile_tra() throws IOException {
		try {
			FileReader fr = new FileReader("DanhSachTraHang.txt");
			try {
				BufferedReader br = new BufferedReader(fr);
				String line = "";
				while(true) {
					line = br.readLine();
					if(line == null) {
						break;
					}
					
					String txt[] = line.split("[;/]");
					String a = txt[0];
					String b = txt[1];
					double c = Double.parseDouble(txt[2]);
					int d = Integer.parseInt(txt[3]);
					String e = txt[4];
					NgayThang date1 = new NgayThang();
					date1.setNgay(Integer.parseInt(txt[5]));
					date1.setThang(Integer.parseInt(txt[6]));
					date1.setNam(Integer.parseInt(txt[7]));
					NgayThang date2 = new NgayThang();
					date2.setNgay(Integer.parseInt(txt[8]));
					date2.setThang(Integer.parseInt(txt[9]));
					date2.setNam(Integer.parseInt(txt[10]));
					
					HangHoa create = new HangHoa(a, b, (long) c, d, e, date1, date2);
					boolean flag = true;
					int local = 0;
					for(HangHoa i : DS_tra) {
						if(i.getMaSanPham().equalsIgnoreCase(create.getMaSanPham())) {
							flag = false;
							local = DS_tra.indexOf(i);
							break;
						}
					}
					if(flag == true) {
						DS_tra.add(create);
					}	
					else {
						DS_tra.set(local, create);
					}					
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
	//đọc file hàng hóa bị loại
	public void readFromFile_loai() throws IOException {
		try {
			FileReader fr = new FileReader("DanhSachHangBiLoai.txt");
			try {
				BufferedReader br = new BufferedReader(fr);
				String line = "";
				while(true) {
					line = br.readLine();
					if(line == null) {
						break;
					}
					
					String txt[] = line.split("[;/]");
					String a = txt[0];
					String b = txt[1];
					double c = Double.parseDouble(txt[2]);
					int d = Integer.parseInt(txt[3]);
					String e = txt[4];
					NgayThang date1 = new NgayThang();
					date1.setNgay(Integer.parseInt(txt[5]));
					date1.setThang(Integer.parseInt(txt[6]));
					date1.setNam(Integer.parseInt(txt[7]));
					NgayThang date2 = new NgayThang();
					date2.setNgay(Integer.parseInt(txt[8]));
					date2.setThang(Integer.parseInt(txt[9]));
					date2.setNam(Integer.parseInt(txt[10]));
					HangHoa create = new HangHoa(a, b, (long) c, d, e, date1, date2);
					boolean flag = true;
					int local = 0;
					for(HangHoa i : DS_Loai) {
						if(i.getMaSanPham().equalsIgnoreCase(create.getMaSanPham())) {
							flag = false;
							local = DS_Loai.indexOf(i);
							break;
						}
					}
					if(flag == true) {
						DS_Loai.add(create);
					}	
					else {
						DS_Loai.set(local, create);
					}							
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
	//sửa, xóa , tìm kiếm
	public void fix() {
		System.out.print("Chọn mã hàng hóa bạn muốn sửa: ");
		String fix_id = this.maHangHoaChecking();
		boolean off = true;
		boolean flag = true;
		int replace = 0;
		while(off == true) {
			for(int j = 0; j<list.size(); j++) {
				if(fix_id.equalsIgnoreCase(list.get(j).getMaSanPham())) {
					flag = false;
					replace = j;
				}
			}
			if(flag == false) {
				System.out.println("Mời nhập lại thông tin (xin nhập lại tất cả, chức năng sửa từng thuộc tính sẽ được nâng cấp sau): ");
				list.get(replace).nhapMHH();;
				boolean off1 = true;
				boolean flag1 = true;
				while(off1 == true) {
					for(int j = replace-1; j>=0; j--) {
						if(list.get(replace).getMaSanPham().equalsIgnoreCase(list.get(j).getMaSanPham())) {
							flag1 = false;
						}
					}
					for(int j = replace+1; j<list.size(); j++) {
						if(list.get(replace).getMaSanPham().equalsIgnoreCase(list.get(j).getMaSanPham())) {
							flag1 = false;
						}
					}
					if(flag1 == false) {
						System.out.println("Mã hàng hóa đã tồn tại, xin mời nhập mã khác !!!!!");
						list.get(replace).nhapMHH();
						flag1 = true;
					}
					else if(flag1 == true) {
						off1 = false;
					}
				}
				list.get(replace).nhap();
				off = false;
			}
			else if(flag == true) {
				System.out.println("Mã hàng hóa không tồn tại!!!!");
				fix_id = this.IDPNchecking();
				off = true;
			}
		}
		File file_replace = new File("../HangHoa.txt");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file_replace));
			for(HangHoa i : list) {
				bw.write(i.toString());
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void delete() {
		System.out.print("Nhập mã hàng hóa bạn muốn xóa: ");
		String delete_id = this.maHangHoaChecking();
		boolean off = true;
		boolean flag = true;
		int delete_index = 0;
		while(off == true) {
			for(int j = 0; j<list.size(); j++) {
				if(delete_id.equalsIgnoreCase(list.get(j).getMaSanPham())) {
					flag = false;
					delete_index = j;
				}
			}
			if(flag == false) {
				for(int j = 0; j<list.size(); j++) {
					if(delete_id.equalsIgnoreCase(list.get(j).getMaSanPham())) {
						list.remove(delete_index);
					}
				}
				off = false;
			}
			else if(flag == true) {
				System.out.println("Mã hàng hóa không tồn tại!!!!");
				delete_id = this.maHangHoaChecking();
				off = true;
			}
		}
		File file_delete = new File("../HangHoa.txt");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file_delete));
			for(HangHoa i : list) {
				bw.write(i.toString());
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void sort() {
		//Tu tu code
		Collections.sort(list, new Comparator<HangHoa>() {

			@Override
			public int compare(HangHoa o1, HangHoa o2) {
				// TODO Auto-generated method stub
				return o1.getMaSanPham().compareTo(o2.getMaSanPham());
			}
		});
		File file_sort = new File("../HangHoa.txt");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file_sort));
			for(HangHoa i : list) {
				bw.write(i.toString());
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void search(String enter) {
		System.out.print("Đang tìm kiếm.............\n");
		System.out.println("===========================================Danh Sách Hàng Hóa Tồn Kho========================================\n");
		System.out.printf("|%-4s|%-15s|%-25s|%-10s|%-15s|%-15s|%-15s|%-15s|", "STT", "Mã hàng hóa", "Tên hàng hóa", "Số lượng", "Giá", "Đơn vị tính", "Ngày sản xuất", "Hạn sử dụng");
		System.out.println("");
		for(int j = 0; j<list.size(); j++) {
			if(enter.equalsIgnoreCase(list.get(j).getMaSanPham()) || enter.equalsIgnoreCase(list.get(j).getTenSanPham()) || enter.equalsIgnoreCase(list.get(j).getDonvitinh())) {
				list.get(j).xuat();
			}
		}
		
		HangHoa.count = 1;
	}
	//xuất
	public void xuatMang()
    {
        System.out.println("===========================================Danh Sách Hàng Hóa Tồn Kho========================================\n");
        System.out.printf("|%-4s|%-15s|%-25s|%-10s|%-15s|%-15s|%-15s|%-15s|", "STT", "Mã hàng hóa", "Tên hàng hóa", "Số lượng", "Giá", "Đơn vị tính", "Ngày sản xuất", "Hạn sử dụng");	
        System.out.println("");
		for(HangHoa i : list) {
			i.xuat();
		}
		
		HangHoa.count = 1;
    }
	public void xuatDS_tra() {
		System.out.println("===========================================Danh Sách Hàng Hóa Cần Trả========================================\n");
		System.out.printf("|%-4s|%-15s|%-25s|%-10s|%-15s|%-15s|%-15s|%-15s|", "STT", "Mã hàng hóa", "Tên hàng hóa", "Số lượng", "Giá", "Đơn vị tính", "Ngày sản xuất", "Hạn sử dụng");		
		System.out.println("");
		for(HangHoa i : DS_tra) {
			i.xuat();
		}
		
		HangHoa.count = 1;
	}
	public void xuatDS_loai() {
		System.out.println("===========================================Danh Sách Hàng Hóa Bị Loại========================================\n");
		System.out.printf("|%-4s|%-15s|%-25s|%-10s|%-15s|%-15s|%-15s|%-15s|", "STT", "Mã hàng hóa", "Tên hàng hóa", "Số lượng", "Giá", "Đơn vị tính", "Ngày sản xuất", "Hạn sử dụng");
		System.out.println("");
		for(HangHoa i : DS_Loai) {
			i.xuat();
		}
		
		HangHoa.count = 1;
	}
	public static void main(String args[]) throws IOException {
		arrHangHoa a = new arrHangHoa();
		a.readFromFile();
		a.xuatMang();
		
		
	}
}
