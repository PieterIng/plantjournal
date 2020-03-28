package org.inghelram.plantjournal.dao

import androidx.room.*
import org.inghelram.plantjournal.database.entity.OverviewItem

@Dao
interface OverviewItemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(overviewItem: OverviewItem)

    @Query("SELECT * from overview_item ORDER BY overviewItem ASC")
    fun getOverviewItems(): List<OverviewItem>

    @Query("DELETE FROM overview_item")
    fun deleteAll()

    @Delete
    fun remove(overviewItem: OverviewItem)
}