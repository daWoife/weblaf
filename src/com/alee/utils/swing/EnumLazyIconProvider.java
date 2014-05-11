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

package com.alee.utils.swing;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Special class for simple and lazy enum icons retrieval.
 *
 * @author Mikle Garin
 */

public class EnumLazyIconProvider
{
    /**
     * Cached enum icons map.
     */
    private static final Map<Enum, Map<String, ImageIcon>> icons = new HashMap<Enum, Map<String, ImageIcon>> ();

    /**
     * Returns cached or just loaded enum icon.
     *
     * @param enumeration enumeration constant for which icon should be loaded
     * @param folder      enumeration icons folder
     * @param <E>         enumeration type
     * @return cached or just loaded enum icon
     */
    public static <E extends Enum<E>> ImageIcon getIcon ( final E enumeration, final String folder )
    {
        return getIcon ( enumeration, null, folder );
    }

    /**
     * Returns cached or just loaded enum icon for the specified state.
     * State string will be used to determine icon name automatically.
     *
     * @param enumeration enumeration constant for which icon should be loaded
     * @param state       enumeration icon state
     * @param folder      enumeration icons folder
     * @param <E>         enumeration type
     * @return cached or just loaded enum icon
     */
    public static <E extends Enum<E>> ImageIcon getIcon ( final E enumeration, final String state, final String folder )
    {
        Map<String, ImageIcon> stateIcons = icons.get ( enumeration );
        if ( stateIcons == null )
        {
            stateIcons = new HashMap<String, ImageIcon> ( 1 );
            icons.put ( enumeration, stateIcons );
        }
        ImageIcon imageIcon = stateIcons.get ( state );
        if ( imageIcon == null && !stateIcons.containsKey ( state ) )
        {
            try
            {
                final String stateSuffix = state != null ? "-" + state : "";
                imageIcon = new ImageIcon ( enumeration.getClass ().getResource ( folder + enumeration + stateSuffix + ".png" ) );
                stateIcons.put ( state, imageIcon );
            }
            catch ( final Throwable e )
            {
                e.printStackTrace ();
                stateIcons.put ( state, null );
            }
        }
        return imageIcon;
    }
}