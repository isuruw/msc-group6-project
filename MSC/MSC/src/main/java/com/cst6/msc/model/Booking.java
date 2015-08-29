/**
 * 
 */
package com.cst6.msc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author SasankaN
 *
 */
@Entity
@Table(name="booking")
public class Booking {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="ref_no", nullable=false)
	private String referenceNo;
	
	@Column(name="booking_date")
	private Date bookingDate;
	
	@ManyToOne
	@JoinColumn(name="customer_id", referencedColumnName="id")
	private Customer customber;
	
	@ManyToOne
	@JoinColumn(name="payment_details_id", referencedColumnName="id")
	private PaymentDetails paymentDetails;
	
	@OneToOne
	@JoinColumn(name="loading_port_id", referencedColumnName="id")
	private Port loadingPort;
	
	@OneToOne
	@JoinColumn(name="unloading_port_id", referencedColumnName="id")
	private Port unloadingPort;
	
	@OneToOne
	@JoinColumn(name="collection_address_id", referencedColumnName="id")
	private Address collectionAddress;
	
	@OneToOne
	@JoinColumn(name="delivery_address_id", referencedColumnName="id")
	private Address deliveryAddress;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Customer getCustomber() {
		return customber;
	}

	public void setCustomber(Customer customber) {
		this.customber = customber;
	}

	public PaymentDetails getPaymentDetails() {
		return paymentDetails;
	}

	public void setPaymentDetails(PaymentDetails paymentDetails) {
		this.paymentDetails = paymentDetails;
	}

	public Port getLoadingPort() {
		return loadingPort;
	}

	public void setLoadingPort(Port loadingPort) {
		this.loadingPort = loadingPort;
	}

	public Port getUnloadingPort() {
		return unloadingPort;
	}

	public void setUnloadingPort(Port unloadingPort) {
		this.unloadingPort = unloadingPort;
	}

	public Address getCollectionAddress() {
		return collectionAddress;
	}

	public void setCollectionAddress(Address collectionAddress) {
		this.collectionAddress = collectionAddress;
	}

	public Address getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(Address deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	
	
	

}
