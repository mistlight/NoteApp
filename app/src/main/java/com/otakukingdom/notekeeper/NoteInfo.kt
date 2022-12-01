package com.otakukingdom.notekeeper

class NoteInfo {
    var courseInfo: CourseInfo? = null
    var title: String? = null
    var text: String? = null

    fun getCompareKey(): String {
        if (courseInfo == null || courseInfo!!.courseId == null) {
            return ""
        }
        return courseInfo!!.courseId!! + "|" + title + "|" + text
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        if (other == null || this.javaClass != other.javaClass) {
            return false
        }

        val that = other as NoteInfo
        return this.getCompareKey() == that.getCompareKey()
    }

    override fun toString(): String {
        return getCompareKey()
    }

    override fun hashCode(): Int {
        return getCompareKey().hashCode()
    }

}