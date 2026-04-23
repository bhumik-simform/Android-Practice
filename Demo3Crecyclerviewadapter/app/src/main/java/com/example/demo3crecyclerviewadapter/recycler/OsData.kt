package com.example.demo3crecyclerviewadapter.recycler

import com.example.demo3crecyclerviewadapter.R

data class MyOS (
    val name: String,
    val year: String,
    val imgId: Int,
    val message: String
)
val osList = listOf(
    MyOS("Android", "2008", R.drawable.ic_android,"Made by Google"),
    MyOS("iOS", "2007", R.drawable.ic_ios,"Made by Apple"),
    MyOS("Ubuntu", "2004", R.drawable.ic_ubuntu, "Made by Canonical"),
    MyOS("Windows", "1985", R.drawable.ic_windows, "Made by Microsoft"),
    MyOS("macOS", "2001", R.drawable.ic_macos,"Made by Apple"),
    MyOS("BlackBerry OS", "1999", R.drawable.ic_blackberry,"Made by Black Berry"),
    MyOS("Linux", "1991", R.drawable.ic_linux, "Made by OG........."),
    MyOS("Chrome OS", "2011", R.drawable.ic_chrome_os,"Made by Google"),
    MyOS("Android", "2008", R.drawable.ic_android,"Made by Google"),
    MyOS("iOS", "2007", R.drawable.ic_ios,"Made by Apple"),
    MyOS("Ubuntu", "2004", R.drawable.ic_ubuntu, "Made by Canonical"),
    MyOS("Windows", "1985", R.drawable.ic_windows, "Made by Microsoft"),
    MyOS("macOS", "2001", R.drawable.ic_macos,"Made by Apple"),
    MyOS("BlackBerry OS", "1999", R.drawable.ic_blackberry,"Made by Black Berry"),
    MyOS("Linux", "1991", R.drawable.ic_linux, "Made by OG........."),
    MyOS("Chrome OS", "2011", R.drawable.ic_chrome_os,"Made by Google"),
    MyOS("Android", "2008", R.drawable.ic_android,"Made by Google"),
    MyOS("iOS", "2007", R.drawable.ic_ios,"Made by Apple"),
    MyOS("Ubuntu", "2004", R.drawable.ic_ubuntu, "Made by Canonical"),
    MyOS("Windows", "1985", R.drawable.ic_windows, "Made by Microsoft"),
    MyOS("macOS", "2001", R.drawable.ic_macos,"Made by Apple"),
    MyOS("BlackBerry OS", "1999", R.drawable.ic_blackberry,"Made by Black Berry"),
    MyOS("Linux", "1991", R.drawable.ic_linux, "Made by OG........."),
    MyOS("Chrome OS", "2011", R.drawable.ic_chrome_os,"Made by Google")
)