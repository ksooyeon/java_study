# 트리(Tree) #

### 개념 ###
![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fxjb2T%2FbtqEVXD2cGD%2FLOr9dROsImFr3gV7XNBuJk%2Fimg.png)  
출처 : https://wonit.tistory.com/196  
  
- 정점(Node)과 선분(Branch)을 이용해 사이클을 이루지 않도록 구성한 그래프
- 비선형, 계층적 구조

-------------------------------------------
### 구성 요소 ###
- Node : 트리의 기본요소, 데이터, 자식노드를 가지고 있다 (A, B, C..)
- Root : 트리의 가장 윗부분에 위치한 노드. 하나의 트리에는 하나의 루트 노드가 존재
- Key : 해당 노드에 있는 데이터
- Edge : 노드와 노드를 연결하는 선
- Leaf Nodes : 트리의 가장 아래에 위치하는 노드
- Siblings : 같은 부모를 갖고 같은 차수에 있는 노드
- Level : 트리의 특정 깊이
- Height : 트리의 높이, 차수(Degree)라고도 한다.
  
-------------------------------------------
### 이진트리 (Binary Tree) ###  
- 자식 노드를 최대 2개 가지는 트리
  
1. 완전 이진트리 (complete binary tree)  
마지막 레벨을 제외하고 모든 자식노드가 채워져있는 트리  
![](https://t1.daumcdn.net/cfile/tistory/996F8E405A74107713)     
출처 : https://sexycoder.tistory.com/81  

2. 포화 이진트리(perfect binary tree)  
모든 노드가 0개 혹은 2개의 자식노드를 가지며 모든 리프노드가 똑같은 레벨에 있는 트리
![](https://t1.daumcdn.net/cfile/tistory/991914425A74646C24)  

3. 정 이진트리(full binary tree)  
모든 노드가 0개 혹은 2개의 자식노드를 가지는 트리. 포화 이진트리의 하위 종류  
![](https://t1.daumcdn.net/cfile/tistory/993E7F3D5A7411D00D)  

4. 편향 이진트리(skewed binary tree)  
노드들이 전부 한 방향으로 편향된 트리  
![](https://t1.daumcdn.net/cfile/tistory/99A211335A74121401)  

-------------------------------------------
### 이진 탐색 트리 (Binary Search Tree) ###  
이진트리이지만 왼쪽 자식노드가 루트노드보다 작고, 오른쪽 자식노드가 루트노드보다 큰 트리  
![](https://t1.daumcdn.net/cfile/tistory/9959833D5A7412A922)  

-------------------------------------------
### 순회 방법 ###  
- 전위 순회(pre-order) : 루트 -> 왼쪽 하위 -> 오른쪽 하위 순으로 순회
- 중위 순회(in-order) : 왼쪽 하위 -> 상위 노드 -> 오른쪽 하위
- 후위 순회(post-order) : 왼쪽 하위 -> 오른쪽 하위 -> 상위 노드

![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbxJkfF%2FbtqHO0KMt0f%2F2kTepCu6RN8reUsE7vG9MK%2Fimg.png)  
출처 : https://readerr.tistory.com/35  

전위 순회 순서 : 1 - 2 - 4 - 5 - 3 - 6 - 7  
중위 순회 순서 : 4 - 2 - 5 - 1 - 6 - 3 - 7  
후위 순회 순서 : 4 - 5 - 2 - 6 - 7 - 3 - 1  
  
-------------------------------------------
### 응용분야 ###
- File System
- HTML tag 구조
- 도-시군구-읍면동 주소체계
- DBMS
- 라우터 통신 알고리즘
- 검색 엔진

