//package org.example.hotel.filter; // make sure your folder matches this
//
//import jakarta.servlet.Filter;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.ServletRequest;
//import jakarta.servlet.ServletResponse;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//
//import java.io.IOException;
//
//public class RoleFilter implements Filter {
//
////    @Override
////    public void doFilter(ServletRequest request,
////                         ServletResponse response,
////                         FilterChain chain)
////            throws IOException, ServletException {
////
////        HttpServletRequest req = (HttpServletRequest) request;
////        HttpServletResponse res = (HttpServletResponse) response;
////
////        HttpSession session = req.getSession(false);
////
////        if (session == null || session.getAttribute("role") == null) {
////            res.sendRedirect(req.getContextPath() + "/jsp/auth/login.jsp");
////            return;
////        }
////
////        chain.doFilter(request, response);
////    }
//
//    @Override
//    public void doFilter(ServletRequest request,
//                         ServletResponse response,
//                         FilterChain chain)
//            throws IOException, ServletException {
//
//        HttpServletRequest req = (HttpServletRequest) request;
//        HttpServletResponse res = (HttpServletResponse) response;
//        String path = req.getRequestURI().substring(req.getContextPath().length());
//
//        // Allow login page and static resources without authentication
//        if (path.startsWith("/auth/login.jsp") || path.startsWith("/css/") || path.startsWith("/js/")) {
//            chain.doFilter(request, response);
//            return;
//        }
//
//        HttpSession session = req.getSession(false);
//        if (session == null || session.getAttribute("role") == null) {
//            res.sendRedirect(req.getContextPath() + "/auth/login.jsp");
//            return;
//        }
//
//        chain.doFilter(request, response);
//    }
//}
//
//package org.example.hotel.filter;
//
//import jakarta.servlet.*;
//import jakarta.servlet.http.*;
//import java.io.IOException;
//
//public class RoleFilter implements Filter {
//
//    @Override
//    public void doFilter(ServletRequest request,
//                         ServletResponse response,
//                         FilterChain chain)
//            throws IOException, ServletException {
//
//        HttpServletRequest req = (HttpServletRequest) request;
//        HttpServletResponse res = (HttpServletResponse) response;
//
//        String path = req.getRequestURI().substring(req.getContextPath().length());
//
//        // Allow login page and static resources without authentication
//        if (path.startsWith("/jsp/auth/login.jsp") || path.startsWith("/css/") || path.startsWith("/js/")) {
//            chain.doFilter(request, response);
//            return;
//        }
//
//        HttpSession session = req.getSession(false);
//        if (session == null || session.getAttribute("role") == null) {
//            res.sendRedirect(req.getContextPath() + "/jsp/auth/login.jsp");
//            return;
//        }
//
//        chain.doFilter(request, response);
//    }
//}


package org.example.hotel.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebFilter("/*") // Apply to all URLs
public class RoleFilter implements Filter {

//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//            throws IOException, ServletException {
//
//        HttpServletRequest req = (HttpServletRequest) request;
//        HttpServletResponse res = (HttpServletResponse) response;
//        String path = req.getRequestURI().substring(req.getContextPath().length());
//
//        // 1. PUBLIC PATHS: Allow access to login, assets, and the login servlet
//        if (path.startsWith("/login") || path.startsWith("/css/") || path.startsWith("/js/") || path.startsWith("/images/")) {
//            chain.doFilter(request, response);
//            return;
//        }
//
//        // 2. AUTHENTICATION CHECK
//        HttpSession session = req.getSession(false);
//        String userRole = (session != null) ? (String) session.getAttribute("role") : null;
//
//        if (userRole == null) {
//            res.sendRedirect(req.getContextPath() + "/login-page");
//            return;
//        }
//
//        // 3. ROLE-BASED AUTHORIZATION (The "Gatekeeper" Logic)
//        boolean authorized = false;
//
//        if (path.startsWith("/reception/") && (userRole.equals("RECEPTION") || userRole.equals("ADMIN") || userRole.equals("SUPER_ADMIN"))) {
//            authorized = true;
//        } else if (path.startsWith("/admin/") && (userRole.equals("ADMIN") || userRole.equals("SUPER_ADMIN"))) {
//            authorized = true;
//        } else if (path.startsWith("/superadmin/") && userRole.equals("SUPER_ADMIN")) {
//            authorized = true;
//        }
//
//        if (authorized) {
//            chain.doFilter(request, response); // User has the right role, let them in!
//        } else {
//            // User is logged in but trying to access a page they aren't allowed to see
//            res.sendError(HttpServletResponse.SC_FORBIDDEN, "You do not have permission to access this page.");
//        }
//    }


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String path = req.getRequestURI().substring(req.getContextPath().length());

        // Allow login page & static assets
        if (path.startsWith("/login") || path.startsWith("/css/") || path.startsWith("/js/") || path.startsWith("/images/")) {
            chain.doFilter(request, response);
            return;
        }

        // Check session
        HttpSession session = req.getSession(false);
        String role = (session != null) ? (String) session.getAttribute("role") : null;

        if (role == null) {
            res.sendRedirect(req.getContextPath() + "/login-page");
            return;
        }

        // Role-based authorization
        boolean allowed = false;

        // ✅ 1. Allow any logged-in user to hit the logout route
        if (path.equals("/logout")) {
            allowed = true;
        }


        if (path.startsWith("/admin/") && (role.equals("ADMIN") || role.equals("SUPER_ADMIN"))) allowed = true;
        if (path.startsWith("/reception/") && (role.equals("RECEPTION") || role.equals("ADMIN") || role.equals("SUPER_ADMIN"))) allowed = true;
        if (path.startsWith("/superadmin/") && role.equals("SUPER_ADMIN")) allowed = true;

        if (allowed) {
            chain.doFilter(request, response);
        } else {
            res.sendError(HttpServletResponse.SC_FORBIDDEN, "You do not have permission to access this page.");
        }
    }
}