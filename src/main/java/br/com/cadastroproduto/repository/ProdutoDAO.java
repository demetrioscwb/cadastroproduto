package br.com.cadastroproduto.repository;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;

import br.com.cadastroproduto.entity.Produto;

@RequestScoped
public class ProdutoDAO {

    @Inject
    private Session session;
 
    private Criteria createCriteria() {
        return session.createCriteria(Produto.class);
    }
 
    @SuppressWarnings("unchecked")
    public List<Produto> list() {
        return createCriteria().list();
    }
    
    public Produto salvarProduto(Produto produto){
    	return (Produto) session.merge(produto);
    }

	public void excluirProduto(int prdId) {
		session.delete(new Produto(prdId));
	}

	public List<Produto> buscarProduto(String prdNome, int mrcId, int tpoId) {

		Criteria criteria = session.createCriteria(Produto.class);
		if(prdNome!=null && prdNome!=""){criteria.add(Expression.like("prdNome","%"+prdNome+"%"));}
		if(mrcId!=0){criteria.add(Expression.eq("marca.mrcId",mrcId));}
		if(tpoId!=0){criteria.add(Expression.eq("tipo.tpoId",tpoId));}
		
		return criteria.list();
	}

}
