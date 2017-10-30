package br.com.cadastroproduto.controller;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.servlet.jsp.tagext.ValidationMessage;

import br.com.cadastroproduto.entity.Tipo;
import br.com.cadastroproduto.service.TipoService;
import br.com.cadastroproduto.vo.TipoVO;
import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.serialization.gson.WithoutRoot;
import br.com.caelum.vraptor.view.Results;

@Controller
public class TipoController {
	
    @Inject	
    private TipoService tipoService;

	private Result result;
	

	/**
	 * @deprecated CDI eyes only
	 */
	protected TipoController() {
		this(null);
	}
	
	@Inject
	public TipoController(Result result) {
		this.result = result;
	}
	
	
	/**
	 * 
	 */
	@Get("/initTipo")
	public void initTipo() {
		
		try{

			auxiliarRetorno(new TipoVO());
		
		} catch (Exception e) {
			result.use(Results.http()).setStatusCode(403);  
			result.use(Results.json()).from(new ValidationMessage("HTTP 403",e.getMessage())).serialize();
		}
	}
	

	/**
	 * @param tipoVO
	 */
	@Post("/cadastrarTipo")
	@Consumes(value="application/json", options=WithoutRoot.class)
	@Produces
	public void cadastrarTipo(TipoVO tipoVO) {
		
		try{
		
			tipoService.salvarTipo(tipoVO.getTipo());
			
			auxiliarRetorno(tipoVO);
		
		} catch (Exception e) {
			result.use(Results.http()).setStatusCode(403);  
			result.use(Results.json()).from(new ValidationMessage("HTTP 403",e.getMessage())).serialize();
		}
		
	}
	
	
	
	/**
	 * @param tpoId
	 */
	@Delete
	@Path("/excluirTipo/{tpoId}")
	public void excluirTipo(int tpoId) {
		
		try{
		
			TipoVO tipoVO = new TipoVO();
	
			tipoService.excluirTipo(tpoId);
					
			auxiliarRetorno(tipoVO);
			
		} catch (Exception e) {
			result.use(Results.http()).setStatusCode(403);  
			result.use(Results.json()).from(new ValidationMessage("HTTP 403",e.getMessage())).serialize();
		}
		
	}
	
	

	/**
	 * @param tipoVO
	 */
	@Put("/alterarTipo")
	@Consumes(value="application/json", options=WithoutRoot.class)
	@Produces
	public void alterarTipo(TipoVO tipoVO) {
		
		try{
		
			tipoService.salvarTipo(tipoVO.getTipo());
	
			auxiliarRetorno(tipoVO);
		
		} catch (Exception e) {
			result.use(Results.http()).setStatusCode(403);  
			result.use(Results.json()).from(new ValidationMessage("HTTP 403",e.getMessage())).serialize();
		}		
		
	}
	
	
	/**
	 * @param tipoVO
	 */
	public void auxiliarRetorno(TipoVO tipoVO){
		
		tipoVO.setTipo(new Tipo());
		tipoVO.setTipos(tipoService.list());
		
		result.use(Results.json()).withoutRoot().from(tipoVO).recursive().serialize();
		
	}

	
}