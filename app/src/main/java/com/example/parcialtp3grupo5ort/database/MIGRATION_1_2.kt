package com.example.parcialtp3grupo5ort.database

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(db: SupportSQLiteDatabase) {
        // Perform schema changes like adding a new column
        db.execSQL("ALTER TABLE destination_table ADD COLUMN is_favorite INTEGER NOT NULL DEFAULT 0")
    }
}
