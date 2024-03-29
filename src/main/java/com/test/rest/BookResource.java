package com.test.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.test.dao.BookBeanDAO;
import com.test.data.BookBean;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * The REST API for books.
 * 
 * @author emondelo
 * 
 */
@Path("/books")
@Produces("application/json;charset=utf-8")
@Api(value = "books", description = "Books service")
public class BookResource {

    /**
     * The books DAO.
     */
    private BookBeanDAO bookBeanDAO;

    /**
     * Constructor
     */
    public BookResource() {

        this.bookBeanDAO = new BookBeanDAO();
    }

    @GET
    @ApiOperation("List the book objects according sort criteria.")
    public Response list(
            @ApiParam(value = "Field name to sort by", required = false, allowableValues = BookBean.FIELD_VALUES) @QueryParam("sortField") String sortField,
            @ApiParam(value = "Apply descending sort", required = false) @QueryParam("descendingSort") Boolean descendingSort) {

        return Response.ok(this.bookBeanDAO.list(sortField, descendingSort)).build();
    }

    @GET
    @Path("/{id}")
    @ApiOperation("Get a book object.")
    public Response get(@PathParam("id") Long id) {

        BookBean bean = this.bookBeanDAO.get(id);
        if (bean == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(bean).build();
    }

    @POST
    @Consumes("application/json;charset=utf-8")
    @ApiOperation("Save a book object.")
    public Response save(BookBean bean) {

        this.bookBeanDAO.save(bean);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    @ApiOperation("Delete a book object.")
    public Response delete(@PathParam("id") Long id) {

        BookBean bean = this.bookBeanDAO.get(id);
        if (bean == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        this.bookBeanDAO.delete(bean);
        return Response.ok().build();
    }
}
