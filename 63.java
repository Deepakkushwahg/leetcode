class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int r = obstacleGrid.length,c = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1)
            return 0;

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(i==0 || j==0){
                    if(obstacleGrid[i][j] == 1 || (j!=0 && obstacleGrid[i][j-1] == 0) || (i!=0 && obstacleGrid[i-1][j] == 0))
                        obstacleGrid[i][j] = 0;
                    else
                        obstacleGrid[i][j] = 1;
                }
                else{
                    if(obstacleGrid[i][j] == 1)
                        obstacleGrid[i][j] = 0;
                    else
                        obstacleGrid[i][j] = obstacleGrid[i][j-1] + obstacleGrid[i-1][j];
                }
            }
        }
        return obstacleGrid[r-1][c-1];
    }
}