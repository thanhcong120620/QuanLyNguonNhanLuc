
public class Employee extends Staff implements ICalculator {
	//khai báo các thuộc tính riêng của employee
	private double hlamthem;
	
	//tạo các constructor
	public Employee() {}
		
	
	public Employee(String codenv, int agenv, int ngaynghiphep, String namenv, String bplamviec, String ngayvaolam,
					double hsluong, double hlamthem) {
		super(codenv, agenv, ngaynghiphep, namenv, bplamviec, ngayvaolam, hsluong);
		this.hlamthem = hlamthem;
	}

	//tạo các getter và setter
	public double getHlamthem() {return hlamthem;}
	public void setHlamthem(double hlamthem) {this.hlamthem = hlamthem;}

	
	//tạo phương thức hiển thị thông tin	
	public void displayInformation() {
		
		System.out.println("\n-------------------------------------");
		System.out.println("Ma so nhan vien: "+ this.getCodenv());
		System.out.println("Ten nhan vien: "+this.getNamenv());
		System.out.println("Tuoi: " + this.getAgenv()+" tuoi");
		System.out.println("Bo phan lam viec: "+this.getBplamviec());
		System.out.println("Ngay vao lam: "+this.getNgayvaolam());
		System.out.println("He so luong: "+this.getHsluong());
		System.out.println("So gio lam them: "+this.getHlamthem()+" (gio)");
		System.out.println("So ngay nghi phep: "+ this.getNgaynghiphep()+" (ngay)");
		System.out.println();	
	}		

	//tạo phương thức tính lương
	public double calculatesalary(){return (double)(this.getHsluong()*3000000+this.getHlamthem()*200000);}
	
	public void displayinfluong() {System.out.println("So gio lam them: "+this.getHlamthem());}

}
