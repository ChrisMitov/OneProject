package com.project.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Ordered_Products")
public class OrderedProducts {

	@Id
	@Column (name = "idOrderedProducts")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderedProductsId;

	@ManyToOne
	@JoinColumn(name = "idProduct")
	private Product product;

	@ManyToOne
	@JoinColumn(name = "idOrder")
	private Order order;

	@Column(name = "quantity")
	private Integer quantity;

	@ManyToOne
	private Order barOrder;
	
	public OrderedProducts() {
	}
	
	public OrderedProducts(Product product, Order order, Integer quantity) {
		this.product = product;
		this.order = order;
		this.quantity = quantity;
	}

	public Product getProductID() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderedProduct{" +
				"orderedProductId=" + orderedProductsId +
				", idProduct=" + product.getIdProduct() +
				", idOrder=" + order.getIdOrder() +
				", quantity=" + quantity + '}';
	}
}
