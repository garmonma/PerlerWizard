package com.nni.gamevate.perlerwizard;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net.HttpMethods;
import com.badlogic.gdx.Net.HttpRequest;
import com.badlogic.gdx.Net.HttpResponseListener;
import com.badlogic.gdx.Net.Protocol;
import com.badlogic.gdx.net.HttpRequestBuilder;
import com.badlogic.gdx.net.Socket;
import com.badlogic.gdx.net.SocketHints;

public class ConnectionService {

	private static HttpURLConnection connection = null;

	private ConnectionService() {

	}

	public static String executePost(String targetURL, String urlParameters) {

		try {
			// Create connection
			URL url = new URL(targetURL);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

			connection.setRequestProperty("Content-Length", Integer.toString(urlParameters.getBytes().length));
			connection.setRequestProperty("Content-Language", "en-US");

			connection.setUseCaches(false);
			connection.setDoOutput(true);

			// Send request
			DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.close();

			// Get Response
			InputStream is = connection.getInputStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(is));
			StringBuilder response = new StringBuilder(); // or StringBuffer if
															// Java version 5+
			String line;
			while ((line = rd.readLine()) != null) {
				response.append(line);
				response.append('\r');
			}
			rd.close();

			return response.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
	}

	// Called when the game is loading to get all of the player info
	public static Player getPlayerInfo(long playerId) {
		Player player = new Player();
		
		
		//TODO
		Protocol protocol;
		String host;
		int port = 9999;
		SocketHints socketHints;
		
		Socket socket = Gdx.net.newClientSocket(null, null, port, null);
		
		HttpRequestBuilder requestBuilder = new HttpRequestBuilder();
		HttpRequest httpRequest = requestBuilder.newRequest()
				.method(HttpMethods.GET).url("http://www.google.de")
				.content(playerId + "").build();
		
		HttpResponseListener responseListener;
		
		Gdx.net.sendHttpRequest(httpRequest, null);

		return player;
	}
}
