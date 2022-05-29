#!/bin/bash

## <master-name> <role> <state> <from-ip> <from-port> <to-ip> <to-port>

echo -e " MASTER_NAME : $1 \n ROLE : $2 \n STATE : $3 \n FROM-IP : $4 \n FROM-PORT : $5 \n TO-IP : $6 \n TO-PORT : $7" | mail -s "Redis Sentinel Failover" carlosxiaocc@163.com

