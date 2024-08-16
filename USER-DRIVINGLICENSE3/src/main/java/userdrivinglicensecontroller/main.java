package userdrivinglicensecontroller;

import java.sql.Date;
import java.util.Random;
import java.util.Scanner;

import userdrivinglicense3.dto.DrivingLicense;
import userdrivinglicense3.dao.DrivingLicenseDao;
import userdrivinglicense3.dao.UserDao;
import userdrivinglicense3.dto.User;

public class main {
	static Scanner sc = new Scanner(System.in);

	static UserDao ud = new UserDao();
	static User u = new User();
	static DrivingLicenseDao dld = new DrivingLicenseDao();
	static DrivingLicense dl = new DrivingLicense();
	public static void main(String[] args) {
		boolean choice = true;
		do {
			System.out.println("Enter your choice \n 1.Register \n 2.Login \n 3.Exit ");
			int value = sc.nextInt();
			if(value ==1) {
				boolean registerChoice = true;
				do {
					System.out.println("Enter your choice \n 1.UserRegister \n 2.DrivingLicenseRegister \n 3.Exit ");
					int registerValue = sc.nextInt();
					if(registerValue==1) {
						userRegister();
					}else if(registerValue==2) {
						drivingLicenseRegister();
					}else if(registerValue==3) {
						//exit();
						registerChoice=false;
					}else {
						System.out.println("wrong choice you make place choice again.......");
					}
					
				}while(registerChoice);
			}else if(value==2) {
				boolean loginChoice = true;
				do {
					System.out.println("Enter your choice \n 1.User \n 2.DrivingLicense\n 3.Exit ");
					int loginValue = sc.nextInt();
					if(loginValue==1) {
						userLogin();
						boolean loginUserChoice = true;
						do {
							System.out.println("Enter your choice \n 1.Profile \n 2.Update \n 3.Delete \n 4.Exit ");
							int loginUserValue = sc.nextInt();
							if(loginUserValue==1) {
								userProfile();
							}else if(loginUserValue==2) {
								userUpdate();
							}else if(loginUserValue==3) {
							    userDelete();
							}else if(loginUserValue==4) {
								//exit();
								loginUserChoice=false;
							}else {
								System.out.println("wrong choice you make place choice again.......");
							}
						}while(loginUserChoice);
						
					}else if(loginValue==2) {
						boolean drivingLicenseLoginValue=true;
						do {
							drivingLicenseLogin();
							System.out.println("Enter your choice \n 1.Save \n 2.Update \n 3.Delete \n 4.Profile \n 5.Exit ");
							int drivingLicenseLoginChoice = sc.nextInt();
							if(drivingLicenseLoginChoice==1) {
								drivingLicenseRegister();
							}else if(drivingLicenseLoginChoice==2) {
								drivingLicenseUpdate();
							}else if(drivingLicenseLoginChoice==3) {
								drivingLicenseDelete();
							}else if(drivingLicenseLoginChoice==4) {
								drivingLicenseProfile();
							}else if(drivingLicenseLoginChoice==5) {
								//exit();
								drivingLicenseLoginValue=false;
							}else {
								System.out.println("wrong choice you make place choice again.......");
							}
						}while(drivingLicenseLoginValue);
					}else if(loginValue==3) {
						loginChoice=false;
					}else {
						System.out.println("wrong choice you make place choice again.......");
					}
				}while(loginChoice);
				
			}else if(value==3) {
				choice=false;
			}else {
				System.out.println("wrong choice you make place choice again.......");
			}
		}while(choice);
		System.out.println("....Thank you....");
	}

	

	private static void userRegister() {
		System.out.println("Enter your name:");
		String name = sc.next();
		System.out.println("Enter your email:");
		String email = sc.next();
		System.out.println("Enter your password:");
		String pwd = sc.next();
		System.out.println("Enter your gender:");
		String gender = sc.next();
		System.out.println("Enter your phonenumber:");
		Long phno = sc.nextLong();
		User u = new User(name,email,pwd,gender,phno);
		ud.register(u);
		System.out.println(u.getName() + " is registration successful");
	}
	
	private static void drivingLicenseRegister() {
		User u = new User();
		int random = new Random().nextInt(45667);
		int dlNum = random;
		System.out.println("Enter your user id:");
		int id = sc.nextInt();
		System.out.println("Enter your name:");
		String name = sc.next();
		System.out.println("Enter your fatherName:");
		String fatherName = sc.next();
		System.out.println("Enter your email:");
		String email = sc.next();
		System.out.println("Enter your DOB(YYYY-MON-DAY");
		Date dob = Date.valueOf(sc.next());
		DrivingLicense dl = new DrivingLicense(dlNum,id,name,fatherName,email,dob);
		dld.register(dl, id);
		System.out.println(dl.getName() + " is registration successful" + "your license id is: " + dl.getDlNum());
	}
	
	private static void userLogin() {
			System.out.println("Enter your email:");
			String email = sc.next();
			System.out.println("Enter your password:");
			String pwd = sc.next();
			User user = ud.userLogin(email,pwd);
			System.out.println("mr/ms " + user.getName() + " login is successful.");
		}
	
	private static void userProfile() {
		System.out.println("Enter your email:");
		String email = sc.next();
		try {
			User d = ud.profileFetch(email);
			System.out.println(d);
		}catch(Exception e) {
			System.out.println("data not found with the given emailid" + email);
		}
		
	}
	 private static void userUpdate() {
				boolean v=true;
				String name=null,email=null,pwd=null,gender=null;
				long phno=0; int age=0;
				DrivingLicense dl=null;
				do {
					System.out.println("chice the data what you want to update");
					System.out.println("1.name");
					System.out.println("2.phone number");
					System.out.println("3.email");
					System.out.println("4.password");
					System.out.println("5.age");
					System.out.println("6.gender");
					System.out.println("7.DrivingLicense");
					int choice=sc.nextInt();
					switch(choice) {
					case 1:{
						System.out.println("enter name");
						name =sc.next();
					}break;
					case 2:{
						System.out.println("enter tne phone");
						phno =sc.nextLong();
					}break;
					case 3:{
						System.out.println("enter the email");
						email =sc.next();
					}break;
					case 4:{
						System.out.println("enter the password");
						pwd =sc.next();
					}break;
					case 5:{
						System.out.println("enter the age");
						age=sc.nextInt();
					}break;
					case 6:{
						System.out.println("enter the gender");
						gender=sc.next();
					}break;
					case 7:{
						System.out.println("exit....");
						v=false;
					}break;
					default:
						System.out.println("you enter wrong choice plese enter the correct");
						break;
					}
				}while(v);
				User u=new User(name,email,pwd,gender,phno);
				ud.updateUser(u, email);	
			}

               
			private static void userDelete() {
				System.out.println("Enter your email:");
				String email = sc.next();
				try {
	    			ud.deleteUser(email);
	    			System.out.println("data deleted");
	    		}catch(Exception e) {
	    			System.out.println("data not found with the given emailid"+ email);
	    		}
			}
			
	
			private static void drivingLicenseLogin() {
				System.out.println("Enter your drivinglicense number:");
				int dlNum = sc.nextInt();
				System.out.println("Enter your name:");
				String name = sc.next();
				DrivingLicense dl =dld.login(dlNum, name);
				
			}
			
			private static void drivingLicenseUpdate() {
				boolean v=true;
				String name=null,fatherName=null,email = null;
				Date dob = null;
				int id = 0;
				do {
					System.out.println("chice the data what you want to update");
//					System.out.println("1.dlNum");
					System.out.println("1.id");
					System.out.println("2.name");
					System.out.println("3.fatherName");
					System.out.println("4.DOB");
					int choice=sc.nextInt();
					switch(choice) {
					case 1:{
						System.out.println("Enter name");
						name =sc.next();
					}break;
					case 2:{
						System.out.println("Enter fathername");
						fatherName =sc.next();
					}break;
					case 3:{
						System.out.println("Enter email:");
						email = sc.next();
					}
					case 4:{
						System.out.println("Enter the DOB");
						dob = Date.valueOf(sc.next());
					}break;
					case 5:{
						System.out.println("Enter your dlid:");
						id = sc.nextInt();
					}
					case 6:{
						System.out.println("exit....");
						v=false;
					}break;
					default:
						System.out.println("you enter wrong choice plese enter the correct");
						break;
					}
				}while(v);
				DrivingLicense  dl =new DrivingLicense(id,name,fatherName,email,dob);
				dld.updateDrivingLicense(dl, id);
				
			}
			
			private static void drivingLicenseDelete() {
				 System.out.println("Enter your drivingLicense id:");
				    int id = sc.nextInt();
					dld.deleteDrivinglicense(id);
			}
			
			private static void drivingLicenseProfile() {
				 System.out.println("Enter your email:");
				 String email = sc.next();
				dld.fetchDrivinglicense(email);
			}	
}

			
    	
    		
    		
    		
    		
    		

	
	


	
	

		
		

		
	
