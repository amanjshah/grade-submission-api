package com.practise.gradesubmission.security.filter;

import java.io.IOException;
import java.util.List;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;

import com.auth0.jwt.JWT;
import com.practise.gradesubmission.security.SecurityConstants;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

public class JWTAuthorizationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorizationHeader = request.getHeader(SecurityConstants.AUTHORIZATION);
        // If there is no bearer JWT authorization header, this must be a registration, so no authorization is needed
        if (authorizationHeader != null && authorizationHeader.startsWith(SecurityConstants.BEARER)) {
            // Authorization header is in form "Bearer {long JWT token string}", so remove the "Bearer "
            String jwtToken = authorizationHeader.replace(SecurityConstants.BEARER, "");
            // JWT tokens are in the form: "{header}.{body}.{signature}"
            // Check that the signature they send is equivalent to a test signature created using our secret key (unknown to client) & the header and body of the received token
            String user = JWT.require(HMAC512(SecurityConstants.SECRET_KEY)).build().verify(jwtToken).getSubject();
            // Set an authentication object for this user on the SecurityContextHolder
            // Ensure you use the UsernamePasswordAuthenticationToken constructor with 3 input fields: the one without "authorities" will not set authentication to true
            SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(user, null, List.of()));
        }
        filterChain.doFilter(request, response);
    }
}
