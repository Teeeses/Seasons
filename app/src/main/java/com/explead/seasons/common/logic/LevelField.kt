package com.explead.seasons.common.logic

data class LevelField<T: Member>(var level: Int = 0,
                      var field: List<List<Char>> = mutableListOf(),
                      val members: ArrayList<T> = ArrayList()) {

    fun count(level: Int) = apply {
        this.level = level
    }

    fun field(field: List<List<Char>>) = apply {
        this.field = field
    }

    fun addMember(member: T) = apply {
        this.members.add(member)
    }
}