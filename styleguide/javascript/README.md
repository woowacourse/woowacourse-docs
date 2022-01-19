# JavaScript Style Guide

우아한테크코스의 자바스크립트 스타일 가이드는 [Airbnb 자바스크립트 스타일 가이드](https://github.com/airbnb/javascript)를 기준으로 작성되었습니다.

## Table of Contents

1. [Types](#1-types)
2. [References](#2-references)
3. [Objects](#3-objects)
4. [Arrays](#4-arrays)
5. [Destructuring](#5-destructuring)
6. [Strings](#6-strings)
7. [Functions](#7-functions)
8. [Arrow Functions](#8-arrow-functions)
9. [Classes & Constructors](#9-classes--constructors)
10. [Modules](#10-modules)
11. [Iterators and Generators](#11-iterators-and-generators)
12. [Properties](#12-properties)
13. [Variables](#13-variables)
14. [Hoisting](#14-hoisting)
15. [Comparison Operators & Equality](#15-comparison-operators--equality)
16. [Blocks](#16-blocks)
17. [Control Statements](#17-control-statements)
18. [Comments](#18-comments)
19. [Whitespace](#19-whitespace)
20. [Commas](#20-commas)
21. [Semicolons](#21-semicolons)
22. [Type Casting & Coercion](#22-type-casting--coercion)
23. [Naming Conventions](#23-naming-conventions)
24. [Accessors](#24-accessors)
25. [Events](#25-events)
26. [jQuery](#26-jquery)
27. [Resources](#27-resources)

## 1. Types

> [Airbnb](https://github.com/airbnb/javascript/blob/master/README.md#types)와 동일합니다.

## 2. References

> [Airbnb](https://github.com/airbnb/javascript/blob/master/README.md#references)와 동일합니다.

## 3. Objects

> [Airbnb](https://github.com/airbnb/javascript/blob/master/README.md#types)와 동일합니다.

## 4. Arrays

> [Airbnb](https://github.com/airbnb/javascript/blob/master/README.md#array)와 동일합니다.

## 5. Destructuring

> [Airbnb](https://github.com/airbnb/javascript/blob/master/README.md#destructuring)와 동일합니다.

## 6. Strings

> [Airbnb](https://github.com/airbnb/javascript/blob/master/README.md#strings)와 동일합니다.

## 7. Functions

> `7.1 ~ 2` 항목을 제외하고는 [Airbnb](https://github.com/airbnb/javascript/blob/master/README.md#functions)와 동일합니다.

- [7.1](#7.1) <a name='7.1'></a>함수 스타일에 대해서 특정 가이드를 제공하지 않습니다. eslint: [`func-style`](http://eslint.org/docs/rules/func-style)

```javascript
// type 1
function foo() {
  // ...
}

// type 2
const foo = function () {
  // ...
};

// type 3
const foo = function bar() {
  // ...
};
```

- [7.2](#7.2) <a name='7.2'></a>즉시 실행함수는 함수를 괄호로 감싸줍니다. eslint: [`wrap-iife`](http://eslint.org/docs/rules/wrap-iife.html)

```javascript
// bad
(function () {
  console.log("Welcome to the Internet. Please follow me.");
})();

// good
(function () {
  console.log("Welcome to the Internet. Please follow me.");
})();
```

## 8. Arrow Functions

> `8.4` 항목을 제외하고는 [Airbnb](https://github.com/airbnb/javascript/blob/master/README.md#arrow-functions)와 동일합니다.

- [8.4](#8.4) <a name='8.4'></a>함수가 단일 파라미터인 경우, 소괄호(`()`)는 생략한다. eslint: [`arrow-parens`](http://eslint.org/docs/rules/arrow-parens.html)

  ```javascript
  // bad
  [1, 2, 3].map((x) => x * x);

  // good
  [1, 2, 3].map((x) => x * x);

  // good
  [1, 2, 3].map(
    (number) =>
      `A long string with the ${number}. It’s so long that we don’t want it to take up space on the .map line!`
  );

  // bad
  [1, 2, 3].map((x) => {
    const y = x + 1;
    return x * y;
  });

  // good
  [1, 2, 3].map((x) => {
    const y = x + 1;
    return x * y;
  });
  ```

## 9. Classes & Constructors

> [Airbnb](https://github.com/airbnb/javascript/blob/master/README.md#classes--constructors)와 동일합니다.

## 10. Modules

> [Airbnb](https://github.com/airbnb/javascript/blob/master/README.md#modules)와 동일합니다.

## 11. Iterators and Generators

> [Airbnb](https://github.com/airbnb/javascript/blob/master/README.md#iterators-and-generators)와 동일합니다.

## 12. Properties

> [Airbnb](https://github.com/airbnb/javascript/blob/master/README.md#properties)와 동일합니다.

## 13. Variables

> [Airbnb](https://github.com/airbnb/javascript/blob/master/README.md#variables)와 동일합니다.

## 14. Hoisting

> [Airbnb](https://github.com/airbnb/javascript/blob/master/README.md#hoisting)와 동일합니다.

## 15. Comparison Operators & Equality

> [Airbnb](https://github.com/airbnb/javascript/blob/master/README.md#comparison-operators--equality)와 동일합니다.

## 16. Blocks

> [Airbnb](https://github.com/airbnb/javascript/blob/master/README.md#blocks)와 동일합니다.

## 17. Control Statements

> [Airbnb](https://github.com/airbnb/javascript/blob/master/README.md#control-statements)와 동일합니다.

## 18. Comments

> [Airbnb](https://github.com/airbnb/javascript/blob/master/README.md#comments)와 동일합니다.

## 19. Whitespace

> [Airbnb](https://github.com/airbnb/javascript/blob/master/README.md#whitespace)와 동일합니다.

## 20. Commas

> [Airbnb](https://github.com/airbnb/javascript/blob/master/README.md#commas)와 동일합니다.

## 21. Semicolons

> [Airbnb](https://github.com/airbnb/javascript/blob/master/README.md#semicolons)와 동일합니다.

## 22. Type Casting & Coercion

> [Airbnb](https://github.com/airbnb/javascript/blob/master/README.md#type-casting--coercion)와 동일합니다.

## 23. Naming Conventions

> `23.11 ~ 23.16`를 제외하고 [Airbnb](https://github.com/airbnb/javascript/blob/master/README.md#naming-conventions)와 동일합니다.

- [23.11](#23.11) <a name='23.11'></a>소스의 변수명, 클래스명 등에는 영문 이외의 언어를 사용하지 않습니다.

- [23.12](#23.12) <a name='23.12'></a>한글 발음을 그대로 사용하지 않습니다.

  ```javascript
  // ''무형자산''이라는 의미의 변수를 선언한 예.
  // bad
  const moohyungJasan;

  // good
  const intangibleAssets;
  ```

- [23.13](#22.12) <a name='23.13'></a>클래스, 메서드 등의 이름에는 특수 문자를 사용하지 않습니다.

  ```js
  // bad
  funtion $some() {

  }
  ```

- [23.14](#22.13) <a name='23.14'></a>클래스명과 변수명은 `명사`를 사용합니다.
- [23.15](#22.14) <a name='23.15'></a>메서드명은 `동사`를 사용합니다.
- [23.16](#22.15) <a name='23.16'></a>상수명은 대문자를 사용하고, 단어와 단어사이는 \_로 연결합니다.

  ```js
  // bad
  const firefox = 1;
  const is_left = true;

  // good
  const FIREFOX = 1;
  const IS_LEFT = true;
  ```

## 24. Accessors

> [Airbnb](https://github.com/airbnb/javascript/blob/master/README.md#accessors)와 동일합니다.

## 25. Events

> [Airbnb](https://github.com/airbnb/javascript/blob/master/README.md#events)와 동일합니다.

## 26. jQuery

> [Airbnb](https://github.com/airbnb/javascript/blob/master/README.md#jquery)와 동일합니다.

## 27. Resources

- [Airbnb 자바스크립트 스타일 가이드 - 영문](https://github.com/airbnb/javascript)
- [Airbnb 자바스크립트 스타일 가이드 - 한글](https://github.com/tipjs/javascript-style-guide)
