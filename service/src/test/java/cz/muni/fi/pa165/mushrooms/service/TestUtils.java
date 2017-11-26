package cz.muni.fi.pa165.mushrooms.service;

import cz.muni.fi.pa165.mushrooms.entity.Visit;

import java.util.List;
import java.util.Map;

/**
 * Utilities used in tests.
 *
 * @author bkompis
 */
class TestUtils {
    static boolean checkVisitDuplicity(Map<Long, Visit> visits, Visit newVisit) {
        for (Visit v : visits.values()) {
            if (!v.getId().equals(newVisit.getId())
                    && v.getHunter().equals(newVisit.getHunter())
                    && v.getForest().equals(newVisit.getForest())
                    && v.getDate().equals(newVisit.getDate())) {
                return true;
            }
        }
        return false;
    }

    static Visit createVisit(){
        return null;
    }
}
