import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.Scanner;

public class ConsultaMoneda {
    public static void main(String[] args) throws IOException, InterruptedException  {

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/0438168d170909662d90f4cb/latest/USD"); //Podemos agregar + divisa
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request =  HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();
        Gson gson = new Gson(); // GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
        MonedaOmdb monedaOmdb = gson.fromJson(json, MonedaOmdb.class);
        try {
            Moneda moneda = new Moneda(monedaOmdb);
            // System.out.println(moneda);

        } catch (Exception e) {
            System.out.println("Datos ingresados erroneos");
            System.out.println(e.getMessage());

        }
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("*************************************");
            System.out.println("Sea bienvenid@ al conversor de Moneda");
            System.out.println("1) Dólar =>> Peso Argentino ") ;
            System.out.println("2) Peso Argentino =>> Dolar");
            System.out.println("3) Dólar =>> Real Brasileño");
            System.out.println("4) Real brasileño =>> Dólar");
            System.out.println("5) Dólar =>> Peso Colombiano");
            System.out.println("6) Peso Colombiano =>> Dolar");
            System.out.println("7) Salir");
            System.out.println("*************************************");
            System.out.println("Elija una opción:");


            int opcion = scanner.nextInt();
            Map<String, Double> conversion_rates = monedaOmdb.conversion_rates();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el valor que desea transformar de Dólar a Peso Argentino");
                    int valorusd1 = scanner.nextInt(); // a la variable valor le asignamos el valor ingresado por teclado
                    Double conversionRate = conversion_rates.get("ARS");
                    double dolarAPesoArg = valorusd1 * conversionRate;
                    System.out.println("Los " + valorusd1 + " Dolares, equivalen a: " + dolarAPesoArg + " Pesos Argentinos");
                    break;
                case 2:
                    System.out.println("Ingrese el valor que desea transformar de Peso Argentino a Dolar");
                    int valorars = scanner.nextInt();
                    Double conversionRate2 = conversion_rates.get("ARS");
                    double arsAdolar = valorars / conversionRate2 ;
                    System.out.println("El valor de: " + valorars + " pesos argentinos es: " +  arsAdolar + " Dolares");
                    break;

                case 3:
                    System.out.println("Ingrese el valor que desea transformar de Dólar a Real Brasileño");
                    int valorusd2 = scanner.nextInt();
                    Double conversionRate3 = conversion_rates.get("BRL");
                    double dolarABr = valorusd2 * conversionRate3;
                    System.out.println("Los " + valorusd2 + " Dolares, equivalen a: " + dolarABr + " Reales Brasileños");
                    break;
                case 4:
                    System.out.println(" Ingrese el valor que desea transformar de Real Brasileño a Dólar");
                    int valor4 = scanner.nextInt();
                    Double conversionRate4 = conversion_rates.get("BRL");
                    double brlAdolar = valor4 / conversionRate4;
                    System.out.println("El valor de: " + valor4 + " Reales Brasileños es: " +  brlAdolar + " Dolares");
                    break;
                case 5:
                    System.out.println("Ingrese el valor que desea transformar de Dólar a Peso Colombiano");
                    int valor5 = scanner.nextInt();
                    Double conversionRate5 = conversion_rates.get("COP");
                    double dolarACop = valor5 * conversionRate5;
                    System.out.println("Los " + valor5 + " Dolares, equivalen a: " + dolarACop + " Pesos Colombianos");
                    break;
                case 6:
                    System.out.println("Ingrese el valor que desea transformar de Peso Colombiano  a Dólar");
                    int valor6 = scanner.nextInt();
                    Double conversionRate6 = conversion_rates.get("COP");
                    double copAdolar = valor6 / conversionRate6;
                    System.out.println("El valor de: " + valor6 + " Pesos Colombianos es: " +  copAdolar + " Dolares");
                    break;
                case 7:
                    System.out.println("¡Adiós!");
                    System.exit(0); // Sale del programa
                    break;

                default:
                    System.out.println("Opción inválida. Por favor, elija una opción válida.");
                    break;
            }
        }
    }
}




