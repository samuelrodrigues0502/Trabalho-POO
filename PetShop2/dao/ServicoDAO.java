package dao;

import bd.BancoDeDados;
import java.util.HashSet;
import java.util.Set;
import model.Servico;
import service.ServicoService;

public class ServicoDAO {

    Set<Servico> set = new HashSet<Servico>();

    /**
     * Construtor de ServicoDAO
     */
    public ServicoDAO() {
        // TODO Auto-generated constructor stub
        set = BancoDeDados.getInstance().getServicos();
    }

    /**
     * Insere os dados de servico no BD
     *
     * @param servico objeto servico passado pela camada Service
     * @return Retorno booleano para checagem de erros na inserção
     */
    public boolean inserir(Servico servico) {
        if(set.add(servico)){
            return true;
        }
        return false;
    }

    /**
     * Altera os dados de servico no BD
     *
     * @param cod Código do servico que será alterado
     * @param servico objeto servico passado pela camada Service
     * @return Retorno booleano para checagem de erros na alteração
     */
    public boolean alterar(int cod, Servico servico) {

        ServicoService servServ = new ServicoService();
        
        for (Servico serv : set) {
            if(serv.getCodigo() == cod){
                set.remove(serv);
                break;
            }
        }
        
        return servServ.inserir(servico);

    }

    /**
     * Remove os dados de servico no BD setando o objeto como null
     *
     * @param cod Código do servico que será removido
     * @return Retorno booleano para checagem de erros na remoção
     */
    public boolean remover(int cod) {
        for (Servico serv : set) {
            if(serv.getCodigo() == cod){
                set.remove(serv);
                return true;
            }
        }

        return false;
    }

    /**
     * Remove todos os dados do BD setando para nulo
     */
    public void limpaDados() {
        set.clear();
    }

    /**
     * Obtém objeto servico do BD
     *
     * @param cod Código do servico que será retornado
     * @return Retorna servico caso existente no BD
     */
    public Servico getServico(int cod) {
        for (Servico serv : set) {
            if(serv.getCodigo() == cod){
                return serv;
            }
        }
        return null;
    }

    /**
     * Obtém vetor de servico
     * @return Retorna o vetor de servicos
     */
    public Set<Servico> getAll() {
       
        return set;
    }
}
