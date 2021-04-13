# 9주차 : 자바의 예외 처리에 대해 학습하세요.

#### 목표

- 자바에서 예외 처리 방법 (try, catch, throw, throws, finally)
- 자바가 제공하는 예외 계층 구조
- Exception과 Error의 차이는?
- RuntimeException과 RE가 아닌 것의 차이는?
- 커스텀한 예외 만드는 방법

------------
### 1. 자바에서 예외 처리 방법 (try, catch, throw, throws, finally)
예외 처리 : 프로그램이 처리되는 동안 특정한 문제가 일어났을 때 처리를 중단하고 다른 처리를 하는 것  
기본적인 구조는 <b>try-catch-finally</b>    
  
- try  
  코드가 실행되는 부분으로, 예외를 잡아내기 위한 부분. 예외 발생 시 catch 블록, 발생하지 않으면 finally 블록 실행.  
- catch  
  try 블록에서 예외 발생 시 catch 블록으로 넘어와 실행되는 부분.  
  - 다중 catch문 : 예외 타입에 따라 여러 catch 블록을 사용할 수 있다.(Java 7부터 가능)  
  - 다중 catch문 사용시 반드시 앞에 나오는 예외 객체 타입이 뒤 객체 타입보다 작아야한다. 앞 객체가 상위 클래스이면 뒤의 예외를 하나의 예외 클래스로 처리할 수 있기 때문.
  ```java
  try{ ... }
  catch(예외타입 변수명1){ ... }
  catch(예외타입 변수명2){ ... }
  
  try{ ... }
  catch(예외타입1 | 예외타입2 변수명) { ... }  // 여러 catch문을 하나의 블록으로 묶을 수 있다.
  
  // 컴파일 에러
  // IOException은 Exception의 자식 클래스이므로 첫 번째 catch 블록에서도 IOException을 처리할 수 있기 때문에 두 번째 블록은 영원히 실행되지 않는다
  try { ... } 
  catch (Exception e) { ... } 
  catch (IOException e) { ... }
  ```
  
- finally  
  필수는 아니나 try-catch 구문에서 예외 발생 유무에 관계 없이 항상 실행되는 블록  
    
- throw  
  인위적으로 예외를 발생시킬 때 사용하는 키워드. 원하는 조건을 만족하지 않을 때 코드를 진행시키지 못하도록 예외를 발생시킬 때 사용한다.
  (라이브러리 만들 때 주로 사용)  
  ```java
  public static void main(String[] args) throws Exception {
		  System.out.println(sumPositiveNum(-1));
	}
  
  // 1부터 N까지의 합 구하는 메소드 
	public static int sumPositiveNum(int N) throws Exception {
      if( N < 0)
        throw new Exception("N은 양의 정수이어야 합니다");

      int sum = 0;
      for(int i =1;i<=N;i++){
        sum += i;
      }
      return sum;
	}
  ```
매개변수로 음수 넘길 시 아래와 같이 예외 발생    
![image](https://user-images.githubusercontent.com/34119641/114515668-8fa61680-9c77-11eb-9edc-049e71d19061.png)  
 
- thorws  
  예외가 발생하는 경우 예외를 발생시킨 메소드의 호출 지점으로 예외를 던져 처리하는 키워드.  
  예제에서 close() 메소드에서 예외 발생. throws 키워드를 통해 main 메소드에게 예외를 처리해달라 의무를 전가한다.  
    
  ```java
  import java.io.*;
  public class Test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.close();
    }
  }
  ```
  
------------
### 2. 자바가 제공하는 예외 계층 구조
![](http://www.tcpschool.com/lectures/img_java_exception_class_hierarchy.png)  
출처 : http://www.tcpschool.com/java/java_exception_class  
  
예외 클래스, 에러 클래스 모두 Throwable 클래스에서 상속받는다.
- Throwable 클래스 : 예외나 에러에 대한 정보 확인할 수 있는 메소드 보유.  
  - getMessage() : 해당 throwable 객체에 대한 자세한 내용을 반환
  - printStackTrace() : 예외나 에러가 발생 할 때까지의 이력을 출력
  - toString() : 해당 throwable 객체의 간단한 내용을 반환
  
- RuntimeException 클래스 및 자식 클래스들은 치명적인 예외 상황 발생시키지 않는다.
- 그러나 Exception 클래스의 자식 클래스들은 치명적인 예외 상황을 발생시키므로 반드시 예외 처리를 해야한다.

  
------------
### 3. Exception과 Error의 차이는?
- 에러 : 메모리 부족, StackOverFlow 등 시스템에 비정상적인 상황이 생겼을 때 발생하는 System level의 문제. 발생 시 복구 불가능  
- 예외 : 개발자가 작성한 로직 내에서 발생한 오류. Application level의 문제. 예외 처리 코드 작성으로 방지 가능.  
  
------------
### 4. RuntimeException과 RE가 아닌 것의 차이는?
RE와 RE가 아닌 것을 구분하는 기준 : CheckedException인지 UncheckedException인지로 판단.  
CheckedException -> 반드시 예외 처리 해줘야 함. UncheckedException -> 예외 처리 강제하지 않음.  
  
- RuntimeException
  * Unchecked Exception
  * 런타임 시 예외 발생, 실행 전에 컴파일 에러를 발생시키지 않는다.
  * NullPointerException, IndexOutOfBoundsException, ArithmeticException 등
  
- 그 외 클래스(RE가 아닌 것)
  * Checked Exception
  * 실행 전 컴파일 단계에서 에러 발생, 반드시 예외 처리를 해줘야 한다.
  * IOException, SQLException 등

------------
### 5. 커스텀한 예외 만드는 방법
기존에 정의된 예외 클래스 외 사용자가 직접 커스텀해 예외를 만들어 처리가 가능하다.  
Exception 클래스 상속받아 사용, 필요에 따라 맞는 예외 클래스를 선택해 사용한다.  

```java
public class customException extends Exception{
	customException() {}
	customException(String msg) {
		super(msg);
	}
}

public class Test {
	public static void main(String[] args){
		String val = "1";
		
		if(val.equals("1")) {
			try {
				throw new customException("makes error");  // 생성자 통해 예외 시 에러메시지 확인 가능
			}
			catch(customException e){
				e.printStackTrace();
				System.out.println("ERR_MSG : "+e.getMessage());  // Throwable 클래스의 getMessage()를 통해 메시지처리
			}
		}
	}
}

```
결과 :   
![image](https://user-images.githubusercontent.com/34119641/114566812-98194400-9cad-11eb-9d57-b67f59ae73b4.png)  

