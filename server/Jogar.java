package server;

import java.net.Socket;
import java.util.Scanner;

import util.Comunicacao;
import util.Requisicao;
import util.Resposta;

public class Jogar extends Thread {
    Scanner input = null;
    Socket socket;
    Comunicacao comunicacao;

    public Jogar(Socket socket) {
        this.socket = socket;
        comunicacao = new Comunicacao(socket);
    }

    @Override
    public void run() {      
        Requisicao requisicao = (Requisicao) comunicacao.receive();
        Resposta resposta = new Resposta();

                /*Pedra ganha da tesoura (amassando-a ou quebrando-a).*/
          
                /*Tesoura ganha do papel (cortando-o).*/
       
                /*Papel ganha da pedra(embrulhando-a).*/
                input.close();
             break;
        }
    }

    /** lógica do jogo **/
}
