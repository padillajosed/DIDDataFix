/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diddatafixer;

/**
 *
 * @author jpadilla
 */
public class ablbodbean {
    private int ID;
    private String IDENTIFICACION;
    private String NOMBRE;
    private String LOGIN;
    private String ULTIMO_LOGIN;
    private String ESTATUS;
    private int IDIOMA_ID;
    private String FECHA_AFILIACION;
    private String AZCRYPTOR_ID;
    private int PAIS_ID;
    private String TIPO_IDENTIFICACION;
    private String SHAREDKEY;
    private int BANCO_ID;
    private String FECHA_INI_SUSP;
    private String FECHA_FIN_SUSP;
    private String CANALES_ID;
    private String SESSIONEQUIPOFRECUENTE;
    private String PERFILDEF;
    private String LLAVE;

    public ablbodbean(int ID, String IDENTIFICACION, String NOMBRE, String LOGIN, String ULTIMO_LOGIN, String ESTATUS, int IDIOMA_ID, String FECHA_AFILIACION, String AZCRYPTOR_ID, int PAIS_ID, String TIPO_IDENTIFICACION, String SHAREDKEY, int BANCO_ID, String FECHA_INI_SUSP, String FECHA_FIN_SUSP, String CANALES_ID, String SESSIONEQUIPOFRECUENTE, String PERFILDEF, String LLAVE) {
        this.ID = ID;
        this.IDENTIFICACION = IDENTIFICACION;
        this.NOMBRE = NOMBRE;
        this.LOGIN = LOGIN;
        this.ULTIMO_LOGIN = ULTIMO_LOGIN;
        this.ESTATUS = ESTATUS;
        this.IDIOMA_ID = IDIOMA_ID;
        this.FECHA_AFILIACION = FECHA_AFILIACION;
        this.AZCRYPTOR_ID = AZCRYPTOR_ID;
        this.PAIS_ID = PAIS_ID;
        this.TIPO_IDENTIFICACION = TIPO_IDENTIFICACION;
        this.SHAREDKEY = SHAREDKEY;
        this.BANCO_ID = BANCO_ID;
        this.FECHA_INI_SUSP = FECHA_INI_SUSP;
        this.FECHA_FIN_SUSP = FECHA_FIN_SUSP;
        this.CANALES_ID = CANALES_ID;
        this.SESSIONEQUIPOFRECUENTE = SESSIONEQUIPOFRECUENTE;
        this.PERFILDEF = PERFILDEF;
        this.LLAVE = LLAVE;
    }

    public int getID() {
        return ID;
    }

    public String getIDENTIFICACION() {
        return IDENTIFICACION;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public String getLOGIN() {
        return LOGIN;
    }

    public String getULTIMO_LOGIN() {
        return ULTIMO_LOGIN;
    }

    public String getESTATUS() {
        return ESTATUS;
    }

    public int getIDIOMA_ID() {
        return IDIOMA_ID;
    }

    public String getFECHA_AFILIACION() {
        return FECHA_AFILIACION;
    }

    public String getAZCRYPTOR_ID() {
        return AZCRYPTOR_ID;
    }

    public int getPAIS_ID() {
        return PAIS_ID;
    }

    public String getTIPO_IDENTIFICACION() {
        return TIPO_IDENTIFICACION;
    }

    public String getSHAREDKEY() {
        return SHAREDKEY;
    }

    public int getBANCO_ID() {
        return BANCO_ID;
    }

    public String getFECHA_INI_SUSP() {
        return FECHA_INI_SUSP;
    }

    public String getFECHA_FIN_SUSP() {
        return FECHA_FIN_SUSP;
    }

    public String getCANALES_ID() {
        return CANALES_ID;
    }

    public String getSESSIONEQUIPOFRECUENTE() {
        return SESSIONEQUIPOFRECUENTE;
    }

    public String getPERFILDEF() {
        return PERFILDEF;
    }

    public String getLLAVE() {
        return LLAVE;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setIDENTIFICACION(String IDENTIFICACION) {
        this.IDENTIFICACION = IDENTIFICACION;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public void setLOGIN(String LOGIN) {
        this.LOGIN = LOGIN;
    }

    public void setULTIMO_LOGIN(String ULTIMO_LOGIN) {
        this.ULTIMO_LOGIN = ULTIMO_LOGIN;
    }

    public void setESTATUS(String ESTATUS) {
        this.ESTATUS = ESTATUS;
    }

    public void setIDIOMA_ID(int IDIOMA_ID) {
        this.IDIOMA_ID = IDIOMA_ID;
    }

    public void setFECHA_AFILIACION(String FECHA_AFILIACION) {
        this.FECHA_AFILIACION = FECHA_AFILIACION;
    }

    public void setAZCRYPTOR_ID(String AZCRYPTOR_ID) {
        this.AZCRYPTOR_ID = AZCRYPTOR_ID;
    }

    public void setPAIS_ID(int PAIS_ID) {
        this.PAIS_ID = PAIS_ID;
    }

    public void setTIPO_IDENTIFICACION(String TIPO_IDENTIFICACION) {
        this.TIPO_IDENTIFICACION = TIPO_IDENTIFICACION;
    }

    public void setSHAREDKEY(String SHAREDKEY) {
        this.SHAREDKEY = SHAREDKEY;
    }

    public void setBANCO_ID(int BANCO_ID) {
        this.BANCO_ID = BANCO_ID;
    }

    public void setFECHA_INI_SUSP(String FECHA_INI_SUSP) {
        this.FECHA_INI_SUSP = FECHA_INI_SUSP;
    }

    public void setFECHA_FIN_SUSP(String FECHA_FIN_SUSP) {
        this.FECHA_FIN_SUSP = FECHA_FIN_SUSP;
    }

    public void setCANALES_ID(String CANALES_ID) {
        this.CANALES_ID = CANALES_ID;
    }

    public void setSESSIONEQUIPOFRECUENTE(String SESSIONEQUIPOFRECUENTE) {
        this.SESSIONEQUIPOFRECUENTE = SESSIONEQUIPOFRECUENTE;
    }

    public void setPERFILDEF(String PERFILDEF) {
        this.PERFILDEF = PERFILDEF;
    }

    public void setLLAVE(String LLAVE) {
        this.LLAVE = LLAVE;
    }
 
}
