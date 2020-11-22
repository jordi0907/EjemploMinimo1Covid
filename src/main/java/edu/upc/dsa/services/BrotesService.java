package edu.upc.dsa.services;


import edu.upc.dsa.BrotesManager;
import edu.upc.dsa.BrotesManagerImp;
import edu.upc.dsa.models.Brotes;
import edu.upc.dsa.models.Casos;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Api(value = "/brotes", description = "Endpoint to Track Service")
@Path("/brotes")

public class BrotesService {

    private BrotesManager tm;

    public BrotesService() {
        this.tm = BrotesManagerImp.getInstance();
    }


    @POST
    @ApiOperation(value = "create a new Brote", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= Brotes.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/createbrote")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crearBrote() {

        Brotes c = this.tm.crearBrote();
        return Response.status(201).entity(c).build();
    }

    @GET
    @ApiOperation(value = "get all Brotes", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Brotes.class, responseContainer="List"),
    })
    @Path("/listarbrotes")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarBrotes() {

        List<Brotes> brotesList = this.tm.listarBrotes();

        GenericEntity<List<Brotes>> entity = new GenericEntity<List<Brotes>>(brotesList) {};
        return Response.status(201).entity(entity).build()  ;

    }



    @POST
    @ApiOperation(value = "addcaso", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response=Brotes.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/addcaso/{idBrote}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response añadirCaso(@PathParam("idBrote") String idBrote, Casos c) {

        if (c.getNombre()==null || c.getCorreo()==null)  return Response.status(500).entity(c).build();
        this.tm.añadirCaso(c,idBrote);
        return Response.status(201).entity(c).build();
    }

    @GET
    @ApiOperation(value = "get all Brotes", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Brotes.class, responseContainer="List"),
    })
    @Path("/{idBrote}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarCasos(@PathParam("idBrote") String idBrote) {

        List<Casos> casosList = this.tm.listarCasos(idBrote);

        if(casosList == null){
            return Response.status(404).build();
        }

        GenericEntity<List<Casos>> entity = new GenericEntity<List<Casos>>(casosList) {};
        return Response.status(201).entity(entity).build()  ;

    }



}
