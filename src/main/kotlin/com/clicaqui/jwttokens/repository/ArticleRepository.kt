package com.clicaqui.jwttokens.repository

import com.clicaqui.jwttokens.model.Article
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class ArticleRepository {
        private val articles = listOf(
                Article(id = UUID.randomUUID(), title = "Test", description = "testando"),
                Article(id = UUID.randomUUID(), title = "Test2", description = "testando2"),
                Article(id = UUID.randomUUID(), title = "Test3", description = "testando3"),
                Article(id = UUID.randomUUID(), title = "Test4", description = "testando4"),
        )

        fun findAll(): List<Article> =
                articles
}