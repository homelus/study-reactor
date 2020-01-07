# [ReactiveX](http://reactivex.io/intro.html)

ReactiveX 는 [observable sequences](https://en.wikipedia.org/wiki/Observer_pattern) 를 사용해 비동기적이고 이벤트 기반의 프로그램들을 구성하는 라이브러리입니다.

이벤트 및 데이터의 sequences 를 지원하도록 observer pattern 을 확장하고 하위 레벨의 쓰레딩, 동기화, 스레드 안전성, 동시성 데이터 구조,
non-blocking I/O 와 같은 문제를 추상화하면서 sequences 를 선언적으로 구성하도록 허용할 수 있는 연산자를 추가합니다.

#### Observables 는 여러 아이템들을 비동기적인 순서로 접근하는 이상적인 방법으로 간격을 채워나갑니다.
||하나의 아이템|여러개의 아이템|
|---|---|---|
|동기|T getData()|Iterable<T> getData()|
|비동기|Future<T> getData()|Observable<T> getData()|

때때로 "functional reactive programming" 이라고 불리지만 이는 잘못된 이름입니다.
ReactiveX 는 functional 할 수 있고 reactive 할수도 있지만 "function reactive programming" 과는 다른 내용입니다.
차이점 중 하나는 functional reactive programming 이 시간이 지남에 따라 지속적으로 변하는 값에 작동하는 반면 ReactiveX 는
시간이 지남에 따라 전달되는 개별 값에 작동한다는 점입니다. [여기](https://github.com/conal/talk-2015-essence-and-origins-of-frp)를 참고하세요
