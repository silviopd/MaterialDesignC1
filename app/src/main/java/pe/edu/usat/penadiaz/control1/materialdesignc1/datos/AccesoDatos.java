package pe.edu.usat.penadiaz.control1.materialdesignc1.datos;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by USER on 04/10/2016.
 */

public class AccesoDatos extends SQLiteOpenHelper {

    private static String nombreBD="bdUsuario";
    private static int versionBD=1;

    public static Context aplicacion;


    private static String tablaUsuario="create table usuario(codigo integer,nombre varchar(100),contrasena varchar(10), PRIMARY KEY (codigo))";
    private static String tablaUsuarioDatos[]= {
            "insert into usuario values(1,'admin','123')",
            "insert into usuario values(2,'silviopd','456')",
    };

    public AccesoDatos(){
        super(aplicacion,nombreBD,null,versionBD);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tablaUsuario);

        for (int i = 0; i < tablaUsuarioDatos.length; i++) {
            db.execSQL(tablaUsuarioDatos[i]);
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
