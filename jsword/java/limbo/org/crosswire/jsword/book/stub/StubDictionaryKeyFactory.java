package org.crosswire.jsword.book.stub;

import java.util.Iterator;

import org.crosswire.jsword.passage.DefaultKeyList;
import org.crosswire.jsword.passage.DefaultLeafKeyList;
import org.crosswire.jsword.passage.Key;
import org.crosswire.jsword.passage.KeyFactory;
import org.crosswire.jsword.passage.NoSuchKeyException;

/**
 * A KeyFactory that handles a pretend set of keys.
 * 
 * <p><table border='1' cellPadding='3' cellSpacing='0'>
 * <tr><td bgColor='white' class='TableRowColor'><font size='-7'>
 *
 * Distribution Licence:<br />
 * JSword is free software; you can redistribute it
 * and/or modify it under the terms of the GNU General Public License,
 * version 2 as published by the Free Software Foundation.<br />
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.<br />
 * The License is available on the internet
 * <a href='http://www.gnu.org/copyleft/gpl.html'>here</a>, or by writing to:
 * Free Software Foundation, Inc., 59 Temple Place - Suite 330, Boston,
 * MA 02111-1307, USA<br />
 * The copyright to this program is held by it's authors.
 * </font></td></tr></table>
 * @see gnu.gpl.Licence
 * @author Joe Walker [joe at eireneh dot com]
 * @version $Id$
 */
public class StubDictionaryKeyFactory implements KeyFactory
{
    /**
     * Simple ctor
     */
    public StubDictionaryKeyFactory()
    {
        set.addAll(KEY_STUB);
        set.addAll(KEY_IMPL);
    }

    /* (non-Javadoc)
     * @see org.crosswire.jsword.passage.KeyFactory#getKey(java.lang.String)
     */
    public Key getKey(String name) throws NoSuchKeyException
    {
        DefaultKeyList reply = new DefaultKeyList();

        for (Iterator it = set.iterator(); it.hasNext();)
        {
            Key key = (Key) it.next();
            if (key.getName().equals(name))
            {
                reply.addAll(key);
                return reply;
            }
        }

        throw new NoSuchKeyException(Msg.NO_KEY);
    }

    /* (non-Javadoc)
     * @see org.crosswire.jsword.passage.KeyFactory#getGlobalKeyList()
     */
    public Key getGlobalKeyList()
    {
        return set;
    }

    /* (non-Javadoc)
     * @see org.crosswire.jsword.passage.KeyFactory#getEmptyKeyList()
     */
    public Key createEmptyKeyList()
    {
        return new DefaultKeyList();
    }

    private Key set = new DefaultKeyList(null, "Stub Dictionary"); //$NON-NLS-1$

    private static final DefaultLeafKeyList KEY_IMPL = new DefaultLeafKeyList("implementation", "implementation"); //$NON-NLS-1$ //$NON-NLS-2$

    private static final DefaultLeafKeyList KEY_STUB = new DefaultLeafKeyList("stub", "stub"); //$NON-NLS-1$ //$NON-NLS-2$
}