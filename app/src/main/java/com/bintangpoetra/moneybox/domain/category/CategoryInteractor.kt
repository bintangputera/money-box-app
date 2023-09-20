package com.bintangpoetra.moneybox.domain.category

import com.bintangpoetra.moneybox.data.category.CategoryRepository
import com.bintangpoetra.moneybox.domain.category.model.Category
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class CategoryInteractor(
    private val repository: CategoryRepository
): CategoryUseCase {

    override fun getAllCategories(): Flow<List<Category>> {
        return repository.getAllCategories()
            .flowOn(Dispatchers.IO)
    }

    override suspend fun addNewCategory(category: Category) {
        return repository.addNewCategory(category)
    }

}