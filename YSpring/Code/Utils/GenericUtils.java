    public static String getCurrentdate() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        String strDate = formatter.format(date);
        return strDate;
    }

******************************************************************************************
