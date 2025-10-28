import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SlidingGameGUI extends JFrame implements ActionListener {
    private final int SIZE = 3; // 3x3 拼图
    private JButton[][] buttons = new JButton[SIZE][SIZE];
    private int[][] board = new int[SIZE][SIZE];
    private int emptyRow, emptyCol;
    private JButton resetButton;

    public SlidingGameGUI() {
        setTitle("Number Sliding Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(300, 350);
        setLocationRelativeTo(null);

        // 创建棋盘面板
        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(SIZE, SIZE));
        Font font = new Font("Arial", Font.BOLD, 28);

        // 初始化按钮
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setFont(font);
                buttons[i][j].addActionListener(this);
                boardPanel.add(buttons[i][j]);
            }
        }

        // 重置按钮
        resetButton = new JButton("Reset");
        resetButton.addActionListener(e -> initBoard());

        add(boardPanel, BorderLayout.CENTER);
        add(resetButton, BorderLayout.SOUTH);

        initBoard();
        setVisible(true);
    }

    // 初始化棋盘
    private void initBoard() {
        ArrayList<Object> numbers = new ArrayList<>();
        for (int i = 0; i < SIZE * SIZE; i++) numbers.add(i);
        Collections.shuffle(numbers);

        int index = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = (int) numbers.get(index++);
                if (board[i][j] == 0) {
                    emptyRow = i;
                    emptyCol = j;
                }
            }
        }
        updateButtons();
    }

    // 更新界面显示
    private void updateButtons() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == 0) {
                    buttons[i][j].setText("");
                    buttons[i][j].setBackground(Color.LIGHT_GRAY);
                } else {
                    buttons[i][j].setText(String.valueOf(board[i][j]));
                    buttons[i][j].setBackground(Color.WHITE);
                }
            }
        }
    }

    // 点击按钮事件
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton) e.getSource();
        int row = -1, col = -1;

        // 找到被点击的按钮位置
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (buttons[i][j] == clicked) {
                    row = i;
                    col = j;
                }
            }
        }

        // 检查是否可移动
        if (Math.abs(row - emptyRow) + Math.abs(col - emptyCol) == 1) {
            board[emptyRow][emptyCol] = board[row][col];
            board[row][col] = 0;
            emptyRow = row;
            emptyCol = col;
            updateButtons();
            if (isSolved()) {
                JOptionPane.showMessageDialog(this, "🎉 Congratulations! You solved the puzzle!");
            }
        }
    }

    // 检查是否完成
    private boolean isSolved() {
        int count = 1;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (i == SIZE - 1 && j == SIZE - 1) return board[i][j] == 0;
                if (board[i][j] != count++) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new SlidingGameGUI();
    }
}

