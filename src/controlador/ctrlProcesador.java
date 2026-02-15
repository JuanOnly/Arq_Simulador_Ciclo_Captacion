package controlador;

import modelo.Procesador;
import modelo.Bus;
import modelo.Memoria;

public class ctrlProcesador {
    private Procesador procesador;
    private Bus bus;
    private Memoria memoria;

    public ctrlProcesador() {
        this.procesador = new Procesador();
        this.bus = new Bus();
        this.memoria = new Memoria();
    }

    public void cicloFetch(String instruccion) {
        bus.escribirInstruccion(stringToBin(instruccion, 16));
        procesador.fetch(instruccion);
    }

    public void cicloEjecucion() {
        procesador.ejecutar();
    }

    public String getRegistrosDisplay() {
        StringBuilder sb = new StringBuilder();
        sb.append("MAR: ").append(procesador.binToString(procesador.getMAR())).append("\n");
        sb.append("MBR: ").append(procesador.binToString(procesador.getMBR())).append("\n");
        sb.append("PC: ").append(procesador.binToString(procesador.getPC())).append("\n");
        sb.append("IR: ").append(procesador.binToString(procesador.getIR())).append("\n");
        sb.append("AC: ").append(procesador.binToString(procesador.getAC())).append("\n");
        sb.append("UC: ").append(procesador.getUC()).append("\n");
        return sb.toString();
    }

    public String getBusDisplay() {
        StringBuilder sb = new StringBuilder();
        sb.append("Datos: ").append(bus.datosToString()).append("\n");
        sb.append("Control: ").append(bus.controlToString()).append("\n");
        sb.append("Instruccion: ").append(bus.instruccionToString()).append("\n");
        return sb.toString();
    }

    public void clear() {
        bus.clear();
        procesador = new Procesador();
    }

    public Procesador getProcesador() { return procesador; }
    public Bus getBus() { return bus; }
    public Memoria getMemoria() { return memoria; }

    private int[] stringToBin(String s, int bits) {
        int[] bin = new int[bits];
        for (int i = 0; i < Math.min(s.length(), bits); i++) {
            bin[i] = Character.getNumericValue(s.charAt(i));
        }
        return bin;
    }
}
