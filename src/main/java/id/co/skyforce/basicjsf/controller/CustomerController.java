package id.co.skyforce.basicjsf.controller;

import id.co.skyforce.basicjsf.HibernateUtil;
import id.co.skyforce.basicjsf.domain.Address;
import id.co.skyforce.basicjsf.domain.Customer;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.hibernate.Session;
import org.hibernate.Transaction;

@ManagedBean
public class CustomerController {

	private String salutation;
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private Date birthDate;
	private String mobileNo;
	private String homePhone;
	private Character gender;

	private String street;
	private String city;
	private String postalCode;
	
	private Long customerId;
	private Long addresId;

	public CustomerController() {
		String id = FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap().get("id");

		if(id != null ){
			customerId = Long.valueOf(id);
			
			Session session = HibernateUtil.openSession();
			Transaction trx = session.beginTransaction();
			Customer customer = (Customer) session.get(Customer.class, customerId);
			
			addresId = customer.getAddress().getId();
			
			salutation = customer.getSalutation();
			firstName = customer.getFirstName();
			lastName = customer.getLastName();
			gender = customer.getGender();
			birthDate=customer.getBirthDate();
			email = customer.getEmail();
			homePhone = customer.getHomePhone();
			mobileNo = customer.getMobileNo();
			password = customer.getPassword();
			street = customer.getAddress().getStreet();
			city = customer.getAddress().getCity();
			postalCode = customer.getAddress().getPostalCode();
			
			trx.commit();
			session.close();
		}
		
	}
	
	public String save() {
		Session session = HibernateUtil.openSession();
		Transaction trx = session.beginTransaction();

		Customer customer = new Customer();
		Address addres = new Address();
		
		customer.setId(customerId);
		
		customer.setSalutation(salutation);
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setBirthDate(birthDate);
		customer.setGender(gender);
		customer.setHomePhone(homePhone);
		customer.setMobileNo(mobileNo);
		customer.setEmail(email);
		customer.setPassword(password);

		addres.setStreet(street);
		addres.setCity(city);
		addres.setPostalCode(postalCode);
		session.saveOrUpdate(addres);
		
		customer.setAddress(addres);

		session.saveOrUpdate(customer);
		trx.commit();
		session.close();

		return "list";
	}

	
	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	
	public Long getAddresId() {
		return addresId;
	}

	public void setAddresId(Long addresId) {
		this.addresId = addresId;
	}

	public String getSalutation() {
		return salutation;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	public Character getGender() {
		return gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

}
