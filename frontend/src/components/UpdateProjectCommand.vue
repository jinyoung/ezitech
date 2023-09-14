<template>
    <v-card outlined>
        <v-card-title>
            UpdateProject
        </v-card-title>

        <v-card-text>
            <String label="NoticeProjectName" v-model="value.noticeProjectName" :editMode="editMode"/>
            <String label="ProjectManager" v-model="value.projectManager" :editMode="editMode"/>
            <String label="ProjectName" v-model="value.projectName" :editMode="editMode"/>
            <String label="RfpName" v-model="value.rfpName" :editMode="editMode"/>
            <String label="ResearchManager" v-model="value.researchManager" :editMode="editMode"/>
            <String label="ParticipationType" v-model="value.participationType" :editMode="editMode"/>
            <Boolean label="CashBurden" v-model="value.cashBurden" :editMode="editMode"/>
            <Boolean label="MaterialBurden" v-model="value.materialBurden" :editMode="editMode"/>
            <Number label="TotalProjectCost" v-model="value.totalProjectCost" :editMode="editMode"/>
            <Number label="CurrentYearProjectCost" v-model="value.currentYearProjectCost" :editMode="editMode"/>
            <Number label="TotalProjectDuration" v-model="value.totalProjectDuration" :editMode="editMode"/>
            <String label="CurrentYearDuration" v-model="value.currentYearDuration" :editMode="editMode"/>
            <String label="OrganName" v-model="value.organName" :editMode="editMode"/>
            <String label="OrganBusinessNumber" v-model="value.organBusinessNumber" :editMode="editMode"/>
            <String label="OrganDirector" v-model="value.organDirector" :editMode="editMode"/>
            <Date label="ReceiptDate" v-model="value.receiptDate" :editMode="editMode"/>
            <Boolean label="SelectionNotification" v-model="value.selectionNotification" :editMode="editMode"/>
            <Boolean label="AccountAllocation" v-model="value.accountAllocation" :editMode="editMode"/>
            <File offline label="ProjectPlanFile" v-model="value.projectPlanFile" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="updateProject"
            >
                UpdateProject
            </v-btn>
            
            <v-btn
                    color="primary"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
   
    export default {
        name: 'UpdateProjectCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.noticeProjectName = '';
            this.value.projectManager = '';
            this.value.projectName = '';
            this.value.rfpName = '';
            this.value.researchManager = '';
            this.value.participationType = '';
            this.value.cashBurden = false;
            this.value.materialBurden = false;
            this.value.totalProjectCost = 0;
            this.value.currentYearProjectCost = 0;
            this.value.totalProjectDuration = 0;
            this.value.currentYearDuration = '';
            this.value.organName = '';
            this.value.organBusinessNumber = '';
            this.value.organDirector = '';
            this.value.receiptDate = '2023-09-14';
            this.value.selectionNotification = false;
            this.value.accountAllocation = false;
            this.value.projectPlanFile = {};
        },
        watch: {
        },
        methods: {
            updateProject() {
                this.$emit('updateProject', this.value);
            },
            close() {
                this.$emit('closeDialog');
            },
            change() {
                this.$emit('input', this.value);
            },
        }
    }
</script>

