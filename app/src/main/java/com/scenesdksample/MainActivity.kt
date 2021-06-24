package com.scenesdksample

import android.net.Uri
import android.os.Bundle
import android.text.Html
import android.text.Spanned
import android.view.MotionEvent
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.google.ar.core.Anchor
import com.google.ar.core.HitResult
import com.google.ar.core.Plane
import com.google.ar.sceneform.AnchorNode
import com.google.ar.sceneform.rendering.ModelRenderable
import com.google.ar.sceneform.rendering.Renderable
import com.google.ar.sceneform.ux.ArFragment
import com.google.ar.sceneform.ux.TransformableNode
import com.scenesdksample.adapter.ArItemPlaceObjectAdapter
import com.scenesdksample.databinding.ActivityMainBinding
import com.scenesdksample.model.PlaceObjectBean

class MainActivity : AppCompatActivity() {

    private var fragment: ArFragment? = null
    private var selectedObject: Uri? = null
    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
        registerCameraOnTapListener()
        showAppUsageAlert()
    }

    //Initial setup for View
    private fun init() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        fragment =
            supportFragmentManager.findFragmentById(R.id.fragment_camera_preview) as ArFragment?
        initAdapterData()
    }

    //Registered scene tapped listener
    private fun registerCameraOnTapListener() {
        fragment!!.setOnTapArPlaneListener { hitResult: HitResult, plane: Plane, _: MotionEvent? ->
            if (plane.type != Plane.Type.HORIZONTAL_UPWARD_FACING) {
                return@setOnTapArPlaneListener
            }
            val anchor = hitResult.createAnchor()
            placeObject(fragment, anchor, selectedObject)
        }
    }

    //App usage step dialog
    private fun showAppUsageAlert() {
        AlertDialog.Builder(this)
            .setMessage(fromHtml(resources.getString(R.string.app_help_message)))
            .setPositiveButton(resources.getString(android.R.string.ok), null)
            .show()
    }

    //Initial data setup for showing list of objects
    private fun initAdapterData() {
        val list = mutableListOf<PlaceObjectBean>()
        list.add(PlaceObjectBean(R.drawable.chair_thumb, Uri.parse("chair.sfb")))
        list.add(PlaceObjectBean(R.drawable.couch_thumb, Uri.parse("couch.sfb")))

        //set default selection of object
        selectedObject = list[0].uri

        val userAdapter = ArItemPlaceObjectAdapter(this, list) { placeObject ->
            selectedObject = placeObject.uri
        }
        binding?.rlvImagesPreview?.adapter = userAdapter
    }

    //This function can be use for render object over camera surface by passing object uri
    private fun placeObject(
        fragment: ArFragment?,
        anchor: Anchor,
        model: Uri?
    ) {
        ModelRenderable.builder()
            .setSource(fragment!!.context, model)
            .build()
            .thenAccept { renderable: ModelRenderable ->
                addNodeToScene(
                    fragment,
                    anchor,
                    renderable
                )
            }
            .exceptionally { throwable: Throwable ->
                val builder =
                    AlertDialog.Builder(this)
                builder.setMessage(throwable.message)
                    .setTitle(resources.getString(R.string.error))
                val dialog = builder.create()
                dialog.show()
                null
            }

    }

    //To use for add node to scene
    private fun addNodeToScene(
        fragment: ArFragment?,
        anchor: Anchor,
        renderable: Renderable
    ) {
        val anchorNode =
            AnchorNode(anchor)
        val node = TransformableNode(fragment!!.transformationSystem)
        node.renderable = renderable
        node.setParent(anchorNode)
        fragment.arSceneView.scene.addChild(anchorNode)
        node.select()
    }

    //To use show string content in html form
    private fun fromHtml(source: String?): Spanned? {
        return Html.fromHtml(source, Html.FROM_HTML_MODE_LEGACY)
    }

    override fun onBackPressed() {
        exitConfirmationAlert()
    }

    //To use show confirmation dialog for exit app
    private fun exitConfirmationAlert() {
        val builder = AlertDialog.Builder(this)
        builder.setMessage(getString(R.string.are_you_sure_want_to_exit))
            .setCancelable(false)
            .setPositiveButton(getString(R.string.yes)) { _, _ -> this@MainActivity.finish() }
            .setNegativeButton(getString(R.string.no)) { dialog, _ -> dialog.cancel() }
        val alert = builder.create()
        alert.show()
    }
}