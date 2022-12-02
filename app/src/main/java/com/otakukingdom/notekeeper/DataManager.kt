package com.otakukingdom.notekeeper

class DataManager {
    val mCourses: MutableList<CourseInfo> = ArrayList()
    val mNotes: MutableList<NoteInfo> = ArrayList()

    companion object {
        var instance: DataManager? = null
            get() {
                if (field == null) {
                    field = DataManager()
                }

                return field
            }
    }

    fun getCurrentUserName(): String {
        return "Jim Wilson"
    }

    fun getCurrentUserEmail(): String {
        return "jimw@jwhh.com"
    }

    fun getNotes(): MutableList<NoteInfo> {
        return mNotes
    }

    fun createNewNote(): Int {
        val newNote = NoteInfo(null, null, null)
        mNotes.add(newNote)
        return mNotes.size - 1
    }
}