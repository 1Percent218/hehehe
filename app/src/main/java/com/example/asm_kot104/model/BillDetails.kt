package com.example.asm_kot104.model


class BillDetails {
    private var _id: String? = null
    var billId: String? = null
    var productId: Product? = null
    var quantity: Int = 0

    fun get_id(): String? {
        return _id
    }

    fun set_id(_id: String?) {
        this._id = _id
    }

    constructor()

    constructor(_id: String?, billId: String?, productId: Product?, quantity: Int) {
        this._id = _id
        this.billId = billId
        this.productId = productId
        this.quantity = quantity
    }
}