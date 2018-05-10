package io.dddbyexamples.employment.minimallevel;

import io.dddbyexamples.rules.Ruleska;
import org.mockito.Mockito;

public class FakeRuleski {

    public static Ruleski mockRulesAdapter() {
        Ruleski mock = Mockito.mock(Ruleski.class);
        Mockito.when(mock.exceededNumberOfStatements()).thenReturn(new Ruleska("przekroczona ilośc oswiadczen"));
        Mockito.when(mock.notEnoughtDeclaredHouers(Mockito.anyInt())).thenReturn(new Ruleska("za mala ilosc godzin w oswiadczeniu"));
        Mockito.when(mock.courseDuplicate(Mockito.any())).thenReturn(new Ruleska("przekroczona ilośc oswiadczen"));
        return mock;
    }
}
