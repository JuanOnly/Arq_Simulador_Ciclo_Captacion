package modelo;

public class Bus {
    private int[] bDatos;
    private int[] bControl;
    private int[] bInstruccion;

    public Bus() {
        this.bDatos = new int[6];
        this.bControl = new int[4];
        this.bInstruccion = new int[16];
    }

    public void escribirDatos(int[] datos) {
        this.bDatos = datos;
    }

    public void escribirControl(int[] control) {
        this.bControl = control;
    }

    public void escribirInstruccion(int[] instruccion) {
        this.bInstruccion = instruccion;
    }

    public int[] leerDatos() {
        return bDatos;
    }

    public int[] leerControl() {
        return bControl;
    }

    public int[] leerInstruccion() {
        return bInstruccion;
    }

    public void clear() {
        this.bDatos = new int[6];
        this.bControl = new int[4];
        this.bInstruccion = new int[16];
    }

    public int[] getbDatos() { return bDatos; }
    public void setbDatos(int[] bDatos) { this.bDatos = bDatos; }
    public int[] getbControl() { return bControl; }
    public void setbControl(int[] bControl) { this.bControl = bControl; }
    public int[] getbIntruccion() { return bInstruccion; }
    public void setbIntruccion(int[] bInstruccion) { this.bInstruccion = bInstruccion; }

    public String datosToString() { return binToString(bDatos); }
    public String controlToString() { return binToString(bControl); }
    public String instruccionToString() { return binToString(bInstruccion); }

    private String binToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int b : arr) sb.append(b);
        return sb.toString();
    }
}
