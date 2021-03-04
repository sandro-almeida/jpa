package br.com.pessoal.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteCriaTabelas {

    public static void main (String[] args) {
        // "contas" eh a persistence-unit, definida no arquivo persistence.xml.
        // Este codigo ja criara nossas tabelas para podermos utilizar o EntityManager
        // com o ambiente ja pronto.
        //
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager entityManager = emf.createEntityManager();
        entityManager.close();

    }
}

