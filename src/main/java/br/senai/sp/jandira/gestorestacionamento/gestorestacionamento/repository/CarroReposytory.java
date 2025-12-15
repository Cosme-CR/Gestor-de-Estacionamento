package br.senai.sp.jandira.gestorestacionamento.gestorestacionamento.repository;

import br.senai.sp.jandira.gestorestacionamento.gestorestacionamento.model.Carro;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarroReposytory    {
    /*registro é o registro.csv
    nao apagar
    private Path registro = Paths.get("/home/cosme/projetos/Projeto-Integrador-T1/Gestor-de-Estacionamento/dados/registro.csv");
    private Path historico = Paths.get("/home/cosme/projetos/Projeto-Integrador-T1/Gestor-de-Estacionamento/dados/historico.csv");
    */


    //registro é o registro.csv
    private Path registro = Paths.get("/home/cosme/projetos/Projeto-Integrador-T1/Gestor-de-Estacionamento/dados/registro.csv");
    private Path historico = Paths.get("/home/cosme/projetos/Projeto-Integrador-T1/Gestor-de-Estacionamento/dados/historico.csv");

 
    public void salvar (Carro carro) {
        try {
            //escreve no resgistro o conteudo de carro.separaDados pula uma linha
            Files.writeString(registro,carro.separaDados()+ "\n", StandardOpenOption.APPEND);
        } catch (IOException e) {
            //trata erro
            throw new RuntimeException(e);
        }
    }

    public void salvahistorico(String resgistro){
        try {
            Files.writeString(historico, resgistro+"\n", StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

/*
    public List<String> exibir (){
        List<String> nomel = new ArrayList<>();
        List<String> placal = new ArrayList<>();
        List<String> carrol = new ArrayList<>();
       // List<String> carros = new ArrayList<>();

        try {
            List<String> Linhas = Files.readAllLines(registro);
            for(String linha : Linhas){
                String[] linhaCarro = linha.split(";");
                if (linhaCarro[6].equals("true")) {
                    String placa = linhaCarro[1];
                    String modelo = linhaCarro[2];
                    String nomePropietario = linhaCarro[3];
                    String data = linhaCarro[4];
                    String hora = linhaCarro[5];

                    //formata horas
                    String diaMes = data.substring(8, 10) + "-" + data.substring(5, 7);
                    // Formata hora para HH:mm
                    String horaMin = hora.substring(0, 5);

                    // Linha formatada com colunas fixas
                    String nome = String.format(nomePropietario);
                    String placal = String.format(placa);
                    String carrol = String.format(modelo);


                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return nomel,placal,carrol;


    }

*/




    public List<String[]> exibir() {

        // lista final que a tabela vai usar
        List<String[]> carros = new ArrayList<>();

        try {
            // lê todas as linhas do arquivo
            List<String> linhas = Files.readAllLines(registro);

            // percorre cada linha do arquivo
            for (String linha : linhas) {

                // separa os dados pelo ;
                String[] dados = linha.split(";");

                // verifica se está ativo
                if (dados[6].equals("true")){

                    String placa = dados[1];
                    String modelo = dados[2];
                    String proprietario = dados[3];

                    String data = dados[4];
                    String hora = dados[5];

                    // formata data (DD-MM)
                    String diaMes =
                            data.substring(8, 10) + "-" +
                            data.substring(5, 7);

                    // formata hora (HH:mm)
                    String horaMin = hora.substring(0, 5);

                    // cria UMA linha da tabela
                    String[] linhaTabela = new String[5];
                    linhaTabela[0] = placa;
                    linhaTabela[1] = modelo;
                    linhaTabela[2] = proprietario;
                    linhaTabela[3] = diaMes;
                    linhaTabela[4] = horaMin;

                    // adiciona a linha na lista
                    carros.add(linhaTabela);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return carros;
    }



















    public String[] busca(String placaBuscada) {

        try {
            List<String> linhas = Files.readAllLines(registro);

            for (String linha : linhas) {
                String[] dados = linha.split(";");

                if (dados[1].equalsIgnoreCase(placaBuscada) && dados[6].equals("true")) {

                    String recebeValor =  calculo(dados[5], dados[4]);
                    String dataSaida = String.valueOf(LocalDate.now());
                    String horaSaida = String.valueOf(LocalTime.now());
                    return new String[]{
                            dados[0],           //id
                            dados[1],          // placa
                            dados[2],          // modelo
                            dados[3],          // proprietario
                            dados[4],          // data
                            dados[5],          // hora
                            dados[6],         // visibilidade
                            dados[7] = dataSaida,         //data de saida
                            dados[8] = horaSaida,         // hora de saida
                            dados[9] =recebeValor         // valor a pagar
                    };
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null; // não achou
    }

    public String converte (){
        String convertido= "";




        return convertido;
    };





    public String calculo(String horaEntrada, String dataEntrada){

        // Converte data e hora de entrada
        LocalDate data = LocalDate.parse(dataEntrada);
        LocalTime hora = LocalTime.parse(horaEntrada);

        LocalDateTime entrada = LocalDateTime.of(data, hora);
        LocalDateTime saida = LocalDateTime.now();

        long minutos = Duration.between(entrada, saida).toMinutes();

        double valor = 10.0; // valor base até 1h
        if (minutos > 60) {
            long minutosExtras = minutos - 60;

            // cada 60 min ou fração conta como 1 hora
            long horasExtras = (long) Math.ceil(minutosExtras / 60.0);

            valor += horasExtras * 5;
        }

        return String.format("%.2f", valor);
    }






    public boolean registrarSaida(String placaBuscada) {

        try {
            List<String> linhas = Files.readAllLines(registro);
            List<String> novasLinhas = new ArrayList<>();

            boolean atualizado = false;
            //String data = String.valueOf(LocalDate.now());
            //String horasaida = String.valueOf(LocalTime.now());


            for (String linha : linhas) {
                String[] dados = linha.split(";");

                if (dados[1].equalsIgnoreCase(placaBuscada) && dados[6].equals("true")) {
                    // altera visibilidade para false
                    dados[6] = "false";
                    //dados[]

                    // recria a linha com dados modificados
                    linha = String.join(";", dados);

                    atualizado = true;

                    String[] teste= busca(placaBuscada);
                    String conetrtido = teste[0] +";"+ teste[1]+";" + teste[2] +";"
                            + teste[3]+";"+ teste[4]+";"+ teste[5]+";"+ teste[6]+";"
                            + teste[7]+";"+ teste[8]+";"+ teste[9]+";";
                    salvahistorico(conetrtido);
                }

                novasLinhas.add(linha);
            }

            // salva tudo de volta
            Files.write(registro, novasLinhas);

            salvahistorico(Arrays.toString(busca(placaBuscada)));

            return atualizado;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
