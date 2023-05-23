import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class arrPhieu implements ReadFile, WriteFile, CheckingFormat{
	private List<Phieu> list = new ArrayList<>();
	public String ID_login = "NV001";
	Scanner inp = new Scanner(System.in);
	public arrPhieu() {
		
	}
	// thực hiện quy trình nhập
	public void execute_nhap() {
		this.readFromFile();
		MangChiTietPhieuNhap a = new MangChiTietPhieuNhap();
		//nhập phiếu
		try {
			FileWriter fw = new FileWriter("Phieu.txt", true);	
			BufferedWriter bw = new BufferedWriter(fw);		
			System.out.println("Đang tạo phiếu..........");
			Phieu pn = new PhieuNhap();
			pn.nhapMaPhieu();
			boolean off = true;
			boolean flag = true;
			while(off == true) {
				for(int j = 0; j<list.size(); j++) {
					if(pn.getMaPhieu().equalsIgnoreCase(list.get(j).getMaPhieu())) {
						flag = false;
					}
				}
				if(flag == false) {
					System.out.println("Mã phiếu đã tồn tại, xin mời nhập mã khác !!!!!");
					pn.nhapMaPhieu();
					flag = true;
				}
				else if(flag == true) {
					off = false;
				}
			}
			pn.nhap();
			pn.setMaNhanVien(ID_login);
			list.add(pn);
			bw.write(pn.toString());
			bw.newLine();
			bw.close();
			fw.close();
			//nhập chi tiết phiếu
			boolean cont_p = true;
			boolean cont = true;
			do {
				a.execute_ct_nhap(pn.getMaPhieu());
				do {
					System.out.println("Bạn có muốn nhập tiếp không ? [y/n]");
					String opt = inp.nextLine();
					if(opt.equalsIgnoreCase("y")) {					
						cont = false;
						cont_p = true;
					}
					else if(opt.equalsIgnoreCase("n")) {
						cont = false;		
						cont_p = false;
					}
					else {
						cont = true;
					}
				}while(cont);
			}while(cont_p);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//quy trình xuất
	public void execute_xuat() {
		this.readFromFile();
		MangChiTietPhieuXuat a = new MangChiTietPhieuXuat();
		//nhập phiếu
		try {
			FileWriter fw = new FileWriter("Phieu.txt", true);	
			BufferedWriter bw = new BufferedWriter(fw);		
			System.out.println("Đang tạo phiếu..........");
			Phieu px = new PhieuXuat();
			px.nhapMaPhieu();
			boolean off = true;
			boolean flag = true;
			while(off == true) {
				for(int j = 0; j<list.size(); j++) {
					if(px.getMaPhieu().equalsIgnoreCase(list.get(j).getMaPhieu())) {
						flag = false;
					}
				}
				if(flag == false) {
					System.out.println("Mã phiếu đã tồn tại, xin mời nhập mã khác !!!!!");
					px.nhapMaPhieu();
					flag = true;
				}
				else if(flag == true) {
					off = false;
				}
			}
			px.nhap();
			px.setMaNhanVien(ID_login);
			list.add(px);
			bw.write(px.toString());
			bw.newLine();
			bw.close();
			fw.close();
			//nhập chi tiết phiếu
			boolean cont_p = true;
			boolean cont = true;
			do {
				a.execute_ct_xuat(px.getMaPhieu());
				do {
					System.out.println("Bạn có muốn nhập tiếp không ? [y/n]");
					String opt = inp.nextLine();
					if(opt.equalsIgnoreCase("y")) {					
						cont = false;
						cont_p = true;
					}
					else if(opt.equalsIgnoreCase("n")) {
						cont = false;		
						cont_p = false;
					}
					else {
						cont = true;
					}
				}while(cont);
			}while(cont_p);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//nhập phiếu nhập
	@Override
	public void input_n() {
		// TODO Auto-generated constructor stub
		try {
			FileWriter fw = new FileWriter("Phieu.txt", true);	
			BufferedWriter bw = new BufferedWriter(fw);		
			System.out.println("Đang tạo phiếu..........");
			Phieu pn = new PhieuNhap();
			pn.nhapMaPhieu();
			boolean off = true;
			boolean flag = true;
			while(off == true) {
				for(int j = 0; j<list.size(); j++) {
					if(pn.getMaPhieu().equalsIgnoreCase(list.get(j).getMaPhieu())) {
						flag = false;
					}
				}
				if(flag == false) {
					System.out.println("Mã phiếu đã tồn tại, xin mời nhập mã khác !!!!!");
					pn.nhapMaPhieu();
					flag = true;
				}
				else if(flag == true) {
					off = false;
				}
			}
			pn.nhap();
			list.add(pn);
			bw.write(pn.toString());
			bw.newLine();
			bw.close();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	//nhập phiếu xuất
	@Override
	public void input_x() {
		// TODO Auto-generated method stub
		try {
			FileWriter fw = new FileWriter("Phieu.txt", true);	
			BufferedWriter bw = new BufferedWriter(fw);
			System.out.println("Dang tao phieu..........");
			System.out.println(list.size());
			Phieu px = new PhieuXuat();
			px.nhapMaPhieu();
			boolean off = true;
			boolean flag = true;
			while(off == true) {
				for(int j = 0; j<list.size(); j++) {
					if(px.getMaPhieu().equalsIgnoreCase(list.get(j).getMaPhieu())) {
						flag = false;
					}
				}
				if(flag == false) {
					System.out.println("Mã phiếu đã tồn tại, xin mời nhập mã khác !!!!!");
					px.nhapMaPhieu();
					flag = true;
				}
				else if(flag == true) {
					off = false;
				}
			}
			px.nhap();
			list.add(px);
			bw.write(px.toString());
			bw.newLine();
			bw.close();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
	}
	
	@Override
	public void readFromFile() {
		// TODO Auto-generated method stub
		File temp = new File("Phieu.txt");
		BufferedReader br_temp;
		try {
			br_temp = new BufferedReader(new FileReader(temp));
			String line1 = "";
			line1 = br_temp.readLine();
			if(line1 == null){
				System.out.println("Hiện không có dữ liệu, dữ liệu mặc định sẽ được tải xuống..........");
				try {
					File phieunhap = new File("Phieu_Default.txt");
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
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}			
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
					if(fileIDpx.contains("PN")) {
						Phieu create = new PhieuNhap(fileIDpx, fileIDnv,fileIDch, fileDate);
						boolean flag = true;
						int local = 0;
						for(Phieu i : list) {
							if(i.getMaPhieu().equals(create.getMaPhieu())) {
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
					else if(fileIDpx.contains("PX")) {
						PhieuXuat create = new PhieuXuat(fileIDpx, fileIDnv, fileIDch, fileDate);
						boolean flag = true;
						int local = 0;
						for(Phieu i : list) {
							if(i.getMaPhieu().equals(create.getMaPhieu())) {
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
				}
				br.close();
			} catch (FileNotFoundException e) {
				throw e;
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public void output_1() {
		// TODO Auto-generated method stub
		System.out.println("========================================Danh Sách Phiếu Nhập=======================================\n");
		System.out.printf("%-4s %-15s %-15s %-20s %-25s %-15s\n", "STT", "Mã phiếu", "Mã Nhân Viên", "Mã nhà cung cấp", "Ngày tạo phiếu", "Tổng giá(VNĐ)");
		PhieuNhap a = new PhieuNhap();
		try {
			a.readFromFile();
			a.readFromFile_PN();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		a.totalPrice();
		for(Phieu i : list) {
			if(i instanceof PhieuNhap ) {
				i.xuat();
			}
		}
		PhieuNhap.count = 1;
	}
	
	@Override
	public void output_2() {
		// TODO Auto-generated method stub
		System.out.println("====================Danh Sách Phiếu Xuất======================\n");
		System.out.printf("%-4s %-15s %-15s %-20s %-25s %-15s\n", "STT", "Mã phiếu", "Mã Nhân Viên", "Mã cửa hàng", "Ngày tạo phiếu", "Tổng giá(VNĐ)");
		PhieuXuat a = new PhieuXuat();
		try {
			a.readFromFile();
			a.readFromFile_PX();;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		a.totalPrice();
		for(Phieu i : list) {
			if(i instanceof PhieuXuat) {
				i.xuat();
			}
		}
		PhieuXuat.count = 1;
	}

	@Override
	public void fix_1() {
		// TODO Auto-generated method stub
		System.out.print("Chọn mã phiếu nhập bạn muốn sửa: ");
		String fix_id = this.IDPNchecking();
		boolean off = true;
		boolean flag = true;
		int replace = 0;
		while(off == true) {
			for(int j = 0; j<list.size(); j++) {
				if(fix_id.equalsIgnoreCase(list.get(j).getMaPhieu())) {
					flag = false;
					replace = j;
				}
			}
			if(flag == false) {
				System.out.println("Mời nhập lại thông tin (xin nhập lại tất cả, chức năng sửa từng thuộc tính sẽ được nâng cấp sau): ");
				list.get(replace).nhapMaPhieu();
				boolean off1 = true;
				boolean flag1 = true;
				while(off1 == true) {
					for(int j = replace-1; j>=0; j--) {
						if(list.get(replace).getMaPhieu().equalsIgnoreCase(list.get(j).getMaPhieu())) {
							flag1 = false;
						}
					}
					for(int j = replace+1; j<list.size(); j++) {
						if(list.get(replace).getMaPhieu().equalsIgnoreCase(list.get(j).getMaPhieu())) {
							flag1 = false;
						}
					}
					if(flag1 == false) {
						System.out.println("Mã phiếu đã tồn tại, xin mời nhập mã khác !!!!!");
						list.get(replace).nhapMaPhieu();
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
				System.out.println("Mã phiếu nhập không tồn tại!!!!");
				fix_id = this.IDPNchecking();
				off = true;
			}
		}
		File file_replace = new File("Phieu.txt");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file_replace));
			for(Phieu i : list) {
				bw.write(i.toString());
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void fix_2() {
		// TODO Auto-generated method stub
		System.out.print("Chọn mã phiếu xuất bạn muốn sửa: ");
		String fix_id = this.IDPXchecking();
		boolean off = true;
		boolean flag = true;
		int replace = 0;
		while(off == true) {
			for(int j = 0; j<list.size(); j++) {
				if(fix_id.equalsIgnoreCase(list.get(j).getMaPhieu())) {
					flag = false;
					replace = j;
				}
			}
			if(flag == false) {
				System.out.println("Mời nhập lại thông tin (xin nhập lại tất cả, chức năng sửa từng thuộc tính sẽ được nâng cấp sau): ");
				list.get(replace).nhapMaPhieu();
				boolean off1 = true;
				boolean flag1 = true;
				while(off1 == true) {
					for(int j = replace-1; j>=0; j--) {
						if(list.get(replace).getMaPhieu().equalsIgnoreCase(list.get(j).getMaPhieu())) {
							flag1 = false;
						}
					}
					for(int j = replace+1; j<list.size(); j++) {
						if(list.get(replace).getMaPhieu().equalsIgnoreCase(list.get(j).getMaPhieu())) {
							flag1 = false;
						}
					}
					if(flag1 == false) {
						System.out.println("Mã phiếu đã tồn tại, xin mời nhập mã khác !!!!!");
						list.get(replace).nhapMaPhieu();
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
				System.out.println("Mã phiếu xuất không tồn tại!!!!");
				fix_id = this.IDPXchecking();
				off = true;
			}
		}
		File file_replace = new File("Phieu.txt");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file_replace));
			for(Phieu i : list) {
				bw.write(i.toString());
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete_1() {
		// TODO Auto-generated method stub
		System.out.print("Chọn mã phiếu nhập bạn muốn xóa: ");
		String delete_id = this.IDPNchecking();
		boolean off = true;
		boolean flag = true;
		int delete_index = 0;
		while(off == true) {
			for(int j = 0; j<list.size(); j++) {
				if(delete_id.equalsIgnoreCase(list.get(j).getMaPhieu())) {
					flag = false;
					delete_index = j;
				}
			}
			if(flag == false) {
				for(int j = 0; j<list.size(); j++) {
					if(delete_id.equalsIgnoreCase(list.get(j).getMaPhieu())) {
						list.remove(delete_index);
					}
				}
				off = false;
			}
			else if(flag == true) {
				System.out.println("Mã phiếu nhập không tồn tại!!!!");
				delete_id = this.IDPNchecking();
				off = true;
			}
		}
		File file_delete = new File("Phieu.txt");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file_delete));
			for(Phieu i : list) {
				bw.write(i.toString());
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete_2() {
		// TODO Auto-generated method stub
		System.out.print("Chọn mã phiếu xuất bạn muốn xóa: ");
		String delete_id = this.IDPXchecking();
		boolean off = true;
		boolean flag = true;
		int delete_index = 0;
		while(off == true) {
			for(int j = 0; j<list.size(); j++) {
				if(delete_id.equalsIgnoreCase(list.get(j).getMaPhieu())) {
					flag = false;
					delete_index = j;
				}
			}
			if(flag == false) {
				for(int j = 0; j<list.size(); j++) {
					if(delete_id.equalsIgnoreCase(list.get(j).getMaPhieu())) {
						list.remove(delete_index);
					}
				}
				off = false;
			}
			else if(flag == true) {
				System.out.println("Mã phiếu xuất không tồn tại!!!!");
				delete_id = this.IDPXchecking();
				off = true;
			}
		}
		File file_delete = new File("Phieu.txt");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file_delete));
			for(Phieu i : list) {
				bw.write(i.toString());
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void search__1() {
		// TODO Auto-generated method stub
		System.out.print("Nhập nội dung bạn muốn tìm kiếm: ");
		String enter = inp.nextLine();
		System.out.print("Đang tìm kiếm.............\n");
		System.out.println("========================================Danh Sách Phiếu Nhập=======================================\n");
		System.out.printf("%-4s %-15s %-15s %-20s %-25s %-15s\n", "STT", "Mã phiếu", "Mã Nhân Viên", "Mã nhà cung cấp", "Ngày tạo phiếu", "Tổng giá");
		PhieuNhap a = new PhieuNhap();
		try {
			a.readFromFile();
			a.readFromFile_PN();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		a.totalPrice();
		for(int j = 0; j<list.size(); j++) {
			if(list.get(j) instanceof PhieuNhap) {
				if(enter.equalsIgnoreCase(list.get(j).getMaPhieu()) || enter.equalsIgnoreCase(list.get(j).getMaNhanVien()) || enter.equalsIgnoreCase(list.get(j).getPartnerID())) {				
					list.get(j).xuat();
				}
			}
		}		
		PhieuNhap.count = 1;
	}

	@Override
	public void search__2() {
		// TODO Auto-generated method stub
		System.out.print("Nhập nội dung bạn muốn tìm kiếm: ");
		String enter = inp.nextLine();
		System.out.print("Đang tìm kiếm.............\n");
		System.out.println("========================================Danh Sách Phiếu Xuất=======================================\n");
		System.out.printf("%-4s %-15s %-15s %-20s %-25s %-15s\n", "STT", "Mã phiếu", "Mã Nhân Viên", "Mã Cửa hàng", "Ngày tạo phiếu", "Tổng giá");
		PhieuXuat a  = new PhieuXuat();
		try {
			a.readFromFile();
			a.readFromFile_PX();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		a.totalPrice();
		for(int j = 0; j<list.size(); j++) {
			if(list.get(j) instanceof PhieuXuat) {
				if(enter.equalsIgnoreCase(list.get(j).getMaPhieu()) || enter.equalsIgnoreCase(list.get(j).getMaNhanVien()) || enter.equalsIgnoreCase(list.get(j).getPartnerID())) {
					list.get(j).xuat();
				}
			}
		}
		PhieuXuat.total_Price.clear();
		PhieuXuat.count = 1;
	}


	public static void main(String args[]) throws IOException {
		arrPhieu arr = new arrPhieu();		
		arr.execute_xuat();
		
		
	}

	
	
	
	
}
