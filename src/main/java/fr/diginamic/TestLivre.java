package fr.diginamic;

import javax.persistence.*;
import java.util.List;

public class TestLivre {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_bibliotheque");
        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Livre livre = em.find(Livre.class, 1);
        System.out.println("---------------------------------------");
        System.out.println(livre);
        System.out.println("---------------------------------------");
        Livre livre2 = em.find(Livre.class, 3);
        System.out.println("---------------------------------------");
        System.out.println(livre2);
        System.out.println("---------------------------------------");

        System.out.println("---------------------------------------");

        TypedQuery<Emprunt> query = em.createQuery("SELECT e FROM Emprunt e WHERE e.id = :id", Emprunt.class);
        query.setParameter("id", 1);
        Emprunt emprunt2 = query.getSingleResult();
        System.out.println(emprunt2);

        //Avoir emprunt de id 1 avec find
        Emprunt emprunt = em.find(Emprunt.class, 1);
        System.out.println("---------------------------------------");
        System.out.println(emprunt);

        //Avoir les emprunts selon id client avec SELECT
        TypedQuery<Emprunt> query2 = em.createQuery("SELECT e FROM Emprunt e WHERE e.client.id = :id", Emprunt.class);
        query2.setParameter("id", 2);
        List<Emprunt> emprunts = query2.getResultList();
        System.out.println("-------------------------------------");
        System.out.println(emprunts);

        //Avoir les emprunts selon id client avec SELECT avec find

        /*Client client2 = em.find(Client.class, 1);
        List<Emprunt> emprunts = client2.getEmprunts();
        System.out.println("-------------------------------------");
        System.out.println(emprunts);*/

        transaction.commit();
        em.close();

    }
}
