package com.example.mydemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast

class Login_Screen : AppCompatActivity() {

    lateinit var etUsername: EditText
    lateinit var etpassword: EditText
    lateinit var btnLogin: Button
    lateinit var checkBoxLog: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)

        etUsername = findViewById(R.id.etUser)
        etpassword = findViewById(R.id.etpassword)
        btnLogin = findViewById(R.id.loginBtn)
        checkBoxLog = findViewById(R.id.checkLog)

        logIn()
    }

    private fun logIn() {

        val arr: ArrayList<User> = ArrayList()
        arr.add(User("test@test.com", "12345"))
        arr.add(User("test@gmail.com", "1122334455"))
        arr.add(User("test@outlook.com", "54321"))
        arr.add(User("t@outlook.com", "54"))
        arr.add(User("tes@outlook.com", "521"))
        arr.add(User("te@outlook.com", "4321"))

        btnLogin.setOnClickListener {


            val UserName = etUsername.text.toString()
            val Password = etpassword.text.toString()

            var user = User(UserName, Password)

            for (userArray in arr) {

                if ((userArray.email == user.email
                            && userArray.password == user.password) && checkBoxLog.isChecked  )  {
                 finish()

                   val  i = Intent(this,MainActivity::class.java)
                    startActivity(i)
                    break
                }

            }

            if (!checkBoxLog.isChecked){
                Toast.makeText(this, "Must agreement Terms", Toast.LENGTH_SHORT).show()
            }


            if (etUsername.text.isEmpty() == true) {
                etUsername.error = "Enter Yor Username"

            }else if (etpassword.text.isEmpty() == true) {
                    etpassword.error = ("Enter Yor Password")
                }
            //                else if (checkBoxLog.isChecked== false){
//                Toast.makeText(this, "Agree Of Terms", Toast.LENGTH_SHORT)
//                    .show()
//                }

                }
            }

        }



