import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class ClienteParaSolicitudes {

    public TiposDeCambio tiposDeCambio() {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/6e96f732f4112e9ac8008af8/latest/USD");


        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return  new Gson().fromJson(response.body(), TiposDeCambio.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
