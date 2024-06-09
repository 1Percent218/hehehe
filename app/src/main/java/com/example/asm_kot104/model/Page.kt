package com.example.asm_kot104.model


class Page<T> {
    private var data: T? = null
    var currentPage: Int = 0
    var totalPage: Int = 0

    constructor()

    fun getData(): T? {
        return data
    }

    fun setData(data: T) {
        this.data = data
    }

    constructor(data: T, currentPage: Int, totalPage: Int) {
        this.data = data
        this.currentPage = currentPage
        this.totalPage = totalPage
    }
}