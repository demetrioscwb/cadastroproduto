package br.com.cadastroproduto.Intercept;

import java.io.IOException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.tagext.ValidationMessage;

import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;
import br.com.caelum.vraptor.view.Results;



@Intercepts
@RequestScoped
public class ControleAcesso {
	
	@Inject
	private HttpSession session;
	
    @Inject
    private HttpServletRequest request;

    @AroundCall
    public void intercept(SimpleInterceptorStack stack,Result result) throws ServletException, IOException {

        if(request.getRequestURI().contains("/cadastroproduto/login") || request.getRequestURI().equals("/cadastroproduto/salvarUsuario")){
        	stack.next(); // continua a execução	
        }else{
        	if(session.getAttribute("usuarioLogado")==null){
        		result.use(Results.http()).setStatusCode(402);  
        		result.use(Results.json()).from(new ValidationMessage("HTTP 402","O usuário não está logado.")).serialize(); 
        	}else{
        		stack.next(); // continua a execução 
        	}    		  
        }
    	

    	
    }


}
