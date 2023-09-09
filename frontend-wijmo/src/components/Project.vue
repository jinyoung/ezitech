<template>
    <div>
        <String label="과제관리번호" v-model="value.projectNumber" :editMode="editMode"/>
        <String label="과제고유번호" v-model="value.projectCode" :editMode="editMode"/>
        <String label="과제기간" v-model="value.projectPeriod" :editMode="editMode"/>
        <String label="과제명" v-model="value.projectName" :editMode="editMode"/>
        <ExpenseTable offline label="예실대비표" v-model="value.expenseTable" :editMode="editMode" @change="change"/>
        <ExpenseTableId offline label="ExpenseTableId" v-model="value.expenseTableId" :editMode="editMode" @change="change"/>

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
    name: 'Project',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "projects"
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>

