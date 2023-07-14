package network;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

    public class ConnectURI {
        private final String USER_AGENT = "Mozila/5.0";

        public ConnectURI() {
        }

        public static URL buildURL(String urlQuery) {
            URL url = null;

            try {
                url = new URL(urlQuery.toString());
            } catch (MalformedURLException var3) {
                var3.printStackTrace();
            }

            return url;
        }

        public static String getResponseFromHttpUrl(URL url) throws IOException {
            HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();

            String var5;
            try {
                InputStream in = urlConnection.getInputStream();
                Scanner scanner = new Scanner(in);
                scanner.useDelimiter("\\A");
                boolean hasInput = scanner.hasNext();
                if (hasInput) {
                    var5 = scanner.next();
                    return var5;
                }

                var5 = null;
            } finally {
                urlConnection.disconnect();
            }

            return var5;
        }
    }

