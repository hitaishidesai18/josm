// License: GPL. For details, see LICENSE file.
package org.openstreetmap.josm.data.osm;

import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.api.Test;
import org.openstreetmap.josm.TestUtils;
import org.openstreetmap.josm.testutils.JOSMTestRules;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

/**
 * Unit tests for class {@link Storage}.
 */
class StorageTest {

    /**
     * Setup test.
     */
    @RegisterExtension
    @SuppressFBWarnings(value = "URF_UNREAD_PUBLIC_OR_PROTECTED_FIELD")
    public JOSMTestRules test = new JOSMTestRules();

    /**
     * Unit test of methods {@link Storage#equals} and {@link Storage#hashCode}.
     */
    @Test
    void testEqualsContract() {
        TestUtils.assumeWorkingEqualsVerifier();
        EqualsVerifier.forClass(Storage.class).usingGetClass()
            .suppress(Warning.NONFINAL_FIELDS)
            .withIgnoredFields("arrayCopyNecessary", "hash", "mask", "modCount", "safeIterator", "size")
            .withPrefabValues(Hash.class, Storage.<Integer>defaultHash(), Storage.<Boolean>defaultHash())
            .verify();
    }
}
