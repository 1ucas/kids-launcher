package br.com.manobray.testelauncher

import android.app.Application
import android.app.admin.DevicePolicyManager
import android.content.Context

class LauncherApplication : Application() {

    // Allowlist two apps.
    private val KIOSK_PACKAGE = "br.com.manobray.testelauncher"
    private val PLAYER_PACKAGE = "com.example.aaaa"
    private val APP_PACKAGES = arrayOf(KIOSK_PACKAGE, PLAYER_PACKAGE)


    override fun onCreate() {
        super.onCreate()
    }

}