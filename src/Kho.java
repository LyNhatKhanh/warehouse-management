

import java.util.Scanner;

public class Kho implements CheckingFormat
{
	protected String maHangHoa;
    protected String viTri;
    
    Scanner inp=new Scanner(System.in);

    public Kho(){
    }
    public Kho(String maHangHoa, String viTri){
    	this.maHangHoa = maHangHoa;
    	this.viTri = viTri;
    }       
   
    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }

    public Kho(String viTri, int soluong) {
        this.viTri = viTri; 
    }
    
    public String getMaHangHoa() {
		return maHangHoa;
	}


	public void setMaHangHoa(String maHangHoa) {
		this.maHangHoa = maHangHoa;
	}
       
    @Override
    public String toString() {
        return this.maHangHoa + ";" + this.viTri;
    }


    public static int count = 1;

    public void xuat() {
        System.out.printf("%-4d %-15s %-15s\n", count, this.maHangHoa, this.viTri);
        count++;
    }
    public void nhap_PK()
    {
    	System.out.print("Nhập mã hàng hóa: ");
    	maHangHoa = this.maHangHoaChecking().trim();
        System.out.print("Nhập vị trí: ");
        viTri= viTriChecking().trim();       
    }
    public void nhap_vitri() {
    	System.out.print("Nhập vị trí: ");
        viTri= viTriChecking().trim(); 
    }
    
    public static void main(String[] args) {
        Kho k = new Kho();
        k.nhap_PK();
        k.xuat();
        k.toString();
    }
  
}
