package com.example.demo.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "clients")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "lastName")
	private String lastName;

	@Column(name = "mobile")
	private long mobile;

	@OneToMany(mappedBy = "client",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Set<Sales> sales;

	public Client() {
	}


	public Client(String name, String lastName, long mobile, Set<Sales> sales) {
		this.name = name;
		this.lastName = lastName;
		this.mobile = mobile;
		this.sales = sales;
	}

	public Set<Sales> getSales() {
		return sales;
	}

	public void setSales(Set<Sales> sales) {
		this.sales = sales;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "Client{" +
				"id=" + id +
				", name='" + name + '\'' +
				", lastName='" + lastName + '\'' +
				", mobile=" + mobile +
				", sales=" + sales +
				'}';
	}
}
