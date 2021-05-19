import java.io.*;
import java.util.*;

/*
We are designing a 2D game and we have a game map that we represent by an integer matrix. For now, each cell can be a wall (denoted by -1) or a blank space (0).

board = [
  [0,  0,  0, -1, -1],
  [0,  0, -1,  0,  0],
  [0, -1,  0, -1,  0],
  [0,  0, -1,  0,  0],
  [0,  0,  0,  0,  0],
  [0,  0,  0,  0,  0],
  [0,  0,  0,  0,  0],
]

The player can move 1 space at a time up, down, left, or right. The player can't go through walls or land on a wall, or go through the edges of the board.

Write a function that, given a board and a player starting position (represented as a row-column pair), returns all of the possible next positions for the player.

Sample inputs (board, starting_position) and outputs (in any order):

findLegalMoves(board, (1, 1)) =>
  (0, 1), (1, 0)

findLegalMoves(board, (5, 3)) =>
  (5, 2), (5, 4), (4, 3), (6, 3)

findLegalMoves(board, (5, 1)) =>
  (6, 1), (4, 1), (5, 0), (5, 2)

findLegalMoves(board, (6, 0)) =>
  (5, 0), (6, 1)

findLegalMoves(board, (6, 4)) =>
  (5, 4), (6, 3)

findLegalMoves(board, (0, 0)) =>
  (0, 1), (1, 0)

findLegalMoves(board, (2, 2)) =>
  [empty]

n: width of the input board
m: height of the input board

*/

public class Solution {
  public static void main(String[] argv) {
    int[][] board = new int[][] {
      {0,  0,  0, -1, -1},
      {0,  0, -1,  0,  0},
      {0, -1,  0, -1,  0},
      {0,  0, -1,  0,  0},
      {0,  0,  0,  0,  0},
      {0,  0,  0,  0,  0},
      {0,  0,  0,  0,  0},
    };


    
    int[] start1 = new int[] {1, 1};
    int[] start2 = new int[] {5, 3};
    int[] start3 = new int[] {5, 1};
    int[] start4 = new int[] {6, 0}; // 6 row, 0 column
    int[] start5 = new int[] {6, 4};
    int[] start6 = new int[] {0, 0};
    int[] start7 = new int[] {2, 2};

    Solution solution = new Solution();
    List<Object> result = solution.findLegalMoves(board, start4);
    for(Object obj: result){
      int[] pair = (int[])obj;
      System.out.println(pair[0] + " " + pair[1]);
          
    }
  }
  
  public List<Object> findLegalMoves(int[][] board, int[] pair){
    List<Object> result = new ArrayList<Object>(); // new int[]
    //result.add(new int[]{2,2});
    
    // find next available coordinates
    int x = pair[0];
    int y = pair[1];
 
    int left = y-1; // 0
    int right = y +1; // 2
    int up = x-1;  // 0
    int down = x +1;//2
    
    int[] left_move = new int[]{x, left};
    int[] right_move = new int[]{x, right};
    int[] up_move = new int[]{up, y};
    int[] down_move = new int[]{down, y};
    int value =0;
    
    // validate if not in the edge
    if (x > 0){
      value = board[up_move[0]][up_move[1]];
      if(value !=-1){
        result.add(up_move);
      }
    }
   
    if(x< board.length-1){
      value = board[down_move[0]][down_move[1]];
      if(value !=-1){
      result.add(down_move);
      }
    }
    if (y > 0){
      value = board[left_move[0]][left_move[1]];
      if(value !=-1){
      result.add(left_move);
      }
    }
    if(y< board[0].length-1){
            value = board[right_move[0]][right_move[1]];
if(value !=-1){
      result.add(right_move);
}
    }
    
    //validate not -1
    
    
    
    //int a= board[left_move[0]][left_move[1]];
//     result.add(left_move);
//    // result.add(right_move);
//     result.add(up_move);
// //     result.add(down_move);
    
    return result; 
  }
  
}
