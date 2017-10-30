package br.com.cadastroproduto.controller;

import javax.inject.Inject;
import javax.servlet.jsp.tagext.ValidationMessage;

import br.com.cadastroproduto.service.UsuarioService;
import br.com.cadastroproduto.vo.UsuarioVO;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;

@Controller
public class UsuarioController {
	
    @Inject	
    private UsuarioService usuarioService;

	private Result result;
	

	/**
	 * @deprecated CDI eyes only
	 */
	protected UsuarioController() {
		this(null);
	}
	
	@Inject
	public UsuarioController(Result result) {
		this.result = result;
	}

	
	/**
	 * 
	 */
	@Get("/initUsuarioControle")
	public void initUsuarioControle() {
		
		try{
		
			UsuarioVO usuarioVO = new UsuarioVO();
	
			usuarioVO.setListUsuario(usuarioService.list());
			
			result.use(Results.json()).withoutRoot().from(usuarioVO).recursive().serialize();
		
		} catch (Exception e) {
			result.use(Results.http()).setStatusCode(403);  
			result.use(Results.json()).from(new ValidationMessage("HTTP 403",e.getMessage())).serialize();
		}
	}
	
	
	/**
	 * @param useId
	 */
	@Delete
	@Path("/excluirUsuario/{useId}")
	public void excluirUsuario(int useId) {
		
		try{
		
			UsuarioVO usuarioVO = new UsuarioVO();
	
			usuarioService.excluirUsuario(useId);
	
			usuarioVO.setListUsuario(usuarioService.list());
			
			result.use(Results.json()).withoutRoot().from(usuarioVO).recursive().serialize();
		
		} catch (Exception e) {
			result.use(Results.http()).setStatusCode(403);  
			result.use(Results.json()).from(new ValidationMessage("HTTP 403",e.getMessage())).serialize();
		}
	}
	
}