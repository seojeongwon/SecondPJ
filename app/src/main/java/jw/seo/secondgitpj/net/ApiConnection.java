package jw.seo.secondgitpj.net;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import jw.seo.secondgitpj.model.GithubUser;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiConnection {

    private Retrofit mRetrofit;
    private final String baseUrl = "https://api.github.com";

    /**
     * 생성자.
     */
    private ApiConnection() {

        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();

        this.mRetrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                // 내려받는 데이터를 gson 형식으로 데이터 변환
                .addConverterFactory(GsonConverterFactory.create())
                // RxJava 를 사용하게되면 해당 아답터팩토리를 등록해야 한다.
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(httpClient)
                .build();
    }

    /**
     * 2. 싱글턴 패턴 구현.
     */
    private static final ApiConnection INSTANCE = new ApiConnection();

    public static ApiConnection getInstance() {
        return INSTANCE;
    }

    /**
     * interface  리턴.
     */
    public GithubService getRetrofitService() {
        return mRetrofit.create(GithubService.class);
    }


//    ---------------------------------------------------------------------
    public Observable<GithubUser> getUser() {
        return  getRetrofitService()
                .getGithubUser2("bearkinf")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
