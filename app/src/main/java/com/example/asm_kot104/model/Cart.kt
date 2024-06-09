package com.example.asm_kot104.model


class Cart {
    var _id: String? = null
    var idAccount: String? = null
    var idProduct: Product? = null
    var quantity: Int = 0

    constructor(idProduct: Product?, quantity: Int) {
        this.idProduct = idProduct
        this.quantity = quantity
    }

    constructor()

    constructor(_id: String?, idAccount: String?, idProduct: Product?, quantity: Int) {
        this._id = _id
        this.idAccount = idAccount
        this.idProduct = idProduct
        this.quantity = quantity
    }
    constructor(idAccount: String?, idProduct: Product?, quantity: Int) {
        this.idAccount = idAccount
        this.idProduct = idProduct
        this.quantity = quantity
    }
}