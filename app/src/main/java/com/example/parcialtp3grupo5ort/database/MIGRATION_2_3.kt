package com.example.parcialtp3grupo5ort.database

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val MIGRATION_2_3 = object : Migration(2, 3) {
    override fun migrate(db: SupportSQLiteDatabase) {
        db.execSQL("""
            CREATE TABLE offer_table (
                id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
                discount TEXT NOT NULL,
                is_favorite INTEGER NOT NULL
            )
        """)
    }
}