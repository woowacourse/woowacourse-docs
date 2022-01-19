# JavaScript Style Guide

우아한테크코스의 자바스크립트 스타일 가이드는 [Airbnb 자바스크립트 스타일 가이드](https://github.com/airbnb/javascript)를 기준으로 작성되었습니다.

## Table of Contents

1. [Types](#types)
2. [References](#references)
3. [Objects](#objects)
4. [Arrays](#arrays)
5. [Destructuring](#destructuring)
6. [Strings](#strings)
7. [Functions](#functions)
8. [Arrow Functions](#arrow-functions)
9. [Classes & Constructors](#classes--constructors)
10. [Modules](#modules)
11. [Iterators and Generators](#iterators-and-generators)
12. [Properties](#properties)
13. [Variables](#variables)
14. [Hoisting](#hoisting)
15. [Comparison Operators & Equality](#comparison-operators--equality)
16. [Blocks](#blocks)
17. [Comments](#comments)
18. [Whitespace](#whitespace)
19. [Commas](#commas)
20. [Semicolons](#semicolons)
21. [Type Casting & Coercion](#type-casting--coercion)
22. [Naming Conventions](#naming-conventions)
23. [Accessors](#accessors)
24. [Events](#events)
25. [jQuery](#jquery)
26. [Resources](#resources)

## Types

> [Airbnb](https://github.com/airbnb/javascript/blob/master/README.md#types)와 동일합니다.

- [1.1](#1.1) <a name='1.1'></a> **Primitives**: primitive type은 그 값을 직접 조작한다.

  - `string`
  - `number`
  - `boolean`
  - `null`
  - `undefined`

  ```javascript
  const foo = 1;
  let bar = foo;

  bar = 9;

  console.log(foo, bar); // => 1, 9
  ```

- [1.2](#1.2) <a name='1.2'></a> **Complex**: 참조형(Complex)은 참조를 통해 값을 조작한다.

  - `object`
  - `array`
  - `function`

  ```javascript
  const foo = [1, 2];
  const bar = foo;

  bar[0] = 9;

  console.log(foo[0], bar[0]); // => 9, 9
  ```

**[⬆ back to top](#table-of-contents)**

## References

> [Airbnb](https://github.com/airbnb/javascript/blob/master/README.md#references)와 동일합니다.

- [2.1](#2.1) <a name='2.1'></a> 변수 선언은 가급적 `const` 를 사용하고, `var` 를 사용하지 않는다. eslint: [`prefer-const`](http://eslint.org/docs/rules/prefer-const.html), [`no-const-assign`](http://eslint.org/docs/rules/no-const-assign.html)

  ```javascript
  // bad
  var a = 1;
  var b = 2;

  // good
  const a = 1;
  const b = 2;
  ```

- [2.2](#2.2) <a name='2.2'></a> 참조를 재할당 해야한다면 `var` 대신 `let` 을 사용한다. eslint: [`no-var`](http://eslint.org/docs/rules/no-var.html) jscs: [`disallowVar`](http://jscs.info/rule/disallowVar)

  ```javascript
  // bad
  var count = 1;
  if (true) {
    count += 1;
  }

  // good, use the let.
  let count = 1;
  if (true) {
    count += 1;
  }
  ```

- [2.3](#2.3) <a name='2.3'></a> `let` 과 `const` 는 선언된 블록 안에서만 존재하는 블록 스코프이다.

  ```javascript
  // const 와 let 은 선언된 블록의 안에서만 존재한다.
  {
    let a = 1;
    const b = 1;
  }
  console.log(a); // ReferenceError
  console.log(b); // ReferenceError
  ```

**[⬆ back to top](#table-of-contents)**

## Objects

> [Airbnb](https://github.com/airbnb/javascript/blob/master/README.md#types)와 동일합니다.

- [3.1](#3.1) <a name='3.1'></a> 오브젝트를 작성할 때는, 리터럴 구문을 사용한다. eslint: [`no-new-object`](http://eslint.org/docs/rules/no-new-object.html)

  ```javascript
  // bad
  const item = new Object();

  // good
  const item = {};
  ```

- [3.2](#3.2) <a name='3.2'></a> 동적 프로퍼티명을 갖는 오브젝트를 작성할 때, 계산된 프로퍼티명(computed property names)을 이용한다.

  ```javascript
  function getKey(k) {
    return `key named ${k}`;
  }

  // bad
  const obj = {
    id: 5,
    name: "San Francisco",
  };
  obj[getKey("enabled")] = true;

  // good
  const obj = {
    id: 5,
    name: "San Francisco",
    ［getKey("enabled")]: true
  };
  ```

- [3.3](#3.3) <a name='3.3'></a> 메서드의 단축 구문을 이용한다. eslint: [`object-shorthand`](http://eslint.org/docs/rules/object-shorthand.html)

  ```javascript
  // bad
  const atom = {
    value: 1,

    addValue: function (value) {
      return atom.value + value;
    },
  };

  // good
  const atom = {
    value: 1,

    addValue(value) {
      return atom.value + value;
    },
  };
  ```

- [3.4](#3.4) <a name='3.4'></a>속성의 단축구문을 이용한다. eslint: [`object-shorthand`](http://eslint.org/docs/rules/object-shorthand.html)

  ```javascript
  const lukeSkywalker = "Luke Skywalker";

  // bad
  const obj = {
    lukeSkywalker: lukeSkywalker,
  };

  // good
  const obj = {
    lukeSkywalker,
  };
  ```

- [3.5](#3.5) <a name='3.5'></a> 속성의 단축 구문은 오브젝트 선언의 시작 부분에 그룹화한다.

  ```javascript
  const anakinSkywalker = "Anakin Skywalker";
  const lukeSkywalker = "Luke Skywalker";

  // bad
  const obj = {
    episodeOne: 1,
    twoJediWalkIntoACantina: 2,
    lukeSkywalker,
    episodeThree: 3,
    mayTheFourth: 4,
    anakinSkywalker,
  };

  // good
  const obj = {
    // 단축 속성 구문 - 시작
    lukeSkywalker,
    anakinSkywalker,
    // 단축 속성 구문 - 끝
    episodeOne: 1,
    twoJediWalkIntoACantina: 2,
    episodeThree: 3,
    mayTheFourth: 4,
  };
  ```

- [3.6](#3.6) <a name='3.6'></a>`-`문자와 같이 속성명으로 지정할수 없는 경우에는 꼭 따옴표를 붙인다. eslint: [`quote-props`](http://eslint.org/docs/rules/quote-props.html)

  ```js
  // bad
  const bad = {
    foo: 3,
    bar: 4,
    "data-blah": 5,
  };

  // good
  const good = {
    foo: 3,
    bar: 4,
    "data-blah": 5,
  };
  ```

- [3.7](#3.7) <a name='3.7'></a>`hasOwnProperty`, `propertyIsEnumerable`, `isPrototypeOf` 와 같은 `Object.prototype` 메서드를 직접적으로 사용하지 않는다. eslint: [`no-prototype-builtins`](http://eslint.org/docs/rules/no-prototype-builtins.html)

  ```javascript
  // bad
  console.log(object.hasOwnProperty(key));

  // good
  console.log(Object.prototype.hasOwnProperty.call(object, key));

  // best
  const has = Object.prototype.hasOwnProperty; // cache the lookup once, in module scope.
  /* or */
  import has from "has";
  // ...
  console.log(has.call(object, key));
  ```

- [3.8](#3.8) <a name='3.8'></a>얕은 복사(shallow-copy)를 하기 위해서 [`Object.assign`](https://developer.mozilla.org/en/docs/Web/JavaScript/Reference/Global_Objects/Object/assign) 보다는 spread 연산자(...)를 선호한다. 오브젝트에서 몇몇 속성을 제거한 새로운 오브젝트를 얻고자 할때는 rest 파라미터(...)를 사용한다.

  ```javascript
  // very bad
  const original = { a: 1, b: 2 };
  const copy = Object.assign(original, { c: 3 }); // this mutates `original`
  delete copy.a; // so does this

  // bad
  const original = { a: 1, b: 2 };
  const copy = Object.assign({}, original, { c: 3 }); // copy => { a: 1, b: 2, c: 3 }

  // good
  const original = { a: 1, b: 2 };
  const copy = { ...original, c: 3 }; // copy => { a: 1, b: 2, c: 3 }

  const { a, ...noA } = copy; // noA => { b: 2, c: 3 }
  ```

**[⬆ back to top](#table-of-contents)**

## Arrays

> `4.4 ~ 5` 항목을 제외하고는 [Airbnb](https://github.com/airbnb/javascript/blob/master/README.md#array)와 동일합니다.

- [4.1](#4.1) <a name='4.1'></a> 배열을 작성 할 때는 리터럴 구문을 사용한다. eslint: [`no-array-constructor`](http://eslint.org/docs/rules/no-array-constructor.html)

  ```javascript
  // bad
  const items = new Array();
  // good
  const items = [];
  ```

- [4.2](#4.2) <a name='4.2'></a> 아이템을 배열에 추가하는 경우, 직접 배열에 항목을 대입하지 말고 [Array#push](https://developer.mozilla.org/en/docs/Web/JavaScript/Reference/Global_Objects/Array/push)를 이용한다.

  ```javascript
  const someStack = [];

  // bad
  someStack[someStack.length] = "abracadabra";

  // good
  someStack.push("abracadabra");
  ```

- [4.3](#4.3) <a name='4.3'></a> 배열을 복사할 때는 배열의 spread 연산자(`...`) 를 이용한다.

  ```javascript
  // bad
  const len = items.length;
  const itemsCopy = [];
  let i;

  for (i = 0; i < len; i++) {
    itemsCopy[i] = items[i];
  }

  // good
  const itemsCopy = [...items];
  ```

- [4.4](#4.4) <a name='4.4'></a>[Airbnb](https://github.com/airbnb/javascript/blob/master/README.md#arrays--from)와 다르게 `array-like 오브젝트를 배열로 변환하는 경우`에 대해서는 별도로 가이드 하지 않는다.

- [4.5](#4.5) <a name='4.5'></a>[Airbnb](https://github.com/airbnb/javascript/blob/master/README.md#arrays--callback-return)와 다르게 `배열의 메서드 콜백`에 대해서는 별도로 가이드 하지 않는다. eslint: [`array-callback-return`](http://eslint.org/docs/rules/array-callback-return.html)

- [4.6](#4.6) <a name='4.6'></a>배열이 멀티 라인인 경우, 배열의 시작(before)과 끝(after)은 개행한다.

  ```javascript
  // bad
  const arr = [
    [0, 1],
    [2, 3],
    [4, 5],
  ];

  const objectInArray = [
    {
      id: 1,
    },
    {
      id: 2,
    },
  ];

  const numberInArray = [1, 2];

  // good
  const arr = [
    [0, 1],
    [2, 3],
    [4, 5],
  ];

  const objectInArray = [
    {
      id: 1,
    },
    {
      id: 2,
    },
  ];

  const numberInArray = [1, 2];
  ```

**[⬆ back to top](#table-of-contents)**

## Destructuring

> [Airbnb](https://github.com/airbnb/javascript/blob/master/README.md#references)와 다르게 별도의 가이드를 제공하지 않습니다.

## Strings

> `6.1`,`6.2` 항목을 제외하고는 [Airbnb](https://github.com/airbnb/javascript/blob/master/README.md#strings)와 동일합니다.

- [6.1](#6.1) <a name='6.1'></a>따옴표는 쌍따옴표를 사용한다. 이스케이프한 경우는 예외로 홑따옴표를 사용할 수 있다. eslint: [`quotes`](http://eslint.org/docs/rules/quotes.html)

  ```javascript
  // bad
  var key = "naver";
  var obj = {
    key: "1",
  };

  // good
  var key = "naver";
  var obj = {
    key: "1",
  };
  ```

- [6.2](#6.2) <a name='6.2'></a>문자열은 `100`자를 넘지 않는다. `100`자가 넘는 긴 문자열인 경우 줄바꿈시 escape 문자(\)를 사용하지 않는다. escape문자 대신 `+` 연산자를 사용한다. ES6의 template strings가 사용 가능한 환경에서는 [6.3](#6.3) 룰을 적용한다.

  ```javascript
  // bad
  const errorMessage =
    "This is a super long error that was thrown because \
  of Batman. When you stop to think about how Batman had anything to do \
  with this, you would get nowhere \
  fast.";

  // good
  const errorMessage =
    "This is a super long error that was thrown because " +
    "of Batman. When you stop to think about how Batman had anything to do " +
    "with this, you would get nowhere fast.";
  ```

- [6.3](#6.3) <a name='6.3'></a> 프로그램에서 문자열을 생성하는 경우는 문자열 연결이 아닌 template strings를 이용한다. eslint: [`prefer-template`](http://eslint.org/docs/rules/prefer-template.html) [`template-curly-spacing`](http://eslint.org/docs/rules/template-curly-spacing)

  ```javascript
  // bad
  function sayHi(name) {
    return "How are you, " + name + "?";
  }

  // bad
  function sayHi(name) {
    return ["How are you, ", name, "?"].join();
  }

  // good
  function sayHi(name) {
    return `How are you, ${name}?`;
  }
  ```

- [6.4](#6.4) <a name='6.4'></a> 절대로 `eval()` 을 사용하지 않는다.

- [6.5](#6.5) <a name='6.5'></a> 문자열에 불필요한 escape 문자를 사용하지 않는다. eslint: [`no-useless-escape`](http://eslint.org/docs/rules/no-useless-escape)

  ```javascript
  // bad
  const foo = "'this' is 'quoted'";

  // good
  const foo = "\"this\" is 'quoted'";
  const foo = `my name is '${name}'`;
  ```

**[⬆ back to top](#table-of-contents)**

## Functions

> `7.1 ~ 2`, `7.11 ~ 14` 항목을 제외하고는 [Airbnb](https://github.com/airbnb/javascript/blob/master/README.md#functions)와 동일합니다.

- [7.1](#7.1) <a name='7.1'></a>함수 스타일에 대해서는 별도의 스타일 가이드를 제공하지 않는다. eslint: [`func-style`](http://eslint.org/docs/rules/func-style)

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

- [7.2](#7.2) <a name='7.2'></a>즉시 실행함수는 함수를 괄호로 감싼다. eslint: [`wrap-iife`](http://eslint.org/docs/rules/wrap-iife.html)

  ```javascript
  // bad
  !function()) {
    console.log("Welcome to the Internet. Please follow me.");
  }();

  // bad
  (function() {
    console.log("Welcome to the Internet. Please follow me.");
  }());

  // good
  (function() {
    console.log("Welcome to the Internet. Please follow me.");
  })();
  ```

- [7.3](#7.3) <a name='7.3'></a> 함수 이외의 블록 (if나 while같은) 안에서 함수를 선언하지 않는다. eslint: [`no-loop-func`](http://eslint.org/docs/rules/no-loop-func.html)

  ```js
  // bad
  let i;
  for (i = 10; i; i--) {
    (function () {
      return i;
    })();
  }

  // bad
  while (i) {
    let a = function () {
      return i;
    };
    a();
  }

  // good
  const a = function () {};
  let i;
  for (i = 10; i; i--) {
    a();
  }
  ```

- [7.4](#7.4) <a name='7.4'></a> [Airbnb](https://github.com/airbnb/javascript/blob/master/README.md#functions--note-on-blocks)와 다르게 `block 내의 함수선언`에 대해서는 별도로 가이드 하지 않는다.

- [7.5](#7.5) <a name='7.5'></a> 절대로 파라미터에 `arguments` 를 지정하지 않는다. 이것은 함수 스코프에 전해지는 `arguments` 오브젝트의 참조를 덮어 버린다.

  ```javascript
  // bad
  function nope(name, options, arguments) {
    // ...stuff...
  }

  // good
  function yup(name, options, args) {
    // ...stuff...
  }
  ```

- [7.6](#7.6) <a name='7.6'></a> 절대 `arguments` 를 이용하지 않는다. 대신에 rest 파라미터(`...`) 를 이용한다. eslint: [`prefer-rest-params`](http://eslint.org/docs/rules/prefer-rest-params.html)

  ```javascript
  // bad
  function concatenateAll() {
    const args = Array.prototype.slice.call(arguments);
    return args.join("");
  }

  // good
  function concatenateAll(...args) {
    return args.join("");
  }
  ```

- [7.7](#7.7) <a name='7.7'></a> 함수의 파라미터를 재정의하지 않는다. 대신 default 파라미터를 이용한다.

  ```javascript
  // really bad
  function handleThings(opts) {
    opts = opts || {};
    // ...
  }

  // still bad
  function handleThings(opts) {
    if (opts === void 0) {
      opts = {};
    }
    // ...
  }

  // good
  function handleThings(opts = {}) {
    // ...
  }
  ```

- [7.8](#7.8) <a name='7.8'></a> side effect 를 유발하는 default 파라미터의 이용을 피한다.

  ```javascript
  var b = 1;
  // bad
  function count(a = b++) {
    console.log(a);
  }
  count(); // 1
  count(); // 2
  count(3); // 3
  count(); // 3
  ```

- [7.9](#7.9) <a name='7.9'></a> 항상 default 파라미터는 뒤쪽에 둔다.

  ```javascript
  // bad
  function handleThings(opts = {}, name) {
    // ...
  }

  // good
  function handleThings(name, opts = {}) {
    // ...
  }
  ```

- [7.10](#7.10) <a name='7.10'></a> 절대 새 함수를 작성하기 위해 Function constructor를 이용하지 않는다. eslint: [`no-new-func`](http://eslint.org/docs/rules/no-new-func)

  ```javascript
  // bad
  var add = new Function("a", "b", "return a + b");

  // still bad
  var subtract = Function("a", "b", "return a - b");
  ```

- [7.11](#7.11) <a name='7.11'></a>익명함수는 function과 괄호 사이에 공백이 없다.
  기명 함수(named function)는 함수 이름과 괄호 사이에 공백이 없다.  
  async arrow function인 경우 async와 arrow function 사이에 공백이 있다.  
  eslint: [`space-before-function-paren`](http://eslint.org/docs/rules/space-before-function-paren) [`space-before-blocks`](http://eslint.org/docs/rules/space-before-blocks)

  ```javascript
  // bad
  const f = function () {};
  const g = function a() {};
  const h = async (v, i) => {};

  // good
  const x = function () {};
  const y = function a() {};
  const z = async (v, i) => {};
  ```

- [7.12](#7.12) <a name='7.12'></a>가급적 mutate parameter는 사용하지 않는다. 하지만, 필요에 의해서는 주의하여 사용한다. eslint: [`no-param-reassign`](http://eslint.org/docs/rules/no-param-reassign.html)

  ```javascript
  // 권장하지 않음.
  function f1(obj) {
    obj.key = 1;
  }
  ```

- [7.13](#7.13) <a name='7.13'></a>파라미터를 재할당하지 않는다. 단, 파라미터의 속성에 대해서는 재할당이 가능하다. eslint: [`no-param-reassign`](http://eslint.org/docs/rules/no-param-reassign.html)

  ```javascript
  // bad
  function f1(a) {
    a = 1;
    // ...
  }

  // bad
  function f2(a) {
    if (!a) {
      a = 1;
    }
    // ...
  }

  // good
  function f3(a) {
    const b = a || 1;
    // ...
  }

  // good
  function f4(a) {
    if (!a) {
      a.b = 1;
    }
    // ...
  }
  ```

- [7.14](#7.14) <a name='7.14'></a>가변함수를 호출할 때는 spread 연산자 (`...`)를 사용한다. eslint: [`prefer-spread`](http://eslint.org/docs/rules/prefer-spread)

  ```javascript
  // bad
  const x = [1, 2, 3, 4, 5];
  console.log.apply(console, x);

  // good
  const x = [1, 2, 3, 4, 5];
  console.log(...x);

  // bad
  new (Function.prototype.bind.apply(Date, [null, 2016, 8, 5]))();

  // good
  new Date(...[2016, 8, 5]);
  ```

- [7.15](#7.15) <a name='7.15'></a>함수의 정의가 멀티라인 인 경우, 오브젝트와 같은 스타일 가이드를 따른다. [19.1](#19.1)을 참조한다.

  ```javascript
  // bad
  function foo(bar, baz, quux) {
    // ...
  }

  // good
  function foo(bar, baz, quux) {
    // ...
  }

  // bad
  console.log(foo, bar, baz);

  // good
  console.log(foo, bar, baz);
  ```

**[⬆ back to top](#table-of-contents)**

## Arrow Functions

> `8.2`, `8.4` 항목을 제외하고는 [Airbnb](https://github.com/airbnb/javascript/blob/master/README.md#arrow-functions)와 동일합니다.

- [8.1](#8.1) <a name='8.1'></a>익명함수를 전달하는 경우, arrow function 표기를 이용한다. eslint: [`prefer-arrow-callback`](http://eslint.org/docs/rules/prefer-arrow-callback.html), [`arrow-spacing`](http://eslint.org/docs/rules/arrow-spacing.html)

  ```javascript
  // bad
  [1, 2, 3].map(function (x) {
    const y = x + 1;
    return x * y;
  });

  // good
  [1, 2, 3].map((x) => {
    const y = x + 1;
    return x * y;
  });
  ```

- [8.2](#8.2) <a name='8.2'></a>함수의 몸체(body)가 단일 표현식이라면 중괄호(`{}`)를 생략하고, 묵시적으로 그 값은 반환값이 된다. 그렇지 않으면, 중괄호(`{}`)는 생략할 수 없고, 반환값이 필요한 경우는 return 을 명시한다. eslint: [`arrow-parens`](http://eslint.org/docs/rules/arrow-parens.html), [`arrow-body-style`](http://eslint.org/docs/rules/arrow-body-style.html)

  ```javascript
  // bad
  [1, 2, 3].map((number) => {
    const nextNumber = number + 1;
    `A string containing the ${nextNumber}.`;
  });

  // good
  [1, 2, 3].map((number) => `A string containing the ${number}.`);

  // good
  [1, 2, 3].map((number) => {
    const nextNumber = number + 1;
    return `A string containing the ${nextNumber}.`;
  });

  // good
  [1, 2, 3].map((number, index) => ({
    [index]: number,
  }));

  // good
  [1, 2, 3].forEach((number) => {
    console.log(nextNumber);
  });
  ```

- [8.3](#8.3) <a name='8.3'></a> 식이 복수행에 걸쳐 있을 경우는 가독성을 더욱 좋게하기 위해 소괄호(`()`)로 감싼다.

  ```js
  // bad
  [1, 2, 3].map(
    (number) =>
      "As time went by, the string containing the " +
      "${number} became much longer. So we needed to break it over multiple " +
      "lines."
  );

  // good
  [1, 2, 3].map(
    (number) =>
      "As time went by, the string containing the ${number} became much " +
      "longer. So we needed to break it over multiple lines."
  );
  ```

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

- [8.5](#8.5) <a name='8.5'></a>arrow function 문법(`=>`)과 비교 연산자 (`<=`, `>=`)를 함께 사용할 경우, 소괄호(`()`)를 이용하여 혼란스럽지 않도록 표현한다. eslint: [`no-confusing-arrow`](http://eslint.org/docs/rules/no-confusing-arrow)

  ```javascript
  // bad
  const itemHeight = (item) =>
    item.height > 256 ? item.largeSize : item.smallSize;

  // bad
  const itemHeight = (item) =>
    item.height > 256 ? item.largeSize : item.smallSize;

  // good
  const itemHeight = (item) =>
    item.height > 256 ? item.largeSize : item.smallSize;

  // good
  const itemHeight = (item) => {
    const { height, largeSize, smallSize } = item;
    return height > 256 ? largeSize : smallSize;
  };
  ```

**[⬆ back to top](#table-of-contents)**

## Classes & Constructors

> [Airbnb](https://github.com/airbnb/javascript/blob/master/README.md#classes--constructors)와 동일합니다.

- [9.1](#9.1) <a name='9.1'></a>`prototype`을 직접 조작하는 것을 피하고 항상 `class`를 이용한다.

  ```javascript
  // bad
  function Queue(contents = []) {
    this._queue = [...contents];
  }
  Queue.prototype.pop = function () {
    const value = this._queue[0];
    this._queue.splice(0, 1);
    return value;
  };

  // good
  class Queue {
    constructor(contents = []) {
      this._queue = [...contents];
    }
    pop() {
      const value = this._queue[0];
      this._queue.splice(0, 1);
      return value;
    }
  }
  ```

- [9.2](#9.2) <a name='9.2'></a>상속은 `extends` 를 이용한다.

  ```javascript
  // bad
  const inherits = require("inherits");
  function PeekableQueue(contents) {
    Queue.apply(this, contents);
  }
  inherits(PeekableQueue, Queue);
  PeekableQueue.prototype.peek = function () {
    return this._queue[0];
  };

  // good
  class PeekableQueue extends Queue {
    peek() {
      return this._queue[0];
    }
  }
  ```

- [9.3](#9.3) <a name='9.3'></a>필요하다면, 메서드의 반환값으로 `this` 를 반환하는 것으로 메서드체이닝을 할 수 있다.

  ```javascript
  // bad
  Jedi.prototype.jump = function () {
    this.jumping = true;
    return true;
  };

  Jedi.prototype.setHeight = function (height) {
    this.height = height;
  };

  const luke = new Jedi();
  luke.jump(); // => true
  luke.setHeight(20); // => undefined

  // good
  class Jedi {
    jump() {
      this.jumping = true;
      return this;
    }

    setHeight(height) {
      this.height = height;
      return this;
    }
  }

  const luke = new Jedi();

  luke.jump().setHeight(20);
  ```

- [9.4](#9.4) <a name='9.4'></a>toString()을 작성하는 것을 허용하지만 올바르게 동작하는 지와 side effect 가 없는지를 꼭 확인한다.

  ```javascript
  class Jedi {
    constructor(options = {}) {
      this.name = options.name || "no name";
    }

    getName() {
      return this.name;
    }

    toString() {
      return `Jedi - ${this.getName()}`;
    }
  }
  ```

- [9.5](#9.5) <a name='9.5'></a>불필요한 빈 default constructor는 사용하지 않는다. eslint: [`no-useless-constructor`](http://eslint.org/docs/rules/no-useless-constructor)

  ```javascript
  // bad
  class Jedi {
    constructor() {}

    getName() {
      return this.name;
    }
  }

  // bad
  class Rey extends Jedi {
    constructor(...args) {
      super(...args);
    }
  }

  // good
  class Rey extends Jedi {
    constructor(...args) {
      super(...args);
      this.name = "Rey";
    }
  }
  ```

- [9.6](#9.6) <a name='9.6'></a>클래스에는 동일 멤버가 있어서는 안된다. eslint: [`no-dupe-class-members`](http://eslint.org/docs/rules/no-dupe-class-members)

  ```javascript
  // bad
  class Foo {
    bar() {
      return 1;
    }
    bar() {
      return 2;
    }
  }

  // good
  class Foo {
    bar() {
      return 1;
    }
  }

  // good
  class Foo {
    bar() {
      return 2;
    }
  }
  ```

**[⬆ back to top](#table-of-contents)**

## Modules

> `10.5`, `10.9` 항목을 제외하고는 [Airbnb](https://github.com/airbnb/javascript/blob/master/README.md#modules)와 동일합니다.

- [10.1](#10.1) <a name='10.1'></a>비표준 모듈시스템이 아닌 (`import`/`export`) 를 항상 사용한다.

  ```javascript
  // bad
  const AirbnbStyleGuide = require("./AirbnbStyleGuide");
  module.exports = AirbnbStyleGuide.es6;

  // ok
  import AirbnbStyleGuide from "./AirbnbStyleGuide";
  export default AirbnbStyleGuide.es6;

  // best
  import {es6} from "./AirbnbStyleGuide";
  export default es6;
  ```

- [10.2](#10.2) <a name='10.2'></a>wildcard import 는 이용하지 않는다.

  ```javascript
  // bad
  import * as AirbnbStyleGuide from "./AirbnbStyleGuide";

  // good
  import AirbnbStyleGuide from "./AirbnbStyleGuide";
  ```

- [10.3](#10.3) <a name='10.3'></a>import 문으로부터 직접 export 하지 않는다.

  ```javascript
  // bad
  // filename es6.js
  export {es6 as default} from "./airbnbStyleGuide";

  // good
  // filename es6.js
  import {es6} from "./AirbnbStyleGuide";
  export default es6;
  ```

- [10.4](#10.4) <a name='10.4'></a>import는 중복되지 않게 한 곳에서 import 한다.
  eslint: [`no-duplicate-imports`](http://eslint.org/docs/rules/no-duplicate-imports)

  ```javascript
  // bad
  import foo from "foo";
  // … some other imports … //
  import { named1, named2 } from "foo";

  // good
  import foo, { named1, named2 } from "foo";

  // good
  import foo, { named1, named2 } from "foo";
  ```

- [10.5](#10.5) <a name='10.5'></a>mutable 객체를 export 하는 것에 대해 강제하지 않는다. eslint: [`import/no-mutable-exports`](https://github.com/benmosher/eslint-plugin-import/blob/master/docs/rules/no-mutable-exports.md)

  ```javascript
  // good
  // let은 변경 가능한 객체
  let foo = {
    a: 10,
  };
  export { foo };

  // good
  // const는 변경 가능하지 않는 객체
  const foo = 3;
  export { foo };
  ```

- [10.6](#10.6) <a name='10.6'></a>export가 하나일 경우, default export를 사용한다.
  eslint: [`import/prefer-default-export`](https://github.com/benmosher/eslint-plugin-import/blob/master/docs/rules/prefer-default-export.md)

  ```javascript
  // bad
  export function foo() {}

  // good
  export default function foo() {}
  ```

- [10.7](#10.7) <a name='10.7'></a>모든 `import`문은 상위에 위치한다.
  eslint: [`import/first`](https://github.com/benmosher/eslint-plugin-import/blob/master/docs/rules/first.md)

  ```javascript
  // bad
  import foo from "foo";
  foo.init();

  import bar from "bar";

  // good
  import foo from "foo";
  import bar from "bar";

  foo.init();
  ```

- [10.8](#10.8) <a name='10.8'></a>멀티 라인 imports 문은 배열이나 오브젝트의 literal과 같이 표현한다. [19.1](#19.1)을 참조한다.

  ```javascript
  // good
  import { longNameA, longNameB, longNameC, longNameD, longNameE } from "path";
  ```

- [10.9](#10.9) <a name='10.9'></a>웹팩 로더 문법 사용에 대해 강제하지 않는다. eslint: [`import/no-webpack-loader-syntax`](https://github.com/benmosher/eslint-plugin-import/blob/master/docs/rules/no-webpack-loader-syntax.md)

  ```javascript
  // good
  import fooSass from "css!sass!foo.scss";
  import barCss from "style!css!bar.css";

  // good
  import fooSass from "foo.scss";
  import barCss from "bar.css";
  ```

**[⬆ back to top](#table-of-contents)**

## Iterators and Generators

> [Airbnb](https://github.com/airbnb/javascript/blob/master/README.md#iterators-and-generators)와 다르게 별도의 가이드를 제공하지 않습니다.

## Properties

> [Airbnb](https://github.com/airbnb/javascript/blob/master/README.md#properties)와 동일합니다.

- [12.1](#12.1) <a name='12.1'></a>프로퍼티에 억세스하는 경우는 점 `.` 을 사용한다. eslint: [`dot-notation`](http://eslint.org/docs/rules/dot-notation.html)

  ```javascript
  const luke = {
    jedi: true,
    age: 28,
  };

  // bad
  const isJedi = luke["jedi"];

  // good
  const isJedi = luke.jedi;
  ```

- [12.2](#12.2) <a name='12.2'></a>변수를 사용해 프로퍼티에 억세스하는 경우는 대괄호(`[]`)를 사용한다.

  ```javascript
  const luke = {
    jedi: true,
    age: 28,
  };

  function getProp(prop) {
    return luke[prop];
  }

  const isJedi = getProp("jedi");
  ```

**[⬆ back to top](#table-of-contents)**

## Variables

> `13.4`, `13.6` 항목을 제외하고는 [Airbnb](https://github.com/airbnb/javascript/blob/master/README.md#variables)와 동일합니다.

- [13.1](#13.1) <a name='13.1'></a>변수를 선언 할 때는 가급적 `const`나 `let`을 사용한다. 그렇게 하지 않으면 글로벌 변수로 선언된다. eslint: [`no-undef`](http://eslint.org/docs/rules/no-undef) [`prefer-const`](http://eslint.org/docs/rules/prefer-const)

  ```javascript
  // bad
  superPower = new SuperPower();

  // good
  const superPower = new SuperPower();
  ```

- [13.2](#13.2) <a name='13.2'></a>변수 선언은 변수당 하나씩 사용한다. eslint: [`one-var`](http://eslint.org/docs/rules/one-var.html)

  ```javascript
  // bad
  const items = getItems(),
    goSportsTeam = true,
    dragonball = "z";

  // bad
  // (compare to above, and try to spot the mistake)
  const items = getItems(),
    goSportsTeam = true;
  dragonball = "z";

  // good
  const items = getItems();
  const goSportsTeam = true;
  const dragonball = "z";
  ```

- [13.3](#13.3) <a name='13.3'></a> 우선 `const` 를 그룹화하고 다음에 `let` 을 그룹화 한다.

  ```javascript
  // bad
  let i,
    len,
    dragonball,
    items = getItems(),
    goSportsTeam = true;

  // bad
  let i;
  const items = getItems();
  let dragonball;
  const goSportsTeam = true;
  let len;

  // good
  const goSportsTeam = true;
  const items = getItems();
  let dragonball;
  let i;
  let length;
  ```

- [13.4](#13.4) <a name='13.4'></a>`let`과 `const`을 사용할 때는 블럭 스코프 이기 때문에, 변수가 사용될 적당한 위치에 변수를 선언한다. 단, `let`과 `const`를 사용할 수 없다면, `var`로 상단에 변수를 선언한다.

  ```javascript
  // bad
  function foo() {
    var i = 0;
    if (i > 0) {
      var j = 0;
    }
  }

  // good
  function foo() {
    var i = 0;
    var j = 0;
    if (i > 0) {
      j = 0;
    }
  }

  // bad - 불필요한 함수 호출
  function checkName(hasName) {
    const name = getName();

    if (hasName === "test") {
      return false;
    }

    if (name === "test") {
      this.setName("");
      return false;
    }

    return name;
  }

  // good
  function checkName(hasName) {
    if (hasName === "test") {
      return false;
    }

    const name = getName();

    if (name === "test") {
      this.setName("");
      return false;
    }

    return name;
  }
  ```

- [13.5](#13.5) <a name='13.5'></a>여러 개의 변수를 한 줄에 동일한 값으로 설정하지 않는다. eslint [`no-multi-assign`](http://eslint.org/docs/rules/no-multi-assign)

  ```javascript
  // bad
  (function example() {
    let a = (b = c = 1);
  })();

  // good
  (function example() {
    let a = 1;
    let b = a;
    let c = a;
  })();
  ```

- [13.6](#13.6) <a name='13.6'></a>++, -- 연산자 사용이 가능하다. 연산자와 피연산자 사이에 공백을 두지 않는다. eslint [`no-plusplus`](http://eslint.org/docs/rules/no-plusplus)

  ```javascript
  // bad
  ++i;
  i++;

  // good
  ++i;
  i++;
  ```

**[⬆ back to top](#table-of-contents)**

## Hoisting

> [Airbnb](https://github.com/airbnb/javascript/blob/master/README.md#hoisting)와 동일합니다.

- [14.1](#14.1) <a name='14.1'></a>`var` 선언은 할당 없이 스코프의 선두에 hoist 된다. `const` 와 `let` 선언은[Temporal Dead Zones (TDZ)](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Statements/let#Temporal_dead_zone_and_errors_with_let) 라고 불리는 새로운 컨셉의 혜택을 받고 있다.

  ```javascript
  // notDefined 가 글로벌변수에 존재하지 않는다고 판정한 경우, 잘 동작하지 않는다.
  function example() {
    console.log(notDefined); // => throws a ReferenceError
  }

  // 그 변수를 참조하는 코드의 뒤에서 그 변수를 선언한 경우
  // 변수가 hoist 된 상태에서 동작한다.
  // 주의：`true` 라는 값 자체는 hoist 되지 않는다.
  function example() {
    console.log(declaredButNotAssigned); // => undefined
    var declaredButNotAssigned = true;
  }

  // 인터프리터는 변수선언을 스코프의 선두에 hoist 한다.
  // 위의 예는 다음과 같이 다시 쓸수 있다.
  function example() {
    let declaredButNotAssigned;
    console.log(declaredButNotAssigned); // => undefined
    declaredButNotAssigned = true;
  }

  // const 와 let 을 이용한 경우
  function example() {
    console.log(declaredButNotAssigned); // => throws a ReferenceError
    console.log(typeof declaredButNotAssigned); // => throws a ReferenceError
    const declaredButNotAssigned = true;
  }
  ```

- [14.2](#14.2) <a name='14.2'></a> 익명 함수의 경우 함수가 할당되기 전의 변수가 hoist 된다.

  ```javascript
  function example() {
    console.log(anonymous); // => undefined

    anonymous(); // => TypeError anonymous is not a function

    var anonymous = function () {
      console.log("anonymous function expression");
    };
  }
  ```

- [14.3](#14.3) <a name='14.3'></a> 기명 함수(named function)의 경우도 똑같이 변수가 hoist 된다. 함수명이나 함수본체는 hoist 되지 않는다.

  ```javascript
  function example() {
    console.log(named); // => undefined

    named(); // => TypeError named is not a function

    superPower(); // => ReferenceError superPower is not defined

    var named = function superPower() {
      console.log("Flying");
    };
  }

  // 함수명과 변수명이 같은 경우도 같은 현상이 발생합니다.
  function example() {
    console.log(named); // => undefined

    named(); // => TypeError named is not a function

    var named = function named() {
      console.log("named");
    };
  }
  ```

- [14.4](#14.4) <a name='14.4'></a> 함수선언은 함수명과 함수본체가 hoist 된다.

  ```javascript
  function example() {
    superPower(); // => Flying

    function superPower() {
      console.log("Flying");
    }
  }
  ```

**[⬆ back to top](#table-of-contents)**

## Comparison Operators & Equality

> [Airbnb](https://github.com/airbnb/javascript/blob/master/README.md#comparison-operators--equality)와 동일합니다.

- [15.1](#15.1) <a name='15.1'></a>`==` 이나 `!=` 보다 `===` 와 `!==` 을 사용한다.

- [15.2](#15.2) <a name='15.2'></a>`if` 문과 같은 조건식은 `ToBoolean` 메서드에 의한 강제형변환으로 평가되어 항상 다음과 같은 심플한 룰을 따른다.

  - **Object** 는 **true** 로 평가된다.
  - **undefined** 는 **false** 로 평가된다.
  - **null** 은 **false** 로 평가된다.
  - **Boolan** 은 **boolean형의 값** 으로 평가된다.
  - **Number** 는 **true** 로 평가된다. 하지만 **+0, -0, or NaN** 의 경우는 **false** 이다.
  - **String** 은 **true** 로 평가된다. 하지만 빈문자 `""` 의 경우는 **false** 이다.

  ```javascript
  if ([0]) {
    // true
    // 배열은 오브젝트이므로 true 로 평가된다.
  }
  ```

- [15.3](#15.3) <a name='15.3'></a>Boolen에 대해서는 단축형을 사용한다.

  ```javascript
  // bad
  if (name !== "") {
    // ...stuff...
  }

  // good
  if (name) {
    // ...stuff...
  }

  // bad
  if (collection.length > 0) {
    // ...stuff...
  }

  // good
  if (collection.length) {
    // ...stuff...
  }
  ```

- [15.4](#15.4) <a name='15.4'></a>비교에 대한 자세한 정보는 [Truth Equality and JavaScript](https://javascriptweblog.wordpress.com/2011/02/07/truth-equality-and-javascript/#more-2108) by Angus Croll. 을 참조한다.

- [15.5](#15.5) <a name='15.5'></a>`case`, `default` 구문에서 `let`, `const`, `function`, `class`가 사용 되는 경우에는 중괄호(`{}`)를 사용한다. eslint rules: [`no-case-declarations`](http://eslint.org/docs/rules/no-case-declarations.html).

  ```javascript
  // bad
  switch (foo) {
    case 1:
      let x = 1;
      break;
    case 2:
      const y = 2;
      break;
    case 3:
      function f() {
        // ...
      }
      break;
    default:
      class C {}
  }

  // good
  switch (foo) {
    case 1: {
      let x = 1;
      break;
    }
    case 2: {
      const y = 2;
      break;
    }
    case 3: {
      function f() {
        // ...
      }
      break;
    }
    case 4:
      bar();
      break;
    default: {
      class C {}
    }
  }
  ```

- [15.6](#15.6) <a name='15.6'></a>중첩 3항 연산자는 사용하지 않는다. eslint rules: [`no-nested-ternary`](http://eslint.org/docs/rules/no-nested-ternary.html).

  ```javascript
  // bad
  const foo = maybe1 > maybe2 ? "bar" : value1 > value2 ? "baz" : null;

  // better
  const maybeNull = value1 > value2 ? "baz" : null;

  const foo = maybe1 > maybe2 ? "bar" : maybeNull;

  // best
  const maybeNull = value1 > value2 ? "baz" : null;

  const foo = maybe1 > maybe2 ? "bar" : maybeNull;
  ```

- [15.7](#15.7) <a name='15.7'></a>불필요한 3항 연산자는 사용하지 않는다. eslint rules: [`no-unneeded-ternary`](http://eslint.org/docs/rules/no-unneeded-ternary.html).

  ```javascript
  // bad
  const foo = a ? a : b;
  const bar = c ? true : false;
  const baz = c ? false : true;

  // good
  const foo = a || b;
  const bar = !!c;
  const baz = !c;
  ```

**[⬆ back to top](#table-of-contents)**

## Blocks

> [Airbnb](https://github.com/airbnb/javascript/blob/master/README.md#blocks)와 다른 가이드를 제공합니다.

- [16.1](#16.1) <a name='16.1'></a>중괄호(`{}`)는 클래스, 메서드, 제어문의 블럭을 구분한다. 중괄호는 클래스 선언, 메서드 선언, 조건/반복문/제어문,줄의 마지막에서 시작한다.

  ```javascript
  // bad
  const Empty = function () {};

  // good
  const Empty = function () {};

  switch (type) {
    case 0:
      break;
    case 1: {
      break;
    }
    default:
      common();
  }

  if (true) {
    return;
  } else if (false) {
    return;
  } else {
  }
  ```

- [16.2](#16.2) <a name='16.2'></a>조건/반복문/제어문에 중괄호 사용한다. 조건/반복문/제어문이 한줄로 끝이라도 중괄호를 활용한다. eslint: [`brace-style`](http://eslint.org/docs/rules/brace-style.html)

  ```javascript
  // bad
  if (exp == null) return false;
  for (var i in obj) if (i === "key") return obj[i];

  // good
  if (exp == null) {
    return false;
  }

  for (var i in obj) {
    if (i === "stop") {
      return obj[i];
    }
  }
  ```

**[⬆ back to top](#table-of-contents)**

## Comments

> [Airbnb](https://github.com/airbnb/javascript/blob/master/README.md#comments)와 동일합니다.

- [17.1](#17.1) <a name='17.1'></a>복수행의 코멘트는 `/** ... */` 을 사용한다. 그 안에는 설명과 모든 파라미터, 반환값에 대해 형이나 값을 기술한다.

  ```javascript
  // bad
  // make() returns a new element
  // based on the passed in tag name
  //
  // @param {String} tag
  // @return {Element} element
  function make(tag) {
    // ...stuff...

    return element;
  }

  // good
  /**
   * make() returns a new element
   * based on the passed in tag name
   *
   * @param {String} tag
   * @return {Element} element
   */
  function make(tag) {
    // ...stuff...

    return element;
  }
  ```

- [17.2](#17.2) <a name='17.2'></a>단일행 코멘트에는 `//` 을 사용한다. 코멘트를 추가하고 싶은 코드의 상부에 배치한다. 또한, 코멘트의 앞에 공백을 넣는다.

  ```javascript
  // bad
  const active = true; // is current tab

  // good
  // is current tab
  const active = true;

  // bad
  function getType() {
    console.log("fetching type...");
    // set the default type to "no type"
    const type = this._type || "no type";

    return type;
  }

  // good
  function getType() {
    console.log("fetching type...");

    // set the default type to "no type"
    const type = this._type || "no type";

    return type;
  }

  // also good
  function getType() {
    // set the default type to "no type"
    const type = this._type || "no type";

    return type;
  }
  ```

- [17.3](#17.3) <a name='17.3'></a>문제를 지적하고 재고를 촉구하는 경우나 문제의 해결책을 제안하는 경우 등, 코멘트의 앞에 `FIXME` 나 `TODO` 를 붙이는 것으로 다른 개발자가 빠르게 이해할 수 있도록 한다. 이런 것들은 어떤 액션을 따른다는 의미이다. 액션이라는 것은 `FIXME -- 해결이 필요` 또는 `TODO -- 구현이 필요` 를 뜻한다.

- [17.4](#17.4) <a name='17.4'></a>문제의 해결이 필요하다는 주석으로써 `// FIXME:` 를 사용한다.

  ```javascript
  class Calculator extends Abacus {
    constructor() {
      super();

      // FIXME: total은 글로벌 변수를 사용해야한다.
      total = 0;
    }
  }
  ```

- [17.5](#17.5) <a name='17.5'></a>구현이 필요하다는 주석으로 `// TODO:` 를 사용한다.

  ```javascript
  class Calculator extends Abacus {
    constructor() {
      super();

      // TODO: total 은 옵션 파라미터로 설정해야한다.
      this.total = 0;
    }
  }
  ```

**[⬆ back to top](#table-of-contents)**

## Whitespace

`18.1`, `18.6`, `18. 11 ~ 13` 항목을 제외하고는 [Airbnb](https://github.com/airbnb/javascript/blob/master/README.md#whitespace)와 동일합니다.

- [18.1](#18.1) <a name='18.1'></a>공백은 탭을 사용한다. eslint: [`indent`](http://eslint.org/docs/rules/indent.html)

  ```javascript
  // bad
  function() {
  ∙∙∙∙var name;
  }

  // bad
  function() {
  ∙var name;
  }

  // good
  function() {
    var name;
  }
  ```

- [18.2](#18.2) <a name='18.2'></a>주요 중괄호 ({}) 앞에는 공백을 1개 넣는다. eslint: [`space-before-blocks`](http://eslint.org/docs/rules/space-before-blocks.html)

  ```javascript
  // bad
  function test() {
    console.log("test");
  }

  // good
  function test() {
    console.log("test");
  }

  // bad
  dog.set("attr", {
    age: "1 year",
    breed: "Bernese Mountain Dog",
  });

  // good
  dog.set("attr", {
    age: "1 year",
    breed: "Bernese Mountain Dog",
  });
  ```

- [18.3](#18.3) <a name='18.3'></a>제어구문 (`if` 문이나 `while` 문 등) 의 소괄호(`()`) 앞에는 공백을 1개 넣는다. 함수선언이나 함수호출시 인수리스트의 앞에는 공백을 넣지 않는다. eslint: [`keyword-spacing`](http://eslint.org/docs/rules/keyword-spacing.html)

  ```javascript
  // bad
  if (isJedi) {
    fight();
  }

  // good
  if (isJedi) {
    fight();
  }

  // bad
  function fight() {
    console.log("Swooosh!");
  }

  // good
  function fight() {
    console.log("Swooosh!");
  }
  ```

- [18.4](#18.4) <a name='18.4'></a>연산자 사이에는 공백을 넣는다. eslint: [`space-infix-ops`](http://eslint.org/docs/rules/space-infix-ops.html)

  ```javascript
  // bad
  const x = y + 5;

  // good
  const x = y + 5;
  ```

- [18.5](#18.5) <a name='18.5'></a>파일 끝에는 개행문자를 1개 넣는다. eslint: [`eol-last`](https://github.com/eslint/eslint/blob/master/docs/rules/eol-last.md)

  ```javascript
  // bad
  (function (global) {
    // ...stuff...
  })(this);
  ```

  ```javascript
  // bad
  (function(global) {
    // ...stuff...
  })(this);↵
  ↵
  ```

  ```javascript
  // good
  (function(global) {
    // ...stuff...
  })(this);↵
  ```

- [18.6](#18.6) <a name='18.6'></a>메서드 체인이 2개를 초과한 경우, 적절히 줄 바꿈을 하여 사용한다. 메서드 체이닝을 하여 줄바꿈을 할 때에는 마침표(.) 다음에 줄 바꿈을 한다. 줄 바꿈 후에는 가독성을 위하여 자동 들여쓰기를 한다. eslint: [`newline-per-chained-call`](http://eslint.org/docs/rules/newline-per-chained-call) [`no-whitespace-before-property`](http://eslint.org/docs/rules/no-whitespace-before-property)

  ```javascript
  // bad
  $("#items").find(".selected").highlight().end().find(".open").updateCount();

  // bad
  $("#items").find(".selected").highlight().end().find(".open").updateCount();

  // good
  $("#items").find(".selected").highlight().end().find(".open").updateCount();

  // bad
  const leds = stage
    .selectAll(".led")
    .data(data)
    .enter()
    .append("svg:svg")
    .classed("led", true)
    .attr("width", (radius + margin) * 2)
    .append("svg:g")
    .attr("transform", `translate(${radius + margin},${radius + margin})`)
    .call(tron.led);

  // good
  const leds = stage
    .selectAll(".led")
    .data(data)
    .enter()
    .append("svg:svg")
    .classed("led", true)
    .attr("width", (radius + margin) * 2)
    .append("svg:g")
    .attr("transform", `translate(${radius + margin},${radius + margin})`)
    .call(tron.led);

  // good
  const leds = stage.selectAll(".led").data(data);
  ```

- [18.7](#18.7) <a name='18.7'></a>문의 앞과 블록의 뒤에는 빈행을 남겨둔다.

  ```javascript
  // bad
  if (foo) {
    return bar;
  }
  return baz;

  // good
  if (foo) {
    return bar;
  }

  return baz;

  // bad
  const obj = {
    foo() {},
    bar() {},
  };
  return obj;

  // good
  const obj = {
    foo() {},

    bar() {},
  };

  return obj;

  // bad
  const arr = [function foo() {}, function bar() {}];
  return arr;

  // good
  const arr = [function foo() {}, function bar() {}];

  return arr;
  ```

- [18.8](#18.8) <a name='18.8'></a>블록에 빈행을 끼워 넣지 않는다. eslint: [`padded-blocks`](http://eslint.org/docs/rules/padded-blocks.html)

  ```javascript
  // bad
  function bar() {
    console.log(foo);
  }

  // also bad
  if (baz) {
    console.log(qux);
  } else {
    console.log(foo);
  }

  // good
  function bar() {
    console.log(foo);
  }

  // good
  if (baz) {
    console.log(qux);
  } else {
    console.log(foo);
  }
  ```

- [18.9](#18.9) <a name='18.9'></a>소괄호(`()`)의 안쪽에 공백을 추가하지 않는다. eslint: [`space-in-parens`](http://eslint.org/docs/rules/space-in-parens.html)

  ```javascript
  // bad
  function bar(foo) {
    return foo;
  }

  // good
  function bar(foo) {
    return foo;
  }

  // bad
  if (foo) {
    console.log(foo);
  }

  // good
  if (foo) {
    console.log(foo);
  }
  ```

- [18.10](#18.10) <a name='18.10'></a>대괄호(`[]`)의 안쪽에 공백을 추가하지 않는다. eslint: [`array-bracket-spacing`](http://eslint.org/docs/rules/array-bracket-spacing.html)

  ```javascript
  // bad
  const foo = [1, 2, 3];
  console.log(foo[0]);

  // good
  const foo = [1, 2, 3];
  console.log(foo[0]);
  ```

- [18.11](#18.11) <a name='18.11'></a>괄호 안에 공백을 삽입하지 않는다. eslint: [`object-curly-spacing`](http://eslint.org/docs/rules/object-curly-spacing.html)

  ```javascript
  // bad
  var obj = {};
  var obj = { a: 2 };
  var arr = [];
  var arr = [1, 2];
  function foo(a, b) {}

  // good
  var obj = {};
  var obj = { a: 2 };
  var arr = [];
  var arr = [1, 2];
  function foo(a, b) {}
  ```

- [18.12](#18.12) <a name='18.12'></a>최대 줄 너비는 `100` 이다.
  고해상도 모니터(해상도 1280\*1024)사용이 보편화 됨에 따라, 최대 줄 사용 너비는 100자까지 가능하다. eslint: [`max-len`](http://eslint.org/docs/rules/max-len.html)

  ```javascript
  // bad
  const foo =
    jsonData &&
    jsonData.foo &&
    jsonData.foo.bar &&
    jsonData.foo.bar.baz &&
    jsonData.foo.bar.baz.quux &&
    jsonData.foo.bar.baz.quux.xyzzy;

  // bad
  $.ajax({
    method: "POST",
    url: "https://www.naver.com/",
    data: { name: "John" },
  })
    .done(() => console.log("Congratulations!"))
    .fail(() => console.log("You have failed this city."));

  // good
  const foo =
    jsonData &&
    jsonData.foo &&
    jsonData.foo.bar &&
    jsonData.foo.bar.baz &&
    jsonData.foo.bar.baz.quux &&
    jsonData.foo.bar.baz.quux.xyzzy;
  ```

- [18.13](#18.13) <a name='18.13'></a>연산식의 경우에는 연산자 후에 줄 바꿈을 한다. 상위 레벨의 깊이에 맞게 들여쓰기를 한다

  ```javascript
  // bad
  const sum = 100 + 200 + 300 + 400 + 500 + 600 + 700 + 800;

  // good
  const sum = 100 + 200 + 300 + 400 + 500 + 600 + 700 + 800;
  ```

**[⬆ back to top](#table-of-contents)**

## Commas

> [Airbnb](https://github.com/airbnb/javascript/blob/master/README.md#commas)와 동일합니다.

- [19.1](#19.1) <a name='19.1'></a>콤마는 뒤에 표기한다. eslint: [`comma-style`](http://eslint.org/docs/rules/comma-style.html)

  ```javascript
  // bad
  const story = [once, upon, aTime];

  // good
  const story = [once, upon, aTime];

  // bad
  const hero = {
    firstName: "Ada",
    lastName: "Lovelace",
    birthYear: 1815,
    superPower: "computers",
  };

  // good
  const hero = {
    firstName: "Ada",
    lastName: "Lovelace",
    birthYear: 1815,
    superPower: "computers",
  };
  ```

- [19.2](#19.2) <a name='19.2'></a>끝에 콤마를 넣는다. eslint: [`comma-dangle`](http://eslint.org/docs/rules/comma-dangle.html)

  ```javascript
  // bad - git diff without trailing comma
  const hero = {
       firstName: "Florence",
  -    lastName: "Nightingale"
  +    lastName: "Nightingale",
  +    inventorOf: ["coxcomb graph", "modern nursing"]
  };

  // good - git diff with trailing comma
  const hero = {
       firstName: "Florence",
       lastName: "Nightingale",
  +    inventorOf: ["coxcomb chart", "modern nursing"],
  };

  // bad
  const hero = {
    firstName: "Dana",
    lastName: "Scully"
  };

  const heroes = [
    "Batman",
    "Superman"
  ];

  // good
  const hero = {
    firstName: "Dana",
    lastName: "Scully",
  };

  const heroes = [
    "Batman",
    "Superman",
  ];
  ```

**[⬆ back to top](#table-of-contents)**

## Semicolons

> [Airbnb](https://github.com/airbnb/javascript/blob/master/README.md#semicolons)와 동일합니다.

- [20.1](#20.1) <a name='20.1'></a>`;`은 문장의 끝에 표기한다. eslint: [`semi`](http://eslint.org/docs/rules/semi.html)

  ```javascript
  // bad
  (function () {
    const name = "Skywalker";
    return name;
  })()(
    // good
    () => {
      const name = "Skywalker";
      return name;
    }
  )();

  // good
  (() => {
    const name = "Skywalker";
    return name;
  })();
  ```

**[⬆ back to top](#table-of-contents)**

## Type Casting & Coercion

> [Airbnb](https://github.com/airbnb/javascript/blob/master/README.md#type-casting--coercion)와 동일합니다.

- [21.1](#21.1) <a name='21.1'></a>문의 선두에서 형의 강제를 수행한다.

- [21.2](#21.2) <a name='21.2'></a>문자열의 경우:

  ```javascript
  //  => this.reviewScore = 9;

  // bad
  const totalScore = this.reviewScore + "";

  // good
  const totalScore = String(this.reviewScore);
  ```

- [21.3](#21.3) <a name='21.3'></a>수치의 경우: `Number` 로 형변환하는 경우는 `parseInt` 를 이용하고, 항상 형변환을 위한 기수를 인수로 넘겨 준다. eslint: [`radix`](http://eslint.org/docs/rules/radix)

  ```javascript
  const inputValue = "4";

  // bad
  const val = new Number(inputValue);

  // bad
  const val = +inputValue;

  // bad
  const val = inputValue >> 0;

  // bad
  const val = parseInt(inputValue);

  // good
  const val = Number(inputValue);

  // good
  const val = parseInt(inputValue, 10);
  ```

- [21.4](#21.4) <a name='21.4'></a>`parseInt`를 사용하는 경우 [성능적인 이유](http://jsperf.com/coercion-vs-casting/3)로 문제가 되면, Bitshift를 사용한다. 이때에는 꼭! Bitshift를 사용한 이유를 주석으로 남긴다.

  ```javascript
  // good
  /**
   * parseInt로 인해 느려졌음
   * Bitshift를 통한 수치로의 문자열 강제 형변환으로 성능을 개선시킴.
   */
  const val = inputValue >> 0;
  ```

- [21.5](#21.5) <a name='21.5'></a>**주의:** Bitshift를 사용하는 경우의 주의사항. 수치는 [64비트 값](http://es5.github.io/#x4.3.19)으로 표현되어 있으나 bitshift 연산한 경우는 항상 32비트 integer 로 넘겨진다.

  ```javascript
  2147483647 >> 0; //=> 2147483647
  2147483648 >> 0; //=> -2147483648
  2147483649 >> 0; //=> -2147483647
  ```

- [21.6](#21.6) <a name='21.6'></a>Boolean의 경우:

  ```javascript
  const age = 0;

  // bad
  const hasAge = new Boolean(age);

  // good
  const hasAge = Boolean(age);

  // good
  const hasAge = !!age;
  ```

**[⬆ back to top](#table-of-contents)**

## Naming Conventions

> `22.2`, `22.4 ~ 5`, `22.10 ~ 15` 항목을 제외하고는 [Airbnb](https://github.com/airbnb/javascript/blob/master/README.md#naming-conventions)와 동일합니다.

- [22.1](#22.1) <a name='22.1'></a>1문자의 이름은 사용하지 않는다. eslint: [`id-length`](http://eslint.org/docs/rules/id-length)

  ```javascript
  // bad
  function q() {
    // ...stuff...
  }

  // good
  function query() {
    // ..stuff..
  }
  ```

- [22.2](#22.2) <a name='22.2'></a>네임스페이스, 오브젝트, 함수 그리고 인스턴스에는 camelCase를 사용한다. eslint: [`camelcase`](http://eslint.org/docs/rules/camelcase.html)

  ```javascript
  // bad
  naver.FOO.bar = function () {};
  const OBJEcttsssss = {};
  const this_is_my_object = {};
  function c() {}

  // good
  naver.foo.bar = function () {};
  const thisIsMyObject = {};
  function thisIsMyFunction() {}
  ```

- [22.3](#22.3) <a name='22.3'></a>클래스나 constructor에는 PascalCase 를 사용한다. eslint: [`new-cap`](http://eslint.org/docs/rules/new-cap.html)

  ```javascript
  // bad
  function user(options) {
    this.name = options.name;
  }

  const bad = new user({
    name: "nope",
  });

  // good
  class User {
    constructor(options) {
      this.name = options.name;
    }
  }

  const good = new User({
    name: "yup",
  });
  ```

- [22.4](#22.4) <a name='22.4'></a>함수명이나 속성명의 앞에 `_`가 있는 경우는 private을 의미한다. 외부에서 접근할 수 있는 경우, 사용하면 안되는 메서드명 또는 속성명은 `_`을 사용한다. 외부에서 접근할 수 없다면, 메서드명 이나 속성명에 `_`을 사용하지 않는다. eslint: [`no-underscore-dangle`](http://eslint.org/docs/rules/no-underscore-dangle.html)

  ```javascript
  // bad - 외부에서 접근할 수 있는 경우, 사용하면 안되는 메서드명 또는 속성명은 `_`을 사용한다.
  class User({
     constructor() {
        privateState: true
     }
     privateMethod() {
     }
     _publicMethod() {
     }
  }

  // good - 외부에서 접근할 수 있는 경우, 사용하면 안되는 메서드명 또는 속성명은 `_`을 사용한다.
  class User({
     constructor() {
        _privateState: true
     }
     _privateMethod() {
     }
     publicMethod() {
     }
  }

  // bad -  외부에서 접근할 수 없다면, 메서드명 이나 속성명에 `_`을 사용하지 않는다.
  (function(){
     var _privateState = true;
     function _privateMethod() {
     }
     function publicMethod() {
        _privateMethod();
     }
  })();

  // good -  외부에서 접근할 수 없다면, 메서드명 이나 속성명에 `_`을 사용하지 않는다.
  (function() {
     var privateState = true;
     function privateMethod() {
     }
     function publicMethod() {
         privateMethod();
     }
  })();
  ```

- [22.5](#22.5) <a name='22.5'></a>가능한 this를 캐싱하지 않는다. arrow functions 또는 [Function#bind](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Function/bind)를 사용한다. jQuery를 사용하는 경우라면, [$.proxy](http://api.jquery.com/jQuery.proxy)를 사용한다.
  만약, this의 참조를 저장하는 경우라면 self 를 사용한다.

  ```javascript
  // bad
  function foo() {
    const self = this;
    return function () {
      console.log(self);
    };
  }

  // bad
  function foo() {
    const that = this;
    return function () {
      console.log(that);
    };
  }

  // good
  function foo() {
    return () => {
      console.log(this);
    };
  }
  ```

- [22.6](#22.6) <a name='22.6'></a>파일을 1개의 `클래스`로 export 하는 경우, 파일명은 클래스명과 완전히 일치시킨다.

  ```javascript
  // file contents
  class CheckBox {
    // ...
  }
  export default CheckBox;

  // in some other file
  // bad
  import CheckBox from "./checkBox";

  // bad
  import CheckBox from "./check_box";

  // good
  import CheckBox from "./CheckBox";
  ```

- [22.7](#22.7) <a name='22.7'></a>Default export가 `함수`일 경우, camelCase를 이용한다. 파일명은 함수명과 동일해야 한다.

  ```javascript
  function makeStyleGuide() {}

  export default makeStyleGuide;
  ```

- [22.8](#22.8) <a name='22.8'></a>`Singleton / function library / 빈 오브젝트`를 export 하는 경우에는 PascalCase를 사용한다.

  ```javascript
  const AirbnbStyleGuide = {
    es6: {},
  };

  export default AirbnbStyleGuide;
  ```

- [22.9](#22.9) <a name='22.9'></a>약어 및 이니셜은 항상 모두 대문자이거나 모두 소문자이어야 한다.

  ```javascript
  // bad
  import SmsContainer from "./containers/SmsContainer";

  // bad
  const HttpRequests = [
    // ...
  ];

  // good
  import SMSContainer from "./containers/SMSContainer";

  // good
  const HTTPRequests = [
    // ...
  ];

  // best
  import TextMessageContainer from "./containers/TextMessageContainer";

  // best
  const Requests = [
    // ...
  ];
  ```

- [22.10](#22.10) <a name='22.10'></a>소스의 변수명, 클래스명 등에는 영문 이외의 언어를 사용하지 않는다.

- [22.11](#22.11) <a name='22.11'></a>한글 발음을 그대로 사용하지 않는다.

  ```javascript
  // ''무형자산''이라는 의미의 변수를 선언한 예.
  // bad
  const moohyungJasan;

  // good
  const intangibleAssets;
  ```

- [22.12](#22.12) <a name='22.12'></a>클래스, 메서드 등의 이름에는 특수 문자를 사용하지 않는다. jQuery 변수의 경우 `$`을 사용하는 것은 예외사항으로 한다.

  ```js
  // bad
  funtion $some() {

  }
  ```

- [22.13](#22.13) <a name='22.13'></a>클래스명과 변수명은 `명사 사용`을 준수한다.
- [22.14](#22.14) <a name='22.14'></a>메서드명은 `동사 사용`을 준수한다.
- [22.15](#22.15) <a name='22.15'></a>상수명은 대문자를 사용하고, 단어와 단어사이는 \_로 연결한다.

  ```js
  // bad
  const firefox = 1;
  const is_left = true;

  // good
  const FIREFOX = 1;
  const IS_LEFT = true;
  ```

**[⬆ back to top](#table-of-contents)**

## Accessors

> [Airbnb](https://github.com/airbnb/javascript/blob/master/README.md#accessors)와 동일합니다.

- [23.1](#23.1) <a name='23.1'></a>프로퍼티를 위한 접근자 (Accessor) 함수는 필수가 아니다.

- [23.2](#23.2) <a name='23.2'></a>접근자 함수가 필요한 경우, `getVal()` 이나 `setVal('hello')` 로 한다.

  ```javascript
  // bad
  dragon.age();

  // good
  dragon.getAge();

  // bad
  dragon.age(25);

  // good
  dragon.setAge(25);
  ```

- [23.3](#23.3) <a name='23.3'></a>프로퍼티가 `boolean` 인 경우, `isVal()` 이나 `hasVal()` 로 한다.

  ```javascript
  // bad
  if (!dragon.age()) {
    return false;
  }

  // good
  if (!dragon.hasAge()) {
    return false;
  }
  ```

- [23.4](#23.4) <a name='23.4'></a> 일관된 경우, `get()` 과 `set()` 으로 함수를 작성해도 좋다.

  ```javascript
  class Jedi {
    constructor(options = {}) {
      const lightsaber = options.lightsaber || "blue";
      this.set("lightsaber", lightsaber);
    }

    set(key, val) {
      this[key] = val;
    }

    get(key) {
      return this[key];
    }
  }
  ```

**[⬆ back to top](#table-of-contents)**

## Events

> [Airbnb](https://github.com/airbnb/javascript/blob/master/README.md#events)와 다르게 별도의 가이드를 제공하지 않습니다.

## jQuery

> `25.3 ~ 4` 항목을 제외하고는 [Airbnb](https://github.com/airbnb/javascript/blob/master/README.md#jquery)와 동일합니다.

- [25.1](#25.1) <a name='25.1'></a>jQuery오브젝트의 변수는 선두에 `$` 를 부여한다.

  ```javascript
  // bad
  const sidebar = $(".sidebar");

  // good
  const $sidebar = $(".sidebar");

  // good
  const $sidebarBtn = $(".sidebar-btn");
  ```

- [25.2](#25.2) <a name='25.2'></a>jQuery의 검색결과를 캐시하여 사용한다.

  ```javascript
  // bad
  function setSidebar() {
    $(".sidebar").hide();

    // ...stuff...

    $(".sidebar").css({
      "background-color": "pink",
    });
  }

  // good
  function setSidebar() {
    const $sidebar = $(".sidebar");
    $sidebar.hide();

    // ...stuff...

    $sidebar.css({
      "background-color": "pink",
    });
  }
  ```

- [25.3](#25.3) <a name='25.3'></a>[Airbnb](https://github.com/airbnb/javascript/blob/master/README.md#jquery--queries)와 다르게 `DOM 검색에 대해서`는 별도로 가이드 하지 않는다.

- [25.4](#25.4) <a name='25.4'></a>[Airbnb](https://github.com/airbnb/javascript/blob/master/README.md#jquery--find)와 다르게 `DOM 검색에 대해서`는 별도로 가이드 하지 않는다.

**[⬆ back to top](#table-of-contents)**

## Resources

- [Airbnb 자바스크립트 스타일 가이드 - 영문](https://github.com/airbnb/javascript)
- [Airbnb 자바스크립트 스타일 가이드 - 한글](https://github.com/tipjs/javascript-style-guide)

**[⬆ back to top](#table-of-contents)**
