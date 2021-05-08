package org.gemseeker.jdb;

import java.time.LocalDateTime;

public abstract class AbstractDataEntry implements IDataEntry {

    protected LocalDateTime created_at;
    protected LocalDateTime updated_at;
}
