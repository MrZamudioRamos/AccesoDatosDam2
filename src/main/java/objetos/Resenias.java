/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

/**
 *
 * @author dam2
 */

public class Resenias {
    private String item;
    private String date;
    private String comment;

    public Resenias() {
    }

    public Resenias(String item, String date, String comment) {
        this.item = item;
        this.date = date;
        this.comment = comment;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getString() {
        return date;
    }

    public void setString(String date) {
        this.date = date;
    }

    public String getComments() {
        return comment;
    }

    public void setComments(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Resenias{" + "item=" + item + ", date=" + date + ", comment=" + comment + '}';
    }
    
    
}
