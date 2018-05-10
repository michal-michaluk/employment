package io.dddbyexamples.rules;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

public class ProviderFactory {

    Map<String, Ruleska> realRuleskiSystem;

    public <T> T create(Class<T> interfaceOfRules) {
        return interfaceOfRules.cast(
                Proxy.newProxyInstance(interfaceOfRules.getClassLoader(),
                        new Class[]{interfaceOfRules},
                        this::create
                )
        );
    }

    private Object create(Object proxy, Method method, Object[] args) {
        RuleId annotation = method.getAnnotation(RuleId.class);
        if (annotation == null) {
            return null;
        }
        String ruleId = annotation.value();
        Ruleska ruleska = realRuleskiSystem.get(ruleId);
        // build context with:
        method.getParameters(); // + args
        return ruleska;
    }
}
