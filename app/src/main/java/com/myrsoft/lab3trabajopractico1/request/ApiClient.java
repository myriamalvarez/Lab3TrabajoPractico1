package com.myrsoft.lab3trabajopractico1.request;

import android.content.Context;
import android.content.SharedPreferences;

import com.myrsoft.lab3trabajopractico1.modelo.Usuario;

public class ApiClient {
    private static SharedPreferences shared;
    private static SharedPreferences conectar(Context context){
        if (shared == null){
            shared = context.getSharedPreferences("datos.xml", 0);
        }
        return shared;
    }
    public static void guardar(Context context, Usuario user){
        SharedPreferences shared = conectar(context);
        SharedPreferences.Editor editor = shared.edit();
        editor.putLong("dni", user.getDni());
        editor.putString("apellido", user.getApellido());
        editor.putString("nombre", user.getNombre());
        editor.putString("mail", user.getMail());
        editor.putString("password", user.getPassword());
        editor.commit();
    }
    public static Usuario leer(Context context){
        SharedPreferences shared = conectar(context);
        Long dni = shared.getLong("dni", -1);
        String apellido = shared.getString("apellido", "null");
        String nombre = shared.getString("nombre", "null");
        String mail = shared.getString("mail", "null");
        String password = shared.getString("password", "null");
        Usuario user = new Usuario(dni, apellido, nombre, mail, password);
        return user;
    }
    public static Usuario login(Context context, String mail, String password){
        Usuario user = null;
        SharedPreferences shared = conectar(context);
        Long dni = shared.getLong("dni", -1);
        String apellido = shared.getString("apellido", "null");
        String nombre = shared.getString("nombre", "null");
        String email = shared.getString("mail", "null");
        String pass = shared.getString("password", "null");
        if (email.equals(mail) && pass.equals(password)) {
            user = new Usuario(dni, apellido, nombre, email, pass);
        }
        return user;
    }
}
