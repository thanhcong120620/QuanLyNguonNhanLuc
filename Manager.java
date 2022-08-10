
public class Manager extends Staff implements ICalculator {
	//khai báo các thuộc tính riêng của Manager
	private String chucdanh;;	
	
	//tạo các constructor
	public Manager() {}		
	
	public Manager(String codenv, int agenv, int ngaynghiphep, String namenv, String bplamviec, String ngayvaolam,
					double hsluong, String chucdanh) {
		super(codenv, agenv, ngaynghiphep, namenv, bplamviec, ngayvaolam, hsluong);
		this.chucdanh = chucdanh;	
	}

	//tạo các getter và setter
	public String getChucdanh() {return chucdanh;}
	public void setChucdanh(String chucdanh) {this.chucdanh = chucdanh;}	

	
	//tạo phương thức hiển thị thông tin
	public void displayInformation() {
		
		System.out.println("\n-------------------------------------");
		System.out.println("Ma so quan ly: "+ this.getCodenv());
		System.out.println("Ten quan ly: "+this.getNamenv());
		System.out.println("Tuoi: " + this.getAgenv()+" tuoi");
		System.out.println("Bo phan lam viec: "+this.getBplamviec());
		System.out.println("Chuc danh cua quan ly la: "+this.getChucdanh());
		System.out.println("Ngay vao lam: "+this.getNgayvaolam());
		System.out.println("He so luong: "+this.getHsluong());
		System.out.println("So ngay nghi phep: "+ this.getNgaynghiphep()+" (ngay)");		
		System.out.println();	
	}
	// tạo phương thức tính lương của manager			
	public double calculatesalary() {
		double luongtn=0;
			if(this.getChucdanh().equals("Business Leader.")) {luongtn = 8000000;}
			else if(this.getChucdanh().equals("Project Leader.")) {luongtn = 5000000;}
			else if(this.getChucdanh().equals("Technical Leader.")) {luongtn = 6000000;}			
			return (double)(this.getHsluong()*5000000+luongtn);			
	}
		
	public void displayinfluong() {System.out.println("Chuc danh: "+this.getChucdanh());}
		
}
