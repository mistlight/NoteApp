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

    fun getCourse(id: String): CourseInfo? {
        for (course in mCourses) {
            if (id == course.courseId) {
                return course
            }
        }

        return null
    }

    fun getNotes(course: CourseInfo): List<NoteInfo> {
        val notes: ArrayList<NoteInfo> = ArrayList()
        for (note in mNotes) {
            if (course == note.courseInfo) {
                notes.add(note)
            }
        }
        return notes
    }

    fun getNoteCount(course: CourseInfo): Int {
        var count = 0
        for (note in mNotes) {
            if (course == note.courseInfo) {
                count++
            }
        }

        return count
    }

    fun createNewNote(): Int {
        val newNote = NoteInfo(null, null, null)
        mNotes.add(newNote)
        return mNotes.size - 1
    }
}