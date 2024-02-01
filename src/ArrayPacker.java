import java.lang.reflect.Array;

public class ArrayPacker {

    public static byte[] pack(int[] arr) {
        byte[] out = new byte[arr.length % 3 == 0 ? arr.length / 3 : arr.length / 3 + 1];
        for (int i = 0; i < arr.length; i++) {
            out[i/3] += arr[i] << 2 * (i % 3);
        }
        return out;
    }

    public static int[] unpack(byte[] arr) {
        int[] out = new int[3 * arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 3; j++) {
                out[3 * i + j] = (arr[i] & (3 << 2 * j)) >> 2 * j;
            }
        }
        return out;
    }
}
