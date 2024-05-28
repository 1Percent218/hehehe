package com.example.asm_kot104.model

import java.io.Serializable

class Product(
    var _id: String,
    var name: String,
    var price: Int,
    var images: List<String>,
    var description: String,
    var categoryId: Category
) : Serializable {
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
}
