/*
 * Copyright [2020] [ispong]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.isxcode.oxygen.core.httpclient;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.isxcode.oxygen.core.exception.UtilsException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.springframework.lang.NonNull;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * httpClient请求 工具类
 *
 * @author ispong
 * @version v0.1.0
 */
public class HttpClientUtils {

    private static HttpClient httpClient = HttpClientBuilder.create().build();

    /**
     * get接口调用
     *
     * @param url         请求路径
     * @param requestMap  请求对象(map)
     * @param responseObj 返回对象
     * @return 返回第三方返回的值
     * @since 2019-11-04
     */
    @NonNull
    public static <A> A doGet(String url, Map<String, String> requestMap, Class<A> responseObj) {

        StringBuilder requestParams = new StringBuilder("?");
        requestMap.forEach((k, v) -> requestParams.append(k).append("=").append(v).append("&"));
        try {
            return JSONObject.parseObject(
                    EntityUtils.toString(
                            httpClient.execute(new HttpGet(url + requestParams)).getEntity()), responseObj);
        } catch (IOException e) {
            throw new UtilsException("get接口调用失败");
        }
    }

    /**
     * post接口调用
     *
     * @param url        请求路径
     * @param requestStr 请求对象(Str)
     * @since 2019-11-04
     */
    @NonNull
    public static void doPost(String url, String requestStr) throws IOException {

        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader(HTTP.CONTENT_TYPE, "application/json;charset=utf-8");
        httpPost.setEntity(new StringEntity(requestStr, StandardCharsets.UTF_8));
        httpClient.execute(httpPost);
    }

    /**
     * post接口调用
     *
     * @param url         请求路径
     * @param requestObj  请求对象(obj)
     * @param responseObj 返回对象
     * @return 返回第三方返回的值
     * @since 2019-11-04
     */
    @NonNull
    public static <A> A doPost(String url, Object requestObj, Class<A> responseObj) throws IOException {

        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader(HTTP.CONTENT_TYPE, "application/json;charset=utf-8");
        httpPost.setEntity(new StringEntity(JSON.toJSONString(requestObj), StandardCharsets.UTF_8));
        return JSONObject.parseObject(EntityUtils.toString(httpClient.execute(httpPost).getEntity()), responseObj);
    }

    /**
     * post接口调用
     *
     * @param url         请求路径
     * @param requestMap  请求对象(map)
     * @param responseObj 返回对象
     * @return 返回第三方返回的值
     * @since 2019-11-04
     */
    @NonNull
    public static <A> A doPost(String url, Map<String, String> requestMap, Class<A> responseObj) throws IOException {

        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader(HTTP.CONTENT_TYPE, "application/json;charset=utf-8");
        httpPost.setEntity(new StringEntity(JSON.toJSONString(requestMap), StandardCharsets.UTF_8));
        return JSONObject.parseObject(EntityUtils.toString(httpClient.execute(httpPost).getEntity()), responseObj);
    }

    /**
     * post接口调用
     *
     * @param url         请求路径
     * @param requestStr  请求对象(json)
     * @param responseObj 返回对象
     * @param headers     请求头
     * @return 返回第三方返回的值
     * @since 2019-11-04
     */
    @NonNull
    public static <A> A doPost(String url, String requestStr, Map<String, String> headers, Class<A> responseObj) throws IOException {

        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader(HTTP.CONTENT_TYPE, "application/json;charset=utf-8");
        httpPost.setEntity(new StringEntity(requestStr, StandardCharsets.UTF_8));
        headers.forEach(httpPost::setHeader);
        return JSONObject.parseObject(EntityUtils.toString(httpClient.execute(httpPost).getEntity()), responseObj);
    }

}

