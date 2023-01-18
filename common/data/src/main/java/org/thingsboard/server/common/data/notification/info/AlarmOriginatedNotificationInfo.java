/**
 * Copyright © 2016-2022 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.common.data.notification.info;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.alarm.AlarmSeverity;
import org.thingsboard.server.common.data.alarm.AlarmStatus;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlarmOriginatedNotificationInfo implements NotificationInfo {

    private AlarmId alarmId;
    private String alarmType;
    private EntityId alarmOriginator;
    private AlarmSeverity alarmSeverity;
    private AlarmStatus alarmStatus;
    private CustomerId customerId;

    @Override
    public EntityType getOriginatorType() {
        return EntityType.ALARM;
    }

    @Override
    public Map<String, String> getTemplateData() {
        return Map.of(
                "alarmType", alarmType,
                "alarmId", alarmId.toString(),
                "alarmSeverity", alarmSeverity.toString(),
                "alarmStatus", alarmStatus.toString(),
                "alarmOriginatorEntityType", alarmOriginator.getEntityType().toString(),
                "alarmOriginatorId", alarmOriginator.getId().toString()
        );
    }

}
