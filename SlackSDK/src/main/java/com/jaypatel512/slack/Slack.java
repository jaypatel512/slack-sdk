package com.jaypatel512.slack;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLEncoder;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder(builderMethodName = "requiredFieldBuilder")
public class Slack {

  private static final String POST = "POST";

  @Default private Proxy proxy = Proxy.NO_PROXY;
  @Default private Gson gson = new GsonBuilder().serializeNulls().setFieldNamingPolicy(
      FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
  @Default private int timeout = 5000;

  private final String url;

  public String send(SlackMessage message) throws SlackException {
    HttpURLConnection connection = null;

    try {
      // Create connection
      connection = getConnection();

      final String payload = getPayload(message);

      // Send request
      final DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
      wr.writeBytes(payload);
      wr.flush();
      wr.close();

      // Get Response
      final InputStream is = connection.getInputStream();
      final BufferedReader rd = new BufferedReader(new InputStreamReader(is));

      String line;
      StringBuilder response = new StringBuilder();
      while ((line = rd.readLine()) != null) {
        response.append(line);
        response.append('\n');
      }

      rd.close();

      return response.toString();
    } catch (Exception e) {
      throw new SlackException(e);
    } finally {
      if (connection != null) {
        connection.disconnect();
      }
    }
  }

  public static SlackBuilder builder(String url) {
    return requiredFieldBuilder().url(url);
  }

  protected String getPayload(SlackMessage message) throws UnsupportedEncodingException {
    return "payload=" + URLEncoder.encode(getGson().toJson(message), "UTF-8");
  }

  protected HttpURLConnection getConnection() throws IOException {
    URL url = new URL(getUrl());
    HttpURLConnection connection = (HttpURLConnection) url.openConnection(getProxy());
    connection.setRequestMethod(POST);
    connection.setConnectTimeout(getTimeout());
    connection.setUseCaches(false);
    connection.setDoInput(true);
    connection.setDoOutput(true);

    return connection;
  }


}
