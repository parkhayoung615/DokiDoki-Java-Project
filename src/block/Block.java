package block;

public class Block {
	private int Bloc;
	private Boolean Pass;
	private String Stage;
	
	public Block(int bloc, Boolean pass, String stage) {
		this.Bloc = bloc;
		this.Pass = pass;
		this.Stage = stage;
	}

	public int getBloc() {
		return Bloc;
	}

	public void setBloc(int bloc) {
		Bloc = bloc;
	}

	public Boolean getPass() {
		return Pass;
	}

	public void setPass(Boolean pass) {
		this.Pass = pass;
	}
	
	
	
}
