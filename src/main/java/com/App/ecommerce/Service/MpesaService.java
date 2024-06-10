
package com.App.ecommerce.Service;

import okhttp3.*;
import org.springframework.stereotype.Service;

import com.App.ecommerce.Repository.PaymentRepo;
import com.App.ecommerce.models.Payment;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

@Service
public class MpesaService {

    private final OkHttpClient client = new OkHttpClient().newBuilder().build();

    // Method to generate the password
    private String generatePassword(String shortCode, String passkey, String timestamp) {
        String dataToEncode = shortCode + passkey + timestamp;
        return Base64.getEncoder().encodeToString(dataToEncode.getBytes());
    }

    // Method to get the access token
    private String getAccessToken() throws IOException {
        String consumerKey = "w2ABSyiW0KFRn8ZxODClm2AALpO15jO4uhZ0jFmtGtyWPAFQ";
        String consumerSecret = "aBSGz6o2w2Sgjn5kY7tieUONCPQAEq4YBuPOCaoDp0wW6XgGNsHsvG6TFjJmj9Zm";
        String auth = Credentials.basic(consumerKey, consumerSecret);

        Request request = new Request.Builder()
            .url("https://sandbox.safaricom.co.ke/oauth/v1/generate?grant_type=client_credentials")
            .get()
            .addHeader("Authorization", auth)
            .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                String responseBody = response.body().string();
                JsonObject jsonObject = JsonParser.parseString(responseBody).getAsJsonObject();
                return jsonObject.get("access_token").getAsString();
            } else {
                throw new IOException("Failed to fetch access token");
            }
        }
    }

    public String performStkPush(Long phoneNumber, String username, double amount) throws IOException {
        String shortCode = "174379";
        String passkey = "bfb279f9aa9bdbcf158e97dd71a467cd2e0c893059b10f78e6b72ada1ed2c919";
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String password = generatePassword(shortCode, passkey, timestamp);
        String accessToken = getAccessToken();

        MediaType mediaType = MediaType.parse("application/json");
        String json = "{"
            + "\"BusinessShortCode\": " + shortCode + ","
            + "\"Password\": \"" + password + "\","
            + "\"Timestamp\": \"" + timestamp + "\","
            + "\"TransactionType\": \"CustomerPayBillOnline\","
            + "\"Amount\": " + amount + ","
            + "\"PartyA\": " + phoneNumber + ","
            + "\"PartyB\": " + shortCode + ","
            + "\"PhoneNumber\": " + phoneNumber + ","
            + "\"CallBackURL\": \"https://35dc-102-215-32-244.ngrok-free.app\","
            + "\"AccountReference\": \"" + username + "\","
            + "\"TransactionDesc\": \"Payment of product\""
            + "}";

        RequestBody body = RequestBody.create(mediaType, json);
        Request request = new Request.Builder()
            .url("https://sandbox.safaricom.co.ke/mpesa/stkpush/v1/processrequest")
            .method("POST", body)
            .addHeader("Content-Type", "application/json")
            .addHeader("Authorization", "Bearer " + accessToken)
            .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public final PaymentRepo paymentRepo;
    
    public MpesaService(PaymentRepo paymentRepo){
        this.paymentRepo = paymentRepo;
    } 

    public String SaveMpesaDetails(Payment payment){
        paymentRepo.save(payment);
        return "Details Saved Successfully";
    }
}
