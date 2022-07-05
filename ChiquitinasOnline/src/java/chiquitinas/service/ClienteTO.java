
package chiquitinas.service;

import java.io.Serializable;


public class ClienteTO implements Serializable{
    
    private int idCliente;
    private String nombreCliente;
    private int cedulaCliente;
    private String direccion;
    private int telefono;

    public ClienteTO() {
        this.nombreCliente = nombreCliente;
        this.cedulaCliente = cedulaCliente;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    
    public String getNombreCliente() {
        return nombreCliente;
    }

    public int getCedulaCliente() {
        return cedulaCliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public void setCedulaCliente(int cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}
