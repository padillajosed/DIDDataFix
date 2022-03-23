/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diddatafixer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
/**
 *
 * @author jpadilla
 */
public class DIDDataFixer {
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException  {
        todo();
    }
    
    
    public static void todo() throws ClassNotFoundException, SQLException  {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            java.sql.Date date = getCurrentDatetime();
            String Actualdate = dateFormat.format(date);
            final ablbodfacade datos = new ablbodfacade();
            final ArrayList<ablbodbean> listaAs400 = datos.getPersona();
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection conexion = DriverManager.getConnection("jdbc:odbc:ExcelBD");
            Statement st = conexion.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            if (listaAs400 != null && listaAs400.size() > 0) {
                for (final ablbodbean cliente : listaAs400) {
                    String shrd = "'"+cliente.getSHAREDKEY()+"'";
                    String Tide = cliente.getTIPO_IDENTIFICACION();
                    String nombre = cliente.getNOMBRE();
                    ResultSet rs2 = st.executeQuery("select CLI_ID_CLIENT from [CLIENT$] where CLI_SHARED_KEY ="+shrd+"");
                         if (rs2.next()){
                              String clid = rs2.getString(1);
                              String clid2 = clid.substring(0,clid.length()-2);
                              String cedula = cliente.getIDENTIFICACION();
                              
                                ResultSet rs3 = st.executeQuery("select * from [IBS$] where CEDULA = '"+cedula+"'");//Bloque verifica correo
                                if (rs3.next()){
                                          String mailibs = "'"+rs3.getString(3)+"'";
                                          genscript persona = new genscript( "--"+Tide+cedula+", "+nombre);
                                          ResultSet rs4 = st.executeQuery("select * from [OTBMAIL$] where CLI_ID_CLIENT ='"+clid+"'");
                                          if (rs4.next()){
                                              String maildid = "'"+rs4.getString(3)+"'";
                                                    //genscript persona = new genscript( "--"+Tide+cedula+", "+nombre);//escribo el nombre de la persona con formato
                                                    if(maildid.equals(mailibs)){
                                                      genscript UPDMail = new genscript("--El correo esta igual en IBS y DID (Borrar solo para control)");  
                                                    }else{
                                                        genscript UPDMail = new genscript("UPDATE DID_USER.OTBMAIL_CLIENT SET OTBMAIL_CLIENT_EMAIL = "+mailibs+""
                                                              + " WHERE CLI_ID_CLIENT \n" + "IN (SELECT CLI_ID_CLIENT FROM DID_USER.CLIENT WHERE "
                                                              + "CLI_SHARED_KEY = "+shrd+";");
                                                    }
                                                    } else{
                                                        genscript INSMail = new genscript("INSERT INTO DID_USER.OTBMAIL_CLIENT (OTBMAIL_CLIENT_ID, CLI_ID_CLIENT, "
                                                         + "OTBMAIL_CLIENT_EMAIL, OTBMAIL_CLIENT_LAST_MOD, OTBMAIL_CLIENT_IS_ACTIVE) \n" + "VALUES "
                                                         + "( DID_USER.SEQ_OTBMAIL_CLIENT.NEXTVAL, (SELECT CLI_ID_CLIENT FROM DID_USER.CLIENT WHERE "
                                                         + "DID_USER.CLIENT.CLI_SHARED_KEY= "+shrd+"), \n" + ""+mailibs+","
                                                         + " TO_DATE('"+Actualdate+"', 'YYYY-MM-DD HH24:MI:SS'), '1');");
                                                          }                                                 
                                            }else{
                                                genscript persona = new genscript( "--"+Tide+cedula+", "+nombre);
                                                genscript asd = new genscript("La cedula de ABLBOD no corresponde a IBS, favor revisar consulta");
                                            }
                                
                                ResultSet rs5 = st.executeQuery("select * from [IBS$] where CEDULA = '"+cedula+"'");//Bloque verifica correo
                                if (rs5.next()){
                                    String tlfibs = "'"+rs5.getString(2)+"'";
                                    String tlfibs1 = "'"+tlfibs.substring(0,tlfibs.length()-2)+"'";
                                          ResultSet rs6 = st.executeQuery("select * from [OTBSMS$] where CLI_ID_CLIENT ='"+clid+"'");
                                          if (rs6.next()){
                                              String tlfdid = "'"+rs6.getString(3)+"'";
                                                    //genscript persona = new genscript( "--"+Tide+cedula+", "+nombre);//escribo el nombre de la persona con formato
                                                    if(tlfdid.equals(tlfibs)){
                                                      genscript UPDTlf = new genscript("--El Telefono esta igual en IBS y DID (Borrar solo para control)");  
                                                    }else{
                                                        genscript UPDTlf = new genscript("UPDATE DID_USER.OTBSMS_CLIENT SET OTBSMS_CLIENT_PHONENUMBER"
                                                                + " = "+tlfibs+" WHERE CLI_ID_CLIENT \n" + "IN (SELECT CLI_ID_CLIENT FROM DID_USER.CLIENT"
                                                                + " WHERE CLI_SHARED_KEY = "+shrd+");");
                                                    }
                                                    } else{
                                                        genscript INSMail = new genscript("INSERT INTO DID_USER.OTBSMS_CLIENT (OTBSMS_CLIENT_ID, CLI_ID_CLIENT,"
                                                                + " OTBSMS_CLIENT_PHONENUMBER, OTBSMS_CLIENT_LAST_MOD, OTBSMS_CLIENT_IS_ACTIVE) \n" + "VALUES "
                                                                + "( DID_USER.SEQ_OTBSMS_CLIENT.NEXTVAL, (SELECT CLI_ID_CLIENT FROM DID_USER.CLIENT WHERE "
                                                                + "DID_USER.CLIENT.CLI_SHARED_KEY= "+shrd+"), \n" + ""+tlfibs+", TO_DATE"
                                                                + "('"+Actualdate+"', 'YYYY-MM-DD HH24:MI:SS'), '1');");
                                                          }                                                 
                                            }else{
                                                genscript persona = new genscript( "--"+Tide+cedula+", "+nombre);
                                                genscript asd = new genscript("La cedula de ABLBOD no corresponde a IBS, favor revisar consulta");
                                            }
                         }else{
                           System.out.println("Cliente no esta en DID");
                         }
            }
        }
                        
                          
                                }
    
    public static java.sql.Date getCurrentDatetime() {
    java.util.Date today = new java.util.Date();
    return new java.sql.Date(today.getTime());
}
                    
}