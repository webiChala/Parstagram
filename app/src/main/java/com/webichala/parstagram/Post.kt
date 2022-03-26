package com.webichala.parstagram

import com.parse.ParseClassName
import com.parse.ParseFile
import com.parse.ParseObject
import com.parse.ParseUser

@ParseClassName("Post")
class Post : ParseObject() {

    fun getDescription(): String? {
        return getString(KEY_Description)
    }

    fun setDescription(description: String){
        put(KEY_Description, description)
    }

    fun setImage(parseFile: ParseFile){
        put(KEY_IMAGE, parseFile)
    }

    fun getUser(): ParseUser? {
        return getParseUser(KEY_USER)
    }

    fun setUser(user:ParseUser){
        put(KEY_USER, user)
    }
    companion object{
        const val KEY_Description = "description"
        const val KEY_IMAGE = "image"
        const val KEY_USER = "user"
    }
}