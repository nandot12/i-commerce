package com.imastudio.guanzhuli.icart.utils

/**
 * Created by nandoseptianhusni on 27/07/18.
 */
object  Constans {

    val name = "name"
    val photo = "photo"
    val harga = "harga"
    val stock = "stock"
}


///add date utils
object DateUtils {
    const val DATE_FORMAT_YYYY = "yyyy-MM-dd"
    const val DATE_FORMAT_FULL = "EEEE dd MMM yyyy"
    const val DATE_FORMAT_HISTORY = "dd MMMM yyyy"

    fun formatStringToDate(date: String, format: String) : Date{
        val sdf = SimpleDateFormat(format, Locale.getDefault())
        return sdf.parse(date)
    }

    fun formatDateLong(date: Long, destinationFormat: String) : String{
        val sdfDest = SimpleDateFormat(destinationFormat, Locale.getDefault())
        return sdfDest.format(Date(date))
    }

    fun formatDateLongLocale(date: Long, destinationFormat: String) : String{
        val sdfDest = SimpleDateFormat(destinationFormat, Locale("in","ID"))
        return sdfDest.format(Date(date))
    }
    fun formatDateLocale(date: Date, destinationFormat: String) : String{
        val sdfDest = SimpleDateFormat(destinationFormat, Locale("in","ID"))
        return sdfDest.format(date)
    }

}
