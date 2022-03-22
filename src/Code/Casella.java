package Code;

import java.util.ArrayList;

public class Casella {
	enum Cell {
		NORMAL,
		OCA,
		POU,
		MORT,
		FINAL
	}
	
	Casella() {
		m_posicio = 0;
		m_tipus = Cell.NORMAL;
	}
	
	public void setPosicio(int posicio) { m_posicio = posicio;}
	public void setTipus(Cell tipus) {	m_tipus = tipus; }
	public int getPosicio() { return m_posicio;	}
	public boolean esOca() { return m_tipus == Cell.OCA; }
	
	public boolean entraJugador(Jugador j, ArrayList<Casella> caselles) {
		boolean torn = false;
		switch (m_tipus) {
		case NORMAL:
			break;
		case POU:
			j.setInactiu(2);
			int ocaIndex = -1;
			int i = m_posicio + 1;
			while (ocaIndex == -1 || i < caselles.size()) {
				if(caselles.get(i).esOca()) {
					ocaIndex = i;
				} else {
					i++;
				}
			}
			if(ocaIndex != -1) {
				j.mou(ocaIndex);
			}
			break;
		case MORT:
			j.mou(0);
			break;
		case FINAL:
			j.guanya();
			break;
		case OCA:
			torn = true;
			break;
		}
		
		return torn;
	}
	
	private int m_posicio;
	private Cell m_tipus;
	
}
