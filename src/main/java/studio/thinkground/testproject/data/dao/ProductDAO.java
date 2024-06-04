package studio.thinkground.testproject.data.dao;

import studio.thinkground.testproject.data.entity.Product;

public interface ProductDAO {

  Product saveProduct(Product product);

  Product getProduct(String productId);

}
