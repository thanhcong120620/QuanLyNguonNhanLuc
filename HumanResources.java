
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
  
  public class HumanResources {
	  
//Khai báo các biến chung của class HumanResources-----------------------------------
	  

	  public static ArrayList<Staff> stafflist = new ArrayList<Staff>();
	  public static ArrayList<Department> dptlist = new ArrayList<Department>();
	  
	  //tạo các đối tượng phòng ban
	  public static Department mktdpt = new Department("MKT","Phong.Marketing",0);
	  public static Department findpt = new Department("FIN","Phong.Tai chinh",0);
	  public static Department omdpt = new Department("OM","Ban.Giam doc",0);
	  public static Department hrdpt = new Department("HR","Phong.Hanh chinh Nhan su",0);
	  public static Department itdpt = new Department("IT","Phong.Cong nghe Thong tin",0);
	  
	  public static Scanner input = new Scanner(System.in);
	  static String optnhapthem; //biến này sử dụng trong các vòng lặp để thực hiện lại từng chức năng
	  
	  
	  
	  					//ĐIỀU KHIỂN CHƯƠNG TRÌNH   
	  
	  public static void main(String[]args) { 
			  
//Hiển thị danh sách các chức năng-------------------------------------
	int optmenu;
	addinfdpt();/*Chạy chức năng thêm phòng ban vào ArrayList phòng ban*/
	//sử dụng vòng lặp để thực hiện lại chức năng của chương trình
	do {	
	System.out.println("\n---HUMAN RESOURCE MANAGEMENT PROGRAMMING---");
	System.out.println("\nBang dieu khien:");
	System.out.println("(Neu day la lan dau tien ban su dung chuong trinh, vui long hay chon so 4 de nhap thong tin)\n");
	System.out.println("(0) Ket thuc chuong trinh.");
	System.out.println("(1) Xem thong tin tat ca nhan vien trong cong ty.");
	System.out.println("(2) Xem thong tin cac phong ban trong cong ty.");
	System.out.println("(3) Xem thong tin cac nhan vien theo tung phong ban.");
	System.out.println("(4) Nhap them thong tin nhan vien/quan ly moi.");
	System.out.println("(5) Tim kien thong tin nhan vien tu ma nhan vien/ten.");
	System.out.println("(6) Xem bang luong cua nhan vien toan cong ty.");
	System.out.println("(7) Xem bang luong cua nhan vien tu thap den cao/cao den thap.");
	System.out.println("--> Ban hay chon 1 chuc nang(0-7): ");
	
	//thực hiện chạy các hàm tương ứng khi người dùng chọn chức năng
	optmenu = input.nextInt();
	if(optmenu==1) {showstafflist();}
	if(optmenu==2) {showdepartmentlist();}	  
	if(optmenu==3) {showstaffindpt();}
	if(optmenu==4) {addstaff();}
	if(optmenu==5) {timkiem();}
	if(optmenu==6) {luongall();}
	if(optmenu==7) {sortluong();}
	}while(optmenu!=0);	  
	

	System.out.println("Ban da ket thuc chuong trinh, hen gap lai");
	  	  
}  
	  
	  
//------------------------------------------------------------------------
	                      
	  					//THIẾT LẬP CÁC CHỨC NĂNG
	  
	  
//Chức năng thêm thông tin phòng ban--------------------------------------		    
	  public static void addinfdpt() {
		  //thêm các đối tượng từng phòng ban vào danh sách phòng ban
	  dptlist.add(mktdpt);dptlist.add(findpt);dptlist.add(omdpt);dptlist.add(hrdpt);dptlist.add(itdpt);}
	  
	  
//Chức năng 1: Hiển thị thông tin danh sách tất cả nhân viên--------------
	  public static void showstafflist() {
		  System.out.println("______________________________");
		  System.out.println("Danh sach cac nhan vien va quan ly trong cong ty:");
		  // dùng vòng lặp để lấy thông tin các phần tử trong danh sách nhân viên
		  for(int i=0;i<stafflist.size();i++) {stafflist.get(i).displayInformation();}
		  System.out.println("-------------------------------------\n");
	  }
	  
	  
//Chức năng 2: Hiển thị thông tin danh sách các phòng ban-----------------
	  public static void showdepartmentlist() {
		  System.out.println("______________________________");
		  System.out.println("Danh sach cac phong ban trong cong ty:");
		  //sử dụng vòng lặp duyệt qua danh sách phòng ban để lấy thông tin từng phòng ban
		  for(int i=0;i<dptlist.size();i++) {
			  //hiển thị thông tin từng phòng ban trong danh sách các phòng ban
			  System.out.println(dptlist.get(i).toString());
			  }
		  System.out.println("-------------------------------------\n");
	  }
	  
	  
//Chức năng 3: Hiển thị thông tin nhân viên theo phòng ban----------------
	  public static void showstaffindpt() {
		  do {
		  System.out.println("______________________________");
		  System.out.println("Danh sach nhan vien & quan ly cua tung phong ban:");
		  System.out.println("Marketing\nFinance\nOperations\nHR\nIT");
		  //nguoi dung phai nhap chinh xac ten cac phong ban de hien thi
		  System.out.print("Nhap ten phong ban muon xem?");
		  String optsid = input.next();
		  for(int i=0; i<stafflist.size();i++) {
			  //điều kiện để lấy thông tin mà người dùng đã nhập
			  if(stafflist.get(i).getBplamviec().equals(optsid)) {
				  stafflist.get(i).displayInformation();
			  }
		  }
		  // sử dụng vòng lặp nếu người nhập muốn thực hiện lại chức năng
		  System.out.print("Ban co muon xem lai khong: ");
		  input = new Scanner(System.in);
			optnhapthem = input.nextLine();

			}while(optnhapthem.equalsIgnoreCase("Có")||optnhapthem.equalsIgnoreCase("Co")||
					optnhapthem.equalsIgnoreCase("C")||optnhapthem.equalsIgnoreCase("yes")||
					optnhapthem.equalsIgnoreCase("y"));
	  }
	  
	  
//Chức năng 4: Thêm thông tin nhân viên----------------------------------- 
		 public static void addstaff() {
			 do {
			 System.out.println("______________________________");
			 System.out.println("Ban muon them nhan vien hay quan ly (1-2)?\n(1) Nhan vien.\n(2) Quan ly.");
			 int optnoq = input.nextInt();
			 //chạy từng chức năng thêm nhân viên hoặc thêm quản lý từ hành động muốn xem của người dùng
			 if(optnoq==1) {addnhanvien();}
			 if(optnoq==2) {addquanly();}
			 //thông báo người dùng đã nhập thành công và yêu cầu có muốn thực hiện lại chức năng không
			 System.out.println("Ban da nhap thanh cong");
			 System.out.println("Ban co muon nhap them khong: ");
				input = new Scanner(System.in);
				optnhapthem = input.nextLine();

				}while(optnhapthem.equalsIgnoreCase("Có")||optnhapthem.equalsIgnoreCase("Co")||
						optnhapthem.equalsIgnoreCase("C")||optnhapthem.equalsIgnoreCase("yes")||
						optnhapthem.equalsIgnoreCase("y"));
		 }
		 //Thêm nhân viên
		 public static void addnhanvien() {
			 
			 //dòng 148 đến 181 yêu cầu người dùng nhập thông tin đầu vào
			 	input = new Scanner(System.in);
				System.out.println("Nhap ma so nhan vien: ");
				String msnv = input.nextLine();
				input = new Scanner(System.in);
				System.out.println("Nhap ten nhan vien: ");
				input = new Scanner(System.in);
				String tennv = input.nextLine();
				System.out.println("Nhap tuoi nhan vien: ");
				input = new Scanner(System.in);
				int tuoinv = input.nextInt();
				
				System.out.println("Chon bo phan lam viec cua nhan vien(1-5): ");
				System.out.println("(1) Marketing.\n(2) Finance.\n(3) Operations management.\n(4) Human Resource.\n(5) Information Technology. ");
				input = new Scanner(System.in);
				String bplamviecnv = "";
				int opte1 = input.nextInt();
				//tại đây nếu người chọn phòng ban nào thì biến bplamviec được gán tên bộ phân ấy 
				//và thực hiện phương thức thêm số lượng +1 tại phòng ban ấy
				if(opte1==1) {slmkt();bplamviecnv = "Marketing";}							
				if(opte1==2) {slfin();bplamviecnv = "Finance";}								
				if(opte1==3) {slom();bplamviecnv = "Operations";}									
				if(opte1==4) {slhr();bplamviecnv = "HR";}				
				if(opte1==5) {slit();bplamviecnv = "IT";}									
				
				System.out.println("Nhap ngay vao lam cua nhan vien: ");
				input = new Scanner(System.in);
				String ngayvaolamnv = input.nextLine();
				System.out.println("Nhap he so luong cua nhan vien: ");
				input = new Scanner(System.in);
				double hsluongnv = input.nextDouble();
				System.out.println("Nhap so ngay nghi phep: ");
				input = new Scanner(System.in);
				int ngaynghiphepnv = input.nextInt();
				System.out.println("Nhap so gio lam them cua nhan vien: ");
				input = new Scanner(System.in);
				double hlamthemnv = input.nextDouble();
				
				//thêm thông tin người dùng đã nhập vào danh sách nhân viên công ty				
				Employee El1 = new Employee(msnv,tuoinv,ngaynghiphepnv,tennv,bplamviecnv,ngayvaolamnv,
											hsluongnv,hlamthemnv);
				HumanResources.stafflist.add(El1);
		  }
			
		 //Thêm quản lý
		 public static void addquanly() {
			//dòng 195 đến 238 yêu cầu người dùng nhập thông tin đầu vào
				System.out.println("Nhap ma so quan ly: ");
				input = new Scanner(System.in);
				String msql = input.nextLine();
				System.out.println("Nhap ten quan ly: ");
				input = new Scanner(System.in);
				String tenql = input.nextLine();
				System.out.println("Nhap tuoi quan ly: ");
				input = new Scanner(System.in);
				int tuoiql = input.nextInt();
				
				System.out.println("Chon bo phan lam viec cua quan ly(1-5): ");
				System.out.println("(1) Marketing.\n(2) Finance.\n(3) Operations management.\n(4) Human Resource.\n(5) Information Technology. ");
				input = new Scanner(System.in);
				String bplamviecql = "";
				//tại đây nếu người chọn phòng ban nào thì biến bplamviec được gán tên bộ phân ấy 
				//và thực hiện phương thức thêm số lượng +1 tại phòng ban ấy
				int optm1 = input.nextInt();
				if(optm1==1) {slmkt();bplamviecql = "Marketing";}							
				if(optm1==2) {slfin();bplamviecql = "Finance";}								
				if(optm1==3) {slom();bplamviecql = "Operations";}									
				if(optm1==4) {slhr();bplamviecql = "HR";}				
				if(optm1==5) {slit();bplamviecql = "IT";}
				
				System.out.println("Nhap ngay vao lam cua quan ly: ");
				input = new Scanner(System.in);
				String ngayvaolamql = input.nextLine();
				System.out.println("Nhap he so luong cua quan ly: ");
				input = new Scanner(System.in);
				double hsluongql = input.nextDouble();
				System.out.println("Nhap so ngay nghi phep: ");
				input = new Scanner(System.in);
				int ngaynghiphepql = input.nextInt();
				
				System.out.println("Chon huc danh cua quan ly(1-3): \n(1) Business Leader.\n(2) Project Leader.\n(3) Technical Leader.");
				input = new Scanner(System.in);
				int optcd = input.nextInt();
				String chucdanhql = "";
				if(optcd==1) {
				chucdanhql = "Business Leader.";
				}
				if(optcd==2) {
				chucdanhql = "Project Leader.";
				}				
				if(optcd==3) {
				chucdanhql = "Technical Leader.";
				}				
				//thêm thông tin người dùng đã nhập vào danh sách nhân viên công ty		
				Manager Ml1 = new Manager(msql,tuoiql,ngaynghiphepql,tenql,bplamviecql,ngayvaolamql,
										  hsluongql,chucdanhql);
				HumanResources.stafflist.add(Ml1);
	  }  
  
		 //Tính số lượng nhân viên hiện tại của mỗi phòng ban
		 public static void slmkt(){mktdpt.addstaffdpt();}
		 public static void slfin(){findpt.addstaffdpt();}
		 public static void slom(){omdpt.addstaffdpt();}
		 public static void slhr(){hrdpt.addstaffdpt();}
		 public static void slit(){itdpt.addstaffdpt();}
  
  
//Chức năng 5: Tìm kiếm nhân viên theo tên và code------------------------
		 public static void timkiem() {
			 //gán các biến người dùng nhập vào và biến người dùng có muốn nhập lại hay không
			 String tk;
			 String optnhaplai;
			 do {
			 System.out.println("______________________________");
			 System.out.println("Nhap ten hoac ma nhan vien de tim kiem: ");
			 input = new Scanner(System.in);
			 boolean tt= true;
			 tk = input.nextLine();
			 //thực hiện vòng lặp kiếm tra thông tin người nhập
			 for(int i=0;i<stafflist.size();i++) {
				 //nếu thông tin người nhập trùng khớp thì hiển thị thông tin
				 if(stafflist.get(i).getNamenv().equalsIgnoreCase(tk)||stafflist.get(i).getCodenv().equalsIgnoreCase(tk)) {
				 stafflist.get(i).displayInformation();
				 tt = false;
				 }				 
			 }
			 //neu ket qua khong dung se thong bao
			 if(tt) {System.out.println("NHAN VIEN TIM KIEM KHONG TON TAI !\n");}
			 
			 //sử dụng vòng lặp cho người nhập có muốn tiếp tục tìm kiếm hay không
			 System.out.println("Ban co muon nhap lai khong: ");
				input = new Scanner(System.in);
				optnhaplai = input.nextLine();

				}while(optnhaplai.equalsIgnoreCase("Có")||optnhaplai.equalsIgnoreCase("Co")||
						optnhaplai.equalsIgnoreCase("C")||optnhaplai.equalsIgnoreCase("yes")||
						optnhaplai.equalsIgnoreCase("y"));
		 }
		 
		
		
//Chức năng 6: Xem bảng lương của toàn bộ nhân viên-----------------------
		 public static void luongall() {
			 //hiển thị công thức tính lương
			System.out.println("______________________________");
			System.out.println("Bang luong nhan vien cong ty: ");
			System.out.println("-->Luong manager = Luong trach nhiem + 5.000.000 x he so luong");
			System.out.println("Luong trach nhiem: Business Leader(8.000.000), Project Leader(5.000.000), Technical Leader(6.000.000)");
			System.out.println("-->Luong nhan vien = he so luong x 3.000.000 + gio lam them x 200.000");
			//hiển thị thông tin liên quan đến lương của 1 nhân viên 
			for(int i=0;i<stafflist.size();i++) {
				System.out.println("\n------------------------");
				System.out.println("Staff: "+(i+1));
				System.out.println("Ten: "+stafflist.get(i).getNamenv());
				System.out.println("He so luong: "+stafflist.get(i).getHsluong());
				
				/* Nếu luong employee lỗi sẽ chuyển sang luong manager*/
				try {
					//hiển thị thông tin liên đến lương
					stafflist.get(i).displayinfluong();
					//hiển thị số lương của nhân viên thứ i trong vòng lặp
					System.out.println("Tong luong nhan vien "+stafflist.get(i).getNamenv()+": "+((Employee)stafflist.get(i)).calculatesalary());					
				}catch(Exception e) {
					
					System.out.println("Tong luong quan ly "+stafflist.get(i).getNamenv()+": "+((Manager)stafflist.get(i)).calculatesalary());
				}
			}
		 }
		
		
//Chức năng 7: Xem bảng lương theo hướng tăng dần/giảm dần----------------
		 public static void sortluong() {
			 //sủ dụng vòng lặp người dùng muốn xem lương từ cao đến thấp hay từ thấp đến cao
			 do {
			 System.out.println("Ban muon xem Bang luong nhu the nao(1-2)?");
			 System.out.println("(1) Luong tu cao den thap.\n(2) Luong tu thap den cao");;
			 
			 input = new Scanner(System.in);
			 int optsort = input.nextInt();
			 		 
			 
			 //Sap xep tang
			 if(optsort==2) {
				 //thuật toán nổi bọt sắp xếp lương
				 double temp;
				 double tempt;
				 double temps;
				 for(int i =0; i<stafflist.size()-1;i++) {
					 for(int j=i+1; j<stafflist.size();j++) {			 
//						 if( (try{((Employee)stafflist.get(i)).calculatesalary();}catch(Exception e) {((Manager)stafflist.get(i)).calculatesalary();})>(try{((Employee)stafflist.get(j)).calculatesalary();}catch(Exception e) {((Manager)stafflist.get(j)).calculatesalary();}) ){}  						 							 						 						 
						//nếu phần tử thứ i lỗi không phải employee thì chạy mã lấy lương của manager 
						 try {
							 if(((Employee)stafflist.get(i)).calculatesalary()>
							 	((Employee)stafflist.get(j)).calculatesalary()) {
								 tempt = ((Employee)stafflist.get(i)).calculatesalary();
								 temps = ((Employee)stafflist.get(j)).calculatesalary();
								 temp = tempt;
								 tempt = temps;
								 temps = temp;
							 }
							 //khi i không phải employee thì phát sinh lỗi và chạy đoạn mã dưới đây
						 }catch(Exception e) {
							 if(((Manager)stafflist.get(i)).calculatesalary()>
							 	((Manager)stafflist.get(j)).calculatesalary()) {
								 tempt = ((Manager)stafflist.get(i)).calculatesalary();
								 temps = ((Manager)stafflist.get(j)).calculatesalary();
								 temp = tempt;
								 tempt = temps;
								 temps = temp;
							 }
						 
						 }
					 }}	
				 
				 // in bảng lương
				 luongall();
				 }
				 
		 
			 //Sắp xếp giảm
			 if(optsort==1) {
				//thuật toán nổi bọt sắp xếp lương
				 double temp;
				 double tempt;
				 double temps;
				 for(int i =0; i<stafflist.size()-1;i++) {
					 for(int j=i+1; j<stafflist.size();j++) {
						//nếu phần tử thứ i lỗi không phải employee thì chạy mã lấy lương của manager 
						 try {
							 if(((Employee)stafflist.get(i)).calculatesalary()<
							 	((Employee)stafflist.get(j)).calculatesalary()) {
								 tempt = ((Employee)stafflist.get(i)).calculatesalary();
								 temps = ((Employee)stafflist.get(j)).calculatesalary();
								 temp = tempt;
								 tempt = temps;
								 temps = temp;
							 }
							//khi i không phải employee thì phát sinh lỗi và chạy đoạn mã dưới đây
						 }catch(Exception e) {
							 if(((Manager)stafflist.get(i)).calculatesalary()<
							 	((Manager)stafflist.get(j)).calculatesalary()) {
								 tempt = ((Manager)stafflist.get(i)).calculatesalary();
								 temps = ((Manager)stafflist.get(j)).calculatesalary();
								 temp = tempt;
								 tempt = temps;
								 temps = temp;
							 }
						 }
					 }}	
				 
				 // in bảng lương
				 luongall();
			 }
			 
			 //tạo vòng lặp cho chức năng 7 nếu người xem muốn thực hiện lại
			 System.out.println("Ban co muon xem lai khong: ");
				input = new Scanner(System.in);
				optnhapthem = input.nextLine();

				}while(optnhapthem.equalsIgnoreCase("Có")||optnhapthem.equalsIgnoreCase("Co")||
						optnhapthem.equalsIgnoreCase("C")||optnhapthem.equalsIgnoreCase("yes")||
						optnhapthem.equalsIgnoreCase("y"));
		
		 }
			
		 
		 
  
  
 } 
 