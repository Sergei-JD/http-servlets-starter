package com.http.servlet;

import com.http.dto.UserDto;
import com.http.util.UrlPath;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(UrlPath.SESSIONS)
public class SessionServlet extends HttpServlet {

    public static final String USER = "user";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var session = req.getSession();
        var user = (UserDto) session.getAttribute(USER);

        if (user == null) {
            user = UserDto.builder()
                    .id(25)
                    .email("test@gmail.com")
                    .build();
            session.setAttribute(USER, user);
        }
    }
}
