package jw.seo.secondgitpj.model;

public class GithubUser {

    private String login;
    private String url;
    private String name;
    private String location;
    private String repos_url;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRepos_url() {
        return repos_url;
    }

    public void setRepos_url(String repos_url) {
        this.repos_url = repos_url;
    }

    @Override
    public String toString() {
        return "GithubUser{" +
                "login='" + login + '\'' +
                ", url='" + url + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", repos_url='" + repos_url + '\'' +
                '}';
    }
}
