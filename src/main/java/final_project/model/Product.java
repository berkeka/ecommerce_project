package final_project.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_price")
    private int productPrice;

    public String getProductName() {
        return productName;
    }
    public void getProductName(String productName) {
        this.productName = productName;
    }
    public int getProductPrice() {
        return productPrice;
    }
    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }
}