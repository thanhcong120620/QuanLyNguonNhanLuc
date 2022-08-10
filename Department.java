import java.util.ArrayList;

public class Department {
	//khai báo các trường thuộc tính
	  private String bpcode; 
	  private String bpname; 
	  private int slnvhientai;	  
	  static ArrayList<Department> dptlist;

  
  //xây dựng các constructor
  public Department() {}
	  	  
  public Department(String bpcode,String bpname,int slnvhientai) {
	  this.bpcode = bpcode;this.bpname = bpname;this.slnvhientai = slnvhientai; }

  
  //xây dựng các getter và các setter
  public String getbpcode() {return bpcode; }
  public void setbpcode(String bpcode) {this.bpcode = bpcode; }
  public String getbpname() { return bpname; }
  public void setbpname(String bpname) {this.bpname = bpname; }
  public int getslnvhientai() {return slnvhientai; }
  public void setslnvhientai(int slnvhientai) {this.slnvhientai = slnvhientai;}
  
  //tạo hàm thêm 1 nhân viên nếu người nhập thêm một nhân viên trong file HumanResources
  public void addstaffdpt() {this.slnvhientai = slnvhientai+1;} 
  //tạo phương thức hiển thông tin
  public String toString() {
	  return "Ma bo phan: "+this.getbpcode()+". \nTen bo phan: "+
	  this.getbpname()+". \nSo luong nhan vien hien tai: "+this.getslnvhientai()+".\n-------------------"; }
  
  

}

  
 