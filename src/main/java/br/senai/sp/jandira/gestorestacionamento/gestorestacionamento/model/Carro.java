package br.senai.sp.jandira.gestorestacionamento.gestorestacionamento.model;

public class Carro {
    //dados do carro
    public String id ;
    public String placa ;
    public String modelo;
    public String nomePropietario;
    public String data;
    public String hora;
    public boolean visibilidade;


    public String datasaida;
    public String horasaida;
    public int valorAPagar;




    public String separaDados (){
        String dadosEmLinha;

         dadosEmLinha = id + ";" + placa + ";" + modelo + ";" + nomePropietario + ";" + data + ";" + hora + ";" + visibilidade+";" + datasaida + ";" + horasaida+ ";"+valorAPagar;

        return dadosEmLinha;

    };

}
