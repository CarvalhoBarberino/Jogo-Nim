
public class Jogo implements Cloneable{
	//****
	private boolean vezDoComputador;
	public boolean fimDeJogo;
	short computadorVence;
	private short[] l;
	//****
	public Jogo(){
		vezDoComputador = false;
		fimDeJogo = false;
		computadorVence = 0;
		l = new short[4];
		l[0] = 1;
		l[1] = 3;
		l[2] = 5;
		l[3] = 7;
	}
	//****
	public void mostrar(){
		for(int i = 0; i < 4; i++){
			for(int q = 1; q <= l[i]; q++){
				System.out.print(" I");
			}
			System.out.println("");
		}
	}
	//****
	private int total(){
		return(l[0] + l[1] + l[2] + l[3]);
	}
	//****
	public void remover(int linha, int quantidade){
		if(!fimDeJogo && (0 <= l[linha] - quantidade)){
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
	public boolean ultimaAnalise() {
		if(total() == 1) {
			fimDeJogo = true;
			if(vezDoComputador) {
				System.out.println("/nVoce venceu\n");
				computadorVence = -1;
				return false;
			}
			else {
				System.out.println("\nEu venci\n");
				computadorVence = 1;
				return true;
			}
		}
		if(total() == 2) {
			fimDeJogo = true;
			if(vezDoComputador) {
				System.out.println("/nEu venci\n");
				computadorVence = -1;
				return true;
			}
			else {
				System.out.println("\nVoce venceu\n");
				computadorVence = -1;
				return false;
			}
		}
		return false;
	}
	//****
	public Jogo getClone(){
		try {
			Jogo r = (Jogo)super.clone();
			r.l = new short[4];
			for(int i = 0; i < r.l.length; i++){
				r.l[i] = this.l[i];
			}
			return r;
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return new Jogo();
		}
	}
}
