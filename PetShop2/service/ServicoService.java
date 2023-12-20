package service;

import dao.ServicoDAO;
import java.util.Set;
import model.Servico;

public class ServicoService {

    private ServicoDAO servicoDao;

    /**
     * Construtor da classe ServicoService
     */
    public ServicoService() {
        servicoDao = new ServicoDAO();
    }

    /**
     * Realiza os tratamentos necessários para a inserção correta e repassa o
     * objeto para a camada DAO
     *
     * @param servico Objeto serviço recebido da camada de usuário
     * @return Retorna uma variável booleana para checagem de erros
     */
    public boolean inserir(Servico servico) {

        Set<Servico> set = servicoDao.getAll();
       
        if((set.contains(servico))){
            return false;
        }
        
        for (Servico serv : set) {
            if(serv.getCodigo() == serv.getCodigo()){
                return false;
            }
        }

        if (servico.getNome().equals("")) {
            return false;
        }
        if (servico.getValor() < 0) {
            return false;
        }

        return servicoDao.inserir(servico);

    }

    /**
     * Encontra o objeto a ser removido e repassa o novo objeto e a posição para
     * a camada DAO
     *
     * @param cod Código do serviço a ser alterado
     * @param servico Novo objeto serviço que substituirá o antigo
     * @return Retorna uma variável booleana para checagem de erros
     */
    public boolean alterar(int cod, Servico servico) {

        Set<Servico> set = servicoDao.getAll();

        for (Servico serv : set) {
            if(serv.getCodigo() == cod){
                return servicoDao.alterar(cod, servico);
            }
        }

        return false;
    }

    /**
     * Encontra o objeto a ser removido e repassa a posição para a camada DAO
     *
     * @param cod Código do serviço a ser alterado
     * @return Retorna uma variável booleana para checagem de erros
     */
    public boolean remover(int cod) {

        Set<Servico> set = servicoDao.getAll();

        for (Servico serv : set) {
            if(serv.getCodigo() == cod){
                return servicoDao.remover(cod);
            }
        }

        return false;
    }

    /**
     * Realiza a chamada que apaga os dados na camada DAO
     */
    public void limpaDados() {

        servicoDao.limpaDados();
    }

    /**
     * Encontra a posição do objeto e repassa para a camada DAO
     *
     * @param cod Código do serviço a ser retornado
     * @return Retorna o serviço obtido na camada DAO ou null caso inexistente
     */
    public Servico getServico(int cod) {

        Set<Servico> set = servicoDao.getAll();
        for (Servico anim : set) {
            if(anim.getCodigo() == cod){
                return servicoDao.getServico(cod);
            }
        }
        return null;
    }

    @Override
    public String toString() {

        String texto = "";
        Set<Servico> set = servicoDao.getAll();
        
        for (Servico serv : set) {
            texto += serv + "\n\n";
            texto += "============================================\n";
        }

        if (texto.equals("")) {
            return "Não existem dados cadastrados.";
        } else {
            return texto;
        }
    }
}
