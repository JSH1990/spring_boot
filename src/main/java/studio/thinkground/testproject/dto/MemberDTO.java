package studio.thinkground.testproject.dto;

import lombok.*;

/* Lombok의 대표적인 어노테이션
@NoArgsConstructor
- 파라미터가 없는 생성자를 생성

@AllArgsConstructor
- 모든 필드값을 파라미터로 갖는 생성자를 생성

@RequiredArgsConstructor
- 필드값 중 final이나 @NotNull인 값을 갖는 생성자 생성
 */

@Getter
@Setter
@ToString
public class MemberDTO {

  private String name;
  private String email;
  private String organization;

}
