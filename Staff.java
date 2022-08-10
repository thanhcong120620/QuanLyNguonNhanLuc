
public abstract class Staff {
	//khai báo các thuộc tính chung của abtract staff mà employee và manager sẽ sử dụng lại
 protected int agenv;
 protected int ngaynghiphep;	
 protected String codenv;
 protected String namenv;
 protected String bplamviec;
 protected String ngayvaolam;
 protected double hsluong;
 

//Tạo các constructor
 public Staff() {}

public Staff(String codenv, int agenv, int ngaynghiphep, String namenv, String bplamviec, String ngayvaolam,
		double hsluong) {
	this.codenv = codenv;
	this.agenv = agenv;
	this.ngaynghiphep = ngaynghiphep;
	this.namenv = namenv;
	this.bplamviec = bplamviec;
	this.ngayvaolam = ngayvaolam;
	this.hsluong = hsluong;
}

//tạo các getter và structor
public String getCodenv() {return codenv;}
public void setCodenv(String codenv) {this.codenv = codenv;}
public int getAgenv() {return agenv;}
public void setAgenv(int agenv) {this.agenv = agenv;}
public int getNgaynghiphep() {return ngaynghiphep;}
public void setNgaynghiphep(int ngaynghiphep) {this.ngaynghiphep = ngaynghiphep;}
public String getNamenv() {return namenv;}
public void setNamenv(String namenv) {this.namenv = namenv;}
public String getBplamviec() {return bplamviec;}
public void setBplamviec(String bplamviec) {this.bplamviec = bplamviec;}
public String getNgayvaolam() {return ngayvaolam;}
public void setNgayvaolam(String ngayvaolam) {this.ngayvaolam = ngayvaolam;}
public double getHsluong() {return hsluong;}
public void setHsluong(double hsluong) {this.hsluong = hsluong;}

//tạo phương thức hiển thị thông tin và được sử dụng lại bởi employee và manager
public abstract void displayInformation();


public abstract void displayinfluong();

}



	
