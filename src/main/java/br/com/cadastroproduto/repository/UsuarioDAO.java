package br.com.cadastroproduto.repository;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

import br.com.cadastroproduto.entity.Usuario;

@RequestScoped
public class UsuarioDAO {

    @Inject
    private Session session;
 
    private Criteria createCriteria() {
        return session.createCriteria(Usuario.class);
    }
 
    @SuppressWarnings("unchecked")
    public List<Usuario> list() {
        return createCriteria().list();
    }
    
    public Usuario salvarUsuario(Usuario usuario){
    	return (Usuario) session.merge(usuario);
    }

	public void excluirUsuario(int useId) {
		session.delete(new Usuario(useId));
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> findUsuarioLogin(String useLogin,String useSenha) {
		Query query = session.createQuery("from Usuario where useLogin = :useLogin and useSenha = :useSenha");
		query.setParameter("useLogin", useLogin);
		query.setParameter("useSenha", useSenha);
		return query.list();
	}

}
