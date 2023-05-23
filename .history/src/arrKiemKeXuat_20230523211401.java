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

public class arrKiemKeXuat implements CheckingFormat, ReadFile, WriteFile, Execution{
	private List<KiemKeXuat> list = new ArrayList<>();
	private HangHoa[] listHH = new HangHoa[500];
	private int n = 0;
	private chiTietPhieuXuat[] listCT = new chiTietPhieuXuat[500];
	private int m = 0;
	private HangHoa[] DS_loai = new HangHoa[500];
	private int p = 0;
	Scanner inp = new Scanner(System.in);
	
	public arrKiemKeXuat() {
		
	}
	
	public void execute_kiemke_chitiet_xuat(String px, String hh) {
		this.readFromFile();
		try {
			FileWriter fw = new FileWriter("../KiemKeXuat.txt", true);	
			BufferedWriter bw = new BufferedWriter(fw);
			System.out.println("Kiểm kê hàng hóa..........");
			System.out.println(list.size());
			KiemKeXuat kkn = new KiemKeXuat();
			kkn.setMaPhieu(px);
			kkn.setMaSanPham(hh);
			boolean off = true;
			boolean flag = true;
			while(off == true) {
				for(int j = 0; j<list.size(); j++) {
					if(kkn.getMaSanPham().equalsIgnoreCase(list.get(j).getMaSanPham()) 
							&& kkn.getMaPhieu().equalsIgnoreCase(list.get(j).getMaPhieu())) {
						flag = false;
					}
				}
				if(flag == false) {
					System.out.println("Mã sản phẩm và mã phiếu xuất đã tồn tại, xin mời nhập mã khác !!!!!");
					kkn.setMaPhieu(px);
					kkn.setMaSanPham(hh);
					flag = true;
				}
				else if(flag == true) {
					off = false;
				}
			}		
			kkn.Input();
			list.add(kkn);
			bw.write(kkn.toString());
			bw.newLine();
			bw.close();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//xuất hàng
		this.readFromFile_case();
		this.readFromFile_HangHoa();
		this.readFromFileCTP();
		this.readFromFile();
		this.Execute();
	}
	@Override
	public void input_x() {
		// TODO Auto-generated method stub
		try {
			FileWriter fw = new FileWriter("../KiemKeXuat.txt", true);	
			BufferedWriter bw = new BufferedWriter(fw);
			System.out.println("Kiểm kê hàng hóa..........");
			System.out.println(list.size());
			KiemKeXuat kkx = new KiemKeXuat();
			kkx.InputP_Key();
			boolean off = true;
			boolean flag = true;
			while(off == true) {
				for(int j = 0; j<list.size(); j++) {
					if(kkx.getMaSanPham().equalsIgnoreCase(list.get(j).getMaSanPham()) 
							&& kkx.getMaPhieu().equalsIgnoreCase(list.get(j).getMaPhieu())) {
						flag = false;
					}
				}
				if(flag == false) {
					System.out.println("Mã sản phẩm và mã phiếu nhập đã tồn tại, xin mời nhập mã khác !!!!!");
					kkx.InputP_Key();
					flag = true;
				}
				else if(flag == true) {
					off = false;
				}
			}
			
			kkx.Input();
			list.add(kkx);
			bw.write(kkx.toString());
			bw.newLine();
			bw.close();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void Execute() {
		// TODO Auto-generated method stub
		try {
			for(KiemKeXuat i : list) {
				for(int j = 0; j < m; j++) { 
					if(i.getMaPhieu().equalsIgnoreCase(listCT[j].getMaPhieuXuat()) && i.getMaSanPham().equalsIgnoreCase(listCT[j].getMaSanPham()) && i.getStatus().equalsIgnoreCase("x")) {
						for(int k = 0; k < n; k++) {						
							if(listCT[j].getMaSanPham().equalsIgnoreCase(listHH[k].getMaSanPham())) {
								int sl_temp = listHH[k].getSoluong() - listCT[j].getSoluong(); 
								if(sl_temp >= i.getSoLuong()) {
									System.out.println(i.getSoLuong());
									listHH[k].setSoluong(listHH[k].getSoluong() - i.getSoLuong() - listCT[j].getSoluong());
									//cập nhật lại tiền
									TonKhoDisplay.giaVon = TonKhoDisplay.giaVon + listCT[j].getDongia()*listCT[j].getSoluong();
									File gia = new File("../TienVon.txt");
									BufferedWriter bw_gia = new BufferedWriter(new FileWriter(gia));
									bw_gia.write(String.valueOf(TonKhoDisplay.giaVon));
									bw_gia.newLine();
									bw_gia.close();
									i.setStatus("v"); //đã xuất hàng							
								}else {
									// ko xuat hang nhung van tru so luong vi san pham loi
									if(i.getSoLuong() < listHH[k].getSoluong()) {
										listHH[k].setSoluong(listHH[k].getSoluong() - i.getSoLuong());
									}						
									System.out.println("Hàng hóa không đủ để xuất, cần nhập thêm!!! Mã phiếu kiểm xuất " + i.getMaPhieu() + " " + i.getMaSanPham());
								}	
							}	
						}				
						//đưa vào DS loại
						if(i.getSoLuong()>0) {
							HangHoa new_p = new HangHoa(listCT[j].getMaSanPham(), listCT[j].getTenSanPham(), listCT[j].getDongia(), i.getSoLuong(), listCT[j].getDonvitinh(), listCT[j].getNsx(), listCT[j].getHsd());
							int local = 0;
							boolean flag_loai = false;
							for(int h = 0; h < p; h++) {
								if(DS_loai[h].getMaSanPham().equalsIgnoreCase(new_p.getMaSanPham())) {
									flag_loai = true;
									new_p.setSoluong(DS_loai[h].getSoluong() + i.getSoLuong());
									local = h;
									break;
								}
							}
							if(flag_loai == false) {
								DS_loai[p] = new_p;
								p++;
							}
							else {
								DS_loai[local] = new_p;
							}	
							i.setSoLuong(0);
						}
						break;
					}
				}		
			}
			//xuat ra file hang hoa
			File exporty = new File("../HangHoa.txt");
			BufferedWriter bw_im = new BufferedWriter(new FileWriter(exporty));
			for(int i = 0; i < n; i++) {
				bw_im.write(listHH[i].toString());
				bw_im.newLine();
			}
			bw_im.close();
			
			//xuat ra file loai hang
			File removy = new File("../DanhSachHangBiLoai.txt");
			BufferedWriter bw_re = new BufferedWriter(new FileWriter(removy));
			for(int i = 0; i < p; i++) {
				bw_re.write(DS_loai[i].toString());
				bw_re.newLine();
			}
			bw_re.close();
			
			//cập nhật lại trạng thái trong file
			File updateStatus = new File("../KiemKeXuat.txt");
			BufferedWriter bw_up = new BufferedWriter(new FileWriter(updateStatus));
			for(KiemKeXuat i : list) {
				bw_up.write(i.toString());
				bw_up.newLine();
			}
			bw_up.close();
			System.out.println("Xuất hàng thành công!!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	@Override
	public void readFromFileCTP() {
		// TODO Auto-generated method stub
		try {
			FileReader fr = new FileReader("../ChiTietPhieuXuat.txt");
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
					long c = Long.parseLong(txt[3]);
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
					chiTietPhieuXuat create = new chiTietPhieuXuat(a, b, c, d, e, date1, date2, q);					
					boolean flag = true;
					int local = 0;
					for(int i = 0; i < m; i++) {
						if(listCT[i].getMaSanPham().equalsIgnoreCase(create.getMaSanPham()) && listCT[i].getMaPhieuXuat().equals(create.getMaPhieuXuat())) {
							flag = false;
							local = i;
							break;
						}
					}
					if(flag == true) {
						listCT[m] = create;
						m++;
					}	
					else {
						listCT[local] = create;
					}
				}
				br.close();
			} catch (FileNotFoundException e) {
				throw e;
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void readFromFile_case() {
		// TODO Auto-generated method stub
		try {
			FileWriter fw = new FileWriter("../DanhSachHangBiLoai.txt", true);
			FileReader fr = new FileReader("../DanhSachHangBiLoai.txt");
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
					for(int i = 0; i < p; i++) {
						if(DS_loai[i].getMaSanPham().equalsIgnoreCase(create.getMaSanPham())) {
							flag = false;
							local = i;
							break;
						}
					}
					if(flag == true) {
						DS_loai[p] = create;
						p++;
					}		
					else {
						DS_loai[local] = create;
					}		
				}
				br.close();
			} catch (FileNotFoundException e) {
				throw e;
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				fw.close();
			}
			fr.close();		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void readFromFile_HangHoa() {
		// TODO Auto-generated method stub
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
					long c = Long.parseLong(txt[2]);
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
					HangHoa create = new HangHoa(a, b, c, d, e, date1, date2);
					boolean flag = true;
					int local = 0;
					for(int i = 0; i < n; i++) {
						if(listHH[i].getMaSanPham().equalsIgnoreCase(create.getMaSanPham())) {
							flag = false;
							local = i;
							break;
						}
					}
					if(flag == true) {
						listHH[n] = create;
						n++;
					}	
					else {
						listHH[local] = create;
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
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void input_n() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void readFromFile() {
		// TODO Auto-generated method stub			
		try {
			File temp = new File("../KiemKeXuat.txt");	
			BufferedReader br_temp = new BufferedReader(new FileReader(temp));
			String line1 = "";
			line1 = br_temp.readLine();
			if(line1 == null){
				System.out.println("Hiện không có dữ liệu, dữ liệu mặc định sẽ được tải xuống..........");
				try {
					File phieunhap = new File("../KiemKeXuat_Default.txt");
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
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					br_temp.close();
				}
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
		try {			
			FileReader fr = new FileReader("../KiemKeXuat.txt");
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
					String c = txt[2];
					int d = Integer.parseInt(txt[3]);
					int e = Integer.parseInt(txt[4]);
					int f = Integer.parseInt(txt[5]);
					int g = Integer.parseInt(txt[6]);
					NgayThang n = new NgayThang(e,f,g);
					KiemKeXuat create = new KiemKeXuat(a, b, c, d, n);
					boolean flag = true;
					int local = 0;
					for(KiemKeXuat i : list) {
						if(i.getMaSanPham().equalsIgnoreCase(create.getMaSanPham()) && i.getMaPhieu().equals(create.getMaPhieu())) {
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
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void output_1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void output_2() {
		// TODO Auto-generated method stub
		System.out.println("====================Danh Sách Kiểm Tra Xuất Hàng Hóa======================\n");
		System.out.printf("%-4s %-15s %-15s %-10s %-15s %-20s", "STT", "Mã phiếu Xuất", "Mã Hàng Hóa", "Tình trạng", "Số lượng loại", "Ngày kiểm kê");
		System.out.println("");
		for(KiemKeXuat i : list) {
			i.Output();
			System.out.println("");
		}
		KiemKeXuat.count = 1;
	}

	@Override
	public void fix_1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fix_2() {
		// TODO Auto-generated method stub
		System.out.print("Nhập mã phiếu của phiếu kiểm xuất bạn muốn sửa: ");
		String fix_id1 = this.IDPXchecking();
		System.out.print("Nhập mã hàng hóa của phiếu kiểm xuất bạn muốn sửa: ");
		String fix_id2 = this.maHangHoaChecking();
		boolean off = true;
		boolean flag = true;
		int replace = 0;
		while(off == true) {
			for(int j = 0; j<list.size(); j++) {
				if(fix_id1.equalsIgnoreCase(list.get(j).getMaPhieu()) && fix_id2.equalsIgnoreCase(list.get(j).getMaSanPham())) {
					flag = false;
					replace = j;
				}
			}
			if(flag == false) {
				System.out.println("Mời nhập lại thông tin (xin nhập lại tất cả, chức năng sửa từng thuộc tính sẽ được nâng cấp sau): ");
				list.get(replace).InputP_Key();;
				boolean off1 = true;
				boolean flag1 = true;
				while(off1 == true) {
					for(int j = replace-1; j>=0; j--) {
						if(list.get(replace).getMaPhieu().equalsIgnoreCase(list.get(j).getMaPhieu()) && list.get(replace).getMaSanPham().equalsIgnoreCase(list.get(j).getMaSanPham())) {
							flag1 = false;
						}
					}
					for(int j = replace+1; j<list.size(); j++) {
						if(list.get(replace).getMaPhieu().equalsIgnoreCase(list.get(j).getMaPhieu()) && list.get(replace).getMaSanPham().equalsIgnoreCase(list.get(j).getMaSanPham())) {
							flag1 = false;
						}
					}
					if(flag1 == false) {
						System.out.println("Phiếu kiểm xuất đã tồn tại, xin mời nhập mã khác !!!!!");
						list.get(replace).InputP_Key();
						flag1 = true;
					}
					else if(flag1 == true) {
						off1 = false;
					}
				}
				list.get(replace).Input();
				off = false;
			}
			else if(flag == true) {
				System.out.println("Phiếu kiểm xuất không tồn tại!!!!\n");
				System.out.print("Nhập mã phiếu xuất của phiếu kiểm xuất bạn muốn sửa: ");
				fix_id1 = this.IDPXchecking();
				System.out.print("Nhập mã hàng hóa của phiếu kiểm xuất bạn muốn sửa: ");
				fix_id2 = this.maHangHoaChecking();
				off = true;
			}
		}
		File file_replace = new File("../KiemKeXuat.txt");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file_replace));
			for(KiemKeXuat i : list) {
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
		
	}

	@Override
	public void delete_2() {
		// TODO Auto-generated method stub
		System.out.print("Nhập mã phiếu xuất của phiếu kiểm xuất bạn muốn xóa: ");
		String delete_id1 = this.IDPXchecking();
		System.out.print("Nhập mã hàng hóa của phiếu kiểm xuất bạn muốn xóa: ");
		String delete_id2 = this.maHangHoaChecking();
		boolean off = true;
		boolean flag = true;
		int delete_index = 0;
		while(off == true) {
			for(int j = 0; j<list.size(); j++) {
				if(delete_id1.equalsIgnoreCase(list.get(j).getMaPhieu()) && delete_id2.equalsIgnoreCase(list.get(j).getMaSanPham())) {
					flag = false;
					delete_index = j;
				}
			}
			if(flag == false) {
				for(int j = 0; j<list.size(); j++) {
					if(delete_id1.equalsIgnoreCase(list.get(j).getMaPhieu())) {
						list.remove(delete_index);
					}
				}
				off = false;
			}
			else if(flag == true) {
				System.out.println("Phiếu kiểm xuất không tồn tại!!!!\n");
				System.out.print("Nhập mã phiếu xuất của phiếu kiểm xuất bạn muốn xóa: ");
				delete_id1 = this.IDPXchecking();
				System.out.print("Nhập mã hàng hóa của phiếu kiểm xuất bạn muốn xóa: ");
				delete_id2 = this.maHangHoaChecking();
				off = true;
			}
		}
		File file_delete = new File("../KiemKeXuat.txt");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file_delete));
			for(KiemKeXuat i : list) {
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
		
	}

	@Override
	public void search__2() {
		// TODO Auto-generated method stub
		System.out.print("Nhập nội dung bạn muốn tìm kiếm: ");
		String enter = inp.nextLine();
		System.out.print("Đang tìm kiếm.............\n");
		System.out.println("====================Danh Sách Kiểm Tra Xuất Hàng Hóa======================\n");
		System.out.printf("%-4s %-15s %-15s %-10s %-10s\n", "STT", "Mã phiếu Xuất", "Mã Hàng Hóa", "Tình trạng", "Số lượng loại");
		for(int j = 0; j<list.size(); j++) {
			if(enter.equalsIgnoreCase(list.get(j).getMaPhieu()) || enter.equalsIgnoreCase(list.get(j).getMaSanPham()) || enter.equalsIgnoreCase(list.get(j).getStatus())) {
				list.get(j).Output();
			}
		}
		KiemKeXuat.count = 1;
	}
	
	public static void main(String args[]) throws IOException {
		arrKiemKeXuat a = new arrKiemKeXuat();
		a.readFromFile();
		a.readFromFile_case();
		a.readFromFile_HangHoa();
		a.readFromFileCTP();
		a.Execute();
		
		
	}

}
