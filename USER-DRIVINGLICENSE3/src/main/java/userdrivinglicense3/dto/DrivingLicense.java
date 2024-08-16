package userdrivinglicense3.dto;

import java.sql.Date;
import java.util.Random;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@Entity(name="DrivingLicenseDetails")
@Entity
public class DrivingLicense {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int dLid;
	int dlNum;
	String name,fatherName,email;
	Date dob;
	
	public int getdLid() {
		return dLid;
	}
	public void setdLid(int dLid) {
		this.dLid = dLid;
	}
	public int getDlNum() {
		return dlNum;
	}
	public void setDlNum(int dlNum) {
		int random=new Random().nextInt();
		this.dlNum = random;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "DrivingLicense [dLid=" + dLid + ", dlNum=" + dlNum + ", name=" + name + ", fatherName=" + fatherName
				+ ", dob=" + dob + "]";
	}
	
	public DrivingLicense() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DrivingLicense(int dlNum, String name, String fatherName, String email, Date dob) {
		super();
		int random = new Random().nextInt(45667);
		this.dlNum = random;
		this.name = name;
		this.fatherName = fatherName;
		this.email = email;
		this.dob = dob;
	}
	public DrivingLicense(int dLid, int dlNum, String name, String fatherName, String email, Date dob) {
		super();
		this.dLid = dLid;
		this.dlNum = dlNum;
		this.name = name;
		this.fatherName = fatherName;
		this.email = email;
		this.dob = dob;
	}
	
	
	
	
	
	
	

}
