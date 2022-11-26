package com.otakukingdom.notekeeper

import android.os.Parcel
import android.os.Parcelable

class ModuleInfo() : Parcelable {
    private var mModuleId: String? = null
    private var mTitle: String? = null
    private var mIsComplete = false

    constructor(moduleId: String, title: String) : this() {
        this.mModuleId = moduleId
        this.mTitle = title
    }

    constructor(moduleId: String, title: String, isComplete: Boolean) : this() {
        this.mModuleId = moduleId
        this.mTitle = title
        this.mIsComplete = isComplete
    }

    constructor(source: Parcel) : this() {
        this.mModuleId = source.readString()
        this.mTitle = source.readString()
        this.mIsComplete = source.readByte() == 1.toByte()
    }

    override fun toString(): String {
        return if (this.mTitle != null) {
            this.mTitle!!
        } else {
            "No Title"
        }
    }

    override fun equals(other: Any?): Boolean {
        if (other == null || javaClass != other.javaClass) return false
        if (this === other) return true

        val that: ModuleInfo = other as ModuleInfo

        return mModuleId.equals(that.mModuleId)
    }

    override fun hashCode(): Int {
        return this.mModuleId.hashCode()
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(this.mModuleId)
        dest.writeString(this.mTitle)
        dest.writeByte((if (this.mIsComplete) 1 else 0).toByte())
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