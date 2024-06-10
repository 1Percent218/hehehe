package com.example.asm_kot104.model

import java.io.Serializable


class Product : Serializable {
    var _id: String? = null
    var name: String? = null
    var price: Int = 0

    override fun toString(): String {
        return "Product{" +
                "_id='" + _id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", images=" + images +
                ", description='" + description + '\'' +
                ", categoryId=" + categoryId +
                '}'
    }

    var images: List<String>? = null
    var description: String? = null
    var categoryId: Category? = null

    constructor()
    constructor(_id: String?) {
        this._id = _id
    }

    constructor(
        _id: String?,
        name: String?,
        price: Int,
        images: List<String>?,
        description: String?,
        categoryId: Category?
    ) {
        this._id = _id
        this.name = name
        this.price = price
        this.images = images
        this.description = description
        this.categoryId = categoryId
    }
}