package com.bintangpoetra.moneybox.data.category.source

import com.bintangpoetra.moneybox.data.category.local.CategoryDao
import com.bintangpoetra.moneybox.data.category.local.CategoryEntity
import kotlinx.coroutines.flow.Flow

class CategoryDataSource(private val dao: CategoryDao) {

    fun getAllCategory(): Flow<List<CategoryEntity>> = dao.getAllCategories()

    suspend fun addNewCategory(categoryEntity: CategoryEntity) {
        dao.addNewCategory(categoryEntity)
    }

}