/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import dto.Usuario;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Patricio
 */
public class DAOUsuario {
    private Session session;
    private Transaction tx;

    public void iniOperacion() {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
    }
    
    public Usuario Login(String user, String pass) {
        try {
            iniOperacion();
            List<Usuario> lista = session.createQuery("FROM Usuario where CorreoUsuario='" + user + "' and PassUsuario='" + pass + "'").list();
            for (Usuario aux : lista) {
                if (aux.getCorreoUsuario().equals(user) && aux.getPassUsuario().equals(pass)) {
                    return aux;
                }
            }
        } catch (Exception e) {
            tx.rollback();
            session.close();
            throw new RuntimeException("Error" + e.getMessage());
        }
        return null;
    }
    
    public boolean agregar(Usuario us) {
        try {
            iniOperacion();
            session.save(us);
            tx.commit();
            session.close();
            return true;
        } catch (Exception e) {
            tx.rollback();
            session.close();
            throw new RuntimeException("No se pudo almacenar el Usuario: " + e.getMessage());
        }
    }

    
    public boolean actualizar(Usuario us) {
        try {
            iniOperacion();
            Usuario usu = buscar(us.getIdUsuario());
            usu.setNombreUsuario(us.getNombreUsuario());
            usu.setPassUsuario(us.getPassUsuario());
            usu.setCorreoUsuario(us.getCorreoUsuario());
            usu.setEquipos(us.getEquipos());
            usu.setTipoUsuario(us.getTipoUsuario());
            session.update(usu);
            tx.commit();
            session.close();
            return true;
        } catch (Exception e) {
            tx.rollback();
            session.close();
            throw new RuntimeException("No se pudo actualizar el Usuario: " + e.getMessage());
        }
    }

    
    public boolean eliminar(Object o) {
        try {
            iniOperacion();
            Usuario usu = buscar(o);
            session.delete(usu);
            tx.commit();
            session.close();
            return true;
        } catch (Exception e) {
            tx.rollback();
            session.close();
            throw new RuntimeException("No se pudo eliminar el Usuario: " + e.getMessage());
        }
    }

    
    public Usuario buscar(Object o) {
        try {
            iniOperacion();
            List<Usuario> lista = session.createQuery("from Usuario where IdUsuario="+o).list();
            for ( Usuario usu : lista ) {
                return usu;
            }
        } catch (Exception e) {
            tx.rollback();
            session.close();
            throw new RuntimeException("No se pudo buscar el Usuario: " + e.getMessage());
        }
        return null;
    }

    
    public List<Usuario> listarTodo() {
        try {
            iniOperacion();
            List<Usuario> lista = session.createQuery("from Usuario").list();
            return lista;
        } catch (Exception e) {
            tx.rollback();
            session.close();
            throw new RuntimeException("No se pudo listar los Usuarios: " + e.getMessage());
        }
    }
}
