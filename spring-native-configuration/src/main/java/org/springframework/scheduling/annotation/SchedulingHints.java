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
package org.springframework.scheduling.annotation;

import org.springframework.nativex.type.NativeConfiguration;
import org.springframework.nativex.hint.NativeHint;
import org.springframework.nativex.hint.TypeInfo;
import org.springframework.nativex.hint.AccessBits;
import org.springframework.scheduling.aspectj.AspectJAsyncConfiguration;

@NativeHint(trigger=AsyncConfigurationSelector.class, typeInfos = {
	@TypeInfo(types= {ProxyAsyncConfiguration.class,AspectJAsyncConfiguration.class},access=AccessBits.CONFIGURATION),
})
@NativeHint(trigger=SchedulingConfiguration.class, typeInfos = {
	@TypeInfo(types = Schedules.class, access=AccessBits.CLASS|AccessBits.DECLARED_METHODS)
})
public class SchedulingHints implements NativeConfiguration { }