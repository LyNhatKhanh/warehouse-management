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

public class TonKhoDisplay{
	private static List<HangHoa> list = new ArrayList<>();
	public static long giaVon = 0;
	static Scanner inp = new Scanner(System.in);
	public TonKhoDisplay() {
		
	}
	public TonKhoDisplay(long giaVon) {
		TonKhoDisplay.giaVon = giaVon;
	}
	public static long giaChecking() {
		 String dauVao;		 
	     while(true){
	    	 dauVao = inp.nextLine().trim();
	    	 if(dauVao.matches("[0-9]{1,9}")) {
	    		 return Long.parseLong(dauVao);
	    	 }
	    	 else {
	    		 System.out.println("Định dạng sai");
	    	 }
	    	 System.out.print("Moi nhap lai: ");
	     } 
	 }
	//Nhập giá vốn
	public static void nhap() throws IOException {
		System.out.println("Nhập số tiền vốn : ");
		TonKhoDisplay.giaVon = giaChecking();
		File tien = new File("../TienVon.txt");
		BufferedWriter bw = new BufferedWriter(new FileWriter(tien));
		bw.write(String.valueOf(giaVon));
		bw.newLine();
		bw.close();
	}
	//đọc giá vốn
	public static void readGiaVon() {
		File tien = new File("../TienVon.txt");
		try {
			BufferedReader br = new BufferedReader(new FileReader(tien));
			String line = "";
			line = br.readLine();
			if(line == null) {
				System.out.println("Chưa có dữ liệu !!!");
				giaVon = 500000000;
				System.out.println("Tự khởi tạo tiền vốn mặc định!!! + " + giaVon);
			}
			else {
				giaVon = Long.parseLong(line);
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//đọc file hàng hóa
	public static void readFromFile_HangHoa() throws IOException {
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
	public static int total_HangHoa() throws IOException {
		readFromFile_HangHoa();
		int S = 0;
		for(HangHoa i : list) {
			S += i.getSoluong();
		}
		return S;
	}
	public static long total_value() throws IOException {
		readFromFile_HangHoa();
		long S = 0;
		for(HangHoa i : list) {
			S = S + i.getDongia()*i.getSoluong();
		}
		return S;
	}
	public static void display() throws IOException {
		System.out.println("\n=======================Tồn kho==========================\n");
		System.out.printf("%-10s %-25s %-15s\n", "Tồn kho", "Tổng giá trị hàng hóa", "Vốn");
		System.out.printf("%-10d %-25d %d\n", total_HangHoa(), total_value(), giaVon);
	}
	public static void main(String args[]) throws IOException {
		TonKhoDisplay.readFromFile_HangHoa();
		TonKhoDisplay.readGiaVon();
		TonKhoDisplay.display();
	}
}
