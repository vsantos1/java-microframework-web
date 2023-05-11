package com.vsantos1.legacy.core.router;


import com.vsantos1.legacy.core.annotations.RequestMapping;
import com.vsantos1.legacy.core.enums.ContentType;
import com.vsantos1.legacy.core.enums.HttpStatus;
import com.vsantos1.legacy.core.response.Error;
import com.vsantos1.legacy.core.response.Response;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Controller extends HttpServlet {

    private Map<String, Method> handlerMethods;


    @Override
    public void init() throws ServletException {
        super.init();
        handlerMethods = new HashMap<>();

        Method[] methods = this.getClass().getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(RequestMapping.class)) {
                RequestMapping mapping = method.getAnnotation(RequestMapping.class);
                String path = mapping.value();
                handlerMethods.put(path, method);
            }

        }
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) {
        String path = request.getPathInfo();
        String method = request.getMethod();

        Method handlerMethod = handlerMethods.get(path);
        if (handlerMethod != null) {
            RequestMapping mapping = handlerMethod.getAnnotation(RequestMapping.class);
            if (mapping.method().name().equalsIgnoreCase(method)) {
                try {
                    handleRequest(handlerMethod, request, response, mapping.contentType());

                } catch (IllegalAccessException | InvocationTargetException e) {

                    this.ErrorBuilder(request, response, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
                }
                return;
            }
        }

        this.ErrorBuilder(request, response, "Not found", HttpStatus.NOT_FOUND);
    }

    private void handleRequest(Method handlerMethod, HttpServletRequest request, HttpServletResponse response, ContentType contentType)
            throws IllegalAccessException, InvocationTargetException {
        response.setContentType(ContentType.TEXT_PLAIN.getValue());

        Class<?>[] parameterTypes = handlerMethod.getParameterTypes();
        Object[] args = new Object[parameterTypes.length];
        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].equals(HttpServletRequest.class)) {
                args[i] = request;
            }
            if (parameterTypes[i].equals(HttpServletResponse.class)) {
                args[i] = response;
            }

        }

        handlerMethod.invoke(this, args);
    }

    private void ErrorBuilder(HttpServletRequest request, HttpServletResponse response, String message, HttpStatus status) {
        Response.status(status).body(new Error(message, status.getValue(), request.getRequestURI(), new Date())).build(response);
    }
}
