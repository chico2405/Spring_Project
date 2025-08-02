package com.example.biblioteca.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.util.Date;

@Entity
public class Emprestimo {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    private User usuario;

    @ManyToOne
    private Exemplares exemplar ;

    private Date data_emprestimo;
    private Date data_dev;

    public Exemplares getExemplar() {
        return exemplar;
    }

    public User getUsuario() {
        return usuario;
    }

    public Date getData_emprestimo() {
        return data_emprestimo;
    }

    public Date getData_dev() {
        return data_dev;
    }

    public void setExemplar(Exemplares exemplar) {
        this.exemplar = exemplar;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    public void setData_emprestimo(Date data_emprestimo) {
        this.data_emprestimo = data_emprestimo;
    }

    public void setData_dev(Date data_dev) {
        this.data_dev = data_dev;
    }



}
