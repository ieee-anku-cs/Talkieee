package com.ieeeanku.talkieee.Services

import android.util.Log
import com.google.firebase.database.*

private val DB_BASE = FirebaseDatabase.getInstance().reference

class DataService {
    companion object {
        val instance = DataService()
    }

    private val TAG = "DataService"

    private val users = DB_BASE.child("users")
    private val chats = DB_BASE.child("chats")
    private val feed = DB_BASE.child("feed")

    fun registerUser(uid: String, userData: Map<String, Any>) {
        users.child(uid).updateChildren(userData)
    }

    fun getUserInfo(uid: String) {
        users.addListenerForSingleValueEvent(object: ValueEventListener {
            override fun onDataChange(p0: DataSnapshot) {
                val dataSnapshot = p0.children

                for (data in dataSnapshot) {
                    if (data.key == uid) {
                        Log.e(TAG, data.child("name").value as String)
                    }
                }
            }

            override fun onCancelled(p0: DatabaseError) {
            }

        })
    }
}