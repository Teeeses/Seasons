package com.explead.seasons.common.logic

data class LevelField(var level: Int = 0,
                      var field: List<List<Char>> = mutableListOf(),
                      val members: ArrayList<Member> = ArrayList()) {

    fun count(level: Int) = apply {
        this.level = level
    }

    fun field(field: List<List<Char>>) = apply {
        this.field = field
    }

    fun addMember(member: Member) = apply {
        this.members.add(member)
    }
}