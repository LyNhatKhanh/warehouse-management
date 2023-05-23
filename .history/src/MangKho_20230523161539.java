import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class MangKho implements CheckingFormat{

    private Kho[] list = new Kho[500];
    private int n = 0;
    Scanner inp = new Scanner(System.in);
    
    public void execute_kho_kiemke_ct_nhap(String hh) {
    	try {
			this.readFromFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	try {
            FileWriter fw = new FileWriter("Kho.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            Kho k = new Kho();
            k.setMaHangHoa(hh);
            k.nhap_vitri();
            boolean off = true;
			boolean flag = true;
			while(off == true) {
				for(int i = 0; i < n; i++) {
					if(k.getMaHangHoa().equalsIgnoreCase(list[i].getMaHangHoa()) && k.getViTri().equalsIgnoreCase(list[i].getViTri())) {   						
						flag = false;
					}
				}
				if(flag == false) {
					System.out.println("Mã sản phẩm và mã phiếu nhập đã tồn tại, xin mời nhập mã khác !!!!!");
					k.setMaHangHoa(hh);
		            k.nhap_vitri();
					flag = true;
				}
				else if(flag == true) {
					off = false;
				}
			}
            list[n] = k;
            bw.write(list[n].toString());
            bw.newLine();
            n++;
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void nhapMang() {
        boolean cont = true;
        boolean cont1 = true;
        try {
            FileWriter fw = new FileWriter("Kho.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            do {
                Kho k = new Kho();
                k.nhap_PK();
                boolean off = true;
    			boolean flag = true;
    			while(off == true) {
    				for(int i = 0; i < n; i++) {
    					if(k.getMaHangHoa().equalsIgnoreCase(list[i].getMaHangHoa()) && k.getViTri().equalsIgnoreCase(list[i].getViTri())) {   						
    						flag = false;
    					}
    				}
    				if(flag == false) {
    					System.out.println("Mã sản phẩm và mã phiếu nhập đã tồn tại, xin mời nhập mã khác !!!!!");
    					k.nhap_PK();
    					flag = true;
    				}
    				else if(flag == true) {
    					off = false;
    				}
    			}
                list[n] = k;
                bw.write(list[n].toString());
                bw.newLine();
                n++;
                do {
                    System.out.println("Bạn có muốn tiếp tục không ? [y/n]");
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
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void readFromFile() throws IOException {
    	File temp = new File("Kho.txt");
		BufferedReader br_temp = new BufferedReader(new FileReader(temp));
		String line1 = "";
		line1 = br_temp.readLine();
		if(line1 == null){
			System.out.println("Hiện không có dữ liệu, dữ liệu mặc định sẽ được tải xuống..........");
			try {
				File phieunhap = new File("Kho_Default.txt");
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
            FileReader file = new FileReader("Kho.txt");
            try {
                BufferedReader br = new BufferedReader(file);
                String line = "";
                while (true) {
                    line = br.readLine();
                    if (line == null) {
                        break;
                    }
                    String txt[] = line.split("[;]");
                    String viTri = txt[1];
                    String maHangHoa = txt[0];  
                    Kho create = new Kho(maHangHoa, viTri);
                    boolean flag = true;
					int local = 0;
					for(int i = 0; i < n; i++) {
						if(list[i].getViTri().equalsIgnoreCase(create.getViTri()) && list[i].getMaHangHoa().equalsIgnoreCase(create.getMaHangHoa())) {
							flag = false;
							local = i;
							break;
						}
					}
					if(flag == true) {
						list[n] = create;
						n++;
					}	
					else {
						list[local] = create;
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
    
    
    public void delete() {
        boolean cont = true;
        boolean cont1 = true;
        try {
            do {
            	System.out.print("Nhập mã hàng hóa :");
                String fix_b = this.maHangHoaChecking(); 
            	System.out.print("Nhập vị trí bạn muốn xóa: ");
                String fix_a = this.viTriChecking();
                     
                boolean off = true;
                boolean flag = true;
                while (off == true) {
                    for (int i = 0; i < n; i++) {
                        if (list[i].getViTri().equalsIgnoreCase(fix_a) && list[i].getMaHangHoa().equalsIgnoreCase(fix_b)) {
                            for(int j = i; j < n-1; j++) {
                            	list[j] = list[j+1];
                            }
                            n--;
                            System.out.println("Xoa thanh cong!!!!");
                            flag = false;
                        }
                    }
                    if (flag == true) {
                        System.out.println("Vị trí không tồn tại !!!");
                        System.out.print("Nhập mã hàng hóa :");
                        fix_b = this.maHangHoaChecking(); 
                    	System.out.print("Nhập vị trí bạn muốn xóa: ");
                        fix_a = this.viTriChecking();
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
            File kho_delete = new File("Kho.txt");
            BufferedWriter bw_delete = new BufferedWriter(new FileWriter(kho_delete));
            for (int i = 0; i < n; i++) {
                bw_delete.write(list[i].toString());
                bw_delete.newLine();
            }
            bw_delete.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public void seach() {
        boolean cont = true;
        boolean cont1 = true;
        Kho kho = new Kho();
        try {
            do {
                String enter = inp.nextLine();
                boolean off = true;
                boolean flag = true;
                while (off == true) {
                    if (n != 0) {
                    	System.out.println("============================== Danh Sách Kho ==============================\n");
                        System.out.printf("%-4s %-15s %-15s\n", "STT", "Mã sản phẩm", "Vị trí");
                        for (int i = 0; i < n; i++) {
                            if (list[i].getViTri().equalsIgnoreCase(enter) || list[i].getMaHangHoa().equalsIgnoreCase(enter)) {
                                list[i].xuat();
                                flag = false;
                            }
                        }
                    } else {
                        System.out.println("Danh sách hàng hoá rỗng !!");
                        return;
                    }
                    if (flag == true) {
                        System.out.println("Vị trí ko tồn tại, xin mời nhập mã khác !!");
                        enter = inp.nextLine();
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

    public void xuatMang() {
        try {
            System.out.println("============================== Danh Sach Kho ==============================\n");
            System.out.printf("%-4s %-15s %-15s\n", "STT", "Mã hàng hóa", "Vị trí");          
            for (int i = 0; i < n; i++) {
                list[i].xuat();              
            }    
            Kho.count = 1;
        } catch (NullPointerException ex) {
            System.out.println("Danh sách rỗng ");
        }
    }
    
    public void fix() {
        boolean cont = true;
        boolean cont1 = true;
        try {
            do {
            	System.out.print("Nhập mã hàng hóa bạn muốn xóa:");
                String fix_b = this.maHangHoaChecking(); 
            	System.out.print("Nhập vị trí bạn muốn xóa: ");
                String fix_a = this.viTriChecking();
                boolean off = true;
                boolean flag = true;
                while (off == true) {
                	int replace = 0;
                	for (int j = 0; j < n; j++) {
        				if (list[j].getViTri().equalsIgnoreCase(fix_a) && list[j].getMaHangHoa().equalsIgnoreCase(fix_b)) {
        					flag = false;
        					replace = j;
        				}
        			}
        			if (flag == false) {
        				System.out.println(
        						"Mời nhập lại thông tin (xin nhập lại tất cả, chức năng sửa từng thuộc tính sẽ được nâng cấp sau): ");
        				list[replace].nhap_PK();
        				boolean off1 = true;
        				boolean flag1 = true;
        				while (off1 == true) {
        					// Kiểm tra trước cái replace có mã nào trùng vs nó không
        					for (int j = replace - 1; j >= 0; j--) {
        						if (list[replace].getViTri().equalsIgnoreCase(list[j].getViTri()) && list[replace].getMaHangHoa().equalsIgnoreCase(list[j].getMaHangHoa())) {
        							flag1 = false;
        						}
        					}
        					// Kiểm tra sau cái replace có mã nào trùng vs nó không
        					for (int j = replace + 1; j < n; j++) {
        						if (list[replace].getViTri().equalsIgnoreCase(list[j].getViTri()) && list[replace].getMaHangHoa().equalsIgnoreCase(list[j].getMaHangHoa())) {
        							flag1 = false;
        						}
        					}
        					if (flag1 == false) {
        						System.out.println("Đã tồn tại, xin mời nhập mã khác !!!!!");
        						list[replace].nhap_PK();
        						flag1 = true;
        					} else if (flag1 == true) {
        						off1 = false;
        					}
        				}
        				off = false;
        			}
        			else {
        				System.out.println("Không tồn tại!!!!");
        				System.out.print("Nhập mã hàng hóa :");
		                fix_b = this.maHangHoaChecking(); 
		            	System.out.print("Nhập vị trí bạn muốn xóa: ");
		                fix_a = this.viTriChecking();
        			}
                }
                File kho_delete = new File("Kho.txt");
                BufferedWriter bw_delete = new BufferedWriter(new FileWriter(kho_delete));
                for (int i = 0; i < n; i++) {
                    bw_delete.write(list[i].toString());
                    bw_delete.newLine();
                }
                bw_delete.close();
                do {
                    System.out.print("Bạn có muốn sửa tiếp không ? [y/n]:");
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
            System.out.println("Danh sách rỗng");
        }
    }
    
    public static void main(String[] args) throws IOException {
        MangKho arr = new MangKho();
        arr.readFromFile();
        arr.fix();
        
        arr.xuatMang();
    }
}
