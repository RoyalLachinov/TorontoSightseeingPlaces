package ca.com.toronto.utils

import android.content.Context
import android.net.ConnectivityManager

/**
 * Created by Royal_L on 22-Oct-17.
 */
object InternetConnection {
    /**
     * CHECK WHETHER INTERNET CONNECTION IS AVAILABLE OR NOT
     */
    fun checkConnection(context: Context): Boolean {
        return (context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).activeNetworkInfo != null
    }
}
