package fr.diginamic;

import jdk.jfr.Timestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="emprunt")
public class Emprunt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //@Timestamp
    @Column(name="DATE_DEBUT")
    private Date dateDebut;

    //@Timestamp
    @Column(name="DATE_FIN")
    private Date dateFin;
    private Integer delai;

    @ManyToOne
    @JoinColumn(name="ID_CLIENT")
    private Client client;

    @ManyToMany
    @JoinTable(name="COMPO",
            joinColumns = @JoinColumn(name="ID_EMP", referencedColumnName="ID"),
            inverseJoinColumns=@JoinColumn(name="ID_LIV", referencedColumnName = "ID")
    )
    private List<Livre> livres;




    public Emprunt() {}

    @Override
    public String toString() {
        return  "ID: " + id +
                ", DATE DEBUT: " + dateDebut +
                ", DATE FIN: " + dateFin +
                ", DELAI: " + delai +
                ", CLIENT: " + client +
                ", LIVRES EMPRUNTE: " + livres;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Integer getDelai() {
        return delai;
    }

    public void setDelai(Integer delai) {
        this.delai = delai;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Livre> getLivres() {
        return livres;
    }

    public void setLivres(List<Livre> livres) {
        this.livres = livres;
    }
}
