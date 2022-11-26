package com.otakukingdom.notekeeper

import android.os.Parcel
import android.os.Parcelable

class CourseInfo() : Parcelable {
    private var mCourseId: String? = null
    private var mTitle: String? = null
    private var mModules: String? = null

    constructor(parcel: Parcel) : this() {
        mCourseId = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
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