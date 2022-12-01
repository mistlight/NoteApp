package com.otakukingdom.notekeeper

import android.os.Parcel
import android.os.Parcelable

class ModuleInfo() : Parcelable {
    var moduleId: String? = null
    var title: String? = null
    var isComplete = false

    constructor(moduleId: String, title: String) : this() {
        this.moduleId = moduleId
        this.title = title
    }

    constructor(moduleId: String, title: String, isComplete: Boolean) : this() {
        this.moduleId = moduleId
        this.title = title
        this.isComplete = isComplete
    }

    constructor(source: Parcel) : this() {
        this.moduleId = source.readString()
        this.title = source.readString()
        this.isComplete = source.readByte() == 1.toByte()
    }

    override fun toString(): String {
        return if (this.title != null) {
            this.title!!
        } else {
            "No Title"
        }
    }

    override fun equals(other: Any?): Boolean {
        if (other == null || javaClass != other.javaClass) return false
        if (this === other) return true

        val that: ModuleInfo = other as ModuleInfo

        return moduleId.equals(that.moduleId)
    }

    override fun hashCode(): Int {
        return this.moduleId.hashCode()
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(this.moduleId)
        dest.writeString(this.title)
        dest.writeByte((if (this.isComplete) 1 else 0).toByte())
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ModuleInfo> {
        override fun createFromParcel(parcel: Parcel): ModuleInfo {
            return ModuleInfo(parcel)
        }

        override fun newArray(size: Int): Array<ModuleInfo?> {
            return arrayOfNulls(size)
        }
    }

}