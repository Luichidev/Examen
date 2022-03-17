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

  public boolean isLesThan(Invoice i) {
    boolean isLess = false;

    if (this.date.before(i.date)) {
      isLess = true;
    } else if (i.date.before(this.date)) {
      isLess = false;
    } else {
      isLess = this.amount < i.amount;
    }

    return isLess;
  }

  public String getDate() {
    String date = "";
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    date = formatter.format(this.date);
    return date;
  }
}
