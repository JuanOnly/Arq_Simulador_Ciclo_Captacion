package modelo;

public class ALU {
    private int[] dir1;
    private int[] dir2;
    private int[] codop;
    private int[] resultado;

    public ALU() {
        this.dir1 = new int[6];
        this.dir2 = new int[6];
        this.codop = new int[4];
        this.resultado = new int[6];
    }

    public ALU(int[] dir1, int[] dir2, int[] codop) {
        this.dir1 = dir1;
        this.dir2 = dir2;
        this.codop = codop;
        this.resultado = new int[6];
    }

    public int[] ejecutar(int opcode) {
        switch (opcode) {
            case 0: // move
                return dir1;
            case 1: // clear
                return new int[6];
            case 2: // set
                return new int[]{1,1,1,1,1,1};
            case 4: // add
                return sumar(dir1, dir2);
            case 5: // sub
                return restar(dir1, dir2);
            case 6: // mpy
                return multiplicar(dir1, dir2);
            case 7: // div
                return dividir(dir1, dir2);
            case 8: // negate
                return negar(dir1);
            case 9: // and
                return and(dir1, dir2);
            case 10: // or
                return or(dir1, dir2);
            case 11: // not
                return not(dir1);
            default:
                return new int[6];
        }
    }

    private int[] sumar(int[] a, int[] b) {
        int valA = binToInt(a);
        int valB = binToInt(b);
        int res = valA + valB;
        return intToBin(res, 6);
    }

    private int[] restar(int[] a, int[] b) {
        int valA = binToInt(a);
        int valB = binToInt(b);
        int res = valA - valB;
        return intToBin(Math.abs(res), 6);
    }

    private int[] multiplicar(int[] a, int[] b) {
        int valA = binToInt(a);
        int valB = binToInt(b);
        int res = valA * valB;
        return intToBin(res, 6);
    }

    private int[] dividir(int[] a, int[] b) {
        int valA = binToInt(a);
        int valB = binToInt(b);
        if (valB == 0) return new int[6];
        int res = valA / valB;
        return intToBin(res, 6);
    }

    private int[] negar(int[] a) {
        int[] res = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            res[i] = (a[i] == 1) ? 0 : 1;
        }
        return res;
    }

    private int[] and(int[] a, int[] b) {
        int[] res = new int[Math.max(a.length, b.length)];
        for (int i = 0; i < res.length; i++) {
            int valA = i < a.length ? a[i] : 0;
            int valB = i < b.length ? b[i] : 0;
            res[i] = (valA == 1 && valB == 1) ? 1 : 0;
        }
        return res;
    }

    private int[] or(int[] a, int[] b) {
        int[] res = new int[Math.max(a.length, b.length)];
        for (int i = 0; i < res.length; i++) {
            int valA = i < a.length ? a[i] : 0;
            int valB = i < b.length ? b[i] : 0;
            res[i] = (valA == 1 || valB == 1) ? 1 : 0;
        }
        return res;
    }

    private int[] not(int[] a) {
        return negar(a);
    }

    private int binToInt(int[] bin) {
        int res = 0;
        for (int i = 0; i < bin.length; i++) {
            res = (res << 1) | bin[i];
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

    public int[] getDir1() { return dir1; }
    public void setDir1(int[] dir1) { this.dir1 = dir1; }
    public int[] getDir2() { return dir2; }
    public void setDir2(int[] dir2) { this.dir2 = dir2; }
    public int[] getCodop() { return codop; }
    public void setCodop(int[] codop) { this.codop = codop; }
    public int[] getResultado() { return resultado; }
    public void setResultado(int[] resultado) { this.resultado = resultado; }

    public String toString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int b : arr) sb.append(b);
        return sb.toString();
    }
}
