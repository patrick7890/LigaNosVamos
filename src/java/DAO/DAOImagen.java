/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import dto.Imagen;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Duoc
 */
public class DAOImagen {
    private Session session;
    private Transaction tx;

    public void iniOperacion() {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
    }
    
    public boolean agregarI(Imagen img){
        try {
            iniOperacion();
            
            session.save(img);
            tx.commit();
            session.close();
            return true;
        } catch (Exception e) {
            tx.rollback();
            session.close();
            throw new RuntimeException("No se pudo almacenar la imagen: " + e.getMessage());
        }
    }
    
    public Imagen buscarXLiga(Object o){
        try {
            iniOperacion();
            List<Imagen> lista = session.createQuery("from Imagen img join Liga li on img.liga_id_liga = li.id_liga where img.id_imagen = '"+o+"'").list();
            for ( Imagen img : lista ) {
                return img;
            }           
        } catch (Exception e) {
            tx.rollback();
            session.close();
            throw new RuntimeException("No se pudo encontrar la imagen: " + e.getMessage());
        }
        return null;
    }
    
    public Imagen buscarXIntegrante(Object o){
        try {
            iniOperacion();
            List<Imagen> lista = session.createQuery("from Imagen img join Integrantes li on img.integrantes_rut_integrante = li.rut_integrante where img.id_imagen = '"+o+"'").list();
            for ( Imagen img : lista ) {
                return img;
            }           
        } catch (Exception e) {
            tx.rollback();
            session.close();
            throw new RuntimeException("No se pudo encontrar la imagen: " + e.getMessage());
        }
        return null;
    }
    
    public Imagen buscarXEquipo(Object o){
        try {
            iniOperacion();
            List<Imagen> lista = session.createQuery("from Imagen img join Equipo li on img.equipo_id_equipo = li.id_equipo where img.id_imagen = '"+o+"'").list();
            for ( Imagen img : lista ) {
                return img;
            }           
        } catch (Exception e) {
            tx.rollback();
            session.close();
            throw new RuntimeException("No se pudo encontrar la imagen: " + e.getMessage());
        }
        return null;
    }
    
}
