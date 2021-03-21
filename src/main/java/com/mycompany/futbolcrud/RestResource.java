/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.futbolcrud;

import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import modelo.Equipos;
import modelo.EquiposCRUD;

/**
 * REST Web Service
 *
 * @author David
 */
@Path("rest")
public class RestResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RestResource
     */
    public RestResource() {
    }

    /**
     * Retrieves representation of an instance of com.mycompany.futbolcrud.RestResource
     * @return an instance of java.lang.String
     */
    @GET
     public String ping(){
              return "Probando Rest ";
    }
     
     
      @GET
    @Path("/equipo/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Equipos getEquipoJson(@PathParam("id") int id) {
        Equipos miEquipo = EquiposCRUD.getEquipo(id);
        return miEquipo;
    }
    
    
    
    
    @GET
    @Path("/equipos/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Equipos> getEquipos() {
        List<Equipos> miEquipo = EquiposCRUD.getEquipos();
        return miEquipo;
    }
    
    
    
    @PUT
    @Path("/equipo/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Equipos updateEquipo(Equipos equ) {
        EquiposCRUD.actualizaEquipo(equ);
        return equ;
               
    }
    
    @POST
    @Path("/equipo/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void setEquipo(Equipos equ) {
        EquiposCRUD.insertaEquipo(equ);
    }
    
    @DELETE
    @Path("/equipo/{id}")
    public void deleteEquipo(@PathParam("id") int id) {
        EquiposCRUD.destroyEquipo(id);
    }
   
    

    /**
     * PUT method for updating or creating an instance of RestResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
