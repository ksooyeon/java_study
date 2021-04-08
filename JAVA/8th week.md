# 8주차 : 자바의 인터페이스에 대해 학습하세요.

#### 목표

- 인터페이스 정의하는 방법
- 인터페이스 구현하는 방법
- 인터페이스 레퍼런스를 통해 구현체를 사용하는 방법
- 인터페이스 상속
- 인터페이스의 기본 메소드 (Default Method), 자바 8
- 인터페이스의 static 메소드, 자바 8
- 인터페이스의 private 메소드, 자바 9

------------
### 1. 인터페이스 정의하는 방법
인터페이스(interface) : 메소드에 대한 선언만 한 상태, 모든 메소드를 추상화로 정의한 상태
- interface 키워드 이용해 선언
- 상수와 추상 메소드만 사용 가능
- 장점
  - 동시적인 개발을 통한 개발 시간 단축
  - 확장에 용이
  - 인터페이스 이용해 선언과 구현을 분리함으로써 클래스 간의 결합도에 영향을 미치지 않음
  - 인터페이스는 인스턴스화 할 수 없으므로 생성자가 필요 없음
   
 ```java
 public interface Phone {
    int year = 2021;
    void setSerialNumber(int serialNumber);
 }
 ```

------------
### 2. 인터페이스 구현하는 방법
- implements 키워드 이용해 구현
- 인터페이스에 선언된 추상 메소드는 반드시 오버라이딩해서 사용해야 하며, 인터페이스에 선언된 변수는 상수이므로 변경 불가능
  
```java
public class iPhone implements Phone {
  private int serialNumber;
  
  @Override
  public void setSerialNumber(int serialNumber) {
      this.serialNumber = serialNumber;
  }
  
  public int getSerialNumber() {
      return serialNumber;
  }
}
```
  
------------
### 3. 인터페이스 레퍼런스를 통해 구현체를 사용하는 방법
- 인터페이스 레퍼런스 타입으로 선언된 구현체에서 인터페이스에 선언된 메소드만 사용된다
- 구현체에서 확장된 메소드를 사용하기 위해서는 구현체 타입으로 캐스팅이 필요하다
  

```java
public class PhoneApp {
    public static void main(String[] args) {
        //래퍼런스로 사용하는 방법
        Phone phone = new iPhone();
        phone.setSerialNumber(100);  // Phone 인터페이스의 setSerialNumber 메소드만 사용 가능

        //인스턴스로 사용하는 방법
        iPhone iphone = new iPhone();    // iPhone 클래스의 getSerialNumber() 메소드도 사용 가능
        iPhone.setSerialNumber(200);

        int serialNumber = iPhone.getSerialNumber();
        System.out.println(serialNumber);     // 200 출력
        
				//캐스팅을 통한 구현체 메소드 접근 가능
        int serialNumber1 = ((iPhone) phone).getSerialNumber();
        System.out.println(serialNumber1);        // 100 출력
    }
}
```

------------
### 4. 인터페이스 상속
- 인터페이스는 다른 인터페이스를 상속(확장)할 수 있다
- extends 키워드 사용
- 클래스와 달리 다중 상속을 지원한다
- 상속받는 부모 인터페이스에 중복된 이름의 메소드가 있다면 다중 상속이 불가능하므로 이름을 변경해야 한다
  
```java
public interface Phone {
    int YEAR = 2021;
    void setSerialNumber(int serialNumber);
}

public interface Camera {
    void shootPhoto(int time);
    void shootVideo(int time);
}

public class Galacxy implements Phone, Camera 
    private int serialNumber;
    //Camera Method
    @Override
    public void shootPhoto(int time) {
        System.out.println("Shooting Photo for "+time+" second" );
    }
    @Override
    public void shootVideo(int time) {
        System.out.println("Shooting Video for "+time+" second" );
    }

    //Phone Method
    @Override
    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getSerialNumber() {
        return serialNumber;
    }
}
```

------------
### 5. 인터페이스의 기본 메소드 (Default Method), 자바 8
- Java 8부터 메소드를 미리 구현해 놓을 수 있는 기본 메소드를 지원하기 시작하였다
- 하위 호환성을 지원하기 위해 등장
- 하위 구현체에서 오바리이딩 통해 재정의 하지 않아도 되고 인터페이스에 정의된 그대로 사용할 수 있다

```java
public interface Camera {
    void shootPhoto(int time);
    void shootVideo(int time);
		
		// Default Method
    default void shoot(){
        System.out.println("Camera is shooting");
    }
}
```

------------
### 6. 인터페이스의 static 메소드, 자바 8
- 기본 메소드와 마찬가지로 Java 8부터 인터페이스 내에 기능을 정의하여 사용할 수 있다
- 단, 인터페이스를 구현하는 구현체에서 재정의하여 사용할 수 없다
- 또한 호출 시 <b>인터페이스명.메소드명</b> 형식으로 호출해야 한다.

```java
public interface Camera {
    void shootPhoto(int time);
    void shootVideo(int time);

		// 기본 메소드
    default void shoot(){
        System.out.println("Camera is shooting");
    }

    // static 메소드
    static void stop() {
        System.out.println("Camera has stopped");
    }
}

public class PhoneApp {
    public static void main(String[] args) {
        IPhone iPhone = new IPhone();
				iPhone.shoot();
        
        Camera.stop();
			  iPhone.stop();   //에러
    }
}
```

------------
### 7. 인터페이스의 private 메소드, 자바 9
- 인터페이스 내부에 코드를 구현할 수 있게 되면서 외부 구현체에서 필요한 메소드가 아닌 내부에서만 작동되기를 원하는 메소드도 노출 되는 경우 발생
- 이를 해결하기 위해 private 메소드 지원, 코드 중복 피하고 내부에서 작동하는 메소드에 대해 캡슐화 유지 가능
- 구현체에서 구현 불가능, 자식 인터페이스에서도 상속 불가능
  
```java
public interface Camera {
    void shootPhoto(int time);
    void shootVideo(int time);

    default void setting(){
        int timer = basicTimer();
        int memory = basicMemory();
        System.out.println(timer + "seconds");
        System.out.println("Memory "+memory+"Giga");
    }

    private static int basicTimer(){
        return 10;
    }

    private int basicMemory() {
        return 5;
    }
}
```
