package dto;
// Generated 09-09-2018 17:10:23 by Hibernate Tools 4.3.1



/**
 * LigaResultado generated by hbm2java
 */
public class LigaResultado  implements java.io.Serializable {


     private LigaResultadoId id;
     private Liga liga;
     private Resultados resultados;

    public LigaResultado() {
    }

    public LigaResultado(LigaResultadoId id, Liga liga, Resultados resultados) {
       this.id = id;
       this.liga = liga;
       this.resultados = resultados;
    }
   
    public LigaResultadoId getId() {
        return this.id;
    }
    
    public void setId(LigaResultadoId id) {
        this.id = id;
    }
    public Liga getLiga() {
        return this.liga;
    }
    
    public void setLiga(Liga liga) {
        this.liga = liga;
    }
    public Resultados getResultados() {
        return this.resultados;
    }
    
    public void setResultados(Resultados resultados) {
        this.resultados = resultados;
    }




}


