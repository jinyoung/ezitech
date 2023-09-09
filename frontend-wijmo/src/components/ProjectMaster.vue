<template>
    <div>
        <String label="ProjectId" v-model="value.projectId" :editMode="editMode"/>
        <String label="공고 사업명" v-model="value.noticeProjectName" :editMode="editMode"/>
        <String label="사업 담당자" v-model="value.projectManager" :editMode="editMode"/>
        <String label="과제명" v-model="value.projectName" :editMode="editMode"/>
        <String label="RFP명" v-model="value.rfpName" :editMode="editMode"/>
        <String label="연구 책임자" v-model="value.researchManager" :editMode="editMode"/>
        <Boolean label="현금 부담 여부" v-model="value.cashBurden" :editMode="editMode"/>
        <Boolean label="현물 부담 여부" v-model="value.materialBurden" :editMode="editMode"/>
        <Number label="총 사업 비용" v-model="value.totalProjectCost" :editMode="editMode"/>
        <Number label="당해년도 사업 비용" v-model="value.currentYearProjectCost" :editMode="editMode"/>
        <Number label="총 기간(개월)" v-model="value.totalProjectDuration" :editMode="editMode"/>
        <String label="당해년도 기간" v-model="value.currentYearDuration" :editMode="editMode"/>
        <String label="주관 기관명" v-model="value.organName" :editMode="editMode"/>
        <String label="주관 기관 사업자 번호" v-model="value.organBusinessNumber" :editMode="editMode"/>
        <String label="주관 기관 총 책임자" v-model="value.organDirector" :editMode="editMode"/>
        <Date label="접수일" v-model="value.receiptDate" :editMode="editMode"/>
        <Boolean label="선정 통보 완료 여부" v-model="value.selectionNotification" :editMode="editMode"/>
        <Boolean label="계정 부여 여부" v-model="value.accountAllocation" :editMode="editMode"/>
        <File offline label="사업 계획서 파일" v-model="value.projectPlanFile" :editMode="editMode" @change="change"/>
        <ParticipationType offline label="ParticipationType" v-model="value.participationType" :editMode="editMode" @change="change"/>

        <v-divider class="border-opacity-100 my-divider"></v-divider>
        <v-layout row justify-end>
            <v-btn
                width="64px"
                color="primary"
                @click="save"
            >
                저장
            </v-btn>
        </v-layout>
    </div>
</template>


<script>

import BaseEntity from './base-ui/BaseEntity'

export default {
    name: 'ProjectMaster',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "projectMasters"
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>

