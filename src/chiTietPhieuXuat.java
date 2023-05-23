
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class chiTietPhieuXuat extends HangHoa implements CheckingFormat {

    private String maPhieuXuat;
    private List<HangHoa> list_HH = new ArrayList<>();
    Scanner inp = new Scanner(System.in);

    public chiTietPhieuXuat() {
        super();
    }

    public chiTietPhieuXuat(String maSanPham, String tenSanPham, long donGia, int soLuong, String donVi, NgayThang ngaySanXuat, NgayThang hanSuDung, String maPhieuXuat) {
        super(maSanPham, tenSanPham, donGia, soLuong, donVi, ngaySanXuat, hanSuDung);
        this.maPhieuXuat = maPhieuXuat;

    }

    public String getMaPhieuXuat() {
        return maPhieuXuat;
    }

    public void setMaPhieuXuat(String maPhieuXuat) {
        this.maPhieuXuat = maPhieuXuat;
    }

    //method
    public void nhapMaPX() {
        System.out.print("Nhập mã phiếu xuất: ");
        maPhieuXuat = IDPXchecking().trim();
    }

    public void nhapMaSP() {
        System.out.print("Nhập mã hàng hóa: ");
        String inp = maHangHoaChecking().trim();
        boolean off = true;
        boolean flag = false;
        try {
            readFromFile_HH();
        } catch (IOException ex) {
            Logger.getLogger(chiTietPhieuXuat.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (off == true) {
            for (int j = 0; j < list_HH.size(); j++) {
                if (inp.equalsIgnoreCase(list_HH.get(j).getMaSanPham())) {
                    super.maSanPham = inp;
                    flag = true;
                }
            }
            if (flag == false) {
                System.out.println("Ma hang hoa khong ton tai, vui long nhap ma nhan vien khac !!!!!");
                System.out.print("Nhập mã hàng hóa: ");
                inp = maHangHoaChecking().trim();
                flag = true;
            } else if (flag == true) 
                off = false;
        }
    }

    public void readFromFile_HH() throws IOException {
        try {
            FileReader fr = new FileReader("../HangHoa.txt");
            try {
                BufferedReader br = new BufferedReader(fr);
                String line = "";
                while (true) {
                    line = br.readLine();
                    if (line == null) {
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
                    for(HangHoa i : list_HH) {
                    	if(i.getMaSanPham().equalsIgnoreCase(create.getMaSanPham())) {
                    		flag = false;
                    		local = list_HH.indexOf(i);
                    		break;
                    	}
                    }
                    if(flag == true) {
                    	list_HH.add(create);
                    } 
                    else {
                    	list_HH.set(local, create);
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

    public int CheckSoLuongHH() throws IOException {
        int input;
        readFromFile_HH();
        while (true) {
            input = soLuongChecking();
            for (int i = 0; i < list_HH.size(); i++) {
                if (super.maSanPham.equalsIgnoreCase(list_HH.get(i).getMaSanPham())) {
                    if (input <= list_HH.get(i).getSoluong()) {
                        return input;
                    } else {
                        System.out.println("Số lượng lớn hơn số lượng trong kho!!!");
                    }
                } 
            }
            System.out.print("Nhập lại số lượng: ");
        }
    }
    public String fillTen() throws IOException {
        String tsp;
        readFromFile_HH();
        while (true) {
            for (int i = 0; i < list_HH.size(); i++) {
                if (super.getMaSanPham().equalsIgnoreCase(list_HH.get(i).getMaSanPham())) {
                    tsp = list_HH.get(i).getTenSanPham();
                    System.out.println(tsp);
                    return tsp;
                } 
            }
        }
    }
    public String fillDVT() throws IOException {
        String dvt;
        readFromFile_HH();
        while (true) {
            for (int i = 0; i < list_HH.size(); i++) {
                if (super.getMaSanPham().equalsIgnoreCase(list_HH.get(i).getMaSanPham())) {
                    dvt = list_HH.get(i).getDonvitinh();
                    System.out.println(dvt);
                    return dvt;
                } 
            }
        }
    }
    public NgayThang fillNSX() throws IOException {
    	
        readFromFile_HH();
        super.nsx = new NgayThang();
        while (true) {
            for (int i = 0; i < list_HH.size(); i++) {
                if (super.getMaSanPham().equalsIgnoreCase(list_HH.get(i).getMaSanPham())) {
                    super.nsx = list_HH.get(i).getNsx();
                    System.out.println(nsx.toString());
                    return this.nsx;
                } 
            }
        }
    }
    public NgayThang fillHSD() throws IOException {
    	
        readFromFile_HH();
        super.hsd = new NgayThang();
        while (true) {
            for (int i = 0; i < list_HH.size(); i++) {
                if (super.getMaSanPham().equalsIgnoreCase(list_HH.get(i).getMaSanPham())) {
                    super.hsd = list_HH.get(i).getHsd();
                    System.out.println(nsx.toString());
                    return super.hsd;
                } 
            }
        }
    }
    public void nhap() {
        try {
            System.out.print("Tên hàng hóa: ");
            super.tenSanPham = fillTen();
            System.out.print("Nhập số lượng: ");
            super.soluong = CheckSoLuongHH();
            System.out.print("Nhập đơn giá hàng hóa: ");
            super.dongia = giaChecking();
            System.out.print("Đơn vị tính: ");
            super.donvitinh = fillDVT();
            System.out.print("Nhập ngày sản xuất: ");
            nsx = this.fillNSX();
            
            System.out.print("Nhập ngày hạn sử dụng: ");
            hsd = this.fillHSD();
            
        } catch (IOException ex) {
            Logger.getLogger(chiTietPhieuXuat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static int count = 1;

    public void xuat() {
        System.out.printf("%-4d %-15s %-15s %-25s %-10d %-15s %-15s %-15s %-15s\n", count, this.maPhieuXuat, super.maSanPham, super.tenSanPham, super.soluong, super.dongia, super.donvitinh, nsx, hsd);
        count++;
    }

    @Override
    public String toString() {
        return maPhieuXuat + ";" + maSanPham + ";" + tenSanPham + ";" + dongia + ";" + soluong + ";" + donvitinh + ";" + nsx + ";" + hsd;
    }
    
    public static void main(String[] args) {
        chiTietPhieuXuat px = new chiTietPhieuXuat();
        px.nhapMaPX();
        px.nhapMaSP();
        px.nhap();
        px.xuat();
    }
}
