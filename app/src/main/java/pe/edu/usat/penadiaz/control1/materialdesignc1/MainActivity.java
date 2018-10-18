package pe.edu.usat.penadiaz.control1.materialdesignc1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import pe.edu.usat.penadiaz.control1.materialdesignc1.datos.AccesoDatos;
import pe.edu.usat.penadiaz.control1.materialdesignc1.negocio.Usuario;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText txtUsuario,txtContrasena;
    Button btnIngresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUsuario = (EditText) findViewById(R.id.txtUsuario);
        txtContrasena = (EditText) findViewById(R.id.txtContrasena);
        btnIngresar = (Button) findViewById(R.id.btnIngresar);

        btnIngresar.setOnClickListener(this);

        AccesoDatos.aplicacion = this;


        txtUsuario.setText("");
        txtContrasena.setText("");
    }

    @Override
    public void onClick(View v) {
        Usuario u = new Usuario();
        //Toast.makeText(this,txtUsuario.getText().toString()+" "+txtContrasena.getText().toString(),Toast.LENGTH_LONG).show();
        if (u.validar(txtUsuario.getText().toString(),txtContrasena.getText().toString())){
            Toast.makeText(this,"Correcto",Toast.LENGTH_LONG).show();
            Intent pantalla2 = new Intent(this, Main2Activity.class);
            startActivity(pantalla2);
        }else{
            Toast.makeText(this,"Incorrecto",Toast.LENGTH_LONG).show();
            txtUsuario.setText("");
            txtContrasena.setText("");
        };
    }

    @Override
    protected void onResume() {
        super.onResume();

        txtUsuario.setText("");
        txtContrasena.setText("");
    }
}
