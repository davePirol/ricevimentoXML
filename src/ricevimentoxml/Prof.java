/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ricevimentoxml;

/**
 *
 * @author pirolo_davide
 */
public class Prof {
    
    private int ID;
    private String nome,giorno,note,ora;
    
    
    public Prof(){
        
    }
    public Prof(int ID, String ora, String nome, String giorno) {
        this.ID = ID;
        this.ora = ora;
        this.nome = nome;
        this.giorno = giorno;
    }

    public Prof(int ID, String ora, String nome, String giorno, String note) {
        this.ID = ID;
        this.ora = ora;
        this.nome = nome;
        this.giorno = giorno;
        this.note = note;
    }
    public String toString(){
        String s=ID+";"+nome+";"+giorno+";"+ora+";"+note;
        return s;
    }
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getOra() {
        return ora;
    }

    public void setOra(String ora) {
        this.ora = ora;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGiorno() {
        return giorno;
    }

    public void setGiorno(String giorno) {
        this.giorno = giorno;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

}
