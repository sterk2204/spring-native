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
package org.springframework.boot.autoconfigure.jdbc;

import java.sql.DatabaseMetaData;
import java.sql.Statement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.util.ConcurrentBag.IConcurrentBagEntry;

import org.springframework.boot.autoconfigure.jdbc.DataSourceConfiguration.Hikari;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.support.JdbcAccessor;
import org.springframework.nativex.hint.AccessBits;
import org.springframework.nativex.hint.MethodInfo;
import org.springframework.nativex.hint.NativeHint;
import org.springframework.nativex.hint.ResourcesInfo;
import org.springframework.nativex.hint.TypeInfo;
import org.springframework.nativex.type.NativeConfiguration;

@NativeHint(trigger=DataSourceInitializationConfiguration.Registrar.class, typeInfos= {
		@TypeInfo(types=DataSourceInitializerPostProcessor.class, access=AccessBits.FULL_REFLECTION)})

@NativeHint(trigger=EmbeddedDataSourceConfiguration.class, typeInfos= {
		@TypeInfo(types= {EmbeddedDatabase.class, JdbcAccessor.class}, typeNames="org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseFactory$EmbeddedDataSourceProxy",
				access=AccessBits.LOAD_AND_CONSTRUCT|AccessBits.DECLARED_METHODS)})

@NativeHint(trigger=Hikari.class, typeInfos= {
		@TypeInfo(types=DatabaseMetaData.class,methods= {@MethodInfo(name="getDatabaseProductName")}),
		@TypeInfo(types= {IConcurrentBagEntry[].class,IConcurrentBagEntry.class, Statement.class, Statement[].class}),
		@TypeInfo(types = {HikariDataSource.class}, access=AccessBits.LOAD_AND_CONSTRUCT),
	@TypeInfo(types = HikariConfig.class, typeNames = "com.zaxxer.hikari.HikariConfigMXBean", access = AccessBits.FULL_REFLECTION)})
@NativeHint(trigger=DataSourceAutoConfiguration.class, resourcesInfos = {
		@ResourcesInfo(patterns = {"schema.sql","data.sql"})
})
public class JdbcHints implements NativeConfiguration { }
