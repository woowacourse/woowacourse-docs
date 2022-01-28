# JavaScript Style Guide

우아한테크코스의 자바스크립트 스타일 가이드는 [Airbnb 자바스크립트 스타일 가이드](https://github.com/airbnb/javascript)를 기준으로 합니다. 기본 Airbnb가이드 외에 아래의 가이드를 함께 준수하도록 합니다.

## Naming Conventions

- 소스의 변수명, 클래스명 등에는 영문 이외의 언어를 사용하지 않습니다.

- 한글 발음을 그대로 사용하지 않습니다.

- 클래스, 메서드 등의 이름에는 특수 문자를 사용하지 않습니다.

  ```js
  // bad
  funtion $some() {

  }
  ```

- 클래스명과 변수명은 `명사`를 사용합니다.
- 메서드명은 `동사`를 사용합니다.
- 상수명은 대문자를 사용하고, 단어와 단어사이는 \_로 연결합니다.

  ```js
  // bad
  const firefox = 1;
  const is_left = true;

  // good
  const FIREFOX = 1;
  const IS_LEFT = true;
  ```

  
