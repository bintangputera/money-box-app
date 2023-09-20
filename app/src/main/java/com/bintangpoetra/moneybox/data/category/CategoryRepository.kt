package com.bintangpoetra.moneybox.data.category

import com.bintangpoetra.moneybox.domain.category.model.Category
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {

    fun getAllCategories(): Flow<List<Category>>

    suspend fun addNewCategory(category: Category)

}