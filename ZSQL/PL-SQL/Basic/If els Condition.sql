IF(p_TAX_CODE='COMMERCIAL') THEN
l_taxper:=5;
ELSIF(p_TAX_CODE='COMMERCIAL EXEMPT') THEN
l_taxper:=0;
ELSIF(p_TAX_CODE='RESIDENTIAL') THEN
l_taxper:=0;
ELSIF(p_TAX_CODE='RESIDENTIAL EXEMPT')THEN
l_taxper:=0;
ELSIF(p_TAX_CODE='STANDARD RATE') THEN
l_taxper:=5;
else 
l_taxper:=0;
END IF;
