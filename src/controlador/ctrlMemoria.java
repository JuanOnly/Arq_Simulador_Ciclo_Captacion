package controlador;

import modelo.Memoria;

public class ctrlMemoria {
    private Memoria memoria;

    public ctrlMemoria() {
        this.memoria = new Memoria();
    }

    public String leer(int direccion) {
        int[] datos = memoria.leer(direccion, "RAM");
        return binToString(datos);
    }

    public void escribir(int direccion, String datos) {
        memoria.escribir(direccion, stringToBin(datos), "RAM");
    }

    public void cargarDiscoARAM(int dirDisco, int dirRAM) {
        memoria.cargarEnRAM(dirDisco, dirRAM);
    }

    public String getMemoriaContents() {
        return memoria.getRAMContents();
    }

    public Memoria getMemoria() {
        return memoria;
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
