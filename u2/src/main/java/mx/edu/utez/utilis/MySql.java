package mx.edu.utez.utilis;

import java.sql.*;

public class MySql {
    public static Connection getConnection(){
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            return   DriverManager.getConnection("jdbc:mysql://localhost:3306/shop","root","root");
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static  void main (String[] args){
        try {
            Connection conexion = MySql.getConnection();
            if(conexion != null) {
                System.out.println("conectado");
                conexion.close();
            } else {
                System.out.println("no conectado");
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void close (Connection conn, PreparedStatement ps, ResultSet rs){
        try{
            if (conn!= null)
                conn.close();
            if (ps!=null)
                ps.close();
            if (rs!=null)
                rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
