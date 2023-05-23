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
public class MangChiTietPhieuXuat implements CheckingFormat
{
    private List<chiTietPhieuXuat> list = new ArrayList<>();
    Scanner inp=new Scanner(System.in);
    public void nhapMang() {
		boolean cont = true;
		boolean cont1 = true;
		try {
			FileWriter fw = new FileWriter("../ChiTietPhieuXuat.txt", true);	
			BufferedWriter bw = new BufferedWriter(fw);
			
			do {
				System.out.println("Dang tao chi tiet phieu..........");
				System.out.println(list.size());
				chiTietPhieuXuat ctpx = new chiTietPhieuXuat();
				ctpx.nhapMaPX();
				ctpx.nhapMaSP();
				boolean off = true;
				boolean flag = true;
				while(off == true) {
					for(int j = 0; j<list.size(); j++) {
						if(ctpx.getMaSanPham().equalsIgnoreCase(list.get(j).getMaSanPham()) && ctpx.getMaPhieuXuat().equalsIgnoreCase(list.get(j).getMaPhieuXuat())) {
							flag = false;
						}
					}
					if(flag == false) {
						System.out.println("CTPX đã tồn tại, xin mời nhập mã khác !!!!!");
						ctpx.nhapMaPX();
						ctpx.nhapMaSP();
						flag = true;
					}
					else if(flag == true) {
						off = false;
					}
				}
				ctpx.nhap();
				list.add(ctpx);
				bw.write(ctpx.toString());
				bw.newLine();
				do {
					System.out.println("Bạn có muốn nhập tiếp không ? [y/n]");
					String opt = inp.nextLine();
					if(opt.equalsIgnoreCase("y")) {
						cont1 = false;
						cont = true;
					}
					else if(opt.equalsIgnoreCase("n")) {
						cont = false;
						cont1 = false;
					}
					else {
						cont1 = true;
					}
				}while(cont1);
			}while(cont);
			bw.close();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    public void execute_ct_xuat(String px) {
    	arrKiemKeXuat b = new arrKiemKeXuat();
    	try {
			readFromFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	try {
			FileWriter fw = new FileWriter("../ChiTietPhieuXuat.txt", true);	
			BufferedWriter bw = new BufferedWriter(fw);
			System.out.println("Dang tao chi tiet phieu..........");
			System.out.println(list.size());
			chiTietPhieuXuat ctpx = new chiTietPhieuXuat();
			ctpx.setMaPhieuXuat(px);
			ctpx.nhapMaSP();
			boolean off = true;
			boolean flag = true;
			while(off == true) {
				for(int j = 0; j<list.size(); j++) {
					if(ctpx.getMaSanPham().equalsIgnoreCase(list.get(j).getMaSanPham()) && ctpx.getMaPhieuXuat().equalsIgnoreCase(list.get(j).getMaPhieuXuat())) {
						flag = false;
					}
				}
				if(flag == false) {
					System.out.println("Mã sản phẩm và mã phiếu nhập đã tồn tại, xin mời nhập mã khác !!!!!");
					ctpx.setMaPhieuXuat(px);
					ctpx.nhapMaSP();
					flag = true;
				}
				else if(flag == true) {
					off = false;
				}
			}
			ctpx.nhap();
			list.add(ctpx);
			bw.write(ctpx.toString());
			bw.newLine();
			bw.close();
			fw.close();
			//kiemke
			b.execute_kiemke_chitiet_xuat(ctpx.getMaPhieuXuat(), ctpx.getMaSanPham());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public void readFromFile() throws IOException {
    	File temp = new File("../ChiTietPhieuXuat.txt");
		BufferedReader br_temp = new BufferedReader(new FileReader(temp));
		String line1 = "";
		line1 = br_temp.readLine();
		if(line1 == null){
			System.out.println("Hiện không có dữ liệu, dữ liệu mặc định sẽ được tải xuống..........");
			try {
				File phieunhap = new File("../ChiTietPhieuXuat_Default.txt");
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
					boolean flag = true;
					int local = 0;
					for(chiTietPhieuXuat i : list) {
						if(i.getMaSanPham().equalsIgnoreCase(create.getMaSanPham()) && i.getMaPhieuXuat().equals(create.getMaPhieuXuat())) {
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
    public void xuatList()
    {
        System.out.println("====================Danh Sách Chi Tiết Phiếu Xuất======================\n");
		System.out.printf("%-4s %-15s %-15s %-25s %-10s %-15s %-15s %-15s %-15s", "STT", "Mã phiếu xuất", "Mã hàng hóa", "Tên hàng hóa", "Số lượng", "Giá", "Đơn vị tính", "Ngày sản xuất", "Hạn sử dụng");
		System.out.println("");
		for(chiTietPhieuXuat i : list) {
			i.xuat();
		}
		
		chiTietPhieuXuat.count = 1;
    }
    public void fix() {
		System.out.print("Nhập mã phiếu của CTPX bạn muốn sửa: ");
		String fix_id1 = this.IDPXchecking();
		System.out.print("Nhập mã hàng hóa của CTPX bạn muốn sửa: ");
		String fix_id2 = this.maHangHoaChecking();
		boolean off = true;
		boolean flag = true;
		int replace = 0;
		while(off == true) {
			for(int j = 0; j<list.size(); j++) {
				if(fix_id1.equalsIgnoreCase(list.get(j).getMaPhieuXuat()) && fix_id2.equalsIgnoreCase(list.get(j).getMaSanPham())) {
					flag = false;
					replace = j;
				}
			}
			if(flag == false) {
				System.out.println("Mời nhập lại thông tin (xin nhập lại tất cả, chức năng sửa từng thuộc tính sẽ được nâng cấp sau): ");
				list.get(replace).nhapMaPX();
				list.get(replace).nhapMaSP();
				boolean off1 = true;
				boolean flag1 = true;
				while(off1 == true) {
					for(int j = replace-1; j>=0; j--) {
						if(list.get(replace).getMaPhieuXuat().equalsIgnoreCase(list.get(j).getMaPhieuXuat()) && list.get(replace).getMaSanPham().equalsIgnoreCase(list.get(j).getMaSanPham())) {
							flag1 = false;
						}
					}
					for(int j = replace+1; j<list.size(); j++) {
						if(list.get(replace).getMaPhieuXuat().equalsIgnoreCase(list.get(j).getMaPhieuXuat()) && list.get(replace).getMaSanPham().equalsIgnoreCase(list.get(j).getMaSanPham())) {
							flag1 = false;
						}
					}
					if(flag1 == false) {
						System.out.println("Mã phiếu và mã hàng hóa đã tồn tại, xin mời nhập mã khác !!!!!");
						list.get(replace).nhapMaPX();
						list.get(replace).nhapMaSP();
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
				System.out.println("CTPX không tồn tại!!!!\n");
				System.out.print("Nhập mã phiếu xuất của CTPX bạn muốn sửa: ");
				fix_id1 = this.IDPXchecking();
				System.out.print("Nhập mã hàng hóa của CTPX bạn muốn sửa: ");
				fix_id2 = this.maHangHoaChecking();
				off = true;
			}
		}
		File file_replace = new File("../ChiTietPhieuXuat.txt");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file_replace));
			for(chiTietPhieuXuat i : list) {
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
		System.out.print("Nhập mã phiếu nhập của CTPN bạn muốn xóa: ");
		String delete_id1 = this.IDPXchecking();
		System.out.print("Nhập mã hàng hóa của CTPN bạn muốn xóa: ");
		String delete_id2 = this.maHangHoaChecking();
		boolean off = true;
		boolean flag = true;
		int delete_index = 0;
		while(off == true) {
			for(int j = 0; j<list.size(); j++) {
				if(delete_id1.equalsIgnoreCase(list.get(j).getMaPhieuXuat()) && delete_id2.equalsIgnoreCase(list.get(j).getMaSanPham())) {
					flag = false;
					delete_index = j;
				}
			}
			if(flag == false) {
				for(int j = 0; j<list.size(); j++) {
					if(delete_id1.equalsIgnoreCase(list.get(j).getMaPhieuXuat())) {
						list.remove(delete_index);
					}
				}
				off = false;
			}
			else if(flag == true) {
				System.out.println("Mã phiếu xuất và mã hàng hóa không tồn tại!!!!\n");
				System.out.print("Nhập mã phiếu xuất của CTPX bạn muốn xóa: ");
				delete_id1 = this.IDPXchecking();
				System.out.print("Nhập mã hàng hóa của CTPX bạn muốn xóa: ");
				delete_id2 = this.maHangHoaChecking();
				off = true;
			}
		}
		File file_delete = new File("../ChiTietPhieuXuat.txt");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file_delete));
			for(chiTietPhieuXuat i : list) {
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
		Collections.sort(list, new Comparator<chiTietPhieuXuat>() {

			@Override
			public int compare(chiTietPhieuXuat o1, chiTietPhieuXuat o2) {
				// TODO Auto-generated method stub
				return o1.getMaPhieuXuat().compareTo(o2.getMaPhieuXuat());
			}
		});
		File file_sort = new File("../ChiTietPhieuXuat.txt");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file_sort));
			for(chiTietPhieuXuat i : list) {
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
		System.out.println("====================Danh Sách Chi Tiết Phiếu Xuất======================\n");
		System.out.printf("%-4s %-15s %-15s %-25s %-10s %-15s %-15s %-15s %-15s\n", "STT", "Mã phiếu xuất", "Mã hàng hóa", "Tên hàng hóa", "Số lượng", "Giá", "Đơn vị tính", "Ngày sản xuất", "Hạn sử dụng");
		for(int j = 0; j<list.size(); j++) {
			if(enter.equalsIgnoreCase(list.get(j).getMaPhieuXuat()) || enter.equalsIgnoreCase(list.get(j).getMaSanPham()) || enter.equalsIgnoreCase(list.get(j).getTenSanPham()) || enter.equalsIgnoreCase(list.get(j).getDonvitinh())) {
				list.get(j).xuat();
			}
		}
		
		PhieuXuat.count = 1;
	}
    public static void main(String[] args) throws IOException 
    {
        MangChiTietPhieuXuat a = new MangChiTietPhieuXuat();
        a.readFromFile();
        a.nhapMang();
        
        a.xuatList();
        
        
    }
    
        
}
