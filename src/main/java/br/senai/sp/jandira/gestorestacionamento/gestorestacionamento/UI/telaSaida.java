package br.senai.sp.jandira.gestorestacionamento.gestorestacionamento.UI;

import br.senai.sp.jandira.gestorestacionamento.gestorestacionamento.model.Carro;
import br.senai.sp.jandira.gestorestacionamento.gestorestacionamento.repository.CarroReposytory;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalDateTime;

public class telaSaida extends VBox {

    public telaSaida() {
        setStyle("-fx-background-color:F5E4D4 ");
        montaTelaSaida();
    }

    public void montaTelaSaida() {


        // Criação das caixas

        // caixa onde ficara o titulo
        VBox header = new VBox();

        //onde ficara o titulo resultado
        VBox miniheader = new VBox();

        //caixa onde ficara os botao
        VBox caixaDeBotao = new VBox();

        //cria caixa que ficara o campo de busca
        VBox caixaDeDados = new VBox();

        //caixa de resultado
        VBox resultado = new VBox();

        // corpo onde ficara as caixa de boao e dados e essa caixa e pra deixar as duad caixas uma do lado da outra
        HBox corpo = new HBox();




        //cria titulo da tela
        header.setStyle("-fx-padding: 10;-fx-background-color: blue;-fx-alignment: center;");
        Label labelTitulo = new Label("Saida");
        labelTitulo.setStyle("-fx-font-size: 30px;-fx-text-fill: white; -fx-font-weight: bold;");

        miniheader.setStyle("-fx-background-color: #343232;-fx-alignment: center;");
        Label labelMiniTitulo = new Label("Resultado");
        labelMiniTitulo.setStyle("Resultado; -fx-text-fill: white");



        Label labelBuscaPlaca = new Label("Placa do veiculo");
        TextField textFieldbuscaPlaca = new TextField();

        Label teste = new Label("teste");


        GridPane gridresultado = new GridPane();

        //criacao dos titulos da tela resultado

        Label tituloPlaca = new Label("Placa do Veiculo:");
        TextField textfildPlaca = new TextField();
        Label tituloModeloVeiculo = new Label("Modelo do Veiculo:");
        TextField textfildModeloVeiculo = new TextField();
        Label TituloNomePropietario = new Label("Nome do propietario:");
        TextField textfildPropietario = new TextField();
        Label TituloHoraEntrada = new Label("Hora de entrada:");
        TextField textfildHoraEntrada = new TextField();
        Label TituloHoraSaida = new Label("Hora de saida:");
        TextField textfildHoraSaida = new TextField();
        Label tituloValorPagar = new Label("Valor Total:");
        TextField textfildValorPagar = new TextField();




        //como os botoes ficarao na tela
        gridresultado.add(tituloPlaca, 0, 0);
        gridresultado.add(textfildPlaca, 1, 0);
        gridresultado.add(tituloModeloVeiculo, 0, 1);
        gridresultado.add(textfildModeloVeiculo, 1, 1);
        gridresultado.add(TituloNomePropietario, 0, 2);
        gridresultado.add(textfildPropietario, 1, 2);
        gridresultado.add(TituloHoraEntrada, 0, 3);
        gridresultado.add(textfildHoraEntrada, 1, 3);
        gridresultado.add(TituloHoraSaida, 0, 4);
        gridresultado.add(textfildHoraSaida, 1, 4);
        gridresultado.add(tituloValorPagar, 0, 5);
        gridresultado.add(textfildValorPagar, 1, 5);

        gridresultado.setStyle(
                "-fx-hgap: 15px;" +
                        "-fx-vgap: 12px;" +
                        "-fx-padding: 20px;"  // espaço interno do GridPane
        );




        // cria botao de busca
        Button botaoBuscar = new Button("Buscar");
        //personaliza botao de voltar
        botaoBuscar.setStyle(
                "-fx-font-size: 18px;" +
                "-fx-padding: 15 30 15 30;" +
                "-fx-background-color: #4763d5;" +
                "-fx-background-radius: 20px;" +
                "-fx-text-fill: white;" +
                "-fx-border-color: black;" +
                "-fx-border-radius: 20px;" +
                "-fx-border-width: 1px;"
        );
        botaoBuscar.setOnAction(event -> {
            CarroReposytory repo = new CarroReposytory();
            String placa = textFieldbuscaPlaca.getText();

            LocalDateTime data = LocalDateTime.now();
            String hora =data.toLocalTime().toString();

            String[] dados = repo.busca(placa);

            if (dados != null) {
                textfildPlaca.setText(dados[1]);          // placa
                textfildModeloVeiculo.setText(dados[2]);  // modelo
                textfildPropietario.setText(dados[3]);    // proprietário
                textfildHoraEntrada.setText(dados[5]);
                textfildHoraSaida.setText(dados[8]);
                textfildValorPagar.setText(dados[9]);


            } else {
                textfildPlaca.setText("");
                textfildModeloVeiculo.setText("");
                textfildPropietario.setText("");
                teste.setText("nao encontrado");

            }


        });

        Button botaoVoltar = new Button("Voltar");
        botaoVoltar.setStyle(
                "-fx-font-size: 18px;" +
                "-fx-padding: 15 30 15 30;" +
                "-fx-background-color: #d54747;" +
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

        //cria botao de saida
        Button botaoRegistrarSaida = new Button("Registrar Saida");
        botaoRegistrarSaida.setStyle(
                "-fx-font-size: 18px;" +
                "-fx-padding: 15 30 15 30;" +
                "-fx-background-color: #d54747;" +
                "-fx-background-radius: 20px;" +
                "-fx-text-fill: white;" +
                "-fx-border-color: black;" +
                "-fx-border-radius: 20px;" +
                "-fx-border-width: 1px;"
        );

        botaoRegistrarSaida.setOnAction(e -> {
            CarroReposytory repo = new CarroReposytory();
            String placa = textFieldbuscaPlaca.getText();

            boolean ok = repo.registrarSaida(placa);

            if (ok) {
                teste.setText("Saída registrada!");

                // limpa campos
                textfildPlaca.setText("");
                textfildModeloVeiculo.setText("");
                textfildPropietario.setText("");
                textfildHoraEntrada.setText("");
                textfildHoraSaida.setText("");
                textfildValorPagar.setText("");

            } else {
                teste.setText("Carro não encontrado ou já saiu!");
            }


        });






        //poem o titulo na caixa header/ no header
        header.getChildren().add(labelTitulo);

        //titulo da caixa resultado
        miniheader.getChildren().add(labelMiniTitulo);
        resultado.getChildren().add(miniheader);
        resultado.getChildren().add(gridresultado);
        //HBox.setHgrow(resultado,);
        resultado.setStyle(
                "-fx-background-color: #a4a4a4;" +
                "-fx-padding: 20px;" +          // espaço interno
                "-fx-spacing: 15px;" +          // espaço entre itens
                "-fx-translate-y: 40px;"        // desce a caixa
        );




        //poem os dados na caixa de dados
        caixaDeDados.getChildren().add(labelBuscaPlaca);
        caixaDeDados.getChildren().add(textFieldbuscaPlaca);
        caixaDeDados.getChildren().add(resultado);

        //caixaDeDados.getChildren().add(teste);

        //poem os botoes na caixa de botao
        caixaDeBotao.getChildren().add(botaoBuscar);
        caixaDeBotao.getChildren().add(botaoVoltar);
        caixaDeBotao.getChildren().add(botaoRegistrarSaida);


        //dados do corpo
        corpo.getChildren().add(caixaDeDados);
        //corpo.getChildren().add(resultado);
        corpo.getChildren().add(caixaDeBotao);


        //poem botao no canto direito
        HBox.setHgrow(caixaDeBotao, Priority.ALWAYS);
        caixaDeBotao.setStyle("-fx-alignment: center-right;");

        //meio q poem tudo na tela porem a classe é a tela
        getChildren().addAll(header, corpo);

    }




}
