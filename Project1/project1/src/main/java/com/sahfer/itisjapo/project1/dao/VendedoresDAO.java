/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sahfer.itisjapo.project1.dao;

import com.sahfer.itisjapo.project1.entity.Vendedores;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

import static com.sahfer.itisjapo.project1.core.Util.UNIT_PERSISTENCE;

/**
 * @author Jose Pino
 */
public class VendedoresDAO {

    public void create(Vendedores vendedores) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(UNIT_PERSISTENCE);
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {


            em.persist(vendedores);
            em.getTransaction().commit();
        } catch (Exception e) {
            new RuntimeException();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Vendedores> getAll() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory(UNIT_PERSISTENCE);
        EntityManager em = emf.createEntityManager();
        List<Vendedores> obj = null;
        em.getTransaction().begin();
        try {

            obj = em.createNamedQuery("Vendedores.findAll", Vendedores.class).getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();

        } finally {
            em.close();
        }
        return obj;

    }

    public Vendedores findVendedores(Integer id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(UNIT_PERSISTENCE);
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Vendedores.class, id);
        } finally {
            em.close();
        }
    }

    public void deleteVendedor(Vendedores vendedores) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory(UNIT_PERSISTENCE);
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        try {
            vendedores=em.find(Vendedores.class,vendedores.getIdVendedor());
            em.remove(vendedores);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();

        } finally {
            em.close();
        }


    }

    public List<String[]> runQuery(String query){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(UNIT_PERSISTENCE);
        EntityManager em = emf.createEntityManager();
        Query q = em.createNativeQuery(query);
        List<String[]> data = q.getResultList();
        return data;
    }
}
