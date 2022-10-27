package mx.edu.utez.utilis;

public class Responce <T>{
    Integer status;
    Boolean error;
    String message;
    T data;

    public Responce(T i, T registrado_correctamente, T person) {
    }

    public static void put(String s, Responce<Object> result) {
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
