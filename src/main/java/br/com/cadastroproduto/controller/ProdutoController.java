package br.com.cadastroproduto.controller;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.servlet.jsp.tagext.ValidationMessage;

import br.com.cadastroproduto.entity.Marca;
import br.com.cadastroproduto.entity.Produto;
import br.com.cadastroproduto.entity.Tipo;
import br.com.cadastroproduto.service.MarcaService;
import br.com.cadastroproduto.service.ProdutoService;
import br.com.cadastroproduto.service.TipoService;
import br.com.cadastroproduto.vo.ProdutoVO;
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
public class ProdutoController{
			
    @Inject	
    private ProdutoService produtoService;
    
    @Inject	
    private MarcaService marcaService;
    
    @Inject	
    private TipoService tipoService;

	private Result result;
		

	/**
	 * @deprecated CDI eyes only
	 */
	protected ProdutoController() {
		this(null);		

	}
	
	@Inject
	public ProdutoController(Result result) {
		this.result = result;	
	}

	/**
	 * 
	 */
	@Get("/initProduto")
	public void initProduto() {
	
		try{

			auxiliarRetorno(new ProdutoVO());
			
		} catch (Exception e) {
			result.use(Results.http()).setStatusCode(403);  
			result.use(Results.json()).from(new ValidationMessage("HTTP 403",e.getMessage())).serialize();
		}
		
	}
	
	/**
	 * @param produtoVO
	 */
	@Post("/cadastrarProduto")
	@Consumes(value="application/json", options=WithoutRoot.class)
	@Produces
	public void cadastrarProduto(ProdutoVO produtoVO) {
		
		try{
		
			produtoVO.getProduto().setMarca(new Marca(produtoVO.getMrcId()));
			produtoVO.getProduto().setTipo(new Tipo(produtoVO.getTpoId()));
			
			produtoService.salvarProduto(produtoVO.getProduto());
					
			auxiliarRetorno(produtoVO);
		
		} catch (Exception e) {
			result.use(Results.http()).setStatusCode(403);  
			result.use(Results.json()).from(new ValidationMessage("HTTP 403",e.getMessage())).serialize();
		}
		
	}
	
	
	/**
	 * @param prdId
	 */
	@Delete
	@Path("/excluirProduto/{prdId}")
	public void excluirProduto(int prdId) {
		
		try{
		
			ProdutoVO produtoVO = new ProdutoVO();	
			produtoService.excluirProduto(prdId);			
			auxiliarRetorno(produtoVO);
		
		} catch (Exception e) {
			result.use(Results.http()).setStatusCode(403);  
			result.use(Results.json()).from(new ValidationMessage("HTTP 403",e.getMessage())).serialize();
		}
		
	}
	
	

	/**
	 * @param produtoVO
	 */
	@Put("/alterarProduto")
	@Consumes(value="application/json", options=WithoutRoot.class)
	@Produces
	public void alterarProduto(ProdutoVO produtoVO) {
		
		try{
		
			produtoVO.getProduto().setMarca(new Marca(produtoVO.getMrcId()));
			produtoVO.getProduto().setTipo(new Tipo(produtoVO.getTpoId()));
			
			produtoService.salvarProduto(produtoVO.getProduto());
					
			auxiliarRetorno(produtoVO);
		
		} catch (Exception e) {
			result.use(Results.http()).setStatusCode(403);  
			result.use(Results.json()).from(new ValidationMessage("HTTP 403",e.getMessage())).serialize();
		}
		
	}
	
	/**
	 * @param prdNome
	 * @param mrcId
	 * @param tpoId
	 */
	@Get("/pesquisarProduto/{prdNome}/{mrcId}/{tpoId}")
	public void pesquisarProduto(String prdNome, int mrcId, int tpoId) {
		
		try{
		
			ProdutoVO produtoVO = new ProdutoVO();
			
			produtoVO.setProdutos(produtoService.buscarProduto(prdNome, mrcId, tpoId));
	
			result.use(Results.json()).withoutRoot().from(produtoVO).recursive().serialize();
		
		} catch (Exception e) {
			result.use(Results.http()).setStatusCode(403);  
			result.use(Results.json()).from(new ValidationMessage("HTTP 403",e.getMessage())).serialize();
		}
		
	}
	
	/**
	 * @param produtoVO
	 */
	public void auxiliarRetorno(ProdutoVO produtoVO){
		
		produtoVO.setTipos(tipoService.list());
		produtoVO.setMarcas(marcaService.list());
		produtoVO.setProduto(new Produto());
		produtoVO.setProdutos(produtoService.list());
		
		result.use(Results.json()).withoutRoot().from(produtoVO).recursive().serialize();
		
	}
	
}