package studio.thinkground.testproject.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/*
  AroundHubExceptionHandler 사용자 정의 예외처리 핸들러

  - @RestControllerAdvice를 사용하여 전역적으로 예외를 처리한다.
  - @ExceptionHandler 어노테이션을 사용하여 특정 예외를 처리하는 메서드를 정의
  - 지역 예외처리가 우선이고, 지역 예외처리가 없으면 여기서 전역예외를 처리한다.
 */
@RestControllerAdvice //컨트롤러에서 발생하는 예외처리는 여기서 처리한다는 의미
public class AroundHubExceptionHandler {

  private final Logger LOGGER = LoggerFactory.getLogger(AroundHubExceptionHandler.class);

  @ExceptionHandler(value = Exception.class)
  public ResponseEntity<Map<String, String>> ExceptionHandler(Exception e) {
    HttpHeaders responseHeaders = new HttpHeaders();
    //responseHeaders.add(HttpHeaders.CONTENT_TYPE, "application/json");
    HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

    LOGGER.info("Advice 내 ExceptionHandler 호출");

    Map<String, String> map = new HashMap<>();
    map.put("error type", httpStatus.getReasonPhrase());
    map.put("code", "400");
    map.put("message", "에러 발생");

    return new ResponseEntity<>(map, responseHeaders, httpStatus);
  }

  @ExceptionHandler(value = AroundHubException.class)
  public ResponseEntity<Map<String, String>> ExceptionHandler(AroundHubException e) {
    HttpHeaders responseHeaders = new HttpHeaders();

    Map<String, String> map = new HashMap<>();
    map.put("error type", e.getHttpStatusType());
    map.put("error code", Integer.toString(e.getHttpStatusCode())); // Map<String, Object>로 설정하면 toString 불필요
    map.put("message", e.getMessage());

    return new ResponseEntity<>(map, responseHeaders, e.getHttpStatus());
  }

}
