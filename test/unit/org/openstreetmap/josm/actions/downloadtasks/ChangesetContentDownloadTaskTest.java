// License: GPL. For details, see LICENSE file.
package org.openstreetmap.josm.actions.downloadtasks;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.awt.Component;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openstreetmap.josm.testutils.JOSMTestRules;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/**
 * Unit tests for class {@link ChangesetContentDownloadTask}.
 */
class ChangesetContentDownloadTaskTest {

    /**
     * Setup test.
     */
    @RegisterExtension
    @SuppressFBWarnings(value = "URF_UNREAD_PUBLIC_OR_PROTECTED_FIELD")
    public JOSMTestRules test = new JOSMTestRules();

    /**
     * Unit test of {@code ChangesetContentDownloadTask#ChangesetContentDownloadTask}.
     */
    @Test
    void testChangesetContentDownloadTask() {
        Component parent = new Component() {
            // empty component
        };
        assertNotNull(new ChangesetContentDownloadTask(parent, 1));
        assertNotNull(new ChangesetContentDownloadTask(parent, Arrays.asList(1, 2)));
        assertNotNull(new ChangesetContentDownloadTask(parent, null));
    }

    /**
     * Unit test of {@code ChangesetContentDownloadTask#ChangesetContentDownloadTask} - invalid changeset id.
     */
    @Test
    void testChangesetContentDownloadTaskInvalidId() {
        assertThrows(IllegalArgumentException.class, () -> new ChangesetContentDownloadTask(0));
    }

    /**
     * Unit test of {@code ChangesetContentDownloadTask#ChangesetContentDownloadTask} - null parent.
     */
    @Test
    void testChangesetContentDownloadTaskNullParent1() {
        assertThrows(IllegalArgumentException.class, () -> new ChangesetContentDownloadTask(1));
    }

    /**
     * Unit test of {@code ChangesetContentDownloadTask#ChangesetContentDownloadTask} - null parent.
     */
    @Test
    void testChangesetContentDownloadTaskNullParent2() {
        assertThrows(IllegalArgumentException.class, () -> new ChangesetContentDownloadTask(Arrays.asList(1, 2)));
    }
}
