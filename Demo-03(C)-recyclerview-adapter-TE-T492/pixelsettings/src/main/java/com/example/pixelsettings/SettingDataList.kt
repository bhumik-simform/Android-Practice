package com.example.pixelsettings


val settingList = listOf(
    // Group 1
    SettingModel(itemType = ItemType.TOP, title = "Google", subTitle = "Services & preferences", iconId = R.drawable.ic_google),

    // Group 2
    SettingModel(itemType = ItemType.TOP, title = "Network & internet", subTitle = "Mobile, Wi-Fi, hotspot", iconId = R.drawable.ic_network_internet),
    SettingModel(itemType = ItemType.BOTTOM, title = "Connected devices", subTitle = "Bluetooth, pairing", iconId = R.drawable.ic_connected_devices),

    // Group 3
    SettingModel(itemType = ItemType.TOP, title = "Apps", subTitle = "Assistant, recent apps, default apps", iconId = R.drawable.ic_apps),
    SettingModel(itemType = ItemType.MIDDLE, title = "Notifications", subTitle = "Notification history, conversations", iconId = R.drawable.ic_notifications),
    SettingModel(itemType = ItemType.MIDDLE, title = "Sound & vibration", subTitle = "Volume and haptics", iconId = R.drawable.ic_sound_vibration),
    SettingModel(itemType = ItemType.MIDDLE, title = "Modes", subTitle = "Do Not Disturb, Bedtime, Driving", iconId = R.drawable.ic_modes),
    SettingModel(itemType = ItemType.MIDDLE, title = "Display & touch", subTitle = "Dark theme, font size, touch", iconId = R.drawable.ic_display_touch),
    SettingModel(itemType = ItemType.BOTTOM, title = "Wallpaper & style", subTitle = "Colors, themed icons, app grid", iconId = R.drawable.ic_wallpaper_style),

    // Group 4
    SettingModel(itemType = ItemType.TOP, title = "Storage", subTitle = "52% used - 3.84 GB free", iconId = R.drawable.ic_storage),
    SettingModel(itemType = ItemType.BOTTOM, title = "Battery", subTitle = "Charged", iconId = R.drawable.ic_battery),

    // Group 5
    SettingModel(itemType = ItemType.TOP, title = "System", subTitle = "Languages, gestures, time", iconId = R.drawable.ic_system),
    SettingModel(itemType = ItemType.BOTTOM, title = "About emulated device", subTitle = "sdk_gphone16k_x86_64", iconId = R.drawable.ic_about_emulated_device),

    // Group 6
    /*Find icon*/SettingModel(itemType = ItemType.TOP, title = "Security & privacy", subTitle = "App security, device lock, permissions", iconId = R.drawable.ic_google),
    SettingModel(itemType = ItemType.MIDDLE, title = "Location", subTitle = "On / 5 apps have access to location", iconId = R.drawable.ic_location),
    SettingModel(itemType = ItemType.MIDDLE, title = "Passwords & passkeys", subTitle = "Suggestions for sign-in & autofill", iconId = R.drawable.ic_passwords_passkeys),
    SettingModel(itemType = ItemType.MIDDLE, title = "Accounts and backup", subTitle = "Back up data, copy data from another device", iconId = R.drawable.ic_accounts_and_backup),
    SettingModel(itemType = ItemType.MIDDLE, title = "Digital Wellbeing", subTitle = "Screen time, app timers, bedtime schedules", iconId = R.drawable.ic_digital_wellbeing),
    /*Find icon*/SettingModel(itemType = ItemType.MIDDLE, title = "Parental controls", subTitle = "Digital ground rules & screen time limits", iconId = R.drawable.ic_google),
    /*Find icon*/SettingModel(itemType = ItemType.BOTTOM, title = "Safety & emergency", subTitle = "Emergency SOS, medical info, alerts", iconId = R.drawable.ic_google),

    // Group 7 (Standalone cards)
    SettingModel(itemType = ItemType.TOP, title = "Accessibility", subTitle = "Display, interaction, audio", iconId = R.drawable.ic_accessibility),
    /*Find icon*/SettingModel(itemType = ItemType.BOTTOM, title = "Tips & support", subTitle = "Help articles, phone & chat", iconId = R.drawable.ic_google)
)