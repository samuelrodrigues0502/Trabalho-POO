package service;

import dao.AtendimentoDAO;
import java.text.DateFormat;
import java.util.Date;
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
     * Realiza os tratamentos necessários para a inserção correta e repassa o objeto para a camada DAO
     * @param atendimento Objeto atendimento recebido da camada de usuário
     * @return Retorna uma variável booleana para checagem de erros
     */
    public boolean inserir(Atendimento atendimento) {

        int contador = 0;
        Atendimento aux[] = atendimentoDao.getAll();
        for (int i = 0; i < aux.length; i++) {
            if (aux[i] != null) {
                contador++;
            }
        }

        if (contador < aux.length - 1) {
            for (int i = 0; i < aux.length; i++) {
                if (aux[i] != null) {
                    if (aux[i].getCodigo() == atendimento.getCodigo()) {
                        return false;
                    }
                }

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
        } else {
            return false;
        }
    }

    /**
     * Encontra o objeto a ser alterado e repassa o novo objeto e a posição para a camada DAO
     * @param cod Código do atendimento a ser alterado
     * @param atendimento Novo objeto atendimento que substituirá o antigo
     * @return Retorna uma variável booleana para checagem de erros
     */
    public boolean alterar(int cod, Atendimento atendimento) {

        Atendimento aux[] = atendimentoDao.getAll();

        if (cod >= 0 && cod < aux.length) {
            for (int i = 0; i < aux.length; i++) {
                if (aux[i] != null) {
                    if (aux[i].getCodigo() == cod) {
                        return atendimentoDao.alterar(cod, atendimento);
                    }
                }
            }
        }
        return false;
    }

    /**
     * Encontra o objeto a ser removido e repassa o novo objeto e a posição para a camada DAO
     * @param cod Código do atendimento a ser removido
     * @return Retorna uma variável booleana para checagem de erros
     */
    public boolean remover(int cod) {
        Atendimento aux[] = atendimentoDao.getAll();

        if (cod >= 0 && cod < aux.length) {
            for (int i = 0; i < aux.length; i++) {
                if (aux[i] != null) {
                    if (aux[i].getCodigo() == cod) {
                        return atendimentoDao.remover(cod);
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

        atendimentoDao.limpaDados();
    }

    /**
     * Encontra a posição do objeto e repassa para a camada DAO
     * @param cod Código do atendimento a ser retornado
     * @return Retorna o atendimento obtido na camada DAO ou null caso inexistente
     */
    public Atendimento getAtendimento(int cod) {

        Atendimento aux[] = atendimentoDao.getAll();
        if (cod >= 0 && cod < aux.length) {
            for (int i = 0; i < aux.length; i++) {
                if (aux[i] != null) {
                    if (aux[i].getCodigo() == cod) {
                        return atendimentoDao.getAtendimento(cod);
                    }
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {

        String texto = "";
        Atendimento aux[] = atendimentoDao.getAll();
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

    /**
     * Função que procura o maior valor dentre os atendimentos
     * @param cod Código do animal que possui os atendimentos
     * @return Retorna o atendimento que possui o maior valor
     */
    public Atendimento getMaiorAtendimento(int cod) {
        
        Atendimento aux[] = atendimentoDao.getAll();
        float maior = 0;
        int maiorIndice = 0;

        for (int i = 0; i < aux.length; i++) {
            if (aux[i] != null) {
                if (aux[i].getAnimal().getCodigo() == cod) {
                    if (aux[i].getServico().getValor() > maior) {
                        maior = aux[i].getServico().getValor();
                        maiorIndice = i;
                    }
                }
            }
        }

        return aux[maiorIndice];
    }

    /**
     * Função que procura o menor valor dentre os atendimentos
     * @param cod Código do animal que possui os atendimentos
     * @return Retorna o atendimento que possui o menor valor
     */
    public Atendimento getMenorAtendimento(int cod) {

        Atendimento aux[] = atendimentoDao.getAll();
        float menor = 9999999;
        int menorIndice = 0;

        for (int i = 0; i < aux.length; i++) {
            if (aux[i] != null) {
                if (aux[i].getAnimal().getCodigo() == cod) {
                    if (aux[i].getServico().getValor() < menor) {
                        menor = aux[i].getServico().getValor();
                        menorIndice = i;
                    }
                }
            }
        }

        return aux[menorIndice];
    }

    /**
     * Função que soma todos os valores de atendimentos de um animal
     * @param cod Código do animal que possui os atendimentos
     * @return Retorna o total do valor dos atendimentos
     */
    public float getTotalAtendimentos(int cod) {

        Atendimento aux[] = atendimentoDao.getAll();
        float total = 0;

        for (int i = 0; i < aux.length; i++) {
            if (aux[i] != null) {
                if (aux[i].getAnimal().getCodigo() == cod) {
                    total += aux[i].getServico().getValor();
                }
            }
        }
        return total;
    }

    /**
     * Função que simula a impressão de uma nota fiscal com alguns dados
     * @param cod Código do animal ao qual será emitida a nota fiscal
     * @return String formatado com os dados necessários para a impressão
     */
    public String getNotaFiscal(int cod) {
        Atendimento aux[] = atendimentoDao.getAll();
        int indice = -1;
        float valorTot = 0;

        for (int i = 0; i < aux.length; i++) {
            if (aux[i] != null) {
                if (aux[i].getAnimal().getCodigo() == cod) {
                    indice = i;
                    break;
                }
            }
        }

        if (indice == -1) {
            return "Não há nenhum atendimento cadastrado com esse código de animal.";
        } else {

            String nota = new String();
            nota += "===================================\n";
            nota += "            \tNota Fiscal            ";
            nota += "\n===================================\n";
            nota += "Nome: " + aux[indice].getAnimal().getNome();
            nota += "\nEndereço: " + aux[indice].getAnimal().getEndereco();
            nota += "\nCidade: " + aux[indice].getAnimal().getCidade();
            nota += "\n===================================\n";
            nota += "            \tAtendimentos            ";
            nota += "\n===================================";

            for (int i = 0; i < aux.length; i++) {
                if (aux[i] != null) {
                    if (aux[i].getAnimal().getCodigo() == cod) {
                        nota += "\nServiço: " + aux[i].getServico().getNome();
                        nota += "   Valor: " + aux[i].getServico().getValor();
                        valorTot += aux[i].getServico().getValor();
                    }
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
     * @param cod Código do animal que possui os atendimentos
     * @return Retorna uma string com os dados obtidos
     */
    private String listaAtendimentos(int cod) {

        Atendimento aux[] = atendimentoDao.getAll();
        String lista = new String();

        for (int i = 0; i < aux.length; i++) {
            if (aux[i].getAnimal().getCodigo() == cod) {
                lista += aux[i].getServico().getNome() + "\n";
            }
        }

        return lista;
    }

    /**
     * Função que seleciona somente os atendimentos realizados entre as datas especificadas pelo usuário
     * @param data1 Data inicial do período
     * @param data2 Data final do período
     * @return Retorna uma String com os atendimentos encontrados entre essas datas
     */
    public String getAtendimentosPorPeriodo(String data1, String data2) {
        Date dataI = Util.stringParaDate(data1);
        Date dataF = Util.stringParaDate(data2);
        
        Atendimento aux[] = atendimentoDao.getAll();
        String texto = "";   
        
        for (int i = 0; i < aux.length; i++) {
            if (aux[i] != null) {
                if (aux[i].getDate().after(dataI) && aux[i].getDate().before(dataF)) {
                    texto += aux[i] + "\n\n";
                    texto += "============================================\n";
                }
            }
        }
        
        return texto;
    }
}
