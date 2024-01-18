package com.aws.demo.filter;

import java.io.IOException;
import java.util.Collections;
import java.util.stream.Collectors;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.aws.demo.entity.UsuarioAutenticado;
import com.aws.demo.service.AutenticacaoService;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginFiltro extends AbstractAuthenticationProcessingFilter{

	 public LoginFiltro(String url, AuthenticationManager authenticationManager){
	        super(new AntPathRequestMatcher(url));
	        setAuthenticationManager(authenticationManager);
	    }

	    @Override
	    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
	        String collect = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
	        UsuarioAutenticado usuarioAutenticado = new ObjectMapper().readValue(collect, UsuarioAutenticado.class);

	        return getAuthenticationManager()
	                .authenticate(new UsernamePasswordAuthenticationToken(
	                                usuarioAutenticado.getUserName(),
	                                usuarioAutenticado.getPassword(),
	                                Collections.emptyList()));
	    }

	    @Override
	    protected void successfulAuthentication(HttpServletRequest httpServletRequest,
	                                            HttpServletResponse httpServletResponse,
	                                            FilterChain filterChain,
	                                            Authentication authentication){

	        AutenticacaoService.addJWToken(httpServletResponse, authentication);
	    }

}
