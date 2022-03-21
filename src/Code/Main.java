package Code;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class Main {
  public static void main(String[] args) {
	ArrayList<Client> clientList = new ArrayList<Client>(); 
	String file = "invoicesRoberto.txt";
	Client newClient = new Client("Roberto");
	readClientInvoices(newClient, file);
	clientList.add(newClient);
	
	file = "invoicesLaura.txt";
	newClient = new Client("Laura");
	readClientInvoices(newClient, file);
	clientList.add(newClient);
	
	file = "invoicesJaime.txt";
	newClient = new Client("Jaime");
	readClientInvoices(newClient, file);
	clientList.add(newClient);
	
	writeClientData(clientList);
  }
  
  
  public static void readClientInvoices(Client cli, String file) {
	try {
		BufferedReader in = new BufferedReader (new FileReader(file));
		String currentLine = "";
		Invoice inv;
		Date date;
		int amount = 0;
		String description;
			
		while((currentLine = in.readLine()) != null) {
			String[] parts = currentLine.split("/");
			int day = Integer.parseInt(parts[0]);
			int month = Integer.parseInt(parts[1]) - 1;
			int year = Integer.parseInt(parts[2]) - 1900;
			date = new Date(year, month, day);
			amount = Integer.parseInt(in.readLine());
			description = in.readLine();
			
			inv = new Invoice(date, description, amount);
			cli.addInvoice(inv);
		}
		
	} catch (IOException e) {
		e.fillInStackTrace();
	}
	
  }
  
  public static void writeClientData(ArrayList<Client> clients) {
	
	for (Client cli : clients) {
		System.out.println("Invoice of " + cli.getNameClient());
		System.out.println("Total Invoices: " + cli.lengthInvoices());
		System.out.println("Total Amount Invoices: " + cli.getTotalImport() + "€");
		
	}
  }
  

}
