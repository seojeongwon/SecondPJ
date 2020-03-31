package jw.seo.kotlin.ex01.model

data class GithubUser(
        var login: String,
        var url: String,
        var name: String,
        var location: String,
        var repos_url: String
)