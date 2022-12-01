package com.otakukingdom.notekeeper

import android.os.Parcel
import android.os.Parcelable

class CourseInfo() : Parcelable {
    var courseId: String? = null
    var title: String? = null
    var modules: List<ModuleInfo> = ArrayList()

    constructor(parcel: Parcel) : this() {
        courseId = parcel.readString()
        title = parcel.readString()
        parcel.readTypedList(modules, ModuleInfo.CREATOR)
    }

    constructor(courseId: String, title: String, modules: List<ModuleInfo>) : this() {
        this.courseId = courseId
        this.title = title
        this.modules = modules
    }

    fun getModulesCompletionStatus(): Array<Boolean> {
        val status = BooleanArray(modules.size).toTypedArray()

        for (i in modules.indices) {
            val moduleInfo: ModuleInfo = modules.get(i)
            status[i] = moduleInfo.isComplete
        }

        return status
    }

    override fun toString(): String {
        return if (title != null) {
            title!!
        } else {
            "No Course Title"
        }
    }

    override fun hashCode(): Int {
        return courseId.hashCode()
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(courseId)
        dest.writeString(title)
        dest.writeTypedList(modules)
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CourseInfo

        if (courseId != other.courseId) return false
        if (title != other.title) return false
        if (modules != other.modules) return false

        return true
    }

    companion object CREATOR : Parcelable.Creator<CourseInfo> {
        override fun createFromParcel(parcel: Parcel): CourseInfo {
            return CourseInfo(parcel)
        }

        override fun newArray(size: Int): Array<CourseInfo?> {
            return arrayOfNulls(size)
        }
    }
}