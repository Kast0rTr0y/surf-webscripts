/**
 * Copyright (C) 2005-2009 Alfresco Software Limited.
 *
 * This file is part of the Spring Surf Extension project.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.extensions.webscripts;

import java.util.List;

import org.mozilla.javascript.Scriptable;

/**
 * Helper to resolve an I18N message for JS scripts.
 * 
 * @author Kevin Roast
 */
public final class ScriptMessage extends AbstractMessageHelper
{
    /**
     * Constructor
     * 
     * @param webscript WebScript
     */
    public ScriptMessage(WebScript webscript)
    {
        super(webscript);
    }
    
    
    /**
     * Get an I18N message
     * 
     * @param id    Message Id
     * 
     * @return resolved message
     */
    public String get(String id)
    {
        String result = null;
        
        if (id != null && id.length() != 0)
        {
            result = resolveMessage(id);
        }
        
        return (result != null ? result : "");
    }
    
    /**
     * Get an I18N message with the given message args
     * 
     * @param id    Message Id
     * @param args  Message args
     * 
     * @return resolved message
     */
    public String get(String id, Scriptable args)
    {
        String result = null;
        
        if (id != null && id.length() != 0)
        {
            Object params = ScriptValueConverter.unwrapValue(args);
            if (params instanceof List)
            {
                result = resolveMessage(id, ((List)params).toArray());
            }
            else
            {
                result = resolveMessage(id);
            }
        }
        
        return (result != null ? result : "");
    }
}
