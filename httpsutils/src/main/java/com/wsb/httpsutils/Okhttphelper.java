package com.wsb.httpsutils;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.SSLSocketFactory;

import okhttp3.OkHttpClient;

/**
 * 修改日期：2018/7/7 on 16:50
 * 描述:
 * 作者:韦书宝VincentW
 */
public class Okhttphelper {
    public static OkHttpClient createOkHttp() {

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        // 添加证书
        List<InputStream> certificates = new ArrayList<>();
        List<byte[]> certs_data = NetConfig.getCertificatesData();

        // 将字节数组转为数组输入流
        if (certs_data != null && !certs_data.isEmpty()) {
            for (byte[] bytes : certs_data) {
                certificates.add(new ByteArrayInputStream(bytes));
            }
        }


        SSLSocketFactory sslSocketFactory = HttpsUtils.getCERSocketFactory(certificates);
        if (sslSocketFactory != null) {
            builder.sslSocketFactory(sslSocketFactory);
        }

        return builder.build();
    }

}
