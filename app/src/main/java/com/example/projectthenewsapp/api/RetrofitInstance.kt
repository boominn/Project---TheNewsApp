package com.example.projectthenewsapp.api

import com.example.projectthenewsapp.util.Constants.Companion.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {

    companion object {          // companion sınıfın objesi oluşturulmadan erişmek için kullanılır direkt erişim için

        private val retrofit by lazy {   // by lazy değerin ilk kez erişildiğinde oluşturulmasını sağlar gereksiz yere nesne oluşturmayı önler Perf(+)
            val logging = HttpLoggingInterceptor()   // HTTP request ve responselarını loglamak için 14-15. satırlar
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder()     //istemci oluşturulur (client) client a logging eklenir ve build edilir
                .addInterceptor(logging)
                .build()

            Retrofit.Builder()          //retrofit clienti oluşturulur
                .baseUrl(BASE_URL)      // JSON verisinin baes url si
                .addConverterFactory(GsonConverterFactory.create())     // JSON verilerini Kotlin nesnelerine çevirir
                .client(client)             // oluşturulan clienti belirtir
                .build()                    // build eder

        }
        val api by lazy {                       // api nesnesini ilk erişildiğinde oluşturur gereksiz nesne oluşturmayı önler
            retrofit.create(NewsAPI::class.java)   // NewsAPI interface ini kullanarak API requestlerini gerçekleştirerek Retrofit clienti oluşturur
        }

    }

}