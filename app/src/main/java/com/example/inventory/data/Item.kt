/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.inventory.data

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Entity data class represents a single row in the database.
 */
@Entity(tableName = "items")
data class Item(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val price: Double,
    val quantity: Int
)
/**
 * Anotasi @Entity menunjukkan bahwa kelas ini adalah tabel dalam database, sedangkan tableName menentukan nama
 * tabel dalam database yaitu 'items'
 * Data class Item merepresentasikan tabel 'items' dalam database menggunakan room.
 */

/**
 * data class items berisi primary key dari tabel dengan parameter autoGenerate = true
 * yang berarti nilai 'id' akan diisi secara otomatis oleh database.
 * Terdapat variabel lain seperti 'name' bertipe String, 'price' bertipe Double, dan 'quantity' bertipe Integer
 * yang mewakili kolom pada tabel yaitu nama item, harga item, dan jumlah item.
 */