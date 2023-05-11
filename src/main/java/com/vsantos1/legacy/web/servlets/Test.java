package com.vsantos1.legacy.web.servlets;

import com.vsantos1.legacy.core.annotations.PathVariable;
import com.vsantos1.legacy.core.annotations.RequestMapping;
import com.vsantos1.legacy.core.enums.ContentType;
import com.vsantos1.legacy.core.enums.HttpMethod;
import com.vsantos1.legacy.core.enums.HttpStatus;
import com.vsantos1.legacy.core.response.Response;
import com.vsantos1.legacy.core.router.Controller;
import com.vsantos1.legacy.web.models.Category;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/api/*")
public class Test extends Controller {

    @RequestMapping(value = "/test", method = HttpMethod.GET, contentType = ContentType.APPLICATION_JSON)
    public void getExample(HttpServletResponse response) {
        Response.status(HttpStatus.OK).body(new Category(2L, "name", "description")).build(response);

    }

    @RequestMapping(value = "/test/{id}", method = HttpMethod.GET, contentType = ContentType.APPLICATION_JSON)
    public void getByIdExample(@PathVariable("id") Long id, HttpServletResponse response) {
        Response.status(HttpStatus.OK).body(new Category(2L, "name", "description")).build(response);

    }

    @RequestMapping(value = "/test/create", method = HttpMethod.POST, contentType = ContentType.APPLICATION_JSON)
    public void putExample(HttpServletResponse response) {

        Response.status(HttpStatus.CREATED).body(new Category(2L, "name", "description")).build(response);
    }

    @RequestMapping(value = "/test/edit/{id}", method = HttpMethod.PUT, contentType = ContentType.APPLICATION_JSON)
    public void postExample(@PathVariable("id") Long id, HttpServletResponse response) {

        Response.status(HttpStatus.OK).body(new Category(2L, "name", "description")).build(response);

    }

    @RequestMapping(value = "/test/delete/{id}", method = HttpMethod.DELETE)
    public void deleteExample(@PathVariable("id") Long id, HttpServletResponse response) {

        Response.status(HttpStatus.NO_CONTENT).build(response);
    }


}
