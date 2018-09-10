/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import dto.TipoUsuario;
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
    
    public Usuario login(String user, String pass) {
        try {
            iniOperacion();
            List<Usuario> lista = session.createQuery("FROM Usuario where Correo_Usuario='" + user + "' and Pass_Usuario='" + pass + "'").list();
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
            Usuario usu = buscarCorreo(us.getCorreoUsuario());
            usu.setNombreUsuario(us.getNombreUsuario());
            usu.setPassUsuario(us.getPassUsuario());
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

    
    public boolean eliminar(String o) {
        try {
            iniOperacion();
            Usuario usu = buscarCorreo(o);
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

    
    public Usuario buscarCorreo(String correo) {
        try {
            iniOperacion();
            List<Usuario> lista = session.createQuery("from Usuario where Correo_Usuario='"+correo+"'").list();
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
    public TipoUsuario buscarTipo(Object o) {
        try {
            iniOperacion();
            List<TipoUsuario> lista = session.createQuery("from TipoUsuario where id_tipo_usuario="+o).list();
            for ( TipoUsuario usu : lista ) {
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
    public List<TipoUsuario> listarTipo() {
        try {
            iniOperacion();
            List<TipoUsuario> lista = session.createQuery("from TipoUsuario where id_tipo_usuario >2").list();
            return lista;
        } catch (Exception e) {
            tx.rollback();
            session.close();
            throw new RuntimeException("No se pudo listar los Tipos: " + e.getMessage());
        }
    }
    public List<TipoUsuario> listarTipoAdmin() {
        try {
            iniOperacion();
            List<TipoUsuario> lista = session.createQuery("from TipoUsuario").list();
            return lista;
        } catch (Exception e) {
            tx.rollback();
            session.close();
            throw new RuntimeException("No se pudo listar los Tipos: " + e.getMessage());
        }
    }
}
