# 

## Model
www.msaez.io/#/storming/ezitech

## Before Running Services
### Make sure there is a Kafka server running
```
cd kafka
docker-compose up
```
- Check the Kafka messages:
```
cd infra
docker-compose exec -it kafka /bin/bash
cd /bin
./kafka-console-consumer --bootstrap-server localhost:9092 --topic
```

## Run the backend micro-services
See the README.md files inside the each microservices directory:

- registration
- 집행
- 정산
- rnd-notes
- budget
- ParticipationRate


## Run API Gateway (Spring Gateway)
```
cd gateway
mvn spring-boot:run
```

## Test by API
- registration
```
 http :8088/projectMasters projectId="projectId" noticeProjectName="noticeProjectName" projectManager="projectManager" projectName="projectName" rfpName="rfpName" researchManager="researchManager" cashBurden="cashBurden" materialBurden="materialBurden" totalProjectCost="totalProjectCost" currentYearProjectCost="currentYearProjectCost" totalProjectDuration="totalProjectDuration" currentYearDuration="currentYearDuration" organName="organName" organBusinessNumber="organBusinessNumber" organDirector="organDirector" receiptDate="receiptDate" selectionNotification="selectionNotification" accountAllocation="accountAllocation" projectPlanFile="projectPlanFile" participationType="participationType" 
```
- 집행
```
```
- 정산
```
```
- rnd-notes
```
```
- budget
```
 http :8088/budgets taskManagementNumber="taskManagementNumber" governmentSupportAmount="governmentSupportAmount" privateRatio="privateRatio" privateCashRatio="privateCashRatio" laborCost="laborCost" internalLaborCost="internalLaborCost" externalLaborCost="externalLaborCost" studentResearchCost="studentResearchCost" materialCost="materialCost" researchFacilityCost="researchFacilityCost" activityCost="activityCost" indirectCost="indirectCost" projectMasterId="projectMasterId" 
```
- ParticipationRate
```
 http :8088/researchers name="name" role="role" residentId="residentId" phoneNumber="phoneNumber" highestEducation="highestEducation" highestEducationSchool="highestEducationSchool" highestEducationMajor="highestEducationMajor" monthlySalary="monthlySalary" physicalAllowanceRate="physicalAllowanceRate" cashAllowanceRate="cashAllowanceRate" duration="duration" department="department" researcherNumber="researcherNumber" projectMasterId="projectMasterId" 
```


## Run the frontend
```
cd frontend
npm i
npm run serve
```

## Test by UI
Open a browser to localhost:8088

## Required Utilities

- httpie (alternative for curl / POSTMAN) and network utils
```
sudo apt-get update
sudo apt-get install net-tools
sudo apt install iputils-ping
pip install httpie
```

- kubernetes utilities (kubectl)
```
curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
sudo install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl
```

- aws cli (aws)
```
curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
unzip awscliv2.zip
sudo ./aws/install
```

- eksctl 
```
curl --silent --location "https://github.com/weaveworks/eksctl/releases/latest/download/eksctl_$(uname -s)_amd64.tar.gz" | tar xz -C /tmp
sudo mv /tmp/eksctl /usr/local/bin
```

