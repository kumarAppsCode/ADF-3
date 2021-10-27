declare
    sample_json   varchar2 (32767)
        := '{
    "glossary": {
        "title": "example glossary",
        "GlossDiv": {
            "title": "S",
            "GlossList": {
                "GlossEntry": {
                    "ID": "SGML",
                    "SortAs": "SGML",
                    "GlossTerm": "Standard Generalized Markup Language",
                    "Acronym": "SGML",
                    "Abbrev": "ISO 8879:1986",
                    "GlossDef": {
                        "para": "A meta-markup language, used to create markup languages such as DocBook.",
                        "GlossSeeAlso": ["GML", "XML"]
                    },
                    "GlossSee": "markup"
                }
            }
        }
    }
}';
begin
    apex_json.parse (sample_json);
    dbms_output.put_line (apex_json.get_varchar2 ('glossary.GlossDiv.title'));
    dbms_output.put_line (apex_json.get_varchar2 ('glossary.GlossDiv.GlossList.GlossEntry.GlossTerm'));
    dbms_output.put_line (apex_json.get_varchar2 ('glossary.GlossDiv.GlossList.GlossEntry.GlossDef.GlossSeeAlso[%d]', 2));
end;
