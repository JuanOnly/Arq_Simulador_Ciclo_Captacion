package modelo;

public class Procesador {
    private int[] MAR;
    private int[] MBR;
    private String UC;
    private int[] PC;
    private int[] IR;
    private int[] AC;
    private int[] dir1;
    private int[] dir2;
    private int[] codop;
    private ALU alu;

    public Procesador() {
        this.MAR = new int[6];
        this.MBR = new int[6];
        this.UC = "";
        this.PC = new int[16];
        this.IR = new int[16];
        this.AC = new int[6];
        this.dir1 = new int[6];
        this.dir2 = new int[6];
        this.codop = new int[4];
        this.alu = new ALU();
    }

    public void fetch(String instruccion16) {
        if (instruccion16.length() != 16) return;
        
        for (int i = 0; i < 4; i++) {
            codop[i] = Character.getNumericValue(instruccion16.charAt(i));
        }
        for (int i = 0; i < 6; i++) {
            dir1[i] = Character.getNumericValue(instruccion16.charAt(i + 4));
            dir2[i] = Character.getNumericValue(instruccion16.charAt(i + 10));
        }
        
        IR = stringToBin(instruccion16);
        
        alu.setCodop(codop);
        alu.setDir1(dir1);
        alu.setDir2(dir2);
    }

    public void ejecutar() {
        int opcode = binToInt(codop);
        int[] result = alu.ejecutar(opcode);
        AC = result;
    }

    public void setPC(int dir) {
        this.PC = intToBin(dir, 16);
    }

    public int getPCValue() {
        return binToInt(PC);
    }

    private int[] stringToBin(String s) {
        int[] bin = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            bin[i] = Character.getNumericValue(s.charAt(i));
        }
        return bin;
    }

    private int binToInt(int[] bin) {
        int res = 0;
        for (int b : bin) {
            res = (res << 1) | b;
        }
        return res;
    }

    private int[] intToBin(int val, int bits) {
        int[] res = new int[bits];
        for (int i = bits - 1; i >= 0; i--) {
            res[i] = val & 1;
            val >>= 1;
        }
        return res;
    }

    public int[] getMAR() { return MAR; }
    public void setMAR(int[] MAR) { this.MAR = MAR; }
    public int[] getMBR() { return MBR; }
    public void setMBR(int[] MBR) { this.MBR = MBR; }
    public String getUC() { return UC; }
    public void setUC(String UC) { this.UC = UC; }
    public int[] getPC() { return PC; }
    public void setPC(int[] PC) { this.PC = PC; }
    public int[] getIR() { return IR; }
    public void setIR(int[] IR) { this.IR = IR; }
    public int[] getAC() { return AC; }
    public void setAC(int[] AC) { this.AC = AC; }
    public int[] getDir1() { return dir1; }
    public void setDir1(int[] dir1) { this.dir1 = dir1; }
    public int[] getDir2() { return dir2; }
    public void setDir2(int[] dir2) { this.dir2 = dir2; }
    public int[] getCodop() { return codop; }
    public void setCodop(int[] codop) { this.codop = codop; }
    public ALU getAlu() { return alu; }
    public void setAlu(ALU alu) { this.alu = alu; }

    public String binToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int b : arr) sb.append(b);
        return sb.toString();
    }
}
