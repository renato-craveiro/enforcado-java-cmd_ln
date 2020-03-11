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
import java.util.Scanner; //para utilizar o Scanner de introdução de dados do user
/**
 *
 * @author Renato Craveiro - 2020
 */
public class UI  { //Class UI: controla a User Interface do jogo
    //chama as funções do jogo propriamente dito nas ocasiões em que são precisas
    
    //cria um objeto enforcado para controlar o jogo
    Enforcado jogo; 
    
    //Construtor de UI que recebe um objeto Enforcado e atribui ao objeto da classe 
    //UI
    public UI(Enforcado e){
        jogo=e;
    }
    
    //função joga que pergunta o necessário ao obejto jogo quando necessário
    public void joga(){
        //Scanner sc para receber dados do user
        Scanner sc;
        //String resposta que guarda o introduzido pelo user
        String resposta;
        //inicializa o Scanner para receber dados do teclado (default System.in)
        sc= new Scanner(System.in);
        //enquanto a variável de jogo terminado do objeto jogo não for verdadeiro
        while(!jogo.jogoTerminou){
            //chama a função jogo do objeto jogo, que mostra os valores ao user
            jogo.jogo();
            //obtém a resposta do user para a variável resposta
            resposta=sc.nextLine();
            //se o jogo não aceitar a resposta
            if(!jogo.aceita(resposta)){
                //vai para a função de respota errada 
                jogo.wrong(resposta);
            }else{
                //caso contrário vai para a função de resposta correta
                jogo.correct(resposta);
            }
            //Se entretanto o jogo acabou
            if(jogo.jogoTerminou){
                //chama a função gameOver que obtém o número de tentativas
                //para confirmar se foram todas gastas ou não
                jogo.gameOver(jogo.getTentativas());
            }
        }
    }
    
}
