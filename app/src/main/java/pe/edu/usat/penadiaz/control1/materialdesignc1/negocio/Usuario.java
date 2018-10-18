package pe.edu.usat.penadiaz.control1.materialdesignc1.negocio;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.Editable;

import pe.edu.usat.penadiaz.control1.materialdesignc1.datos.AccesoDatos;

/**
 * Created by USER on 04/10/2016.
 */

public class Usuario extends AccesoDatos {

    private String nombre;
    private String contrasena;

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean validar(String usuario, String contrasena){
        SQLiteDatabase db = this.getReadableDatabase();
        String sql ="select * from usuario where nombre like '"+usuario+"' and contrasena like '"+contrasena+"'";
        Cursor resultado = db.rawQuery(sql, null);
        if (resultado.moveToNext()){
            return true;
        };
        return false;
    }
}
