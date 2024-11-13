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

package com.example.inventory

import android.app.Application
import com.example.inventory.data.AppContainer
import com.example.inventory.data.AppDataContainer

class InventoryApplication : Application() {

    /**
     * AppContainer instance used by the rest of classes to obtain dependencies
     */
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}
/**
 * Kelas 'InventoryApplication' meng-extend 'Application()'
 * Kelas ini adalah titik masuk utama aplikasi juga mengatur dependensi yang diperlukan kelas lain
 */
/**
 * Terdapat 'container' yang merupakan instance dari 'AppContainer' dengan sifat lateinit karena diinisialisasi dalam metode 'onCreate'
 * 'onCreate' dipanggil saat aplikasi pertama kali dijalankan. Kemudian 'container' diinisialisasi dengan 'AppDataContainer(this)'
 * yang membuat instance dari 'AppContainer'
 */