package jw.seo.kotlin.ex01.net

import io.reactivex.Observable
import io.reactivex.Single
import jw.seo.secondgitpj.model.GithubUser
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    //RxJava 용 .Observable
    @GET("users/{user}")
    fun getGithubUserObservable(@Path("user") userName: String): Observable<GithubUser>

    @GET("users/{user}")
    fun getGithubUserSingle(@Path("user") userName: String): Single<GithubUser>
}