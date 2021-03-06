package org.springframework.boot.actuate.autoconfigure.security.servlet;

import org.springframework.nativex.type.NativeConfiguration;
import org.springframework.nativex.hint.NativeHint;
import org.springframework.nativex.hint.TypeInfo;
import org.springframework.nativex.hint.AccessBits;

@NativeHint(trigger= ManagementWebSecurityAutoConfiguration.class,typeInfos= {
@TypeInfo(typeNames = {
		"org.springframework.boot.autoconfigure.security.DefaultWebSecurityCondition",
		"org.springframework.boot.autoconfigure.security.DefaultWebSecurityCondition$Classes",
		"org.springframework.boot.autoconfigure.security.DefaultWebSecurityCondition$Beans",
}, access = AccessBits.ALL)})
public class ManagementWebSecurityAutoConfigurationHints implements NativeConfiguration {
}
