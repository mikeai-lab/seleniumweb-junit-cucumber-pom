package data;

import modelos.Credencial;

import java.util.Map;

public class DataGiver {
    private static Map<String, Credencial> obtenerMapCredenciales(){
        return JsonReader.obtenerMapCredenciales().getMapCredenciales();
    }
    public static Credencial getValidCredentials(){
        return obtenerMapCredenciales().get("valid");
    }
}
