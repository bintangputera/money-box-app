package com.bintangpoetra.moneybox.domain.category

import com.bintangpoetra.moneybox.domain.category.model.Category
import kotlinx.coroutines.flow.Flow

interface CategoryUseCase {

    fun getAllCategories(): Flow<List<Category>>

    suspend fun addNewCategory(category: Category)

}