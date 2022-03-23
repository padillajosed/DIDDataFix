package diddatafixer;


import diddatafixer.ablbodbean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jpadilla
 */
public class ablbodfacade {
    public ArrayList getPersona() throws ClassNotFoundException, SQLException 
        {
            ArrayList lista =  new ArrayList();
            try {
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                Connection conexion = DriverManager.getConnection("jdbc:odbc:ExcelBD");
                Statement st = conexion.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
                ResultSet rs1 = st.executeQuery("select * from [ABLBOD$]");
                    while (rs1.next()){
                          int ID = rs1.getInt("ID");
                          String IDENTIFICACION = rs1.getString("IDENTIFICACION");
                          String NOMBRE = rs1.getString("NOMBRE");
                          String LOGIN = rs1.getString("LOGIN");
                          String ULTIMO_LOGIN = rs1.getString("ULTIMO_LOGIN");
                          String ESTATUS = rs1.getString("ESTATUS");
                          int IDIOMA_ID = rs1.getInt("IDIOMA_ID");
                          String FECHA_AFILIACION = rs1.getString("FECHA_AFILIACION");
                          String AZCRYPTOR_ID = rs1.getString("AZCRYPTOR_ID");
                          int PAIS_ID = rs1.getInt("PAIS_ID");
                          String TIPO_IDENTIFICACION = rs1.getString("TIPO_IDENTIFICACION");
                          String SHAREDKEY = rs1.getString("SHAREDKEY");
                          int BANCO_ID = rs1.getInt("BANCO_ID");
                          String FECHA_INI_SUSP = rs1.getString("FECHA_INI_SUSP");
                          String FECHA_FIN_SUSP = rs1.getString("FECHA_FIN_SUSP");
                          String CANALES_ID = rs1.getString("CANALES_ID");
                          String SESSIONEQUIPOFRECUENTE = rs1.getString("SESSIONEQUIPOFRECUENTE");
                          String PERFILDEF = rs1.getString("PERFILDEF");
                          String LLAVE = rs1.getString("LLAVE");
                          
                      ablbodbean a = new ablbodbean(ID,	IDENTIFICACION,	NOMBRE,	LOGIN, ULTIMO_LOGIN, ESTATUS, IDIOMA_ID, FECHA_AFILIACION, AZCRYPTOR_ID, PAIS_ID, TIPO_IDENTIFICACION, SHAREDKEY, BANCO_ID, FECHA_INI_SUSP, FECHA_FIN_SUSP, CANALES_ID,	SESSIONEQUIPOFRECUENTE,	PERFILDEF, LLAVE);
                      
                      lista.add(a);
                    } 
                    } catch (Exception e){
                        e.printStackTrace();
                    }
            return lista;
        }
}
