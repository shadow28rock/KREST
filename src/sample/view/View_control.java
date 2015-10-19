package sample.view;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.util.Duration;

import javax.swing.*;

/**
 * Created by 803581 on 01.10.2015.
 */
public class View_control
{
    public void reDrawRow(int index, Button btn00)
    {
        Object[] arr =   btn00.getParent().getChildrenUnmodifiable().toArray();
        for(int i=1; i< 10; i++){
            Button btn = (Button) arr[i];
            String input = btn.getId().substring(3);
            int num_row = Integer.parseInt(input.substring(0, 1));
            if (num_row == index)
                btn.setStyle("-fx-background-color: red; -fx-text-fill: gold; -fx-opacity:1");
        }
    }
    public void reDrawColumn(int index, Button btn00)
    {
        Object[] arr =   btn00.getParent().getChildrenUnmodifiable().toArray();
        for(int i=1; i< 10; i++){
            Button btn = (Button) arr[i];
            String input = btn.getId().substring(3);
            int num_col = Integer.parseInt(input.substring(1));
            if (num_col == index)
                btn.setStyle("-fx-background-color: red; -fx-text-fill: gold; -fx-opacity:1");
        }
    }
    public void clearEffect(Button btn00)
    {
        Object[] arr =   btn00.getParent().getChildrenUnmodifiable().toArray();
        FadeTransition ft;
        for(int i=1; i < 10; i++) {
            ft = new FadeTransition(Duration.millis(1500));
            ft.setFromValue(0);
            ft.setToValue(1);
            if (arr[i] instanceof  Button){
                Button btn = (Button) arr[i];
                ft.setNode((Button) arr[i]);
                ft.play();
            }
        }
    }
    public void setEffect(Button btn00)
    {   Object[] arr =   btn00.getParent().getChildrenUnmodifiable().toArray();
        RotateTransition rt;
        for(int i=1; i < 10; i++) {
            rt = new RotateTransition(Duration.millis(1000));
            rt.setFromAngle(180);
            rt.setToAngle(360);
            rt.setCycleCount(1);
            rt.setAutoReverse(false);
            if (arr[i] instanceof  Button){
                Button btn = (Button) arr[i];
                rt.setNode(btn);
                rt.play();
            }
        }
    }
    public  void reDrawDiagonal(int index, Button btn00)
    {
        Object[] arr =   btn00.getParent().getChildrenUnmodifiable().toArray();
        if (index == 0) {
            for (int i = 1; i < 10; i++) {
                Button btn = (Button) arr[i];
                String input = btn.getId().substring(3);
                int num_col = Integer.parseInt(input.substring(1));
                int num_row = Integer.parseInt(input.substring(0, 1));

                if (num_col == index && num_row == index) {
                    btn.setStyle("-fx-background-color: red; -fx-text-fill: gold; -fx-opacity:1");
                    index++;
                }
            }
        }
        else if (index==2)
        {   for (int i = 1; i < 10; i++) {
            Button btn = (Button) arr[i];
            String input = btn.getId().substring(3);
            int num_col = Integer.parseInt(input.substring(1));
            int num_row = Integer.parseInt(input.substring(0, 1));
            if ((num_col == 2 && num_row == 0) || (num_col == 1 && num_row == 1)|| (num_col == 0 && num_row == 2)) {
                btn.setStyle("-fx-background-color: red; -fx-text-fill: gold; -fx-opacity:1");
            }
        }
        }
    }

}
