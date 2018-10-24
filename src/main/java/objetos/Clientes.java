/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import java.util.List;

/**
 *
 * @author dam2
 */
public class Clientes {
    private String id;
    private String name;
    private String phone;
    private List<Resenias>  resenias;
    
    public Clientes() {
    }

    public Clientes(String id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Resenias> getResenias() {
        return resenias;
    }

    public void setResenias(List<Resenias> resenias) {
        this.resenias = resenias;
    }
  
    @Override
    public String toString() {
        return "Clientes{" + "id=" + id + ", name=" + name + ", phone=" + phone + '}';
    }
    
    
}
