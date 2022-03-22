package Code;

public class Jugador {

	Jugador(){
		this.m_casella = 1;
		this.m_potTirar = true;
		this.m_nTornsInactius = 0;
		this.m_guanyador = false;
	}
	
	public int posicio() {	return this.m_casella;	}
	public void mou(int casella) {	this.m_casella = casella;	}
	public void guanya() {	this.m_guanyador = true; }
	public boolean esGuanyador() { return this.m_guanyador;	}
	
	public void setInactiu(int nTorns) {
		this.m_potTirar = false;
		this.m_nTornsInactius = nTorns;
	}
	
	public boolean potTirar() {
		boolean potTirar = m_potTirar;
		
		if(!potTirar) {
			this.m_nTornsInactius--;
			if(this.m_nTornsInactius == 0) {
				this.m_potTirar = true;				
			}
		}
		
		return this.m_potTirar;
	}
	
	private int m_casella;
	private boolean m_potTirar;
	private int m_nTornsInactius;
	private boolean m_guanyador;
}
