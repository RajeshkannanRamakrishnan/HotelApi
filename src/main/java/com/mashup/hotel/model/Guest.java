package com.mashup.hotel.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@Entity
@Component
@Table(name="guest")
@ApiModel(description = "Class representing user tracked by an Admin.")

public class Guest {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Transient
    static final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	
	@Column
    @ApiModelProperty(notes = "check in time of guest, calculated by application", example = "2018-08-18 17:27:22", position = 3)
	private String checkInTime;
	
	@Column
	@NotNull
	@Size(min=2, message="Name should have atleast 2 characters")
    @ApiModelProperty(notes = "first name of guest", example = "Walter", position = 4)
	private String firstName;
	
	@Column
    @ApiModelProperty(notes = "Age of Guest", example = "24", position = 4)
	private Integer age;
	
	@Column
	@ApiModelProperty(notes= "checkout time for guest,provided by admin",example = "2018-08-18 17:26:23", position= 5)
	@Nullable
	private String checkOutTime;
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}


	public String getCheckOutTime() {
		return checkOutTime;
	}

	public void setCheckOutTime(String checkOutTime) {
		this.checkOutTime = checkOutTime;
	}

	@Column
    @ApiModelProperty(notes = "last name of guest", example = "White", position = 5)
	private String lastName;
	
	@Column
	@NotNull
	@Size(min=10,max=10, message="contact should have atleast 10 digits")
    @ApiModelProperty(notes = "contact of guest ", example = "8756846722", position = 6)
	private String contact;
	
	@Column
	@NotNull
	@Email(message="Email not well formed")
    @ApiModelProperty(notes = "email of guest ", example = "rish93@gmail.com", position = 7)
	private String email; 
	
	
	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getCheckInTime() {
		return checkInTime;
	}

	public void setCheckInTime(String checkInTime) {
		this.checkInTime = checkInTime;
	}

	public void setDate(long dateMilisecond) {
		Date date= new Date(dateMilisecond);
		this.checkInTime=sdf.format(date);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
	@Override
	public String toString() {
	//{System.out.println("firstName"+this.firstName+" lastName"+this.lastName);
		return "firstName"+this.firstName+" lastName"+this.lastName ;
	}
	
}
