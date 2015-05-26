package algoplants;

import java.util.Hashtable;

/* Třída reprezentující substituci a její kód */
public class Substitution {
    /* Hašovací tabulka s pravidly */
    Hashtable<Character, String> table;
    /* Kód generovaný ze seedu po aplikovaní substituce depth-krát */
    String code;
    /* Počet krokrů kolikrát bude aplikována subsituce */
    int depth;

    public Substitution(Hashtable<Character, String> table, int depth, String seed) {
        this.table = table;
        this.depth = depth;
        this.code = this.makeCode(seed);
    }

    private String makeCode(String seed) {
        String code = seed;
        String tmp = "";
        /* připravení kódu -- podle počtu kroků se vždy vezme získaný řetězec
        * (začíná se se seedem) a provede se ve všech znacích substituce
        * pomocí přepisovacího pravidla získaného z hašovaví tabulky
        */
        for (int i = 0; i < this.getDepth(); i++) {
            for (int j = 0; j < code.length(); j++) {
                try {
                    if(table.get(code.charAt(j))!= null)
                    {
                        tmp = tmp + table.get(code.charAt(j));
                    }
                    else
                    {
                        tmp = tmp + code.charAt(j);
                    }

                }
                catch (Exception e)
                {
                    System.out.println("stala se chyba"+e.getMessage());
                }
            }
            //System.out.println(tmp);
            code = tmp;
            tmp = "";

        }
        return code;
    }

    public Hashtable<Character, String> getTable() {
        return table;
    }

    public void setTable(Hashtable<Character, String> table) {
        this.table = table;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }
}
