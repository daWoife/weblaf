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

package com.alee.extended.tree;

import com.alee.api.annotations.NotNull;

/**
 * Adapter for {@link AsyncPathExpansionListener}.
 *
 * @param <N> {@link AsyncUniqueNode} type
 * @author Mikle Garin
 */
public abstract class AsyncPathExpansionAdapter<N extends AsyncUniqueNode> implements AsyncPathExpansionListener<N>
{
    @Override
    public void pathNodeExpanded ( @NotNull final N expandedNode )
    {
        /**
         * Do nothing by default.
         */
    }

    @Override
    public void pathExpanded ( @NotNull final N lastNode )
    {
        /**
         * Do nothing by default.
         */
    }

    @Override
    public void pathPartiallyExpanded ( @NotNull final N lastFoundNode )
    {
        /**
         * Do nothing by default.
         */
    }

    @Override
    public void pathFailedToExpand ()
    {
        /**
         * Do nothing by default.
         */
    }
}