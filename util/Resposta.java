package util;

import java.io.Serializable;

public class Resposta implements Serializable {

    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
