package metro;

public class Arista {
	
	private int nodoOrigen;
	private int nodoDestino;
	private int costo;
	
	public Arista(int nodoOrigen, int nodoDestino, int costo) {
		super();
		this.nodoOrigen = nodoOrigen;
		this.nodoDestino = nodoDestino;
		this.costo = costo;
	}

	public int getNodoOrigen() {
		return nodoOrigen;
	}

	public void setNodoOrigen(int nodoOrigen) {
		this.nodoOrigen = nodoOrigen;
	}

	public int getNodoDestino() {
		return nodoDestino;
	}

	public void setNodoDestino(int nodoDestino) {
		this.nodoDestino = nodoDestino;
	}

	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

	@Override
	public String toString() {
		return "Arista [nodoOrigen=" + (nodoOrigen + 1) + ", nodoDestino=" + (nodoDestino + 1) + ", costo=" + costo + "]";
	}
	
}
