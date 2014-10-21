package id.co.skyforce.basicjsf.controller;

import id.co.skyforce.basicjsf.HibernateUtil;
import id.co.skyforce.basicjsf.domain.Product;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.hibernate.Hibernate;
import org.hibernate.Session;

@ManagedBean
public class ProductManagementListController {
	private List<Product> products;
	
	public ProductManagementListController() {
		Session session = HibernateUtil.openSession();
		
		products = session.createQuery("from Product").list();
		
		for (Product product : products) {
			Hibernate.initialize(product.getCategory());
			Hibernate.initialize(product.getSupplier());
		}
		
		session.close();
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
