package br.com.cadastroproduto.service;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.cadastroproduto.entity.Usuario;
import br.com.cadastroproduto.repository.UsuarioDAO;

@Transactional
public class UsuarioService {

	@Inject
	UsuarioDAO usuarioDAO;

	public List<Usuario> list() {
		return usuarioDAO.list();
	}
	
	public Usuario salvarUsuario(Usuario usuario){
		return usuarioDAO.salvarUsuario(usuario);
	}

	public void excluirUsuario(int useId) {
		usuarioDAO.excluirUsuario(useId);
	}

	public Usuario getEfetuarLogin(String useLogin,String useSenha) throws Exception {
				
		List<Usuario> list = usuarioDAO.findUsuarioLogin(useLogin,useSenha);
		
		if(list.size()==0)
			throw new Exception("Usuário não cadastrado.");

		if(list.size()>1)
			throw new Exception("Usuário duplicado.");
		
		return list.get(0);
		
	}
	
}
