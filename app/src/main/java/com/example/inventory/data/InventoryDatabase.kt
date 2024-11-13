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

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Item::class], version = 1, exportSchema = false)
abstract class InventoryDatabase : RoomDatabase() {

    abstract fun itemDao(): ItemDao

    companion object {
        @Volatile
        private var Instance: InventoryDatabase? = null

        fun getDatabase(context: Context): InventoryDatabase {
            // if the Instance is not null, return it, otherwise create a new database instance.
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, InventoryDatabase::class.java, "item_database")
                    .build().also { Instance = it }
            }
        }
    }
}
/**
 * Anotasi @Database menunjukkan bahwa kelas ini adalah database Room dengan entitas 'Item'. Terdapat beberapa parameter di dalamnya
 * - entities, yaitu daftar kelas entitas yang digunakan database ini, dalam kasus ini hanya 'Item'.
 * - version, yaitu versi dari database yang digunakan.
 * exportSchema, dalam kasus ini 'false' yang berarti Room tidak akan menympan file skema
 */

/**
 * Kelas 'InventoryDatabase' adalah kelas abstrak yang meng-extend 'RoomDatabase'. kelas ini berfungsi sebagai titik akses utama database room untuk aplikasi
 * Terdapat konfigurasi databse dan instance DAO
 * Fungsi abstrak 'itemDAO' mengembalikan 'ItemDao' bertugas untuk mengakses metode DAO 'ItemDao'.
 */

/**
 * 'companion object' berfungsi untuk membuat singleton 'InventoryDatabase' sehingga hanya ada satu instance database yang digunakan di seluruh aplikasi
 * 'Instance' bertipe 'InventoryDatabase' dan bersifat @Volatile yang memastikan setiap perubahan 'Instance' langsung terlihat oleh semua Thread
 */

/**
 * Fungsi 'getDatabase' untuk mendapatkan instance 'InventoryDatabase' dengan parameter 'context: Context'
 * Pengembalian 'Instance' jika tidak 'null' maka fungsi langsung mengembalikannya, jika 'null' maka akan melakukan sinkronisasi pada 'this' untuk mencegah pengaksesan
 * dibangun instance database baru menggunakan 'Room.databaseBuilder' dengan nama database diatur sebagai 'item_database'
 */

