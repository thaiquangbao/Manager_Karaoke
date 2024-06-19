package Function;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class functionNecessary {
    public String formatMoney (int x) {
        String mau = "" + x;
        String result = " VND";
        int j = 0;
        String z = mau.charAt(0) + "";
        for (int i = mau.length() -1 ; i > -1 ; i--) {
            if (j == 3) {
                result = mau.charAt(i) + "," + result;
                j = 0;
            } else {
                result = mau.charAt(i) + result;
            }
            j++;
        }
        if (z.equals("-")) {
        	result = result.replaceFirst("-,", "");
//        	result = "-" + result;
        }
        return result;
    }

    public String formatString (String x) {
        x = x.replaceAll(" ", "");
        x = x.replaceAll(",", "");
        x = x.replaceAll("VND","");
        return x;
    }
    public String formatNumber (int x) {
        String result = "";
        if (x < 10 ) {
            result = "0" + x;
        } else {
            result = "" + x;
        }
        return result;
    }
    public int moneyPerSecond (int money) {
        int result = 0;
        result = money / 3600;
        return result;
    }
    
    
    
    public String getCurrentTime () {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH : mm ( dd/MM/yyyy )");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now) + "";
    }
    
    
    public String formarMa (int x) {
        if (x < 10) {
            return "00" + x;
        }
        else if (x >= 10 && x < 100 ) {
            return "0" + x;
        }
        return "" + x;
    }
    
    public String formatTimeForAnalysis (String x) {
    	return x.substring(10, 20) + " ( " + x.substring(0,7) + " - " +x.substring(27, 34) + " )" ;
    }

}
