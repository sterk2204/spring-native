/*
 * Copyright 2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.data.web.config;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebAutoConfiguration;
import org.springframework.data.mongodb.config.GeoJsonConfiguration;
import org.springframework.data.web.config.EnableSpringDataWebSupport.QuerydslActivator;
import org.springframework.data.web.config.EnableSpringDataWebSupport.SpringDataWebConfigurationImportSelector;
import org.springframework.nativex.type.NativeConfiguration;
import org.springframework.nativex.hint.NativeHint;
import org.springframework.nativex.hint.TypeInfo;
import org.springframework.nativex.hint.AccessBits;

// TODO there are others in spring.factories
@NativeHint(trigger = SpringDataWebConfigurationImportSelector.class, typeInfos = {
	@TypeInfo(types = {
			HateoasAwareSpringDataWebConfiguration.class,
			SpringDataWebConfiguration.class,
			ProjectingArgumentResolverRegistrar.class,
			SpringDataJacksonConfiguration.class
	})}, abortIfTypesMissing = true, follow = true)
@NativeHint(trigger = QuerydslActivator.class, typeInfos = {
	@TypeInfo(types= QuerydslWebConfiguration.class) }, abortIfTypesMissing = true, follow = true)
@NativeHint(trigger = SpringDataWebAutoConfiguration.class, typeInfos =
	@TypeInfo(types = GeoJsonConfiguration.class, access = AccessBits.CONFIGURATION))
public class SpringDataWebHints implements NativeConfiguration {
}
