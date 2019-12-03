# study-reactor3
### Reactor3 개인 스터디

Spring 5 의 WebFlux 에는 Reactor3 를 이용한 다양한 기법들이 적용되어 있다.
앞으로 Reactive 형태의 작업들이 등장할 것이고 자주 사용될 것으로 생각한다.

Reference 번역 테스트 코드를 통해 Reactive Streams 기반의 *Mono* 와 *Flux* 를 이해하는 것을 목표로 한다.

> `Mono` 와 `Flux` 는 **Reactive Streams** 의 Publisher로서 생성과 변환 등에 대한 다양한 연산자들을 지원한다. 
> `Mono` 는 하나의 데이터에 대한 작업 흐름을 만드는 반면 `Flux` 는 여러개의 데이터를 처리할 수 있으며
> 이들은 subscribe 을 통해 완료될 수 있다.

## 개요
[Introduce to reactive programming](documents/tech.io/ko/introduce-to-reactive-programming.md) 

## \* 문서 개인 번역

### Reference

- [Reactive Stream Introduction](documents/reference/3.%20Introduction%20to%20Reactive%20Programming.md)
- [Reactor Core Features](documents/reference/4.%20Reactor%20Core%20Features.md)
