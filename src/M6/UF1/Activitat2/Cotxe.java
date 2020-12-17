package M6.UF1.Activitat2;

import java.io.Serializable;

public class Cotxe implements Serializable {
    //Implementa la interfície Serializable
    private String marca;
    private String model;
    private int any;
    private String matricula;

    public Cotxe(String marca, String model, int any, String matricula) {

        this.marca = marca;
        this.model = model;
        this.any = any;
        this.matricula = matricula;
    }
    public Cotxe() {

    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return model;
    }
    public void setModelo(String modelo) {
        this.model = modelo;
    }
    public int getAny() {
        return any;
    }
    public void setAny(int any) {
        this.any = any;
    }
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }


}