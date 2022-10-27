package mx.edu.utez.model;

import javax.xml.ws.Response;
import java.util.List;

public interface Respository<T> {

    Response<List> findAll();
    Response<T> findOne(Long id);
    Response<T> save(T object);
    Response<T> update(T object);
    Response<T> delete(Long id);

}
