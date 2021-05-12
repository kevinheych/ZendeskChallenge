package com.kevinnh;

import java.util.List; 
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
 
public class Tickets {

@SerializedName("tickets")
@Expose
private List<Ticket> tickets = null;
@SerializedName("next_page")
@Expose
private String nextPage;
@SerializedName("previous_page")
@Expose
private Object previousPage;
@SerializedName("count")
@Expose
private Long count;

public List<Ticket> getTickets() {
return tickets;
}

public void setTickets(List<Ticket> tickets) {
this.tickets = tickets;
}

public String getNextPage() {
return nextPage;
}

public void setNextPage(String nextPage) {
this.nextPage = nextPage;
}

public Object getPreviousPage() {
return previousPage;
}

public void setPreviousPage(Object previousPage) {
this.previousPage = previousPage;
}

public Long getCount() {
return count;
}

public void setCount(Long count) {
this.count = count;
}

@Override
public String toString() {
StringBuilder sb = new StringBuilder();
sb.append(Tickets.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
sb.append("tickets");
sb.append('=');
sb.append(((this.tickets == null)?"<null>":this.tickets));
sb.append(',');
sb.append("nextPage");
sb.append('=');
sb.append(((this.nextPage == null)?"<null>":this.nextPage));
sb.append(',');
sb.append("previousPage");
sb.append('=');
sb.append(((this.previousPage == null)?"<null>":this.previousPage));
sb.append(',');
sb.append("count");
sb.append('=');
sb.append(((this.count == null)?"<null>":this.count));
sb.append(',');
if (sb.charAt((sb.length()- 1)) == ',') {
sb.setCharAt((sb.length()- 1), ']');
} else {
sb.append(']');
}
return sb.toString();
}

}