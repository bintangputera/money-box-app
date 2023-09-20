package com.bintangpoetra.moneybox.data.savings.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "savings")
data class SavingsEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0,
    @ColumnInfo(name = "nominal")
    val nominal: Int,
    @ColumnInfo(name = "type")
    val type: String,
    @ColumnInfo(name = "notes")
    val notes: String,
    @ColumnInfo(name = "date")
    val date: String
)
