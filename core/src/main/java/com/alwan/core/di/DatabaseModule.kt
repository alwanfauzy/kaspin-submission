package com.alwan.core.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.alwan.core.R
import com.alwan.core.data.local.dao.BarangDao
import com.alwan.core.data.local.db.BarangDatabase
import com.alwan.core.data.local.entity.BarangEntity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context,
    ): BarangDatabase {

        return Room.databaseBuilder(context, BarangDatabase::class.java, "barang-database.db")
            .fallbackToDestructiveMigration()
            .createFromAsset("barang-database.db")
            .build()
    }

    @Provides
    fun provideBarangDao(barangDatabase: BarangDatabase) = barangDatabase.barangDao()

    @Provides
    fun provideDatabaseCallback(
        @ApplicationContext context: Context,
    ) = object : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            CoroutineScope(Dispatchers.IO).launch {
                fillWithStartingData(
                    context,
                    provideBarangDao(provideDatabase(context))
                )
            }
        }
    }

    private suspend fun fillWithStartingData(context: Context, dao: BarangDao) {
        val barang = loadJsonArray(context)
        try {
            if (barang != null) {
                for (i in 0 until barang.length()) {
                    val item = barang.getJSONObject(i)
                    dao.insertAll(
                        BarangEntity(
                            item.getString("id"),
                            item.getString("name"),
                            item.getString("description"),
                            item.getInt("stock"),
                            item.getLong("price"),
                            item.getString("imageUrl")
                        )
                    )
                }
            }
        } catch (exception: JSONException) {
            exception.printStackTrace()
        }
    }

    private fun loadJsonArray(context: Context): JSONArray? {
        val builder = StringBuilder()
        val `in` = context.resources.openRawResource(R.raw.barang)
        val reader = BufferedReader(InputStreamReader(`in`))
        var line: String?
        try {
            while (reader.readLine().also { line = it } != null) {
                builder.append(line)
            }
            val json = JSONObject(builder.toString())
            return json.getJSONArray("barangs")
        } catch (exception: IOException) {
            exception.printStackTrace()
        } catch (exception: JSONException) {
            exception.printStackTrace()
        }
        return null
    }
}