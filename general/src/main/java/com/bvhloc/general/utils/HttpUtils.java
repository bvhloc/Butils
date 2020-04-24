package com.bvhloc.general.utils;

import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

//import okhttp3.MediaType;
//import okhttp3.OkHttpClient;
//import okhttp3.Request;
//import okhttp3.RequestBody;
//import okhttp3.Response;

public class HttpUtils {
//
//    private static final int DEFAULT_CONNECTION_TIMEOUT = 30;
//    private static final String HOST_GOOGLE = "https://google.com";
//    public static final String KEY_RESPONSE = "RESPONSE";
//    public static final String KEY_API_CODE = "API_CODE";
//
//    public static ExecuteResponse requestHttpGETHeader(String requestUrl) {
//        return requestHttpGETHeader(requestUrl, DEFAULT_CONNECTION_TIMEOUT);
//    }
//
//    public static ExecuteResponse requestHttpGETHeader(String requestUrl, int timeoutInSeconds) {
//
//        Request request = new Request.Builder().url(requestUrl).build();
//        return getResponse(request, timeoutInSeconds);
//    }
//
//    /**
//     * Call HTTP GET with header is Authorization
//     *
//     * @param requestUrl
//     * @param token
//     * @return
//     */
//    public static ExecuteResponse requestHttpGETHeader(String requestUrl, String token) {
//        return requestHttpGETHeader(requestUrl, token, DEFAULT_CONNECTION_TIMEOUT);
//    }
//
//    public static ExecuteResponse requestHttpGETHeader(String requestUrl, String token, int timeoutInSeconds) {
//        Request request = new Request.Builder()
//                .url(requestUrl)
//                .header("Authorization", "Bearer " + token)
//                .build();
//        return getResponse(request, timeoutInSeconds);
//    }
//
//    /**
//     * Call HTTP POST with header is Authorization
//     *
//     * @param requestUrl
//     * @param body
//     * @param accessToken
//     * @return
//     */
//    public static ExecuteResponse requestHttpPOSTHeader(String requestUrl, String body, String accessToken, int timeOutInMillis) {
//        MediaType JSON
//                = MediaType.parse("application/json; charset=utf-8");
//
//        Request.Builder requestBuilder = new Request.Builder()
//                .url(requestUrl)
//                .addHeader("Authorization", "Bearer " + accessToken);
//
//        RequestBody requestBody = RequestBody.create(JSON, body);
//        requestBuilder.post(requestBody);
//
//        Request request = requestBuilder.build();
//        return getResponse(request, timeOutInMillis);
//    }
//
//    /**
//     * Call HTTP PUT with header is Authorization
//     *
//     * @param requestUrl
//     * @param body
//     * @param accessToken
//     * @return
//     */
//    public static ExecuteResponse requestHttpPUTHeader(String requestUrl, String body, String accessToken, int timeOutInMillis) {
//        MediaType JSON
//                = MediaType.parse("application/json; charset=utf-8");
//
//        Request.Builder requestBuilder = new Request.Builder()
//                .url(requestUrl)
//                .addHeader("Authorization", "Bearer " + accessToken);
//
//        RequestBody requestBody = RequestBody.create(JSON, body);
//        requestBuilder.put(requestBody);
//
//        Request request = requestBuilder.build();
//        return getResponse(request, timeOutInMillis);
//    }
//
//    /**
//     * Call HTTP PUT with header is Authorization
//     *
//     * @param requestUrl
//     * @param body
//     * @param accessToken
//     * @return
//     */
//    public static ExecuteResponse requestHttpDELETEHeader(String requestUrl, String body, String accessToken, int timeOutInMillis) {
//        MediaType JSON
//                = MediaType.parse("application/json; charset=utf-8");
//
//        Request.Builder requestBuilder = new Request.Builder()
//                .url(requestUrl)
//                .addHeader("Authorization", "Bearer " + accessToken);
//
//        RequestBody requestBody = RequestBody.create(JSON, body);
//        requestBuilder.delete(requestBody);
//
//        Request request = requestBuilder.build();
//        return getResponse(request, timeOutInMillis);
//    }
//
//    public static ExecuteResponse requestHttpPOST(String requestUrl, String body) {
//        return requestHttpPOST(requestUrl, body, DEFAULT_CONNECTION_TIMEOUT);
//    }
//
//    public static ExecuteResponse requestHttpPOST(String requestUrl, String[] keys, Object[] values) {
//        return requestHttpPOST(requestUrl, keys, values, DEFAULT_CONNECTION_TIMEOUT);
//    }
//
//    public static ExecuteResponse requestHttpPOST(String requestUrl, String[] keys, Object[] values, int timeoutInSeconds) {
//
//        Map<String, Object> map = new HashMap<>();
//        for (int i = 0; i < keys.length; i++) {
//            map.put(keys[i], values[i]);
//        }
//
//        return requestHttpPOST(requestUrl, map, timeoutInSeconds);
//    }
//
//    public static ExecuteResponse requestHttpPOST(String requestUrl, Map<String, Object> params) {
//        return requestHttpPOST(requestUrl, params, DEFAULT_CONNECTION_TIMEOUT);
//    }
//
//    public static ExecuteResponse requestHttpPOST(String requestUrl, Map<String, Object> params, int timeoutInSeconds) {
//
//        String body = buildJson(params);
//        return requestHttpPOST(requestUrl, body, timeoutInSeconds);
//    }
//
//    public static String buildJson(Map<String, Object> params) {
//
//        JSONObject json = new JSONObject();
//        try {
//            if (params.entrySet().size() > 0) {
//                for (String key : params.keySet()) {
//                    json.putOpt(key, params.get(key));
//                }
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        return json.toString();
//    }
//
//    public static ExecuteResponse requestHttpPOST(String requestUrl, String body, int timeoutInSeconds) {
//
//        MediaType JSON
//                = MediaType.parse("application/json; charset=utf-8");
//
//        RequestBody requestBody = RequestBody.create(JSON, body);
//        Request request = new Request.Builder()
//                .url(requestUrl)
//                .post(requestBody)
//                .build();
//        return getResponse(request, timeoutInSeconds);
//    }
//
//    public static ExecuteResponse requestHttpPUT(String requestUrl, String body) {
//        return requestHttpPUT(requestUrl, body, DEFAULT_CONNECTION_TIMEOUT);
//    }
//
//    public static ExecuteResponse requestHttpPUT(String requestUrl, String body, int timeoutInSeconds) {
//
//        MediaType JSON
//                = MediaType.parse("application/json; charset=utf-8");
//
//        RequestBody requestBody = RequestBody.create(JSON, body);
//        Request request = new Request.Builder()
//                .url(requestUrl)
//                .put(requestBody)
//                .build();
//        return getResponse(request, timeoutInSeconds);
//    }
//
//    public static String requestHttpDelete(String requestUrl) {
//        return requestHttpDelete(requestUrl, DEFAULT_CONNECTION_TIMEOUT);
//    }
//
//    public static String requestHttpDelete(String requestUrl, int timeoutInSeconds) {
//
//        Request request = new Request.Builder()
//                .url(requestUrl)
//                .delete()
//                .build();
//        return getResponse(request, timeoutInSeconds).response;
//    }
//
//    public static ExecuteResponse getResponse(Request request, int timeoutInSeconds) {
//
////        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
////        // set your desired log level
////        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
//
//        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .readTimeout(timeoutInSeconds, TimeUnit.SECONDS)
//                .writeTimeout(timeoutInSeconds, TimeUnit.SECONDS)
////                .addInterceptor(logging)
//                .build();
//
//
//        int code = 0;
//        String responseStr = null;
//        try {
//            Response response = okHttpClient.newCall(request).execute();
//            responseStr = response.body().string();
//            code = response.code();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return new ExecuteResponse(code, responseStr);
//    }
//
//    private static Map<String, String> getResponseWithStatusCode(final Request request) {
//
////        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
////        // set your desired log level
////        logging.setLevel(HttpLoggingInterceptor.Level.HEADERS);
//
//        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .readTimeout(HttpUtils.DEFAULT_CONNECTION_TIMEOUT, TimeUnit.SECONDS)
//                .writeTimeout(HttpUtils.DEFAULT_CONNECTION_TIMEOUT, TimeUnit.SECONDS)
////                .addInterceptor(logging)
//                .build();
//
//        Map<String, String> responseMap = new HashMap<>();
//
//        try {
//            Response response = okHttpClient.newCall(request).execute();
//            if (response.body() != null) {
//                responseMap.put(KEY_RESPONSE, response.body().string());
//            }
//            responseMap.put(KEY_API_CODE, response.code() + "");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return responseMap;
//    }
//
//    private SSLContext getSSLContext() throws CertificateException, IOException, KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
//
//        // Load CAs from an InputStream
//// (could be from a resource or ByteArrayInputStream or ...)
//        CertificateFactory cf = CertificateFactory.getInstance("X.509");
//// From https://www.washington.edu/itconnect/security/ca/load-der.crt
//        InputStream caInput = new BufferedInputStream(new FileInputStream("load-der.crt"));
//        Certificate ca;
//        try {
//            ca = cf.generateCertificate(caInput);
//            System.out.println("ca=" + ((X509Certificate) ca).getSubjectDN());
//        } finally {
//            caInput.close();
//        }
//
//// Create a KeyStore containing our trusted CAs
//        String keyStoreType = KeyStore.getDefaultType();
//        KeyStore keyStore = KeyStore.getInstance(keyStoreType);
//        keyStore.load(null, null);
//        keyStore.setCertificateEntry("ca", ca);
//
//// Create a TrustManager that trusts the CAs in our KeyStore
//        String tmfAlgorithm = TrustManagerFactory.getDefaultAlgorithm();
//        TrustManagerFactory tmf = TrustManagerFactory.getInstance(tmfAlgorithm);
//        tmf.init(keyStore);
//
//// Create an SSLContext that uses our TrustManager
//        SSLContext context = SSLContext.getInstance("TLS");
//        context.init(null, tmf.getTrustManagers(), null);
//
//        return context;
//    }
//
////    private HttpClient getHttpClient() {
////        try {
////            KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
////            trustStore.load(null, null);
////
////            SSLSocketFactory sf = new SFSSLSocketFactory(trustStore);
////            sf.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
////
////            HttpParams params = new BasicHttpParams();
////            HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
////            HttpProtocolParams.setContentCharset(params, HTTP.UTF_8);
////
////            SchemeRegistry registry = new SchemeRegistry();
////            registry.registerUser(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
////            registry.registerUser(new Scheme("https", sf, 443));
////
////            ClientConnectionManager ccm = new ThreadSafeClientConnManager(params, registry);
////
////            return new DefaultHttpClient(ccm, params);
////        } catch (Exception e) {
////            return new DefaultHttpClient();
////        }
////    }
//
//    public static void checkInternetConnection(final OnConnectionListener listener) {
//        checkInternetConnection(DEFAULT_CONNECTION_TIMEOUT, listener);
//    }
//
//    public static void checkInternetConnection(final int timeoutInSeconds /*seconds*/, final OnConnectionListener listener) {
//        new AsyncTask<Void, Void, Boolean>() {
//            @Override
//            protected void onPreExecute() {
//                super.onPreExecute();
//                listener.onPreConnect();
//            }
//
//            @Override
//            protected Boolean doInBackground(Void... params) {
//
//                try {
//                    Request request = new Request.Builder().url(HOST_GOOGLE).build();
//                    OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                            .readTimeout(timeoutInSeconds, TimeUnit.SECONDS)
//                            .writeTimeout(timeoutInSeconds, TimeUnit.SECONDS)
//                            .build();
//                    Response response = okHttpClient.newCall(request).execute();
//                    return response != null;
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                return false;
//            }
//
//            @Override
//            protected void onPostExecute(Boolean responded) {
//                super.onPostExecute(responded);
//                if (responded) {
//                    listener.onConnected();
//                } else {
//                    listener.onFail();
//                }
//            }
//        }.execute();
//    }
//
//    public static void executeHttpGET(final String requestUrl, ConnectionCallback callback) {
//        executeHttpGET(requestUrl, DEFAULT_CONNECTION_TIMEOUT, callback);
//    }
//
//    public static void executeHttpGET(final String requestUrl, final int timeoutInSeconds, ConnectionCallback callback) {
//        executeRequest(callback, new Execute() {
//            @Override
//            public ExecuteResponse onExecute() {
//                return requestHttpGETHeader(requestUrl, timeoutInSeconds);
//            }
//        });
//    }
//
//    public static void executeHttpPOST(String requestUrl, String[] keys, Object[] values, ConnectionCallback callback) {
//        executeHttpPOST(requestUrl, keys, values, DEFAULT_CONNECTION_TIMEOUT, callback);
//    }
//
//    public static void executeHttpPOST(String requestUrl, String[] keys, Object[] values, int timeoutInSeconds, ConnectionCallback callback) {
//
//        Map<String, Object> map = new HashMap<>();
//        for (int i = 0; i < keys.length; i++) {
//            map.put(keys[i], values[i]);
//        }
//
//        executeHttpPOST(requestUrl, map, timeoutInSeconds, callback);
//    }
//
//    public static void executeHttpPOST(String requestUrl, Map<String, Object> params, ConnectionCallback callback) {
//        executeHttpPOST(requestUrl, params, DEFAULT_CONNECTION_TIMEOUT, callback);
//    }
//
//    public static void executeHttpPOST(String requestUrl, Map<String, Object> params, int timeoutInSeconds, ConnectionCallback callback) {
//
//        String body = buildJson(params);
//        executeHttpPOST(requestUrl, body, timeoutInSeconds, callback);
//    }
//
//    public static void executeHttpPOST(String requestUrl, String body, ConnectionCallback callback) {
//        executeHttpPOST(requestUrl, body, DEFAULT_CONNECTION_TIMEOUT, callback);
//    }
//
//    public static void executeHttpPOST(final String requestUrl, final String body, final int timeoutInSeconds, ConnectionCallback callback) {
//        executeRequest(callback, new Execute() {
//            @Override
//            public ExecuteResponse onExecute() {
//                return requestHttpPOST(requestUrl, body, timeoutInSeconds);
//            }
//        });
//    }
//
//    public static void executeHttpPUT(String requestUrl, String[] keys, Object[] values, ConnectionCallback callback) {
//        executeHttpPUT(requestUrl, keys, values, DEFAULT_CONNECTION_TIMEOUT, callback);
//    }
//
//    public static void executeHttpPUT(String requestUrl, String[] keys, Object[] values, int timeoutInSeconds, ConnectionCallback callback) {
//
//        Map<String, Object> map = new HashMap<>();
//        for (int i = 0; i < keys.length; i++) {
//            map.put(keys[i], values[i]);
//        }
//
//        executeHttpPUT(requestUrl, map, timeoutInSeconds, callback);
//    }
//
//    public static void executeHttpPUT(String requestUrl, Map<String, Object> params, ConnectionCallback callback) {
//        executeHttpPUT(requestUrl, params, DEFAULT_CONNECTION_TIMEOUT, callback);
//    }
//
//    public static void executeHttpPUT(String requestUrl, Map<String, Object> params, int timeoutInSeconds, ConnectionCallback callback) {
//
//        String body = buildJson(params);
//        executeHttpPUT(requestUrl, body, timeoutInSeconds, callback);
//    }
//
//    public static void executeHttpPUT(String requestUrl, String body, ConnectionCallback callback) {
//        executeHttpPUT(requestUrl, body, DEFAULT_CONNECTION_TIMEOUT, callback);
//    }
//
//    public static void executeHttpPUT(final String requestUrl, final String body, final int timeoutInSeconds, ConnectionCallback callback) {
//        executeRequest(callback, new Execute() {
//            @Override
//            public ExecuteResponse onExecute() {
//                return requestHttpPUT(requestUrl, body, timeoutInSeconds);
//            }
//        });
//    }
//
//    /**
//     * Below is execution with header
//     */
//
//    public static void executeHttpGET(final String requestUrl, String token, ConnectionCallback callback) {
//        executeHttpGET(requestUrl, token, DEFAULT_CONNECTION_TIMEOUT, callback);
//    }
//
//    public static void executeHttpGET(final String requestUrl, final String token, final int timeoutInSeconds, ConnectionCallback callback) {
//        executeRequest(callback, new Execute() {
//            @Override
//            public ExecuteResponse onExecute() {
//                return requestHttpGETHeader(requestUrl, token, timeoutInSeconds);
//            }
//        });
//    }
//
//    public static void executeHttpPOST(String requestUrl, String token, String body, ConnectionCallback callback) {
//        executeHttpPOST(requestUrl, token, body, DEFAULT_CONNECTION_TIMEOUT, callback);
//    }
//
//    public static void executeHttpPOST(String requestUrl, String token, Map<String, Object> params, ConnectionCallback callback) {
//        executeHttpPOST(requestUrl, token, params, DEFAULT_CONNECTION_TIMEOUT, callback);
//    }
//
//    public static void executeHttpPOST(String requestUrl, String token, Map<String, Object> params, int timeoutInSeconds, ConnectionCallback callback) {
//        String body = null;
//        if (params != null) {
//            body = buildJson(params);
//        }
//        executeHttpPOST(requestUrl, token, body, timeoutInSeconds, callback);
//    }
//
//    public static void executeHttpPOST(final String requestUrl, final String token, final String body, final int timeoutInSeconds, ConnectionCallback callback) {
//        executeRequest(callback, new Execute() {
//            @Override
//            public ExecuteResponse onExecute() {
//                return requestHttpPOSTHeader(requestUrl, body, token, timeoutInSeconds);
//            }
//        });
//    }
//
//    public static void executeHttpPUT(String requestUrl, String token, String body, ConnectionCallback callback) {
//        executeHttpPUT(requestUrl, token, body, DEFAULT_CONNECTION_TIMEOUT, callback);
//    }
//
//    public static void executeHttpPUT(String requestUrl, String token, Map<String, Object> params, ConnectionCallback callback) {
//        executeHttpPUT(requestUrl, token, params, DEFAULT_CONNECTION_TIMEOUT, callback);
//    }
//
//    public static void executeHttpPUT(String requestUrl, String token, Map<String, Object> params, int timeoutInSeconds, ConnectionCallback callback) {
//        String body = null;
//        if (params != null) {
//            body = buildJson(params);
//        }
//        executeHttpPUT(requestUrl, token, body, timeoutInSeconds, callback);
//    }
//
//    public static void executeHttpPUT(final String requestUrl, final String token, final String body, final int timeoutInSeconds, ConnectionCallback callback) {
//        executeRequest(callback, new Execute() {
//            @Override
//            public ExecuteResponse onExecute() {
//                return requestHttpPUTHeader(requestUrl, body, token, timeoutInSeconds);
//            }
//        });
//    }
//
//    public static void executeHttpDELETE(String requestUrl, String token, String body, ConnectionCallback callback) {
//        executeHttpDELETE(requestUrl, token, body, DEFAULT_CONNECTION_TIMEOUT, callback);
//    }
//
//    public static void executeHttpDELETE(String requestUrl, String token, Map<String, Object> params, ConnectionCallback callback) {
//        executeHttpDELETE(requestUrl, token, params, DEFAULT_CONNECTION_TIMEOUT, callback);
//    }
//
//    public static void executeHttpDELETE(String requestUrl, String token, Map<String, Object> params, int timeoutInSeconds, ConnectionCallback callback) {
//        String body = null;
//        if (params != null) {
//            body = buildJson(params);
//        }
//        executeHttpDELETE(requestUrl, token, body, timeoutInSeconds, callback);
//    }
//
//    public static void executeHttpDELETE(final String requestUrl, final String token, final String body, final int timeoutInSeconds, ConnectionCallback callback) {
//        executeRequest(callback, new Execute() {
//                    @Override
//                    public ExecuteResponse onExecute() {
//                        return requestHttpDELETEHeader(requestUrl, body, token, timeoutInSeconds);
//                    }
//                }
//        );
//    }
//
//    public static void executeRequest(final ConnectionCallback callback, final Execute execute) {
//        final long start = System.currentTimeMillis();
//        new AsyncTask<Void, Void, ExecuteResponse>() {
//            @Override
//            protected void onPreExecute() {
//                super.onPreExecute();
//                callback.onPreConnect();
//            }
//
//            @Override
//            protected ExecuteResponse doInBackground(Void... params) {
//                return execute.onExecute();
//            }
//
//            @Override
//            protected void onPostExecute(ExecuteResponse executeResponse) {
//                super.onPostExecute(executeResponse);
//                long end = System.currentTimeMillis();
//                long callbackInMilis = end - start;
//                if (executeResponse.response != null) {
//                    callback.onResponse(executeResponse.response, executeResponse.code, callbackInMilis);
//                } else {
//                    callback.onConnectionFail(callbackInMilis);
//                }
//            }
//        }.execute();
//    }
//
//    public interface OnConnectionListener {
//
//        void onPreConnect();
//
//        void onConnected();
//
//        void onFail();
//    }
//
//    public static class ExecuteResponse {
//
//        private int code;
//
//        private String response;
//
//        public ExecuteResponse(int code, String response) {
//            this.code = code;
//            this.response = response;
//        }
//    }
//
//    public interface Execute {
//
//        ExecuteResponse onExecute();
//    }
//
//    private interface BaseConnectionCallback {
//
//        void onPreConnect();
//
//        void onResponse(String response, int code, long callbackInMilis);
//
//        void onConnectionFail(long callbackInMilis);
//    }
//
//    public abstract static class ConnectionCallback implements BaseConnectionCallback {
//
//        @Override
//        public void onPreConnect() {
//
//        }
//    }

}
