package com.example.viniciusvianna.smavc_paciente;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.viniciusvianna.smavc_paciente.modelo.Usuario;
import com.example.viniciusvianna.smavc_paciente.util.Seguranca;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static com.example.viniciusvianna.smavc_paciente.util.Seguranca.*;

public class TelaCadastro extends AppCompatActivity {

    private EditText etNome;
    private EditText etIdade;
    private Spinner spSexo;
    private Spinner spUser;
    private EditText etLogin;
    private EditText etSenha;
    private Button btnCad;

    public Usuario u;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);


        etNome = (EditText) findViewById(R.id.et_tc_nome);
        etIdade = (EditText) findViewById(R.id.et_tc_idade);
        spSexo = (Spinner) findViewById(R.id.sp_tc_sexo);
        spUser = (Spinner) findViewById(R.id.sp_tc_user);
        etLogin = (EditText) findViewById(R.id.et_tc_login);
        etSenha = (EditText) findViewById(R.id.et_tc_senha);
        btnCad = (Button) findViewById(R.id.btn_tc_cad);

        btnCad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                u = new Usuario();

                u.setNome(etNome.getText().toString());
                u.setIdade(Integer.parseInt(etIdade.getText().toString()));
                u.setSexo(spSexo.getSelectedItem().toString());
                u.setUser(spUser.getSelectedItem().toString());
                u.setLogin(etLogin.getText().toString());
                u.setSenha(criptografar(etSenha.getText().toString()));

                if (spUser.getSelectedItem().toString().equals("Operador")) {
                    //        Escreve uma mensagem no baco da dados
                    FirebaseApp.initializeApp(TelaCadastro.this);
                    FirebaseDatabase db = FirebaseDatabase.getInstance();
                    final DatabaseReference banco = db.getReference("User").child("OPERDOR");

                    AlertDialog.Builder msg = new AlertDialog.Builder(TelaCadastro.this);
                    msg.setTitle(R.string.cadastro);
                    msg.setMessage(u.toString());
                    msg.setIcon(R.drawable.ic_cruz);
                    msg.setNeutralButton(R.string.btnOk, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
//                        envia para o banco
                            banco.push().setValue(u);
                            Toast.makeText(TelaCadastro.this, R.string.operador_cadast, Toast.LENGTH_LONG).show();

                            Intent it = new Intent(TelaCadastro.this, TelaPricipal.class);
                            startActivity(it);
                            finish();
                        }
                    });
                    msg.show();
                }else if(spUser.getSelectedItem().toString().equals("Paciente")){
                    //        Escreve uma mensagem no baco da dados
                    FirebaseApp.initializeApp(TelaCadastro.this);
                    FirebaseDatabase db = FirebaseDatabase.getInstance();
                    final DatabaseReference banco = db.getReference("User").child("PACIENTE");

                    AlertDialog.Builder msg = new AlertDialog.Builder(TelaCadastro.this);
                    msg.setTitle(R.string.cadastro);
                    msg.setMessage(u.toString());
                    msg.setIcon(R.drawable.ic_cruz);
                    msg.setNeutralButton(R.string.btnOk, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
//                        envia para o banco
                            banco.push().setValue(u);
                            Toast.makeText(TelaCadastro.this, R.string.usuario_cadastrado, Toast.LENGTH_LONG).show();

                            Intent it = new Intent(TelaCadastro.this,  TelaPricipal.class);
                            startActivity(it);
                            finish();
                        }
                    });
                    msg.show();

                }else if(spUser.getSelectedItem().toString().equals("Cuidador")){
                    //        Escreve uma mensagem no baco da dados
                    FirebaseApp.initializeApp(TelaCadastro.this);
                    FirebaseDatabase db = FirebaseDatabase.getInstance();
                    final DatabaseReference banco = db.getReference("User").child("CUIDADOR");

                    AlertDialog.Builder msg = new AlertDialog.Builder(TelaCadastro.this);
                    msg.setTitle(R.string.cadastro);
                    msg.setMessage(u.toString());
                    msg.setIcon(R.drawable.ic_cruz);
                    msg.setNeutralButton(R.string.btnOk, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
//                        envia para o banco
                            banco.push().setValue(u);
                            Toast.makeText(TelaCadastro.this, R.string.cadastrad_cuidador, Toast.LENGTH_LONG).show();

                            Intent it = new Intent(TelaCadastro.this,  TelaPricipal.class);
                            startActivity(it);
                            finish();
                        }
                    });
                    msg.show();

                }else{
                    AlertDialog.Builder msg = new AlertDialog.Builder(TelaCadastro.this);
                    msg.setTitle(R.string.erro);
                    msg.setMessage(R.string.msg_erro);
                    msg.setIcon(R.drawable.ic_excla);
                    msg.setNegativeButton(R.string.btnOk,null);
                    msg.show();
                }
            }
        });

    }//fecha onCreate
}//fecha classe
