import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.Map;

public class Moneda {

    private String divisa;
    private Map <String, Double> tasaDeConversion;


//Constructor de la clase
        public Moneda(String divisa,  String resultado) {
        this.divisa = divisa;
        this.tasaDeConversion = tasaDeConversion;

    }
//Constructor de la clase MonedaOmdb que se ha estanciado en la clase ConsultaMoneda.
        public Moneda(MonedaOmdb monedaOmdb) {
        this.divisa = monedaOmdb.base_code();
        this.tasaDeConversion = monedaOmdb.conversion_rates();

    }


    public String getDivisa() {
        return divisa;
    }

    public void setDivisa(String divisa) {
        this.divisa = divisa;
    }

    public Map<String, Double> getTasaDeConversion() {
        return tasaDeConversion;
    }

    public void setTasaDeConversion(Map<String, Double> tasaDeConversion) {
        this.tasaDeConversion = tasaDeConversion;
    }

    @Override
    public String toString() {
        return "Moneda{" +
                "divisa='" + divisa + '\'' +
                ", tasaDeConversion=" + tasaDeConversion +
                '}';
    }
}

