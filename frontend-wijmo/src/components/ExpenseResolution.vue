<template>
    <div>
        <String label="결의번호" v-model="value.resolutionNumber" :editMode="editMode"/>
        <String label="비목" v-model="value.directOrIndirectExpense" :editMode="editMode"/>
        <String label="세목" v-model="value.item" :editMode="editMode"/>
        <String label="결의명" v-model="value.resolutionName" :editMode="editMode"/>
        <String label="지급처명" v-model="value.vendorName" :editMode="editMode"/>
        <String label="은행명" v-model="value.bankName" :editMode="editMode"/>
        <String label="은행계좌번호" v-model="value.bankAccountNumber" :editMode="editMode"/>
        <String label="예금주" v-model="value.accountOwner" :editMode="editMode"/>
        <String label="결의내용" v-model="value.resolutionContent" :editMode="editMode"/>
        <String label="결재상태" v-model="value.approvalStatus" :editMode="editMode"/>
        <String label="결재선" v-model="value.approvalLine" :editMode="editMode"/>
        <Money offline label="결의공급가액" v-model="value.totalAmount" :editMode="editMode" @change="change"/>

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
    name: 'ExpenseResolution',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "expenseResolutions"
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>

