package com.example.biblioteca.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
public class Emprestimo {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @NotNull
    private User usuario;

    @ManyToOne
    @NotNull
    private Exemplares exemplar ;

    @NotNull
    private LocalDate  data_emprestimo;

    @NotNull
    private LocalDate  dataDev;

    private boolean devolvido = false;

    public Exemplares getExemplar() {
        return exemplar;
    }

    public User getUsuario() {
        return usuario;
    }

    public LocalDate  getData_emprestimo() {
        return data_emprestimo;
    }

    public LocalDate  getData_dev() {
        return dataDev;
    }

    public void setExemplar(Exemplares exemplar) {
        this.exemplar = exemplar;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    public void setData_emprestimo(LocalDate data_emprestimo) {
        this.data_emprestimo = data_emprestimo;
    }

    public void setData_dev(LocalDate  data_dev) {
        this.dataDev = data_dev;
    }

    public boolean isDevolvido() {
        return devolvido;
    }

    public void setDevolvido(boolean devolvido) {
        this.devolvido = devolvido;
    }




}
