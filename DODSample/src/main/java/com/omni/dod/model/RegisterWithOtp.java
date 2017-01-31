package com.omni.dod.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "otp_table")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class RegisterWithOtp {
	
	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	/*@Column(name="USER_TYPE")
	private String user_type;*/
	@Column(name="USER_ID")
	private String user_id;
	@Column(name="OTP_NO")
	private String otpno;
	@Version
	
	@Column(name="EXP_DATE")
	private Date expdate;
	
	public Date getExpdate() {
		return expdate;
	}
	public void setExpdate(Date expdate) {
		this.expdate = expdate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getOtpno() {
		return otpno;
	}
	public void setOtpno(String otpno) {
		this.otpno = otpno;
	}	
	@Column(name="CRETATE_DATE")
	private Date createdate;

	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

}
