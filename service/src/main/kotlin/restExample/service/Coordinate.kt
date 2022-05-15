package restExample.service

class Coordinate(latitude: Double?, longitude: Double? ) {
    var longitude: Double? = latitude
    var latitude: Double? = longitude

    @JvmName("getLongitude1")
    fun getLongitude(): Double?{
        return this.longitude
    }

    @JvmName("setLongitude1")
    fun setLongitude(longitude: Double?){
        this.longitude = longitude
    }

    @JvmName("getLatitude1")
    fun getLatitude(): Double?{
        return this.latitude
    }

    @JvmName("setLatitude1")
    fun setLatitude(latitude: Double?){
        this.latitude = latitude
    }

}