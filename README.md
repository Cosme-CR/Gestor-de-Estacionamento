Projeto desenvolvido em **Java com JavaFX** para gerenciamento de entrada e saída de veículos em um estacionamento. O sistema permite registrar veículos, visualizar carros estacionados, calcular o valor a pagar e registrar a saída, salvando histórico em arquivos CSV.

---

##  Funcionalidades

- **Registro de Entrada de Veículos**
    
    - Cadastro de placa, modelo e nome do proprietário
        
    - Registro automático de data e hora de entrada
        
-  **Tela Inicial (Dashboard)**
    
    - Exibição em tabela dos veículos atualmente estacionados
        
    - Botões de acesso rápido para **Entrada** e **Saída/Pagamento**
        
-  **Registro de Saída e Pagamento**
    
    - Busca do veículo pela placa
        
    - Exibição dos dados do veículo
        
    - Cálculo automático do valor a pagar baseado no tempo estacionado
        
    - Registro da saída e gravação no histórico
        
-  **Persistência em Arquivos CSV**
    
    - `registro.csv`: veículos atualmente estacionados
        
    - `historico.csv`: histórico completo de entradas e saídas
        

---

##  Telas do Sistema

### 🔹 Tela Inicial

- Mostra os **carros estacionados** em uma `TableView`
    
- Possui dois botões principais:
    
    - **Registrar nova Entrada**
        
    - **Registrar Saída / Pagamento**
        

### 🔹 Tela de Registro de Entrada

- Formulário para cadastro do veículo
    
- Valida campos obrigatórios
    
- Impede cadastro de placas duplicadas
    

### 🔹 Tela de Saída

- Busca veículo pela placa
    
- Exibe dados completos da entrada
    
- Mostra hora de saída e valor total
    
- Permite confirmar a saída
    

---

##  Regra de Cálculo do Valor

-  **R$ 10,00** até 1 hora
    
-  **R$ 5,00** para cada hora adicional ou fração
    

O cálculo é feito automaticamente com base na diferença entre a data/hora de entrada e a data/hora atual.

---

##  Estrutura do Projeto

```
Gestor-de-Estacionamento
│
├── UI
│   ├── telaInicial.java
│   ├── telaRegistro.java
│   └── telaSaida.java
│
├── model
│   └── Carro.java
│
├── repository
│   └── CarroReposytory.java
│
├── dados
│   ├── registro.csv
│   └── historico.csv
│
└── resources
|    └── tableview.css
|    
└── HelloAplication.java
|    
└── HelloController.java
|    
└── Launcher.java
    
    
    
```

---

##  Tecnologias Utilizadas

-  **Java**
    
-  **JavaFX**
    
-  **Arquivos CSV** para persistência
    
-  **Programação Orientada a Objetos (POO)**
    

---

##  Como Executar

1. Clone o repositório:
    
    ```bash
    git clone https://github.com/seu-usuario/Gestor-de-Estacionamento.git
    ```
    
2. Abra o projeto no **IntelliJ IDEA Ultimate**
    
3. Certifique-se de que o **JavaFX** está configurado corretamente

4. Certifiquese de alterar o caminho dos arquivos na classe CarroReposytory.java para o caminho que esta a pasta dados em sua maquina (a pasta é baixada na mesma pasta do projeto) 
    
5. Execute o  arquivo **Launcher.java**
    

---

##  Autores

Projeto desenvolvido como atividade acadêmica no **SENAI Jandira**.

- [May](https://github.com/maayhsoull) – Tela Inicial
- [Anderson](https://github.com/Nephyro) – Tela de Registro
- Cosme – Tela de Saída e `CarroRepository`
    

---

