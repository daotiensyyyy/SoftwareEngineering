package bean;

import java.util.Date;

public abstract class User {
	protected String code;
	protected String firstname;
	protected String lastname;
	protected String address;
	protected String email;
	protected Date birthday;
	protected String phone;
	protected String username;
	protected String password;
	protected String role;
	protected String status;
	
	public User(String code, String firstname, String lastname, String address, String email, Date birthday,
			String phone, String username, String password, String role, String status) {
		super();
		this.code = code;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.email = email;
		this.birthday = birthday;
		this.phone = phone;
		this.username = username;
		this.password = password;
		this.role = role;
		this.status = status;
	}
	
	public User() {
		
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String isStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "User [code=" + code + ", lastname=" + lastname + ", firstname=" + firstname + ", address=" + address
				+ ", email=" + email + ", birthday=" + birthday + ", phone=" + phone + ", username=" + username
				+ ", password=" + password + ", role=" + role + ", status=" + status + "]";
	}
	
}
