# JavaScript Style Guide

우아한테크코스의 자바스크립트 스타일 가이드는 [Airbnb 자바스크립트 스타일 가이드](https://github.com/airbnb/javascript)를 기준으로 합니다. 기본 Airbnb가이드 외에 아래의 가이드를 함께 준수하도록 합니다.

## 네이밍 컨벤션

### 기본

- 소스의 변수명, 클래스명 등에는 영문 이외의 언어를 사용하지 않습니다.

- 클래스, 메서드 등의 이름에는 특수 문자를 사용하지 않습니다.

  ```js
  // bad
  funtion $some() {

  }
  ```

- 클래스명과 변수명은 `명사`를 사용합니다.
- 상수명은 SNAKE_CASE로 작성합니다.

  ```js
  // bad
  const firefox = 1;
  const is_left = true;

  // good
  const FIREFOX = 1;
  const IS_LEFT = true;
  ```

### 파일 & 패키지
- 소스코드 파일의 이름은 알파벳 소문자, 하이픈( - ), 밑줄( _ ) 으로만 작성합니다.
- 패키지의 이름은 camelCase로 표기합니다.

  ```js
  // bad
  woowacourse/frontendcourse
  woowacourse/frontend_course

  // good
  woowacourse/frontendCourse
  ```
