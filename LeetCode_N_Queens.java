class Solution {
//TC(N)==O(N) and S(C(N))==O(N) as it requires Dynamic Memory alloc iteratively
  public List<List<String>> solveNQueens(int n) {//solveNQueens func declare
    List<List<String>> ans = new ArrayList<>();//Output Delcare
    char[][] board = new char[n][n];//Board declare

    for (int i = 0; i < n; ++i)//iterating through Board's Cells
      Arrays.fill(board[i], '.');//inserting Board's Cells

    dfs(n, 0, new boolean[n], new boolean[2 * n - 1], new boolean[2 * n - 1], board, ans);//calling dfs func
    return ans;//printing output
  }

  private void dfs(int n, int i, boolean[] cols, boolean[] diag1, boolean[] diag2, char[][] board,
                   List<List<String>> ans) {//Dfs func declare
    if (i == n) {ans.add(construct(board));return;}//adding  Board's Output

    for (int j = 0; j < cols.length; ++j) {//Iterating through Board's Col 's Length
      if (cols[j] || diag1[i + j] || diag2[j - i + n - 1])//Board's Col's and Diagonal val Travelling
        continue;
      board[i][j] = 'Q';//Declaring Queen As Central Cell 
      cols[j] = diag1[i + j] = diag2[j - i + n - 1] = true;//columns val decalre
      dfs(n, i + 1, cols, diag1, diag2, board, ans);//applying dfs appr to the next Cell within same Col
      cols[j] = diag1[i + j] = diag2[j - i + n - 1] = false;//
      board[i][j] = '.';//Inserting Board's Cell within .
    }
  }

  private List<String> construct(char[][] board) {//Constructing Board's funct
    List<String> listBoard = new ArrayList<>();//Listing Board List
    for (int i = 0; i < board.length; ++i)//Board's Length iteration
      listBoard.add(String.valueOf(board[i]));//Adding board's Indx Val
    return listBoard;//Printing Board's List
  }
}
