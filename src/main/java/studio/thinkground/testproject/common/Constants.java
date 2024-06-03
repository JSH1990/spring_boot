package studio.thinkground.testproject.common;

public class Constants {

    /*
  ExceptionClass 애플리케이션 전반에서 사용할 상수를 정의

  - 각 예외 유형은 PRODUCT, ORDER, PROVIDER로 정의
 */
    public enum ExceptionClass {

        PRODUCT("Product"), ORDER("Order"), PROVIDER("Provider"); //상수로 정의

        private String exceptionClass;

        ExceptionClass(String exceptionClass) {
            this.exceptionClass = exceptionClass;
        }

        public String getExceptionClass() {
            return exceptionClass;
        }

        @Override
        public String toString() {
            return getExceptionClass() + " Exception. ";
        }

    }

}
