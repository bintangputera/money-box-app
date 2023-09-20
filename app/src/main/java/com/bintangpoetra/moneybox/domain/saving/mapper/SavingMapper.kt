package com.bintangpoetra.moneybox.domain.saving.mapper

import com.bintangpoetra.moneybox.data.savings.local.SavingsEntity
import com.bintangpoetra.moneybox.domain.saving.model.Saving

fun SavingsEntity.toDomain(): Saving {
    return Saving(
        this.id,
        this.nominal,
        this.type,
        this.notes,
        this.date
    )
}

fun Saving.toEntity(): SavingsEntity {
    return SavingsEntity(
        this.id,
        this.nominal,
        this.type,
        this.notes,
        this.date
    )
}

fun List<SavingsEntity>.toDomain(): List<Saving> {
    return this.map {
        it.toDomain()
    }
}