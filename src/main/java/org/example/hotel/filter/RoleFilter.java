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

package org.example.hotel.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class RoleFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String path = req.getRequestURI().substring(req.getContextPath().length());

        // Allow login page and static resources without authentication
        if (path.startsWith("/jsp/auth/login.jsp") || path.startsWith("/css/") || path.startsWith("/js/")) {
            chain.doFilter(request, response);
            return;
        }

        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("role") == null) {
            res.sendRedirect(req.getContextPath() + "/jsp/auth/login.jsp");
            return;
        }

        chain.doFilter(request, response);
    }
}