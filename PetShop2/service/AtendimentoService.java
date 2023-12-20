package service;

import dao.AtendimentoDAO;
import java.util.Date;
import java.util.Set;
import model.Atendimento;
import util.Util;

public class AtendimentoService {

    private AtendimentoDAO atendimentoDao;

    /**
     * Construtor da classe AtendimentoService
     */
    public AtendimentoService() {
        atendimentoDao = new AtendimentoDAO();
    }

    /**
     * Realiza os tratamentos necessários para a inserção correta e repassa o
     * objeto para a camada DAO
     *
     * @param atendimento Objeto atendimento recebido da camada de usuário
     * @return Retorna uma variável booleana para checagem de erros
     */
    public boolean inserir(Atendimento atendimento) {

        Set<Atendimento> set = atendimentoDao.getAll();

        for (Atendimento atend : set) {
            if(atend.getCodigo() == atendimento.getCodigo()){
                return false;
            }
        }
        
        if ((set.contains(atendimento))) {
            return false;
        }

        if (atendimento.getAnimal() == null) {
            return false;
        }
        if (atendimento.getServico() == null) {
            return false;
        }
        if (atendimento.getDate() == null) {
            return false;
        }

        return atendimentoDao.inserir(atendimento);

    }

    /**
     * Encontra o objeto a ser alterado e repassa o novo objeto e a posição para
     * a camada DAO
     *
     * @param cod Código do atendimento a ser alterado
     * @param atendimento Novo objeto atendimento que substituirá o antigo
     * @return Retorna uma variável booleana para checagem de erros
     */
    public boolean alterar(int cod, Atendimento atendimento) {

        Set<Atendimento> set = atendimentoDao.getAll();

        for (Atendimento atend : set) {
            if (atend.getCodigo() == cod) {
                return atendimentoDao.alterar(cod, atend);
            }
        }
        return false;
    }

    /**
     * Encontra o objeto a ser removido e repassa o novo objeto e a posição para
     * a camada DAO
     *
     * @param cod Código do atendimento a ser removido
     * @return Retorna uma variável booleana para checagem de erros
     */
    public boolean remover(int cod) {
        Set<Atendimento> set = atendimentoDao.getAll();

        for (Atendimento atend : set) {
            if (atend.getCodigo() == cod) {
                return atendimentoDao.remover(cod);
            }
        }
        return false;
    }

    /**
     * Realiza a chamada que apaga os dados na camada DAO
     */
    public void limpaDados() {

        atendimentoDao.limpaDados();
    }

    /**
     * Encontra a posição do objeto e repassa para a camada DAO
     *
     * @param cod Código do atendimento a ser retornado
     * @return Retorna o atendimento obtido na camada DAO ou null caso
     * inexistente
     */
    public Atendimento getAtendimento(int cod) {
        Set<Atendimento> set = atendimentoDao.getAll();

        for (Atendimento atend : set) {
            if (atend.getCodigo() == cod) {
                return atendimentoDao.getAtendimento(cod);
            }
        }
        return null;
    }

    @Override
    public String toString() {

        String texto = "";
        Set<Atendimento> set = atendimentoDao.getAll();

        for (Atendimento atend : set) {
            texto += atend + "\n\n";
            texto += "============================================\n";
        }

        if (texto.equals("")) {
            return "Não existem dados cadastrados.";
        } else {
            return texto;
        }
    }

    /**
     * Função que procura o maior valor dentre os atendimentos
     *
     * @param cod Código do animal que possui os atendimentos
     * @return Retorna o atendimento que possui o maior valor
     */
    public Atendimento getMaiorAtendimento(int cod) {

        Set<Atendimento> set = atendimentoDao.getAll();
        Atendimento aux = new Atendimento();
        aux = null;
        float maior = 0;

        for (Atendimento atend : set) {
            if (atend.getAnimal().getCodigo() == cod) {
                if (atend.getServico().getValor() > maior) {
                    maior = atend.getServico().getValor() * atend.getAnimal().getTaxa() + atend.getServico().getValor();
                    aux = atend;
                }
            }
        }

        
        return aux;
    }

    /**
     * Função que procura o menor valor dentre os atendimentos
     *
     * @param cod Código do animal que possui os atendimentos
     * @return Retorna o atendimento que possui o menor valor
     */
    public Atendimento getMenorAtendimento(int cod) {

        Set<Atendimento> set = atendimentoDao.getAll();
        Atendimento aux = new Atendimento();
        aux = null;
        float menor = 9999999;

        for (Atendimento atend : set) {
            if (atend.getAnimal().getCodigo() == cod) {
                if (atend.getServico().getValor() < menor) {
                    menor = atend.getServico().getValor() * atend.getAnimal().getTaxa() + atend.getServico().getValor();
                    aux = atend;
                }
            }
        }
     
        
        return aux;
    }

    /**
     * Função que soma todos os valores de atendimentos de um animal
     *
     * @param cod Código do animal que possui os atendimentos
     * @return Retorna o total do valor dos atendimentos
     */
    public float getTotalAtendimentos(int cod) {

        Set<Atendimento> set = atendimentoDao.getAll();
        float total = 0;

        for (Atendimento atend : set) {
            if (atend.getAnimal().getCodigo() == cod) {
                total += (atend.getServico().getValor() * atend.getAnimal().getTaxa() + atend.getServico().getValor());
            }
        }
        return total;
    }

    /**
     * Função que simula a impressão de uma nota fiscal com alguns dados
     *
     * @param cod Código do animal ao qual será emitida a nota fiscal
     * @return String formatado com os dados necessários para a impressão
     */
    public String getNotaFiscal(int cod) {
        Set<Atendimento> set = atendimentoDao.getAll();
        Atendimento aux = new Atendimento();
        aux = null;
        float valorTot = 0;

        for (Atendimento atend : set) {
            if (atend.getAnimal().getCodigo() == cod) {
                aux = atend;
                break;
            }
        }

        if (aux == null) {
            return "Não há nenhum atendimento cadastrado com esse código de animal.";
        } else {

            String nota = new String();
            nota += "===================================\n";
            nota += "            \tNota Fiscal            ";
            nota += "\n===================================\n";
            nota += "Nome: " + aux.getAnimal().getNome();
            nota += "\nEndereço: " + aux.getAnimal().getEndereco();
            nota += "\nCidade: " + aux.getAnimal().getCidade();
            nota += "\n===================================\n";
            nota += "            \tAtendimentos            ";
            nota += "\n===================================";

            for (Atendimento atend : set) {
                if (atend.getAnimal().getCodigo() == cod) {
                    nota += "\nServiço: " + atend.getServico().getNome();
                    nota += "   Valor: " + (atend.getServico().getValor() * atend.getAnimal().getTaxa() + atend.getServico().getValor());
                    valorTot += (atend.getServico().getValor() * atend.getAnimal().getTaxa() + atend.getServico().getValor());
                }
            }
            
            nota += "\n===================================\n";
            nota += "Total = " + valorTot;
            nota += "\n===================================\n";

            return nota;
        }
    }

    /**
     * Função que concatena todos os atendimentos realizados de um animal
     *
     * @param cod Código do animal que possui os atendimentos
     * @return Retorna uma string com os dados obtidos
     */
    public String listaAtendimentos() {

        Set<Atendimento> set = atendimentoDao.getAll();
        String lista = new String();

        for (Atendimento atend : set) {

            lista += "Código do atendimento: " + atend.getCodigo() +"\nData: "+ atend.getDate() +"\nAnimal atendido: " + 
                    atend.getAnimal().getCodigo() + " " + atend.getAnimal().getNome() + "\nServiço: " + atend.getServico().getNome() + 
                    "\nValor(Taxa): "+ (atend.getServico().getValor() * atend.getAnimal().getTaxa() + atend.getServico().getValor()) + "\n";
            lista += "\n============================================\n";

        }

        return lista;
    }

    /**
     * Função que seleciona somente os atendimentos realizados entre as datas
     * especificadas pelo usuário
     *
     * @param data1 Data inicial do período
     * @param data2 Data final do período
     * @return Retorna uma String com os atendimentos encontrados entre essas
     * datas
     */
    public String getAtendimentosPorPeriodo(String data1, String data2) {
        Date dataI = Util.stringParaDate(data1);
        Date dataF = Util.stringParaDate(data2);

        Set<Atendimento> set = atendimentoDao.getAll();
        String texto = "";

        for (Atendimento atend : set) {
            if (atend.getDate().after(dataI) && atend.getDate().before(dataF)) {
                texto += "Código do atendimento: " + atend.getCodigo() +"\nData: "+ atend.getDate() + "\nAnimal atendido: " + 
                    atend.getAnimal().getCodigo() + " " + atend.getAnimal().getNome() + "\nServiço: " + atend.getServico().getNome() + 
                    "\nValor(Taxa): "+ (atend.getServico().getValor() * atend.getAnimal().getTaxa() + atend.getServico().getValor()) + "\n";
                texto += "============================================\n";
            }
        }

        return texto;
    }
}
