
package br.senai.sp.jandira.gestorestacionamento.gestorestacionamento.UI;

import br.senai.sp.jandira.gestorestacionamento.gestorestacionamento.model.Carro;
import br.senai.sp.jandira.gestorestacionamento.gestorestacionamento.repository.CarroReposytory;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
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
        header.setStyle("-fx-padding: 10;-fx-background-color: #404CCD;-fx-alignment: center;");
        Label labelTitulo = new Label("Carros Estacionados");
        labelTitulo.setStyle("-fx-font-size: 30px;-fx-text-fill: white; -fx-font-weight: lighter;");
        header.getChildren().add(labelTitulo);

        // caixa de botao
        HBox boxBotao = new HBox();
        boxBotao.setPadding(new Insets(90, 0, 90, 0));
        boxBotao.setSpacing(90);
        boxBotao.setStyle("-fx-alignment: center;");

        //botao de entrada
        Button botaoEntrada = new Button("Registrar nova \n Entrada");
        botaoEntrada.setStyle(
                "-fx-font-size: 18px;" +
                "-fx-pref-width: 180;"+
                "-fx-pref-height: 240 ;" +
                "-fx-background-color: #4CAF50;" +
                "-fx-background-radius: 20px;" +
                "-fx-text-fill: white;" +
                "-fx-border-color: black;" +
                "-fx-border-radius: 20px;" +
                "-fx-border-width: 2px;"
        );
        botaoEntrada.setOnAction(e -> {criaTelaDecadastro();});

        //botao de saida
        Button botaoSaida = new Button(" Registrar \n saída/pagamento");
        botaoSaida.setStyle(
                    "-fx-font-size: 18px;" +
                    "-fx-pref-height: 230 ;"+
                    "-fx-background-color: #d54747;" +
                    "-fx-background-radius: 20px;" +
                    "-fx-text-fill: white;" +
                    "-fx-border-color: black;" +
                    "-fx-border-radius: 20px;" +
                    "-fx-border-width: 2px;"

        );
        botaoSaida.setOnAction(e -> {telaDeSaidaDeVeiculo();});

       // poem os botoes na caixa de botao
        boxBotao.getChildren().add( botaoEntrada);
        boxBotao.getChildren().add(botaoSaida);
        //caixa da tabela
        VBox caixaCarros = new VBox(tabela());

        // ADICIONA TUDO NA PRÓPRIA TELA
        getChildren().addAll(header, boxBotao, caixaCarros);
        setSpacing(20);
    }




    public void criaTelaDecadastro(){
        //criar a janela de registro
        telaRegistro telaregistrar = new telaRegistro();
        Scene novaCena = new Scene(telaregistrar, 800, 600);

        // Pega o stage atual (janela principal)
        Stage stage = (Stage) getScene().getWindow();
        stage.setScene(novaCena);
        stage.setTitle("Cadastro de Entrada");
    }

    public void telaDeSaidaDeVeiculo(){
        telaSaida telaDeSaida = new telaSaida();
        Scene novaCenaSaida = new Scene(telaDeSaida, 800, 600);

        Stage stage = (Stage) getScene().getWindow();
        stage.setScene(novaCenaSaida);
    }


    public TableView<String[]> tabela() {
        CarroReposytory repo = new CarroReposytory();
        List<String[]> dados = repo.exibir();

        TableView<String[]> tabelaCarros = new TableView<>();
        //cria as colunas
        TableColumn<String[], String> colunaPlaca = new TableColumn<>("Placa");
        TableColumn<String[], String> colunaModelo = new TableColumn<>("Modelo");
        TableColumn<String[], String> colunaProprietario = new TableColumn<>("Proprietário");
        TableColumn<String[], String> colunaData = new TableColumn<>("Data");
        TableColumn<String[], String> colunaHora = new TableColumn<>("Hora");

        //liga as colunas ate os dados
        colunaPlaca.setCellValueFactory(d -> new SimpleStringProperty(d.getValue()[0]));
        colunaModelo.setCellValueFactory(d -> new SimpleStringProperty(d.getValue()[1]));
        colunaProprietario.setCellValueFactory(d -> new SimpleStringProperty(d.getValue()[2]));
        colunaData.setCellValueFactory(d -> new SimpleStringProperty(d.getValue()[3]));
        colunaHora.setCellValueFactory(d -> new SimpleStringProperty(d.getValue()[4]));

        tabelaCarros.getColumns().addAll(
                colunaPlaca,
                colunaModelo,
                colunaProprietario,
                colunaData,
                colunaHora
        );



        //nao deixa ter colunas extra
        tabelaCarros.setItems(FXCollections.observableArrayList(dados));

        tabelaCarros.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        //chama o css
        tabelaCarros.getStylesheets().add(
                getClass().getResource("/tableview.css").toExternalForm()
        );
        return tabelaCarros;
    }




}
