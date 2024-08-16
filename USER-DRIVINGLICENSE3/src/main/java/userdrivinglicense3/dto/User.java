package userdrivinglicense3.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


//@Entity(name="UserDetails")
@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String name;
	@Column(unique=true)
	String email;
	String pwd,gender;
	long phoneNumber;
	
	@OneToOne(cascade = CascadeType.ALL)
	DrivingLicense dl;

	public User(int id, String name, String email, String pwd, String gender, long phoneNumber, DrivingLicense dl) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.pwd = pwd;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.dl = dl;
	}

	public User(String name, String email, String pwd, String gender, long phoneNumber) {
		super();
		this.name = name;
		this.email = email;
		this.pwd = pwd;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", pwd=" + pwd + ", gender=" + gender
				+ ", phoneNumber=" + phoneNumber + ", dl=" + dl + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public DrivingLicense getDl() {
		return dl;
	}

	public void setDl(DrivingLicense dl) {
		this.dl = dl;
	}

	

	

}