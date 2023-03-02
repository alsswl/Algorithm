class Solution {
    static  char[][] arr;
    static int[][] vis;
    static int ok = 0;
    
    static void check(int m, int n, int x, int y){
        
        if(arr[x][y] == '.') return;
        if(x+1<m&&y+1<n){
            if(arr[x][y] == arr[x+1][y] && arr[x][y] == arr[x][y+1]
              && arr[x][y] == arr[x+1][y+1]) {
                ok = 1;
                vis[x+1][y] = 1;
                vis[x][y+1] = 1;
                vis[x+1][y+1] = 1;
                vis[x][y] = 1;
            }
        }
        
    }
    
    static void drop(int m, int n){
        for(int i = 0;i<n;i++){
            for(int j = m-1;j>=0;j--){
                if(arr[j][i] == '.'){
                    for(int z = j-1;z>=0;z--){
                        if(arr[z][i] != '.'){
                            arr[j][i] = arr[z][i];
                            arr[z][i] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }
    
    public int solution(int m, int n, String[] board) {
        vis = new int[m][n];
        arr = new char[m][n];
        
        for(int i = 0;i<m;i++){
            arr[i] = board[i].toCharArray();
        }
        
        
        while(true){
            ok = 0;
            vis = new int[m][n];
            for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
               check(m,n,i,j);
            }
        }
            for(int i = 0;i<m;i++){
                for(int j = 0;j<n;j++){
                    if(vis[i][j] == 1) arr[i][j] = '.';
                }
            }
            
            
            
            drop(m,n);
            
            if(ok == 0) break;
        }
        
        
        int answer = 0;
        
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
               if(arr[i][j] == '.') answer++;
            }
        }
        
        
        return answer;
    }
}