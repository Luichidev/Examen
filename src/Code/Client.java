package Code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Client {
  private String name;
  private ArrayList<Invoice> invoices;
  private int importTotal = 0;

  Client(String name){
    invoices = new ArrayList<Invoice>();
    this.name = name;
  }
 
  public void addInvoice(Invoice inv){
    invoices.add(inv);
    SortElements();
  }

  private void SortElements() {
		Collections.sort(invoices, new Comparator<Invoice>(){
      public int compare(Invoice inv1, Invoice inv2) {
          return inv1.isLesThan(inv2);
      }
		});
	}

  public int getTotalImport(){
	totalImport();
    return this.importTotal;
  }

  private void totalImport(){
    int sum = 0;
    for(Invoice inv : invoices){
      sum += inv.getAmount();
    }

    this.importTotal = sum;
  }

  public String toString() {
	String info = "Invoices of "+ this.name + ":\n";
	info += "---------\n";
	for(Invoice inv: invoices) {
		info+= inv.toString() + "\n";
	}
	return info;

  }
  
  public int lengthInvoices() {
	  return invoices.size();
  }

  public String getNameClient() {
	  return this.name;
  }
}


