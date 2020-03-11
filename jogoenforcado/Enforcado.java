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
import java.util.Random; //para utilizar a função Random
/**
 *
 * @author Renato Craveiro - 2020
 */
public class Enforcado { //Class Enforcado: controla o jogo em si
    //tem as funções de funcionamento do jogo que podem ser chamadas a qualquer
    //momento pela Interface de utilizador
    
    private static String dic[]={ //array dic de strings: contém todas as palavras
        //possíveis de se calhar durante o jogo
        "Forquilha", "Praia", "Marrom", "Anel", "Fralda", "Estrada", "Fruta", "Livro", "Carne", 
        "Zero", "Chupeta", "Orelha", "Pulso", "Sapato", "Lampada", "Sorvete", "Carne", "Pino", 
        "Tubarao", "Assobio", "Bonito", "Abelha", "Mar", "Barriga", "Saia", "Pimenta", "Lamente", 
        "Orelhas", "Dedo", "Dez", "Flor", "Meias", "Motocicleta", "Martelo", "Tulipa", "Espada", 
        "Dinheiro", "Torneira", "Saia", "Sino", "Tomates", "Bom", "Abelha", "Cavalo", "Relogio", 
        "Fino", "Comida", "Fantasma", "Guardanapo", "Cebola"

    };
    
    private static String getRandomWord(String[] array) {
        //devolve uma palavra aleatória do array de strings que lhe for atribuido
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }
    
    boolean jogoTerminou; //controla se o jogo terminou ou não
    private int tentativas; //controla as tentativas utilizadas pelo utilizador
    private static int maxTentativas=10; //máximo de tentativas: por defeito 10
    public String palavraUtil; //a palavra adivinhada e até ao momento correta
    private String palavraCorr; //guarda a palavra a adivinhar
    private String letrasUsadas =""; //letras/palavras utilizadas pelo utilizador 
    //mas incorretas
    
    
    public int getTentativas(){
        //devolve o número de tentativas utilizadas pelo utilizador
        return tentativas;
    }
    
    public Enforcado(){
        //COnstrutor do Enforcado: prepara as variáveis para começar o jogo
        jogoTerminou = false; //o jogo começou, ou seja, ainda não terminou
        tentativas=0; //Ainda não foram gastas tentativas
        palavraCorr = getRandomWord(dic); //apanha uma palavra aleatória do array 
        //dic[] e coloca-a na String palavraCOrr
        palavraCorr = palavraCorr.toLowerCase(); //muda a palavra apenas para 
        //minúsculas, para facilitar a comparação mais adiante
        palavraUtil=""; //até agora o utilizador não adivinhou nada
        for (int i=0; i<palavraCorr.length();i++){
            palavraUtil = palavraUtil+"_"; //coloca _ por cada letra da palavra 
            //a adivinhar
        }
        System.out.println("Novo jogo preparado com Sucesso!\n\nBem vindo ao jogo do enforcado.\n");
    }
    
    public String adicionaLetra(String lUsadas, String Uinput){
        //adiciona letras às letras/palavras pelo utilizador até ao momento
        lUsadas = lUsadas+" "+Uinput; //separa-as por espaços
        return lUsadas; //devolve a mesma String já completa
    }
    
    public void jogo(){
        //Apresenta os dados obtidos até ao momento de chamada da função
        
        //Apresenta o número de tentativas que o utilizador ainda pode dar
        System.out.println("\nTem "+(maxTentativas-tentativas)+" tentativas para adivinhar a palavra.\n");
        
        if(!letrasUsadas.isEmpty()){
            //Se ainda errou alguma letra/palavra então a lista tem conteúdo, que
            //será apresentado neste momento
            System.out.println("Letras usadas: "+letrasUsadas+"\n");
        }
        
        //Apresenta a palavra até agora descoberta
        System.out.println("Palavra a adivinhar: "+palavraUtil+"\n\n Insira uma letra.");
    }
    
    public void wrong(String guess){
        //Trata das variáveis que se alteram quando o utilizdor erra letra/palavra
        //E apresenta que a letra/palavra não se apresenta correta
        
        //Aumenta o número de tentativas utilizadas até agora
        tentativas++;
        //Adiciona a palavra/letra incorreta à string de palavras/etras incorretas
        letrasUsadas = adicionaLetra(letrasUsadas, guess);
        //Avisa o utilizador de que não se encontra na palavra
        System.out.println(guess+" não se encontra na palavra.");
        //Se as tentativas utilizadas chegaram ao máximo de tentativas
        if(tentativas==maxTentativas){
            //Atualiza a variável de jogo terminado para verdadeiro
            jogoTerminou=true;
        }
    }
    
    public void correct(String guess){
        //Caso a palavra/letra esteja correta
        
        //Avisa o utilizador de que a mesma se encontra na palavra
        System.out.println(guess+" encontra-se na palavra.");
        //a variável index obtém a posição da primeira letra/palavra que se encontra
        //na palavra correta
        int index = palavraCorr.indexOf(guess);
        //enquanto index >=0, pois se não encontrar mais passa a -1
        while (index >= 0) {
            //A palavra do Utilizador vai colocar a letra na posição de index
            palavraUtil = palavraUtil.substring(0, index) + guess + palavraUtil.substring(index + 1); 
            //o index procura uma nova aparição da letra/palavra na palavra correta 
            //e obtém a posição da mesma na palavra Correta
            index = palavraCorr.indexOf(guess, index + 1);
        }
        
        //Se a palavra correta for igual à palavra introduzida ou à palavra
        //até agora adivinhada pelo utilizador
        if(palavraCorr.equals(guess) || palavraCorr.equals(palavraUtil)){
            //passa a variável d ejogo terminado para verdadeiro
            jogoTerminou=true;
        }
    }
    
    
    public boolean aceita(String guess){
        //Verifica se encontrou a palavra introduzida na palavra correta ou não
        
        //variável que guarda a introdução do utilizador para minúsculas
        String lowerGuess;
        lowerGuess = guess.toLowerCase();

        //se a palavra não contém o introduzido pelo user
        if(!palavraCorr.contains(guess)){
            //retorna falso         
            return false;
        }else{
            //Caso contrário retorna verdadeiro
            return true;           
        }
                
    }
    
    public void gameOver(int tent){
        //chamado para terminar o jogo, apresentando os resultados finais
        
        //Se as tentativas foram todas utilizadas
        if(tentativas==maxTentativas){
            
            //avisa que o limite de tentativas foi utilizado ao utilizador. GAME OVER
            System.out.println("Chegou ao limite de tentativas. \n\n---GAME OVER---\n\n");
        }else{
            //Caso contrário (as tentativas ainda atingiram o máximo)
            //Congrtula o user e confirma a palavra adivinhada com a apalavra 
            //correta. Avisa o termino do jogo.
            System.out.println("PARABENS, adivinhou a palavra "+palavraCorr+" ("+palavraUtil+")!\n\nAcabou o jogo!\n\n");
        }
    }
       
}
