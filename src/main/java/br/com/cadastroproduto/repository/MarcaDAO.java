package br.com.cadastroproduto.repository;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.Session;

import br.com.cadastroproduto.entity.Marca;

@RequestScoped
public class MarcaDAO {

    @Inject
    private Session session;
 
    private Criteria createCriteria() {
        return session.createCriteria(Marca.class);
    }
 
    @SuppressWarnings("unchecked")
    public List<Marca> list() {
        return createCriteria().list();
    }
    
    public Marca salvarMarca(Marca marca){
    	return (Marca) session.merge(marca);
    }

	public void excluirMarca(int mrcId) {
		session.delete(new Marca(mrcId));
	}

}
