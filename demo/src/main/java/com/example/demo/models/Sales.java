package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "sales")
public class Sales extends AuditModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "seller")
	private String seller;

	@Column(name = "total")
	private Double total;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "client_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Client client;

	public Sales(String name, String seller, Double total, Client client) {
		this.name = name;
		this.seller = seller;
		this.total = total;
		this.client = client;
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

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Sales() {
	}

	@Override
	public String toString() {
		return "Sales{" +
				"id=" + id +
				", name='" + name + '\'' +
				", seller='" + seller + '\'' +
				", total=" + total +
				", client=" + client +
				'}';
	}
}
