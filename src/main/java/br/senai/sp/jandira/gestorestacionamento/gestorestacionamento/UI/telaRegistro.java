package br.senai.sp.jandira.gestorestacionamento.gestorestacionamento.UI;

import br.senai.sp.jandira.gestorestacionamento.gestorestacionamento.model.Carro;
import br.senai.sp.jandira.gestorestacionamento.gestorestacionamento.repository.CarroReposytory;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.time.LocalDateTime;

import java.util.UUID;

public class telaRegistro extends VBox {
    public telaRegistro() {
        setStyle("-fx-background-color:F5E4D4 ");


        montaTelaRegistro();
    }

    public void montaTelaRegistro() {

        // HEADER
        VBox header = new VBox();
        header.setStyle("-fx-padding: 10;-fx-background-color: #404CCD;-fx-alignment: center;");
        Label labelTitulo = new Label("Cadastro de Entrada");
        labelTitulo.setStyle("-fx-font-size: 30px;-fx-text-fill: white; -fx-font-weight: lighter;");

        // caixa principal onde ficara tudo
        HBox corpo = new HBox();
        //formulario
        GridPane gridformulario = new GridPane();

        //criacao dos titulos
        Label tituloPlaca = new Label("Placa do Veiculo:");
        TextField textfildPlaca = new TextField();
        Label tituloModeloVeiculo = new Label("Modelo do Veiculo:");
        TextField textfildModeloVeiculo = new TextField();
        Label TituloNomePropietario = new Label("Nome do propietario:");
        TextField textfildPropietario = new TextField();
        Label status = new Label("");


        Label TituloDataEntrada = new Label("Data de entrada:");
        TextField textFielddata =new TextField();
        Label TituloHoraEntrada = new Label("Hora de entrada:");
        TextField textFielhora =new TextField();


        //como os botoes ficarao na tela/formulario
        gridformulario.add(tituloPlaca, 0, 0);
        gridformulario.add(textfildPlaca, 1, 0);
        gridformulario.add(tituloModeloVeiculo, 0, 1);
        gridformulario.add(textfildModeloVeiculo, 1, 1);
        gridformulario.add(TituloNomePropietario, 0, 2);
        gridformulario.add(textfildPropietario, 1, 2);

        gridformulario.add(TituloDataEntrada, 0, 3);
        gridformulario.add(textFielddata, 1,3);
        gridformulario.add(TituloHoraEntrada, 0, 4);
        gridformulario.add(textFielhora, 1,4);
        gridformulario.add(status,0,5);

        gridformulario.setStyle(
                "-fx-hgap: 15px;" +
                "-fx-vgap: 12px;" +
                "-fx-padding: 20px;"  // espaço interno do GridPane
        );




        //caixa onde ficara os botao de  registrar e voltat
        VBox caixaDeBotao = new VBox();
        caixaDeBotao.setSpacing(40);


        Button botaoVoltar = new Button("Voltar");
        botaoVoltar.setStyle(
                        "-fx-font-size: 18px;" +
                        "-fx-padding: 15 30 15 30;" +
                        "-fx-background-color: #068791;" +
                        "-fx-background-radius: 20px;" +
                        "-fx-text-fill: white;" +
                        "-fx-border-color: black;" +
                        "-fx-border-radius: 20px;" +
                        "-fx-border-width: 1px;"
        );
        botaoVoltar.setOnAction(e -> {
            telaInicial telaPrincipal = new telaInicial();
            //criar a janela de regist
            Scene novaCena = new Scene(telaPrincipal, 800, 600);

            // Pega o stage atual (janela principal)
            Stage stage = (Stage) botaoVoltar.getScene().getWindow();
            stage.setScene(novaCena);
            stage.setTitle("Carros Estacionados");

        });

        Button botaoRegistrar = new Button("Registrar");
        botaoRegistrar.setOnAction(e -> {
            LocalDateTime data = LocalDateTime.now();
            CarroReposytory cr = new CarroReposytory();

            String aux = textfildPlaca.getText();

            if (textfildPlaca.getText().isEmpty() || textfildPropietario.getText().isEmpty() || textfildModeloVeiculo.getText().isEmpty()){
                textfildPlaca.setText("Preencha todos os campos");
                textfildModeloVeiculo.setText("Preencha todos os campos");
                textfildPropietario.setText("Preencha todos os campos");

            } else if (cr.busca(aux) != null)  {
                textfildPlaca.setText("placa ja registrada");

            }else {

                Carro carro = new Carro();

                carro.id = UUID.randomUUID().toString();
                carro.placa = textfildPlaca.getText();
                carro.modelo = textfildModeloVeiculo.getText();
                carro.nomePropietario = textfildPropietario.getText();
                carro.data = data.toLocalDate().toString();
                carro.hora = data.toLocalTime().toString();
                carro.visibilidade = true;

                textFielddata.setText(data.toLocalDate().toString());
                textFielhora.setText(data.toLocalTime().toString().substring(0, 5));

                cr.salvar(carro);

                //limpa tela
                textfildPlaca.setText("");
                textfildModeloVeiculo.setText("");
                textfildPropietario.setText("");
                status.setText("registrado");
            }


        });


        botaoRegistrar.setStyle(
                "-fx-font-size: 18px;" +
                        "-fx-padding: 15 30 15 30;" +
                        "-fx-background-color: #4CD745;" +
                        "-fx-background-radius: 20px;" +
                        "-fx-text-fill: white;" +
                        "-fx-border-color: black;" +
                        "-fx-border-radius: 20px;" +
                        "-fx-border-width: 1px;"
        );
        //poem o titulo na caixa header/ no header
        header.getChildren().add(labelTitulo);

        //poem os botoes na caixa de botao

        caixaDeBotao.getChildren().add(botaoVoltar);
        caixaDeBotao.getChildren().add(botaoRegistrar);
        corpo.getChildren().addAll(gridformulario,caixaDeBotao);

        //teste

        HBox.setHgrow(caixaDeBotao, Priority.ALWAYS);
        caixaDeBotao.setStyle("-fx-alignment: center-right;");

        //
        //meio q poem tudo na tela porem a classe é a tela
        getChildren().addAll(header, corpo);


    }



}
