package com.firebirdhacks.vrslideride;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.widget.Toast;

import com.google.vr.sdk.base.Eye;
import com.google.vr.sdk.base.GvrActivity;
import com.google.vr.sdk.base.GvrView;
import com.google.vr.sdk.base.HeadTransform;
import com.google.vr.sdk.base.Viewport;

import java.io.IOException;

import javax.microedition.khronos.egl.EGLConfig;


public class SlideView extends GvrActivity implements GvrView.StereoRenderer {

    protected float[] mHeadView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide_view);
        GvrView gvrView = (GvrView) findViewById(R.id.gvr_view);
        // Associate a GvrView.StereoRenderer with gvrView.
        gvrView.setRenderer(this);
        // Associate the gvrView with this activity.
        setGvrView(gvrView);

        // Initialize other objects here.
        mHeadView = new float[2];
        mHeadView[0] = 10;
        mHeadView[1] = 10;
    }

    @Override
    public void onNewFrame(HeadTransform headTransform) {


        headTransform.getHeadView(mHeadView, 0);
    }

    @Override
    public void onDrawEye(Eye eye) {
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT | GLES20.GL_DEPTH_BUFFER_BIT);
        // Apply the eye transformation to the camera.
        float [] mView = mHeadView;
        float [] mCamera = mHeadView;
        float [] mLightPosInEyeSpace = mHeadView;
        float [] LIGHT_POS_IN_WORLD_SPACE = mHeadView;
        int Z_NEAR = 0;
        int Z_FAR = 10;
        float [] mModelView = mHeadView;
        float [] mModelCube = mHeadView;
        float [] mModelViewProjection = mHeadView;


        Matrix.multiplyMM(mView, 0, eye.getEyeView(), 0, mCamera, 0);

        // Set the position of the light
        Matrix.multiplyMV(mLightPosInEyeSpace, 0, mView, 0, LIGHT_POS_IN_WORLD_SPACE, 0);

        // Build the ModelView and ModelViewProjection matrices
        // for calculating cube position and light.
        float[] perspective = eye.getPerspective(Z_NEAR, Z_FAR);
        Matrix.multiplyMM(mModelView, 0, mView, 0, mModelCube, 0);
        Matrix.multiplyMM(mModelViewProjection, 0, perspective, 0, mModelView, 0);

        // Draw the rest of the scene.
    }

    @Override
    public void onFinishFrame(Viewport viewport) {

    }

    @Override
    public void onSurfaceChanged(int i, int i1) {

    }

    @Override
    public void onSurfaceCreated(EGLConfig eglConfig) {

    }

    @Override
    public void onRendererShutdown() {

    }
}
