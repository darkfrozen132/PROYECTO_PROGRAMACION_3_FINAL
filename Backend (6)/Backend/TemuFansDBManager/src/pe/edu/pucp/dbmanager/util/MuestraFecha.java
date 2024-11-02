package pe.edu.pucp.dbmanager.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MuestraFecha {

    public static String toString(Date date) {
        String fecha = "NULL";
        if (date != null) {
            SimpleDateFormat formateador = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            fecha = formateador.format(date);
        }
        return fecha;
    }
}
