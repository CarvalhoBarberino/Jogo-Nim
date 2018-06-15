
public class Jogo implements Cloneable{
	//****
	private boolean vezDoComputador;//Variavel que indica se eh a vez do computador jogar.
	public boolean fimDeJogo;//Variavel que indica que ja eh possivel saber quem será o vencedor
	short computadorVence;//Variavel que indica se o computador vence. Caso o computador seja o vencedor, vale 1. Caso o usuario seja o vencedor, vale -1. Caso ainda seja impossivel saber quem eh o vencedor, vale 0. 
	private short[] l;
	//****
	public Jogo(){//Metodo construtor
		vezDoComputador = false;//Inicialmente o usuario sera o primeiro a jogar
		fimDeJogo = false;
		computadorVence = 0;
		l = new short[4];
		l[0] = 1;
		l[1] = 3;
		l[2] = 5;
		l[3] = 7;
	}
	//****
	public void mostrar(){//Esta funcao imprime na tela o estado atual do jogo
		for(int i = 0; i < 4; i++){
			for(int q = 1; q <= l[i]; q++){
				System.out.print(" I");
			}
			System.out.println();
		}
	}
	//****
	private int total(){//Esta funcao retorna o total de pecas na mesa
		return(l[0] + l[1] + l[2] + l[3]);
	}
	//****
	public void remover(int linha, int quantidade){//Esta funcao remove pecas da mesa
		if(!fimDeJogo && (0 <= l[linha] - quantidade) && (quantidade > 0)){
			l[linha] = (short) (l[linha] - quantidade);
			vezDoComputador = !vezDoComputador;
			mostrar();
		}
		mostraVez();
		ultimaAnalise();
	}
	//****
	public void mostraVez() {
		if(vezDoComputador) {System.out.println("Minha vez de jogar");}
		else {System.out.println("Sua vez de jogar");}
	}
	//****
	public boolean ultimaAnalise() {//Esta funcao retorna true se a vitoria do computador sobre o usuario ja estiver garantida
		if(total() == 1) {
			fimDeJogo = true;
			if(vezDoComputador) {
				//System.out.println("\nVoce venceu\n");
				computadorVence = -1;
				return false;
			}
			else {
				//System.out.println("\nEu venci\n");
				computadorVence = 1;
				return true;
			}
		}
		if(total() == 2) {
			fimDeJogo = true;
			if(vezDoComputador) {
				//System.out.println("\nEu venci\n");
				computadorVence = -1;
				return true;
			}
			else {
				//System.out.println("\nVoce venceu\n");
				computadorVence = -1;
				return false;
			}
		}
		return false;
	}
	//****
	public Jogo getClone(){//Esta funcao retorna uma copia do jogo.
		try {
			Jogo r = (Jogo)super.clone();
			r.l = new short[4];
			for(int i = 0; i < r.l.length; i++){//Este laco eh necessario para carregar uma copia de l no novo jogo. Se nao houvesse este laco entao o novo jogo teria apenas uma referencia a l ao invez de uma copia.
				r.l[i] = this.l[i];
			}
			return r;
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return new Jogo();
		}
	}
	//****
	public void jogada(int aleatorio){//Esta funcao recebe um inteiro aleatorio e faz uma jogada com base no inteiro recebido
		int modulo = (aleatorio % (total() - 1)) + 1;
		/*Sempre existe total() jogadas possiveis. Como retirar a ultima peca significa
		perder o jogo propositalmente entao soh podem ser retiradas (total() - 1) pecas.
		Como (aleatorio % (total() - 1)) varia entre 0 e (total() - 1) precisamos
		acrescentar 1 para variar entre 1 e total()*/
		int linha = 0;
		int q = 0;//Esta variavel indica a posicao da quebra de linha
		for(int i = 1; i < modulo; i++){//Este laco conta de 1 ate (modulo - 1), atribuindo 1 para primeira peca, 2 para segunda peca, etc. Como a ultima peca nao pode ser retirada, nao eh necessario contar ate a ultima peca.
			if(i > l[linha] + q){
				q = q + l[linha];//Atualiza posicao da quebra de linha
				linha++;//Atualiza a linha da ultima peca contada por i.
			}
			//System.out.println("depois: i=" + i + " l[" + linha + "]=" + l[linha] + " q=" + q);
		}
		//Quando o laco acima termina, fica definido qual linha sera alterada e quantas pecas serao retiradas dessa linha
		System.out.println(linha + " " + (modulo - q - 1));
		remover(linha, modulo - q - 1);
	}
	public boolean getVezDoComputador(){
		return vezDoComputador;
	}
}
