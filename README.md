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
- budget
- ParticipationRate
- 연구노트


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
 http :8088/expenseResolutions resolutionNumber="resolutionNumber" directOrIndirectExpense="directOrIndirectExpense" item="item" resolutionName="resolutionName" totalAmount="totalAmount" vendorName="vendorName" bankName="bankName" bankAccountNumber="bankAccountNumber" accountOwner="accountOwner" resolutionContent="resolutionContent" attachments="attachments" approvalStatus="approvalStatus" approvalLine="approvalLine" 
```
- 정산
```
 http :8088/projects projectNumber="projectNumber" projectCode="projectCode" projectPeriod="projectPeriod" projectName="projectName" expenseTable="expenseTable" expenseTableId="expenseTableId" 
 http :8088/expenseTables item="item" plannedBudget="plannedBudget" budgetChange="budgetChange" executionAmount="executionAmount" approvedExecutionAmount="approvedExecutionAmount" balance="balance" 
```
- budget
```
 http :8088/budgets issueManagementNumber="issueManagementNumber" privateBurdenRate="privateBurdenRate" privateCashBurdenRate="privateCashBurdenRate" studentResearchExpenses="studentResearchExpenses" internalPersonnelExpenses="internalPersonnelExpenses" externalPersonnelExpenses="externalPersonnelExpenses" studentResearchExpenses="studentResearchExpenses" materialExpenses="materialExpenses" researchFacilityExpenses="researchFacilityExpenses" activityExpenses="activityExpenses" projectMasterId="projectMasterId" governmentSupportFunds="governmentSupportFunds" personnelExpenses="personnelExpenses" 
```
- ParticipationRate
```
 http :8088/inHireCosts name="name" role="role" residentRegistrationNumber="residentRegistrationNumber" phoneNumber="phoneNumber" finalEducation="finalEducation" finalEducationSchool="finalEducationSchool" finalEducationMajor="finalEducationMajor" monthlySalary="monthlySalary" physicalRatio="physicalRatio" cashRatio="cashRatio" duration="duration" department="department" nationalResearcherNumber="nationalResearcherNumber" 
```
- 연구노트
```
 http :8088/researchNotes researchNoteId="researchNoteId" date="date" author="author" content="content" signature="signature" approvalStatus="approvalStatus" 
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

