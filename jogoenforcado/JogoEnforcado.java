/*
 * P.A. - Programnação Avançada - Ficha 2 - Exercício 1 - Jogo do Enforcado
 * Renato Craveiro | 2018011392 | ISEC - Lic. Eng. Informática
 * 
 * O objetivo deste programa é simular um jogo do enforcado: o utilizador tenta 
    adivihar uma palavra em que lhe apresentam quantas letras tem, tendo 10
    tentativas para adivinhar a mesma. A cada letra não presente perde uma 
    tentativa, mas se adivinhar uma letra presente não perde tentativas. Pode ainda
    adivinhar a palavra mal desconfie qual seja.
 */
package jogoenforcado; //package do jogo: presente em todos os métodos

/**
 *
 * @author Renato Craveiro - 2020
 */
public class JogoEnforcado { //Class main que vai chamar todas as outras classes
    //a utilizar no jogo

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // main: chama tudo o que é necessário para a execução do jogo
        
        //novo objeto enforcado
        Enforcado jogo = new Enforcado();
        //novo objeto UI que recebe o objeto enforcado criado anteriormente
        UI UserInterface = new UI(jogo);
        //executa a função joga da UI, sendo ela a principal do programa
        UserInterface.joga();
        //ao sair da função joga, o programa termina
        
    }
    
}
