package leetcode.test0751to0800;

public class leetcode794 {
    public boolean validTicTacToe(String[] board) {
        int play1Num = 0;
        int play2Num = 0;

        boolean[] play1Book = new boolean[9];
        boolean[] play2Book = new boolean[9];

        for(int i = 0; i < 9; i++){
            if(board[i/3].charAt(i%3) == 'X'){
                play1Num++;
                play1Book[i] = true;
            }

            if(board[i/3].charAt(i%3) == 'O'){
                play2Num++;
                play2Book[i] = true;
            }
        }
        System.out.println(play1Num);
        System.out.println(play2Num);
        if(play1Num - play2Num > 1 || play2Num - play1Num > 0){
            return false;
        }
        boolean play1Flag = checkWin(play1Book);
        
        if(play1Num == play2Num){
            return !play1Flag;
        }

        boolean play2Flag = checkWin(play2Book);
        System.out.println(play1Flag);
        System.out.println(play2Flag);

        if(play1Num == play2Num + 1){
            return !play2Flag;
        }
        return false;
    }

    public boolean checkWin(boolean[] playBook){
        if(playBook[4]){
            if(playBook[1] && playBook[7]){
                return true;
            }
            if(playBook[3] && playBook[5]){
                return true;
            }

            if(playBook[0] && playBook[8]){
                return true;
            }

            if(playBook[2] && playBook[6]){
                return true;
            }
        }
        if(playBook[0]){
            if(playBook[3] && playBook[6]){
                return true;
            }

            if(playBook[1] && playBook[2]){
                return true;
            }
        }

        if(playBook[8]){
            if(playBook[2] && playBook[5]){
                return true;
            }
            if(playBook[6] && playBook[7]){
                return true;
            }
        }

        return false;
    }
/*
 * 给你一个字符串数组 board 表示井字游戏的棋盘。当且仅当在井字游戏过程中，棋盘有可能达到 board 所显示的状态时，才返回 true 。

井字游戏的棋盘是一个 3 x 3 数组，由字符 ' '，'X' 和 'O' 组成。字符 ' ' 代表一个空位。

以下是井字游戏的规则：

玩家轮流将字符放入空位（' '）中。
玩家 1 总是放字符 'X' ，而玩家 2 总是放字符 'O' 。
'X' 和 'O' 只允许放置在空位中，不允许对已放有字符的位置进行填充。
当有 3 个相同（且非空）的字符填充任何行、列或对角线时，游戏结束。
当所有位置非空时，也算为游戏结束。
如果游戏结束，玩家不允许再放置字符。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-tic-tac-toe-state
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
}
