package demo.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Contact {
	private int id =0;
	private short agent_id=0;
	private String first_name=null,last_name=null,email=null,phone=null;
	private String address1=null,address2=null,address3=null,address4=null,address5=null;
	private String extaccno = null, profession = null;
	private short age = 0;
	private int income = 0;
	private String marital_status = null;

	public Contact() {
		super();
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address1 == null) ? 0 : address1.hashCode());
		result = prime * result + ((address2 == null) ? 0 : address2.hashCode());
		result = prime * result + ((address3 == null) ? 0 : address3.hashCode());
		result = prime * result + ((address4 == null) ? 0 : address4.hashCode());
		result = prime * result + ((address5 == null) ? 0 : address5.hashCode());
		result = prime * result + age;
		result = prime * result + agent_id;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((extaccno == null) ? 0 : extaccno.hashCode());
		result = prime * result + ((first_name == null) ? 0 : first_name.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (int) (income ^ (income >>> 32));
		result = prime * result + ((last_name == null) ? 0 : last_name.hashCode());
		result = prime * result + ((marital_status == null) ? 0 : marital_status.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((profession == null) ? 0 : profession.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		if (address1 == null) {
			if (other.address1 != null)
				return false;
		} else if (!address1.equals(other.address1))
			return false;
		if (address2 == null) {
			if (other.address2 != null)
				return false;
		} else if (!address2.equals(other.address2))
			return false;
		if (address3 == null) {
			if (other.address3 != null)
				return false;
		} else if (!address3.equals(other.address3))
			return false;
		if (address4 == null) {
			if (other.address4 != null)
				return false;
		} else if (!address4.equals(other.address4))
			return false;
		if (address5 == null) {
			if (other.address5 != null)
				return false;
		} else if (!address5.equals(other.address5))
			return false;
		if (age != other.age)
			return false;
		if (agent_id != other.agent_id)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (extaccno == null) {
			if (other.extaccno != null)
				return false;
		} else if (!extaccno.equals(other.extaccno))
			return false;
		if (first_name == null) {
			if (other.first_name != null)
				return false;
		} else if (!first_name.equals(other.first_name))
			return false;
		if (id != other.id)
			return false;
		if (income != other.income)
			return false;
		if (last_name == null) {
			if (other.last_name != null)
				return false;
		} else if (!last_name.equals(other.last_name))
			return false;
		if (marital_status == null) {
			if (other.marital_status != null)
				return false;
		} else if (!marital_status.equals(other.marital_status))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (profession == null) {
			if (other.profession != null)
				return false;
		} else if (!profession.equals(other.profession))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String
				.format("Contact [id=%s, agentid=%s, first_name=%s, last_name=%s, email=%s, phone=%s, address1=%s, address2=%s, address3=%s, address4=%s, address5=%s, extaccno=%s, proession=%s, age=%s, income=%s, marital_status=%s]",
						id, agent_id, first_name, last_name, email, phone, address1, address2, address3, address4, address5, extaccno, profession, age,
						income, marital_status);
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public short getAgent_id() {
		return agent_id;
	}


	public void setAgent_id(short agent_id) {
		this.agent_id = agent_id;
	}


	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getAddress1() {
		return address1;
	}


	public void setAddress1(String address1) {
		this.address1 = address1;
	}


	public String getAddress2() {
		return address2;
	}


	public void setAddress2(String address2) {
		this.address2 = address2;
	}


	public String getAddress3() {
		return address3;
	}


	public void setAddress3(String address3) {
		this.address3 = address3;
	}


	public String getAddress4() {
		return address4;
	}


	public void setAddress4(String address4) {
		this.address4 = address4;
	}


	public String getAddress5() {
		return address5;
	}


	public void setAddress5(String address5) {
		this.address5 = address5;
	}


	public String getExtaccno() {
		return extaccno;
	}


	public void setExtaccno(String extaccno) {
		this.extaccno = extaccno;
	}


	public String getProfession() {
		return profession;
	}


	public void setProfession(String profession) {
		this.profession = profession;
	}


	public short getAge() {
		return age;
	}


	public void setAge(short age) {
		this.age = age;
	}


	public int getIncome() {
		return income;
	}


	public void setIncome(int income) {
		this.income = income;
	}


	public String getMarital_status() {
		return marital_status;
	}


	public void setMarital_status(String marital_status) {
		this.marital_status = marital_status;
	}

}
