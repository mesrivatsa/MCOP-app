/*

*  Copyright (C) 2017, University of the Basque Country (UPV/EHU)
*
* Contact for licensing options: <licensing-mcpttclient(at)mcopenplatform(dot)com>
*
* This file is part of MCOP MCPTT Client
*
* This is free software: you can redistribute it and/or modify it under the terms of
* the GNU General Public License as published by the Free Software Foundation, either version 3
* of the License, or (at your option) any later version.
*
* This is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
* without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
* See the GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License along
* with this program; if not, write to the Free Software Foundation, Inc.,
* 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
*/
package org.doubango.ngn.datatype.affiliation.pidf;

import org.simpleframework.xml.convert.Converter;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;


 public class StatusTypeConverter implements Converter<StatusType> {
    @Override
    public StatusType read(InputNode node) throws Exception
    {
        final String value = node.getNext("status").getValue();

        for(StatusType ts : StatusType.values() )
        {
            if( ts.value().equalsIgnoreCase(value) )
                return ts;
        }
        throw new IllegalArgumentException("No enum available for " + value);
    }


    @Override
    public void write(OutputNode node, StatusType value) throws Exception
    {
        OutputNode child = node.getChild("status");
        child.setValue(value.value());
    }
}
