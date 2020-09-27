package cadastro.controllers;

import cadastro.models.Aluno;
import cadastro.models.Sexo;
import cadastro.models.Sistema;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.Calendar;

public class addController{
    @FXML
    private TextField tfNome;
    @FXML
    private DatePicker datePicker;
    @FXML
    private ChoiceBox<Sexo> cb;
    @FXML
    private TextField tfResponsavel;
    @FXML
    private Label lbResponsavel;

    ObservableList choiceBox = FXCollections.observableArrayList();
    Sistema sistema = Sistema.getInstance();

    public void choiceBox(){
        choiceBox.removeAll();
        choiceBox.addAll(Sexo.values());
        cb.getItems().addAll(choiceBox);
    }
    public void initialize(){
        choiceBox();
    }
    public void datePicker(){
        Calendar dataAtual = Calendar.getInstance();
        int anoN = datePicker.getValue().getYear();
        int mesN = datePicker.getValue().getMonthValue();
        int diaN = datePicker.getValue().getDayOfMonth();
        int anoA = dataAtual.get(Calendar.YEAR);
        int mesA = dataAtual.get(Calendar.MONTH) + 1;
        int diaA = dataAtual.get(Calendar.DAY_OF_MONTH);
        int idade = 0;
        if(anoA - anoN >= 18){
            idade = 18;
            if(mesN == mesA){
                idade = 18;
                if(diaA < diaN){
                    idade--;
                }
            }
        }
        if(idade < 18){
            lbResponsavel.setVisible(true);
            tfResponsavel.setVisible(true);
        }else{
            lbResponsavel.setVisible(false);
            tfResponsavel.setVisible(false);
        }
    }
    public void onClick() {
        Alert alert;
        Aluno aluno = new Aluno();

        aluno.setNome(tfNome.getText());
        aluno.setDataDeNasc(datePicker.getValue());
        aluno.setSexo(cb.getValue());
        aluno.setResponsavel(tfResponsavel.getText());

        boolean cadastrado = sistema.cadastrarAlunos(aluno);
        if(cadastrado) {
            cleanTextFilds();
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Operação");
            alert.setHeaderText("Sucess");
            alert.setContentText("Cadastrado com Sucesso!");
            alert.show();
        }
    }

    public void cleanTextFilds(){
        tfNome.setText("");
//        datePicker.setValue(null);
        cb.setItems(choiceBox);
        tfResponsavel.setText("");
        lbResponsavel.setVisible(false);
        tfResponsavel.setVisible(false);
    }
}


