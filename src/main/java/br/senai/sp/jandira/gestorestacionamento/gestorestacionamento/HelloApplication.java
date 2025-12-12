package br.senai.sp.jandira.gestorestacionamento.gestorestacionamento;

//import br.senai.sp.jandira.gestorestacionamento.gestorestacionamento.UI.cadastroUI;
import br.senai.sp.jandira.gestorestacionamento.gestorestacionamento.UI.telaInicial;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
      //  FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        //chama tela inicial
        telaInicial tela = new telaInicial();
        Scene scene = new Scene(tela, 800, 600);

        stage.setTitle("Gestor Veicular");
        stage.setScene(scene);
        stage.show();

    }
}
