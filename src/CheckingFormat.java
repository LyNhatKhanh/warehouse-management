import java.util.Scanner;

public interface CheckingFormat {
	Scanner inp = new Scanner(System.in);
	default String IDPNchecking() {
		String DauVao;
		while(true) {
			DauVao = inp.nextLine();
			DauVao = DauVao.toUpperCase();
			if(DauVao.matches("PN" + "[0-9]{1,3}")){
				return DauVao;
			}
			else {
				System.out.println("Dinh dang ma san pham: PN___. Vi du: PN001");
			}
			System.out.print("Moi nhap lai: ");
		}
	}
	default String maHangHoaChecking() {
        String dauVao;
        while(true) {
        	dauVao = inp.nextLine();
            dauVao = dauVao.toUpperCase();
            if(dauVao.matches("MHH" + "[0-9]{1,3}")){
                    return dauVao;
            }
            else {
                    System.out.println("Dinh dang ma hang hoa: MHH___. Vi du: MHH001");
            }
            System.out.print("Moi nhap lai: ");
        }
    }
	public default String IDNCCchecking() {
		String DauVao;
		while(true) {
			DauVao = inp.nextLine();
			DauVao = DauVao.toUpperCase();
			if(DauVao.matches("SUP" + "[0-9]{1,3}")){
				return DauVao;
			}
			else {
				System.out.println("Dinh dang ma san pham: SUP___. Vi du: SUP001");
			}
			System.out.print("Moi nhap lai: ");
		}
	}
	public default String IDNVchecking() {
		String DauVao;
		while(true) {
			DauVao = inp.nextLine();
			DauVao = DauVao.toUpperCase();
			if(DauVao.matches("NV" + "[0-9]{1,3}")){
				return DauVao;
			}
			else {
				System.out.println("Dinh dang ma san pham: NV___. Vi du: NV001");
			}
			System.out.print("Moi nhap lai: ");
		}
	}
	public default String IDCHchecking() {
		String DauVao;
		while(true) {
			DauVao = inp.nextLine();
			DauVao = DauVao.toUpperCase();
			if(DauVao.matches("CUS" + "[0-9]{1,3}")){
				return DauVao;
			}
			else {
				System.out.println("Định dạng mã nhà cung cấp: CUS___. Vi du: CUS001");
			}
			System.out.print("Moi nhap lai: ");
		}
	}
	public default String IDPXchecking() {
		String DauVao;
		while(true) {
			DauVao = inp.nextLine();
			DauVao = DauVao.toUpperCase();
			if(DauVao.matches("PX" + "[0-9]{1,3}")){
				return DauVao;
			}
			else {
				System.out.println("Dinh dang ma phieu xuat: PX___. Vi du: PX001");
			}
			System.out.print("Moi nhap lai: ");
		}
	}
	public default String IDPTchecking() {
		String DauVao;
		while(true) {
			DauVao = inp.nextLine();
			DauVao = DauVao.toUpperCase();
			if(DauVao.matches("PT" + "[0-9]{1,3}")){
				return DauVao;
			}
			else {
				System.out.println("Dinh dang ma phieu xuat: PT___. Vi du: PT001");
			}
			System.out.print("Moi nhap lai: ");
		}
	}
	// Chuẩn hóa chữ cái đầu viết hoa
	public default String chuanhoa() {
		String message;
	    message = inp.nextLine();
	    message = message.toLowerCase();
	    char[] charArray = message.toCharArray();
	    boolean foundSpace = true;
	    for(int i = 0; i < charArray.length; i++) {
	      if(Character.isLetter(charArray[i])) {   
	        if(foundSpace) {	          
	          charArray[i] = Character.toUpperCase(charArray[i]);
	          foundSpace = false;
	        }
	      }
	      else {
	        foundSpace = true;
	      }
	    }
	    message = String.valueOf(charArray);
		return message;
	}
	public default int soLuongChecking() 
    {
		String dauVao;		 
	    while(true){
	    	 dauVao = inp.nextLine().trim();
	    	 if(dauVao.matches("[0-9]{1,9}")) {
	    		 return Integer.parseInt(dauVao);
	    	 }
	    	 else {
	    		 System.out.println("Định dạng sai");
	    	 }
	    	 System.out.print("Moi nhap lai: ");
	    } 
    }  
	public default String kiemTraBlank() {
		String DauVao;
		while(true) {
			DauVao = chuanhoa();
			if(DauVao.isBlank() || DauVao.isEmpty()){
				System.out.println("Không được bỏ trống");
			}
			else {
				return DauVao;
			}
			System.out.print("Moi nhap lai: ");
		}
	}
	public default long giaChecking() {
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
	public default String checkTraNhap() {
		String DauVao;
		while(true) {
			DauVao = inp.nextLine().toUpperCase();
			if(DauVao.equalsIgnoreCase("n") || DauVao.equalsIgnoreCase("t")) {
				return DauVao;
			}
			else {
				System.out.println("Trả nhập 't'/Nhập nhập 'n' !!!");
			}
			System.out.println("Mời nhập lại: ");
		}
	}
	public default String checkXuatLoai() {
		String DauVao;
		while(true) {
			DauVao = inp.nextLine().toUpperCase();
			if(DauVao.equalsIgnoreCase("x") || DauVao.equalsIgnoreCase("l")) {
				return DauVao;
			}
			else {
				System.out.println("Xuất nhập 'x'/Loại nhập 'l' !!!");
			}
			System.out.println("Mời nhập lại: ");
		}
	}
	// Check số điện thoại
		public default String check_sdt() {
			String message_sdt;
			while (true) {
				message_sdt = inp.nextLine();
				if (message_sdt.matches("0[123456789]{1}\\d{8}")) {
					return message_sdt;
				} else {
					System.out.println("Định dạng số điện thoại (VD:0__):");
				}
				System.out.println("Vui lòng nhập lại !!");
			}
		}

		// Check email
		public default String check_email() {
			String message_email;
			while (true) {
				message_email = inp.nextLine();
				if (message_email.matches("^\\w+[a-z0-9]*@gmail.com$")) {
					return message_email;
				} else {
					System.out.println("Định dạng số email (VD:ten@gmail.com):");
				}
				System.out.println("Vui lòng nhập lại !!");
			}
		}
		//Vị trí checking
		public default String check_Local() {
			String message;
			while (true) {
				message = inp.nextLine();
				if (message.matches("[A-Z]" + "-" + "[1-9]")) {
					return message;
				} else {
					System.out.println("Vị trí bao gồm tên khu và số kệ (VD: A-1)!!!!");
				}
				System.out.println("Vui lòng nhập lại !!");
			}
		}
		public default int Check1_10() {
			String DauVao;
			while(true) {
				DauVao = inp.nextLine();
				if(DauVao.matches("[0-9]{1,2}")){
					return Integer.parseInt(DauVao);
				}
				else {
					System.out.println("Chi duoc nhap trong khoang 1->11.");
				}
				System.out.print("Moi nhap lai: ");
			}
		}
		public default int Check1_8() {
			String DauVao;
			while(true) {
				DauVao = inp.nextLine();
				if(DauVao.matches("[1-8]")){
					return Integer.parseInt(DauVao);
				}
				else {
					System.out.println("Chi duoc nhap trong khoang 1->8.");
				}
				System.out.print("Moi nhap lai: ");
			}
		}
		public default int Check1_2() {
			String DauVao;
			while(true) {
				DauVao = inp.nextLine();
				if(DauVao.matches("[1-2]")){
					return Integer.parseInt(DauVao);
				}
				else {
					System.out.println("Chi duoc nhap trong khoang 1->2.");
				}
				System.out.print("Moi nhap lai: ");
			}
		}
		public default int Check1_6() {
			String DauVao;
			while(true) {
				DauVao = inp.nextLine();
				if(DauVao.matches("[1-6]")){
					return Integer.parseInt(DauVao);
				}
				else {
					System.out.println("Chi duoc nhap trong khoang 1->6.");
				}
				System.out.print("Moi nhap lai: ");
			}
		}
		public default int Check1_3() {
			String DauVao;
			while(true) {
				DauVao = inp.nextLine();
				if(DauVao.matches("[1-3]")){
					return Integer.parseInt(DauVao);
				}
				else {
					System.out.println("Chi duoc nhap trong khoang 1->3.");
				}
				System.out.print("Moi nhap lai: ");
			}
		}
		public default int Check1_7() {
			String DauVao;
			while(true) {
				DauVao = inp.nextLine();
				if(DauVao.matches("[1-7]")){
					return Integer.parseInt(DauVao);
				}
				else {
					System.out.println("Chi duoc nhap trong khoang 1->7.");
				}
				System.out.print("Moi nhap lai: ");
			}
		}
		public default int Check1_5() {
			String DauVao;
			while(true) {
				DauVao = inp.nextLine();
				if(DauVao.matches("[1-5]")){
					return Integer.parseInt(DauVao);
				}
				else {
					System.out.println("Chi duoc nhap trong khoang 1->5.");
				}
				System.out.print("Moi nhap lai: ");
			}
		}
		public default String checkStatus() {
			String input ;
			while(true) {
				input = inp.nextLine();
				if(input.matches("[xv]")){
					return input;
				}
				else {
					System.out.println("Sai định dạng!!!");
				}
				System.out.print("Moi nhap lai: ");
			}
		}
		
		public default String checkPermission() {
			String DauVao;
			while(true) {
				DauVao = inp.nextLine().toUpperCase().trim();
				if(DauVao.equalsIgnoreCase("admin") || DauVao.equalsIgnoreCase("staff")) {
					return DauVao;
				}
				else {
					System.out.println("Chỉ được nhập một trong hai quyền truy cập (ADMIN // STAFF) !!!");
				}
				System.out.println("Mời nhập lại: ");
			}
		}
		
		public default String IDTKchecking() {
	        String DauVao;
	        while (true) {
	            DauVao = inp.nextLine().trim();
	            if (DauVao.matches("^[a-z0-9_-]{3,16}$")) {
	                return DauVao;
	            } else {
	                System.out.println("Tai khoan tu 3-16 ky tu (bao gom: chu thuong, so, \"_\", \"-\")");
	            }
	            System.out.print("Moi nhap lai: ");
	        }
	    }
		public default String viTriChecking() 
	    {
	        
	        String dauVao;
	        while(true) {
	                dauVao = inp.nextLine();
	                dauVao = dauVao.toUpperCase();
	                if(dauVao.matches("[A-D][-][1-9]")){
	                        return dauVao;
	                }
	                else {
	                        System.out.println("Định dạng vị trí: [Khu chứa hàng hóa(A-D)][-][Tên kệ(1-9)]. Vi du: A-1");
	                }
	                System.out.print("Moi nhap lai: ");
	        }
	    }   
		public default int ngayThangChecking() {
			String dauVao;
	        while(true) {
	        	dauVao = inp.nextLine();               
                if(dauVao.matches("[0-9]{1,4}")){
                        return Integer.parseInt(dauVao);
                }
                else {
                        System.out.println("Sai định dạng!!");
                }
                System.out.print("Moi nhap lai: ");     
	        }   
		}
}
