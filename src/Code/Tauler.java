package Code;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Tauler {
	ArrayList<Jugador> players;
	ArrayList<Casella> caselles;
	int m_tornActual;
	
	Tauler(){
		players = null;
		caselles = null;
		m_tornActual = -1;
	}
	
	public void inicialitza(String nomFitxer, int nJugador) {
		try {
			inicialitzaJugador(nJugador);
			caselles = new ArrayList<Casella>();
			m_tornActual = 0;
			BufferedReader in = new BufferedReader (new FileReader(nomFitxer));
			String currentLine = "";
			String tipus;
			int pos;
			
			while((currentLine = in.readLine()) != null) {
				String[] parts = currentLine.split(" ");
				pos = Integer.parseInt(parts[0]);
				tipus = parts[1];
				
				Casella.Cell type = getType(tipus);				
				Casella newCasella = new Casella();
				newCasella.setPosicio(pos);
				newCasella.setTipus(type);
				caselles.add(newCasella);
			}
			in.close();
		} catch (IOException e) {
			e.fillInStackTrace();
		}
	}
	
	public void inicialitzaJugador(int n) {
		players =  new ArrayList<Jugador>();
		
		if(n < 5 && n > 0) {
			for (int i = 0; i < n; i++) {
				players.add(new Jugador());
			}
		} else {
			if(n <= 0) System.err.println("Has de crear com a mínim un jugador!");
			else System.err.println("Només es poden crear fins 4 jugadors!");
		}
	}
	
	private Casella.Cell getType(String tipus){
		Casella.Cell type = Casella.Cell.NORMAL;
		if(tipus.compareTo("OCA") == 0) {
			type = Casella.Cell.OCA;
		} else if(tipus.compareTo("POU") == 0) {
			type = Casella.Cell.POU;
		} else if(tipus.compareTo("MORT") == 0) {
			type = Casella.Cell.MORT;
		}else if(tipus.compareTo("FINAL") == 0) {
			type = Casella.Cell.FINAL;
		}
		
		return type;
	}
	
	public void tornJoc() {
		boolean conservaTorn = true;
		Jugador currentPlayer = players.get(m_tornActual);
		while (conservaTorn) {
			if(currentPlayer.potTirar()) {
				int dau = valorDau();
				int nextCasella = currentPlayer.posicio() + dau;
				if(nextCasella >= caselles.size()) {
					conservaTorn = false;
				} else {
					currentPlayer.mou(nextCasella);
					conservaTorn = caselles.get(nextCasella).entraJugador(currentPlayer, caselles);
				}
			} else {
				conservaTorn = false;
			}
		}
		
		m_tornActual = (m_tornActual + 1) % players.size();
	}
	
	public int valorDau() {
		return (int) (Math.floor(Math.random() * 6) + 1);
	}
}
