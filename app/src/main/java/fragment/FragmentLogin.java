package fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import duydev.com.foodorder.DBHelper;
import duydev.com.foodorder.DetailActivity;
import duydev.com.foodorder.R;
import duydev.com.foodorder.RegisterActivity;

/**
 * Created by duy dev on 10/16/2017.
 */

public class FragmentLogin extends Fragment implements View.OnClickListener,CompoundButton.OnCheckedChangeListener{

    private Button btnLogin;
    private CheckBox cbRememberAccount;
    private TextView tvRegister;
    private EditText edtEmail;
    private EditText edtPass;
    private DBHelper dbHelper;
    private Context context;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_login, container, false);
        btnLogin = (Button) view.findViewById(R.id.btnLogin);
        cbRememberAccount = (CheckBox) view.findViewById(R.id.cbRememberAccount);
        tvRegister = (TextView) view.findViewById(R.id.tvRegister);
        edtEmail = (EditText) view.findViewById(R.id.edtEmail);
        edtPass = (EditText) view.findViewById(R.id.edtPass);

        btnLogin.setOnClickListener(this);
        tvRegister.setOnClickListener(this);
        cbRememberAccount.setOnCheckedChangeListener(this);

        dbHelper = new DBHelper(context,1);
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        sqLiteDatabase.close();
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onClick(View view) {
        if(view == btnLogin){
            String email = edtEmail.getText().toString();
            String pass = edtPass.getText().toString();

            if(!email.equals("") && !pass.equals("")){
                //check database
                String sql = "SELECT * FROM USER";
                SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
                Cursor cursor = sqLiteDatabase.rawQuery(sql, null);
                boolean success = false;
                if(cursor.moveToFirst()){
                    do{
                        String emailDb = cursor.getString(1);
                        String passDb = cursor.getString(2);
                        if(email.equals(emailDb) && pass.equals(passDb)){
                            success = true;
                            break;
                        }
                    }while(cursor.moveToNext());
                }
                if(success) {
                    if(cbRememberAccount.isChecked()){
                        SharedPreferences sharedPreferences = context.getSharedPreferences("coco5", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("user", email + ":" + pass);
                        editor.commit();
                    }
                    Intent intent = new Intent(context, DetailActivity.class);
                    startActivity(intent);
                    getActivity().finish();
                }
                else {
                    edtPass.setText("");
                    Toast.makeText(context, "Login Fail", Toast.LENGTH_LONG).show();
                }
                sqLiteDatabase.close();
            }else
                Toast.makeText(context, "Email or password must not empty", Toast.LENGTH_LONG).show();
        }
        if(view == tvRegister){
            Intent intent = new Intent(context, RegisterActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

        if(b){
            String email = edtEmail.getText().toString();
            String pass = edtPass.getText().toString();
            if(email.equals("") && pass.equals("")){
                Toast.makeText(context, "Email or password must not empty", Toast.LENGTH_LONG).show();
            }
        }

    }
}
