/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import dto.Liga;
import dto.TipoLiga;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Patricio
 */
public class DAOLiga {
    private Session session;
    private Transaction tx;

    public void iniOperacion() {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
    }
    
    
    public boolean agregar(Liga li) {
        try {
            iniOperacion();
            session.save(li);
            tx.commit();
            session.close();
            return true;
        } catch (Exception e) {
            tx.rollback();
            session.close();
            throw new RuntimeException("No se pudo almacenar el Liga: " + e.getMessage());
        }
    }

    
    public boolean actualizar(Liga li) {
        try {
            iniOperacion();
            Liga lig = buscar(li.getIdLiga());
            lig.setNombreLiga(li.getNombreLiga());
            lig.setFechaInicio(li.getFechaInicio());
            lig.setFechaTermino(li.getFechaTermino());
            lig.setLugar(li.getLugar());
            lig.setTipoLiga(li.getTipoLiga());
            lig.setLigaResultados(li.getLigaResultados());
            session.update(lig);
            tx.commit();
            session.close();
            return true;
        } catch (Exception e) {
            tx.rollback();
            session.close();
            throw new RuntimeException("No se pudo actualizar el Liga: " + e.getMessage());
        }
    }

    
    public boolean eliminar(Object o) {
        try {
            iniOperacion();
            Liga lig = buscar(o);
            session.delete(lig);
            tx.commit();
            session.close();
            return true;
        } catch (Exception e) {
            tx.rollback();
            session.close();
            throw new RuntimeException("No se pudo eliminar el Liga: " + e.getMessage());
        }
    }

    
    public Liga buscar(Object o) {
        try {
            iniOperacion();
            List<Liga> lista = session.createQuery("from Liga where IdLiga="+o).list();
            for ( Liga lig : lista ) {
                return lig;
            }
        } catch (Exception e) {
            tx.rollback();
            session.close();
            throw new RuntimeException("No se pudo encontrar el Liga: " + e.getMessage());
        }
        return null;
    }
    public TipoLiga buscarTipo(Object o) {
        try {
            iniOperacion();
            List<TipoLiga> lista = session.createQuery("from TipoLiga where idtipo_liga='"+o+"'").list();
            for ( TipoLiga lig : lista ) {
                return lig;
            }
        } catch (Exception e) {
            tx.rollback();
            session.close();
            throw new RuntimeException("No se pudo encontrar el Liga: " + e.getMessage());
        }
        return null;
    }

    
    public List<Liga> listarTodo() {
        try {
            iniOperacion();
            List<Liga> lista = session.createQuery("from Liga").list();
            return lista;
        } catch (Exception e) {
            tx.rollback();
            session.close();
            throw new RuntimeException("No se pudo listar los Ligas: " + e.getMessage());
        }
    }
    
    
    public List<TipoLiga> ListarTipo() {
        try {
            iniOperacion();
            List<TipoLiga> lista = session.createQuery("from TipoLiga").list();
            return lista;
            
        } catch (Exception e) {
            tx.rollback();
            session.close();
            throw new RuntimeException("No se pudo encontrar el Tipo Liga: " + e.getMessage());
        }
        
    }
    
    
}
