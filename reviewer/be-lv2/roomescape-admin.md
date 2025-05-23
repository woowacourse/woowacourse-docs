# 방탈출 예약 관리

---

## 리뷰어 가이드

이번 미션에서는 사용자의 요청을 받고 이 요청을 처리하는 간단한 웹 애플리케이션을 만들어 봅니다. 
크루들은 이 과정에서 웹 프로그래밍과 스프링이라는 프레임워크를 스프링을 처음으로 사용하는 상태입니다.

이번 미션의 가장 큰 목표는 **'First Try'** 입니다. 학습 목표 이상의 우아한 구현과 탐구는 불필요한 단계입니다.
학습 목표를 넘어선 키워드 제시는 이후를 위해 아껴두시고, 이번 미션에서 학습해야할 것들을 충실히 했는지 확인해 주세요. (크루의 질문이 들어왔을 때에도 이후 학습 내용이라 언급하고 넘기시면 됩니다.)

테스트의 경우, 별도의 도구 없이 JUnit 기반의 단위 테스트만으로 구현해보도록 구성되어 있습니다.
이를 통해 테스트 과정에서의 불편함과 한계를 직접 경험하고, 무엇을 어떻게 테스트해야 할지 스스로 고민해보는 것이 중요한 학습 목표입니다.
도구 없이 겪는 어려움 자체가 의미 있는 학습이므로, 도구를 소개하거나 도와주기보다는 그 과정에서 어떤 고민이 있었는지를 물어봐 주세요.

현업자의 시선에서는 아직 부족할 수 있지만, 처음으로 웹 애플리케이션을 개발하고 완성해낸 것을 격려해 주세요.
누구나 초보자였던 시절이 있고, 그 첫 완성의 순간은 오래 기억에 남는 설레는 경험이니까요.

---

## 경험해야할 학습 목표

- 로컬 환경(localhost)에서 웹 애플리케이션을 실행 및 테스트
- 스프링부트 프레임워크를 사용해 웹 요청을 받고 응답하기
- 웹 애플리케이션에서 DB에 데이터를 저장하고 조회하기
- 스프링 빈의 의존성 주입이 무엇인지 알고, 코드에 적용
- 소프트웨어 개발에 일반적으로 적용되는 계층형 아키텍쳐(Layered Architecture)를 알고, 코드에 적용
- `학습 테스트`를 활용해 새로운 기능을 학습
- 웹 애플리케이션 개발 시 JUnit 만으로 테스트 할 때의 한계를 경험하고, 추가적인 테스트 도구와 방법의 필요성을 체감하기

---

## 리뷰 포인트

단계에 상관 없이 아래 내용이 잘 적용되어 있는지 확인해 주세요.
- 작성한 모든 테스트 코드가 통과하는가?
  - 테스트 커버리지보다는 객체에 대한 단위테스트를 잘 작성했는지 확인
  - Spring 환경에서 테스트가 어렵다고 느끼는 지점이 있었는지 질문
- 로컬에서 서버를 실행하여 페이지에 접근했을 때, 모든 기능 요구사항이 정상적으로 동작하는가?
- 레벨1에서 학습했던 클린코드의 원칙이 잘 적용되어있는가?

### 1~3단계

- 웹 요청/응답 처리 시 스프링이 제공하는 기능을 정확하게 사용하는가?
  - 요청에 응답하기 위해 제공하는 어노테이션이 여러가지라면 왜 이런 어노테이션을 사용했지 질문하기
- 사전 지식으로 인해 당연하게 쓰는 코드가 있다면 왜 이 코드를 사용했는지 물어보기
  - 예를 들어, 컨트롤러에서 응답을 위해 `ResponseEntity` 를 사용했을 경우, 왜 사용했는지 혹은 다른 방법은 없었는지 질문 (참고: 이번 미션에서는 Http Status를 세분화하여 구현하는 요구사항은 없음)
  - 미리 계층을 나누어 구현 할 경우 왜 필요한지 물어봐서 맹목적으로 작성하는 패턴화된 코드에 대한 경각심을 주기

### 4~9단계

- 데이터베이스 접근 시 스프링이 제공하는 기능을 정확하게 사용하는가?
- 객체 관리를 위해 스프링이 제공하는 기능을 정확하게 사용하는가?
- 계층의 역할과 책임을 잘 알고 구현했는가? 
  - 만약 빈약한 계층이 있다면 해당 계층이 꼭 필요한지를 물어봐서 맹목적으로 작성하는 패턴화된 코드에 대한 경각심을 주기
- 코드의 구조가 일관성을 가지고 있는가?
- JUnit 기반의 단위 테스트를 시도하고, 어떤 것을 깨달았는가?

### 10단계 (선택)

- 콘솔 애플리케이션과 웹 애플리케이션에서의 중복코드가 적절히 제거되었는가?
- 비즈니스 로직이 콘솔이나 웹에 의존적이여서 재사용에 용이하지 않은 코드가 있지는 않는가?
