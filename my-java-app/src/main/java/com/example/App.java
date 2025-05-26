package com.example;

import jakarta.servlet.http.*;
import jakarta.servlet.*;
import java.io.*;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.*;

public class App {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);

        ServletContextHandler handler = new ServletContextHandler();
        handler.setContextPath("/");

        handler.addServlet(new ServletHolder(new HttpServlet() {
            protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                    throws ServletException, IOException {
                resp.setContentType("text/html");
                resp.setStatus(HttpServletResponse.SC_OK);
                resp.getWriter().println("<h1>" + greet() + "</h1>");
            }
        }), "/*");

        server.setHandler(handler);
        server.start();
        server.join();
    }

    public static String greet() {
        return "Hello from greet() method!";
    }
}
