# 연결리스트 (Linked List) #

### 개념 ###
- 데이터와 포인터로 구성된 노드(node)들이 한 줄로 연결된 데이터의 모음
- 순차적인 공간을 차지하는 배열의 단점을 보완하고자 고안됨
- 노드 : 데이터 저장 단위(데이터값, 포인터)로 구성, 포인터 : 이전/다음 노드와의 연결 정보 가지고 있는 공간  
- 저장된 요소는 비순차적으로 분포, 이러한 요소들 사이를 링크(link)로 연결
  
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
- 