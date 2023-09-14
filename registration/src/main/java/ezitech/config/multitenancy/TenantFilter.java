package ezitech.config.multitenancy;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
//import newtest.security.AuthenticationService;
import java.io.IOException;
import javax.crypto.SecretKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.stereotype.Component;

@Component
@Order(1)
class TenantFilter implements Filter {

    @Autowired
    TenantIdentifierResolver tenantIdentifierResolver;

    @Override
    public void doFilter(
        ServletRequest request,
        ServletResponse response,
        FilterChain chain
    ) throws IOException, ServletException {
        String token =
            ((HttpServletRequest) request).getHeader("Authorization");
        if (token == null) {
            throw new ServletException("No Token provided");
        }

        String tenant = JwtTokenParser.extractAudienceFromToken(
            token.replace("Bearer ", "")
        );

        tenantIdentifierResolver.setCurrentTenant(tenant);

        try {
            chain.doFilter(request, response);
        } finally {
            tenantIdentifierResolver.setCurrentTenant(tenant);
        }
    }
}
