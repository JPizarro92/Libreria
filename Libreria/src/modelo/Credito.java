package modelo;

public class Credito {

	private double cupo;
	private int id;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getCupo() {
		return cupo;
	}

	public void setCupo(double cupo) {
		this.cupo = cupo;
	}

	@Override
	public String toString() {
		return "Credito [cupo=" + cupo + ", id=" + id + "]";
	}
	
	
	
}
