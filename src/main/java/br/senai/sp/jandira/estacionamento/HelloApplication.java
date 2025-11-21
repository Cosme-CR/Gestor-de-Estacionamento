package br.senai.sp.jandira.estacionamento;

import javafx.application.Application;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //tamanho
        stage.setWidth(800);
        stage.setHeight(600);

        //tela principal
        VBox root = new VBox();
        Scene scene = new Scene(root);

        VBox header = new VBox();
        header.setStyle("-fx-padding: 10;-fx-background-color: yellow;-fx-alignment: center; ");
        Label labelTitulo = new Label("Gestor Veicular");
        labelTitulo.setStyle("-fx-font-size: 30px;-fx-text-fill: white; -fx-font-weight: bold;");


        VBox teste = new VBox();
        teste.setPadding(new Insets(60,0, 0,0));
        teste.setStyle(""+
                "-fx-font-size: 18px;" +
                "-fx-alignment: center;"+
                "-fx-padding: 15 30 15 30;" +
                "-fx-background-color: #2305ea;" +
                "-fx-background-radius: 20px;" +   //  arredonda o fundo
                "-fx-text-fill: white;" +
                "-fx-border-color: black;" +
                "-fx-border-radius: 20px;" +       //  arredonda a borda
                "-fx-border-width: 1px;"

        );
        Label labelSub = new Label("Bem-Vindo(a) ao sistema");

        labelSub.setStyle("-fx-font-size: 30px;-fx-text-fill: white; -fx-font-weight: bold;");



        HBox boxBotao = new HBox();
        boxBotao.setPadding(new Insets(90,0, 0,0));
        boxBotao.setSpacing(10);
        boxBotao.setStyle("-fx-alignment: center;");

        Button botaoRegistrar = new Button("Registra Veiculo");
        botaoRegistrar.setStyle("" +
                "-fx-font-size: 18px;" +
                "-fx-padding: 15 30 15 30;" +
                "-fx-background-color: #4CAF50;" +
                "-fx-background-radius: 20px;" +   //  arredonda o fundo
                "-fx-text-fill: white;" +
                "-fx-border-color: black;" +
                "-fx-border-radius: 20px;" +       //  arredonda a borda
                "-fx-border-width: 1px;"
        );
        Button botaoRetirar = new Button("Retira Veiculo");
        botaoRetirar.setStyle("" +
                "-fx-font-size: 18px;" +
                "-fx-padding: 15 30 15 30;" +
                "-fx-background-color: red;" +
                "-fx-background-radius: 20px;" +   //  arredonda o fundo
                "-fx-text-fill: white;" +
                "-fx-border-color: black;" +
                "-fx-border-radius: 20px;" +       //  arredonda a borda
                "-fx-border-width: 1px;"
        );
        Button botaoEstacionados = new Button("veiculos Estacionados");
        botaoEstacionados.setStyle("" +
                "-fx-font-size: 18px;" +
                "-fx-padding: 15 30 15 30;" +
                "-fx-background-color: orange;" +
                "-fx-background-radius: 20px;" +   //  arredonda o fundo
                "-fx-text-fill: white;" +
                "-fx-border-color: black;" +
                "-fx-border-radius: 20px;" +       //  arredonda a borda
                "-fx-border-width: 1px;"

        );


        header.getChildren().add(labelTitulo);
        teste.getChildren().add(labelSub);

        boxBotao.getChildren().add(botaoRegistrar);
        boxBotao.getChildren().add(botaoRetirar);
        boxBotao.getChildren().add(botaoEstacionados);


        root.getChildren().add(header);
        root.getChildren().add(teste);
        root.getChildren().add(boxBotao);


        stage.setTitle("Gestor Veicular!");
        stage.setScene(scene);
        stage.show();
    }
}
