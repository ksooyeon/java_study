# 10주차 : 자바의 멀티쓰레드 프로그래밍에 대해 학습하세요.

#### 목표

- Thread 클래스와 Runnable 인터페이스
- 쓰레드의 상태
- 쓰레드의 우선순위
- Main 쓰레드
- 동기화
- 데드락

------------
### 1. Thread 클래스와 Runnable 인터페이스
Thread : 메모리 할당받아 프로세스를 실행하는 단위. 하나의 프로세스에 여러개의 쓰레드로 구성될 수 있다.  
  
Java에서 스레드 생성하는 2가지 방법
1. Thread 클래스 확장  
java.lang.Thread 클래스 상속받아 생성해 사용 가능. run() 메소드 오버라이딩해 Thread를 사용한다.

```java
public class LiveStudyThread extends Thread{
	@Override
	public void run() {
		for(int i=1;i<=5;i++)
			System.out.println("#"+ i +" "+ getName());
	}
}

public class Test {
	public static void main(String[] args){
		LiveStudyThread thread1 = new LiveStudyThread();
		thread1.start();
	}
}

//결과
#1 Thread-0
#2 Thread-0
#3 Thread-0
#4 Thread-0
#5 Thread-0
```

2. Runnable 인터페이스 구현  
Runnable 인터페이스를 구현해 동일한 스레드 기능을 가진 run() 메소드를 작성한다.  
스레드 생성 시 Runnable 타입의 객체로 받은 후 Thread 클래스의 생성자 매개변수로 Runnable 객체를 넣어 사용한다.  

```java
public class RunnableThread implements Runnable{
	@Override
	public void run() {
		for(int i=1;i<=5;i++)
			System.out.println("#"+i+" "+Thread.currentThread().getName());
	}
}

public class Practice {
	public static void main(String[] args){
		Runnable r = new RunnableThread();
		Thread t2 = new Thread(r);
		
		t2.start();
	}
}

//결과
#1 Thread-0
#2 Thread-0
#3 Thread-0
#4 Thread-0
#5 Thread-0
```

클래스는 다중 상속이 불가능한 것에 비해 인터페이스는 여러 인터페이스를 구현해 사용할 수 있으므로  
자바에서 스레드를 사용할 때는 일반적으로 Runnable 인터페이스를 구현해 스레드를 사용하고, 해당 클래스에서 필요한 다른 클래스를 상속받아 사용한다.  
  
------------
### 2. 쓰레드의 상태
![](https://user-images.githubusercontent.com/52314663/105436329-5f676100-5ca2-11eb-88ab-8ff7d8891206.png)  
출처 : https://m.blog.naver.com/PostView.nhn?blogId=qbxlvnf11&logNo=220921178603&proxyReferer=https:%2F%2Fwww.google.com%2F  
  
1. NEW : 객체는 생성되었지만 아직 시작하지 않은 상태
2. RUNNABLE : 쓰레드가 실행중인 상태
3. BLOCKED : 모니터락을 기다리면서 블락된 상태
4. WAITING : 다른 스레드가 특정 작업을 수행할 때까지 무기한 대기중인 상태
5. TIMED-WAITING : 다른 스레드가 지정된 대기시간까지 작업을 수행하길 기다리는 상태
6. TERMINATED : 종료된 상태


------------
### 3. 쓰레드의 우선순위
하나의 프로세스는 여러 쓰레드를 가질 수 있다. 그래서 쓰레드의 작업을 스케줄링 할 필요가 있다.  
<b>우선순위 방법과 Round-Robin 방법 사용.</b>  
  
우선순위 : 1-10까지 숫자가 높을수록 높은 우선순위로 인식. 디폴트 우선순위 = 5, 우선순위 변경 : setPriority() 메소드 이용.  
  
```java
public class RunnableThread implements Runnable{
	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		System.out.println(name+" 시작");
        try {
            // 3초 대기
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name+" 끝");
	}
}

public class ThreadRunner {
    public static void main(String[] args) {
        Thread p1 = new Thread(new RunnableThread());
        p1.setName("number 1");
        p1.setPriority(10);

        Thread p2 = new Thread(new RunnableThread());
        p2.setName("number 2");

        p1.start();
        p2.start();
    }
}

// 결과
number 1 시작
number 2 시작
number 1 끝
number 2 끝

```

------------
### 4. Main 쓰레드
- 프로그램이 시작되면 가장 먼저 시작되는 스레드. 
- 싱글 스레드 : 메인스레드만 실행되는 경우, 작업 종료 시 프로세스도 종료
- 멀티 스레드 : 메인 스레드가 여러 개의 스레드 실행, 메인 스레드 종료되어도 다른 스레드들이 종료되기 전까지 프로세스는 종료되지 않는다
- 기본 우선순위는 5
- join() : 다른 스레드가 종료된 후 메인스레드가 종료되기 위해서 다른 스레드가 종료될 때까지 대기하도록 하는 메소드

```java
public class Test {
	public static void main(String[] args){
		
		Thread mainThread = Thread.currentThread();
		LiveStudyThread rt = new LiveStudyThread();
		
		rt.setName("라이브스터디 스레드");
		rt.start();
		
		try {
			rt.join();
		}
		catch(InterruptedException e) {
            e.printStackTrace();
        }
    System.out.println("메인 스레드 우선순위 : "+mainThread.getPriority());
    System.out.println("메인스레드 종료");
	}
}

// 결과

라이브스터디 스레드 시작
라이브스터디 스레드 끝
메인 스레드 우선순위 : 5
메인스레드 종료

```
  
<데몬 스레드>
- 메인 스레드의 작업을 보조하는 스레드
- 메인 스레드가 종료되면 강제로 종료된다

```java
public class Test {
	public static void main(String[] args){
		
		Thread daemon = new Thread(() ->{ 
			while(true) {
				System.out.println("데몬 스레드 실행중 ");
				try {
					Thread.sleep(30);
				}
				catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		daemon.setDaemon(true);
		daemon.start();
		
		try {
			Thread.sleep(100);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("메인 스레드 종료");
	}
}

// 결과
데몬 스레드 실행중 
데몬 스레드 실행중 
데몬 스레드 실행중 
메인 스레드 종료
```
  
------------
### 5. 동기화
동기화 : 여러 스레드들이 같은 리소스를 사용하려 할 때 다른 스레드는 사용하지 못하도록 해당 리소스에 임계영역을 지정해 lock을 걸어 접근을 제한하는 것.  
  
synchronized : 자바에서 임계 영역 지정하는 키워드  
  
1. Synchronized 메소드
  
```java
public class Calculator{
    private int amount;
    
    public synchronized void plus(int value) {
          amount += value;
    }
    
    public synchronized void minus(int value) {
          amount -= value;
    }
}
```


2. Synchronized 블록
  
```java
public class Calculator{
    private int amount;
    
    public void plus(int value) {
          synchronized(this) {
              amount += value;
          }
    }
    
    public synchronized void minus(int value) {
          synchronized(this) {
              amount -= value;
          }
    }
}
```
  
------------
### 6. 데드락
데드락 : 두 개 이상의 스레드가 Lock을 획득하기 위해 대기하는데, 해당 Lock을 점유 중인 스레드도 다른 Lock을 획득하기 위해 대기하는 경우 두 개의 스레드는 무한히 대기하게 되는 현상.  
(A 스레드가 a 점유/b 대기 중인 상태에서 B 스레드가 b 점유/a 대기하는 상태라 무한히 대기하는 상황)  
  
데드락의 발생 조건  
- 상호 배제 : 자원은 한 번에 한 프로세스만 사용할 수 있어야 한다.
- 점유 대기 : 최소 한 개의 자원을 점유하면서 다른 프로세스가 점유하고 있는 자원을 추가 점유하기 위해 대기하는 프로세스가 있어야 한다.
- 비선점 : 다른 프로세스에 할당된 자원을 강제로 선점할 수 없어야 한다.
- 순환 대기 : 각 프로세스가 순환적으로 다음 프로세스의 자원을 가져야 한다.  
*=> 네 조건이 모두 성립해야 데드락이 발생한다.*

데드락 해결 방법
- 예방 : 발생 조건 중 하나라도 해결하면 데드락이 해결된다
- 회피 : 데드락이 발생하지 않도록 알고리즘을 적용해 해결한다.(예. 은행원 알고리즘, 자원할당 그래프 알고리즘)
- 회복 : 데드락이 발생하면 해결하는 방법
- 무시 : 데드락 해결 시에도 Context Switching이 발생하기 때문에 데드락으로 인한 성능 저하보다 이를 해결하는게 성능 저하가 더 심한 경우 무시하는 방법  
  
  

