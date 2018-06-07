
public class Nim {
	public static void main(String args[]){
		Jogo j1 = new Jogo();
		Jogo j2 = j1.getClone();
		j1.remover(3, 7);
		j1.remover(0, 1);
		j1.remover(2, 4);
		j1.remover(1, 1);
		j1.remover(1, 1);
		j1.remover(2, 1);
		System.out.println("j2");
		j2.mostrar();
		
		/*while(!j1.fimDeJogo) {
			
		}*/
	}
}
