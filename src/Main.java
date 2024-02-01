import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

//        Backup backup = new Backup(".");
//        backup.make();
        int[] arr = new int[]{0, 1, 0, 3, 0, 3, 0, 2, 0};
        byte[] packed = ArrayPacker.pack(arr);
        System.out.println(Arrays.toString(packed));
        int[] unpacked = ArrayPacker.unpack(packed);
        System.out.println(Arrays.toString(unpacked));
    }

}