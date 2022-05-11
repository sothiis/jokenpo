package src.threads;

import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class ThreadJogadorVsJogador extends Thread{

    private Socket cliente; //serve para armazenar o retorno do accept() -> pedido de conexão
    private Scanner input = null;
    private PrintStream output = null;
    private ArrayList<ThreadJogadorVsJogador> threads;

    //CONSTRUCTOR para saber com quem a Thread ira conversar(cliente)
    public ThreadJogadorVsJogador(Socket cliente, ArrayList<ThreadJogadorVsJogador> threads) {
        this.cliente = cliente;
        this.threads = threads; //para ter o controle certo das Threads se conectando na lista
    }

    @Override
    public void run() {
        //FASE DE COMUNICAÇÃO
        try {
            //preciso de 2 obj, um para poder ler e outro para poder escrever
            //system.in(system.out.println) -> para ler o teclado / getInputStream -> ler as mensagens de determinado canal de comunicação
            input = new Scanner(cliente.getInputStream()); //para ler as mensagens que virão dentro desse canal de comunicação

            output = new PrintStream(cliente.getOutputStream()); //para escrever no canal de comunicação do cliente

            String msg1;
            String nome1;
            String msg2;
            String nome2;

                msg1 = input.nextLine(); //uso scanner para ler um texto e guardo dentro dessa variavel
                nome1 = input.nextLine();

                msg2 = input.nextLine();
                nome2 = input.nextLine();

                if(msg1.equalsIgnoreCase("1") && msg2.equalsIgnoreCase("2") || msg1.equalsIgnoreCase("2") && msg2.equalsIgnoreCase("3") || msg1.equalsIgnoreCase("3") && msg2.equalsIgnoreCase("1")) {
                    //CPU vence
                    output.println("Jogador " + nome2 + " venceu!");
                }else if(msg2.equalsIgnoreCase("1") && msg1.equalsIgnoreCase("2") || msg2.equalsIgnoreCase("2") && msg1.equalsIgnoreCase("3") || msg2.equalsIgnoreCase("3") && msg1.equalsIgnoreCase("1")) {
                    //Usuário VENCEU da CPU
                    output.println("Jogador " + nome1 + " venceu!");
                }else {
                    output.println("Empatou");
                }



        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //FASE DE ENCERRAMENTO DA CONEXÃO
        try {
            input.close();
            cliente.close();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //quando o construtor criar a thread, ele ira passar como param um Socket
    }

}
