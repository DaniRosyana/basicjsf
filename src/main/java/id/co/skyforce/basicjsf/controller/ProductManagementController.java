package id.co.skyforce.basicjsf.controller;

import id.co.skyforce.basicjsf.HibernateUtil;
import id.co.skyforce.basicjsf.domain.Category;
import id.co.skyforce.basicjsf.domain.Customer;
import id.co.skyforce.basicjsf.domain.Product;
import id.co.skyforce.basicjsf.domain.Supplier;

import java.math.BigDecimal;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.hibernate.Session;
import org.hibernate.Transaction;

@ManagedBean (name = "product")
public class ProductManagementController {

	private String name;
	private BigDecimal price;
	private Integer stock;
	private String description;

	private Long productId;
	private Long categoryId;
	private Long supplierId;
	
	
	public ProductManagementController() {
		
		String id = (String) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		if (id != null) {
			productId = Long.valueOf(id);
			
			Session session = HibernateUtil.openSession();
			
			Product products = (Product) session.get(Product.class, productId);
			categoryId = products.getCategory().getId();
			supplierId = products.getSupplier().getId();
			
			name = products.getName();
			price = products.getPrice();
			stock = products.getStock();
			description = products.getDescription();
			
			session.close();
		}
	}
	
	public String saveOrUpdate(){
		Session session = HibernateUtil.openSession();
		Transaction trx = session.beginTransaction();
		
		long IdCategory = Long.valueOf(categoryId);
		long IdSupplier = Long.valueOf(supplierId);
		int stocks = Integer.valueOf(stock);
		
		Product product = new Product();
		Category category = (Category) session.get(Category.class, IdCategory);
		Supplier supplier = (Supplier) session.get(Supplier.class, IdSupplier);
		
		product.setName(name);
		product.setPrice(price);
		product.setStock(stocks);
		product.setDescription(description);
		product.setCategory(category);
		product.setSupplier(supplier);
		
		session.saveOrUpdate(product);
		trx.commit();
		session.close();
		
		return "list";
	}

	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

}
