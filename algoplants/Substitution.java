package algoplants;

import java.util.Hashtable;

public class Substitution {
    Hashtable<Character, String> table;
    String code;
    int depth;

    public Substitution(Hashtable<Character, String> table, int depth, String seed) {
        this.table = table;
        this.depth = depth;
        this.code = this.makeCode(seed);
    }

    private String makeCode(String seed) {
        String code = seed;
        String tmp = "";
        for (int i = 0; i < this.getDepth(); i++) {
            for (int j = 0; j < code.length(); j++) {
                try {
                    tmp = tmp + table.get(code.charAt(j));
                }
                catch (Exception e)
                {
                    System.out.println("stala se chyba"+e.getMessage());
                }
            }
            System.out.println(tmp);
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
