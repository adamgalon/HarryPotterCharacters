package com.example.harrypottercaracters.data.local
//
//import android.content.Context
//import androidx.room.Database
//import androidx.room.Room
//import androidx.room.RoomDatabase
//import com.example.harrypottercaracters.data.models.CharactersItem
//
//@Database(entities = [CharactersItem::class], version = 1, exportSchema = false)
//abstract class AppDatabase : RoomDatabase() {
//
//    abstract fun charactersDao(): CharactersDao
//
//    companion object {
//        @Volatile
//        private var instance: AppDatabase? = null
//
//        fun getDatabase(context: Context): AppDatabase {
//            return instance ?: synchronized(this) {
//                instance ?: buildDatabase(context).also { instance = it }
//            }
//        }
//        private fun buildDatabase(context: Context) =
//            Room.databaseBuilder(
//                context,
//                AppDatabase::class.java,
//                "characters"
//            ).build()
//
//    }
//}