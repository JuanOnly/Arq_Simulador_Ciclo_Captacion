package modelo;

public class Memoria {
    private int[][] discoDuro;
    private int[][] RAM;
    private int[][] registros;

    public Memoria() {
        this.discoDuro = new int[6][32];
        this.RAM = new int[6][16];
        this.registros = new int[6][5];
    }

    public int[] leer(int direccion, String tipo) {
        if ("RAM".equals(tipo)) {
            if (direccion >= 0 && direccion < RAM[0].length) {
                return RAM[direccion];
            }
        } else if ("disco".equals(tipo)) {
            if (direccion >= 0 && direccion < discoDuro[0].length) {
                return discoDuro[direccion];
            }
        }
        return new int[6];
    }

    public void escribir(int direccion, int[] datos, String tipo) {
        if ("RAM".equals(tipo)) {
            if (direccion >= 0 && direccion < RAM[0].length) {
                RAM[direccion] = datos;
            }
        } else if ("disco".equals(tipo)) {
            if (direccion >= 0 && direccion < discoDuro[0].length) {
                discoDuro[direccion] = datos;
            }
        }
    }

    public void cargarEnRAM(int dirDisco, int dirRAM) {
        if (dirDisco >= 0 && dirDisco < discoDuro[0].length 
            && dirRAM >= 0 && dirRAM < RAM[0].length) {
            RAM[dirRAM] = discoDuro[dirDisco];
        }
    }

    public String getRAMContents() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < RAM[0].length; i++) {
            sb.append("[").append(String.format("%2s", Integer.toBinaryString(i)).replace(' ', '0'))
              .append("]: ");
            for (int j = 0; j < RAM.length; j++) {
                sb.append(RAM[j][i]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public int[][] getDiscoDuro() { return discoDuro; }
    public void setDiscoDuro(int[][] discoDuro) { this.discoDuro = discoDuro; }
    public int[][] getRAM() { return RAM; }
    public void setRAM(int[][] RAM) { this.RAM = RAM; }
    public int[][] getRegistros() { return registros; }
    public void setRegistros(int[][] registros) { this.registros = registros; }
}
