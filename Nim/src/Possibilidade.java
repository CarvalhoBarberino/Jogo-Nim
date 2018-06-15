
public class Possibilidade {
	public static short profundidadeMax = 5;//Variavel que indica quantos niveis podem ser simulados sem travar o computador
	private short profundidade;//Variavel que indica a profundidade da analise atual.
	public static short larguraMax = 5;//Variavel que indica quantas simulacoes por nivel podem ser realizadas sem travar o computador
	boolean jogoValido;//Variavel que indica que o jogo foi aceito pelo construtor.
	private Jogo jogoASerAnalisado;
	//****
	public Possibilidade(Jogo jogoArg){
		profundidade = 0;
		if(!jogoArg.fimDeJogo && jogoArg.getVezDoComputador()){//Nao se pode iniciar Possibilidade de um jogo já acabado nem de um jogo onde seja a vez do usuario jogar
			jogoASerAnalisado = jogoArg;
		}
		else{
			jogoValido = false;
		}
	}
	//****
	public int melhorJogada(){
		int melhorJogada;
		int pontuacao = 0;
		/*
		for(int i = 0; i <= larguraMax; i++){
			if(pontuacao < pontuacao2){pontuacao = pontuacao2; melhorJogada = melhorJogada2}
		}
		
		 */
		return melhorJogada;
	}
	
}
