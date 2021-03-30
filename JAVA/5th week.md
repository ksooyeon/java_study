# 5주차 : 자바의 Class에 대해 학습하세요.

#### 목표

- 클래스 정의하는 방법
- 객체 만드는 방법 (new 키워드 이해하기)
- 메소드 정의하는 방법
- 생성자 정의하는 방법
- this 키워드 이해하기
------------
#### 1. 클래스 정의하는 방법
클래스 : 객체를 정의해주는 틀
  - 필드(멤버 변수) : 객체의 속성, 멤버 변수
  - 생성자 : 변수에 초기값 대입하듯 클래스를 초기화 하는 역할
  - 메소드 : 기능(행위), 메소드 내 정의된 행위 실행  
  
<접근 지정자>  

접근지정자|클래스 내부|동일 패키지|하위 클래스|그 외 영역|  
--------|-----|------|------|------
public|O|O|O|O
protected|O|O|O|X
default(생략가능)|O|O|X|X
private|O|X|X|X  
  
<명명규칙>
1. 자바의 식별자는 대소문자를 구분한다.
2. 길이 제한은 없음, 공백 포함 불가능
3. 첫 문자가 문자, '_', '$' 의 특수문자로 시작되어야 함, 숫자로 시작 불가능
4. 자바의 키워드는 사용 불가능

```java
public class Person {            // 접근지정자 class 클래스명으로 클래스 생성
  // 필드
  private String name;
  private int age;
  
  // default 생성자, 파라미터 가진 생성자 있을 시 반드시 명시(없으면 생략 가능)
  public Person() {
  }
  
  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }
  
  //메소드, name 리턴 기능
  public String getName() {
    return name;
  }
}
```

------------
#### 2. 객체 만드는 방법 (new 키워드 이해하기)
- 정의한 클래스를 사용하기 위해서 객체를 만들어야 한다. => "클래스의 인스턴스화"  
- 객체는 <b>new</b> 키워드를 이용해 생성 가능. -> 메모리 힙 영역에 데이터를 저장할 영역 할당 받은 후 해당 영역의 주소를 객체에게 반환.  
  
클래스이름 변수명 = new 클래스이름
```java
Person p1 = new Person();
Person p2 = new Person("Kim", 30);
System.out.println(p2.getName());  // Kim
```
------------
#### 3. 메소드 정의하는 방법
- 정의부 : 접근지정자 리턴타입 메소드명 파라미터(선택)
- 호출부 : 메소드 기능 호출
  
```java
public String getName() {  //정의부
  //호출부
  return name;
}
public void setName(String name) {
  this.name = name;
}
```
  
다형성을 이용해 코드의 변경과 확장을 용이하게 해주는 특징
1. 메소드 오버로딩
- 파라미터의 갯수나 타입이 다르면 동일한 이름의 메소드명을 사용해 메소드를 정의할 수 있는 기법(ex.System.out.println())    
- 매개변수 동일하지만 리턴타입이 다를 경우 오버로딩 성립되지 않는다  
- 하나의 이름으로 다양한 기능을 사용할 수 있으므로 편의성 제공
```java
public String getName() { ...}
public String getName(int age) {...}
```
  
2. 메소드 오버라이딩
- 상위클래스가 정의한 메소드를 하위클래스가 가져와 변경하거나 확장하는 기법(재정의)
- 확장과 변경에 용이
```java
class Person {
  public void print() { System.out.println("사람입니다."); }
}
class Child extends Person {
  @Override
  public void print() { System.out.println("어린이입니다."); }
}

Person person = new Person();
Child child = new Child();

person.print();    // 사람입니다.
child.print();     // 어린이입니다.
```
------------
#### 4. 생성자 정의하는 방법
생성자 : 클래스 생성하고 객체 호출할 때 객체를 초기화하기 위해 사용되는 것  
- 리턴 값을 가지지 않는다
- 생성자는 클래스명과 동일하다
- 모든 클래스는 반드시 생성자가 한개 이상 존재한다
- 클래스 내부에 생성자를 선언하지 않으면 컴파일러가 기본 생성자를 선언해 사용한다
- 명시적 생성자를 사용할 경우 묵시적 생성자를 선언해주어야 한다(이미 생성자가 선언되어 있으므로 기본 생성자가 생성되지 않기 때문)  
- 생성자의 종류
  - 기본 생성자 : 클래스 내부에 선언된 생성자가 없는 경우 객체 생성 시 컴파일러가 자동으로 추가해주는 생성자
  - 묵시적 생성자 : 파라미터 값을 가지지 않는 생성자
  - 명시적 생성자 : 파라미터 값을 가지는 생성자  
  
```java
class Person() {}   // 기본 생성자
class Person() {
  
  public Person() {...}  // 묵시적 생성자
  public Person(String name, int age) {...}  // 명시적 생성자
  
}
```
------------
#### 5. this 키워드 이해하기
this : 클래스가 인스턴스화 되었을 때 자기 자신의 메모리 주소를 가지고 있고 이를 나타내는 키워드.  
(메소드를 통해 넘어온 파라미터의 변수명과 동일할 경우 클래스 내 필드명과 구분해준다)  
  
- this()는 클래스 내부에서 생성자를 호출한다.  
: this()는 호출하는 곳의 첫 번째 문장에서 호출되어야 한다.   
생성자가 파라미터가 있는 경우 this()안에 생성자 파라미터 타입에 맞게 직접 입력하여 사용할 수 있다.  
  
```java
class Person() {
  private String name;
  
  public Person(String name) {
    this.name = name;     // 클래스 필드 name = 파라미터 name
  }
  
  public Person(String name) {
    this(name + "입니다.");
  }
}
```
-----------------------
#### 과제 (Optional)
- int 값을 가지고 있는 이진 트리를 나타내는 Node 라는 클래스를 정의하세요.
- int value, Node left, right를 가지고 있어야 합니다.
- BinrayTree라는 클래스를 정의하고 주어진 노드를 기준으로 출력하는 bfs(Node node)와 dfs(Node node) 메소드를 구현하세요.
- DFS는 왼쪽, 루트, 오른쪽 순으로 순회하세요.
  
Node.java
```java
public class Node {
	private int value;
	private Node left;
	private Node right;
	
	public Node(int value, Node left, Node right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}
}
```
  
BinaryTree.java  
```java
import java.util.*;

public class BinaryTree {
	private Node root;
	
	public BinaryTree(Node root) {
		this.root = root;
	}
	
	public Node getRoot() {
		return root;
	}
	
	public void BFS(Node root) {
		Queue<Node> q = new LinkedList<>();
		
		q.offer(root);
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			System.out.print(node.getValue() + " ");
			
			if(node.getLeft() != null)
				q.offer(node.getLeft());
			if(node.getRight() != null)
				q.offer(node.getRight());
		}
		System.out.println();
	}
	
	public void DFS(Node root) {
		if(root == null)
			return;
		DFS(root.getLeft());
		System.out.print(root.getValue()+ " ");
		DFS(root.getRight());
	}
}
```
  
BinaryTreeTest.java
```java
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BinaryTreeTest {
	private static Node root;
	private static BinaryTree bnTree;
	
	@BeforeEach
	void setUp() throws Exception {                                              //              1  
		Node node10 = new Node(10, null, null);                                  //         2         3
		Node node9 = new Node(9, null, null);                                    //      4        5       6
		Node node8 = new Node(8, node10, null);                                  //   7                 8
		Node node7 = new Node(7, null, node9);                                   //     9            10
		Node node6 = new Node(6, node8, null);
		Node node5 = new Node(5, null, null);
		Node node4 = new Node(4, node7, null);
		Node node3 = new Node(3, node5, node6);
		Node node2 = new Node(2, node4, null);
		Node node1 = new Node(1, node2, node3);
		
		bnTree = new BinaryTree(node1);
		root = bnTree.getRoot();
	}

	@Test
	@DisplayName("root 값 출력")
	void getRoot() {
		Assertions.assertEquals(1, bnTree.getRoot().getValue());
	}
	
	@Test
	@DisplayName("BFS 테스트")
	void BFS() {
		bnTree.BFS(root);                         // 1 2 3 4 5 6 7 8 9 10
	}
	
	@Test
	@DisplayName("DFS 테스트")
	void DFS() {
		bnTree.DFS(root);                         // 7 9 4 2 1 5 3 10 8 6
	}

}
```
