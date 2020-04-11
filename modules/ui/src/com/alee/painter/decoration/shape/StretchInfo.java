/*
 * This file is part of WebLookAndFeel library.
 *
 * WebLookAndFeel library is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * WebLookAndFeel library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with WebLookAndFeel library.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.alee.painter.decoration.shape;

import com.alee.api.annotations.NotNull;
import com.alee.api.annotations.Nullable;
import com.alee.utils.general.Pair;

import java.io.Serializable;

/**
 * Class containing shape stretch information.
 *
 * @author Mikle Garin
 */
public class StretchInfo implements Serializable
{
    /**
     * Horizontal stretch intervals.
     */
    @Nullable
    protected Pair<Integer, Integer> horizontalStretch;

    /**
     * Vertical stretch intervals.
     */
    @Nullable
    protected Pair<Integer, Integer> verticalStretch;

    /**
     * Constructs new empty stretch information.
     */
    public StretchInfo ()
    {
        this ( null, null );
    }

    /**
     * Constructs new stretch information with specified values.
     *
     * @param horizontalStretch horizontal stretch intervals
     * @param verticalStretch   vertical stretch intervals
     */
    public StretchInfo ( @Nullable final Pair<Integer, Integer> horizontalStretch, @Nullable final Pair<Integer, Integer> verticalStretch )
    {
        this.horizontalStretch = horizontalStretch;
        this.verticalStretch = verticalStretch;
    }

    /**
     * Returns horizontal stretch intervals.
     *
     * @return horizontal stretch intervals
     */
    @Nullable
    public Pair<Integer, Integer> getHorizontalStretch ()
    {
        return horizontalStretch;
    }

    /**
     * Returns vertical stretch intervals.
     *
     * @return vertical stretch intervals
     */
    @Nullable
    public Pair<Integer, Integer> getVerticalStretch ()
    {
        return verticalStretch;
    }

    /**
     * Returns whether or not at least one side of the shape is stretchable.
     *
     * @return true if at least one side of the shape is stretchable, false otherwise
     */
    public boolean isStretchable ()
    {
        return horizontalStretch != null || verticalStretch != null;
    }

    @Override
    public String toString ()
    {
        final StringBuilder sb = new StringBuilder ();
        if ( horizontalStretch != null )
        {
            sb.append ( "hor:" );
            append ( sb, horizontalStretch );
        }
        if ( verticalStretch != null )
        {
            sb.append ( "ver:" );
            append ( sb, verticalStretch );
        }
        return sb.toString ();
    }

    /**
     * Appends intervals to string builder.
     *
     * @param sb       string builder
     * @param interval stretch interval
     */
    protected void append ( @NotNull final StringBuilder sb, @NotNull final Pair<Integer, Integer> interval )
    {
        sb.append ( interval.getKey () ).append ( "," ).append ( interval.getValue () );
    }
}