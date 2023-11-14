package xyz.teamgravity.sharedpreferencesdelegate

import android.content.Context
import android.content.SharedPreferences
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class SharedPreferencesDelegate(
    private val context: Context,
    private val key: String,
    private val defaultValue: String?
) : ReadWriteProperty<Any?, String?> {

    private val shp: SharedPreferences by lazy {
        context.getSharedPreferences("is_this_rebook_or_nike", Context.MODE_PRIVATE)
    }

    override fun getValue(thisRef: Any?, property: KProperty<*>): String? {
        return shp.getString(key, defaultValue) ?: defaultValue
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: String?) {
        shp.edit().putString(key, value).apply()
    }
}

fun Context.sharedPreferences(
    key: String,
    defaultValue: String? = null
): SharedPreferencesDelegate = SharedPreferencesDelegate(
    context = this,
    key = key,
    defaultValue = defaultValue
)