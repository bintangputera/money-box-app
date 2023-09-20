package com.bintangpoetra.moneybox.domain.category.mapper

import com.bintangpoetra.moneybox.data.category.local.CategoryEntity
import com.bintangpoetra.moneybox.domain.category.model.Category

fun CategoryEntity.toDomain(): Category {
    return Category(
        this.id,
        this.categoryName
    )
}

fun Category.toEntity(): CategoryEntity {
    return CategoryEntity(
        this.id,
        this.categoryName
    )
}