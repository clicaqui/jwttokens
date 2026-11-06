package com.clicaqui.jwttokens.service

import com.clicaqui.jwttokens.model.Article
import com.clicaqui.jwttokens.repository.ArticleRepository
import org.springframework.stereotype.Service

@Service
class ArticleService(
    private val articleRepository: ArticleRepository
) {
    fun findAll(): List<Article>
    = articleRepository.findAll()
}