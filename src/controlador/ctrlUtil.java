package controlador;

public class ctrlUtil {

    public static boolean validarEntrada(String dir) {
        if (dir == null || dir.isEmpty()) {
            return false;
        }
        if (dir.length() != 16) {
            return false;
        }
        return dir.matches("[01]+");
    }

    public static int[] stringToArray(String str) {
        int[] arr = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = Character.getNumericValue(str.charAt(i));
        }
        return arr;
    }

    public static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int b : arr) sb.append(b);
        return sb.toString();
    }

    public static String formatearBinario(String bin, int bits) {
        return String.format("%" + bits + "s", bin).replace(' ', '0');
    }

    public static int binToInt(String bin) {
        return Integer.parseInt(bin, 2);
    }

    public static String intToBin(int val, int bits) {
        return String.format("%" + bits + "s", Integer.toBinaryString(val)).replace(' ', '0');
    }
}
