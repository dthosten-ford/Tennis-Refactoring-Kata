package com.ford.xapi.models.response
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.ford.xapi.database.StatusConverter
import com.ford.xapi.database.VehicleDetailConverter

@Entity(tableName = "user_vehicles_data")
@TypeConverters(VehicleDetailConverter::class, StatusConverter::class)
data class UserVehicles(
        @PrimaryKey
        val key: String = DATABASE_KEY,
        val status: Status? = null,
        val vehicleDetails: List<VehicleDetail?>? = null
) {
    companion object {
        const val DATABASE_KEY = "AuthDatabaseKey"
    }
}