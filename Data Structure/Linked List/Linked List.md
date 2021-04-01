# 연결리스트 (Linked List) #

### 개념 ###
- 데이터와 포인터로 구성된 노드(node)들이 한 줄로 연결된 데이터의 모음
- 순차적인 공간을 차지하는 배열의 단점을 보완하고자 고안됨
- 노드 : 데이터 저장 단위(데이터값, 포인터)로 구성, 포인터 : 이전/다음 노드와의 연결 정보 가지고 있는 공간  
- 저장된 요소는 비순차적으로 분포, 이러한 요소들 사이를 링크(link)로 연결
- 인덱스가 없으므로 탐색 속도가 떨어짐
- 데이터 추가/삭제 -> 연결리스트, 탐색/정렬 -> 배열  
  
------------------------------------- 
### 종류 ###
1. 단일 연결 리스트  
![](http://www.tcpschool.com/lectures/img_java_singly_linked_list.png)  
출처 : http://www.tcpschool.com/java/java_collectionFramework_list  
  
  - 요소의 저장과 삭제 작업이 다음 요소를 가리키는 참조만 변경하므로 처리 속도가 빠름
  - 그러나 현재 요소에서 이전 요소로의 접근이 어려움

2. 이중 연결 리스트  
![](http://www.tcpschool.com/lectures/img_java_doubly_linked_list.png)  
  
  - 단일 연결 리스트의 단점 때문에 보다 자주 사용됨
  -  두 개의 포인터가 각각 앞, 뒤 노드를 가리킴

------------------------------------- 
### 메소드 ###
- boolean add(Object o) : 데이터 추가
- void claer() : 모든 요소 삭제
- boolean contains(Object o) : 객체가 Linked List에 포함되어 있는지 확인
- int indexof(Object o) : 지정된 객체가 저장된 위치를 반환
- peek() : 첫 번째 요소 반환, peek() : 첫 번째 요소 반환 후 삭제
- boolean remove(Objct o) : 인자로 전달된 객체를 현재 Queue에서 최초로 검출된 요소를 삭제
- List subList(int fromIndex, int toIndex) : Linked List의 일부를 List로 반환
