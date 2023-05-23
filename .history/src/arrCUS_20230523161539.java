import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class arrCUS {
	private CuaHang[] arr = new CuaHang[500];
	private int n;
	Scanner inp = new Scanner(System.in);

	public arrCUS() {
		
	}

	public arrCUS(CuaHang[] arr, int n) {
		this.arr = arr;
		this.n = n;
	}

	public CuaHang[] getArr() {
		return arr;
	}

	public void setArr(CuaHang[] arr) {
		this.arr = arr;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	// Biến toàn cục
	String position = "";
	int temp = 0;
	boolean cont = true;
	boolean cont1 = true;
	int timkiem = 0;

	// Nhập mảng cửa hàng
	public void input_arrCUS() {
		try {
			do {
				CuaHang ch = new CuaHang();
				ch.input_mch();
				boolean off = true;
				boolean flag = true;
				while (off == true) {
					for (int i = 0; i < n; i++) {
						if (ch.getMaCuaHang().equalsIgnoreCase(arr[i].getMaCuaHang())) {
							flag = false;
						}
					}
					if (flag == false) {
						System.out.println("Mã cửa hàng đã tồn tại, xin mời nhập mã khác !!!!!");
						ch.input_mch();
						flag = true;
					} else if (flag == true) {
						off = false;
					}
				}
				arr[temp] = new CuaHang();
				ch.input_tct();
				ch.input_sdt();
				ch.input_email();
				ch.input_diachi();
				arr[temp] = ch;
				try {
					FileWriter fw = new FileWriter("DanhSachCuaHang.txt", true);
					BufferedWriter bw = new BufferedWriter(fw);
					bw.write(arr[temp].toString());
					bw.newLine();
					bw.close();
					fw.close();
				} catch (Exception e) {
				}
				temp++;
				n++;
				
				do {
					System.out.print("Bạn có muốn nhập tiếp không ? [y/n]:");
					String opt = inp.nextLine();
					if (opt.equalsIgnoreCase("y")) {
						cont = true;
						cont1 = false;
					} else if (opt.equalsIgnoreCase("n")) {
						cont = false;
						cont1 = false;
					} else {
						cont1 = true;
					}
				} while (cont1);
			} while (cont);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// đọc file hàng hóa
	public void readFromFile_CUS() throws IOException {
		try {
			FileReader fr = new FileReader("DanhSachCuaHang.txt");
			try {
				BufferedReader br = new BufferedReader(fr);
				String line = "";
				while (true) {
					line = br.readLine();
					if (line == null) {
						break;
					}
					String txt[] = line.split("[,]");
					String a = txt[0];
					String b = txt[1];
					String c = txt[2];
					String d = txt[3];
					DiaChi e = new DiaChi();
					e.setDiachicuthe(txt[4]);
					e.setXaphuong(txt[5]);
					e.setQuanhuyen(txt[6]);
					e.setTinhtp(txt[7]);
					CuaHang create = new CuaHang(a, b, c, d, e);
					boolean flag = true;
					for (int i = 0 ; i < n ; i++) {
						if (arr[i].getMaCuaHang().equalsIgnoreCase(create.getMaCuaHang())) {
							flag = false;
							break;
						}
					}
					if (flag == true) {
						arr[n] = create;
						n++;
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

	// Hàm sắp xếp tăng theo mã cửa hàng
	// Hàm swap
	public static void swap(CuaHang[] arr, int i, int j) {
		CuaHang temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public void sort_arrCUS() {
		try {
			if (n != 0) {
				for (int i = 0; i < n - 1; i++) {
					for (int j = i + 1; j < n; j++)
						/*
						 * Nếu chuỗi thứ nhất < chuỗi thứ hai thì < 0 Nếu chuỗi thứ nhất = chuỗi thứ hai
						 * thì = 0 Nếu chuỗi thứ nhất > chuỗi thứ hai thì > 0
						 */
						if (arr[i].getMaCuaHang().compareTo(arr[j].getMaCuaHang()) > 0) {
							swap(arr, i, j);
						}
				}
				System.out.println("Đang xếp mã cửa hàng theo thứ tự tăng dần....");
				System.out.println("Sắp xếp thành công !!");
				output_arrCUS();
			} else {
				System.out.println("Bạn chưa có mã cửa hàng nào !!");
			}
		} catch (Exception e) {
			System.out.println("Danh sách cửa hàng rỗng");
		}
	}
	
	// Tìm kiếm mã cửa hàng
	public void seach_arrCUS() {
		CuaHang ch = new CuaHang();
		try {
			do {
				System.out.println("Nhập mã cửa hàng muốn tìm kiếm");
				ch.input_mch();
				boolean off = true;
				boolean flag = true;
				while (off == true) {
					if (n != 0) {
						for (int i = 0; i < n; i++) {
							if (ch.getMaCuaHang().equalsIgnoreCase(arr[i].getMaCuaHang())) {
								arr[i].output();
								flag = false;
							}
						}
					} else {
						System.out.println("Danh sách rỗng !!");
						return;
					}
					if (flag == true) {
						System.out.println("Mã cửa hàng không tồn tại, xin mời nhập mã khác !!");
						ch.input_mch();
					} else if (flag == false) {
						off = false;
					}
				}
				do {
					System.out.print("Bạn có muốn tìm kiếm tiếp không ? [y/n]:");
					String opt = inp.nextLine();
					if (opt.equalsIgnoreCase("y")) {
						cont1 = false;
						cont = true;
					} else if (opt.equalsIgnoreCase("n")) {
						cont = false;
						cont1 = false;
					} else {
						cont1 = true;
					}
				} while (cont1);
			} while (cont);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Hàm tìm vị trí để xóa phần tử
	public int search_pos(CuaHang[] arr, int n, String x) {
		for (int i = 0; i < n; i++) {
			if (arr[i].getMaCuaHang().equalsIgnoreCase(x)) {
				return i;
			}
		}
		return -1;
	}

	// Xóa mã cửa hàng
	public void delete_arrCUS() {
		CuaHang ch = new CuaHang();
		try {
			do {
				boolean off = true;
				boolean flag = true;
				System.out.println("Nhập mã cửa hàng cần xóa :");
				position = ch.input_mch();
				timkiem = search_pos(arr, n, position);
				while (off == true) {
					if (n != 0) {
						if (timkiem != -1) {
							System.out.println("Đang xóa......");
							for (int i = timkiem; i < n - 1; i++) {
								arr[i] = arr[i + 1];
							}
							flag = false;
							n--;
							System.out.println("Xóa thành công !!");
							output_arrCUS();
						}
					} else {
						System.out.println("Danh sách rỗng !!");
						return;
					}
					if (flag == true) {
						System.out.println("Không có mã cửa hàng này trong danh sách, xin vui lòng kiểm tra lại !!");
						position = ch.input_mch();
						timkiem = search_pos(arr, n, position);
					} else if (flag == false) {
						off = false;
					}
				}
				do {
					System.out.print("Bạn có muốn xóa tiếp không ? [y/n]:");
					String opt = inp.nextLine();
					if (opt.equalsIgnoreCase("y")) {
						cont1 = false;
						cont = true;
					} else if (opt.equalsIgnoreCase("n")) {
						cont = false;
						cont1 = false;
					} else {
						cont1 = true;
					}
				} while (cont1);
			} while (cont);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File file_delete = new File("DanhSachCuaHang.txt");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file_delete));
			for(int i = 0 ; i < n ; i++) {
				bw.write(arr[i].toString());
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Sửa thông tin của cửa hàng
	public void fix_arrCUS() {
		CuaHang ch = new CuaHang();
		System.out.print("Chọn mã cửa hàng bạn muốn sửa: ");
		ch.input_mch();
		boolean off = true;
		boolean flag = true;
		int replace = 0;
		if (n == 0) {
			System.out.println("Danh sách chưa có cửa hàng nào !!!");
			return;
		}
		while (off == true) {
			for (int j = 0; j < n; j++) {
				if (ch.getMaCuaHang().equalsIgnoreCase(arr[j].getMaCuaHang())) {
					flag = false;
					replace = j;
				}
			}
			if (flag == false) {
				System.out.println(
						"Mời nhập lại thông tin (xin nhập lại tất cả, chức năng sửa từng thuộc tính sẽ được nâng cấp sau): ");
				arr[replace].input_mch();
				boolean off1 = true;
				boolean flag1 = true;
				while (off1 == true) {
					// Kiểm tra trước cái replace có mã nào trùng vs nó không
					for (int j = replace - 1; j >= 0; j--) {
						if (arr[replace].getMaCuaHang().equalsIgnoreCase(arr[j].getMaCuaHang())) {
							flag1 = false;
						}
					}
					// Kiểm tra sau cái replace có mã nào trùng vs nó không
					for (int j = replace + 1; j < n; j++) {
						if (arr[replace].getMaCuaHang().equalsIgnoreCase(arr[j].getMaCuaHang())) {
							flag1 = false;
						}
					}
					if (flag1 == false) {
						System.out.println("Mã cửa hàng đã tồn tại, xin mời nhập mã khác !!!!!");
						arr[replace].input_mch();
						flag1 = true;
					} else if (flag1 == true) {
						off1 = false;
					}
				}
				arr[replace] = new CuaHang();
				ch.input_tct();
				ch.input_sdt();
				ch.input_email();
				ch.input_diachi();
				arr[replace] = ch;
				off = false;
			} else if (flag == true) {
				System.out.println("Mã cừa hàng nhập không tồn tại!!!!");
				ch.input_mch();
				off = true;
			}
		}
		File file_delete = new File("DanhSachCuaHang.txt");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file_delete));
			for(int i = 0 ; i < n ; i++) {
				bw.write(arr[i].toString());
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void output_arrCUS() {
		System.out.println(
				"=================================================Danh Sách Cửa Hàng=================================================\n");
		System.out.printf("%-4s %-15s %-15s %-20s %-25s %-30s\n", "STT", "Mã Cửa Hàng", "Tên Cửa Hàng", "Số Điện Thoại",
				"Email", "Địa Chỉ");
		System.out.println("");
		for (int i = 0; i < n; i++) {
			arr[i].output();
			System.out.println("");
		}
		System.out.println(
				"====================================================================================================================\n");
		CuaHang.count = 1;
	}

}
