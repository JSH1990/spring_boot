package studio.thinkground.testproject.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import studio.thinkground.testproject.data.dto.ProductDto;
import studio.thinkground.testproject.data.entity.ProductEntity;
import studio.thinkground.testproject.data.handler.impl.ProductDataHandlerImpl;

import static org.mockito.Mockito.verify;

@SpringBootTest(classes = {ProductDataHandlerImpl.class, ProductServiceImpl.class})
public class ProductServiceImplTest {

  @MockBean
  ProductDataHandlerImpl productDataHandler;

  @Autowired
  ProductServiceImpl productService;

  @Test
  public void getProductTest() {
    //given
    Mockito.when(productDataHandler.getProductEntity("123")) //이런 상황일때, 아래 코드를 리턴해줘라
        .thenReturn(new ProductEntity("123", "pen", 2000, 3000));

    ProductDto productDto = productService.getProduct("123");

    Assertions.assertEquals(productDto.getProductName(), "pen");

    verify(productDataHandler).getProductEntity("123");
  }

  @Test
  public void saveProductTest() {
    //given
    Mockito.when(productDataHandler.saveProductEntity("123", "pen", 2000, 3000))
        .thenReturn(new ProductEntity("123", "pen", 2000, 3000));

    ProductDto productDto = productService.saveProduct("123", "pen", 2000, 3000);

    Assertions.assertEquals(productDto.getProductId(), "123");
    Assertions.assertEquals(productDto.getProductName(), "pen");
    Assertions.assertEquals(productDto.getProductPrice(), 2000);
    Assertions.assertEquals(productDto.getProductStock(), 3000);

  }


}
