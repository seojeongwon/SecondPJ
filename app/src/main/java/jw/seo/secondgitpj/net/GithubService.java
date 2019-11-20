package jw.seo.secondgitpj.net;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import jw.seo.secondgitpj.model.GithubUser;
import jw.seo.secondgitpj.model.GithubUserRepository;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GithubService {

    @GET("users/{user}")
    Call<GithubUser> getGithubUser(@Path("user") String userName);

    @GET("users/{user}/repos")
    Call<List<GithubUserRepository>> getGithubUserRepository(@Path("user") String userName);

    //RxJava 용 .Observable
    @GET("users/{user}")
    Observable<GithubUser> getGithubUser2(@Path("user") String userName);

    @GET("users/{user}/repos")
    Flowable<List<GithubUserRepository>> getGithubUserRepository2(@Path("user") String userName);
}
