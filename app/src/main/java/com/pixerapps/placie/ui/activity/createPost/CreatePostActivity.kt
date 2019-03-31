package com.pixerapps.placie.ui.activity.createPost

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.pixerapps.placie.R
import com.pixerapps.placie.mvp.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_create_post.*

class CreatePostActivity : BaseMvpActivity<CreatePostContract.View, CreatePostPresenter>(),
    CreatePostContract.View, View.OnClickListener {

    override var presenter: CreatePostPresenter = CreatePostPresenter()
    var postTitle: EditText? = null
    var postBody: EditText? = null
    lateinit var toolbar: Toolbar
    val PICK_IMAGE_REQUEST : Int = 71
    lateinit var imageUri : Uri

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_post)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        window.statusBarColor = Color.WHITE

        postTitle = findViewById(R.id.post_title)
        postBody = findViewById(R.id.post_body)
        toolbar = findViewById(R.id.toolbar)

        setToolbar()

        create_post.setOnClickListener(this)
        upload_image.setOnClickListener(this)
    }

    override fun setToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        toolbar.title = "Post your thought"
        toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.grey_800))
        toolbar.setTitleTextAppearance(this, R.style.futuraTextAppearance)

    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item!!.itemId==android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.create_post -> {
                if (postBody!!.text.length > 3) {
                    presenter.createPost(
                        this,
                        postTitle!!.text.toString(),
                        postBody!!.text.toString(),
                        imageUri,
                        false
                    )
                } else Toast.makeText(this, "Please write something useful", Toast.LENGTH_LONG).show()
            }

            R.id.upload_image->{
                chooseImage()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data?.data!=null){
            imageUri=data.data!!
            image_preview.setImageURI(imageUri)
        }
    }


    fun chooseImage(){
        var i = Intent()
        i.type = "image/*"
        i.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(i,"select image"),PICK_IMAGE_REQUEST)
    }
}