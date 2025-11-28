package fr.diginamic;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="livre")
public class Livre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titre;
    private String auteur;

    @ManyToMany
    @JoinTable(name="COMPO",
            joinColumns = @JoinColumn(name="ID_LIV", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name="ID_EMP", referencedColumnName = "ID")
    )
    private List<Emprunt> emprunts;


    public Livre() {}

    @Override
    public String toString() {
        return  "ID: " + id +
                ", TITRE: " + titre +
                ", AUTEUR: " + auteur;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }
}
