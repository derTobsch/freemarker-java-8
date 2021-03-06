/*
 * Copyright (c) 2015-2015 Amedia Utvikling AS.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package no.api.freemarker.java8.time;

import freemarker.ext.beans.BeansWrapper;
import freemarker.template.AdapterTemplateModel;
import freemarker.template.SimpleNumber;
import freemarker.template.TemplateHashModel;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;
import freemarker.template.TemplateScalarModel;

import java.time.Duration;

import static no.api.freemarker.java8.time.DateTimeTools.*;

/**
 * DurationAdapter adds basic format support for {@link Duration} too FreeMarker 2.3.23 and above.
 */
public class DurationAdapter extends AbstractAdapter<Duration> implements AdapterTemplateModel,
        TemplateScalarModel, TemplateHashModel {

    public DurationAdapter(Duration obj, BeansWrapper wrapper) {
        super(obj, wrapper);
    }


    @Override
    public TemplateModel getForType(String s) throws TemplateModelException {
        if (METHOD_NANO.equalsIgnoreCase(s)) {
            return new SimpleNumber(getObject().getNano());
        } else if (METHOD_SECONDS.equalsIgnoreCase(s)) {
            return new SimpleNumber(getObject().getSeconds());
        }
        throw new TemplateModelException(METHOD_UNKNOWN_MSG + s);
    }

}
