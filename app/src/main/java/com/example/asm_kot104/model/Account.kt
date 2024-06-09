package com.example.asm_kot104.model

import java.util.Date

class Account {
    private var _id: String? = null

    var fullName: String? = null
    var email: String? = null
    var password: String? = null
    var birthday: Date? = null

    fun get_id(): String? {
        return _id
    }

    fun set_id(_id: String?) {
        this._id = _id
    }

    constructor(
        _id: String?,
        fullName: String?,
        email: String?,
        password: String?,
        birthday: Date?
    ) {
        this._id = _id
        this.fullName = fullName
        this.email = email
        this.password = password
        this.birthday = birthday
    }

    constructor()
    constructor(_id: String?) {
        this._id = _id
    }
    constructor(email: String?, password: String?) {
        this.email = email
        this.password = password
    }

    constructor(fullName: String?, email: String?, password: String?, birthday: Date?) {
        this.fullName = fullName
        this.email = email
        this.password = password
        this.birthday = birthday
    }
    constructor(fullName: String?, email: String?, password: String?) {
        this.fullName = fullName
        this.email = email
        this.password = password
    }
}