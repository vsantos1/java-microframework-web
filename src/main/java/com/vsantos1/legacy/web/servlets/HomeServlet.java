package com.vsantos1.legacy.web.servlets;

import com.google.gson.JsonObject;
import com.vsantos1.legacy.core.enums.ContentType;
import com.vsantos1.legacy.core.response.Response;

import com.vsantos1.legacy.web.models.Category;
import com.vsantos1.legacy.core.enums.HttpStatus;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "home", urlPatterns = "/home")
public class HomeServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        List<Category> categories = new ArrayList<>();
        categories.add(new Category(1L, "A", "Testando"));
        categories.add(new Category(2L, "B", "Testando"));
        categories.add(new Category(3L, "C", "Testando"));
        categories.add(new Category(4L, "D", "Testando"));
        categories.add(new Category(5L, "F", "Testando"));
        categories.add(new Category(6L, "G", "Testando"));

        Response.status(HttpStatus.NO_CONTENT).body(categories).build(response, ContentType.APPLICATION_JSON);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String name = request.getParameter("name");
        String description = request.getParameter("description");

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("message", "Cadastrado com sucesso!");
        jsonObject.addProperty("name", name);
        jsonObject.addProperty("description", description);


        Response.status(HttpStatus.OK).body(jsonObject).build(response, ContentType.APPLICATION_JSON);
    }


}