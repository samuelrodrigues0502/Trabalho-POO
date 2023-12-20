package service;

import dao.AnimalDAO;
import java.util.Set;
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
     * Realiza os tratamentos necessários para a inserção correta e repassa o
     * objeto para a camada DAO
     *
     * @param animal Objeto animal recebido da camada de usuário
     * @return Retorna uma variável booleana para checagem de erros
     */
    public boolean inserir(Animal animal) {

        Set<Animal> set = animalDAO.getAll();
        
        if(!(set.isEmpty())){
            if(set.contains(animal)){
                return false;
            }
        }
        
        for (Animal anim : set) {
            if(anim.getCodigo() == animal.getCodigo()){
                return false;
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
    }

    /**
     * Encontra o objeto a ser removido e repassa o novo objeto e a posição para
     * a camada DAO
     *
     * @param cod Código do animal a ser alterado
     * @param animal Novo objeto animal que substituirá o antigo
     * @return Retorna uma variável booleana para checagem de erros
     */
    public boolean alterar(int cod, Animal animal) {

        Set<Animal> set = animalDAO.getAll();

        for (Animal anim : set) {
            if(anim.getCodigo() == cod){
                return animalDAO.alterar(cod, animal);
            }
        }

        return false;

    }

    /**
     * Encontra o objeto a ser removido e repassa a posição para a camada DAO
     *
     * @param cod Código do animal a ser alterado
     * @return Retorna uma variável booleana para checagem de erros
     */
    public boolean remover(int cod) {
        Set<Animal> set = animalDAO.getAll();

        for (Animal anim : set) {
            if(anim.getCodigo() == cod){
                return animalDAO.remover(cod);
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
     *
     * @param cod Código do animal a ser retornado
     * @return Retorna o animal obtido na camada DAO ou null caso inexistente
     */
    public Animal getAnimal(int cod) {
        Set<Animal> set = animalDAO.getAll();
        
        for (Animal anim : set) {
            if(anim.getCodigo() == cod){
                return animalDAO.getAnimal(cod);
            }
        }
        return null;
    }

    @Override
    public String toString() {

        String texto = "";
        Set<Animal> set = animalDAO.getAll();
        
        for (Animal anim : set) {
            texto += anim + "\n\n";
            texto += "============================================\n";
        }

        if (texto.equals("")) {
            return "Não existem dados cadastrados.";
        } else {
            return texto;
        }
    }
}
