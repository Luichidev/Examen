package Code;

import java.text.SimpleDateFormat;
import java.util.*;

public class Invoice {
  private Date date;
  private String description;
  private static int id = 0;
  private int amount;
  private int invoiceID;

  Invoice(Date date, String description, int amount) {
    this.date = date;
    this.description = description;
    this.amount = amount;
    id++;
    this.invoiceID = id;
  }

  public int isLesThan(Invoice i) {
	  int isLess = 0;
		if (this.date.before(i.date)) {
			isLess = -1;
		}else if (i.date.before(this.date)) {
			isLess = 1;
		}else {
			if (this.amount < i.amount) {
				isLess = -1;
			}else if (this.amount > i.amount) {
				isLess = 1;
			}else {
				isLess = 0;
			}
		}
		
		return isLess;
  }

  public String getDate() {
    String date = "";
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    date = formatter.format(this.date);
    return date;
  }
  
  public String toString() {
	String info = "";
	info += "{ id: " + this.invoiceID;
	info += ", Description.: " + this.description;
	info += ", Amount: " + this.amount;
	info += ", Date.: " + getDate();
	info += "}"; 
	return info;
  }
  
  public int getAmount() {
	  return this.amount;
  }
}
