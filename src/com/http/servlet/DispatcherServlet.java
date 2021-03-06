package com.http.servlet;

import com.http.util.UrlPath;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(UrlPath.DISPATCHER)
public class DispatcherServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/flights")
//                .forward(req,resp)
                .include(req, resp);
        var writer = resp.getWriter();
        writer.write("all that is below when redirecting \"forward\" the user will not see, and when \"include\" - will see!!");

//        resp.sendRedirect("/flights");
    }
}
