package org.polymap.rap.openlayers.demo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.eclipse.rap.rwt.application.AbstractEntryPoint;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

import org.polymap.rap.openlayers.OlWidget;
import org.polymap.rap.openlayers.base.OlEvent;
import org.polymap.rap.openlayers.base.OlEventListener;
import org.polymap.rap.openlayers.base.OlMap;
import org.polymap.rap.openlayers.layer.ImageLayer;
import org.polymap.rap.openlayers.layer.TileLayer;
import org.polymap.rap.openlayers.layer.VectorLayer;
import org.polymap.rap.openlayers.source.GeoJSONSource;
import org.polymap.rap.openlayers.source.ImageWMSSource;
import org.polymap.rap.openlayers.source.ImageWMSSource.RequestParams;
import org.polymap.rap.openlayers.source.MapQuestSource;
import org.polymap.rap.openlayers.style.StrokeStyle;
import org.polymap.rap.openlayers.style.Style;
import org.polymap.rap.openlayers.types.Attribution;
import org.polymap.rap.openlayers.types.Color;
import org.polymap.rap.openlayers.types.Coordinate;
import org.polymap.rap.openlayers.types.Projection;
import org.polymap.rap.openlayers.types.Projection.Units;
import org.polymap.rap.openlayers.view.View;

public class DemoEntryPoint extends AbstractEntryPoint {

	private final static Log log = LogFactory.getLog(DemoEntryPoint.class);

	@Override
	protected void createContents(Composite parent) {
		parent.setLayout(new FillLayout());
		// Composite mainComposite = new Composite(parent, SWT.NONE);
		// mainComposite.setLayout(new RowLayout());

		Composite left = new Composite(parent, SWT.BORDER);
		Composite right = new Composite(parent, SWT.BORDER);
		Composite buttons = new Composite(parent, SWT.BORDER);

		createMap(left);
//      createMap2(right);
//      createButtons(buttons);
	}


//    private void createButtons( Composite parent ) {
//        parent.setLayout( new FillLayout() );
//        Button button = new Button( parent, SWT.PUSH );
//        button.setText( "addScaleLineControlToLeftMap" );
//        button.addSelectionListener( new SelectionListener() {
//            @Override
//            public void widgetSelected( SelectionEvent e ) {
//                map.addControl( new ScaleLineControl( null, null, ScaleLineControl.Units.metric, null ) );
//                view.removeEventListener( View.EVENT.center, listener );
//            }
//            @Override
//            public void widgetDefaultSelected( SelectionEvent e ) {
//                // TODO Auto-generated method stub
//
//            }
//        });
//    }


	private OlWidget createMap( Composite parent ) {
		parent.setLayout( new FillLayout() );
		OlWidget olwidget = new OlWidget(parent, SWT.MULTI | SWT.WRAP | SWT.BORDER);

		// String srs = "EPSG:4326";// Geometries.srs( getCRS() );
		// Projection proj = new Projection(srs);
		// String units = srs.equals("EPSG:4326") ? "degrees" : "m";
		// float maxResolution = srs.equals("EPSG:4326") ? (360 / 256) : 500000;
		// // Bounds maxExtent = new Bounds(12.80, 53.00, 14.30, 54.50);
		// Bounds bounds = new Bounds(11.0, 50.00, 17.30, 64.50);
		// // olwidget1.createMap(proj, proj, units, bounds, maxResolution);
		// // olwidget1.prepare();
		//
		// map1 = new OlMap(olwidget1, proj, proj, units, bounds,
		// maxResolution);
		// // map.updateSize();
		
		OlMap map = new OlMap( olwidget, 
		        new View( newView -> {
		                newView.projection.set( new Projection( "EPSG:3857", Units.m ) );
		                //newView.projection.set( new Projection( "EPSG:4326", Units.degrees ) );
		                //newView.extent.set( new Extent( 12.80, 53.00, 14.30, 54.50 ) ); 
		                newView.zoom.set( 3 ); 
		                newView.center.set( new Coordinate( 0, 0 ) ); } ) );

//        map.addLayer( new TileLayer( newLayer ->
//                newLayer.source.set( new MapQuestSource( MapQuestSource.Type.hyb ) ) ) );

        map.addLayer( new ImageLayer( newLayer -> {
                newLayer.source.set( new ImageWMSSource( source -> {
                        source.url.set( "http://ows.terrestris.de/osm/service/" );
                        source.params.set( new RequestParams( newParams -> {
                                newParams.layers.set( "OSM-WMS" );
                        }));
                }));
                newLayer.opacity.set( 0.5f );
        }));
        
		// //
		// map1.addControl(new NavigationControl(true));
		// map1.addControl(new PanZoomBarControl( ));
		// map1.addControl(new LayerSwitcherControl( ));
		// map1.addControl(new MousePositionControl());
		// // map1.addControl(new ScaleLineControl());
		// map.addControl(new OverviewMapControl(map, layer));

		// map.addControl( new ScaleControl() );
		// map.addControl( new LoadingPanelControl() );

		// map.setRestrictedExtend( maxExtent );
		// map1.zoomToExtent(bounds, true);
		// map1.zoomTo(2);

		// map events
		// HashMap<String, String> payload = new HashMap<String, String>();
		// payload.put( "left", "event.object.getExtent().toArray()[0]" );
		// payload.put( "bottom", "event.object.getExtent().toArray()[1]" );
		// payload.put( "right", "event.object.getExtent().toArray()[2]" );
		// payload.put( "top", "event.object.getExtent().toArray()[3]" );
		// payload.put( "scale", map1.getJSObjRef() + ".getScale()" );
		// map1.events.register( this, OlMap.EVENT_MOVEEND, payload );
		// map1.events.register( this, OlMap.EVENT_ZOOMEND, payload );
        return olwidget;
	}

	private void createMap2(Composite parent) {
        parent.setLayout( new FillLayout() );
        OlWidget olwidget2 = new OlWidget( parent, SWT.MULTI | SWT.WRAP | SWT.BORDER );

        Projection epsg3857 = new Projection( "EPSG:3857", Units.m );
        OlMap map = new OlMap( olwidget2, new View()
                .projection.put( epsg3857 )
                .center.put( new Coordinate( 0, 0 ) )
                .zoom.put( 1 ) );
        
        map.addLayer( new TileLayer()
                .source.put( new MapQuestSource( MapQuestSource.Type.hyb ) ) );
        
		VectorLayer vector = (VectorLayer)new VectorLayer()
		        .style.put( new Style()
                        .stroke.put( new StrokeStyle()
                                .color.put( new Color( 0, 0, 0, 0.5f ) )
                                .width.put( 2f ) ) )
		        .source.put( new GeoJSONSource()
                        .projection.put( epsg3857 )
                        .url.put( "/rwt-resources/demo/polygon-samples.geojson" )
                        .attribution.put( new Attribution( "Steffen Stundzig" ) ) );
		
		map.addLayer( vector );

		// vector.addEventListener(VectorSource.EVENT.addfeature, event ->
		// System.out.println(event.getProperties()));

		// DrawInteraction di = new DrawInteraction(source,
		// GeometryType.LineString);
		// di.addEventListener(DrawInteraction.EVENT.drawstart, event ->
		// System.out.println(event.getProperties()));
		// di.addEventListener(DrawInteraction.EVENT.drawend, event ->
		// System.out.println(event.getProperties()));
		// map2.addInteraction(di);
		// WMSLayer layer = new WMSLayer("OSM2",
		// "http://ows.terrestris.de/osm/service/", "OSM-WMS");
		// layer.setIsBaseLayer(true);
		// map2.addLayer(layer);
		// //
		// map2.addControl(new NavigationControl(true));
		// map.addControl(new LayerSwitcherControl());
		// map.addControl(new ClickControl());
		// map.addControl(new ButtonControl("foo"));
		// map.addControl(new BoxControl());

		//
		// HashMap<String, String> payload = new HashMap<String, String>();
		// map.events.register( this, OlMap.EVENT_MOVEEND, payload );
        OlEventListener listener = new OlEventListener() {
            @Override
            public void handleEvent( OlEvent event ) {
                System.out.println( event.getProperties() );
            }
        };
        map.view.get().addEventListener( View.EVENT.center, listener );
		// view2.addEventListener(View.EVENT.resolution, listener);
		// new OlEventListener() {
		//
		// @Override
		// public void handleEvent(OpenLayersObject src, String name,
		// JsonObject properties) {
		// log.info(this + ": " + name);
		// }
		//
		// }, null);

		// map2.addEventListener(OlMap.EVENT_MOVEEND,
		// new OlEventListener() {
		//
		// @Override
		// public void handleEvent(OpenLayersObject src, String name,
		// JsonObject properties) {
		// log.info(this + ": " + name);
		// }
		//
		// }, null);

	}
}
