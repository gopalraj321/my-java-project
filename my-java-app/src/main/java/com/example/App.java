package com.example;

import jakarta.servlet.http.*;
import jakarta.servlet.*;
import java.io.*;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.*;

public class App {
    public static void main(String[] args) throws Exception {
        Server server = new Server(9090);

        ServletContextHandler handler = new ServletContextHandler();
        handler.setContextPath("/");

        handler.addServlet(new ServletHolder(new HttpServlet() {
            @Override
            protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
                resp.setContentType("text/html");
                resp.setStatus(HttpServletResponse.SC_OK);
                try {
                    resp.getWriter().println("<h1>" + greet() + "</h1>");
                } catch (IOException e) {
                    // Handle IOException here: log error and set HTTP 500 status
                    e.printStackTrace();
                    resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                    try {
                        resp.getWriter().println("<h1>Internal Server Error</h1>");
                    } catch (IOException ex) {
                        // If writing error message fails, just ignore or log
                        ex.printStackTrace();
                    }
                }
            }
        }), "/*");

        server.setHandler(handler);
        server.start();
        server.join();
    }

    // 🔥 Required for your test case
    public static String greet() {
        return "Hello! MR GOpalraj wellcome to our World";
    }
}
