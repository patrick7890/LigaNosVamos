/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import dto.Integrantes;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Patricio
 */
public class DAOIntegrantes {

    private Session session;
    private Transaction tx;

    public void iniOperacion() {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
    }

    public boolean agregar(Integrantes inte) {
        try {
            iniOperacion();
            session.save(inte);
            tx.commit();
            session.close();
            return true;
        } catch (Exception e) {
            tx.rollback();
            session.close();
            throw new RuntimeException("No se pudo almacenar el Integrantes: " + e.getMessage());
        }
    }

    public boolean actualizar(Integrantes inte) {
        try {
            iniOperacion();
            Integrantes in = new Integrantes();
            in.setRutIntegrante(inte.getRutIntegrante());
            in.setNombreIntegrante(inte.getNombreIntegrante());
            in.setEquipo(inte.getEquipo());
            in.setEstadoInt(inte.getEstadoInt());
            session.update(inte);
            tx.commit();
            session.close();
            return true;
        } catch (Exception e) {
            tx.rollback();
            session.close();
            throw new RuntimeException("No se pudo actualizar el Integrantes: " + e.getMessage());
        }
    }

    public boolean eliminar(Object o) {
        try {
            iniOperacion();
            Integrantes inte = buscar(o);
            session.delete(inte);
            tx.commit();
            session.close();
            return true;
        } catch (Exception e) {
            tx.rollback();
            session.close();
            throw new RuntimeException("No se pudo eliminar el Integrantes: " + e.getMessage());
        }
    }

    public Integrantes buscar(Object o) {
        try {
            iniOperacion();
            List<Integrantes> lista = session.createQuery("from Integrantes where rut_integrante='" + o + "'").list();
            for (Integrantes inte : lista) {
                return inte;
            }
        } catch (Exception e) {
            tx.rollback();
            session.close();
            throw new RuntimeException("No se pudo buscar el Integrantes: " + e.getMessage());
        }
        return null;
    }

    public List<Integrantes> listarTodo() {
        try {
            iniOperacion();
            List<Integrantes> lista = session.createQuery("from Integrantes").list();
            return lista;
        } catch (Exception e) {
            tx.rollback();
            session.close();
            throw new RuntimeException("No se pudo listar los Integrantess: " + e.getMessage());
        }
    }
    public List<Integrantes> listarTodoEquipo(Object o) {
        try {
            iniOperacion();
            List<Integrantes> lista = session.createQuery("from Integrantes equipo_nombre_equipo='"+o+"'").list();
            return lista;
        } catch (Exception e) {
            tx.rollback();
            session.close();
            throw new RuntimeException("No se pudo listar los Integrantess: " + e.getMessage());
        }
    }
}
