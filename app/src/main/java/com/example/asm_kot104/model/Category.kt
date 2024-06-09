package com.example.asm_kot104.model

import java.io.Serializable


class Category : Serializable {
    var _id: String? = null
    var categoryName: String? = null

    override fun toString(): String {
        return "Category{" +
                "_id='" + _id + '\'' +
                ", categoryName='" + categoryName + '\'' +
                '}'
    }
    constructor()

    constructor(_id: String?, name: String?) {
        this._id = _id
        this.categoryName = name
    }

    constructor(_id: String) {
        this._id = _id
    }
}