package net.codejava;

import javax.servlet.http.HttpServletRequest;

public class Uttility {



        public static String getSiteURL(HttpServletRequest request) {
            String siteURL = request.getRequestURL().toString();
            return siteURL.replace(request.getServletPath(), "");
        }

}
