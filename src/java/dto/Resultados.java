package dto;
// Generated 09-09-2018 22:57:04 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Resultados generated by hbm2java
 */
public class Resultados  implements java.io.Serializable {


     private Integer idResultados;
     private String equipo1;
     private String equipo2;
     private String ganador;
     private Date fechaResultado;
     private Set<LigaResultado> ligaResultados = new HashSet<LigaResultado>(0);

    public Resultados() {
    }

	
    public Resultados(String equipo1, String equipo2, String ganador, Date fechaResultado) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.ganador = ganador;
        this.fechaResultado = fechaResultado;
    }
    public Resultados(String equipo1, String equipo2, String ganador, Date fechaResultado, Set<LigaResultado> ligaResultados) {
       this.equipo1 = equipo1;
       this.equipo2 = equipo2;
       this.ganador = ganador;
       this.fechaResultado = fechaResultado;
       this.ligaResultados = ligaResultados;
    }
   
    public Integer getIdResultados() {
        return this.idResultados;
    }
    
    public void setIdResultados(Integer idResultados) {
        this.idResultados = idResultados;
    }
    public String getEquipo1() {
        return this.equipo1;
    }
    
    public void setEquipo1(String equipo1) {
        this.equipo1 = equipo1;
    }
    public String getEquipo2() {
        return this.equipo2;
    }
    
    public void setEquipo2(String equipo2) {
        this.equipo2 = equipo2;
    }
    public String getGanador() {
        return this.ganador;
    }
    
    public void setGanador(String ganador) {
        this.ganador = ganador;
    }
    public Date getFechaResultado() {
        return this.fechaResultado;
    }
    
    public void setFechaResultado(Date fechaResultado) {
        this.fechaResultado = fechaResultado;
    }
    public Set<LigaResultado> getLigaResultados() {
        return this.ligaResultados;
    }
    
    public void setLigaResultados(Set<LigaResultado> ligaResultados) {
        this.ligaResultados = ligaResultados;
    }




}


