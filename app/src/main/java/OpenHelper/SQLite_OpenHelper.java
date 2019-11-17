package OpenHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLite_OpenHelper extends SQLiteOpenHelper{
    public SQLite_OpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       String query="create table usuarios(_ID integer primary key autoincrement, Nombre text, Password text, Repepassword text, Email text);";
       db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    // metodo abrir base de datos

    public void abrir(){
        this.getWritableDatabase();
    }
    public void cerrar(){
        this.close();

    }

    //metodo insertar registros en la tabla usuarios
    public void insertar(String nom, String pas, String repas, String cor  ){
        ContentValues valores=new ContentValues();
        valores.put("Nombre",nom);
        valores.put("Password",pas);
        valores.put("Repepassword",repas);
        valores.put("Email",cor);
        this.getWritableDatabase().insert("usuarios",null,valores);
    }

// metodo validacion de usuario

    public Cursor consultarusuario(String usu, String pas) throws SQLException{
        Cursor mcursor=null;

        mcursor=this.getReadableDatabase().query("usuarios", new String[]{"_ID","Nombre","Password","Repepassword","Email"},"Email like'"+usu+"'and password like '"+pas+"'",null,null,null,null);

        return mcursor;
    }

}
