package cn.csfz.util;

import okhttp3.*;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;
import java.util.concurrent.TimeUnit;


/**
 * @author eajon
 * @description OkHttpUtils
 * @date 2019-08-26 11:31
 */

public class OkHttpUtils {


    public static OkHttpClient okHttpClient = new
            OkHttpClient.Builder()
            //.sslSocketFactory(sslSocketFactory(), x509TrustManager())
            .retryOnConnectionFailure(true)
            .connectionPool(pool())
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build();


    public X509TrustManager x509TrustManager() {
        return new X509TrustManager() {
            @Override
            public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
            }

            @Override
            public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
            }

            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }
        };
    }


    /**
     * Create a new connection pool with tuning parameters appropriate for a single-user application.
     * The tuning parameters in this pool are subject to change in future OkHttp releases. Currently
     */
    public static ConnectionPool pool() {
        return new ConnectionPool(200, 5, TimeUnit.MINUTES);
    }


    /**
     * get
     *
     * @param url    请求的url
     * @param params 请求的参数，在浏览器？后面的数据，没有可以传null
     * @return
     */
    public static String get(String url, Map<String, String> params) {
        StringBuilder stringBuilder = new StringBuilder(url).append("?");
        if (params != null && params.keySet().size() > 0) {
            for (String key : params.keySet()) {
                stringBuilder.append(key).append("=").append(params.get(key)).append("&");
            }
        }
        Request request = new Request.Builder()
                .url(stringBuilder.substring(0, stringBuilder.length() - 1))
                .build();
        return doRequest(request);
    }

    /**
     * get
     *
     * @param url    请求的url
     * @param params 请求的参数，在浏览器？后面的数据，没有可以传null
     * @return
     */
    public static String get(String url, Map<String, String> params, Headers headers) {
        StringBuilder stringBuilder = new StringBuilder(url).append("?");
        if (params != null && params.keySet().size() > 0) {
            for (String key : params.keySet()) {
                stringBuilder.append(key).append("=").append(params.get(key)).append("&");
            }
        }
        Request request = new Request.Builder()
                .url(stringBuilder.substring(0, stringBuilder.length() - 1))
                .headers(headers)
                .build();
        return doRequest(request);
    }

    /**
     * post
     *
     * @param url    请求的url
     * @param params post form 提交的参数
     * @return
     */
    public static String post(String url, Map<String, String> params) {
        FormBody.Builder builder = new FormBody.Builder();
        //添加参数
        if (params != null && params.keySet().size() > 0) {
            for (String key : params.keySet()) {
                builder.add(key, params.get(key));
            }
        }
        Request request = new Request.Builder()
                .url(url)
                .post(builder.build())
                .build();
        return doRequest(request);
    }

    /**
     * post
     *
     * @param url    请求的url
     * @param params post form 提交的参数
     * @return
     */
    public static String post(String url, Map<String, String> params, Headers headers) {
        FormBody.Builder builder = new FormBody.Builder();
        //添加参数
        if (params != null && params.keySet().size() > 0) {
            for (String key : params.keySet()) {
                builder.add(key, params.get(key));
            }
        }
        Request request = new Request.Builder()
                .url(url)
                .headers(headers)
                .post(builder.build())
                .build();
        return doRequest(request);
    }
    /**
     * post
     *
     * @param url    请求的url
     * @param params post form 提交的参数
     * @return
     */
    public static InputStream download(String url, Map<String, String> params, Headers headers) {
        FormBody.Builder builder = new FormBody.Builder();
        //添加参数
        if (params != null && params.keySet().size() > 0) {
            for (String key : params.keySet()) {
                builder.add(key, params.get(key));
            }
        }
        Request request = new Request.Builder()
                .url(url)
                .headers(headers)
                .post(builder.build())
                .build();
        return doDownload(request);
    }


    /**
     * post
     *
     * @param url    请求的url
     * @param params post form 提交的参数
     * @return
     */
    public static void asyncPost(String url, Map<String, String> params, Callback callback) {
        FormBody.Builder builder = new FormBody.Builder();
        //添加参数
        if (params != null && params.keySet().size() > 0) {
            for (String key : params.keySet()) {
                builder.add(key, params.get(key));
            }
        }
        Request request = new Request.Builder()
                .url(url)
                .post(builder.build())
                .build();
        doAsyncRequest(request, callback);
    }


    /**
     * post
     *
     * @param url    请求的url
     * @param params post form 提交的参数
     * @return
     */
    public static void asynPost(String url, Map<String, String> params, Headers headers, Callback callback) {
        FormBody.Builder builder = new FormBody.Builder();
        //添加参数
        if (params != null && params.keySet().size() > 0) {
            for (String key : params.keySet()) {
                builder.add(key, params.get(key));
            }
        }
        Request request = new Request.Builder()
                .url(url)
                .post(builder.build())
                .headers(headers)
                .build();
        doAsyncRequest(request, callback);
    }


    /**
     * Post请求发送JSON数据....{"name":"zhangsan","pwd":"123456"}
     * 参数一：请求Url
     * 参数二：请求的JSON
     * 参数三：请求回调
     */
    public static String json(String url, String jsonParams) {
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jsonParams);
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        return doRequest(request);
    }

    /**
     * Post请求发送JSON数据....{"name":"zhangsan","pwd":"123456"}
     * 参数一：请求Url
     * 参数二：请求的JSON
     * 参数三：请求回调
     */
    public static String json(String url, String jsonParams, Headers headers) {
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jsonParams);
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .headers(headers)
                .build();
        return doRequest(request);
    }

    /**
     * Post请求发送xml数据....
     * 参数一：请求Url
     * 参数二：请求的xmlString
     * 参数三：请求回调
     */
    public static String xml(String url, String xml) {
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/xml; charset=utf-8"), xml);
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        return doRequest(request);
    }

    /**
     * Post请求发送xml数据....
     * 参数一：请求Url
     * 参数二：请求的xmlString
     * 参数三：请求回调
     */
    public static String xml(String url, String xml, Headers headers) {
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/xml; charset=utf-8"), xml);
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .headers(headers)
                .build();
        return doRequest(request);
    }

    private static String doRequest(Request request) {
        String responseBody = "";
        try {
            Response response = okHttpClient.newCall(request).execute();
            if (response.isSuccessful() && response.body() != null) {
                return response.body().string();
            }
        } catch (Exception e) {
            System.out.println("okhttp3 post error >> ex = {}" + e);
        }
        return responseBody;
    }

    private static InputStream doDownload(Request request) {
        try {
            Response response = okHttpClient.newCall(request).execute();
            if (response.isSuccessful() && response.body() != null) {
                return response.body().byteStream();
            }
        } catch (Exception e) {
            System.out.println("okhttp3 post error >> ex = {}" + e);
        }
        return null;
    }


    private static void doAsyncRequest(Request request, Callback callback) {
        okHttpClient.newCall(request).enqueue(callback);
    }


}
