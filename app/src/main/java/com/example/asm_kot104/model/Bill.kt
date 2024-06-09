package com.example.asm_kot104.model


class Bill {
    private var _id: String? = null
    var date: String? = null
    var total: String? = null
    var sum: String? = null
    var accountEmail: Account? = null

    fun get_id(): String? {
        return _id
    }

    fun set_id(_id: String?) {
        this._id = _id
    }

    constructor()

    constructor(_id: String?, date: String?, total: String?, sum: String?, accountEmail: Account?) {
        this._id = _id
        this.date = date
        this.total = total
        this.sum = sum
        this.accountEmail = accountEmail
    }
}