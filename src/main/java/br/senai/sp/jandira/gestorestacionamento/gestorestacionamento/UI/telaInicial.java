
package br.senai.sp.jandira.gestorestacionamento.gestorestacionamento.UI;

import br.senai.sp.jandira.gestorestacionamento.gestorestacionamento.repository.CarroReposytory;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.util.List;

public class telaInicial extends VBox {

    public telaInicial() {
        setStyle("-fx-background-color:F5E4D4 ");

        montarTela();
    }

    public void montarTela() {

        // HEADER
        VBox header = new VBox();
        header.setStyle("-fx-padding: 10;-fx-background-color: blue;-fx-alignment: center;");
        Label labelTitulo = new Label("Carros Estacionados");
        labelTitulo.setStyle("-fx-font-size: 30px;-fx-text-fill: white; -fx-font-weight: bold;");
        header.getChildren().add(labelTitulo);

        // caixa de botao
        HBox boxBotao = new HBox();
        boxBotao.setPadding(new Insets(90, 0, 90, 0));
        boxBotao.setSpacing(90);
        boxBotao.setStyle("-fx-alignment: center;");
        //botao de entrada
        Button botaoEntrada = new Button("Registrar nova entrada");
        botaoEntrada.setStyle(
                "-fx-font-size: 18px;" +
                        "-fx-padding: 15 30 15 30;" +
                        "-fx-background-color: #4CAF50;" +
                        "-fx-background-radius: 20px;" +
                        "-fx-text-fill: white;" +
                        "-fx-border-color: black;" +
                        "-fx-border-radius: 20px;" +
                        "-fx-border-width: 1px;"
        );

        botaoEntrada.setOnAction(e -> {
            //criar a janela de registro
            telaRegistro telaregistrar = new telaRegistro();
            Scene novaCena = new Scene(telaregistrar, 800, 600);

            // Pega o stage atual (janela principal)
            Stage stage = (Stage) botaoEntrada.getScene().getWindow();
            stage.setScene(novaCena);
            stage.setTitle("Cadastro de Entrada");
        });

        //botao de saida
        Button botaoSaida = new Button("Registrar nova saída");
        botaoSaida.setStyle(
                "-fx-font-size: 18px;" +
                        "-fx-padding: 15 30 15 30;" +
                        "-fx-background-color: #d54747;" +
                        "-fx-background-radius: 20px;" +
                        "-fx-text-fill: white;" +
                        "-fx-border-color: black;" +
                        "-fx-border-radius: 20px;" +
                        "-fx-border-width: 1px;"
        );

        botaoSaida.setOnAction(e -> {

            telaSaida telaDeSaida = new telaSaida();
            Scene novaCenaSaida = new Scene(telaDeSaida, 800, 600);
            Stage stage = (Stage) botaoSaida.getScene().getWindow();
            stage.setScene(novaCenaSaida);

        });

       // poem os botoes na caixa de botao
        boxBotao.getChildren().add( botaoEntrada);
        boxBotao.getChildren().add(botaoSaida);

        // LISTA
        CarroReposytory repo = new CarroReposytory();
        List<String> carrosExibidos = repo.exibir();

        ListView<String> listaCarros = new ListView<>();



        listaCarros.getItems().addAll(carrosExibidos);




        VBox caixaCarros = new VBox(listaCarros);

        // ADICIONA TUDO NA PRÓPRIA TELA
        getChildren().addAll(header, boxBotao, caixaCarros);
        setSpacing(20);
    }
}
