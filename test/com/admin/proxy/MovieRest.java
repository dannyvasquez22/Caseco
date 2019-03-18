package com.admin.proxy;

import static org.junit.Assert.*;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
//import jdk.nashorn.internal.parser.JSONParser;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

/** * @author DANNY  */
public class MovieRest {
    
//    http://unirest.io/java.html
    
//    https://developers.themoviedb.org/4/list/get-list
    
//    @Test
    public void testRestx() throws UnirestException {
        HttpResponse<JsonNode> jsonResponse = Unirest.get("https://api.themoviedb.org/4/list/1?api_key=03e3a52650b1eda66fda262d0887c3c8&page=1")
            .header("authorization", "Bearer <<access_token>>")
            .asJson();
        
        Unirest.setTimeouts(10, 10);
        
        assertEquals(200, jsonResponse.getStatus());
        System.out.println("----------------------------");
        System.out.println(jsonResponse.getStatus());
        System.out.println(jsonResponse.getStatusText());
        System.out.println(jsonResponse.getHeaders());
//        System.out.println(jsonResponse.getBody());
        
        JSONObject jo = new JSONObject(jsonResponse);
        
        // .toString(4) => le da formato de identacion al tabulador de 4

        System.out.println(new JSONObject(jsonResponse.getBody().toString()).toString(4)); // todo el BODY
        System.out.println("*******************************************");
        System.out.println(new JSONObject(jsonResponse.getBody().toString()).getJSONObject("object_ids").toString(4));
        System.out.println("*******************************************");
        System.out.println(new JSONObject(jsonResponse.getBody().toString()).getInt("total_results"));
        System.out.println("*******************************************");
        System.out.println(new JSONObject(jsonResponse.getBody().toString()).getInt("page"));
        System.out.println("*******************************************");
        System.out.println(new JSONObject(jsonResponse.getBody().toString()).getInt("total_pages"));
        System.out.println("*******************************************");
        System.out.println(new JSONObject(jsonResponse.getBody().toString()).getString("name"));
        System.out.println("*******************************************");
        System.out.println(new JSONObject(jsonResponse.getBody().toString()).getString("sort_by"));
        System.out.println("*******************************************");
        System.out.println(new JSONObject(jsonResponse.getBody().toString()).getString("description"));
        System.out.println("*******************************************");
        System.out.println(new JSONObject(jsonResponse.getBody().toString()).getString("backdrop_path"));
        System.out.println("*******************************************");
        System.out.println(new JSONObject(jsonResponse.getBody().toString()).getDouble("average_rating"));
        System.out.println("*******************************************");
        System.out.println(new JSONObject(jsonResponse.getBody().toString()).getString("poster_path"));
        System.out.println("*******************************************");
        System.out.println(new JSONObject(jsonResponse.getBody().toString()).getJSONObject("comments").toString(4));
        System.out.println("*******************************************");
        System.out.println(new JSONObject(jsonResponse.getBody().toString()).getJSONObject("created_by").toString(4));
        System.out.println("*******************************************");
        System.out.println(new JSONObject(jsonResponse.getBody().toString()).getJSONArray("results").toString(4));
    }    
    
    @Test
    public void tstGh() throws UnirestException {
        HttpResponse<JsonNode> jsonResponseGh = Unirest.get("https://api.github.com/users/dannyvasquez22/repos")
            .asJson();
        
        JSONArray jarr = new JSONArray(jsonResponseGh.getBody().toString());
        
        jarr.forEach(x -> {
            JSONObject elem = new JSONObject(x.toString());
            System.out.println(elem.getString("full_name"));//Nombre de repos
//            System.out.println(elem.toString(4));
        });
    }
    
//    @Test
    public void testito() {
        try {
            HttpResponse<String> jsonResponse = Unirest.get("https://api.themoviedb.org/3/find/%7Bexternal_id%7D?external_source=imdb_id&language=en-US&api_key=03e3a52650b1eda66fda262d0887c3c8")
                .asString();
            System.out.println("================================");
            System.out.println(jsonResponse.getStatus());
            System.out.println(jsonResponse.getStatusText());
            System.out.println(jsonResponse.getHeaders());
            System.out.println(jsonResponse.getBody());
                        
            HttpResponse<String> response = Unirest.delete("https://api.themoviedb.org/3/authentication/session?api_key=03e3a52650b1eda66fda262d0887c3c8")
                .header("content-type", "application/json")
                .body("{\"session_id\":\"2629f70fb498edc263a0adb99118ac41f0053e8c\"}")
                .asString();
            
            HttpResponse<String> response1 = Unirest.post("https://api.themoviedb.org/3/authentication/session/new?api_key=03e3a52650b1eda66fda262d0887c3c8")
                .header("content-type", "application/json")
                .body("{\"request_token\":\"6bc047b88f669d1fb86574f06381005d93d3517a\"}")
                .asString();
        } catch (UnirestException ex) {
            Logger.getLogger(MovieRest.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }   
    
//    @Test
    public void testRest() {     
        try {
            OkHttpClient client = new OkHttpClient();
            
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, "{}");
            Request request = new Request.Builder()
                    .url("https://api.themoviedb.org/4/list/1?api_key=03e3a52650b1eda66fda262d0887c3c8&page=1")
                    .get()
                    .addHeader("content-type", "application/json;charset=utf-8")
                    .addHeader("authorization", "Bearer <<access_token>>")
                    .build();
            
            Response response = client.newCall(request).execute();
            
//            assertEquals(200, response);
            System.out.println(response.toString());
        } catch (IOException ex) {
            Logger.getLogger(MovieRest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}