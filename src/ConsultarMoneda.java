import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarMoneda {

    public String consultarDivisas(String moneda){

        URI codigoDemoneda = URI.create("https://v6.exchangerate-api.com/v6/adf142384ed67c11a768695c/latest/"+moneda);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(codigoDemoneda)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();

            return json;

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Monedas convertir(String monedaBase, String monedaACambiar, double cantidad){

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/adf142384ed67c11a768695c/pair/"+monedaBase+"/"+
                monedaACambiar+"/"+cantidad);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Monedas.class);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void imprimirTasasDeCambio(JsonElement jsonElement){
        if (jsonElement.isJsonObject()){
            JsonObject jsonObj = jsonElement.getAsJsonObject();

            String resultado = jsonObj.get("result").getAsString();
            String divisa = jsonObj.get("base_code").getAsString();

            JsonObject tasasDeConversion = jsonObj.getAsJsonObject("conversion_rates");
            double dolar = tasasDeConversion.get("USD").getAsDouble();
            double pesoArgentino = tasasDeConversion.get("ARS").getAsDouble();
            double boliviano = tasasDeConversion.get("BOB").getAsDouble();
            double real = tasasDeConversion.get("BRL").getAsDouble();
            double pesoChileno = tasasDeConversion.get("CLP").getAsDouble();
            double pesoColombiano = tasasDeConversion.get("COP").getAsDouble();

            System.out.println("dolar: " + dolar);
            System.out.println("Peso argentino: " + pesoArgentino);
            System.out.println("Peso boliviano: " + boliviano);
            System.out.println("Real brasileño: " + real);
            System.out.println("Peso Chileno: " + pesoChileno);
            System.out.println("Peso Colombiano: " + pesoColombiano);

            // Ejemplo de como se utilizaría este método:

            //ConsultarMoneda consultarTodasLasDivisas = new ConsultarMoneda();
            //System.out.println("Indique el código de la moneda de la que le gustaría tener todas las tasas de cambio: ");
            //String moneda = lectura.nextLine();
            //JsonElement root = jp.parse(String.valueOf(consultarTodasLasDivisas.consultarDivisas(moneda)));
            //consultarTodasLasDivisas.imprimirTasasDeCambio(root);
        }
    }

}
