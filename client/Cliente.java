package client;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import util.Comunicacao;
import util.Requisicao;
import util.Resposta;

public class Cliente {
    Socket socket;
    Scanner input = null;
    Scanner tipoJogo = null;
    PrintStream output = null;
    Scanner scanner = new Scanner(System.in);{

/*MENU*/
    System.out.println("* * * * * * ");
    System.out.println("JOKENPO");
    System.out.println("* * * * * *");
    System.out.println("MENU");
    System.out.println("Qual tipo de jogo quer jogar?");
    System.out.println("Opções:");
    System.out.println("1) Jogador Vs CPU:");
    System.out.println("2) Jogador Vs Jogador");
    System.out.println("Digite CPU para jogar contra a CPU ou 02 para ");
    int escolha = Integer.parseInt(scanner.nextLine());
    /** AQUI PRECISA SER ESCOLHIDO O TIPO DE JOGO */
    System.out.println("O jogo irá começar, se prepare!");
    /* System.out.println("Agora você está jogando contra a CPU!"); */
    /* AQUI JOGO CONTRA CPU */
    /* System.out.println("Agora você está jogando contra outro jogador"); */
    System.out.println("(1) Pedra, (2) Papel, (3) Tesoura");

    /*PEDIDO CONEXÃO*/
    if (tipoJogo == 01) { 
            final int PORT = 1234;
            final String IP = "127.0.0.1";
            
            try {
                socket = new Socket(IP, PORT);
            } catch (Exception e) {
                System.out.println("Não foi possível fazer a conexão ao servidor.");
                return;
            }

            
        } else if (tipoJogo == 02) {
            final int PORT = 123456;
            final String IP = "127.0.0.1";
             
            try {
                socket = new Socket(IP, PORT);
            } catch (Exception e) {
                System.out.println("Não foi possível fazer a conexão ao servidor.");
                return;
            }
        }

/*COMUNICAÇÃO/REQUISIÇÃO/RESPOSTA*/

    Requisicao requisicao = new Requisicao();

    Comunicacao comunicacao = new Comunicacao(socket);

    comunicacao.send(requisicao);

    Resposta resposta = (Resposta) comunicacao.receive();

/*ENCERRANDO A CONEXÃO*/
    try {
        output.close();
        socket.close();
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }

 
}
}
