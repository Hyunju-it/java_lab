# Java 활용 마스터를 위한 상세 로드맵

이 문서는 Java 언어와 핵심 라이브러리(Core API)를 깊이 있게 이해하고 자유자재로 활용하는 것을 목표로 하는 **상세 학습 로드맵**입니다. 각 주제에 대해 구체적인 학습 목표와 실습 과제를 제시하여, Java 언어 자체의 전문가가 되는 길을 안내합니다.

---

## 1. Java 언어 심층 탐구 (Language Deep Dive)

*목표: Java 언어의 명세(JLS)를 깊이 이해하고, 모던 Java의 기능을 능숙하게 사용하여 간결하고 효율적인 코드를 작성한다.*

-   **객체 지향 원리(OOP)와 디자인 패턴**
    -   **학습 목표**: SOLID 원칙을 실제 코드에 적용하여 유연하고 유지보수하기 좋은 설계를 한다.
    -   **세부 주제**:
        -   `LSP` (리스코프 치환 원칙): `instanceof` 사용을 지양하고 다형성으로 해결하는 방법.
        -   `ISP` (인터페이스 분리 원칙): 기능에 따라 인터페이스를 분리하여 클라이언트 입장에서의 명확성 확보.
        -   `DIP` (의존관계 역전 원칙): 구체 클래스가 아닌 추상화(인터페이스)에 의존하는 코드 작성.
    -   **실습**: 간단한 주문 시스템을 SOLID 원칙을 모두 적용하여 리팩토링하기.

-   **제네릭(Generics) 마스터**
    -   **학습 목표**: 제네릭의 동작 원리를 이해하고, 타입 안정성이 높은 유연한 코드를 작성한다.
    -   **세부 주제**:
        -   `PECS` (`Producer-Extends, Consumer-Super`): `? extends T`와 `? super T`의 명확한 구분과 사용.
        -   Type Erasure: 제네릭이 컴파일 타임에 어떻게 동작하고, 런타임에 어떤 제약이 생기는지 이해.
        -   제네릭 메소드, 제네릭 클래스, 중첩 제네릭 활용.
    -   **실습**: 제네릭을 사용하여 `List`를 복사하는 유틸리티 메소드 `copy(List<? super T> dest, List<? extends T> src)` 구현하기.

-   **모던 Java 기능 (Java 8 ~ 21+)**
    -   **학습 목표**: 최신 Java 버전의 핵심 기능을 활용하여 생산성과 코드 품질을 높인다.
    -   **세부 주제**:
        -   `Records` (Java 16): 불변(Immutable) 데이터 객체를 간결하게 정의하고 활용하기.
        -   `Sealed Classes` (Java 17): 상속 가능한 클래스를 제한하여 도메인 모델의 안정성 확보.
        -   `Pattern Matching for instanceof` (Java 16+): `if (obj instanceof String s)` 구문을 통한 코드 간소화.
        -   `Text Blocks` (Java 15): 멀티라인 문자열을 깔끔하게 관리.
    -   **실습**: JSON과 유사한 데이터 구조를 `Record`와 `Sealed Class`를 조합하여 모델링하기.

---

## 2. 동시성 프로그래밍 (Concurrency Programming)

*목표: Java 메모리 모델을 이해하고, `java.util.concurrent`와 가상 스레드를 활용하여 안전하고 성능 좋은 멀티스레드 애플리케이션을 개발한다.*

-   **Java 메모리 모델(JMM)과 동기화**
    -   **학습 목표**: `volatile`, `synchronized`의 동작 원리를 JMM 관점에서 설명할 수 있다.
    -   **세부 주제**:
        -   가시성(Visibility), 원자성(Atomicity), 순서성(Ordering) 문제.
        -   `happens-before` 관계의 이해.
        -   `volatile` 키워드의 역할: 가시성 보장 및 일부 순서성 보장.
        -   `synchronized` 블록과 메소드의 동작 원리 (Monitor Lock).
    -   **실습**: `volatile` 키워드 없이 멀티스레드 환경에서 공유 변수 값의 불일치가 발생하는 코드와, `volatile`로 해결하는 코드 작성하기.

-   **`java.util.concurrent` 패키지 정복**
    -   **학습 목표**: 스레드 풀과 동기화 도구를 목적에 맞게 사용하여 동시성 문제를 해결한다.
    -   **세부 주제**:
        -   `ExecutorService`: `newFixedThreadPool`, `newCachedThreadPool`의 차이와 올바른 사용법.
        -   `Future`와 `CompletableFuture`: 비동기 작업의 결과를 다루고, 콜백, 조합, 에러 처리를 능숙하게 수행.
        -   `ReentrantLock`, `ReadWriteLock`: `synchronized`보다 유연한 락킹 메커니즘 활용.
        -   `Semaphore`, `CountDownLatch`, `CyclicBarrier`: 스레드 간의 실행 흐름 제어.
    -   **실습**: `CompletableFuture`를 사용하여 여러 개의 외부 API 호출을 비동기적으로 실행하고, 모든 결과가 오면 조합하여 반환하는 로직 구현하기.

-   **가상 스레드 (Virtual Threads)**
    -   **학습 목표**: 가상 스레드의 개념을 이해하고, I/O 바운드 작업의 성능을 극대화한다.
    -   **세부 주제**:
        -   플랫폼 스레드 vs 가상 스레드: 차이점과 사용 시나리오.
        -   `Thread.ofVirtual().start()`를 이용한 가상 스레드 생성 및 실행.
        -   `Structured Concurrency` (Preview): 여러 스레드의 작업을 하나의 단위로 묶어 관리.
    -   **실습**: 기존 `ExecutorService`를 사용한 Blocking I/O 기반의 웹 서버를 가상 스레드 기반으로 변경하여 성능 비교하기.

---

## 3. I/O & NIO

*목표: Blocking I/O와 Non-blocking I/O의 차이를 이해하고, NIO를 사용하여 고성능 네트워킹 애플리케이션의 기반을 만든다.*

-   **`java.io` (Blocking I/O)와 `java.nio` (Non-blocking I/O)**
    -   **학습 목표**: 두 패러다임의 차이를 설명하고, 상황에 맞는 I/O 모델을 선택한다.
    -   **세부 주제**:
        -   Stream-based vs Buffer-based: `java.io`와 `java.nio`의 근본적인 데이터 처리 방식 차이.
        -   Blocking vs Non-blocking: 스레드가 대기하는 방식의 차이.
-   **NIO 핵심 컴포넌트: Buffer, Channel, Selector**
    -   **학습 목표**: NIO의 3대 컴포넌트를 사용하여 이벤트 기반의 I/O 로직을 구현할 수 있다.
    -   **세부 주제**:
        -   `ByteBuffer`: `allocate()` vs `allocateDirect()`. `flip()`, `rewind()`, `clear()` 메소드의 정확한 역할.
        -   `FileChannel`: 파일에 대한 랜덤 액세스 및 파일 락킹.
        -   `Selector`와 `SelectionKey`: `OP_READ`, `OP_WRITE` 등 이벤트를 등록하고, 단일 스레드에서 여러 채널을 효율적으로 관리.
    -   **실습**: `Selector`를 사용하여 여러 클라이언트의 연결을 동시에 처리하는 간단한 Non-blocking 에코(Echo) 서버 구현하기.

---

## 4. JVM과 성능 최적화 (JVM & Performance Tuning)

*목표: JVM의 내부 동작을 이해하고, 프로파일링 툴을 사용하여 애플리케이션의 성능 병목을 찾아내고 해결한다.*

-   **가비지 컬렉션 (GC) 분석 및 튜닝**
    -   **학습 목표**: GC 로그를 분석하여 애플리케이션의 메모리 사용 패턴을 파악하고, GC 옵션을 조절하여 성능을 개선한다.
    -   **세부 주제**:
        -   Minor GC vs Major GC (Full GC).
        -   GC 로깅 옵션 (`-Xlog:gc*:file=gc.log:time,level,tags:filecount=5,filesize=10m`).
        -   G1GC의 핵심 파라미터 (`-XX:MaxGCPauseMillis`, `-XX:G1HeapRegionSize`) 튜닝.
    -   **실습**: 일부러 메모리 누수를 발생시키는 코드를 작성하고, VisualVM이나 MAT(Memory Analyzer Tool)를 사용하여 원인 분석하기.

-   **JIT 컴파일과 프로파일링**
    -   **학습 목표**: 내 코드가 어떻게 최적화되는지 이해하고, 프로파일링 툴을 통해 성능 병목 지점을 정확히 찾아낸다.
    -   **세부 주제**:
        -   JIT 컴파일의 단계와 Escape Analysis 같은 최적화 기법.
        -   JFR (Java Flight Recorder)와 JMC (JDK Mission Control)를 사용한 저부하 프로파일링.
        -   `async-profiler`를 이용한 On-CPU, Off-CPU 분석.
    -   **실습**: 특정 메소드에 부하를 준 뒤, JMC를 사용하여 Hot Method를 찾아내고 코드 개선 후 성능 변화 측정하기.

---

> 이 로드맵은 '어떻게'를 넘어 '왜'를 탐구하는 데 초점을 맞춥니다. 각 주제에 대해 제시된 실습 과제를 직접 코드로 구현하며 깊이 있는 지식을 체득하시길 바랍니다.