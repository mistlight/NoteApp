package com.otakukingdom.notekeeper

class DataManager {
    companion object {
        var instance: DataManager? = null
            get() {
                if (field == null) {
                    field = DataManager()
                }

                return field
            }
    }

}