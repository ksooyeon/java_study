# 1주차 : 자바 소스 파일(.java)을 JVM으로 실행하는 과정 이해하기

#### 목표

- JVM이란 무엇인가
- 컴파일 하는 방법
- 실행하는 방법
- 바이트코드란 무엇인가
- JIT 컴파일러란 무엇이며 어떻게 동작하는지
- JVM 구성 요소
- JDK와 JRE의 차이

------------


#### 1. JVM이란 무엇인가
자바 가상 머신(Java Virtual Machine): 자바로 작성 된 프로그램을 운영체제에 맞게 실행할 수 있도록 하는 프로그램.  
(단, 자바 가상 머신은 운영체제에 종속적이므로 각 운영체제에 맞는 자바 가상 머신을 설치해야 한다.)  
 
 단점: 자바 가상 머신을 한 단계 더 거쳐야 하므로 상대적으로 실행 속도가 느림.  
  
![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbcIXTU%2FbtqMOyctXyu%2FhntrUedTHkmx1S0HA3QNRK%2Fimg.png)
  
출처: https://www.infoworld.com/article/3272244/what-is-the-jvm-introducing-the-java-virtual-machine.html  

------------

#### 2. 컴파일 하는 방법
자바 컴파일러가 자바로 작성한 소스 코드를 자바 가상 머신이 이해할 수 있는 자바 바이트 코드로 변환(기계어 x).  
  
hello.java 소스코드 작성  
↓  
```
javac hello.java
```
↓   
hello.class 생성

------------

#### 3. 실행하는 방법
```
java hello.class
```
위 명령어 실행 시 클래스로더가 hello.class 파일을 메모리상의 JVM으로 가져온다.  
로딩된 class 파일은 Execution Engine을 통해 해석되고 해석 된 바이트 코드는 Runtime Data Areas에 배치되어 수행이 이루어진다.  

------------

#### 4. 바이트 코드란 무엇인가
바이트 코드란 가상 컴퓨터에서 돌아가는 실행 프로그램을 위한 이진 표현법이다.  
자바 바이트 코드(Java bytecode)란 자바 가상 머신이 이해할 수 있는 언어로 변환된 자바 소스 코드.  
자바 컴파일러에 의해 변환되는 코드의 명령어가 1바이트 크기라서 자바 바이트 코드라고 불리운다.  
확장자는 .class이며 운영체제에 상관없이 JVM만 설치되어 있으면 동일하게 동작한다.

------------

#### 5. JIT 컴파일러란 무엇이며 어떻게 동작하는지
JIT 컴파일러(JUST-IN-TIME compiler)란 프로그램이 실행 중인 런타임에 실제 기계어로 변환해주는 컴파일러를 의미한다.  
동적 번역(dynamic translation)이라고도 불리며 이 기법은 프로그램의 실행 속도를 향상시키기 위해 개발되었다.  
즉, JIT 컴파일러는 자바 컴파일러가 생성한 자바 바이트 코드를 런타임에 바로 기계어로 변환하는 데 사용한다.  

![9949E83D5B73D7EA25](https://user-images.githubusercontent.com/34119641/109104445-510fd780-776f-11eb-89db-5baf6f298342.png)  
출처: https://steady-snail.tistory.com/67  
  
바이트 코드를 바로 네이티브 코드로 만드는 것이 아니라 IR(Intermediate Representation)로 변환하여 최적화를 수행 후 네이티브 코드로 변환한다.  
*컴파일 후 캐싱, 캐시에서 꺼내 사용하고 변경된 부분만 컴파일하기 때문에 수행속도가 interpreter 방식보다 빠름.

------------

#### 6. JVM 구성 요소

![](https://www.skyer9.pe.kr/wordpress/wp-content/uploads/2020/03/20200327-01.png)  
출처: https://jeong-pro.tistory.com/148  
  
1. Class Loader  
자바는 동적으로 클래스를 읽어오므로, 프로그램이 실행 중인 런타임에서야 모든 코드가 자바 가상 머신과 연결된다.  
클래스 로더는 동적으로 클래스를 로딩해주는 역할을 한다.  
  
2. Execution Engine  
클래스 로더에 의해 Rntime Data Area에 적재된 클래스를 기계어로 변환하고 실행한다.  
명령어는 Interpreter 방식으로 하나씩 실행되기도, JIT에 의해 적절한 시간에 전체 바이트코드를 네이티브코드로 변환하여 실행하기도 한다.  
  
3. 가비지 컬렉터(Garbage Collector)  
더는 사용하지 않는 메모리를 자동으로 회수해 준다. 개발자가 따로 메모리를 관리하지 않아도 되므로 손쉬운 프로그래밍을 할 수 있도록 도와준다.  
  
4. Runtime Data Area  
JVM 메모리 영역으로 어플리케이션 실행 시 사용되는 데이터들을 적재하는 영역이다.  

![](https://www.skyer9.pe.kr/wordpress/wp-content/uploads/2020/03/20200327-02.png)  
출처: https://jeong-pro.tistory.com/148  
  
4-1. Method Area  
클래스 정보가 저장되는 공간. 클래스의 메소드 정보, 멤버 변수 이름과 타입, 메소드의 이름과 파라미터, 리턴값, 각종 상수, static 메소드 등  
  
4-2. Heap Area  
new 키워드에 의해 생성되는 클래스와 배열 등이 저장된다. Method Area에 저장된 클래스만 생성 가능, 가비지 컬렉터에 의해 사용되지 않는 클래스 제거.  
  
4-3. Stack Area  
지역 변수, 파라미터, 리턴 값, 연산에 사용되는 임시 값 등이 생성되는 영역.  
클래스 아닌 변수들이 이곳에 저장된다. new로 생성된 클래스의 참조명만 저장된다.  
  
4-4. PC Register  
스레드가 생성될 때마다 생성되며, 현재 실행중인 주소와 명령을 저장한다. 멀티스레드가 동작할 때, 이곳의 정보를 이용해 동시에 여러 스레드를 실행할 수 있다.  
  
4-5. Native Method Stack  
자바 이외의 코드(JNI;Java Native Interface)가 저장되는 공간.  
  
------------

#### 7. JDK와 JRE의 차이  
![](https://i.stack.imgur.com/AaveN.png)  
  
JRE(Java Runtime Environment)는 자바 어플리케이션 수행을 위한 SW이고,  
JDK(Java Development Kit)는 JRE와 개발에 필요한 SW를 모아 놓은 더 큰 범위의 SW이다.  

