package controlador;

import modelo.ALU;

public class ctrlALU {
    private ALU alu;

    public ctrlALU() {
        this.alu = new ALU();
    }

    public String ejecutar(int opcode) {
        int[] resultado = alu.ejecutar(opcode);
        return binToString(resultado);
    }

    public void setOperandos(String op1, String op2) {
        alu.setDir1(stringToBin(op1));
        alu.setDir2(stringToBin(op2));
    }

    public ALU getALU() {
        return alu;
    }

    private String binToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int b : arr) sb.append(b);
        return sb.toString();
    }

    private int[] stringToBin(String s) {
        int[] bin = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            bin[i] = Character.getNumericValue(s.charAt(i));
        }
        return bin;
    }
}
