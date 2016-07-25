package com.project.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.project.enums.OrderType;

@Entity
@Table(name = "Order")
public class Order {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idOrder;

	@Temporal(TemporalType.DATE)
	@Column(name = "time_started")
	private Date timeStarted;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "time_finished")
	private Date timeFinished;
	
	@ManyToOne
	@JoinColumn(name = "barmanId")
	private User barman;
	
	@ManyToOne
	@JoinColumn(name = "waiterId")
	private User waiter;

	@OneToMany(mappedBy = "BarOrder", cascade = CascadeType.ALL)
	private List<OrderedProducts> productsInOrder;

	@Column(name = "type")
	@Enumerated(EnumType.STRING)
	private OrderType type;

	public Order() {
		productsInOrder = new ArrayList<OrderedProducts>();
		this.type = OrderType.WAITING;
	}
		
	public Order(Date timeStarted, User barman, User waiter) {
		this.timeStarted = timeStarted;
		this.barman = barman;
		this.waiter = waiter;
		this.type = OrderType.WAITING;
	}

	public List<OrderedProducts> getProductsInOrder() {
		return productsInOrder;
	}

	public void setProductsInOrder(List<OrderedProducts> productsInOrder) {
		this.productsInOrder = productsInOrder;
	}

	public User getWaiter() {
		return waiter;
	}

	public void setWaiter(User waiter) {
		this.waiter = waiter;
	}

	public User getBarman() {
		return barman;
	}

	public void setBarman(User barman) {
		this.barman = barman;
	}

	public Date getTimeFinished() {
		return timeFinished;
	}

	public void setTimeFinished(Date timeFinished) {
		this.timeFinished = timeFinished;
	}

	public Date getTimeStarted() {
		return timeStarted;
	}

	public void setTimeStarted(Date timeStarted) {
		this.timeStarted = timeStarted;
	}

	public Integer getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(Integer idOrder) {
		this.idOrder = idOrder;
	}

	public OrderType getType() {
		return type;
	}

	public void setType(OrderType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "BarOrder{" +
				"idOrder=" + idOrder +
				", timeStarted=" + timeStarted +
				", timeFinished=" + timeFinished +
				", barman=" + barman +
				", waiter=" + waiter +
				", productsInOrder=" + productsInOrder +
				'}';
	}
}