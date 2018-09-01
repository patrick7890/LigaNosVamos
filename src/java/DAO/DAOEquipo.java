/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import dto.Equipo;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Patricio
 */
public class DAOEquipo {
    private Session session;
    private Transaction tx;

    public void iniOperacion() {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
    }
    
    
    public boolean agregar(Equipo eq) {
        try {
            iniOperacion();
            session.save(eq);
            tx.commit();
            session.close();
            return true;
        } catch (Exception e) {
            tx.rollback();
            session.close();
            throw new RuntimeException("No se pudo almacenar el Equipo: " + e.getMessage());
        }
    }

    
    public boolean actualizar(Equipo eq) {
        try {
            iniOperacion();
            Equipo equ = buscar(eq.getIdEquipo());
            equ.setNombreEquipo(eq.getNombreEquipo());
            equ.setEstadoEquipo(eq.getEstadoEquipo());
            equ.setUsuario(eq.getUsuario());
            equ.setLiga(eq.getLiga());
            equ.setTipoLiga(eq.getTipoLiga());
            session.update(equ);
            tx.commit();
            session.close();
            return true;
        } catch (Exception e) {
            tx.rollback();
            session.close();
            throw new RuntimeException("No se pudo actualizar el Equipo: " + e.getMessage());
        }
    }

    
    public boolean eliminar(Object o) {
        try {
            iniOperacion();
            Equipo equ = buscar(o);
            session.delete(equ);
            tx.commit();
            session.close();
            return true;
        } catch (Exception e) {
            tx.rollback();
            session.close();
            throw new RuntimeException("No se pudo eliminar el Equipo: " + e.getMessage());
        }
    }

    
    public Equipo buscar(Object o) {
        try {
            iniOperacion();
            List<Equipo> lista = session.createQuery("from Equipo where IdEquipo="+o).list();
            for ( Equipo equ : lista ) {
                return equ;
            }
        } catch (Exception e) {
            tx.rollback();
            session.close();
            throw new RuntimeException("No se pudo beqcar el Equipo: " + e.getMessage());
        }
        return null;
    }

    
    public List<Equipo> listarTodo() {
        try {
            iniOperacion();
            List<Equipo> lista = session.createQuery("from Equipo").list();
            return lista;
        } catch (Exception e) {
            tx.rollback();
            session.close();
            throw new RuntimeException("No se pudo listar los Equipos: " + e.getMessage());
        }
    }
}
