package jw.seo.secondgitpj;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import jw.seo.secondgitpj.model.GithubUser;
import jw.seo.secondgitpj.net.ApiConnection;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ApiCallback ApiCallback;

    //test commit
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getGitUser(new ApiCallback() {
            @Override
            public void onResult(GithubUser githubUser) {
                Log.d("onResult", "getGitUser onResult : " + githubUser);
            }
        });

        getGitUser2(githubUser -> Log.d("onResult", " getGitUser2onResult : " + githubUser));

//        setOnApiCallbackListener(new ApiCallback() {
//            @Override
//            public void onResult(GithubUser githubUser) {
//                Log.d("onResult","onResult : " + githubUser);
//            }
//        });

        getGitUser3(githubUser -> {
            Log.d("onResult", " getGitUser3onResult : " + githubUser);
        });
    }

    private void getGitUser(final ApiCallback apiCallback) {
        Call<GithubUser> result = ApiConnection.getInstance().getRetrofitService().getGithubUser("bearkinf");
        result.enqueue(new Callback<GithubUser>() {
            @Override
            public void onResponse(Call<GithubUser> call, Response<GithubUser> response) {
                Log.d("getGitUser", "response.body : " + response.body());
                apiCallback.onResult(response.body());
            }

            @Override
            public void onFailure(Call<GithubUser> call, Throwable t) {
                Log.d("getGitUser", t.getMessage());
            }
        });
    }

    interface ApiCallback {
        void onResult(GithubUser githubUser);
    }

    public void setOnApiCallbackListener(ApiCallback apiCallback) {
        this.ApiCallback = apiCallback;
    }

    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    private void getGitUser2(ApiCallback apiCallback) {
        ApiConnection.getInstance().getUser().subscribe(new Observer<GithubUser>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(GithubUser githubUser) {
                apiCallback.onResult(githubUser);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    private void getGitUser3(ApiCallback apiCallback) {
        Disposable disposable = ApiConnection.getInstance().getRetrofitService().getGithubUser2("bearkinf")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(githubUser -> {
                    apiCallback.onResult(githubUser);
                }, throwable -> {

                });

        mCompositeDisposable.add(disposable);

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mCompositeDisposable.clear();
    }
}