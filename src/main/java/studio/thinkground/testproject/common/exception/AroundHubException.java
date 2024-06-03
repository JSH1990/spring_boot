package studio.thinkground.testproject.common.exception;

import org.springframework.http.HttpStatus;
import studio.thinkground.testproject.common.Constants;

/*
  AroundHubException 사용자 정의 예외 클래스

  - Exception 클래스를 상속하여 만들어졌다.
  - AroundHubException 생성자를 통해, 아래 내용을 커스텀 할수 있다.
  {
  "error code": "403",
  "error type": "Forbidden",
  "message": "Product Exception. 접근이 금지되었습니다."
  }

 */

public class AroundHubException extends Exception{ //Exception클래스를 상속받음

  private static final long serialVersionUID = 4663380430591151694L; //직렬화를 위해 만듦

  private Constants.ExceptionClass exceptionClass;
  private HttpStatus httpStatus;

  public AroundHubException(Constants.ExceptionClass exceptionClass, HttpStatus httpStatus, String message){ //커스텀 생성자
    super(exceptionClass.toString() + message);
    this.exceptionClass = exceptionClass;
    this.httpStatus = httpStatus;
  }

  public Constants.ExceptionClass getExceptionClass() {
    return exceptionClass;
  }

  public int getHttpStatusCode() {
    return httpStatus.value();
  }

  public String getHttpStatusType() {
    return httpStatus.getReasonPhrase();
  }

  public HttpStatus getHttpStatus(){
    return httpStatus;
  }

}
