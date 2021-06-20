package final_project.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_price")
    private double productPrice;
    
    @OneToMany(mappedBy = "product")
    private Set<Item> items = new HashSet<>();
    
    public Product() {
    	
    }

    public Product(String productName, double productPrice) {
    	setProductName(productName);
    	setProductPrice(productPrice);
    }
    
    public int getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public double getProductPrice() {
        return productPrice;
    }
    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
}