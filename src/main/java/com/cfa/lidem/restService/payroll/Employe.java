package com.cfa.lidem.restService.payroll;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Employe {

    private @Id @GeneratedValue long id;
    private String nom;
    private String role;

    public Employe() {
    }

    public Employe( String nom, String role) {
        this.nom = nom;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employe employe = (Employe) o;
        return id == employe.id && Objects.equals(nom, employe.nom) && Objects.equals(role, employe.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, role);
    }
}
