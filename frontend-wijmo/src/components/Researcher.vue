<template>
    <div>
        <String label="Name" v-model="value.name" :editMode="editMode"/>
        <String label="Role" v-model="value.role" :editMode="editMode"/>
        <String label="ResidentId" v-model="value.residentId" :editMode="editMode"/>
        <String label="PhoneNumber" v-model="value.phoneNumber" :editMode="editMode"/>
        <String label="HighestEducation" v-model="value.highestEducation" :editMode="editMode"/>
        <String label="HighestEducationSchool" v-model="value.highestEducationSchool" :editMode="editMode"/>
        <String label="HighestEducationMajor" v-model="value.highestEducationMajor" :editMode="editMode"/>
        <Number label="PhysicalAllowanceRate" v-model="value.physicalAllowanceRate" :editMode="editMode"/>
        <Number label="CashAllowanceRate" v-model="value.cashAllowanceRate" :editMode="editMode"/>
        <Number label="Duration" v-model="value.duration" :editMode="editMode"/>
        <String label="Department" v-model="value.department" :editMode="editMode"/>
        <String label="ResearcherNumber" v-model="value.researcherNumber" :editMode="editMode"/>
        <Money offline label="MonthlySalary" v-model="value.monthlySalary" :editMode="editMode" @change="change"/>
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
    name: 'Researcher',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "researchers"
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>

