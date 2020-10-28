package PracticeLab_5;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class StringToDateExample1 {
	public static void main(String[] args)throws Exception {  
	    String sDate1="31/12/1998";  
	    Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);  
	    System.out.println(sDate1+"\t"+date1);  
	    
	    
	    SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
	    
	    String dateInString = "7-Jun-2013";
	    Date date = formatter.parse(dateInString);
	    System.out.println(date);  
	    
	}  
}
