package com.bintangpoetra.moneybox.data.category

import com.bintangpoetra.moneybox.data.category.source.CategoryDataSource
import com.bintangpoetra.moneybox.domain.category.mapper.toDomain
import com.bintangpoetra.moneybox.domain.category.mapper.toEntity
import com.bintangpoetra.moneybox.domain.category.model.Category
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CategoryDataStore(
    private val db: CategoryDataSource
): CategoryRepository {

    override fun getAllCategories(): Flow<List<Category>> = flow {
        db.getAllCategory().collect { category ->
            val categories = mutableListOf<Category>()
            category.forEach {
                categories.add(it.toDomain())
            }
            emit(categories)
        }
    }

    override suspend fun addNewCategory(category: Category) {
        db.addNewCategory(category.toEntity())
    }

}