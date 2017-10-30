package br.com.cadastroproduto.repository;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.Session;

import br.com.cadastroproduto.entity.Tipo;

@RequestScoped
public class TipoDAO {

    @Inject
    private Session session;
 
    private Criteria createCriteria() {
        return session.createCriteria(Tipo.class);
    }
 
    @SuppressWarnings("unchecked")
    public List<Tipo> list() {
        return createCriteria().list();
    }
    
    public Tipo salvarTipo(Tipo tipo){
    	return (Tipo) session.merge(tipo);
    }

	public void excluirTipo(int tpoId) {
		session.delete(new Tipo(tpoId));
	}

}
