package pe.edu.pucp.dbmanagertest.util;

import pe.edu.pucp.dbmanager.util.Cifrado;
public class CifradoTest {

    public static void main(String[] args) {
        //prueba del crifrado de la contraseña
//        String contraseña = "1INF33Melgar";
        String contraseña = "hzxz eqrx rriv oqpk";
        String contraseña_cifrada = Cifrado.cifrarMD5(contraseña);
        String contraseña_descifrada = Cifrado.descifrarMD5(contraseña_cifrada);
        System.out.println(contraseña);
        System.out.println(contraseña_cifrada);
        System.out.println(contraseña_descifrada);                         
    }

}
