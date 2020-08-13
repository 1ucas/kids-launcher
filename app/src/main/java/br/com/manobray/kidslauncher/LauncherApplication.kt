package br.com.manobray.kidslauncher

import android.app.Application

class LauncherApplication : Application() {

    // Allowlist two apps.
    private val KIOSK_PACKAGE = "br.com.manobray.kidslauncher"
    private val PLAYER_PACKAGE = "com.example.aaaa"
    private val APP_PACKAGES = arrayOf(KIOSK_PACKAGE, PLAYER_PACKAGE)


    override fun onCreate() {
        super.onCreate()
    }

}