package com.springboot.jasperreports.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="products")
public class Products {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_id_sequence")
	@SequenceGenerator(name = "product_id_sequence", sequenceName = "product_id_sequence", allocationSize = 1)
	@Column(name = "product_id", updatable = false, columnDefinition = "INTEGER")
	private Long id;
	
	@Column(name = "product_name", columnDefinition = "VARCHAR(300)")
	private String productName;
	
	@Column(name = "product_category", columnDefinition = "VARCHAR(50)")
	private String productCategory;
	
	@Column(name = "product_price", columnDefinition = "DOUBLE")
	private Double productPrice;
}
