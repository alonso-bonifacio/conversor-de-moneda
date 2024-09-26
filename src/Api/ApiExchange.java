package Api;

import Model.Dto.GenericResponseDto;
import Model.Vo.ConversionVo;
import Shared.Constants.Api;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiExchange {

    public ConversionVo convert(String[] codes, double valueConvert){
        var codeBase = codes[0];
        var codeTarget = codes[1];
        var url = getUrl(codeBase, codeTarget, valueConvert);
        var client = HttpClient.newHttpClient();
        var httpRequest = HttpRequest.newBuilder().uri(URI.create(url)).build();
        try {
            var httpResponse = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            var json = httpResponse.body();
            var gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    .create();

            var response = gson.fromJson(json, GenericResponseDto.class);
            return new ConversionVo(response);
        } catch (Exception e) {
            return new ConversionVo();
        }
    }

    /* PRIVATE METHODS */

    private static String getUrl(String codeBase, String codeTarget, double valueConvert){
        return "%s/%s/%s/%s/%s/%s".formatted(Api.API_URL, Api.API_KEY, Api.API_OPERATION, codeBase, codeTarget, valueConvert);
    }

}
