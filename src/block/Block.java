package block;

public class Block {
	private int Bloc;
	private Boolean Pass;
	private String Stage;
	private int type;
	
	public Block(int bloc, Boolean pass, String stage, int type) {
		this.Bloc = bloc;
		this.Pass = pass;
		this.Stage = stage;
		this.type = type;
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

	public String getStage() {
		return Stage;
	}

	public void setStage(String stage) {
		Stage = stage;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	
	
}
