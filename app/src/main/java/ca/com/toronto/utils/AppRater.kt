package ca.com.toronto.utils

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import ca.com.testtutorials.R

/**
 * Created by Royal_L on 20-Nov-17.
 */
object AppRater {
    private const val APP_TITLE = "Toronto Sightseeing Places" // App Name
    private const val APP_NAME = "ca.com.testtutorials" // Package Name
    private const val DAYS_UNTIL_PROMPT = 0 //Min number of days
    private const val LAUNCHES_UNTIL_PROMPT = 0 //Min number of launches
    fun handleAppLaunch(mContext: Context) {
        val prefs = mContext.getSharedPreferences("apprater", 0)
        if (prefs.getBoolean("dontshowagain", false)) {
            return
        }
        val editor = prefs.edit()

        // Increment launch counter
        val launchCount = prefs.getLong("launch_count", 0) + 1
        editor.putLong("launch_count", launchCount)

        // Get date of first launch
        var dateFirstLaunch = prefs.getLong("date_first_launch", 0)
        if (dateFirstLaunch == 0L) {
            dateFirstLaunch = System.currentTimeMillis()
            editor.putLong("date_first_launch", dateFirstLaunch)
        }

        // Wait at least n days before opening
        if (launchCount >= LAUNCHES_UNTIL_PROMPT) {
            if (System.currentTimeMillis() >= dateFirstLaunch + DAYS_UNTIL_PROMPT * 24 * 60 * 60 * 1000) {
                showRateDialog(mContext, editor)
            }
        }
        editor.commit()
    }

    private fun showRateDialog(mContext: Context, editor: SharedPreferences.Editor) {
        val alertDialog = AlertDialog.Builder(mContext).create()
        alertDialog.setTitle(mContext.getString(R.string.rate, APP_TITLE))
        alertDialog.setMessage(mContext.getString(R.string.app_rate_title, APP_TITLE))
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, mContext.getString(R.string.rate, "")) { _, _ ->
            alertDialog.dismiss()
            mContext.startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("market://details?id=$APP_NAME")
                )
            )
        }
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, mContext.getString(R.string.no_thanks)) { _, _ ->
            editor.putBoolean("dontshowagain", true)
            editor.commit()
            alertDialog.dismiss()
        }
        alertDialog.setButton(
            AlertDialog.BUTTON_NEUTRAL,
            mContext.getString(R.string.remind_me_later)
        ) { _, _ -> alertDialog.dismiss() }
        alertDialog.show()
    }
}
