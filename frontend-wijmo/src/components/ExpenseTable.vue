<template>
    <div>
        <String label="세목" v-model="value.item" :editMode="editMode"/>
        <Money offline label="계획예산" v-model="value.plannedBudget" :editMode="editMode" @change="change"/>
        <Money offline label="변경예산" v-model="value.budgetChange" :editMode="editMode" @change="change"/>
        <Money offline label="집행액" v-model="value.executionAmount" :editMode="editMode" @change="change"/>
        <Money offline label="가집행액" v-model="value.approvedExecutionAmount" :editMode="editMode" @change="change"/>
        <Money offline label="잔액" v-model="value.balance" :editMode="editMode" @change="change"/>

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
    name: 'ExpenseTable',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "expenseTables"
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>

