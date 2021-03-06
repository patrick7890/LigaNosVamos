package dto;
// Generated 09-09-2018 23:17:02 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Equipo generated by hbm2java
 */
public class Equipo  implements java.io.Serializable {


     private String nombreEquipo;
     private Liga liga;
     private TipoLiga tipoLiga;
     private Usuario usuario;
     private byte estadoEquipo;
     private Set<Imagen> imagens = new HashSet<Imagen>(0);
     private Set<Integrantes> integranteses = new HashSet<Integrantes>(0);

    public Equipo() {
    }

	
    public Equipo(String nombreEquipo, Liga liga, TipoLiga tipoLiga, Usuario usuario, byte estadoEquipo) {
        this.nombreEquipo = nombreEquipo;
        this.liga = liga;
        this.tipoLiga = tipoLiga;
        this.usuario = usuario;
        this.estadoEquipo = estadoEquipo;
    }
    public Equipo(String nombreEquipo, Liga liga, TipoLiga tipoLiga, Usuario usuario, byte estadoEquipo, Set<Imagen> imagens, Set<Integrantes> integranteses) {
       this.nombreEquipo = nombreEquipo;
       this.liga = liga;
       this.tipoLiga = tipoLiga;
       this.usuario = usuario;
       this.estadoEquipo = estadoEquipo;
       this.imagens = imagens;
       this.integranteses = integranteses;
    }
   
    public String getNombreEquipo() {
        return this.nombreEquipo;
    }
    
    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }
    public Liga getLiga() {
        return this.liga;
    }
    
    public void setLiga(Liga liga) {
        this.liga = liga;
    }
    public TipoLiga getTipoLiga() {
        return this.tipoLiga;
    }
    
    public void setTipoLiga(TipoLiga tipoLiga) {
        this.tipoLiga = tipoLiga;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public byte getEstadoEquipo() {
        return this.estadoEquipo;
    }
    
    public void setEstadoEquipo(byte estadoEquipo) {
        this.estadoEquipo = estadoEquipo;
    }
    public Set<Imagen> getImagens() {
        return this.imagens;
    }
    
    public void setImagens(Set<Imagen> imagens) {
        this.imagens = imagens;
    }
    public Set<Integrantes> getIntegranteses() {
        return this.integranteses;
    }
    
    public void setIntegranteses(Set<Integrantes> integranteses) {
        this.integranteses = integranteses;
    }




}


