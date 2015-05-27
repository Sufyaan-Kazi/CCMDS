package demo.beans;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Statement {
	private int acc_id =0, statementId = 0;
	private short year = 0, month = 0;
	private BigDecimal opening_balance=null, closing_balance=null, min_payment=null;
	private int txn_count=0;

	public Statement() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (acc_id ^ (acc_id >>> 32));
		result = prime * result + ((closing_balance == null) ? 0 : closing_balance.hashCode());
		result = prime * result + ((min_payment == null) ? 0 : min_payment.hashCode());
		result = prime * result + month;
		result = prime * result + ((opening_balance == null) ? 0 : opening_balance.hashCode());
		result = prime * result + (int) (statementId ^ (statementId >>> 32));
		result = prime * result + (int) (txn_count ^ (txn_count >>> 32));
		result = prime * result + year;
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
		Statement other = (Statement) obj;
		if (acc_id != other.acc_id)
			return false;
		if (closing_balance == null) {
			if (other.closing_balance != null)
				return false;
		} else if (!closing_balance.equals(other.closing_balance))
			return false;
		if (min_payment == null) {
			if (other.min_payment != null)
				return false;
		} else if (!min_payment.equals(other.min_payment))
			return false;
		if (month != other.month)
			return false;
		if (opening_balance == null) {
			if (other.opening_balance != null)
				return false;
		} else if (!opening_balance.equals(other.opening_balance))
			return false;
		if (statementId != other.statementId)
			return false;
		if (txn_count != other.txn_count)
			return false;
		if (year != other.year)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format(
				"Statement [acc_id=%s, statement_id=%s, year=%s, month=%s, opening_balance=%s, current_balance=%s, min_payment=%s, txn_count=%s]",
				acc_id, statementId, year, month, opening_balance, closing_balance, min_payment, txn_count);
	}

	public int getAcc_id() {
		return acc_id;
	}

	public void setAcc_id(int acc_id) {
		this.acc_id = acc_id;
	}

	public int getStatementId() {
		return statementId;
	}

	public void setStatementId(int statementId) {
		this.statementId = statementId;
	}

	public short getYear() {
		return year;
	}

	public void setYear(short year) {
		this.year = year;
	}

	public short getMonth() {
		return month;
	}

	public void setMonth(short month) {
		this.month = month;
	}

	public BigDecimal getOpening_balance() {
		return opening_balance;
	}

	public void setOpening_balance(BigDecimal opening_balance) {
		this.opening_balance = opening_balance;
	}

	public BigDecimal getClosing_balance() {
		return closing_balance;
	}

	public void setClosing_balance(BigDecimal closing_balance) {
		this.closing_balance = closing_balance;
	}

	public BigDecimal getMin_payment() {
		return min_payment;
	}

	public void setMin_payment(BigDecimal min_payment) {
		this.min_payment = min_payment;
	}

	public int getTxn_count() {
		return txn_count;
	}

	public void setTxn_count(int txn_count) {
		this.txn_count = txn_count;
	}

}
