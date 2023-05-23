
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

public class arrTaiKhoan implements CheckingFormat{

    private List<TaiKhoan> list = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    public String ID_login = "";
    public void nhapMang() {
        boolean cont = true;
        boolean cont1 = true;
        try {
            FileWriter fw = new FileWriter("TaiKhoan.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);

            do {
                System.out.println("============= Tao tai khoan =============");
                System.out.println("So tai khoan hien tai: " + list.size());
                TaiKhoan tk = new TaiKhoan();
                tk.nhapMaNV();
                boolean off_mnv = true;
                boolean flag_mnv = true;
                while (off_mnv == true) {
                    for (int j = 0; j < list.size(); j++) {
                        if (tk.getMaNhanVien().equalsIgnoreCase(list.get(j).getMaNhanVien())) {
                            flag_mnv = false;
                        }
                    }
                    if (flag_mnv == false) {
                        System.out.println("Ma nhan vien da ton tai, vui long nhap ma nhan vien khac !!!!!");
                        tk.nhapMaNV();
                        flag_mnv = true;
                    } else if (flag_mnv == true) {
                        off_mnv = false;
                    }
                }

                tk.nhapTenTK();
                boolean off_tk = true;
                boolean flag_tk = true;
                while (off_tk == true) {
                    for (int j = 0; j < list.size(); j++) {
                        if (tk.getTenTaiKhoan().equalsIgnoreCase(list.get(j).getTenTaiKhoan())) {
                            flag_tk = false;
                        }
                    }
                    if (flag_tk == false) {
                        System.out.println("Ten tai khoan da ton tai !!!!!");
                        tk.nhapTenTK();
                        flag_tk = true;
                    } else if (flag_tk == true) {
                        off_tk = false;
                    }
                }

                tk.nhap();
                list.add(tk);
                bw.write(tk.toString());
                bw.newLine();
                do {
                    System.out.println("Ban co muon tao them tai khoan khong? [y/n]");
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

    // đọc dữ liệu từ file
    public void readFromFile() throws IOException {
        File temp = new File("TaiKhoan.txt");
        BufferedReader br = new BufferedReader(new FileReader(temp));
        String line1 = "";
        line1 = br.readLine();
        if (line1 == null) {
            System.out.println("Hiện không có dữ liệu, dữ liệu mặc định sẽ được tải xuống..........");
            try {
                File phieunhap = new File("TaiKhoan_Default.txt");
                BufferedReader brn = new BufferedReader(new FileReader(phieunhap));
                String line = "";
                while (true) {
                    line = brn.readLine();
                    if (line == null) {
                        break;
                    }
                    BufferedWriter bwn = new BufferedWriter(new FileWriter(temp, true));
                    bwn.write(line);
                    bwn.newLine();
                    bwn.close();
                }
                brn.close();
            } catch (FileNotFoundException e) {
                throw e;
            } catch (NumberFormatException e) {
                throw e;
            }finally {
            	 br.close();
            }
        }
       
        try {
            FileReader file = new FileReader("TaiKhoan.txt");
            try {
                BufferedReader bufferedReader = new BufferedReader(file);
                String line = "";
                while (true) {
                    line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    String txt[] = line.split("[;/]");
                    String maNV = txt[0];
                    String tenTK = txt[1];
                    String matKhau = txt[2];
                    NgayThang ngayTao = new NgayThang();
                    ngayTao.setNgay(Integer.parseInt(txt[3]));
                    ngayTao.setThang(Integer.parseInt(txt[4]));
                    ngayTao.setNam(Integer.parseInt(txt[5]));
                    String status = txt[6];
                    String permiss = txt[7];
                    TaiKhoan create = new TaiKhoan(maNV, tenTK, matKhau, ngayTao, status, permiss);
                    boolean flag = true;
					int local = 0;
					for(TaiKhoan i : list) {
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
                bufferedReader.close();
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

    public void login() {
        System.out.print("Nhập tên tài khoản: ");
        String username = sc.nextLine();
        System.out.print("Nhập mật khẩu: ");
        String password = sc.nextLine();
        boolean off = true;
        boolean flag = true;
        boolean flag_status = true;
        while (off == true) {
            for (int j = 0; j < list.size(); j++) {
                if (username.equals(list.get(j).getTenTaiKhoan()) && password.equals(list.get(j).getMatKhau()) && list.get(j).gettrangThaiTK().equalsIgnoreCase("active")) {
                	ID_login = list.get(j).getMaNhanVien();
                	flag = false;
                    flag_status = true;
                } else if (username.equals(list.get(j).getTenTaiKhoan()) && password.equals(list.get(j).getMatKhau()) && list.get(j).gettrangThaiTK().equalsIgnoreCase("lock")) {
                    flag_status = false;
                    flag = false;
                }
            }
            if (flag == false) {
                if (flag_status == false) {
                    System.out.println("Tài khoản này hiện đang khóa !!!!");
                    System.out.print("Nhập tên tài khoản: ");
                    username = sc.nextLine();
                    System.out.print("Nhập mật khẩu: ");
                    password = sc.nextLine();
                    off = true;
                } else {
                    System.out.println("Đăng nhập thành công !!!!!!!");
                    off = false;
                }
            } else if (flag == true) {
                System.out.println("Tên tài khoản hoặc mật khẩu không đúng !!!!!");
                System.out.print("Nhập tên tài khoản: ");
                username = sc.nextLine();
                System.out.print("Nhập mật khẩu: ");
                password = sc.nextLine();
                off = true;
            }

        }
    }
    public void login_admin() {
    	System.out.println("ĐĂNG NHẬP VỚI QUYỀN ADMIN!!!");
        System.out.print("Nhập tên tài khoản: ");
        String username = sc.nextLine();
        System.out.print("Nhập mật khẩu: ");
        String password = sc.nextLine();
        boolean off = true;
        boolean flag = true;
        boolean flag_status = true;
        while (off == true) {
            for (int j = 0; j < list.size(); j++) {
                if (username.equals(list.get(j).getTenTaiKhoan()) && password.equals(list.get(j).getMatKhau()) 
                		&& list.get(j).gettrangThaiTK().equalsIgnoreCase("active") && list.get(j).getPermission().equalsIgnoreCase("admin")) {
                    flag = false;
                    flag_status = true; 	
                } else if (username.equals(list.get(j).getTenTaiKhoan()) && password.equals(list.get(j).getMatKhau()) 
                		&& list.get(j).gettrangThaiTK().equalsIgnoreCase("lock")) {
                    flag_status = false;
                    flag = false;
                }
            }
            if (flag == false) {
                if (flag_status == false) {
                    System.out.println("Tài khoản này hiện đang khóa !!!!");
                    System.out.print("Nhập tên tài khoản: ");
                    username = sc.nextLine();
                    System.out.print("Nhập mật khẩu: ");
                    password = sc.nextLine();
                    off = true;
                } else {
                    System.out.println("Đăng nhập thành công !!!!!!!");
                    off = false;
                }
            } else if (flag == true) {
                System.out.println("Tên tài khoản hoặc mật khẩu không đúng !!!!!");
                System.out.print("Nhập tên tài khoản: ");
                username = sc.nextLine();
                System.out.print("Nhập mật khẩu: ");
                password = sc.nextLine();
                off = true;
            }

        }
    }
    public void sort() {
        //Tu tu code
    }

    public void fix() {
        boolean cont = true;
        boolean cont1 = true;
        try {
            do {
                System.out.print("Nhập tên tài khoản muốn sửa");
                String tk = this.IDTKchecking();
                boolean off = true;
                boolean flag = true;
                while (off == true) {
                    for (int i = 0; i < list.size(); i++) {
                        if (tk.equalsIgnoreCase(list.get(i).getTenTaiKhoan())) {
                            list.get(i).nhapMaNV();
                            list.get(i).nhapTenTK();
                            list.get(i).nhap();
                            flag = false;
                            break;
                        }
                    }
                    if (flag == true) {
                        System.out.println("Tài khoản không tồn tại, xin mời nhập tài khoản khác !!!!!");
                        tk = this.IDTKchecking();
                    } else if (flag == false) {
                        off = false;
                    }
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
            File file_fix = new File("TaiKhoan.txt");
    		try {
    			BufferedWriter bw_tk = new BufferedWriter(new FileWriter(file_fix));
    			for(TaiKhoan i : list) {
    				bw_tk.write(i.toString());
    				bw_tk.newLine();
    			}
    			bw_tk.close();
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
        } catch (Exception e) {
            System.out.println("Danh sách rỗng");
        }
    }

    public void seach() {
        boolean cont = true;
        boolean cont1 = true;
        TaiKhoan tk = new TaiKhoan();
        try {
            do {
                System.out.println("Nhập tài khoản muốn tìm kiếm");
                tk.nhapTenTK();
                boolean off = true;
                boolean flag = true;
                while (off == true) {
                    if (list.size() != 0) {
                        for (int i = 0; i < list.size(); i++) {
                            if (tk.getTenTaiKhoan().equalsIgnoreCase(list.get(i).getTenTaiKhoan())) {
                                System.out.print("========================================= Danh Sach Tai Khoan ===========================================\n");
                                System.out.printf("%-5s %-15s %-25s %-25s %-20s %-15s\n", "STT", "Ma nhan vien", "Tai khoan", "Mat khau", "Ngay tao tai khoan", "Trang thai");
                                list.get(i).xuat();
                                flag = false;
                            }
                        }
                    } else {
                        System.out.println("Danh sách tài khoản rỗng !!");
                        return;
                    }
                    if (flag == true) {
                        System.out.println("Tài khoản không tồn tại, xin mời nhập tải khoản khác !!");
                        tk.nhapTenTK();
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
    // @SuppressWarnings("static-access")

    public void delete() {
        boolean cont = true;
        boolean cont1 = true;
        do {
        	System.out.print("Nhập tên tài khoản :");
		    String tk = this.IDTKchecking();
		    boolean off = true;
		    boolean flag = true;
		    while (off == true) {
		        for (int i = 0; i < list.size(); i++) {
		            if (tk.equalsIgnoreCase(list.get(i).getTenTaiKhoan())) {
		                list.remove(i);
		                flag = false;
		            }
		        }
		        if (flag == true) {
		            System.out.println("Tài khoản không tồn tại, xin mời nhập tài khoản khác !!!!!");
		            tk = this.IDTKchecking();
		        } else if (flag == false) {
		            off = false;
		        }
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
		File file_delete = new File("TaiKhoan.txt");
		try {
			BufferedWriter bw_tk = new BufferedWriter(new FileWriter(file_delete));
			for(TaiKhoan i : list) {
				bw_tk.write(i.toString());
				bw_tk.newLine();
			}
			bw_tk.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void xuatMang() {
        try {
            System.out.println("========================================= Danh Sach Tai Khoan ===========================================\n");
            System.out.printf("%-5s %-15s %-25s %-25s %-20s %-15s %-15s\n", "STT", "Ma nhan vien", "Tai khoan", "Mat khau", "Ngay tao tai khoan", "Trang thai", "Quyen truy cap");
            for (TaiKhoan i : list) {
                i.xuat();
                System.out.println("");
            }
            TaiKhoan.count = 0;
        } catch (NullPointerException ex) {
            System.out.println("Danh sách rỗng ");
        }
    }

    public static void main(String args[]) throws IOException {

        arrTaiKhoan a = new arrTaiKhoan();
        a.readFromFile();
       a.seach();
       a.fix();
        // a.delete();
        a.xuatMang();
    }

}
