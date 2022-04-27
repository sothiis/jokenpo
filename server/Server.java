package server;

import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        final int PORT = 1234;
        final String IP = "127.0.0.1";
        Socket socket;
        Scanner scanner = new Scanner(System.in);

        try {
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
            /*.....*/

        }

    }
}