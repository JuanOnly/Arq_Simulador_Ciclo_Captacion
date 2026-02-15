package controlador;

import modelo.Bus;

public class ctrlBus {
    private Bus bus;

    public ctrlBus() {
        this.bus = new Bus();
    }

    public void escribirDatos(String datos) {
        bus.escribirDatos(stringToBin(datos));
    }

    public void escribirControl(String control) {
        bus.escribirControl(stringToBin(control));
    }

    public void escribirInstruccion(String instruccion) {
        bus.escribirInstruccion(stringToBin(instruccion));
    }

    public String leerDatos() {
        return bus.datosToString();
    }

    public String leerControl() {
        return bus.controlToString();
    }

    public String leerInstruccion() {
        return bus.instruccionToString();
    }

    public void clear() {
        bus.clear();
    }

    public Bus getBus() {
        return bus;
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
