package chiquitinas.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServicioCliente extends Servicio {

    public List<ClienteTO> demeClientes() {
        List<ClienteTO> listaRetorno = new ArrayList<>();
        Connection conn = super.getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            //Paso 3 (Preparar)
            //super.conectar();
            ps = conn.prepareStatement("SELECT IDCLIENTE, CEDULA, NOMBRE, DIRECCION, TELEFONO FROM CLIENTE");
            rs = ps.executeQuery();

            //Paso 4 (Ejectuar)
            while (rs.next()) {
                int idCliente = rs.getInt("IDCLIENTE");
                int cedula = rs.getInt("CEDULA");
                String nombre = rs.getString("NOMBRE");
                String direccion = rs.getString("DIRECCION");
                int telefono = rs.getInt("TELEFONO");

                ClienteTO clienteTO = new ClienteTO();
                clienteTO.setIdCliente(idCliente);
                clienteTO.setCedulaCliente(cedula);
                clienteTO.setNombreCliente(nombre);
                clienteTO.setDireccion(direccion);
                clienteTO.setTelefono(telefono);

                listaRetorno.add(clienteTO);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
            //Paso 5 (Cerrar)  
        } finally {
            try {
                if (ps != null && !ps.isClosed()) {
                    ps.close();
                }
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            //super.desconectar();

        }
        return listaRetorno;

    }

    public List<ClienteTO> datosCliente() {
        List<ClienteTO> listaRetorno = new ArrayList<>();
        Connection conn = super.getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            //Paso 3 (Preparar)
            //super.conectar();
            ps = conn.prepareStatement("SELECT CEDULA, NOMBRE, DIRECCION, TELEFONO FROM chiquitinas.cliente ,chiquitinas.ordenes WHERE idCliente = idOrden AND IDORDEN = NUMERO");
            rs = ps.executeQuery();

            //Paso 4 (Ejectuar)
            while (rs.next()) {

                int cedula = rs.getInt("CEDULA");
                String nombre = rs.getString("NOMBRE");
                String direccion = rs.getString("DIRECCION");
                int telefono = rs.getInt("TELEFONO");

                ClienteTO clienteTO = new ClienteTO();
                clienteTO.setCedulaCliente(cedula);
                clienteTO.setNombreCliente(nombre);
                clienteTO.setDireccion(direccion);
                clienteTO.setTelefono(telefono);

                listaRetorno.add(clienteTO);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
            //Paso 5 (Cerrar)  
        } finally {
            try {
                if (ps != null && !ps.isClosed()) {
                    ps.close();
                }
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            //super.desconectar();

        }
        return listaRetorno;

    }

    public ClienteTO demeCliente(String user, int pass) {

        Connection conn = super.getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String usuario = null;
        ClienteTO clienteTO = null;
        try {

            ps = conn.prepareStatement("SELECT IDCLIENTE,CEDULA,NOMBRE,DIRECCION,TELEFONO FROM chiquitinas.cliente WHERE NOMBRE=? AND CEDULA=?");
            ps.setString(1, user);
            ps.setInt(2, pass);
            rs = ps.executeQuery();

            if (rs.next()) {

                clienteTO = new ClienteTO();

                clienteTO.setIdCliente(rs.getInt("IDCLIENTE"));
                clienteTO.setNombreCliente(rs.getString("NOMBRE"));
                clienteTO.setCedulaCliente(rs.getInt("CEDULA"));
                clienteTO.setDireccion(rs.getString("DIRECCION"));
                clienteTO.setTelefono(rs.getInt("TELEFONO"));

            }
        } catch (Exception ex) {
            ex.printStackTrace();
            //Paso 5 (Cerrar)  
        } finally {
            try {
                if (ps != null && !ps.isClosed()) {
                    ps.close();
                }
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }
        return clienteTO;
    }

    public int demeContrasena() {

        Connection conn = super.getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int contrasena = 0;

        try {

            ps = conn.prepareStatement("SELECT CEDULA FROM chiquitinas.cliente");
            rs = ps.executeQuery();

            if (rs.next()) {

                contrasena = rs.getInt("CEDULA");

            }
        } catch (Exception ex) {
            ex.printStackTrace();
            //Paso 5 (Cerrar)  
        } finally {
            try {
                if (ps != null && !ps.isClosed()) {
                    ps.close();
                }
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }
        return contrasena;
    }

    public void insertarCliente(ClienteTO clienteTO) {

        PreparedStatement ps = null;

        try {
            Connection conn = super.getConexion();
            ps = conn.prepareStatement("INSERT INTO CLIENTE(CEDULA, NOMBRE, DIRECCION, TELEFONO) VALUES(?,?,?,?)");
            ps.setInt(1, clienteTO.getCedulaCliente());
            ps.setString(2, clienteTO.getNombreCliente());
            ps.setString(3, clienteTO.getDireccion());
            ps.setInt(4, clienteTO.getTelefono());
            ps.execute();

        } catch (Exception ex) {
            ex.printStackTrace();

        } finally {
            try {
                if (ps != null && !ps.isClosed()) {
                    ps.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public int demeIdCliente() {

        Connection conn = super.getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int maxCliente = 0;

        try {

            ps = conn.prepareStatement("SELECT MAX(idCliente) as max_cliente FROM chiquitinas.cliente");
            rs = ps.executeQuery();

            if (rs.next()) {

                maxCliente = rs.getInt("max_cliente");

            }
        } catch (Exception ex) {
            ex.printStackTrace();
            //Paso 5 (Cerrar)  
        } finally {
            try {
                if (ps != null && !ps.isClosed()) {
                    ps.close();
                }
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }
        return maxCliente;
    }

    public ClienteTO buscarCliente(int cedulaParam) {

        ClienteTO retorno = new ClienteTO();
        Connection conn = super.getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            ps = conn.prepareStatement("SELECT CEDULA, NOMBRE, DIRECCION FROM CLIENTE WHERE CEDULA = ?");
            ps.setInt(1, cedulaParam);
            rs = ps.executeQuery();

            if (rs.next()) {

                int cedula = rs.getInt("CEDULA");
                String nombre = rs.getString("NOMBRE");
                String direccion = rs.getString("DIRECCION");
                int telefono = rs.getInt("TELEFONO");

                ClienteTO clienteTO = new ClienteTO();
                clienteTO.setCedulaCliente(cedula);
                clienteTO.setNombreCliente(nombre);
                clienteTO.setDireccion(direccion);
                clienteTO.setTelefono(telefono);

                retorno = clienteTO;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (ps != null && !ps.isClosed()) {
                    ps.close();
                }
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return retorno;
    }

    public void eliminarCliente(int cedulaParam) {

        Connection conn = super.getConexion();
        PreparedStatement ps = null;

        try {

            ps = conn.prepareStatement("DELETE FROM CLIENTE WHERE CEDULA = ?");
            ps.setInt(1, cedulaParam);
            ps.execute();

        } catch (Exception ex) {
            ex.printStackTrace();

        } finally {
            try {
                if (ps != null && !ps.isClosed()) {
                    ps.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

}
