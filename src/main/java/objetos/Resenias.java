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
    private String comments;

    public Resenias() {
    }

    public Resenias(String item, String date, String comments) {
        this.item = item;
        this.date = date;
        this.comments = comments;
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
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Resenias{" + "item=" + item + ", date=" + date + ", comments=" + comments + '}';
    }
    
    
}
