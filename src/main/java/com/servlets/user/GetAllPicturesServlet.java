package com.servlets.user;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataBase.MongoInteractor;
import com.google.gson.JsonObject;
import model.Company;

import java.io.IOException;
import java.util.List;


@WebServlet("/getAllPictures")
public class GetAllPicturesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Company> companyList = MongoInteractor.getInstance().getAllCompanies();
        JsonObject jsonObject = new JsonObject();

        for (Company company : companyList) {
            jsonObject.addProperty(company.getName(), company.getLogoUrl());
        }

        resp.getOutputStream().print(jsonObject.toString());
    }
}