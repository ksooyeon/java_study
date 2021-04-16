

// 위상정렬 : 순서가 정해져 있는 작업을 차례로 수행해야 할 때 그 순서를 결정하는 알고리즘
// - 여러 개의 답이 존재 가능하다
// - DAG(방향있고 싸이클 없는 그래프)에서만 적용 가능하다

// 1. 진입차수(특정노드로 들어오는 다른 노드의 개수가)가 0인 노드를 큐에 삽입한다
// 2. 큐에서 원소를 꺼내 연결된 간선을 모두 제거한다. 이 때, 간선을 제거한 후 노드들의 진입차수를 갱신한다.
// 3. 진입차수가 0이 된 노드들을 다시 큐에 삽입한다.
// 4. 큐가 빌 때까지 2~3의 과정을 반복한다.

// 결과 : 모든 원소를 방문했다면 큐에서 꺼낸 결과가 위상정렬 결과이다.(모든 원소 방문 전 큐가 비었다면 사이클이 존재)



class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        int[] indegree = new int[numCourses];

        Queue<Integer> q = new LinkedList<Integer>();
        int count = numCourses;

        for(int i=0;i<numCourses;i++)
          map.put(i, new ArrayList<Integer>());

        for(int i=0;i<prerequisites.length;i++) {
          map.get(prerequisites[i][0]).add(prerequisites[i][1]);
          indegree[prerequisites[i][1]]++;
        }

        for(int i=0;i<numCourses;i++) {
          if(indegree[i] == 0)        //진입차수 0인 노드를 큐에 삽입
            q.offer(i);
        }

        while(!q.isEmpty()) {
          int current = q.poll();
          for(int i : map.get(current)) {   //큐에서 원소 꺼내 연결된 간선 제거, 노드들의 진입차수 갱신
            if(--indegree[i] == 0)
              q.offer(i);
          }
          count--;
        }
        
        return count == 0;
    }
}

