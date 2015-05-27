package demo.beans;

import java.math.BigDecimal;
import java.util.Date;

public class Account {
	private int id=0, customer_id = 0, contact_id=0;
	private Date start_date=null;
	private String acctype=null,segmentation=null;
	private BigDecimal acc_limit = null,current_balance=null;
	private BigDecimal income_received=null;
	private int statement_count = 0;
	private String bal_segment = null;
	private int txn_count = 0;

	public Account() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acc_limit == null) ? 0 : acc_limit.hashCode());
		result = prime * result + ((acctype == null) ? 0 : acctype.hashCode());
		result = prime * result + ((bal_segment == null) ? 0 : bal_segment.hashCode());
		result = prime * result + contact_id;
		result = prime * result + ((current_balance == null) ? 0 : current_balance.hashCode());
		result = prime * result + customer_id;
		result = prime * result + id;
		result = prime * result + ((income_received == null) ? 0 : income_received.hashCode());
		result = prime * result + ((segmentation == null) ? 0 : segmentation.hashCode());
		result = prime * result + ((start_date == null) ? 0 : start_date.hashCode());
		result = prime * result + statement_count;
		result = prime * result + txn_count;
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
		Account other = (Account) obj;
		if (acc_limit == null) {
			if (other.acc_limit != null)
				return false;
		} else if (!acc_limit.equals(other.acc_limit))
			return false;
		if (acctype == null) {
			if (other.acctype != null)
				return false;
		} else if (!acctype.equals(other.acctype))
			return false;
		if (bal_segment == null) {
			if (other.bal_segment != null)
				return false;
		} else if (!bal_segment.equals(other.bal_segment))
			return false;
		if (contact_id != other.contact_id)
			return false;
		if (current_balance == null) {
			if (other.current_balance != null)
				return false;
		} else if (!current_balance.equals(other.current_balance))
			return false;
		if (customer_id != other.customer_id)
			return false;
		if (id != other.id)
			return false;
		if (income_received == null) {
			if (other.income_received != null)
				return false;
		} else if (!income_received.equals(other.income_received))
			return false;
		if (segmentation == null) {
			if (other.segmentation != null)
				return false;
		} else if (!segmentation.equals(other.segmentation))
			return false;
		if (start_date == null) {
			if (other.start_date != null)
				return false;
		} else if (!start_date.equals(other.start_date))
			return false;
		if (statement_count != other.statement_count)
			return false;
		if (txn_count != other.txn_count)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String
				.format("Account [id=%s, customer_id=%s, contact_id=%s, start_date=%s, acctype=%s, segmentation=%s, acc_limit=%s, current_balance=%s, income_received=%s, statement_count=%s, bal_segment=%s, txn_count=%s]",
						id, customer_id, contact_id, start_date, acctype, segmentation, acc_limit, current_balance, income_received, statement_count,
						bal_segment, txn_count);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public int getContact_id() {
		return contact_id;
	}

	public void setContact_id(int contact_id) {
		this.contact_id = contact_id;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public String getAcctype() {
		return acctype;
	}

	public void setAcctype(String acctype) {
		this.acctype = acctype;
	}

	public String getSegmentation() {
		return segmentation;
	}

	public void setSegmentation(String segmentation) {
		this.segmentation = segmentation;
	}

	public BigDecimal getCurrent_balance() {
		return current_balance;
	}

	public void setCurrent_balance(BigDecimal current_balance) {
		this.current_balance = current_balance;
	}

	public BigDecimal getIncome_received() {
		return income_received;
	}

	public void setIncome_received(BigDecimal income_received) {
		this.income_received = income_received;
	}

	public int getStatement_count() {
		return statement_count;
	}

	public void setStatement_count(int statement_count) {
		this.statement_count = statement_count;
	}

	public String getBal_segment() {
		return bal_segment;
	}

	public void setBal_segment(String bal_segment) {
		this.bal_segment = bal_segment;
	}

	public int getTxn_count() {
		return txn_count;
	}

	public void setTxn_count(int txn_count) {
		this.txn_count = txn_count;
	}

	public BigDecimal getAcc_limit() {
		return acc_limit;
	}

	public void setAcc_limit(BigDecimal acc_limit) {
		this.acc_limit = acc_limit;
	}
}
