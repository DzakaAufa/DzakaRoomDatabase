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

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: Item)

    @Update
    suspend fun update(item: Item)

    @Delete
    suspend fun delete(item: Item)

    @Query("SELECT * from items WHERE id = :id")
    fun getItem(id: Int): Flow<Item>

    @Query("SELECT * from items ORDER BY name ASC")
    fun getAllItems(): Flow<List<Item>>
}
/**
 * Anotasi @Dao menandakan ini adalah kelas DAO yang dikelola Room
 * Interface 'ItemDao' bertindak sebagai Data Access Object (DAO) untuk entity 'Items'
 * Fungsi DAO adalah menyediakan metode-metode untuk melakukan operasi database (CRUD) pada tabel 'Items'
 */

/**
 * Fungsi 'insert' bertugas untuk menambah data baru ke tabel 'Items'. Ditandai dengan anotasi @Insert yang menandakan operasi penyisipan.
 * Strategi yang digunakan adalah 'OnConflictStrategy.IGNORE' yang berarti jika terjadi konflik, data baru akan diabaikan oleh Room.
 * Sedangkan 'suspend' berarti fungsi ini berjalan secara asynchronous.
 */

/**
 * Fungsi 'update' bertugas untuk memperbarui data yang ada di dalam tabel 'items'. Ditandai dengan anotasi @Update yang menandakan operasi pembaruan pada tabel.
 * Sedangkan 'suspend' berarti fungsi ini berjalan secara asynchronous.
 */

/**
 * Fungsi 'delete' bertugas untuk menghapus data dari tabel 'items'. Ditandai dengan anotasi @Delete yang menandakan operasi penghapusan.
 * Sedangkan 'suspend' berarti fungsi ini berjalan secara asynchronous
 */

/**
 * Fungsi 'getItem' bertugas untuk mengambil satu data 'Item' berdasarkan 'id' nya dalam tabel 'Items'.
 * Anotasi @Query digunakan untuk menuliskan query SQL untuk mengambil data dari tabel
 * Pengembalian 'Flow<Item>' digunakan agar bisa mengamati data secara real-time
 */

/**
 * Fungsi 'getAllItem' bertugas untuk mengambil semua data dari tabel 'Items'.
 * Anotasi @Query digunakan untuk menuliskan query SQL untuk mengambil semua data dari tabel dan diurutkan berdasarkan nama item secara ascending.
 * Pengembalian 'Flow<Item>' digunakan agar bisa mengamati data secara real-time
 */