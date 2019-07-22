package com.ieeeanku.talkieee.Services

import com.google.firebase.auth.FirebaseAuth
import java.lang.Exception

private val auth = FirebaseAuth.getInstance()

class AuthService {
    companion object {
        val instance = AuthService()
    }

    fun emailSign(email: String, password: String, handler: (success: Boolean, error: Exception?) -> Unit) {
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                handler(true, null)
            } else {
                handler(false, task.exception)
            }
        }
    }

    fun emailLogin(email: String, password: String, handler: (success: Boolean, error: Exception?) -> Unit) {
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                handler(true, null)
            } else {
                handler(false, task.exception)
            }
        }
    }

    fun sendVerificationMail(email: String, handler: (success: Boolean) -> Unit) {
        auth.currentUser?.sendEmailVerification()?.addOnCompleteListener { task ->
            if (task.isSuccessful) {
                handler(true)
            } else {
                handler(false)
            }
        }
    }

    fun updateEmail(email: String, handler: (success: Boolean) -> Unit) {
        auth.currentUser?.updateEmail(email)?.addOnCompleteListener { task ->
            if (task.isSuccessful) {
                handler(true)
            } else {
                handler(false)
            }
        }
    }

    fun updatePassword(password: String, handler: (success: Boolean) -> Unit) {
        auth.currentUser?.updatePassword(password)?.addOnCompleteListener { task ->
            if (task.isSuccessful) {
                handler(true)
            } else {
                handler(false)
            }
        }
    }

    fun sendPasswordResetMail(email: String, handler: (success: Boolean) -> Unit) {
        auth.sendPasswordResetEmail(email).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                handler(true)
            } else {
                handler(false)
            }
        }
    }

    fun deleteUser(handler: (success: Boolean) -> Unit) {
        auth.currentUser?.delete()?.addOnCompleteListener { task ->
            if (task.isSuccessful) {
                handler(true)
            } else {
                handler(false)
            }
        }
    }
}