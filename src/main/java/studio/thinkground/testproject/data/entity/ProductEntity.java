package studio.thinkground.testproject.data.entity;

import lombok.*;
import studio.thinkground.testproject.data.dto.ProductDto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "product")
public class ProductEntity {

  @Id
  String productId;

  String productName;

  Integer productPrice;

  Integer productStock;

  /*
  @Column
  String sellerId;

  @Column
  String sellerPhoneNumber;
   */

  public ProductDto toDto(){
    return ProductDto.builder()
        .productId(productId)
        .productName(productName)
        .productPrice(productPrice)
        .productStock(productStock)
        .build();
  }

}
