package com.gugawag.pdist.ejbs;

import com.gugawag.pdist.model.Mensagem;
import com.gugawag.pdist.model.Usuario;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import java.util.List;

@Stateless(name = "mensagemService")
@Remote
public class MensagemService {

	@EJB
	private MensagemDAO mensagemDAO;
	
	public List<Mensagem> listar() {
		return mensagemDAO.listar();
	}
	
    public void inserir(long id, String nome) {
        Mensagem mensagem = new Mensagem(id, nome);
        mensagemDAO.inserir(mensagem);
    }
    
    public Mensagem findById(long id) {
    	return mensagemDAO.findById(id);
    }
}
