import java.util.*;

public class SGFirst {
    static int[][] board = new int[3][3];
    static int emptyRow, emptyCol;

    public static void main(String[] args) {
        initBoard();
        Scanner sc = new Scanner(System.in);

        while (true) {
            printBoard();
            System.out.print("Enter move (w=up, s=down, a=left, d=right): ");
            char move = sc.next().charAt(0);
            moveTile(move);

            if (isSolved()) {
                printBoard();
                System.out.println("🎉 You Win!");
                break;
            }
        }
    }

    // 1. 初始化棋盘
    static void initBoard() {
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < 9; i++) nums.add(i);
        Collections.shuffle(nums);

        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = nums.get(index++);
                if (board[i][j] == 0) {
                    emptyRow = i;
                    emptyCol = j;
                }
            }
        }
    }

    // 2. 打印棋盘
    static void printBoard() {
        for (int[] row : board) {
            for (int num : row) {
                System.out.print(num == 0 ? " _ " : " " + num + " ");
            }
            System.out.println();
        }
    }

    // 3. 移动逻辑
    static void moveTile(char dir) {
        int newRow = emptyRow, newCol = emptyCol;
        switch (dir) {
            case 'w': newRow++; break;
            case 's': newRow--; break;
            case 'a': newCol++; break;
            case 'd': newCol--; break;
            default: System.out.println("Invalid input");
        }
        if (newRow < 0 || newRow >= 3 || newCol < 0 || newCol >= 3) return;

        board[emptyRow][emptyCol] = board[newRow][newCol];
        board[newRow][newCol] = 0;
        emptyRow = newRow;
        emptyCol = newCol;
    }

    // 4. 胜利检测
    static boolean isSolved() {
        int count = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 2 && j == 2) return board[i][j] == 0;
                if (board[i][j] != count++) return false;
            }
        }
        return true;
    }
}
