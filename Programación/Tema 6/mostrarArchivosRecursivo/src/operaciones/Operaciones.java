package operaciones;

import java.io.File;
import java.util.Arrays;

public class Operaciones {

    public void  leerFichero(String path, String tabulacion){
        File file = new File(path);
        System.out.println(tabulacion + file.getName());
        if (file.isDirectory()) {
            Arrays.stream(file.listFiles()).forEach((item) -> leerFichero(item.getPath(), tabulacion + "\t"));
        }
    }

}
