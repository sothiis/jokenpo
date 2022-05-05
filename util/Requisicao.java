package util;

import java.io.Serializable;

public class Requisicao implements Serializable {
    private int papel, tesoura, pedra;

    public Requisicao(int papel, int tesoura, int pedra) {
        this.papel = papel;
        this.tesoura = tesoura;
        this.pedra = pedra;

    }

    public int getPapel(){
        return papel;

    }

    public int getTesoura() {
        return tesoura;
    }

    public int getPedra() {
        return pedra;
    }


}
