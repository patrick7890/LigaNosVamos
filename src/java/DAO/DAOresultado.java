/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import dto.Resultados;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Lennon
 */
public class DAOresultado {
    
    private Session session;
    private Transaction tx;

    public void iniOperacion() {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
    }
    
    public boolean agregar(Resultados resul) {
        try {
            iniOperacion();
            session.save(resul);
            tx.commit();
            session.close();
            return true;
        } catch (Exception e) {
            tx.rollback();
            session.close();
            throw new RuntimeException("No se pudo almacenar el Resultados: " + e.getMessage());
        }
    }

    
    public boolean actualizar(Resultados resul) {
        try {
            iniOperacion();
            Resultados resultado = buscar(resul.getIdResultados());
            resultado.setEquipo1(resul.getEquipo1());
            resultado.setEquipo2(resul.getEquipo2());
            resultado.setFechaResultado(resul.getFechaResultado());
            resultado.setGanador(resul.getGanador());
            resultado.setIdResultados(resul.getIdResultados());
            resultado.setLigaResultados(resul.getLigaResultados());
            
            session.update(resultado);
            tx.commit();
            session.close();
            return true;
        } catch (Exception e) {
            tx.rollback();
            session.close();
            throw new RuntimeException("No se pudo actualizar el Resultados: " + e.getMessage());
        }
    }

    
    public boolean eliminar(Object resul) {
        try {
            iniOperacion();
            Resultados resultado = buscar(resul);
            session.delete(resultado);
            tx.commit();
            session.close();
            return true;
        } catch (Exception e) {
            tx.rollback();
            session.close();
            throw new RuntimeException("No se pudo eliminar el Resultados: " + e.getMessage());
        }
    }

    
    public Resultados buscar(Object o) {
        try {
            iniOperacion();
            List<Resultados> lista = session.createQuery("from resultados where Id_resultados="+o).list();
            for ( Resultados resul : lista ) {
                return resul;
            }
        } catch (Exception e) {
            tx.rollback();
            session.close();
            throw new RuntimeException("No se pudo beqcar el Resultados: " + e.getMessage());
        }
        return null;
    }

    
    public List<Resultados> listarTodo() {
        try {
            iniOperacion();
            List<Resultados> lista = session.createQuery("from resultados").list();
            return lista;
        } catch (Exception e) {
            tx.rollback();
            session.close();
            throw new RuntimeException("No se pudo listar los Resultadoss: " + e.getMessage());
        }
    }
    
    
}
