package com.example.fitnessapp

import org.json.JSONObject

object Database {
    private val data = mutableListOf<JSONObject>()

    fun saveData(jsonObject: JSONObject) {
        data.add(jsonObject)
    }

    fun deleteData(jsonObject: JSONObject) {
        data.remove(jsonObject)
    }

    fun getAllData(): List<JSONObject> {
        return data.toList()
    }
}

//fun main() {
//    val intent: Intent =
//    val data = JSONObject()
//    data.put("a","b")
//    val db = Database.saveData(data)
//    Database.getAllData()
//}

