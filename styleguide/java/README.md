# Java Style Guide

우아한테크코스의 자바 스타일 가이드는 [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html)를 기준으로
작성되었습니다. ([한글 번역 - 1기 제이](https://github.com/JunHoPark93/google-java-styleguide)
, [한글 번역 - 3기 아마찌](https://newwisdom.tistory.com/m/96))

Google Java Style Guide와 다른 부분만 아래 명시합니다.

---

### 4.2 블럭 들여쓰기: +4 스페이스

새 블록 또는 블록과 유사한 구조(block-like construct)가 열릴 때마다 들여쓰기가 네 칸씩 증가합니다. 블록이 끝나면 들여쓰기는 이전 들여쓰기 단계로 돌아갑니다. 들여쓰기 단계는 블록 전체의 코드와
주석 모두에 적용됩니다.

### 4.4 열 제한: 120

Java 코드의 열 제한은 120자입니다. "문자"는 유니코드 코드 포인트를 의미합니다.

### 4.5.2 들여쓰기 지속은 최소 +8 스페이스

줄 바꿈 시 그 다음 줄은 원래 줄에서 +8 이상 들여씁니다.

### 4.6.1 수직 빈 줄

...

빈 줄은 가독성을 향상시키기 위해서라면 어디든(예를 들면 논리적으로 코드를 구분하기 위해 문장 사이) 사용 될 수 있습니다. 클래스의 첫 번째 멤버나 초기화(initializer) 또는 마지막 멤버 또는 초기화(
initializer) 뒤의 빈 줄은 권장되지도 비권장하지도 않습니다.

> 클래스의 첫 번째 멤버나 초기화(initializer) 앞에 있는 빈줄을 강제하지 않습니다.

...
