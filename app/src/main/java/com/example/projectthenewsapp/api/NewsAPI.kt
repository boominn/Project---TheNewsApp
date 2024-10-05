package com.example.projectthenewsapp.api


import com.example.projectthenewsapp.models.NewsResponse
import com.example.projectthenewsapp.util.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.Locale.IsoCountryCode

interface NewsAPI {
                            // https://newsapi.org/v2/top-headlines?country=us&apiKey=6d946314dbdf4a2aa7562092ec5271a5
    @GET("v2/top-headlines")   // top headlines linkinin devamında görüldüğü gibi country us olacak api key de bizim api keyimiz olacak ve buna
    suspend fun getHeadlines(   // request göndereceğiz bu sebeple Querylerimizi yazıyoruz
        @Query("country")
        countryCode: String = "us",
        @Query("page")
        pageNumber: Int = 1,
        @Query("apiKey")
        apiKey: String = API_KEY
    ): Response<NewsResponse>        // bu fonksiyon bize Response türünden NewsResponse verilerini geri döndürecek NewsResponse classımızda
                                    // verilerimiz olduğu için

    @GET("v2/everything")               //https://newsapi.org/v2/everything?q=bitcoin&apiKey=6d946314dbdf4a2aa7562092ec5271a5
    suspend fun searchForNews(         //Şimdi de haber aratmak istediğimiz için everything başlığı altına geliyoruz @GET
        @Query("q")                    // içine endpointinin yazıyoruz arama yapmak istediğimiz için Query("q") yazıyoruz q olmasının sebebi sitede
        searchQuery: String,            // dökümantasyonda q Querysi ile search edildiği için page number ımızı olacak ve api key olmak zorunda yine
        @Query("page")
        pageNumber: Int = 1,
        @Query("apiKey")
        apiKey: String = API_KEY
    ): Response<NewsResponse>               // Response türünden  bize NewResponse verilerini dönecek yanıt olarak
}
                // Fonksiyonlarımız suspend olmak zorunda çünkü main threadde çalışıp verinin geliş
                // durumuna göre programı çökertmesini istemiyoruz suspend fonksiyonları bildiğimiz
                // üzere retrofit ile kullanabiliyoruz