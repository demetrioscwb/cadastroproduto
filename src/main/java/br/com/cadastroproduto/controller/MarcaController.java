package br.com.cadastroproduto.controller;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.servlet.jsp.tagext.ValidationMessage;

import br.com.cadastroproduto.entity.Marca;
import br.com.cadastroproduto.service.MarcaService;
import br.com.cadastroproduto.vo.MarcaVO;
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
public class MarcaController {
	
    @Inject	
    private MarcaService marcaService;

	private Result result;
	

	/**
	 * @deprecated CDI eyes only
	 */
	protected MarcaController() {
		this(null);
	}
	
	@Inject
	public MarcaController(Result result) {
		this.result = result;
	}
	
	
	/**
	 * 
	 */
	@Get("/initMarca")
	public void initMarca() {
		
		try{

			auxiliarRetorno(new MarcaVO());

		} catch (Exception e) {
			result.use(Results.http()).setStatusCode(403);  
			result.use(Results.json()).from(new ValidationMessage("HTTP 403",e.getMessage())).serialize();
		}
	
	}
	

	/**
	 * @param marcaVO
	 */
	@Post("/cadastrarMarca")
	@Consumes(value="application/json", options=WithoutRoot.class)
	@Produces
	public void cadastrarMarca(MarcaVO marcaVO) {
		
		try{
		
			marcaService.salvarMarca(marcaVO.getMarca());
			
			auxiliarRetorno(new MarcaVO());
					
		} catch (Exception e) {
			result.use(Results.http()).setStatusCode(403);  
			result.use(Results.json()).from(new ValidationMessage("HTTP 403",e.getMessage())).serialize();
		}
		
	}
	
	
	/**
	 * @param mrcId
	 */
	@Delete
	@Path("/excluirMarca/{mrcId}")
	public void excluirMarca(int mrcId) {
		
		try{

			marcaService.excluirMarca(mrcId);
				
			auxiliarRetorno(new MarcaVO());
		
		} catch (Exception e) {
			result.use(Results.http()).setStatusCode(403);  
			result.use(Results.json()).from(new ValidationMessage("HTTP 403",e.getMessage())).serialize();
		}
		
	}
	
	

	/**
	 * @param marcaVO
	 */
	@Put("/alterarMarca")
	@Consumes(value="application/json", options=WithoutRoot.class)
	@Produces
	public void alterarMarca(MarcaVO marcaVO) {
		
		try{
		
			marcaService.salvarMarca(marcaVO.getMarca());		
			
			auxiliarRetorno(marcaVO);
		
		} catch (Exception e) {
			result.use(Results.http()).setStatusCode(403);  
			result.use(Results.json()).from(new ValidationMessage("HTTP 403",e.getMessage())).serialize();
		}		
		
	}
	
	
	/**
	 * @param marcaVO
	 */
	public void auxiliarRetorno(MarcaVO marcaVO){
		
		marcaVO.setMarca(new Marca());
		marcaVO.setMarcas(marcaService.list());
		
		result.use(Results.json()).withoutRoot().from(marcaVO).recursive().serialize();
		
	}


	
}