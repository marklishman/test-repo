package io.lishman.domain;

import lombok.*;
import org.apache.commons.lang3.StringUtils;

@Builder
@AllArgsConstructor
@ToString(of = "name")
@EqualsAndHashCode(of = "name")
public final class Branch {

    @Getter
    private final String name;

    @Getter
    private final boolean projectExists;

    @Getter
    private final String sha;

    @Getter
    private final boolean stale;

    public boolean isMaster() {
        return StringUtils.equalsIgnoreCase(getName(), "master");
    }

    public BranchBuilder cloneBuilder() {
        return builder()
                .name(this.getName())
                .projectExists(this.isProjectExists());
    }
}