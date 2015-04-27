/*
 * polymap.org
 * Copyright (C) 2009-2014, Polymap GmbH. All rights reserved.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */
package org.polymap.rap.openlayers.style;

import org.polymap.rap.openlayers.base.OlObject;
import org.polymap.rap.openlayers.util.JSonBuilder;

public class ImageStyle extends OlObject {

	public ImageStyle(Options options) {
		create("new ol.style.Image(" + options.asJson() + ")");
	}

	public static Options builder() {
		return new Options();
	}

	public static class Options {
		// TODO more options here
		// http://openlayers.org/en/v3.1.1/apidoc/ol.style.Image.html?unstable=true
		private JSonBuilder asJson() {
			JSonBuilder json = new JSonBuilder();

			return json;
		}

		public ImageStyle build() {
			return new ImageStyle(this);
		}
	}
}
