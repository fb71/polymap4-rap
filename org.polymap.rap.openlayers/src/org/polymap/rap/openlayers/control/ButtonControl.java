///*
// * polymap.org
// * Copyright 2009, Polymap GmbH, and individual contributors as indicated
// * by the @authors tag.
// *
// * This is free software; you can redistribute it and/or modify it
// * under the terms of the GNU Lesser General Public License as
// * published by the Free Software Foundation; either version 3 of
// * the License, or (at your option) any later version.
// *
// * This software is distributed in the hope that it will be useful,
// * but WITHOUT ANY WARRANTY; without even the implied warranty of
// * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// * Lesser General Public License for more details.
// *
// * You should have received a copy of the GNU Lesser General Public
// * License along with this software; if not, write to the Free
// * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
// * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
// *
// */
//
//package org.polymap.rap.openlayers.control;
//
///**
// * 
// * @author Marcus -LiGi- B&uuml;schleb < mail: ligi (at) polymap (dot) de >
// * @author <a href="http://stundzig.it">Steffen Stundzig</a>
// * 
// */
//public class ButtonControl extends Control {
//
//    private String display_class="";
//    
//	public ButtonControl(String display_class) {
//	    this.display_class=display_class;
//		super.create("new OpenLayers.Control.Button( {  displayClass: '" + display_class + "' } );");
//	}
//	
//	  public ButtonControl(String display_class,String js_code) {
//	        this.display_class=display_class;
//	        super.create("new OpenLayers.Control.Button( {  displayClass: '" + display_class + "'  , trigger: function() { " + js_code + "}} );");
//	    }
//	
//	
//	public void setStyle(String css) {
//	    super.createCSS( "." + display_class+"ItemActive" , css);
//        super.createCSS( "." + display_class+"ItemInactive" , css);
//	  }
//}