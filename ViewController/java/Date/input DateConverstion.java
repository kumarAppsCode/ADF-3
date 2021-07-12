        if (stmtDate.getValue() != null) {
            repDate = stmtDate.getValue().toString();
            selectedDate = getFormattedDate(repDate);
        }

private String getFormattedDate(String repDate) throws ParseException { 
        SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy");
        java.util.Date date = formatter.parse(repDate);  
        SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy");
        return ft.format(date);
    }
