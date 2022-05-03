package client;

import java.net.Socket;
import java.util.Scanner;
import util.Comunicacao;
import util.Requisicao;
import util.Resposta;

public class Cliente {
    final int PORT = 1234;
    final String IP = "127.0.0.1";
    Socket socket;
    double jogotipo1, jogotipo2;
    
    Scanner scanner = new Scanner(System.in);

    try
    {
        socket = new Socket(IP, PORT);

        System.out.println("* * * * * * ");
        System.out.println("JOKENPO");
        System.out.println("* * * * * *");
        System.out.println("MENU");
        System.out.println("Qual tipo de jogo quer jogar?");
        System.out.println("Opções:");
        System.out.println("1) Jogador Vs CPU:");
        System.out.println("2) Jogador Vs Jogador");
        System.out.println("Digite 1 ou 2 para iniciar o jogo");
        /*GUADAR ESCOLHA*/
        /**AQUI PRECISA SER ESCOLHIDO O TIPO DE JOGO*/
        System.out.println("O jogo irá começar, se prepare!");

       
        
        Requisicao requisicao = new Requisicao();
        /**/

        Comunicacao comunicacao = new Comunicacao(socket);

        comunicacao.send(requisicao);

        Resposta resposta = (Resposta) comunicacao.receive();

        /*if */
        scanner.close();
    } catch(Exception e)
    {
        System.out.println(e.getMessage());
    }
}}
