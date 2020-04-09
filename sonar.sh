#!/bin/bash
mvn sonar:sonar \
  -Dsonar.projectKey=neuropsi-gateway-server \
  -Dsonar.host.url=http://localhost:9000 \
  -Dsonar.login=088af9ceebf2424e9d7414ddc187442611019f31
