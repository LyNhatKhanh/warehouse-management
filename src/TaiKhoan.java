import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TaiKhoan implements CheckingFormat{
    private String maNhanVien;
    private String tenTaiKhoan;
    private String matKhau;
    private NgayThang ngayTaoTK;
    private String trangThaiTK;
    private String Permission;
    Scanner sc = new Scanner(System.in);
    public TaiKhoan() {

    }

    public TaiKhoan(String maNhanVien, String tenTaiKhoan, String matKhau, NgayThang ngayTaoTK, String trangThaiTK, String Permission) {
        this.maNhanVien = maNhanVien;
        this.tenTaiKhoan = tenTaiKhoan;
        this.matKhau = matKhau;
        this.ngayTaoTK = ngayTaoTK;
        this.trangThaiTK = trangThaiTK;
        this.Permission = Permission;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getTenTaiKhoan() {
        return tenTaiKhoan;
    }

    public void setTenTaiKhoan(String tenTaiKhoan) {
        this.tenTaiKhoan = tenTaiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public NgayThang getNgayTaoTK() {
        return ngayTaoTK;
    }

    public void setNgayTaoTK(NgayThang ngayTaoTK) {
        this.ngayTaoTK = ngayTaoTK;
    }

    public String gettrangThaiTK() {
        return trangThaiTK;
    }

    public void settrangThaiTK(String trangThaiTK) {
        this.trangThaiTK = trangThaiTK;
    }
    
    public String getPermission() {
		return Permission;
	}

	public void setPermission(String permission) {
		Permission = permission;
	}



    public NgayThang today() {
        NgayThang hn = new NgayThang();
        String now = java.time.LocalDate.now().toString();
        ArrayList<String> ngay = new ArrayList<String>();
        StringTokenizer st = new StringTokenizer(now, "-");
        while (st.hasMoreTokens()) {
            ngay.add(st.nextToken());
        }
        hn.setNgay(Integer.parseInt(ngay.get(2)));
        hn.setThang(Integer.parseInt(ngay.get(1)));
        hn.setNam(Integer.parseInt(ngay.get(0)));
        this.ngayTaoTK = hn;
        return ngayTaoTK;
    }

    public String trangThai() {
        System.out.println("1. Active");
        System.out.println("2. Lock");
        System.out.print("Nhap (1 or 2): ");
        int status;
        do {
            status = sc.nextInt();
            if (status != 1 && status != 2) {
                System.out.println("Không hợp lệ! Nhập lại!");
            }
        } while (status != 1 && status != 2);
        trangThaiTK = "";
        switch (status) {
            case 1:
                trangThaiTK = "Active";
                break;
            case 2:
                trangThaiTK = "Lock";
                break;
        }
        System.out.println("Trang thai tai khoan: "+trangThaiTK);
        return trangThaiTK;
    }

    public void nhapMaNV() {
        System.out.print("Nhap ma nhan vien: ");
        this.maNhanVien = IDNVchecking();
    }
    
    public void nhapTenTK() {
        System.out.print("Ten tai khoan: ");
        this.tenTaiKhoan = IDTKchecking();
    }

    public void nhap() {
        System.out.print("Mat khau: ");
        setMatKhau(sc.nextLine());
        System.out.print("Ngay tao tai khoan: ");
        // today();
        System.out.println(today());
        System.out.println("Trang thai tai khoan: ");
        settrangThaiTK(trangThai());
        System.out.println("Nhap quyen truy cap cua tai khoan: ");
        this.Permission = this.checkPermission();
    }

    public static int  count = 1;

	public void xuat() {
		System.out.printf("%-5d %-15s %-25s %-25s %-20s %-15s %-15s\n", count, this.maNhanVien, this.tenTaiKhoan, this.matKhau, this.ngayTaoTK.toString(), this.trangThaiTK, this.Permission);
		count++;
	}

	public String toString() {
		return this.maNhanVien + ";" + this.tenTaiKhoan + ";" + this.matKhau + ";" + this.ngayTaoTK.toString() + ";" + this.trangThaiTK + ";" + this.Permission;
	}

}
