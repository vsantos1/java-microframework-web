package com.vsantos1.legacy.web.servlets;

import com.vsantos1.legacy.core.dao.GenericDAO;
import com.vsantos1.legacy.core.encrypt.Encryption;
import com.vsantos1.legacy.core.encrypt.EncryptionFactory;
import com.vsantos1.legacy.core.enums.ContentType;
import com.vsantos1.legacy.core.enums.HttpStatus;
import com.vsantos1.legacy.core.response.Response;
import com.vsantos1.legacy.web.models.Category;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "home", urlPatterns = "/home")
public class HomeServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {


        GenericDAO<Category, Long> genericDAO = new GenericDAO<>();

        List<Category> categories = new ArrayList<>();

        categories.add(new Category(null, "A", "B"));
        categories.add(new Category(null, "A", "B"));
        categories.add(new Category(13L, "Lanche da galeras", "dsdas"));
        categories.add(new Category(19L, "Adsadsa", "Bdsads"));
        categories.add(new Category(null, "A", "B"));
        categories.add(new Category(null, "A", "B"));
        genericDAO.saveAll(categories, Category.class);

        Response.status(HttpStatus.OK).body(categories).build(response, ContentType.APPLICATION_JSON);

    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String name = request.getParameter("name");
        String description = request.getParameter("description");


        Encryption hash = EncryptionFactory.getInstance(15);
        String hashed = hash.generateHash(name);
        GenericDAO<Category, Long> genericDAO = new GenericDAO<>();

        Category category = genericDAO.save(new Category(null, hashed, description));

        Response.status(HttpStatus.OK).body(category).build(response, ContentType.APPLICATION_JSON);
    }


}