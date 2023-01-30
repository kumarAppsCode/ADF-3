create or replace FUNCTION get_amt_in_words (l_amt IN NUMBER, l_ccode VARCHAR2)
      RETURN VARCHAR2
   AS
      words      VARCHAR2 (1000);
      whole      VARCHAR2 (500) := NULL;
      frac       VARCHAR2 (500) := NULL;
      suffix1    VARCHAR2 (20);
      suffix2    VARCHAR2 (20);
      currency   NUMBER (20, 3);
      code       VARCHAR2 (200);
      c2         NUMBER;
      i          NUMBER;
      p          NUMBER;
      flen       NUMBER;
      text       VARCHAR2 (30);
      tl         NUMBER;
      tl1        NUMBER;
   BEGIN
      IF l_ccode IN ('BHD', 'KWD', 'OMR')
      THEN
         text := TO_CHAR (l_amt, '99999999.999');
         tl1 := 1000;
      ELSE
         text := TO_CHAR (l_amt, '99999999.99');
         tl1 := 100;
      END IF;

      tl := LENGTH (text);
      p :=
         INSTR (text,
                '.',
                1,
                1);
      tl := LENGTH (SUBSTR (text, p + 1, tl));
      currency := TRUNC (l_amt);
      c2 := l_amt - currency;
      c2 := c2 * tl1;
      code := UPPER (l_ccode);

      BEGIN
         SELECT DECODE (l_ccode,
                        'USD', 'cents',
                        'GBP', 'pences',
                        'SAR', 'halalat',
                        'QAR', 'dirhams',
                        'AED', 'fils',
                        'DEM', 'pfennigs',
                        'EURO', 'euro cents',
                        'INR', 'paise',
                        'FRF', 'centimes',
                        'BHD', 'fils',
                        'KWD', 'fils',
                        'OMR', 'baizas',
                        'KES', 'cents',
                        'ZAR', 'cents',
                        'UGX', 'cents',
                        'TZS', 'cents')
           INTO suffix2
           FROM DUAL;
      EXCEPTION
         WHEN OTHERS
         THEN
            RAISE;
      END;

      BEGIN
         SELECT DECODE (l_ccode,
                        'USD', ' US Dollars',
                        'BHD', ' Bahraini Dinars',
                        'GBP', ' Pounds',
                        'KWD', ' Kuwaiti Dinars',
                        'SAR', ' Saudi Riyals',
                        'QAR', ' Qatari Riyals',
                        'AED', ' UAE Dirhams',
                        'DEM', ' German Marks',
                        'EURO', ' Euros',
                        'INR', ' Indian Rupees',
                        'FRF', ' French Franks',
                        'OMR', ' Omani Rials',
                        'IRR', ' Iran Rials',
                        'KES', 'Kenya Shillings',
                        'ZAR', 'South African Rand',
                        'UGX', 'Ugandan Shillings',
                        'TZS', 'Tanzanian Shiilings')
           INTO suffix1
           FROM DUAL;
      EXCEPTION
         WHEN OTHERS
         THEN
            RAISE;
      END;

      IF (currency + c2 = 0)
      THEN
         --words :='Zero '||' and Zero '||INITCAP(suffix2)||' '||'Only';
         words :=
               'Zero '
            || INITCAP (suffix1)
            || ' and Zero '
            || INITCAP (suffix2)
            || ' '
            || 'Only';
      ELSE
         words := 'Zero '
            || INITCAP (suffix1)
            || ' and Zero '
            || INITCAP (suffix2)
            || ' '
            || 'Only';
           --    ap_amount_utilities_pkg.ap_convert_number (currency)
           -- || ','
           -- || ap_amount_utilities_pkg.ap_convert_number (c2);
         p :=
            INSTR (words,
                   ',',
                   1,
                   1);
         whole := whole || SUBSTR (words, 1, p - 1);
         frac := frac || SUBSTR (words, p + 1, LENGTH (words));
         --   words := INITCAP(replace(whole,'-',' '))||' and '||
         --INITCAP(frac)||' '||INITCAP(suffix2)||' '||'Only';

         words :=
               INITCAP (REPLACE (whole, '-', ' '))
            || ' '
            || 'Dirhams'
            || ' and '
            || INITCAP (frac)
            || ' '
            || INITCAP (suffix2)
            || ' '
            || 'Only';                                      --INITCAP(suffix1)
      END IF;

      RETURN words;
   EXCEPTION
      WHEN OTHERS
      THEN
         words := 'UNKNOWN CURRENCY';
         RETURN words;
   END get_amt_in_words;
