package mx.edu.utez.model.prendas;

import mx.edu.utez.utilis.MySql;
import mx.edu.utez.utilis.Responce;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoPrendas {
    MySql client = new MySql();
    //CONEXION A BDD
    Connection con;
    //PREPARE STATEMENT
    PreparedStatement ps;
    //RESULT SET
    ResultSet rs;


    public List<BeanPrendas> findAll() {
        List<BeanPrendas> listaPersonas = new ArrayList<>();
        BeanPrendas person = null;
        BeanPrendas position = null;
        try {
            con = client.getConnection();
            ps = con.prepareStatement("SELECT pe.*,po.name FROM clothes pe INNER JOIN clothe_types po ON po.id = pe.category_id;");
            rs = ps.executeQuery();
            while (rs.next()){
                person = new BeanPrendas();
                position = new BeanPrendas();
                person.setIdP(rs.getLong("id"));
                person.setName(rs.getString("name"));
                person.setPrecio(rs.getInt("prize"));
                person.setSize(rs.getString("size"));
                person.setStock(rs.getInt("stock"));
                person.setType_clothes(rs.getString(" cloth_type"));
                position.setPrenda_id(person.prenda_id);

                person.setCategoria_id(person.categoria_id);
                listaPersonas.add(person);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoPrendas.class.getName()).log(Level.SEVERE,"Error -> "+e.getMessage());
        }finally {
            client.close(con,ps,rs);
        }
        return listaPersonas;
    }

    /*@Override
    public BeanPersonal findById(Long id) {
        BeanPersonal persona = new BeanPersonal();
        BeanPosition bpo = null;

        try {
            con = client.getConnection();
            ps = con.prepareStatement("SELECT pe.id,pe.name,pe.surname,pe.lastname,pe.salary,pe.birthday,po.description FROM personal pe INNER JOIN position po ON po.id where pe.id = ?;");
            ps.setLong(1,id);
            rs = ps.executeQuery();
            while (rs.next()){
                bpo = new BeanPosition();

                bpe.setId(rs.getLong("id"));
                bpe.setName(rs.getString("name"));
                bpe.setSurname(rs.getString("surname"));
                bpe.setLastname(rs.getString("lastname"));
                bpe.setSalary(rs.getDouble("salary"));
                bpe.setBirthday(rs.getString("birthday"));
                bpo.setDescription(rs.getString("description"));
                bpe.setPosition(bpo);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoPersonal.class.getName()).log(Level.SEVERE,"Error -> "+e.getMessage());
        }
        return null;
    }*/


    public BeanPrendas findById(Long id) {
        BeanPrendas persona = new BeanPrendas();
        BeanPrendas position;
        try {
            con = client.getConnection();
            ps = con.prepareStatement("SELECT pe.id, pe.name, pe.price, pe.size, pe.brand, pe.birthday, po.cloth_type FROM  clothes pe INNER JOIN  clothe_types po ON  po.id " +
                    "WHERE pe.id = ?;");
            ps.setLong(1, id);

            rs = ps.executeQuery();
            while (rs.next()){
                position = new BeanPrendas();
                persona.setIdP(rs.getLong("id"));
                persona.setName(rs.getString("name"));
                persona.setPrecio(rs.getInt("price"));
                persona.setSize(rs.getString("size"));
                persona.setStock(rs.getInt("brand"));
                persona.setType_clothes(rs.getString(" cloth_type"));
                persona.setPrenda_id(persona.prenda_id);
                persona.setCategoria_id(persona.categoria_id);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoPrendas.class.getName()).log(Level.SEVERE,"Error -> "+e.getMessage());
        }finally {
            client.close(con,ps,rs);
        }
        return persona;
    }

    public Responce<Object> save(BeanPrendas object) {
        BeanPrendas person = new BeanPrendas();
        try {
            con = client.getConnection();
            ps = con.prepareStatement("INSERT INTO personal (name, price , size, brand,stock,category_id) VALUES (?,?,?,?,?,?);");
            ps.setString(1,person.getName());
            ps.setDouble(2,person.getPrecio());
            ps.setString(3,person.getSize());
            ps.setDouble(4,person.getStock());
            ps.setString(5,person.getType_clothes());
            ps.setLong(6,person.getPrenda_id());
            if(ps.executeUpdate()==1){
                System.out.println("exito");
                return new Responce<Object>(200,"Error al registrar",person);
            }else{
                System.out.println("fallo");
                return new Responce<Object>(200,"Error al registrar",person);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoPrendas.class.getName()).log(Level.SEVERE, "ERROR -> "+e.getMessage());
            return new Responce<Object>(200,"Error al registrar",person);
        }finally {
            client.close(con,ps,rs);
        }
    }




    public Responce<BeanPrendas> update(BeanPrendas object) {
        return null;
    }


    public Responce<BeanPrendas> remove(Long id) {
        return null;
    }

    public BeanPrendas insertarPerson(String name, double precio, String size, int stock, String brand) {
        BeanPrendas person = new BeanPrendas();
        try {
            con = MySql.getConnection();
            ps = con.prepareStatement("INSERT INTO personal(id,nombre,)");
        }catch(SQLException e){

        }

        return null;

    }
}
