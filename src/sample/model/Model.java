package sample.model;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javax.swing.*;


public class Model {
    private int what_row;
    public  Model()
    {
        //пустой конструктор
    }
    //проверяем, есть ли в ряду одинокавые символы
    public int sameIntoRow(int[][] matrix)
    {
        for(int i=0; i< 3; i++)
        {   int count = 0;
            for(int j=0; j<2; j++)
            {
                if (matrix[i][j]> 0 && matrix[i][j] == matrix[i][j+1])
                    ++count;
            }
            if (count == 2)//в каком-либо ряду есть одинаковые символы
            {
               return i;
            }
            count = 0;
        }
        return -1;
    }
    //не работает
    public int sameIntoColumn(int[][] matrix)
    {
        for(int i=0; i < 3; i++) //бежим по столбцам
        {   int count = 0;
            for(int j=0; j<2; j++) //бежим по строком
            {
                if (matrix[j][i]>0 && matrix[j][i] == matrix[j+1][i])
                    ++count;
            }
            if (count == 2)//в каком-либо ряду есть одинаковые символы
            {
                return i;
            }
            count = 0;
        }
        return -1;
    }
    public int sameIntoDiag(int[][]matrix)
    {   int count = 0;
        //мы можем получить 1 или -1
        int i;
        for(i=0; i<2; i++)
        {
            if (matrix[i][i]>0 && matrix[i][i] == matrix[i+1][i+1])
                ++count;
        }
        if (count == 2)
            return 0;

        if (matrix[2][0] > 0 && matrix[2][0]== matrix[1][1] && matrix[1][1] == matrix[0][2])
            return 2;
        return -1;
    }
    //этот метод запоминает,какой был сделан ход в матрице ходов
    public  void  forward(Button btn, String last_symbol, int[][]matrix)
    {   String input = btn.getId().substring(3);
        int num_row = Integer.parseInt(input.substring(0, 1));
        int num_col = Integer.parseInt(input.substring(1));
        if (last_symbol=="x")
        {
            matrix[num_row][num_col] = 2;
        }
        else
        {
            matrix[num_row][num_col] = 1;
        }

    }
    private int x_count = 0;
    private int y_count = 0;

    public void clearCount(Label result)
    {
        x_count = 0;
        y_count = 0;
        String msg = "Cчёт: 0 : 0";
        result.setText(msg);
    }
    public void whoIsLost(String last_symbol, Label result)
    {   String res = "",msg = "";
        if (last_symbol == "x") {
            msg = "Cчёт: " + ++x_count + " : " + y_count;
            res="нолики";
        }
        else if (last_symbol == "o") {
            msg = "Cчёт: " + x_count + " : " + ++y_count;
            res = "крестики";
        }
        result.setText(msg);

        JOptionPane.showMessageDialog(null, "К сожалению, " + res + " проиграли", "Игра окончена", JOptionPane.INFORMATION_MESSAGE);
    }
}
