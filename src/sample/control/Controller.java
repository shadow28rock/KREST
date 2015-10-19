package sample.control;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.Button;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import sample.model.Model;
import sample.view.Music;
import sample.view.View_control;

public class Controller {
    public Button btn00;
    public Button btn01;
    public Button btn02;
    public Button btn10;
    public Button btn11;
    public Button btn12;
    public Button btn20;
    public Button btn21;
    public Button btn22;
    public ComboBox instruments;
    public Label lblResult;
    private int[][] matrix;
    private Model model;
    private View_control view_control;
    public Controller()
    {
        matrix = new int[3][3];
        model = new Model();
        view_control = new View_control();

    }
    private String last_symbol = "x";
    private boolean game_over = false;

    public void setSymbol(ActionEvent actionEvent) {
        Object[] arr =   btn00.getParent().getChildrenUnmodifiable().toArray(); //получили все кнопки на форме
        for(int i=1; i< 10; i++) {
            Button cur_btn = (Button) arr[i]; //текущая кнопка
            if (actionEvent.getSource().equals(cur_btn) && cur_btn.getText() == "") {
                cur_btn.setText(last_symbol);               //по клику на клетке устанавливаем соответсвующий знак
                Music.playSound("sound2.wav");
                model.forward(cur_btn, last_symbol, matrix);  //запоминаем ход в матрице ходов
                int index_row = model.sameIntoRow(matrix);
                int index_column = model.sameIntoColumn(matrix);
                int index_diag = model.sameIntoDiag(matrix);
                if (index_row > -1 && !game_over) { //есть победитель в строке
                    view_control.reDrawRow(index_row, btn00);
                    model.whoIsLost(last_symbol, lblResult);
                    Music.playSound("end.wav");
                    game_over = true;
                }
                if (index_column > -1 && !game_over) {//есть победитель в столбце
                    view_control.reDrawColumn(index_column, btn00);

                    model.whoIsLost(last_symbol, lblResult);
                    Music.playSound("end.wav");
                    game_over = true;
                }
                if (index_diag > -1 && !game_over) {//есть победитель в диагонале
                    view_control.reDrawDiagonal(index_diag, btn00);

                    model.whoIsLost(last_symbol, lblResult);
                    Music.playSound("end.wav");
                    game_over = true;
                }
                changeLast_symbol();        //меняем символ для следующего игрока
            }
        }
    }
    //метод обеспечивает чередование символа - крестик или нолик
    private void changeLast_symbol()
    {
        if (last_symbol=="x") last_symbol = "o";
        else last_symbol = "x";
    }
    //очистка поля для начала новой игры
    public void clearField(ActionEvent actionEvent)
    {
        Object[] arr =   btn00.getParent().getChildrenUnmodifiable().toArray(); //получили все кнопки на форме
        for(int i=1; i< 10;i++)
        {
            Button cur_btn = (Button)arr[i];
            if (cur_btn.getId() != "btnClear") {
                cur_btn.setText("");
                cur_btn.setStyle("-fx-padding: 0;\n" +
                        "-fx-text-fill: white;\n" +
                        "-fx-opacity:1;\n" +
                        "-fx-font-family: \"Arial Narrow\";\n" +
                        "-fx-font-weight: bold;\n" +
                        "-fx-font-size: 35px;\n" +
                        "-fx-background-color: linear-gradient(#61a2b1, #2A5058);");
            }

        }
        Music.playSound("sound1.wav");
        view_control.clearEffect(btn00);
        matrix = new int[3][3];
        setPrevSymbol();
        game_over = false;
    }

    public void selectInstruments(ActionEvent actionEvent) {
        setPrevSymbol();
    }
    private void  setPrevSymbol()
    {
        int index = instruments.getSelectionModel().getSelectedIndex();
        if (index == 0)
            last_symbol = "x";
        if (index == 1)
            last_symbol = "o";
        else last_symbol="x";
    }

    public void setChoice(Event event) {
        Music.playSound("sound1.wav");
    }
    public void startGame(ActionEvent actionEvent)
    {
        view_control.setEffect(btn00);
        model.clearCount(lblResult);
    }
}
