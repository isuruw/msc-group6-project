/**
 * 
 */
package com.cst6.msc.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author SasankaN
 *
 */
@Entity
@Table(name="payment_details")
public class PaymentDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="amount", nullable=false)
	private Double amount;
	
	@Column(name="payment_date", nullable=false)
	private Date paymentDate;
	
	@OneToOne
	@JoinColumn(name="payment_mode_id", referencedColumnName="id")
	private PaymentMode paymentMode;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public PaymentMode getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(PaymentMode paymentMode) {
		this.paymentMode = paymentMode;
	}
	
	@Override
	public String toString() {
		StringBuilder newSB = new StringBuilder("PaymentDetails[");
		newSB.append("id=").append(getId()).append(",");
		newSB.append("amount=").append(getAmount()).append(",");
		newSB.append("paymentDate=").append(getPaymentDate()).append(",");
		newSB.append("paymentMode=").append(getPaymentMode());
		newSB.append("]"); 
		
		return newSB.toString();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		
		if(obj==this)
			return true;
		
		if(obj instanceof PaymentDetails){
			PaymentDetails other = (PaymentDetails) obj;
			return other.getId().equals(getId());
		}
			
		return false;
	}
}
