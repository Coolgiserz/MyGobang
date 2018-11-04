package com.geotools.test;

import java.io.File;
import java.io.IOException;

import org.geotools.data.CachingFeatureSource;
import org.geotools.data.FileDataStore;
import org.geotools.data.FileDataStoreFinder;
import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.data.simple.SimpleFeatureSource;
import org.geotools.map.FeatureLayer;
import org.geotools.map.Layer;
import org.geotools.map.MapContent;
import org.geotools.styling.SLD;
import org.geotools.swing.JMapFrame;
import org.geotools.swing.data.JFileDataStoreChooser;
import org.opengis.style.Style;
import org.geotools.data.CachingFeatureSource;

public class HelloTools {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		ShapefileDataStore shp;
        File file = JFileDataStoreChooser.showOpenFile("shp", null);
        if (file == null) {
            return;
        }

        FileDataStore store = FileDataStoreFinder.getDataStore(file);
        SimpleFeatureSource featureSource = store.getFeatureSource();

        // CachingFeatureSource is deprecated as experimental (not yet production ready)
        @SuppressWarnings("deprecation")
		CachingFeatureSource cache = new CachingFeatureSource(featureSource);

        // Create a map content and add our shapefile to it
        MapContent map = new MapContent();
        map.setTitle("Using cached features");
        Style style = SLD.createSimpleStyle(featureSource.getSchema());
        Layer layer = new FeatureLayer(cache, (org.geotools.styling.Style) style);
        map.addLayer(layer);

        // Now display the map
        JMapFrame.showMap(map);
	}

}
