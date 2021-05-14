rows = 6, 행렬의 세로 길이
columns = 6, 행렬 가로 길이
queries = [[2,2,5,4],[3,3,6,6],[5,1,6,3]], 회전들의 목록
result = 회전에 의해 위치가 바뀐 숫자들 중 가장 작은 숫자들의 배열


import java.util.*;
class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int count = 1;
        int[][] arr = new int[rows][columns];  // 1번부터 rows x columns까지 순서대로 담길 arr 배열 
        for(int i=0;i<rows;i++) {
          for(int j=0;j<columns;j++)
            arr[i][j] = count++;
        }

        int[] result = new int[queries.length];

        for(int i=0;i<queries.length;i++) {
          int a = queries[i][0]-1;     // 회전할 배열의 왼쪽 위 x좌표
          int b = queries[i][1]-1;     // 회전할 배열의 왼쪽 위 y좌표
          int c = queries[i][2]-1;     // 회전할 배열의 오른쪽 아래 x좌표
          int d = queries[i][3]-1;     // 회전할 배열의 오른쪽 아래 y좌표

          List<Integer> list = new ArrayList<Integer>();   // 회전한 수들을 담을 배열
          // 꼭짓점 좌표들 추가
          list.add(arr[a][b]);
          list.add(arr[c][b]);
          list.add(arr[a][d]);
          list.add(arr[c][d]);
          // 꼭짓점 사이 좌표들 추가
          for(int k=a+1;k<c;k++)
            list.add(arr[k][b]);
          for(int k=a+1;k<c;k++)
            list.add(arr[k][d]);
          for(int k=b+1;k<d;k++)
            list.add(arr[a][k]);
          for(int k=b+1;k<d;k++)
            list.add(arr[c][k]);

          int index = 0;
          // 꼭짓점 좌표들 회전시키기
          arr[a][b+1] = list.get(index++);   // 오른쪽으로 이동
          arr[c-1][b] = list.get(index++);   // 위로 이동
          arr[a+1][d] = list.get(index++);   // 아래로 이동
          arr[c][d-1] = list.get(index++);   // 왼쪽으로 이동
          // 꼭짓점 사이 
          for(int k=a+1;k<c;k++)             // 위로 이동
            arr[k-1][b] = list.get(index++);
          for(int k=a+1;k<c;k++)             // 아래로 이동
            arr[k+1][d] = list.get(index++);
          for(int k=b+1;k<d;k++)             // 오른쪽으로 이동
            arr[a][k+1] = list.get(index++);
          for(int k=b+1;k<d;k++)             // 왼쪽으로 이동
            arr[c][k-1] = list.get(index++);

          Collections.sort(list);
          result[i] = list.get(0);
        }
        return result;
    }
}
