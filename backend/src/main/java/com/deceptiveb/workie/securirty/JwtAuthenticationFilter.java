package com.deceptiveb.workie.securirty;

import com.deceptiveb.workie.service.JWTService;
import com.deceptiveb.workie.service.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private JWTService jwtService;
    private CustomUserDetailsService userService;

    @Autowired
    public JwtAuthenticationFilter(
            JWTService jwtService,
            CustomUserDetailsService userService
    ) {
        this.jwtService = jwtService;
        this.userService = userService;
    }
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        try {
            String jwt = parseJwt(request);
            if (jwtService.validateJwtToken(jwt)) {
                final String username = jwtService.getUserFromToken(jwt);
                final UserDetails userDetails = userService.loadUserByUsername(username);

                UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(
                                userDetails,
                                null,
                                userDetails.getAuthorities()
                        );
                authToken.setDetails(
                        new WebAuthenticationDetailsSource()
                                .buildDetails(request)
                );
                SecurityContextHolder.getContext()
                        .setAuthentication(authToken);
            }
        } catch (Exception e){

        }

        filterChain.doFilter(request, response);

        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);


    }

    private String parseJwt(HttpServletRequest request) {
        String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        if(!authHeader.startsWith("Bearer ")) {
            // filterChain.doFilter(request, response);
            return authHeader.substring(7);
        }
        return null;
    }
}
