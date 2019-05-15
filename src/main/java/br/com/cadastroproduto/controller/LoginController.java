package br.com.cadastroproduto.controller;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.tagext.ValidationMessage;

import br.com.cadastroproduto.entity.Usuario;
import br.com.cadastroproduto.service.UsuarioService;
import br.com.cadastroproduto.vo.LoginVO;
import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.serialization.gson.WithoutRoot;
import br.com.caelum.vraptor.view.Results;


@Controller
public class LoginController{
	
	@Inject
	private HttpSession session;	
	
    @Inject	
    private UsuarioService usuarioService;

	private Result result;

	protected LoginController() {
		this(null);
	}
	
	@Inject
	public LoginController(Result result) {
		this.result = result;
	}


	@Path("/")
	public void index() {

	}
	

	/**
	 * @param useLogin
	 * @param useSenha
	 */
	@Path("/login/{useLogin}/{useSenha}")
	public void index(String useLogin,String useSenha){
				
		LoginVO loginVO = new LoginVO();
		
		Usuario usuario = new Usuario();
		
		try {
			usuario = usuarioService.getEfetuarLogin(useLogin,useSenha);			
			
			session.setAttribute("usuarioLogado", usuario);

			result.use(Results.json()).withoutRoot().from(loginVO).recursive().serialize();
			
		} catch (Exception e) {
			result.use(Results.http()).setStatusCode(403);  
			result.use(Results.json()).from(new ValidationMessage("HTTP 403",e.getMessage())).serialize();
		}

	}
	
	/**
	 * @param loginVO
	 */
	@Post("/salvarUsuario")
	@Consumes(value="application/json", options=WithoutRoot.class)
	@Produces
	public void salvarUsuario(LoginVO loginVO) {
		
		usuarioService.salvarUsuario(loginVO.getUsuario());
		
		result.use(Results.json()).withoutRoot().from(loginVO).recursive().serialize();
		
	}

	

	
}