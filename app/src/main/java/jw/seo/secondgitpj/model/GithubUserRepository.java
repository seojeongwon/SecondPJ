package jw.seo.secondgitpj.model;

public class GithubUserRepository {

    private String name;
    private String html_url;
    private String language;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "GithubUserRepository{" +
                "name='" + name + '\'' +
                ", html_url='" + html_url + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}
