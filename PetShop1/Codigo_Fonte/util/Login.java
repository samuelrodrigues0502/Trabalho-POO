package util;


public class Login {
   private static final String user = "jj";
   private static final String password = "jj";
   
   /**
    * Construtor da classe Login
    */
    public Login() {
    }
    /**
     * Função que compara a Strings digitadas com o usuário com o BD e libera/nega o acesso ao menu
     * @param user String digitada pelo usuário no campo "Usuário"
     * @param password String digitada pelo usuário no campo "Senha"
     * @return Retorna true para liberar o acesso caso as Strings sejam iguais ou retorna false e fecha o programa
     */
    public static boolean logar(String user, String password){
        if (Login.user.equals(user) && Login.password.equals(password)) {
            System.out.println("Login concluido.");
            return true;
        }else{
            System.err.println("Usuário ou senha errados.");
            return false;
            
        }
    }
}