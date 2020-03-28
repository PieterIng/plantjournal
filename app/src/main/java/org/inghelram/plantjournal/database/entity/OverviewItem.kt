package org.inghelram.plantjournal.database.entity

import androidx.room.*
import com.google.gson.Gson

@TypeConverters()
@Entity(tableName = "overview_item")
class OverviewItem (@PrimaryKey @ColumnInfo(name = "overviewItem") val overviewItem: OverviewItem)

class OverviewItemConverter {
    @TypeConverter
    fun fromOverviewItem(overviewItem: OverviewItem): String {
        val gson = Gson()
        return gson.toJson(overviewItem)
    }

    @TypeConverter
    fun toOverviewItem(overviewItem: String): OverviewItem {
        val gson = Gson()
        return gson.fromJson(overviewItem, OverviewItem::class.java)
    }
}