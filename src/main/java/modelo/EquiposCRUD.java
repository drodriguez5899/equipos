/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author David
 */
public class EquiposCRUD {
     public static List<Equipos> getEquipos() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.mycompany_futbolCRUD_war_1.0-SNAPSHOTPU");
        EntityManager manager = factory.createEntityManager();
        String sql = "SELECT * FROM Equipos";
        Query q = manager.createNativeQuery(sql,Equipos.class); //método para consultas en SQL
        List<Equipos> equiposBD =  q.getResultList();

        return equiposBD;        
        }
     
      public static int destroyEquipo(int id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.mycompany_futbolCRUD_war_1.0-SNAPSHOTPU");
        EntityManager manager = factory.createEntityManager();
        String sql = "DELETE from Equipos e WHERE e.id = " + id;
        Query q = manager.createQuery(sql);
        manager.getTransaction().begin();
        int filasAfectadas = q.executeUpdate(); //para las consultas de modif. datos se usa el método executeUpdate
        manager.getTransaction().commit();
        return filasAfectadas;  
    }
      
      
     public static Equipos getEquipo(int id) {  //devuelve un objeto de clase Productos
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.mycompany_futbolCRUD_war_1.0-SNAPSHOTPU");
        EntityManager manager = factory.createEntityManager();
        String sql = "SELECT e FROM Equipos e WHERE e.id=" + id;
        Query q = manager.createQuery(sql,Equipos.class); //método para consultas en SQL
        Equipos miEquipo =  ( Equipos ) q.getSingleResult(); //para un único registro
        manager.close();
        return  miEquipo;
    } 
    
    public static int actualizaEquipo(Equipos miEquipo) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.mycompany_futbolCRUD_war_1.0-SNAPSHOTPU");
        EntityManager manager = factory.createEntityManager();
        String sql = "UPDATE Equipos e SET e.nombre = :nombre, e.pais = :pais, e.ciudad = :ciudad,  e.presupuesto = :presupuesto,  e.escudo = :escudo WHERE e.id = :id";
        Query q = manager.createQuery(sql,Equipos.class);
        q.setParameter("id", miEquipo.getId());
        q.setParameter("nombre", miEquipo.getNombre());
        q.setParameter("pais", miEquipo.getPais());
        q.setParameter("ciudad", miEquipo.getCiudad());
        q.setParameter("presupuesto", miEquipo.getPresupuesto());
        q.setParameter("escudo", miEquipo.getEscudo());
        
        manager.getTransaction().begin();
        int filasAfectadas = q.executeUpdate();
        manager.getTransaction().commit();
        manager.close();
        return filasAfectadas;      
    }
    
    public static void insertaEquipo(Equipos equipo) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.mycompany_futbolCRUD_war_1.0-SNAPSHOTPU");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        manager.merge(equipo);
        manager.getTransaction().commit();
        }
      
    
}
