package icu.nullptr.hidemyapplist.service

import android.content.Context.MODE_PRIVATE
import icu.nullptr.hidemyapplist.hmaApp

object PrefManager {

    private const val PREF_FILTER_SHOW_SYSTEM = "filter_show_system"
    private const val PREF_FILTER_SORT_METHOD = "filter_sort_method"
    private const val PREF_FILTER_REVERSE_ORDER = "filter_reverse_order"

    enum class SortMethod {
        BY_LABEL, BY_PACKAGE_NAME, BY_INSTALL_TIME, BY_UPDATE_TIME
    }

    private val pref = hmaApp.getSharedPreferences("settings", MODE_PRIVATE)

    var filter_showSystem: Boolean
        get() = pref.getBoolean(PREF_FILTER_SHOW_SYSTEM, false)
        set(value) = pref.edit().putBoolean(PREF_FILTER_SHOW_SYSTEM, value).apply()

    var filter_sortMethod: SortMethod
        get() = SortMethod.values()[pref.getInt(PREF_FILTER_SORT_METHOD, SortMethod.BY_LABEL.ordinal)]
        set(value) = pref.edit().putInt(PREF_FILTER_SORT_METHOD, value.ordinal).apply()

    var filter_reverseOrder: Boolean
        get() = pref.getBoolean(PREF_FILTER_REVERSE_ORDER, false)
        set(value) = pref.edit().putBoolean(PREF_FILTER_REVERSE_ORDER, value).apply()
}