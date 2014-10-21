package id.co.skyforce.basicjsf.trycontroller;

import java.util.Date;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class MyFirstTryController {

	private String youSay = "Hello World  !! ";
	private String name;
	private int age;
	private Date birthDate;
	private String hobi;
	private char gender;
	private String alamat;
	private String kota;
	private String mobilePhone;

	public String personalAgain() {
		
		return "output";
	}

	public String getYouSay() {
		return youSay;
	}

	public void setYouSay(String youSay) {
		this.youSay = youSay;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getHobi() {
		return hobi;
	}

	public void setHobi(String hobi) {
		this.hobi = hobi;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	public String getKota() {
		return kota;
	}

	public void setKota(String kota) {
		this.kota = kota;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

}
