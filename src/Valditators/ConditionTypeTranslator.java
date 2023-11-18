package src.Valditators;

import src.domain.ConditionType;

public class ConditionTypeTranslator {
    public static ConditionType trnaslate_condition(String scondition)
    {
        if(scondition.equalsIgnoreCase("Disease") && StringValidators.StringMatching(scondition,"Disease"))
            return ConditionType.Disease;
        if(scondition.equalsIgnoreCase("Allergies") && StringValidators.StringMatching(scondition,"Allergies"))
            return ConditionType.Allergies;
        if(scondition.equalsIgnoreCase("Allergies") && StringValidators.StringMatching(scondition,"Medication"))
            return ConditionType.Medication;
        return null;
    }
}
