package com.tunedapps.regestration.rest;

import com.tunedapps.regestration.entities.Student;
import com.tunedapps.regestration.repository.Repository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;

@Path("/students")
public class StudentsController {

    @Inject
    private Repository<Long, Student> repository;

    @Path("/{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
    public Response getStudent(@PathParam("id") long id) {
        Student student = this.repository.findById(id);
        if (student == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(student).build();
    }

    @Path("/{id}")
    @DELETE
    public Response deleteStudent(@PathParam("id") long id){
        Student student = repository.findById(id);
        if (student == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        repository.delete(id);
        return Response.noContent().build();
    }

    @Path("/{id}")
    @PUT
    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
    @Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
    public Response updateStudent(@PathParam("id") long id, Student student){
        Student oldStudent = repository.findById(id);
        if (oldStudent == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        repository.update(id, student);
        return Response.ok(repository.findById(student.getId())).build();
    }

    @Path("")
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
    public Response createStudent(Student student) throws URISyntaxException {
        return Response.created(new URI("/students/" + repository.create(student))).build();
    }
}
