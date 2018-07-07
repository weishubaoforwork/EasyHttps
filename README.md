# EasyHttps
基于OKHTTP快速使用Https!

 如何使用 How To Use:




1.集成项目
To get a Git project into your build:   


    1.1 Add it in your root build.gradle at the end of repositories:
    1.1 将你的根目录下的build.gradle文件中添加仓库设置
        
        allprojects {
            repositories {
                            maven { 
                                url 'https://jitpack.io'
                                 }
                            }
                }
                
    
    
    1.2Add the dependency
    1.2在你的APP中的build.gradle中添加依赖
         dependencies {
             implementation 'com.github.weishubaoforwork:EasyHttps:1.0'
                }


2.使用EasyHttps进行绕过证书对Https进行请求
Use EasyHttps to bypass the certificate to request Https.
    
    2.1在你的okhttpclient.builder处进行引用即可
    2.1Reference at your okhttpclient.builder
        
        okHttpClient = new OkHttpClient();
                okHttpClient.newBuilder()
                        .connectTimeout(10, TimeUnit.SECONDS)
                        .readTimeout(10, TimeUnit.SECONDS)
                        .writeTimeout(10, TimeUnit.SECONDS).sslSocketFactory(HttpsUtils.getSslSocketFactory(null,null,null))
                        .hostnameVerifier(new HostnameVerifier() {
                            @Override
                            public boolean verify(String s, SSLSession sslSession) {
                                return true;
                            }
                        });
                        
3.使用EasyHttps进行自定义证书对Https进行请求
Use EasyHttps to customize the certificate to request Https.
    
    3.1请先将你的同事提供给你的.cer自定义证书文件放入Assets
    3.1Please first put the.Cer custom certificate file provided by your colleague to your Project Assets.
        
        
        
    3.2在你的okhttpclient.builder处进行引用即可(在getSSlFactory()中需要提供您的证书名字)
    3.2Reference at your okhttpclient.builder(You need to provide your certificate name in getSSlFactory ())
                
                okHttpClient = new OkHttpClient();
                okHttpClient.newBuilder()
                           .connectTimeout(10, TimeUnit.SECONDS)
                           .readTimeout(10, TimeUnit.SECONDS)
                           .writeTimeout(10, TimeUnit.SECONDS)  
                           .sslSocketFactory(HttpsUtils.getSSlFactory(context,"certificate.cer")).hostnameVerifier(new HostnameVerifier() {
                       @Override
                       public boolean verify(String s, SSLSession sslSession) {
                           return true;
                       }
                   });