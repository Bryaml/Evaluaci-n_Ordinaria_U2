package mx.edu.utez.model.prendas;

public class BeanPrendas {
    long idP;
    String name;
    double precio;
    String size;
    String brand;
    int stock;
    String type_clothes;
    String date;
    long categoria_id;
    long prenda_id;

    public BeanPrendas() {
    }

    public BeanPrendas(long idP, String name, double precio, String size, String brand, int stock, String type_clothes, String date, long categoria_id, long prenda_id) {
        this.idP = idP;
        this.name = name;
        this.precio = precio;
        this.size = size;
        this.brand = brand;
        this.stock = stock;
        this.type_clothes = type_clothes;
        this.date = date;
        this.categoria_id = categoria_id;
        this.prenda_id = prenda_id;
    }

    public long getIdP() {
        return idP;
    }

    public void setIdP(long idP) {
        this.idP = idP;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getType_clothes() {
        return type_clothes;
    }

    public void setType_clothes(String type_clothes) {
        this.type_clothes = type_clothes;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(long categoria_id) {
        this.categoria_id = categoria_id;
    }

    public long getPrenda_id() {
        return prenda_id;
    }

    public void setPrenda_id(long prenda_id) {
        this.prenda_id = prenda_id;
    }
}
