package com.example.servlet;

import com.example.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    //write your code here!

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = (String) req.getSession(true).getAttribute("user");
        if(user != null){
            resp.sendRedirect("/user/hello.jsp");
        }else {
            resp.sendRedirect("/login.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if(Users.getInstance().getUsers().contains(login) &&
        password.isEmpty()){
            req.getSession(true).setAttribute("user", login);
            resp.sendRedirect("/user/hello.jsp");
        }else {
            resp.sendRedirect("/login.jsp");
        }
    }
}
