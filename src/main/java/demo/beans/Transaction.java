package demo.beans;

import java.math.BigDecimal;
import java.util.Date;

public class Transaction {
	private int acc_id = 0, statement_id = 0, tx_id = 0;
	private Date tx_date = null;
	private BigDecimal amount=null;
	private String description=null, category = null;

	public Transaction() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (acc_id ^ (acc_id >>> 32));
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((tx_date == null) ? 0 : tx_date.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + (int) (statement_id ^ (statement_id >>> 32));
		result = prime * result + (int) (tx_id ^ (tx_id >>> 32));
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
		Transaction other = (Transaction) obj;
		if (acc_id != other.acc_id)
			return false;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (tx_date == null) {
			if (other.tx_date != null)
				return false;
		} else if (!tx_date.equals(other.tx_date))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (statement_id != other.statement_id)
			return false;
		if (tx_id != other.tx_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("Transaction [acc_id=%s, statement_id=%s, tx_id=%s, date=%s, amount=%s, description=%s, category=%s]", acc_id,
				statement_id, tx_id, tx_date, amount, description, category);
	}

	public int getAcc_id() {
		return acc_id;
	}

	public void setAcc_id(int acc_id) {
		this.acc_id = acc_id;
	}

	public int getStatement_id() {
		return statement_id;
	}

	public void setStatement_id(int statement_id) {
		this.statement_id = statement_id;
	}

	public int getTx_id() {
		return tx_id;
	}

	public void setTx_id(int tx_id) {
		this.tx_id = tx_id;
	}

	public Date getTx_date() {
		return tx_date;
	}

	public void setTx_date(Date tx_date) {
		this.tx_date = tx_date;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
