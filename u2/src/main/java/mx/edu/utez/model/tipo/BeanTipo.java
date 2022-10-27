package mx.edu.utez.model.tipo;

public class BeanTipo {
    long idT;
    String name;

    public BeanTipo() {
    }

    public BeanTipo(long idT, String name) {
        this.idT = idT;
        this.name = name;
    }

    public long getIdT() {
        return idT;
    }

    public void setIdT(long idT) {
        this.idT = idT;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
