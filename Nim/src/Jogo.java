
public class Jogo {
	private boolean vezDoComputador, fimDeJogo;
	short computadorVence;
	private short[] l;
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
	public void mostrar(){
		for(int i = 0; i < 4; i++){
			for(int q = 1; q <= l[i]; q++){
				System.out.print(" I");
			}
			System.out.println("");
		}
	}
	private int total(){
		return(l[0] + l[1] + l[2] + l[3]);
	}
	public void remover(int linha, short quantidade){
		if(!fimDeJogo && ()){
			l[linha] = (short) (l[linha] - quantidade);
			vezDoComputador = !vezDoComputador;
		}
		if(total() == 2){
			fimDeJogo = true;
		}
	}
}
