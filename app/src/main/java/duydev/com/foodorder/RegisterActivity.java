package duydev.com.foodorder;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnRegister;
    private EditText edtEmailReg;
    private EditText edtPassReg;
    private EditText edtPassConReg;
    private DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnRegister = (Button) findViewById(R.id.btnRegister);
        edtEmailReg = (EditText) findViewById(R.id.edtEmailReg);
        edtPassConReg = (EditText) findViewById(R.id.edtPassConReg);
        edtPassReg = (EditText) findViewById(R.id.edtPassReg);
        dbHelper = new DBHelper(this,1);
        btnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == btnRegister){
            String email = edtEmailReg.getText().toString();
            String pass = edtPassReg.getText().toString();
            String passConfirm = edtPassConReg.getText().toString();

            if(!email.equals("") && !pass.equals("") && !passConfirm.equals("")){
                String regex = "^[a-zA-Z0-9]+@[a-z]+(\\.[a-z]+)(\\.[a-z]{2,})*";
                boolean match = email.matches(regex);
                if(match) {
                    if (pass.equals(passConfirm)) {

                        //get email
                        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
                        String sql = "SELECT * FROM USER";
                        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);
                        boolean exists = false;
                        if (cursor.moveToFirst()) {
                            do {
                                String emailDb = cursor.getString(1);
                                if (email.equals(emailDb)) {
                                    exists = true;
                                    break;
                                }
                            } while (cursor.moveToNext());
                        }
                        if (!exists) {
                            SQLiteDatabase sqLiteDatabase1 = dbHelper.getWritableDatabase();
                            ContentValues content = new ContentValues();
                            content.put("USER_EMAIL", email);
                            content.put("USER_PASS", pass);
                            long success = sqLiteDatabase.insert("USER", null, content);
                            sqLiteDatabase1.close();
                            edtEmailReg.setText("");
                            edtPassReg.setText("");
                            edtPassConReg.setText("");
                            if (success == -1)
                                Toast.makeText(this, "fail", Toast.LENGTH_SHORT).show();
                            else
                                Toast.makeText(this, "success", Toast.LENGTH_SHORT).show();
                        } else
                            Toast.makeText(this, "Email exist please choose difference email", Toast.LENGTH_LONG).show();
                    } else
                        Toast.makeText(this, "Password must like password confirm", Toast.LENGTH_SHORT).show();
                }else
                    Toast.makeText(this, "Email must like format", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Email or password must not empty", Toast.LENGTH_SHORT).show();
            }
        }
    }
}