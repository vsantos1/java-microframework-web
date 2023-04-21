package com.vsantos1.legacy.core.dao;


import com.vsantos1.legacy.core.db.DatabaseFactory;
import com.vsantos1.legacy.core.repository.CrudRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.lang.reflect.Field;
import java.util.List;

public class GenericDAO<T, ID> implements CrudRepository<T, ID> {


    public GenericDAO() {
        DatabaseFactory.loadYaml();
    }

    public static EntityManager getEntityManager() {
        EntityManagerFactory factory = DatabaseFactory.getEntityManagerFactory();
        return factory.createEntityManager();
    }

    @Override
    public T save(T entity) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try {
            Field id = entity.getClass().getDeclaredField("id");
            id.setAccessible(true);
            Object value = id.get(entity);
            if (value == null) {
                em.persist(entity);
            } else {
                em.merge(entity);
            }
            em.getTransaction().commit();
            em.close();


            return entity;
        } catch (IllegalAccessException | NoSuchFieldException e) {
            throw new RuntimeException("Error while flushing data", e);
        }

    }


    @Override
    public List<T> findAll(Class<T> clazz) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();

        try {
            List<T> entites = em.createQuery("SELECT e FROM " + clazz.getSimpleName() + " e", clazz).getResultList();
            em.getTransaction().commit();
            em.close();


            return entites;
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving data, cause ", e);
        }
    }

    // TODO: Implement this method

    @Override
    public T update(T entity) {
        return null;
    }


    // TODO: Implement this method
    @Override
    public void deleteById(ID id) {
        return;
    }

    public T findById(ID id, Class<T> clazz) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();

        try {
            T entity = em.find(clazz, id);
            em.getTransaction().commit();
            em.close();

            return entity;
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving data, cause ", e);
        }
    }


    @Override
    public void delete(ID id, Class<T> clazz) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();

        try {
            T entity = em.find(clazz, id);
            em.remove(entity);
            em.getTransaction().commit();
            em.close();

        } catch (Exception e) {
            throw new RuntimeException("Error saving data", e);
        }
    }


}
