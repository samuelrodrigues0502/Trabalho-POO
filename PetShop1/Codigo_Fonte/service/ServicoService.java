package service;

import dao.ServicoDAO;
import model.Servico;
import util.Util;

public class ServicoService {

    private ServicoDAO servicoDao;

    /**
     * Construtor da classe ServicoService
     */
    public ServicoService() {
        servicoDao = new ServicoDAO();
    }

    /**
     * Realiza os tratamentos necessários para a inserção correta e repassa o objeto para a camada DAO
     * @param servico Objeto serviço recebido da camada de usuário
     * @return Retorna uma variável booleana para checagem de erros
     */
    public boolean inserir(Servico servico) {

        int contador = 0;
        Servico aux[] = servicoDao.getAll();
        for (int i = 0; i < aux.length; i++) {
            if (aux[i] != null) {
                contador++;
            }
        }

        if (contador < aux.length - 1) {
            for (int i = 0; i < aux.length; i++) {
                if (aux[i] != null) {
                    if (aux[i].getCodigo() == servico.getCodigo()) {
                        return false;
                    }
                }

            }

            if (servico.getNome().equals("")) {
                return false;
            }
            if (servico.getValor() < 0) {
                return false;
            }

            return servicoDao.inserir(servico);
        } else {
            
            return false;
        }
    }

    /**
     * Encontra o objeto a ser removido e repassa o novo objeto e a posição para a camada DAO
     * @param cod Código do serviço a ser alterado
     * @param servico Novo objeto serviço que substituirá o antigo
     * @return Retorna uma variável booleana para checagem de erros
     */
    public boolean alterar(int cod, Servico servico) {

        Servico aux[] = servicoDao.getAll();

        if (cod >= 0 && cod < aux.length) {
            for (int i = 0; i < aux.length; i++) {
                if (aux[i] != null) {
                    if (aux[i].getCodigo() == cod) {
                        return servicoDao.alterar(cod, servico);
                    }
                }
            }
        }
        return false;
    }

    /**
     * Encontra o objeto a ser removido e repassa a posição para a camada DAO
     * @param cod Código do serviço a ser alterado
     * @return Retorna uma variável booleana para checagem de erros
     */
    public boolean remover(int cod) {

        Servico aux[] = servicoDao.getAll();

        if (cod >= 0 && cod < aux.length) {
            for (int i = 0; i < aux.length; i++) {
                if (aux[i] != null) {
                    if (aux[i].getCodigo() == cod) {
                        return servicoDao.remover(cod);
                    }
                }
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
     * @param cod Código do serviço a ser retornado
     * @return Retorna o serviço obtido na camada DAO ou null caso inexistente
     */
    public Servico getServico(int cod) {

        Servico aux[] = servicoDao.getAll();
        if (cod >= 0 && cod < aux.length) {

            for (int i = 0; i < aux.length; i++) {
                if (aux[i] != null) {
                    if (aux[i].getCodigo() == cod) {
                        return servicoDao.getServico(cod);
                    }
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {

        String texto = "";
        Servico aux[] = servicoDao.getAll();
        for (int i = 0; i < aux.length; i++) {
            if (aux[i] != null) {
                texto += aux[i] + "\n\n";
                texto += "============================================\n";
            }
        }

        if (texto.equals("")) {
            return "Não existem dados cadastrados.";
        } else {
            return texto;
        }
    }
}
