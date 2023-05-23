
import java.io.IOException;
import java.util.Scanner;

public class Menu implements CheckingFormat {

	Scanner input = new Scanner(System.in);
	static String maNV = "";
	public Menu() {

	}

	public void login() throws IOException {
		arrTaiKhoan a = new arrTaiKhoan();
		boolean cont = true;
		do {
			System.out.println("╔==============================================╗");
			System.out.println("|                  ĐĂNG NHẬP                   |");
			System.out.println("|  1. Đăng nhập                                |");
			System.out.println("|  2. Thoát chương trình                       |");
			System.out.println("╚==============================================╝");
			System.out.print("Nhap lua chon: ");
			int opt = this.Check1_2();
			switch (opt) {
			case 1:
				a.readFromFile();
				a.login();
				maNV = a.ID_login;
				mainMenu();
				break;
			case 2:
				System.out.println("Tạm biệt!!!!!");
				cont = false;
				break;
			}
		} while (cont);
	}

	public void mainMenu() throws IOException {
		TonKhoDisplay.readGiaVon();
		boolean cont = true;
		do {
			System.out.println("╔==============================================╗");
			System.out.println("|            QUẢN LÝ KHO HÀNG                  |");
			System.out.println("|  1 . Thực hiện quy trình nhập kho            |");
			System.out.println("|  2 . Thực hiện quy trình xuất kho            |");
			System.out.println("|  3 . Quản lý Nhân Viên                       |");
			System.out.println("|  4 . Quản lý Phiếu                           |");
			System.out.println("|  5 . Quản Lý Tài khoản                       |");
			System.out.println("|  6 . Quản Lý Hàng hoá                        |");
			System.out.println("|  7 . Quản Lý Kiểm Kê                         |");
			System.out.println("|  8 . Tồn kho                                 |");
			System.out.println("|  9 . Kho hàng                                |");
			System.out.println("|  10 . Quản lí đối tác                        |");
			System.out.println("|  11 . Đăng Xuất                              |");
			System.out.println("╚==============================================╝");
			System.out.print("Nhap lua chon: ");
			int opt = this.Check1_10();
			switch (opt) {
			case 1:
				quytrinh_nhap();
				break;
			case 2:
				quytrinh_xuat();
				break;
			case 3:
				this.login_nhanvien();
				break;
			case 4:
				this.sub_menu_phieu();
				break;
			case 5:
				this.login_taikhoan();
				break;
			case 6:
				this.sub_menu_hanghoa();
				break;
			case 7:
				this.sub_menu_kiemke();
				break;
			case 8:
				this.submenu_tonkho();
				break;
			case 9:
				this.sub_menu_kho();
				break;
			case 10:
				this.sub_menu_doitac();
				break;
			case 11:
				System.out.println("Đã đăng xuất!!!!!");
				cont = false;
				break;
			}
		} while (cont);
	}
	
	
	public void quytrinh_nhap() {
		arrPhieu a = new arrPhieu();
		a.ID_login = Menu.maNV;
		a.execute_nhap();
	}
	public void quytrinh_xuat() {
		arrPhieu a = new arrPhieu();
		a.ID_login = Menu.maNV;
		a.execute_xuat();
	}
	public void login_nhanvien() throws IOException {
        arrTaiKhoan a = new arrTaiKhoan();
        a.readFromFile();
        boolean cont = true;
        do {
            System.out.println("╔==============================================╗");
            System.out.println("|                  ĐĂNG NHẬP ADMIN             |");
            System.out.println("|  1. Đăng nhập                                |");
            System.out.println("|  2. Quay lại                                 |");
            System.out.println("╚==============================================╝");
            System.out.print("Nhap lua chon: ");
            int opt = this.Check1_2();
            switch (opt) {
                case 1:
                    a.readFromFile();
                    a.login_admin();
                    sub_menu_nhanvien();
                    break;
                case 2:
                    cont = false;
                    break;
            }
        } while (cont);
    }

    public void login_taikhoan() throws IOException {
        arrTaiKhoan a = new arrTaiKhoan();
        a.readFromFile();
        boolean cont = true;
        do {
            System.out.println("╔==============================================╗");
            System.out.println("|                  ĐĂNG NHẬP ADMIN             |");
            System.out.println("|  1. Đăng nhập                                |");
            System.out.println("|  2. Quay lại                                 |");
            System.out.println("╚==============================================╝");
            System.out.print("Nhap lua chon: ");
            int opt = this.Check1_2();
            switch (opt) {
                case 1:
                    a.readFromFile();
                    a.login_admin();
                    sub_menu_taikhoan();
                    break;
                case 2:
                    cont = false;
                    break;
            }
        } while (cont);
    }
	public void sub_menu_nhanvien() throws IOException {
		quanlynhanvien a = new quanlynhanvien();
		a.readFromFile();
		boolean cont = true;
		do {
			System.out.println("╔==============================================╗");
			System.out.println("|            QUẢN LÝ NHÂN VIÊN                 |");
			System.out.println("|  1 . Thêm Nhân Viên                          |");
			System.out.println("|  2 . Sửa Thông tin nhân viên                 |");
			System.out.println("|  3 . Xóa thông tin nhân viên                 |");
			System.out.println("|  4 . Danh sách nhân viên                     |");
			System.out.println("|  5 . Tìm kiếm                                |");
			System.out.println("|  6 . Quay lại                                |");
			System.out.println("╚==============================================╝");
			System.out.print("Nhap lua chon: ");
			int opt = this.Check1_6();
			switch (opt) {
			case 1:
				a.nhapMang();
				break;
			case 2:
				a.fix_arrNV();
				break;
			case 3:
				a.delete();
				break;
			case 4:
				a.xuatMang();
				break;
			case 5:
				a.seach_arrNV();
				break;
			case 6:
				cont = false;
				break;
			}
		} while (cont);
	}
	public void sub_menu_doitac() throws IOException {
		boolean cont = true;
		do {
			System.out.println("╔==============================================╗");
			System.out.println("|              QUẢN LÝ ĐỐI TÁC                 |");
			System.out.println("|  1 . Cửa hàng                                |");
			System.out.println("|  2 . Nhà cung cấp                            |");
			System.out.println("|  3 . Quay lại                                |");
			System.out.println("╚==============================================╝");
			System.out.print("Nhap lua chon: ");
			int opt = this.Check1_3();
			switch (opt) {
			case 1:
				this.sub_menu_cuahang();;
				break;
			case 2:
				this.sub_menu_nhacungcap();
				break;
			case 3:
				cont = false;
				break;
			}
		} while (cont);
	}
	public void sub_menu_phieu() throws IOException {
		boolean cont = true;
		do {
			System.out.println("╔==============================================╗");
			System.out.println("|              QUẢN LÝ PHIẾU                   |");
			System.out.println("|  1 . Quản lý phiếu nhập                      |");
			System.out.println("|  2 . Quản lý phiếu xuất                      |");
			System.out.println("|  3 . Quay lại                                |");
			System.out.println("╚==============================================╝");
			System.out.print("Nhap lua chon: ");
			int opt = this.Check1_3();
			switch (opt) {
			case 1:
				sub_menu_phieunhap();
				break;
			case 2:
				sub_menu_phieuxuat();
				break;
			case 3:
				cont = false;
				break;
			}
		} while (cont);
	}

	public void sub_menu_phieunhap() throws IOException {
		arrPhieu a = new arrPhieu();
		a.readFromFile();
		boolean cont = true;
		do {
			System.out.println("╔==============================================╗");
			System.out.println("|              QUẢN LÝ PHIẾU NHẬP              |");
			System.out.println("|  1 . Danh sách phiếu nhập                    |");
			System.out.println("|  2 . Chi tiết danh sách phiếu nhập           |");
			System.out.println("|  3 . Thêm mới phiếu nhập                     |");
			System.out.println("|  4 . Sửa phiếu nhập                          |");
			System.out.println("|  5 . Xóa phiếu nhập                          |");
			System.out.println("|  6 . Tìm kiếm                                |");
			System.out.println("|  7 . Quay lại                                |");
			System.out.println("╚==============================================╝");
			System.out.print("Nhap lua chon: ");
			int opt = this.Check1_7();
			switch (opt) {
			case 1:
				a.output_1();;
				break;
			case 2:
				sub_menu_CTPhieuNhap();
				break;
			case 3:
				a.input_n();;
				break;
			case 4:
				a.fix_1();
				break;
			case 5:
				a.delete_1();
				break;
			case 6:
				a.search__1();
				break;
			case 7:
				cont = false;
				break;
			}
		} while (cont);
	}

	public void sub_menu_phieuxuat() throws IOException {
		arrPhieu a = new arrPhieu();
		a.readFromFile();
		boolean cont = true;
		do {
			System.out.println("╔==============================================╗");
			System.out.println("|              QUẢN LÝ PHIẾU XUẤT              |");
			System.out.println("|  1 . Danh sách phiếu xuất                    |");
			System.out.println("|  2 . Chi tiết danh sách phiếu xuất           |");
			System.out.println("|  3 . Thêm mới phiếu xuất                     |");
			System.out.println("|  4 . Sửa phiếu xuất                          |");
			System.out.println("|  5 . Xóa phiếu xuất                          |");
			System.out.println("|  6 . Tìm kiếm                                |");
			System.out.println("|  7 . Quay lại                                |");
			System.out.println("╚==============================================╝");
			System.out.print("Nhap lua chon: ");
			int opt = this.Check1_7();
			switch (opt) {
			case 1:
				a.output_2();;
				break;
			case 2:
				sub_menu_CTPhieuXuat();
				break;
			case 3:
				a.input_x();
				break;
			case 4:
				a.fix_2();
				break;
			case 5:
				a.delete_2();
				break;
			case 6:
				a.search__2();
				break;
			case 7:
				cont = false;
				break;
			}
		} while (cont);
	}

	public void sub_menu_taikhoan() throws IOException {
		arrTaiKhoan a = new arrTaiKhoan();
		a.readFromFile();
		boolean cont = true;
		do {
			System.out.println("╔==============================================╗");
			System.out.println("|              QUẢN LÝ TÀI KHOẢN               |");
			System.out.println("|  1 . Thêm Tài khoản                          |");
			System.out.println("|  2 . Sửa Thông tin Tài khoản                 |");
			System.out.println("|  3 . Xóa thông tin Tài khoản                 |");
			System.out.println("|  4 . Tìm kiếm                                |");
			System.out.println("|  5 . Danh sách Tài khoản                     |");
			System.out.println("|  6 . Quay lại                                |");
			System.out.println("╚==============================================╝");
			System.out.print("Nhap lua chon: ");
			int opt = this.Check1_6();
			switch (opt) {
			case 1:
				a.nhapMang();
				break;
			case 2:
				a.fix();
				break;
			case 3:
				a.delete();
				break;
			case 4:
				a.seach();
				break;
			case 5:
				a.xuatMang();
				break;
			case 6:
				cont = false;
				break;
			}
		} while (cont);
	}

	public void sub_menu_nhacungcap() throws IOException {
		arrSUP a = new arrSUP();
		a.readFromFile_SUP();
		boolean cont = true;
		do {
		System.out.println("╔==============================================╗");
		System.out.println("|              QUẢN LÝ NHÀ CUNG CÂP            |");
		System.out.println("|  1 . Thêm Nhà cung cấp                       |");
		System.out.println("|  2 . Sửa Thông tin Nhà cung cấp              |");
		System.out.println("|  3 . Xóa thông tin Nhà cung cấp              |");
		System.out.println("|  4 . Danh sách Nhà cung cấp                  |");
		System.out.println("|  5 . Tìm kiếm                                |");
		System.out.println("|  6 . Sắp xếp                                 |");
		System.out.println("|  7 . Quay lại                                |");
		System.out.println("╚==============================================╝");
		System.out.print("Nhập lựa chọn: ");
		int opt = this.Check1_7();
		switch (opt) {
		case 1:
			a.input_arrSUP();
			break;
		case 2:
			a.fix_arrSUP();
			break;
		case 3:
			a.delete_arrSUP();
			break;
		case 4:
			a.output_arrSUP();
			break;
		case 5:
			a.seach_arrSUP();
			break;
		case 6:
			a.sort_arrSUP();
			break;
		case 7:
			cont = false;
			break;
		}
	} while (cont);
	}


	public void sub_menu_hanghoa() throws IOException {
		arrHangHoa a = new arrHangHoa();
		a.readFromFile();
		boolean cont = true;
		do {
			System.out.println("╔==============================================╗");
			System.out.println("|              QUẢN LÝ HÀNG HOÁ                |");
			System.out.println("|  1 . Sửa Thông tin Hàng hoá                  |");
			System.out.println("|  2 . Xoá Thông tin Hàng hoá                  |");
			System.out.println("|  3 . Danh sách hàng hoá trả                  |");
			System.out.println("|  4 . Danh sách Hàng hoá loại                 |");
			System.out.println("|  5 . Danh sách Hàng hoá                      |");
			System.out.println("|  6 . Tìm kiếm                                |");
			System.out.println("|  7 . Quay lại                                |");
			System.out.println("╚==============================================╝");
			System.out.print("Nhap lua chon: ");
			int opt = this.Check1_7();
			switch (opt) {
			case 1:
				a.fix();
				break;
			case 2:
				a.delete();
				break;
			case 3:
				a.readFromFile_tra();
				a.xuatDS_tra();
				break;
			case 4:
				a.readFromFile_loai();
				a.xuatDS_loai();
				break;
			case 5:
				a.xuatMang();
				break;
			case 6:
				input.nextLine();
				System.out.print("Nhập nội dung bạn muốn tìm kiếm: ");
				a.search(input.nextLine());
				break;
			case 7:
				cont = false;
				break;
			}
		} while (cont);
	}

	public void sub_menu_cuahang() throws IOException {
		arrCUS a = new arrCUS();
		a.readFromFile_CUS();
		boolean cont = true;
		do {
		System.out.println("╔==============================================╗");
		System.out.println("|              QUẢN LÝ CỬA HÀNG                |");
		System.out.println("|  1 . Thêm Cửa hàng                           |");
		System.out.println("|  2 . Sửa Thông tin Cửa hàng                  |");
		System.out.println("|  3 . Xóa thông tin Cửa hàng                  |");
		System.out.println("|  4 . Danh sách Cửa hàng                      |");
		System.out.println("|  5 . Tìm kiếm                                |");
		System.out.println("|  6 . Sắp xếp                                 |");
		System.out.println("|  7 . Quay lại                                |");
		System.out.println("╚==============================================╝");
		System.out.print("Nhap lua chon: ");
		int opt = this.Check1_7();
		switch (opt) {
		case 1:
			a.input_arrCUS();
			break;
		case 2:
			a.fix_arrCUS();
			break;
		case 3:
			a.delete_arrCUS();
			break;
		case 4:
			a.output_arrCUS();
			break;
		case 5:
			a.readFromFile_CUS();
			a.seach_arrCUS();
			break;
		case 6:
			a.sort_arrCUS();
			break;
		case 7:
			cont = false;
			break;
		default :
			a.readFromFile_CUS();
			break;
		}
		}while (cont);

	}

	public void sub_menu_kiemkeNhap() throws IOException {
		arrKiemKeNhap a = new arrKiemKeNhap();
		a.readFromFile();
		boolean cont = true;
		do {
			System.out.println("╔==============================================╗");
			System.out.println("|              QUẢN LÝ KIỂM KÊ NHẬP            |");
			System.out.println("|  1 . Thêm phiếu kiểm nhập                    |");
			System.out.println("|  2 . Sửa Thông tin phiếu                     |");
			System.out.println("|  3 . Xóa phiếu                               |");
			System.out.println("|  4 . Danh sách phiếu                         |");
			System.out.println("|  5 . Tìm kiếm                                |");
			System.out.println("|  6 . Nhập hàng                               |");
			System.out.println("|  7 . Quay lại                                |");
			System.out.println("╚==============================================╝");
			System.out.print("Nhap lua chon: ");
			int opt = this.Check1_7();
			switch (opt) {
			case 1:
				a.input_n();;
				break;
			case 2:
				a.fix_1();
				break;
			case 3:
				a.delete_1();
				break;
			case 4:
				a.output_1();;
				break;
			case 5:
				a.search__1();
				break;
			case 6:
				a.readFromFile();
				a.readFromFile_HangHoa();
				a.readFromFile_case();
				a.readFromFileCTP();
				a.Execute();
				break;
			case 7:
				cont = false;
				break;
			}
		} while (cont);
	}

	public void sub_menu_kiemkeXuat() throws IOException {
		arrKiemKeXuat a = new arrKiemKeXuat();
		a.readFromFile();

		boolean cont = true;
		do {
			System.out.println("╔==============================================╗");
			System.out.println("|              QUẢN LÝ KIỂM KÊ XUẤT            |");
			System.out.println("|  1 . Thêm phiếu kiểm xuất                    |");
			System.out.println("|  2 . Sửa Thông tin phiếu                     |");
			System.out.println("|  3 . Xóa phiếu                               |");
			System.out.println("|  4 . Danh sách phiếu                         |");
			System.out.println("|  5 . Tìm kiếm                                |");
			System.out.println("|  6 . Xuất hàng                               |");
			System.out.println("|  7 . Quay lại                                |");
			System.out.println("╚==============================================╝");
			System.out.print("Nhap lua chon: ");
			int opt = this.Check1_7();
			switch (opt) {
			case 1:
				a.input_x();
				break;
			case 2:
				a.fix_2();
				break;
			case 3:
				a.delete_2();
				break;
			case 4:
				a.output_2();
				break;
			case 5:
				a.search__2();
				break;
			case 6:
				a.readFromFile();
				a.readFromFile_HangHoa();
				a.readFromFileCTP();
				a.readFromFile_case();
				a.Execute();
				break;
			case 7:
				cont = false;
				break;
			}
		} while (cont);
	}

	public void sub_menu_kiemke() throws IOException {
		boolean cont = true;
		do {
			System.out.println("╔==============================================╗");
			System.out.println("|              QUẢN LÝ KIỂM KÊ                 |");
			System.out.println("|  1 . Quản lý kiểm kê nhập                    |");
			System.out.println("|  2 . Quản lý kiểm kê xuất                    |");
			System.out.println("|  3 . Quay lại                                |");
			System.out.println("╚==============================================╝");
			System.out.print("Nhap lua chon: ");
			int opt = this.Check1_3();
			switch (opt) {
			case 1:
				sub_menu_kiemkeNhap();
				break;
			case 2:
				sub_menu_kiemkeXuat();
				break;
			case 3:
				cont = false;
				break;
			}
		} while (cont);
	}

	public void sub_menu_CTPhieuNhap() throws IOException {
		MangChiTietPhieuNhap a = new MangChiTietPhieuNhap();
		a.readFromFile();
		boolean cont = true;
		do {
			System.out.println("╔==============================================╗");
			System.out.println("|         QUẢN LÝ CHI TIẾT PHIẾU NHẬP          |");
			System.out.println("|  1 . Thêm Chi tiết phiếu nhập                |");
			System.out.println("|  2 . Sửa Chi tiết phiếu nhập                 |");
			System.out.println("|  3 . Xóa Chi tiết phiếu nhập                 |");
			System.out.println("|  4 . Danh sách Chi tiết phiếu nhập           |");
			System.out.println("|  5 . Tìm kiếm                                |");
			System.out.println("|  6 . Quay lại                                |");
			System.out.println("╚==============================================╝");
			System.out.print("Nhap lua chon: ");
			int opt = this.Check1_6();
			switch (opt) {
			case 1:
				a.nhapMang();
				break;
			case 2:
				a.fix();
				break;
			case 3:
				a.delete();
				break;
			case 4:
				a.xuatList();
				break;
			case 5:
				input.nextLine();
				System.out.print("Nhập nội dung bạn muốn tìm kiếm: ");
				a.search(input.nextLine());
				break;
			case 6:
				cont = false;
				break;
			}
		} while (cont);
	}

	public void sub_menu_CTPhieuXuat() throws IOException {
		MangChiTietPhieuXuat a = new MangChiTietPhieuXuat();
		a.readFromFile();
		boolean cont = true;
		do {
			System.out.println("╔==============================================╗");
			System.out.println("|         QUẢN LÝ CHI TIẾT PHIẾU XUẤT          |");
			System.out.println("|  1 . Thêm Chi tiết phiếu xuất                |");
			System.out.println("|  2 . Sửa Chi tiết phiếu xuất                 |");
			System.out.println("|  3 . Xóa Chi tiết phiếu xuất                 |");
			System.out.println("|  4 . Danh sách Chi tiết phiếu xuất           |");
			System.out.println("|  5 . Tìm kiếm                                |");
			System.out.println("|  6 . Quay lại                                |");
			System.out.println("╚==============================================╝");
			System.out.print("Nhap lua chon: ");
			int opt = this.Check1_6();
			switch (opt) {
			case 1:
				a.nhapMang();
				break;
			case 2:
				a.fix();
				break;
			case 3:
				a.delete();
				break;
			case 4:
				a.xuatList();
				break;
			case 5:
				input.nextLine();
				System.out.print("Nhập nội dung bạn muốn tìm kiếm: ");
				a.search(input.nextLine());
				break;
			case 6:
				cont = false;
				break;
			}
		} while (cont);
	}

	public void submenu_tonkho() throws IOException {
		TonKhoDisplay.readGiaVon();
		boolean cont = true;
		do {
			System.out.println("╔==============================================╗");
			System.out.println("|         XEM TỒN KHO                          |");
			System.out.println("|  1 . Nhập tiền vốn                           |");
			System.out.println("|  2 . Thống kê tồn kho                        |");
			System.out.println("|  3 . Thoát                                   |");
			System.out.println("╚==============================================╝");
			System.out.print("Nhap lua chon: ");
			int opt = this.Check1_3();
			switch (opt) {
			case 1:
				TonKhoDisplay.nhap();
				break;
			case 2:
				TonKhoDisplay.readFromFile_HangHoa();
				TonKhoDisplay.display();
				break;
			case 3:
				cont = false;
				break;
			}
		} while (cont);
	}

	public void sub_menu_kho() throws IOException {
		MangKho a = new MangKho();
		a.readFromFile();
		boolean cont = true;
		do {
			System.out.println("╔==============================================╗");
			System.out.println("|              QUẢN LÝ KHO                     |");
			System.out.println("|  1 . Thêm Vị trí sản phẩm                    |");
			System.out.println("|  2 . Sửa Vị trí sản phẩm                     |");
			System.out.println("|  3 . Xóa Vị trí sản phẩm                     |");
			System.out.println("|  4 . Tìm kiếm                                |");
			System.out.println("|  5 . Danh sách Tài khoản                     |");
			System.out.println("|  6 . Quay lại                                |");
			System.out.println("╚==============================================╝");
			System.out.print("Nhap lua chon: ");
			int opt = this.Check1_6();
			switch (opt) {
			case 1:
				a.nhapMang();
				break;
			case 2:
				a.fix();
				break;
			case 3:
				a.delete();
				break;
			case 4:
				a.seach();
				break;
			case 5:
				a.xuatMang();
				break;
			case 6:
				cont = false;
				break;
			}
		} while (cont);
	}

	public static void main(String[] args) throws IOException {
		Menu mn = new Menu();
		mn.login();
	}

}
