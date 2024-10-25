package com.desarollador.ConversorDivisas;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaDivisa {
    public Divisa buscaDivisa(String tipoDivisa1, String tipoDivisa2){
        URI direccion = URI.create
                ("https://v6.exchangerate-api.com/v6/9141053bae016e4be7abb874/pair/"+tipoDivisa1+"/"+tipoDivisa2);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try{
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Divisa.class);
        } catch (Exception e) {
            throw new RuntimeException("Error al seleccionar la divisa");
        }
    }
}
