package mx.edu.utez.controllerTienda;
import mx.edu.utez.model.prendas.BeanPrendas;
import mx.edu.utez.model.prendas.DaoPrendas;
import mx.edu.utez.utilis.Responce;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.xml.ws.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/api/personal")
public class TiendaServices {
    Map<String,Object> response = new HashMap<>();
    @GET
    @Path("/employee")
    @Produces(value = {"application/json"})
    public Response<List> getAll() {
        return (Response<List>) new DaoPrendas().findAll();
    }

    @POST
    @Path("/")
    @Consumes(value = {"application/json"})
    @Produces(value = {"application/json"})
    public Map<String,Object> save(BeanPrendas prendas){
        //Buscar información sobre como obtener el body del -> request
        //para convertirlo a un BeanPersonal
        System.out.println(prendas.getName());
        Responce<Object> result = new DaoPrendas().save(prendas);
        response.put("result -> ",result);

        return response;
    }

    @POST
    @Path("/nuevaPersona")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public BeanPrendas savePerson(BeanPrendas prendas){
        BeanPrendas personAdd = new DaoPrendas().insertarPerson(
                prendas.getName(),
                prendas.getPrecio(),
                prendas.getSize(),
                prendas.getStock(),
                prendas.getBrand()

        );
        return personAdd;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public BeanPrendas getById(@PathParam("id") Long id){
        return new DaoPrendas().findById(id);
    }
}
