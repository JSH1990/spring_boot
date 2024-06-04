package studio.thinkground.testproject.data.handler;

import studio.thinkground.testproject.data.entity.Product;

public interface ProductDataHandler {

    Product saveProductEntity(String productId, String productName, int productPrice, int productStock);

    Product getProductEntity(String productId);

}
