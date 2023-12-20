package service;

import dao.AnimalDAO;
import model.Animal;


public class AnimalService {

    private AnimalDAO animalDAO;

    /**
     * Construtor da classe AnimalService
     */
    public AnimalService() {

        animalDAO = new AnimalDAO();
    }

    /**
     * Realiza os tratamentos necessários para a inserção correta e repassa o objeto para a camada DAO
     * @param animal Objeto animal recebido da camada de usuário
     * @return Retorna uma variável booleana para checagem de erros
     */
    public boolean inserir(Animal animal) {

        //testar regras de negocio: os campos estão todos preenchidos? 
        //                            o vetor está cheio?
        int contador = 0;
        Animal aux[] = animalDAO.getAll();
        for (int i = 0; i < aux.length; i++) {
            if (aux[i] != null) {
                contador++;
            }
        }

        if (contador < aux.length - 1) {
            for (int i = 0; i < aux.length; i++) {
                if (aux[i] != null) {
                    if (aux[i].getCodigo() == animal.getCodigo()) {
                        return false;
                    }
                }
            }

            if (animal.getEndereco().equals("")) {
                System.out.println("Endereço nulo");
                return false;
            }
            if (animal.getCidade().equals("")) {
                System.out.println("Cidade nulo");
                return false;
            }
            if (animal.getNome().equals("")) {
                System.out.println("Nome nulo");
                return false;
            }

            return animalDAO.inserir(animal);
        } else {
            System.out.println(" \nNão é possível, estamos sem vagas.\n");
            return false;
        }
    }

    /**
     * Encontra o objeto a ser removido e repassa o novo objeto e a posição para a camada DAO
     * @param cod Código do animal a ser alterado
     * @param animal Novo objeto animal que substituirá o antigo
     * @return Retorna uma variável booleana para checagem de erros
     */
    public boolean alterar(int cod, Animal animal) {

        Animal aux[] = animalDAO.getAll();

        if (cod >= 0 && cod < aux.length) {
            for (int i = 0; i < aux.length; i++) {
                if (aux[i] != null) {
                    if (aux[i].getCodigo() == cod) {
                        return animalDAO.alterar(cod, animal);
                    }
                }
            }
        }
        return false;

    }
    
    /**
     * Encontra o objeto a ser removido e repassa a posição para a camada DAO
     * @param cod Código do animal a ser alterado
     * @return Retorna uma variável booleana para checagem de erros
     */
    public boolean remover(int cod) {
        Animal aux[] = animalDAO.getAll();

        if (cod >= 0 && cod < aux.length) {
            for (int i = 0; i < aux.length; i++) {
                if (aux[i] != null) {
                    if (aux[i].getCodigo() == cod) {
                        return animalDAO.remover(cod);
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

            animalDAO.limpaDados();
    }

    /**
     * Encontra a posição do objeto e repassa para a camada DAO
     * @param cod Código do animal a ser retornado
     * @return Retorna o animal obtido na camada DAO ou null caso inexistente
     */
    public Animal getAnimal(int cod) {
        Animal aux[] = animalDAO.getAll();
        if (cod >= 0 && cod < aux.length) {
            for (int i = 0; i < aux.length; i++) {
                if (aux[i] != null) {
                    if (aux[i].getCodigo() == cod) {
                        return animalDAO.getAnimal(cod);
                    }
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {

        String texto = "";
        Animal aux[] = animalDAO.getAll();

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
