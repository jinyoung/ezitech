<template>
    <div>
        <String label="과제관리번호" v-model="value.taskManagementNumber" :editMode="editMode"/>
        <Number label="민간부담율" v-model="value.privateRatio" :editMode="editMode"/>
        <Number label="민간현금부담율" v-model="value.privateCashRatio" :editMode="editMode"/>
        <Money offline label="정부지원금" v-model="value.studentResearchCost" :editMode="editMode" @change="change"/>
        <Money offline label="인건비" v-model="value.laborCost" :editMode="editMode" @change="change"/>
        <Money offline label="내부 인건비" v-model="value.internalLaborCost" :editMode="editMode" @change="change"/>
        <Money offline label="외부 인건비" v-model="value.externalLaborCost" :editMode="editMode" @change="change"/>
        <Money offline label="학생 연구비" v-model="value.studentResearchCost" :editMode="editMode" @change="change"/>
        <MaterialCost offline label="재료비" v-model="value.materialCost" :editMode="editMode" @change="change"/>
        <ResearchFacilityCost offline label="연구시설장비비" v-model="value.researchFacilityCost" :editMode="editMode" @change="change"/>
        <ActivityCost offline label="활동비" v-model="value.activityCost" :editMode="editMode" @change="change"/>
        <IndirectCost offline label="간접비" v-model="value.indirectCost" :editMode="editMode" @change="change"/>
        <ProjectMasterId offline label="ProjectMasterId" v-model="value.projectMasterId" :editMode="editMode" @change="change"/>

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
    name: 'Budget',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "budgets"
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>

