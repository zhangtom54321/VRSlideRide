package com.firebirdhacks.vrslideride;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.vr.sdk.widgets.pano.VrPanoramaView;

public class SlideView extends android.support.v4.app.Fragment {

    private VrPanoramaView panoWidgetView;
    private ImageLoaderTask backgroundImageLoaderTask;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = null;
        if (panoWidgetView != null) {
            ViewGroup parent = (ViewGroup) panoWidgetView.getParent();
            if (parent != null)
                parent.removeView(panoWidgetView);
        }
        try {
            v = inflater.inflate(R.layout.activity_slide_view, container, false);
        } catch (InflateException e) {
        /* map is already there, just return view as it is */
        }

        //View v =  inflater.inflate(R.layout.activity_slide_view, container,false);
        panoWidgetView = (VrPanoramaView) v.findViewById(R.id.slide_view);
        return v;
    }
    public void onPause() {
        panoWidgetView.pauseRendering();
        super.onPause();
    }

    @Override
    public void onResume() {
        panoWidgetView.resumeRendering();
        super.onResume();
    }

    /*@Override
    public void onDestroy() {
        // Destroy the widget and free memory.
        panoWidgetView.shutdown();
        super.onDestroy();
    }*/

    private synchronized void loadPanoImage() {
        ImageLoaderTask task = backgroundImageLoaderTask;
        if (task != null && !task.isCancelled()) {
            // Cancel any task from a previous loading.
            task.cancel(true);
        }

        // pass in the name of the image to load from assets.
        VrPanoramaView.Options viewOptions = new VrPanoramaView.Options();
        viewOptions.inputType = VrPanoramaView.Options.TYPE_STEREO_OVER_UNDER;

        // use the name of the image in the assets/ directory.
        String panoImageName = "My-Pano-Test-Mirrored.jpg";

        // create the task passing the widget view and call execute to start.
        task = new ImageLoaderTask(panoWidgetView, viewOptions, panoImageName);
        task.execute(getActivity().getAssets());
        backgroundImageLoaderTask = task;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loadPanoImage();
    }

}
