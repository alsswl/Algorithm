import java.util.*;

class Coor{
    int x;
    int y;
    int count;
    public Coor(int x, int y, int count){
        this.x=x;
        this.y=y;
        this.count = count;
    }
}

class Solution {
    public int[] dx = {1,0,0,-1}; //동남북서
    public int[] dy = {0,1,-1,0};
    
    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;
        
        Queue<Coor> qu = new LinkedList<>();
        qu.add(new Coor(0,0,1));
        
        int[][] visited = new int[n][m];
        visited[0][0] = 0;
        
        while(!qu.isEmpty()){
            Coor now = qu.poll();
            int currX = now.x;
            int currY = now.y;
            int currCount = now.count;
            
            if(currX==n-1 && currY==m-1){
                answer = currCount;
                return answer;
            }
            // System.out.println("g");
            for(int i=0; i<4; i++){
                int nextX = currX + dx[i];
                int nextY = currY + dy[i];
                if(nextX< 0 || nextX >= n || nextY<0 || nextY >= m){
                    continue;
                }
                if(maps[nextX][nextY] == 1 && visited[nextX][nextY] == 0){
                    // 길이있고 방문하지 않았으면
                    qu.add(new Coor(nextX, nextY, currCount + 1));
                    visited[nextX][nextY] = 1; // 방문했으면 1
                }
            }
        }
        
        
        return -1;
    }
}
