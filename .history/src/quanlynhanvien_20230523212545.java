
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

public class quanlynhanvien {

    private List<NhanVien> list = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void nhapMang() {
        boolean cont = true;
        boolean cont1 = true;
        try {
            FileWriter fw = new FileWriter("../NhanVien.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);

            do {
                System.out.println("============= Them Nhan Vien =============");
                System.out.println("So luong nhan vien hien tai: " + list.size());
                NhanVien nv = new NhanVien();
                nv.input_MaNhanVien();
                boolean off_mnv = true;
                boolean flag_mnv = true;
                while (off_mnv == true) {
                    for (int j = 0; j < list.size(); j++) {
                        if (nv.getMaNhanVien().equalsIgnoreCase(list.get(j).getMaNhanVien())) {
                            flag_mnv = false;
                        }
                    }
                    if (flag_mnv == false) {
                        System.out.println("Ma nhan vien da ton tai, vui long nhap ma nhan vien khac !!!!!");
                        nv.input_MaNhanVien();
                        flag_mnv = true;
                    } else if (flag_mnv == true) {
                        off_mnv = false;
                    }
                }
                nv.input_NhanVien();
                list.add(nv);
                bw.write(nv.toString());
                bw.newLine();
                do {
                    System.out.println("Ban co muon tao them nhan vien khong? [y/n]");
                    String opt = sc.nextLine();
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
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void xuatMang() {
    	
        try {
            System.out.println(
                    "========================================= Danh Sach Nhan Vien ===========================================\n");
            System.out.printf("%-3s %-10s %-18s %-5s %-13s %-12s %-15s %-15s %-22s %-15s %-15s %-15s\n", "STT", "Ma NV",
                    "Ho va Ten", "GT", "Ngay sinh", "SDT", "Thanh pho", "CCCD", "Email", "Ngay vao lam",
                    "Luong co ban", "Luong thuong");
            System.out.println("");
            for (NhanVien i : list) {
                i.xuat();
                System.out.println("");
            }
            NhanVien.count = 0;
        } catch (NullPointerException ex) {
            System.out.println("Danh sách rỗng ");
        }
    }
    
    // đọc dữ liệu từ file
    public void readFromFile() throws IOException {
    	File temp = new File("../NhanVien.txt");
		BufferedReader br_temp = new BufferedReader(new FileReader(temp));
		String line1 = "";
		line1 = br_temp.readLine();
		if(line1 == null){
			System.out.println("Hiện không có dữ liệu, dữ liệu mặc định sẽ được tải xuống..........");
			try {
				File phieunhap = new File("../NhanVien_Default.txt");
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
			}finally{
				br_temp.close();
			}
		}
		
        try {
            FileReader file = new FileReader("../NhanVien.txt");
            try {
                BufferedReader br = new BufferedReader(file);
                String line = "";
                while (true) {
                    line = br.readLine();
                    if (line == null) {
                        break;
                    }
                    String txt[] = line.split("[;/]");

                    String maNhanVien = txt[0];
                    String hoVaTen = txt[1];
                    String gioiTinh = txt[2];
                    NgayThang ngaySinh = new NgayThang();
                    ngaySinh.setNgay(Integer.parseInt(txt[3]));
                    ngaySinh.setThang(Integer.parseInt(txt[4]));
                    ngaySinh.setNam(Integer.parseInt(txt[5]));
                    String soDienThoai = txt[6];
                    DiaChi diaChi = new DiaChi();
                    diaChi.setTinhtp(txt[7]);
                    String canCuoc = txt[8];
                    String email = txt[9];
                    NgayThang ngayVaoLam = new NgayThang();
                    ngayVaoLam.setNgay(Integer.parseInt(txt[10]));
                    ngayVaoLam.setThang(Integer.parseInt(txt[11]));
                    ngayVaoLam.setNam(Integer.parseInt(txt[12]));
                    long luongCoBan = Long.parseLong(txt[13]);
                    long luongThuong = Long.parseLong(txt[14]);

                    NhanVien create = new NhanVien(maNhanVien, hoVaTen, gioiTinh, ngaySinh, soDienThoai, diaChi,
                            canCuoc, email, ngayVaoLam, luongCoBan, luongThuong);
                    boolean flag = true;
					int local = 0;
					for(NhanVien i : list) {
						if(i.getMaNhanVien().equalsIgnoreCase(create.getMaNhanVien())) {
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
            file.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    
    // Tìm kiếm thông tin bằng mã nhân viên trong danh sách
    public void seach_arrNV() {
        boolean cont = true;
        boolean cont1 = true;
        NhanVien nv = new NhanVien();
        try {
            do {
                System.out.println("Nhập mã nhân viên muốn tìm kiếm");
                nv.input_MaNhanVien();
                boolean off = true;
                boolean flag = true;
                while (off == true) {
                    if (list.size() != 0) {
                        for (int i = 0; i < list.size(); i++) {
                            if (nv.getMaNhanVien().equalsIgnoreCase(list.get(i).getMaNhanVien())) {
                                list.get(i).output_NhanVien();
                                flag = false;
                            }
                        }
                    } else {
                        System.out.println("Danh sách nhân viên rỗng !!");
                        return;
                    }
                    if (flag == true) {
                        System.out.println("Mã nhân viên không tồn tại, xin mời nhập mã khác !!");
                        nv.input_MaNhanVien();
                    } else if (flag == false) {
                        off = false;
                    }
                }
                do {
                    System.out.print("Bạn có muốn tìm kiếm tiếp không ? [y/n]:");
                    String opt = sc.nextLine();
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


    public void fix_arrNV() {
        boolean cont = true;
        boolean cont1 = true;
        try {
            FileWriter fw;
            BufferedWriter bw;
            File file = new File("../NhanVien.txt");
            do {
                NhanVien nv = new NhanVien();
                nv.input_MaNhanVien();
                boolean off = true;
                boolean flag = true;
                while (off == true) {
                    for (int i = 0; i < list.size(); i++) {
                        if (nv.getMaNhanVien().equalsIgnoreCase(list.get(i).getMaNhanVien())) {
                            list.get(i).input_NhanVien();
                            flag = false;
                        }
                    }
                    if (flag == true) {
                        System.out.println("Mã nhân viên không tồn tại, xin mời nhập mã khác !!!!!");
                        nv.input_MaNhanVien();
                    } else if (flag == false) {
                        off = false;
                    }
                }
                file.delete();
                fw = new FileWriter("../NhanVien.txt", true);
                bw = new BufferedWriter(fw);
                for (int i = 0; i < list.size(); i++) {
                    nv = list.get(i);
                    bw.write(nv.toString());
                    bw.newLine();
                }
                do {
                    System.out.print("Bạn có muốn sửa tiếp không ? [y/n]:");
                    String opt = sc.nextLine();
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
            bw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println("Danh sách rỗng");
        }
    }
    
    public void delete() {
        boolean cont = true;
        boolean cont1 = true;
        try {
            FileWriter fw;
            BufferedWriter bw;
            File file = new File("../NhanVien.txt");
            do {
                NhanVien nv = new NhanVien();
                nv.input_MaNhanVien();
                boolean off = true;
                boolean flag = true;
                while (off == true) {
                    for (int i = 0; i < list.size(); i++) {
                        if (nv.getMaNhanVien().equalsIgnoreCase(list.get(i).getMaNhanVien())) {
                            list.remove(i);
                            flag = false;
                        }
                    }
                    if (flag == true) {
                        System.out.println("Mã nhân viên không tồn tại, xin mời nhập mã khác !!!!!");
                        nv.input_MaNhanVien();
                    } else if (flag == false) {
                        off = false;
                    }
                }
                file.delete();
                fw = new FileWriter("../NhanVien.txt", true);
                bw = new BufferedWriter(fw);
                for (int i = 0; i < list.size(); i++) {
                    nv = list.get(i);
                    bw.write(nv.toString());
                    bw.newLine();
                }
                do {
                    System.out.print("Bạn có muốn xóa tiếp không ? [y/n]:");
                    String opt = sc.nextLine();
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
            bw.close();
            fw.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String args[]) throws IOException {
        quanlynhanvien qlnv = new quanlynhanvien();
        qlnv.nhapMang();
        qlnv.xuatMang();
        qlnv.seach_arrNV();
        qlnv.fix_arrNV();
        qlnv.delete();
        qlnv.xuatMang();
    }

}
